/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Instrument
 *  org.bukkit.Sound
 */
package com.xxmicloxx.NoteBlockAPI.utils;

import com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils;
import com.xxmicloxx.NoteBlockAPI.utils.NoteUtils;
import org.bukkit.Instrument;
import org.bukkit.Sound;

public class InstrumentUtils {
    public static Sound getInstrument(byte instrument) {
        return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName(InstrumentUtils.getInstrumentName(instrument));
    }

    public static String warpNameOutOfRange(byte instrument, byte key, short pitch) {
        return InstrumentUtils.warpNameOutOfRange(InstrumentUtils.getSoundNameByInstrument(instrument), key, pitch);
    }

    public static String warpNameOutOfRange(String name, byte key, short pitch) {
        if ((key = NoteUtils.applyPitchToKey(key, pitch)) < 9) {
            name = name + "_-2";
        } else if (key < 33) {
            name = name + "_-1";
        } else if (key >= 57) {
            if (key < 81) {
                name = name + "_1";
            } else if (key < 105) {
                name = name + "_2";
            }
        }
        return name;
    }

    public static String getSoundNameByInstrument(byte instrument) {
        switch (instrument) {
            case 0: {
                return "minecraft:block.note_block.harp";
            }
            case 1: {
                return "minecraft:block.note_block.bass";
            }
            case 2: {
                return "minecraft:block.note_block.basedrum";
            }
            case 3: {
                return "minecraft:block.note_block.snare";
            }
            case 4: {
                return "minecraft:block.note_block.hat";
            }
            case 5: {
                return "minecraft:block.note_block.guitar";
            }
            case 6: {
                return "minecraft:block.note_block.flute";
            }
            case 7: {
                return "minecraft:block.note_block.bell";
            }
            case 8: {
                return "minecraft:block.note_block.chime";
            }
            case 9: {
                return "minecraft:block.note_block.xylophone";
            }
            case 10: {
                return "minecraft:block.note_block.iron_xylophone";
            }
            case 11: {
                return "minecraft:block.note_block.cow_bell";
            }
            case 12: {
                return "minecraft:block.note_block.didgeridoo";
            }
            case 13: {
                return "minecraft:block.note_block.bit";
            }
            case 14: {
                return "minecraft:block.note_block.banjo";
            }
            case 15: {
                return "minecraft:block.note_block.pling";
            }
        }
        return "minecraft:block.note_block.harp";
    }

    public static String getInstrumentName(byte instrument) {
        switch (instrument) {
            case 0: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_HARP").name();
            }
            case 1: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_BASS").name();
            }
            case 2: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_BASEDRUM").name();
            }
            case 3: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_SNARE").name();
            }
            case 4: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_HAT").name();
            }
            case 5: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_GUITAR").name();
            }
            case 6: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_FLUTE").name();
            }
            case 7: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_BELL").name();
            }
            case 8: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_CHIME").name();
            }
            case 9: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_XYLOPHONE").name();
            }
            case 10: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_IRON_XYLOPHONE").name();
            }
            case 11: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_COW_BELL").name();
            }
            case 12: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_DIDGERIDOO").name();
            }
            case 13: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_BIT").name();
            }
            case 14: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_BANJO").name();
            }
            case 15: {
                return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_PLING").name();
            }
        }
        return com.xxmicloxx.NoteBlockAPI.model.Sound.getFromBukkitName("BLOCK_NOTE_BLOCK_HARP").name();
    }

    public static Instrument getBukkitInstrument(byte instrument) {
        switch (instrument) {
            case 0: {
                return Instrument.PIANO;
            }
            case 1: {
                return Instrument.BASS_GUITAR;
            }
            case 2: {
                return Instrument.BASS_DRUM;
            }
            case 3: {
                return Instrument.SNARE_DRUM;
            }
            case 4: {
                return Instrument.STICKS;
            }
        }
        if (CompatibilityUtils.getServerVersion() >= 0.0112f) {
            switch (instrument) {
                case 5: {
                    return Instrument.valueOf((String)"GUITAR");
                }
                case 6: {
                    return Instrument.valueOf((String)"FLUTE");
                }
                case 7: {
                    return Instrument.valueOf((String)"BELL");
                }
                case 8: {
                    return Instrument.valueOf((String)"CHIME");
                }
                case 9: {
                    return Instrument.valueOf((String)"XYLOPHONE");
                }
            }
            if (CompatibilityUtils.getServerVersion() >= 0.0114f) {
                switch (instrument) {
                    case 10: {
                        return Instrument.valueOf((String)"IRON_XYLOPHONE");
                    }
                    case 11: {
                        return Instrument.valueOf((String)"COW_BELL");
                    }
                    case 12: {
                        return Instrument.valueOf((String)"DIDGERIDOO");
                    }
                    case 13: {
                        return Instrument.valueOf((String)"BIT");
                    }
                    case 14: {
                        return Instrument.valueOf((String)"BANJO");
                    }
                    case 15: {
                        return Instrument.valueOf((String)"PLING");
                    }
                }
            }
            return Instrument.PIANO;
        }
        return Instrument.PIANO;
    }

    public static boolean isCustomInstrument(byte instrument) {
        return instrument >= InstrumentUtils.getCustomInstrumentFirstIndex();
    }

    public static byte getCustomInstrumentFirstIndex() {
        if (CompatibilityUtils.getServerVersion() >= 0.0114f) {
            return 16;
        }
        if (CompatibilityUtils.getServerVersion() >= 0.0112f) {
            return 10;
        }
        return 5;
    }
}

