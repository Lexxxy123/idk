/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package com.xxmicloxx.NoteBlockAPI.songplayer;

import com.xxmicloxx.NoteBlockAPI.NoteBlockAPI;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.model.Layer;
import com.xxmicloxx.NoteBlockAPI.model.Note;
import com.xxmicloxx.NoteBlockAPI.model.Playlist;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.model.playmode.ChannelMode;
import com.xxmicloxx.NoteBlockAPI.model.playmode.MonoMode;
import com.xxmicloxx.NoteBlockAPI.model.playmode.MonoStereoMode;
import org.bukkit.entity.Player;

public class RadioSongPlayer
extends com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer {
    public RadioSongPlayer(Song song) {
        super(song);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.RadioSongPlayer.class);
    }

    public RadioSongPlayer(Song song, SoundCategory soundCategory) {
        super(song, soundCategory);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.RadioSongPlayer.class);
    }

    private RadioSongPlayer(SongPlayer songPlayer) {
        super(songPlayer);
    }

    public RadioSongPlayer(Playlist playlist, SoundCategory soundCategory) {
        super(playlist, soundCategory);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.RadioSongPlayer.class);
    }

    public RadioSongPlayer(Playlist playlist) {
        super(playlist);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.RadioSongPlayer.class);
    }

    @Override
    public void playTick(Player player, int tick) {
        byte playerVolume = NoteBlockAPI.getPlayerVolume(player);
        for (Layer layer : this.song.getLayerHashMap().values()) {
            Note note = layer.getNote(tick);
            if (note == null) continue;
            float volume = (float)(layer.getVolume() * this.volume * playerVolume * note.getVelocity()) / 1.0E8f;
            this.channelMode.play(player, player.getEyeLocation(), this.song, layer, note, this.soundCategory, volume, !this.enable10Octave);
        }
    }

    @Deprecated
    public boolean isStereo() {
        return !(this.channelMode instanceof MonoMode);
    }

    @Deprecated
    public void setStereo(boolean stereo) {
        this.channelMode = stereo ? new MonoMode() : new MonoStereoMode();
    }

    public void setChannelMode(ChannelMode mode) {
        this.channelMode = mode;
    }
}

