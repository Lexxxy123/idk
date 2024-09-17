/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Sound
 */
package com.xxmicloxx.NoteBlockAPI.model;

import java.util.HashMap;
import java.util.Map;

public enum Sound {
    NOTE_PIANO("NOTE_PIANO", "BLOCK_NOTE_HARP", "BLOCK_NOTE_BLOCK_HARP"),
    NOTE_BASS("NOTE_BASS", "BLOCK_NOTE_BASS", "BLOCK_NOTE_BLOCK_BASS"),
    NOTE_BASS_DRUM("NOTE_BASS_DRUM", "BLOCK_NOTE_BASEDRUM", "BLOCK_NOTE_BLOCK_BASEDRUM"),
    NOTE_SNARE_DRUM("NOTE_SNARE_DRUM", "BLOCK_NOTE_SNARE", "BLOCK_NOTE_BLOCK_SNARE"),
    NOTE_STICKS("NOTE_STICKS", "BLOCK_NOTE_HAT", "BLOCK_NOTE_BLOCK_HAT"),
    NOTE_BASS_GUITAR("NOTE_BASS_GUITAR", "BLOCK_NOTE_GUITAR", "BLOCK_NOTE_BLOCK_GUITAR"),
    NOTE_FLUTE("NOTE_FLUTE", "BLOCK_NOTE_FLUTE", "BLOCK_NOTE_BLOCK_FLUTE"),
    NOTE_BELL("NOTE_BELL", "BLOCK_NOTE_BELL", "BLOCK_NOTE_BLOCK_BELL"),
    NOTE_CHIME("NOTE_CHIME", "BLOCK_NOTE_CHIME", "BLOCK_NOTE_BLOCK_CHIME"),
    NOTE_XYLOPHONE("NOTE_XYLOPHONE", "BLOCK_NOTE_XYLOPHONE", "BLOCK_NOTE_BLOCK_XYLOPHONE"),
    NOTE_PLING("NOTE_PLING", "BLOCK_NOTE_PLING", "BLOCK_NOTE_BLOCK_PLING"),
    NOTE_IRON_XYLOPHONE("BLOCK_NOTE_BLOCK_IRON_XYLOPHONE"),
    NOTE_COW_BELL("BLOCK_NOTE_BLOCK_COW_BELL"),
    NOTE_DIDGERIDOO("BLOCK_NOTE_BLOCK_DIDGERIDOO"),
    NOTE_BIT("BLOCK_NOTE_BLOCK_BIT"),
    NOTE_BANJO("BLOCK_NOTE_BLOCK_BANJO");

    private String[] versionDependentNames;
    private org.bukkit.Sound cached = null;
    private static Map<String, org.bukkit.Sound> cachedSoundMap;

    private Sound(String ... versionDependentNames) {
        this.versionDependentNames = versionDependentNames;
    }

    public static org.bukkit.Sound getFromBukkitName(String bukkitSoundName) {
        org.bukkit.Sound sound = cachedSoundMap.get(bukkitSoundName.toUpperCase());
        if (sound != null) {
            return sound;
        }
        return org.bukkit.Sound.valueOf((String)bukkitSoundName);
    }

    private org.bukkit.Sound getSound() {
        if (this.cached != null) {
            return this.cached;
        }
        for (String name : this.versionDependentNames) {
            try {
                this.cached = org.bukkit.Sound.valueOf((String)name);
                return this.cached;
            } catch (IllegalArgumentException illegalArgumentException) {
            }
        }
        return null;
    }

    public org.bukkit.Sound bukkitSound() {
        if (this.getSound() != null) {
            return this.getSound();
        }
        throw new IllegalArgumentException("Found no valid sound name for " + this.name());
    }

    static {
        cachedSoundMap = new HashMap<String, org.bukkit.Sound>();
        for (Sound sound : Sound.values()) {
            for (String soundName : sound.versionDependentNames) {
                cachedSoundMap.put(soundName.toUpperCase(), sound.getSound());
            }
        }
    }
}

