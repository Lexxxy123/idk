/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.event.Event
 *  org.bukkit.event.HandlerList
 */
package vn.giakhanhvn.skysim.nms.packetevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import vn.giakhanhvn.skysim.nms.packetevents.WrappedPluginMessage;

public class PluginMessageReceived
extends Event {
    private static final HandlerList handlers = new HandlerList();
    private WrappedPluginMessage a;

    public PluginMessageReceived(WrappedPluginMessage b2) {
        this.a = b2;
    }

    public WrappedPluginMessage getWrappedPluginMessage() {
        return this.a;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}

