/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.util.Vector
 */
package de.tr7zw.nbtapi.data;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTFile;
import de.tr7zw.nbtapi.NbtApiException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.bukkit.util.Vector;

public class WorldData {
    private final NBTFile file;

    protected WorldData(File worldFolder) throws IOException {
        if (!new File(worldFolder, "level.dat").exists()) {
            throw new FileNotFoundException("Level.dat at: " + new File(worldFolder, "level.dat").getAbsolutePath());
        }
        this.file = new NBTFile(new File(worldFolder, "level.dat"));
    }

    public NBTFile getFile() {
        return this.file;
    }

    public NBTCompound getCompound() {
        return this.file;
    }

    public void saveChanges() {
        try {
            this.file.save();
        } catch (IOException e2) {
            throw new NbtApiException("Error when saving level data!", e2);
        }
    }

    public String getWorldName() {
        return this.file.getCompound("Data").getString("LevelName");
    }

    public void setWorldName(String name) {
        this.file.getCompound("Data").setString("LevelName", name);
    }

    public Vector getSpawnPosition() {
        NBTCompound data = this.file.getCompound("Data");
        return new Vector(data.getInteger("SpawnX").intValue(), data.getInteger("SpawnY").intValue(), data.getInteger("SpawnZ").intValue());
    }

    public void setSpawnPosition(Vector vec) {
        NBTCompound data = this.file.getCompound("Data");
        data.setInteger("SpawnX", vec.getBlockX());
        data.setInteger("SpawnY", vec.getBlockY());
        data.setInteger("SpawnZ", vec.getBlockZ());
    }
}

