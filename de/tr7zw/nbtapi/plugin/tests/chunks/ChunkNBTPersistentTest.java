/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Chunk
 *  org.bukkit.World
 */
package de.tr7zw.nbtapi.plugin.tests.chunks;

import de.tr7zw.nbtapi.NBTChunk;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;

public class ChunkNBTPersistentTest
implements Test {
    @Override
    public void test() throws Exception {
        if (MinecraftVersion.getVersion().getVersionId() < MinecraftVersion.MC1_16_R3.getVersionId()) {
            return;
        }
        if (!Bukkit.getWorlds().isEmpty()) {
            World world = (World)Bukkit.getWorlds().get(0);
            try {
                if (world.getLoadedChunks().length > 1) {
                    Chunk chunk = world.getLoadedChunks()[0];
                    NBTChunk comp = new NBTChunk(chunk);
                    NBTCompound persistentData = comp.getPersistentDataContainer();
                    persistentData.removeKey("Foo");
                    if (persistentData.hasKey("Foo").booleanValue()) {
                        throw new NbtApiException("Unable to remove key from Chunk!");
                    }
                    persistentData.setString("Foo", "Bar");
                    if (!new NBTChunk(chunk).getPersistentDataContainer().getString("Foo").equals("Bar")) {
                        throw new NbtApiException("Custom Data did not save to the Chunk!");
                    }
                }
            } catch (Exception ex) {
                throw new NbtApiException("Wasn't able to use NBTChunks!", ex);
            }
        }
    }
}

