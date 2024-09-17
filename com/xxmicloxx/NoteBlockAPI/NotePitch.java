/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 */
package com.xxmicloxx.NoteBlockAPI;

import org.bukkit.Bukkit;

@Deprecated
public enum NotePitch {
    NOTE_0(0, 0.5f, 0.5f),
    NOTE_1(1, 0.53f, 0.52973f),
    NOTE_2(2, 0.56f, 0.56123f),
    NOTE_3(3, 0.6f, 0.59461f),
    NOTE_4(4, 0.63f, 0.62995f),
    NOTE_5(5, 0.67f, 0.66741f),
    NOTE_6(6, 0.7f, 0.70711f),
    NOTE_7(7, 0.76f, 0.74916f),
    NOTE_8(8, 0.8f, 0.7937f),
    NOTE_9(9, 0.84f, 0.84089f),
    NOTE_10(10, 0.9f, 0.89091f),
    NOTE_11(11, 0.94f, 0.94386f),
    NOTE_12(12, 1.0f, 1.0f),
    NOTE_13(13, 1.06f, 1.05945f),
    NOTE_14(14, 1.12f, 1.12245f),
    NOTE_15(15, 1.18f, 1.1892f),
    NOTE_16(16, 1.26f, 1.25993f),
    NOTE_17(17, 1.34f, 1.33484f),
    NOTE_18(18, 1.42f, 1.4142f),
    NOTE_19(19, 1.5f, 1.49832f),
    NOTE_20(20, 1.6f, 1.58741f),
    NOTE_21(21, 1.68f, 1.6818f),
    NOTE_22(22, 1.78f, 1.7818f),
    NOTE_23(23, 1.88f, 1.88775f),
    NOTE_24(24, 2.0f, 2.0f);

    public int note;
    public float pitchPre1_9;
    public float pitchPost1_9;

    private NotePitch(int note, float pitchPre1_9, float pitchPost1_9) {
        this.note = note;
        this.pitchPre1_9 = pitchPre1_9;
        this.pitchPost1_9 = pitchPost1_9;
    }

    public static float getPitch(int note) {
        boolean pre1_9 = Bukkit.getVersion().contains("1.8") || Bukkit.getVersion().contains("1.7");
        for (NotePitch notePitch : NotePitch.values()) {
            if (notePitch.note != note) continue;
            return pre1_9 ? notePitch.pitchPre1_9 : notePitch.pitchPost1_9;
        }
        return 0.0f;
    }
}

