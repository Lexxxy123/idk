/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.World
 *  org.bukkit.entity.Animals
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Monster
 */
package de.tr7zw.nbtapi.plugin.tests.entities;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;

public class EntityCustomNbtPersistentTest
implements Test {
    @Override
    public void test() throws Exception {
        if (MinecraftVersion.getVersion().getVersionId() < MinecraftVersion.MC1_14_R1.getVersionId()) {
            return;
        }
        if (!Bukkit.getWorlds().isEmpty()) {
            World world = (World)Bukkit.getWorlds().get(0);
            try {
                if (!world.getEntitiesByClasses(new Class[]{Animals.class, Monster.class}).isEmpty()) {
                    Entity ent = (Entity)world.getEntitiesByClasses(new Class[]{Animals.class, Monster.class}).iterator().next();
                    NBTEntity nbtEnt = new NBTEntity(ent);
                    NBTCompound comp = nbtEnt.getPersistentDataContainer();
                    comp.setString("Hello", "World");
                    NBTEntity nbtent = new NBTEntity(ent);
                    if (!nbtent.toString().contains("Hello:\"World\"")) {
                        throw new NbtApiException("Custom Data did not save to the Entity!");
                    }
                    comp.removeKey("Hello");
                }
            } catch (Exception ex) {
                throw new NbtApiException("Wasn't able to use NBTEntities!", ex);
            }
        }
    }
}

