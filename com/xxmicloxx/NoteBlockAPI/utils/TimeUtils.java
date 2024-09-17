/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.utils;

import com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer;

public class TimeUtils {
    public static String getActualTime(String format, SongPlayer songPlayer) {
        return TimeUtils.getTime(format, songPlayer.getTick(), songPlayer.getSong().getSpeed());
    }

    public static String getLength(String format, SongPlayer songPlayer) {
        return TimeUtils.getTime(format, songPlayer.getSong().getLength(), songPlayer.getSong().getSpeed());
    }

    private static String getTime(String format, short ticks, float speed) {
        String time = format;
        long milisTotal = (long)((float)ticks / speed * 1000.0f);
        int hours = 0;
        if (time.contains("h")) {
            hours = (int)Math.floor(milisTotal / 1000L / 60L / 60L);
            milisTotal -= (long)(hours * 1000 * 60 * 60);
        }
        int minutes = 0;
        if (time.contains("m")) {
            minutes = (int)Math.floor(milisTotal / 1000L / 60L);
            milisTotal -= (long)(minutes * 1000 * 60);
        }
        int seconds = 0;
        if (time.contains("s")) {
            seconds = (int)Math.floor(milisTotal / 1000L);
            milisTotal -= (long)(seconds * 1000);
        }
        time = time.replace("hh", String.format("%02", hours));
        time = time.replace("h", hours + "");
        time = time.replace("mm", String.format("%02", minutes));
        time = time.replace("m", minutes + "");
        time = time.replace("ss", String.format("%02", seconds));
        time = time.replace("s", seconds + "");
        time = time.replace("n", milisTotal + "");
        return time;
    }
}

