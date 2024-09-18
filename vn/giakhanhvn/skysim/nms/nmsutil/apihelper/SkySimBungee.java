/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package vn.giakhanhvn.skysim.nms.nmsutil.apihelper;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.util.SLog;

public class SkySimBungee {
    private String channel;
    private List<String> servers = new ArrayList<String>();

    public SkySimBungee(String channel) {
        this.channel = channel;
    }

    public static SkySimBungee getNewBungee() {
        return new SkySimBungee("BungeeCord");
    }

    public void sendData(Player p2, String subchannel, String args) {
        Player sender = null;
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(subchannel);
        if (args != null) {
            out.writeUTF(args);
        }
        if ((sender = p2 == null ? (Player)Iterables.getFirst(Bukkit.getOnlinePlayers(), null) : p2) != null) {
            sender.sendPluginMessage((Plugin)SkySimEngine.getPlugin(), this.channel, out.toByteArray());
        } else {
            SLog.warn("Player object mustn't be null!");
        }
    }
}

