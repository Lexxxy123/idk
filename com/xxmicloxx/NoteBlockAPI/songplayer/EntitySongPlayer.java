/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Event
 */
package com.xxmicloxx.NoteBlockAPI.songplayer;

import com.xxmicloxx.NoteBlockAPI.NoteBlockAPI;
import com.xxmicloxx.NoteBlockAPI.event.PlayerRangeStateChangeEvent;
import com.xxmicloxx.NoteBlockAPI.model.Layer;
import com.xxmicloxx.NoteBlockAPI.model.Note;
import com.xxmicloxx.NoteBlockAPI.model.Playlist;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.songplayer.RangeSongPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EntitySongPlayer
extends RangeSongPlayer {
    private Entity entity;

    public EntitySongPlayer(Song song) {
        super(song);
    }

    public EntitySongPlayer(Song song, SoundCategory soundCategory) {
        super(song, soundCategory);
    }

    public EntitySongPlayer(Playlist playlist, SoundCategory soundCategory) {
        super(playlist, soundCategory);
    }

    public EntitySongPlayer(Playlist playlist) {
        super(playlist);
    }

    @Override
    public boolean isInRange(Player player) {
        return player.getLocation().distance(this.entity.getLocation()) <= (double)this.getDistance();
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return this.entity;
    }

    @Override
    public void playTick(Player player, int tick) {
        if (this.entity.isDead()) {
            if (this.autoDestroy) {
                this.destroy();
            } else {
                this.setPlaying(false);
            }
        }
        if (!player.getWorld().getName().equals(this.entity.getWorld().getName())) {
            return;
        }
        byte playerVolume = NoteBlockAPI.getPlayerVolume(player);
        for (Layer layer : this.song.getLayerHashMap().values()) {
            Note note = layer.getNote(tick);
            if (note == null) continue;
            float volume = (float)(layer.getVolume() * this.volume * playerVolume * note.getVelocity()) / 1.0E8f * (0.0625f * (float)this.getDistance());
            this.channelMode.play(player, this.entity.getLocation(), this.song, layer, note, this.soundCategory, volume, !this.enable10Octave);
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
}

