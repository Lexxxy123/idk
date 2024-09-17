/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package com.xxmicloxx.NoteBlockAPI.songplayer;

import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.model.Playlist;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import org.bukkit.entity.Player;

public abstract class RangeSongPlayer
extends com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer {
    private int distance = 16;

    public RangeSongPlayer(Song song, SoundCategory soundCategory) {
        super(song, soundCategory);
    }

    public RangeSongPlayer(Song song) {
        super(song);
    }

    protected RangeSongPlayer(SongPlayer songPlayer) {
        super(songPlayer);
    }

    public RangeSongPlayer(Playlist playlist, SoundCategory soundCategory) {
        super(playlist, soundCategory);
    }

    public RangeSongPlayer(Playlist playlist) {
        super(playlist);
    }

    @Override
    void update(String key, Object value) {
        super.update(key, value);
        switch (key) {
            case "distance": {
                this.distance = (Integer)value;
            }
        }
    }

    public void setDistance(int distance) {
        this.distance = distance;
        this.CallUpdate("distance", distance);
    }

    public int getDistance() {
        return this.distance;
    }

    public abstract boolean isInRange(Player var1);
}

