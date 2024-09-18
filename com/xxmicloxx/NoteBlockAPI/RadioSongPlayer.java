/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.CompatibilityUtils;
import com.xxmicloxx.NoteBlockAPI.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.Layer;
import com.xxmicloxx.NoteBlockAPI.Note;
import com.xxmicloxx.NoteBlockAPI.NoteBlockAPI;
import com.xxmicloxx.NoteBlockAPI.NotePitch;
import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.utils.InstrumentUtils;
import org.bukkit.entity.Player;

@Deprecated
public class RadioSongPlayer
extends SongPlayer {
    public RadioSongPlayer(Song song) {
        super(song);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer.class);
    }

    public RadioSongPlayer(Song song, SoundCategory soundCategory) {
        super(song, soundCategory);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer.class);
    }

    public RadioSongPlayer(com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer songPlayer) {
        super(songPlayer);
    }

    @Override
    public void playTick(Player player, int tick) {
        byte playerVolume = NoteBlockAPI.getPlayerVolume(player);
        for (Layer layer : this.song.getLayerHashMap().values()) {
            Note note = layer.getNote(tick);
            if (note == null) continue;
            float volume = (float)(layer.getVolume() * this.volume * playerVolume) / 1000000.0f;
            float pitch = NotePitch.getPitch(note.getKey() - 33);
            if (InstrumentUtils.isCustomInstrument(note.getInstrument())) {
                CustomInstrument instrument = this.song.getCustomInstruments()[note.getInstrument() - InstrumentUtils.getCustomInstrumentFirstIndex()];
                if (instrument.getSound() != null) {
                    CompatibilityUtils.playSound(player, player.getEyeLocation(), instrument.getSound(), this.soundCategory, volume, pitch);
                    continue;
                }
                CompatibilityUtils.playSound(player, player.getEyeLocation(), instrument.getSoundfile(), this.soundCategory, volume, pitch);
                continue;
            }
            CompatibilityUtils.playSound(player, player.getEyeLocation(), InstrumentUtils.getInstrument(note.getInstrument()), this.soundCategory, volume, pitch);
        }
    }
}

