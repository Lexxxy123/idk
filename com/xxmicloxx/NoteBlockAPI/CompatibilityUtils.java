/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

@Deprecated
public class CompatibilityUtils {
    public static final String OBC_DIR = Bukkit.getServer().getClass().getPackage().getName();
    public static final String NMS_DIR = OBC_DIR.replaceFirst("org.bukkit.craftbukkit", "net.minecraft.server");

    public static Class<?> getMinecraftClass(String name) {
        return com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils.getMinecraftClass(name);
    }

    public static Class<?> getCraftBukkitClass(String name) {
        return com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils.getCraftBukkitClass(name);
    }

    public static boolean isPost1_12() {
        return com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils.isPost1_12();
    }

    protected static boolean isSoundCategoryCompatible() {
        return com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils.getServerVersion() >= 0.0111f;
    }

    public static void playSound(Player player, Location location, String sound, com.xxmicloxx.NoteBlockAPI.SoundCategory category, float volume, float pitch) {
        com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils.playSound(player, location, sound, SoundCategory.valueOf(category.name()), volume, pitch);
    }

    public static void playSound(Player player, Location location, Sound sound, com.xxmicloxx.NoteBlockAPI.SoundCategory category, float volume, float pitch) {
        com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils.playSound(player, location, sound, SoundCategory.valueOf(category.name()), volume, pitch);
    }

    public static ArrayList<CustomInstrument> get1_12Instruments() {
        return CompatibilityUtils.getVersionCustomInstruments(0.0112f);
    }

    public static ArrayList<CustomInstrument> getVersionCustomInstruments(float serverVersion) {
        ArrayList<CustomInstrument> instruments = new ArrayList<CustomInstrument>();
        if (serverVersion == 0.0112f) {
            instruments.add(new CustomInstrument(0, "Guitar", "guitar.ogg"));
            instruments.add(new CustomInstrument(0, "Flute", "flute.ogg"));
            instruments.add(new CustomInstrument(0, "Bell", "bell.ogg"));
            instruments.add(new CustomInstrument(0, "Chime", "icechime.ogg"));
            instruments.add(new CustomInstrument(0, "Xylophone", "xylobone.ogg"));
            return instruments;
        }
        if (serverVersion == 0.0114f) {
            instruments.add(new CustomInstrument(0, "Iron Xylophone", "iron_xylophone.ogg"));
            instruments.add(new CustomInstrument(0, "Cow Bell", "cow_bell.ogg"));
            instruments.add(new CustomInstrument(0, "Didgeridoo", "didgeridoo.ogg"));
            instruments.add(new CustomInstrument(0, "Bit", "bit.ogg"));
            instruments.add(new CustomInstrument(0, "Banjo", "banjo.ogg"));
            instruments.add(new CustomInstrument(0, "Pling", "pling.ogg"));
            return instruments;
        }
        return instruments;
    }

    public static ArrayList<CustomInstrument> getVersionCustomInstrumentsForSong(int firstCustomInstrumentIndex) {
        ArrayList<CustomInstrument> instruments = new ArrayList<CustomInstrument>();
        if (com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils.getServerVersion() < 0.0112f) {
            if (firstCustomInstrumentIndex == 10) {
                instruments.addAll(CompatibilityUtils.getVersionCustomInstruments(0.0112f));
            } else if (firstCustomInstrumentIndex == 16) {
                instruments.addAll(CompatibilityUtils.getVersionCustomInstruments(0.0112f));
                instruments.addAll(CompatibilityUtils.getVersionCustomInstruments(0.0114f));
            }
        } else if (com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils.getServerVersion() < 0.0114f && firstCustomInstrumentIndex == 16) {
            instruments.addAll(CompatibilityUtils.getVersionCustomInstruments(0.0114f));
        }
        return instruments;
    }
}

