/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Item
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitTask
 */
package de.slikey.effectlib.entity;

import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.util.RandomUtils;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public final class EntityManager {
    private final EffectLib effectLib;
    private final Map<Entity, BukkitTask> entities;
    private boolean disposed = false;

    public EntityManager(EffectLib effectLib) {
        this.effectLib = effectLib;
        this.entities = new HashMap<Entity, BukkitTask>();
    }

    public void removeAll() {
        for (Map.Entry<Entity, BukkitTask> entry : this.entities.entrySet()) {
            entry.getKey().remove();
            entry.getValue().cancel();
        }
        this.entities.clear();
    }

    public void remove(Entity entity) {
        this.entities.get(entity).cancel();
        this.entities.remove(entity);
        entity.remove();
    }

    public void add(final Entity entity, int duration) {
        if (this.disposed) {
            throw new IllegalStateException("EffectManager is disposed and not able to accept any effects.");
        }
        BukkitTask task = Bukkit.getScheduler().runTaskLater((Plugin)this.effectLib, new Runnable(){

            @Override
            public void run() {
                EntityManager.this.remove(entity);
            }
        }, (long)duration);
        this.entities.put(entity, task);
    }

    public Item spawnItem(ItemStack is, Location loc, int duration) {
        ItemMeta im = is.getItemMeta();
        im.setDisplayName("EffectItem" + ChatColor.RED + RandomUtils.random.nextInt(10000));
        is.setItemMeta(im);
        Item i2 = loc.getWorld().dropItem(loc, is);
        i2.setMetadata("EffectItem", (MetadataValue)new FixedMetadataValue((Plugin)EffectLib.instance(), (Object)0));
        this.add((Entity)i2, duration);
        return i2;
    }

    public Entity spawnEntity(EntityType type, Location loc, int duration) {
        Entity e2 = loc.getWorld().spawnEntity(loc, type);
        e2.setMetadata("EffectItem", (MetadataValue)new FixedMetadataValue((Plugin)EffectLib.instance(), (Object)0));
        this.add(e2, duration);
        return e2;
    }

    public void dispose() {
        this.disposed = true;
        this.removeAll();
    }
}

