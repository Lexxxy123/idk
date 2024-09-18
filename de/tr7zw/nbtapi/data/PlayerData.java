/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.data;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTFile;
import de.tr7zw.nbtapi.NbtApiException;
import java.io.File;
import java.io.IOException;

public class PlayerData {
    private final NBTFile file;

    protected PlayerData(File playerFile) throws IOException {
        this.file = new NBTFile(playerFile);
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

    public float getHealth() {
        return this.file.getFloat("Health").floatValue();
    }

    public void setHealth(float health) {
        this.file.setFloat("Health", Float.valueOf(health));
    }
}

