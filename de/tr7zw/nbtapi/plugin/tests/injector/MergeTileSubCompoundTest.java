/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Material
 *  org.bukkit.World
 *  org.bukkit.block.Block
 */
package de.tr7zw.nbtapi.plugin.tests.injector;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import de.tr7zw.nbtinjector.NBTInjector;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class MergeTileSubCompoundTest
implements Test {
    @Override
    public void test() throws Exception {
        if (!NBTInjector.isInjected()) {
            return;
        }
        if (!Bukkit.getWorlds().isEmpty()) {
            World world = (World)Bukkit.getWorlds().get(0);
            try {
                boolean failed = false;
                Block block = world.getBlockAt(world.getSpawnLocation().getBlockX(), 255, world.getSpawnLocation().getBlockZ());
                if (block.getType() == Material.AIR) {
                    block.setType(Material.CHEST);
                    NBTCompound comp = NBTInjector.getNbtData(block.getState());
                    comp.addCompound("subcomp").setString("hello", "world");
                    NBTContainer cont = new NBTContainer();
                    cont.mergeCompound(comp.getCompound("subcomp"));
                    if (!cont.hasKey("hello").booleanValue() || !"world".equals(cont.getString("hello"))) {
                        failed = true;
                    }
                    block.setType(Material.AIR);
                    if (failed) {
                        throw new NbtApiException("Data was not correct! " + cont);
                    }
                }
            } catch (Exception ex) {
                throw new NbtApiException("Wasn't able to use NBTTiles!", ex);
            }
        }
    }
}

