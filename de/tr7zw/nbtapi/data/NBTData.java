/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.World
 *  org.bukkit.plugin.Plugin
 */
package de.tr7zw.nbtapi.data;

import de.tr7zw.nbtapi.NBTFile;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.data.PlayerData;
import de.tr7zw.nbtapi.data.WorldData;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

public class NBTData {
    public static WorldData getWorldData(World world) {
        try {
            return new WorldData(world.getWorldFolder());
        } catch (IOException e2) {
            throw new NbtApiException("Error loading World Data!", e2);
        }
    }

    public static WorldData getWorldData(File worldFolder) {
        try {
            return new WorldData(worldFolder);
        } catch (IOException e2) {
            throw new NbtApiException("Error loading World Data!", e2);
        }
    }

    public static PlayerData getOfflinePlayerData(UUID uuid) {
        for (World world : Bukkit.getWorlds()) {
            File dataFolder = new File(world.getWorldFolder(), "playerdata");
            File playerFile = new File(dataFolder, uuid.toString() + ".dat");
            if (!playerFile.exists()) continue;
            try {
                return new PlayerData(playerFile);
            } catch (IOException e2) {
                throw new NbtApiException("Error loading player data!", e2);
            }
        }
        return null;
    }

    public static NBTFile getPluginPlayerData(Plugin plugin, UUID uuid) {
        try {
            File dataFolder = new File(plugin.getDataFolder(), "nbt-playerdata");
            dataFolder.mkdirs();
            return new NBTFile(new File(dataFolder, uuid.toString() + ".dat"));
        } catch (IOException e2) {
            throw new NbtApiException("Error getting Player Plugin data!", e2);
        }
    }

    public static NBTFile getPluginData(Plugin plugin) {
        try {
            plugin.getDataFolder().mkdirs();
            return new NBTFile(new File(plugin.getDataFolder(), "settings.dat"));
        } catch (IOException e2) {
            throw new NbtApiException("Error getting Plugin data!", e2);
        }
    }
}

