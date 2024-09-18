/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.nms.packetevents;

import org.bukkit.entity.Player;

public class WrappedPluginMessage {
    private String channelName;
    private Player player;
    private byte[] message;

    public WrappedPluginMessage(String cn, Player p2, byte[] msg) {
        this.channelName = cn;
        this.player = p2;
        this.message = msg;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public Player getPlayer() {
        return this.player;
    }

    public byte[] getMessage() {
        return this.message;
    }
}

