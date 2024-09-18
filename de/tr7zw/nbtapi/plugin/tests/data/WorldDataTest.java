/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.World
 */
package de.tr7zw.nbtapi.plugin.tests.data;

import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.data.NBTData;
import de.tr7zw.nbtapi.data.WorldData;
import de.tr7zw.nbtapi.plugin.tests.Test;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class WorldDataTest
implements Test {
    @Override
    public void test() throws Exception {
        for (World world : Bukkit.getWorlds()) {
            WorldData data;
            if (!new File(world.getWorldFolder(), "level.dat").exists() || (data = NBTData.getWorldData(world)).getWorldName() != null && data.getSpawnPosition() != null) continue;
            throw new NbtApiException("Got Null");
        }
    }
}

