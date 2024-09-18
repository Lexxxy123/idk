/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 */
package de.tr7zw.nbtapi.plugin.tests.injector;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import de.tr7zw.nbtinjector.NBTInjector;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class SpawnEntityCustomNbtInjectorTest
implements Test {
    @Override
    public void test() throws Exception {
        if (!NBTInjector.isInjected()) {
            return;
        }
        if (!Bukkit.getWorlds().isEmpty()) {
            World world = (World)Bukkit.getWorlds().get(0);
            try {
                Entity entity = world.spawnEntity(new Location(world, 0.0, 0.0, 0.0), EntityType.ARMOR_STAND);
                entity = NBTInjector.patchEntity(entity);
                NBTCompound comp = NBTInjector.getNbtData(entity);
                comp.setString("Hello", "World");
                NBTEntity nbtent = new NBTEntity(entity);
                if (!nbtent.toString().contains("__extraData:{Hello:\"World\"}")) {
                    throw new NbtApiException("Custom Data did not save to the Entity!");
                }
                comp.removeKey("Hello");
                entity.remove();
            } catch (Exception ex) {
                throw new NbtApiException("Wasn't able to use NBTEntities!", ex);
            }
        }
    }
}

