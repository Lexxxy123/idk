/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.server.ServerListPingEvent
 */
package vn.giakhanhvn.skysim.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;
import vn.giakhanhvn.skysim.listener.PListener;

public class ServerPingListener
extends PListener {
    @EventHandler
    public void onServerPing(ServerListPingEvent e2) {
        e2.setMotd(ChatColor.GOLD + "SkySim Version 0.7.0 BETA, Starting up...");
    }
}

