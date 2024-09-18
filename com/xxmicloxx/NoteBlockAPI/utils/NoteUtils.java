/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.utils;

import com.xxmicloxx.NoteBlockAPI.model.Note;

public class NoteUtils {
    private static float[] pitches = null;

    @Deprecated
    public static float getPitch(Note note) {
        return NoteUtils.getPitch(note.getKey(), note.getPitch());
    }

    @Deprecated
    public static float getPitch(byte key, short pitch) {
        return NoteUtils.getPitchTransposed(key, pitch);
    }

    public static float getPitchInOctave(Note note) {
        return NoteUtils.getPitchInOctave(note.getKey(), note.getPitch());
    }

    public static float getPitchInOctave(byte key, short pitch) {
        key = NoteUtils.applyPitchToKey(key, pitch);
        pitch = (short)(pitch % 100);
        if (key < 9) {
            key = (byte)(key + 15);
        } else if (key < 33) {
            key = (byte)(key - 9);
        } else if (key < 57) {
            key = (byte)(key - 33);
        } else if (key < 81) {
            key = (byte)(key - 57);
        } else if (key < 105) {
            key = (byte)(key - 81);
        }
        return pitches[key * 100 + pitch];
    }

    public static byte applyPitchToKey(byte key, short pitch) {
        key = (byte)(key + pitch / 100);
        return key;
    }

    public static float getPitchTransposed(Note note) {
        return NoteUtils.getPitchTransposed(note.getKey(), note.getPitch());
    }

    public static float getPitchTransposed(byte key, short pitch) {
        for (pitch = (short)(pitch + key * 100); pitch < 3300; pitch = (short)(pitch + 1200)) {
        }
        while (pitch > 5700) {
            pitch = (short)(pitch - 1200);
        }
        pitch = (short)(pitch - 3300);
        return pitches[pitch];
    }

    public static boolean isOutOfRange(byte key, short pitch) {
        if ((key = NoteUtils.applyPitchToKey(key, pitch)) < 33) {
            return true;
        }
        return key >= 57;
    }

    static {
        pitches = new float[2401];
        for (int i2 = 0; i2 < 2401; ++i2) {
            NoteUtils.pitches[i2] = (float)Math.pow(2.0, ((double)i2 - 1200.0) / 1200.0);
        }
    }
}

