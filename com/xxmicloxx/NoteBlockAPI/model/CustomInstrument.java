/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Sound
 */
package com.xxmicloxx.NoteBlockAPI.model;

import com.xxmicloxx.NoteBlockAPI.model.Sound;

public class CustomInstrument {
    private byte index;
    private String name;
    private String soundFileName;
    private org.bukkit.Sound sound;

    public CustomInstrument(byte index, String name, String soundFileName) {
        this.index = index;
        this.name = name;
        this.soundFileName = soundFileName.replaceAll(".ogg", "");
        if (this.soundFileName.equalsIgnoreCase("pling")) {
            this.sound = Sound.NOTE_PLING.bukkitSound();
        }
    }

    public byte getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public String getSoundFileName() {
        return this.soundFileName;
    }

    public org.bukkit.Sound getSound() {
        return this.sound;
    }
}

