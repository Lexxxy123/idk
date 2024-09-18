/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Material
 *  org.bukkit.World
 *  org.bukkit.block.Block
 */
package de.tr7zw.nbtapi.plugin.tests.tiles;

import de.tr7zw.nbtapi.NBTTileEntity;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class TileTest
implements Test {
    @Override
    public void test() throws Exception {
        if (!Bukkit.getWorlds().isEmpty()) {
            World world = (World)Bukkit.getWorlds().get(0);
            try {
                Block block = world.getBlockAt(world.getSpawnLocation().getBlockX(), 254, world.getSpawnLocation().getBlockZ());
                if (block.getType() == Material.AIR) {
                    block.setType(Material.CHEST);
                    NBTTileEntity tile = new NBTTileEntity(block.getState());
                    if (tile.getInteger("y") != 254) {
                        block.setType(Material.AIR);
                        throw new NbtApiException("The Tile Y pos wasn't correct!");
                    }
                    tile.setString("Lock", "test");
                    if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3) && !tile.hasKey("Lock").booleanValue() && !"test".equals(tile.getString("test"))) {
                        block.setType(Material.AIR);
                        throw new NbtApiException("The Lock wasn't successfully set.");
                    }
                    block.setType(Material.AIR);
                }
            } catch (Exception ex) {
                throw new NbtApiException("Wasn't able to use NBTTiles!", ex);
            }
        }
    }
}

