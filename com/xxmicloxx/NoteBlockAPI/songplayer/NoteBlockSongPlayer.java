/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Note
 *  org.bukkit.block.Block
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
import com.xxmicloxx.NoteBlockAPI.utils.InstrumentUtils;
import com.xxmicloxx.NoteBlockAPI.utils.NoteUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class NoteBlockSongPlayer
extends RangeSongPlayer {
    private Block noteBlock;

    public NoteBlockSongPlayer(Song song) {
        super(song);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.NoteBlockSongPlayer.class);
    }

    public NoteBlockSongPlayer(Song song, SoundCategory soundCategory) {
        super(song, soundCategory);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.NoteBlockSongPlayer.class);
    }

    public NoteBlockSongPlayer(Playlist playlist, SoundCategory soundCategory) {
        super(playlist, soundCategory);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.NoteBlockSongPlayer.class);
    }

    public NoteBlockSongPlayer(Playlist playlist) {
        super(playlist);
        this.makeNewClone(com.xxmicloxx.NoteBlockAPI.NoteBlockSongPlayer.class);
    }

    private NoteBlockSongPlayer(SongPlayer songPlayer) {
        super(songPlayer);
    }

    @Override
    void update(String key, Object value) {
        super.update(key, value);
        switch (key) {
            case "noteBlock": {
                this.noteBlock = (Block)value;
            }
        }
    }

    public Block getNoteBlock() {
        return this.noteBlock;
    }

    public void setNoteBlock(Block noteBlock) {
        this.noteBlock = noteBlock;
        this.CallUpdate("noteBlock", noteBlock);
    }

    @Override
    public void playTick(Player player, int tick) {
        if (this.noteBlock.getType() != Material.NOTE_BLOCK) {
            return;
        }
        if (!player.getWorld().getName().equals(this.noteBlock.getWorld().getName())) {
            return;
        }
        byte playerVolume = NoteBlockAPI.getPlayerVolume(player);
        Location loc = this.noteBlock.getLocation();
        loc = new Location(loc.getWorld(), loc.getX() + 0.5, loc.getY() - 0.5, loc.getZ() + 0.5);
        for (Layer layer : this.song.getLayerHashMap().values()) {
            Note note = layer.getNote(tick);
            if (note == null) continue;
            player.playNote(loc, InstrumentUtils.getBukkitInstrument(note.getInstrument()), new org.bukkit.Note(note.getKey() - 33));
            float volume = (float)(layer.getVolume() * this.volume * playerVolume * note.getVelocity()) / 1.0E8f * (0.0625f * (float)this.getDistance());
            float pitch = NoteUtils.getPitch(note);
            this.channelMode.play(player, loc, this.song, layer, note, this.soundCategory, volume, !this.enable10Octave);
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
        Location loc = this.noteBlock.getLocation();
        loc = new Location(loc.getWorld(), loc.getX() + 0.5, loc.getY() - 0.5, loc.getZ() + 0.5);
        return !(player.getLocation().distance(loc) > (double)this.getDistance());
    }
}

