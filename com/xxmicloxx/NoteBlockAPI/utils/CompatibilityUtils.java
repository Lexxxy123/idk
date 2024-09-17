/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 */
package com.xxmicloxx.NoteBlockAPI.utils;

import com.xxmicloxx.NoteBlockAPI.model.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.utils.MathUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class CompatibilityUtils {
    public static final String OBC_DIR = Bukkit.getServer().getClass().getPackage().getName();
    public static final String NMS_DIR = OBC_DIR.replaceFirst("org.bukkit.craftbukkit", "net.minecraft.server");
    private static Class<? extends Enum> soundCategoryClass;
    private static HashMap<String, Method> playSoundMethod;
    private static float serverVersion;

    public static Class<?> getMinecraftClass(String name) {
        try {
            return Class.forName(NMS_DIR + "." + name);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Class<?> getCraftBukkitClass(String name) {
        try {
            return Class.forName(OBC_DIR + "." + name);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Class<? extends Enum> getSoundCategoryClass() throws ClassNotFoundException {
        if (CompatibilityUtils.isSoundCategoryCompatible() && soundCategoryClass == null) {
            soundCategoryClass = Class.forName("org.bukkit.SoundCategory");
        }
        return soundCategoryClass;
    }

    private static Method getPlaySoundMethod(Class sound, boolean soundcategory) throws ClassNotFoundException, NoSuchMethodException {
        Method method = playSoundMethod.get(sound.getName() + soundcategory);
        if (method == null) {
            method = soundcategory ? Player.class.getMethod("playSound", Location.class, sound, CompatibilityUtils.getSoundCategoryClass(), Float.TYPE, Float.TYPE) : Player.class.getMethod("playSound", Location.class, sound, Float.TYPE, Float.TYPE);
            playSoundMethod.put(sound.getName() + soundcategory, method);
        }
        return method;
    }

    public static boolean isPost1_12() {
        return CompatibilityUtils.getServerVersion() >= 0.0112f;
    }

    protected static boolean isSoundCategoryCompatible() {
        return CompatibilityUtils.getServerVersion() >= 0.0111f;
    }

    public static void playSound(Player player, Location location, String sound, SoundCategory category, float volume, float pitch) {
        CompatibilityUtils.playSound(player, location, sound, category, volume, pitch, 0.0f);
    }

    public static void playSound(Player player, Location location, String sound, SoundCategory category, float volume, float pitch, boolean stereo) {
        CompatibilityUtils.playSound(player, location, sound, category, volume, pitch, stereo ? 2.0f : 0.0f);
    }

    public static void playSound(Player player, Location location, Sound sound, SoundCategory category, float volume, float pitch) {
        CompatibilityUtils.playSound(player, location, sound, category, volume, pitch, 0.0f);
    }

    public static void playSound(Player player, Location location, Sound sound, SoundCategory category, float volume, float pitch, boolean stereo) {
        CompatibilityUtils.playSound(player, location, sound, category, volume, pitch, stereo ? 2.0f : 0.0f);
    }

    public static void playSound(Player player, Location location, String sound, SoundCategory category, float volume, float pitch, float distance) {
        CompatibilityUtils.playSoundUniversal(player, location, sound, category, volume, pitch, distance);
    }

    public static void playSound(Player player, Location location, Sound sound, SoundCategory category, float volume, float pitch, float distance) {
        CompatibilityUtils.playSoundUniversal(player, location, sound, category, volume, pitch, distance);
    }

    private static void playSoundUniversal(Player player, Location location, Object sound, SoundCategory category, float volume, float pitch, float distance) {
        try {
            if (CompatibilityUtils.isSoundCategoryCompatible()) {
                Method method = CompatibilityUtils.getPlaySoundMethod(sound.getClass(), true);
                Enum soundCategoryEnum = Enum.valueOf(CompatibilityUtils.getSoundCategoryClass(), category.name());
                method.invoke(player, MathUtils.stereoPan(location, distance), sound, soundCategoryEnum, Float.valueOf(volume), Float.valueOf(pitch));
            } else {
                Method method = CompatibilityUtils.getPlaySoundMethod(sound.getClass(), false);
                method.invoke(player, MathUtils.stereoPan(location, distance), sound, Float.valueOf(volume), Float.valueOf(pitch));
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<CustomInstrument> get1_12Instruments() {
        return CompatibilityUtils.getVersionCustomInstruments(0.0112f);
    }

    public static ArrayList<CustomInstrument> getVersionCustomInstruments(float serverVersion) {
        ArrayList<CustomInstrument> instruments = new ArrayList<CustomInstrument>();
        if (serverVersion == 0.0112f) {
            instruments.add(new CustomInstrument(0, "Guitar", "block.note_block.guitar.ogg"));
            instruments.add(new CustomInstrument(0, "Flute", "block.note_block.flute.ogg"));
            instruments.add(new CustomInstrument(0, "Bell", "block.note_block.bell.ogg"));
            instruments.add(new CustomInstrument(0, "Chime", "block.note_block.icechime.ogg"));
            instruments.add(new CustomInstrument(0, "Xylophone", "block.note_block.xylobone.ogg"));
            return instruments;
        }
        if (serverVersion == 0.0114f) {
            instruments.add(new CustomInstrument(0, "Iron Xylophone", "block.note_block.iron_xylophone.ogg"));
            instruments.add(new CustomInstrument(0, "Cow Bell", "block.note_block.cow_bell.ogg"));
            instruments.add(new CustomInstrument(0, "Didgeridoo", "block.note_block.didgeridoo.ogg"));
            instruments.add(new CustomInstrument(0, "Bit", "block.note_block.bit.ogg"));
            instruments.add(new CustomInstrument(0, "Banjo", "block.note_block.banjo.ogg"));
            instruments.add(new CustomInstrument(0, "Pling", "block.note_block.pling.ogg"));
            return instruments;
        }
        return instruments;
    }

    public static ArrayList<CustomInstrument> getVersionCustomInstrumentsForSong(int firstCustomInstrumentIndex) {
        ArrayList<CustomInstrument> instruments = new ArrayList<CustomInstrument>();
        if (CompatibilityUtils.getServerVersion() < 0.0112f) {
            if (firstCustomInstrumentIndex == 10) {
                instruments.addAll(CompatibilityUtils.getVersionCustomInstruments(0.0112f));
            } else if (firstCustomInstrumentIndex == 16) {
                instruments.addAll(CompatibilityUtils.getVersionCustomInstruments(0.0112f));
                instruments.addAll(CompatibilityUtils.getVersionCustomInstruments(0.0114f));
            }
        } else if (CompatibilityUtils.getServerVersion() < 0.0114f && firstCustomInstrumentIndex == 16) {
            instruments.addAll(CompatibilityUtils.getVersionCustomInstruments(0.0114f));
        }
        return instruments;
    }

    public static float getServerVersion() {
        if (serverVersion != -1.0f) {
            return serverVersion;
        }
        String versionInfo = Bukkit.getServer().getVersion();
        int start = versionInfo.lastIndexOf(40);
        int end = versionInfo.lastIndexOf(41);
        String[] versionParts = versionInfo.substring(start + 5, end).split("\\.");
        String versionString = "0.";
        for (String part : versionParts) {
            if (part.length() == 1) {
                versionString = versionString + "0";
            }
            versionString = versionString + part;
        }
        serverVersion = Float.parseFloat(versionString);
        return serverVersion;
    }

    static {
        playSoundMethod = new HashMap();
        serverVersion = -1.0f;
    }
}

