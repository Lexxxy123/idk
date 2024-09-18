/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 */
package com.xxmicloxx.NoteBlockAPI.model.playmode;

import com.xxmicloxx.NoteBlockAPI.model.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.model.Layer;
import com.xxmicloxx.NoteBlockAPI.model.Note;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.model.playmode.ChannelMode;
import com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils;
import com.xxmicloxx.NoteBlockAPI.utils.InstrumentUtils;
import com.xxmicloxx.NoteBlockAPI.utils.NoteUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class StereoMode
extends ChannelMode {
    private float maxDistance = 2.0f;
    private ChannelMode fallbackChannelMode = null;

    @Override
    public void play(Player player, Location location, Song song, Layer layer, Note note, SoundCategory soundCategory, float volume, float pitch) {
        if (!song.isStereo() && this.fallbackChannelMode != null) {
            this.fallbackChannelMode.play(player, location, song, layer, note, soundCategory, volume, pitch);
            return;
        }
        float distance = 0.0f;
        distance = layer.getPanning() == 100 ? (float)(note.getPanning() - 100) * this.maxDistance : (float)(layer.getPanning() - 100 + note.getPanning() - 100) / 200.0f * this.maxDistance;
        if (InstrumentUtils.isCustomInstrument(note.getInstrument())) {
            CustomInstrument instrument = song.getCustomInstruments()[note.getInstrument() - InstrumentUtils.getCustomInstrumentFirstIndex()];
            if (instrument.getSound() != null) {
                CompatibilityUtils.playSound(player, location, instrument.getSound(), soundCategory, volume, pitch, distance);
            } else {
                CompatibilityUtils.playSound(player, location, instrument.getSoundFileName(), soundCategory, volume, pitch, distance);
            }
        } else {
            CompatibilityUtils.playSound(player, location, InstrumentUtils.getInstrument(note.getInstrument()), soundCategory, volume, pitch, distance);
        }
    }

    @Override
    public void play(Player player, Location location, Song song, Layer layer, Note note, SoundCategory soundCategory, float volume, boolean doTranspose) {
        if (!song.isStereo() && this.fallbackChannelMode != null) {
            this.fallbackChannelMode.play(player, location, song, layer, note, soundCategory, volume, doTranspose);
            return;
        }
        float pitch = doTranspose ? NoteUtils.getPitchTransposed(note) : NoteUtils.getPitchInOctave(note);
        float distance = 0.0f;
        distance = layer.getPanning() == 100 ? (float)(note.getPanning() - 100) * this.maxDistance : (float)(layer.getPanning() - 100 + note.getPanning() - 100) / 200.0f * this.maxDistance;
        if (InstrumentUtils.isCustomInstrument(note.getInstrument())) {
            CustomInstrument instrument = song.getCustomInstruments()[note.getInstrument() - InstrumentUtils.getCustomInstrumentFirstIndex()];
            if (!doTranspose) {
                CompatibilityUtils.playSound(player, location, InstrumentUtils.warpNameOutOfRange(instrument.getSoundFileName(), note.getKey(), note.getPitch()), soundCategory, volume, pitch, distance);
            } else if (instrument.getSound() != null) {
                CompatibilityUtils.playSound(player, location, instrument.getSound(), soundCategory, volume, pitch, distance);
            } else {
                CompatibilityUtils.playSound(player, location, instrument.getSoundFileName(), soundCategory, volume, pitch, distance);
            }
        } else if (NoteUtils.isOutOfRange(note.getKey(), note.getPitch()) && !doTranspose) {
            CompatibilityUtils.playSound(player, location, InstrumentUtils.warpNameOutOfRange(note.getInstrument(), note.getKey(), note.getPitch()), soundCategory, volume, pitch, distance);
        } else {
            CompatibilityUtils.playSound(player, location, InstrumentUtils.getInstrument(note.getInstrument()), soundCategory, volume, pitch, distance);
        }
    }

    public float getMaxDistance() {
        return this.maxDistance;
    }

    public void setMaxDistance(float maxDistance) {
        this.maxDistance = maxDistance;
    }

    public ChannelMode getFallbackChannelMode() {
        return this.fallbackChannelMode;
    }

    public void setFallbackChannelMode(ChannelMode fallbackChannelMode) {
        if (fallbackChannelMode instanceof StereoMode) {
            throw new IllegalArgumentException("Fallback ChannelMode can't be instance of StereoMode!");
        }
        this.fallbackChannelMode = fallbackChannelMode;
    }
}

