/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Event
 *  org.bukkit.event.HandlerList
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Deprecated
public class PlayerRangeStateChangeEvent
extends Event {
    private static final HandlerList handlers = new HandlerList();
    private SongPlayer song;
    private Player player;
    private boolean state;

    public PlayerRangeStateChangeEvent(SongPlayer song, Player player, boolean state) {
        this.song = song;
        this.player = player;
        this.state = state;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public SongPlayer getSongPlayer() {
        return this.song;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean isInRange() {
        return this.state;
    }
}

