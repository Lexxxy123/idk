/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Event
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.CompatibilityUtils;
import com.xxmicloxx.NoteBlockAPI.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.Layer;
import com.xxmicloxx.NoteBlockAPI.Note;
import com.xxmicloxx.NoteBlockAPI.NoteBlockAPI;
import com.xxmicloxx.NoteBlockAPI.NotePitch;
import com.xxmicloxx.NoteBlockAPI.PlayerRangeStateChangeEvent;
import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.utils.InstrumentUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

@Deprecated
public class PositionSongPlayer
extends SongPlayer {
    private Location targetLocation;
    private int distance = 16;

    public PositionSongPlayer(Song song) {
        super(song);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.songplayer.PositionSongPlayer.class);
    }

    public PositionSongPlayer(Song song, SoundCategory soundCategory) {
        super(song, soundCategory);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.songplayer.PositionSongPlayer.class);
    }

    public PositionSongPlayer(com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer songPlayer) {
        super(songPlayer);
    }

    @Override
    void update(String key, Object value) {
        super.update(key, value);
        switch (key) {
            case "distance": {
                this.distance = (Integer)value;
                break;
            }
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
            float volume = (float)(layer.getVolume() * this.volume * playerVolume) / 1000000.0f * (0.0625f * (float)this.getDistance());
            float pitch = NotePitch.getPitch(note.getKey() - 33);
            if (InstrumentUtils.isCustomInstrument(note.getInstrument())) {
                CustomInstrument instrument = this.song.getCustomInstruments()[note.getInstrument() - InstrumentUtils.getCustomInstrumentFirstIndex()];
                if (instrument.getSound() != null) {
                    CompatibilityUtils.playSound(player, this.targetLocation, instrument.getSound(), this.soundCategory, volume, pitch);
                } else {
                    CompatibilityUtils.playSound(player, this.targetLocation, instrument.getSoundfile(), this.soundCategory, volume, pitch);
                }
            } else {
                CompatibilityUtils.playSound(player, this.targetLocation, InstrumentUtils.getInstrument(note.getInstrument()), this.soundCategory, volume, pitch);
            }
            if (this.isPlayerInRange(player)) {
                if (((Boolean)this.playerList.get(player.getName())).booleanValue()) continue;
                this.playerList.put(player.getName(), true);
                Bukkit.getPluginManager().callEvent((Event)new PlayerRangeStateChangeEvent(this, player, true));
                continue;
            }
            if (!((Boolean)this.playerList.get(player.getName())).booleanValue()) continue;
            this.playerList.put(player.getName(), false);
            Bukkit.getPluginManager().callEvent((Event)new PlayerRangeStateChangeEvent(this, player, false));
        }
    }

    public void setDistance(int distance) {
        this.distance = distance;
        this.CallUpdate("distance", distance);
    }

    public int getDistance() {
        return this.distance;
    }

    @Deprecated
    public boolean isPlayerInRange(Player player) {
        return player.getLocation().distance(this.targetLocation) <= (double)this.getDistance();
    }
}

