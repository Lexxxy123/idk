/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Event
 */
package com.xxmicloxx.NoteBlockAPI.songplayer;

import com.xxmicloxx.NoteBlockAPI.NoteBlockAPI;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.event.PlayerRangeStateChangeEvent;
import com.xxmicloxx.NoteBlockAPI.model.Layer;
import com.xxmicloxx.NoteBlockAPI.model.Note;
import com.xxmicloxx.NoteBlockAPI.model.Playlist;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.songplayer.RangeSongPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class PositionSongPlayer
extends RangeSongPlayer {
    private Location targetLocation;

    public PositionSongPlayer(Song song) {
        super(song);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.PositionSongPlayer.class);
    }

    public PositionSongPlayer(Song song, SoundCategory soundCategory) {
        super(song, soundCategory);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.PositionSongPlayer.class);
    }

    private PositionSongPlayer(SongPlayer songPlayer) {
        super(songPlayer);
    }

    public PositionSongPlayer(Playlist playlist, SoundCategory soundCategory) {
        super(playlist, soundCategory);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.PositionSongPlayer.class);
    }

    public PositionSongPlayer(Playlist playlist) {
        super(playlist);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.PositionSongPlayer.class);
    }

    @Override
    void update(String key, Object value) {
        super.update(key, value);
        switch (key) {
            case "targetLocation": {
                this.targetLocation = (Location)value;
            }
        }
    }

    public Location getTargetLocation() {
        return this.targetLocation;
    }

    public void setTargetLocation(Location targetLocation) {
        this.targetLocation = targetLocation;
        this.CallUpdate("targetLocation", targetLocation);
    }

    @Override
    public void playTick(Player player, int tick) {
        if (!player.getWorld().getName().equals(this.targetLocation.getWorld().getName())) {
            return;
        }
        byte playerVolume = NoteBlockAPI.getPlayerVolume(player);
        for (Layer layer : this.song.getLayerHashMap().values()) {
            Note note = layer.getNote(tick);
            if (note == null) continue;
            float volume = (float)(layer.getVolume() * this.volume * playerVolume * note.getVelocity()) / 1.0E8f * (0.0625f * (float)this.getDistance());
            this.channelMode.play(player, this.targetLocation, this.song, layer, note, this.soundCategory, volume, !this.enable10Octave);
            if (this.isInRange(player)) {
                if (((Boolean)this.playerList.get(player.getUniqueId())).booleanValue()) continue;
                this.playerList.put(player.getUniqueId(), true);
                Bukkit.getPluginManager().callEvent((Event)new PlayerRangeStateChangeEvent(this, player, true));
                continue;
            }
            if (!((Boolean)this.playerList.get(player.getUniqueId())).booleanValue()) continue;
            this.playerList.put(player.getUniqueId(), false);
            Bukkit.getPluginManager().callEvent((Event)new PlayerRangeStateChangeEvent(this, player, false));
        }
    }

    @Override
    public boolean isInRange(Player player) {
        return player.getLocation().distance(this.targetLocation) <= (double)this.getDistance();
    }
}

