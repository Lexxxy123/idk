/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Instrument
 *  org.bukkit.Sound
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.utils.InstrumentUtils;
import org.bukkit.Sound;

@Deprecated
public class Instrument {
    public static Sound getInstrument(byte instrument) {
        return Sound.valueOf((String)Instrument.getInstrumentName(instrument));
    }

    public static String getInstrumentName(byte instrument) {
        return InstrumentUtils.getInstrumentName(instrument);
    }

    public static org.bukkit.Instrument getBukkitInstrument(byte instrument) {
        return InstrumentUtils.getBukkitInstrument(instrument);
    }

    public static boolean isCustomInstrument(byte instrument) {
        return InstrumentUtils.isCustomInstrument(instrument);
    }

    public static byte getCustomInstrumentFirstIndex() {
        return InstrumentUtils.getCustomInstrumentFirstIndex();
    }
}

