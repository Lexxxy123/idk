/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.event.Event
 *  org.bukkit.event.HandlerList
 */
package com.xxmicloxx.NoteBlockAPI.event;

import com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SongStoppedEvent
extends Event {
    private static final HandlerList handlers = new HandlerList();
    private SongPlayer songPlayer;

    public SongStoppedEvent(SongPlayer songPlayer) {
        this.songPlayer = songPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public SongPlayer getSongPlayer() {
        return this.songPlayer;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}

