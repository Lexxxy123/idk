/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.util.CachedServerIcon
 */
package vn.giakhanhvn.skysim.nms.pingrep;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.util.CachedServerIcon;

public class PingReply {
    private Object ctx;
    private String motd;
    private int onlinePlayers;
    private int maxPlayers;
    private int protocolVersion;
    private String protocolName;
    private List<String> playerSample;
    private boolean hidePlayerSample = false;
    private CachedServerIcon icon = Bukkit.getServerIcon();

    public PingReply(Object ctx, String motd, int onlinePlayers, int maxPlayers, int protocolVersion, String protocolName, List<String> playerSample) {
        this.ctx = ctx;
        this.motd = motd;
        this.onlinePlayers = onlinePlayers;
        this.maxPlayers = maxPlayers;
        this.protocolVersion = protocolVersion;
        this.protocolName = protocolName;
        this.playerSample = playerSample;
    }

    public int getOnlinePlayers() {
        return this.onlinePlayers;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public String getMOTD() {
        return this.motd;
    }

    public int getProtocolVersion() {
        return this.protocolVersion;
    }

    public String getProtocolName() {
        return this.protocolName;
    }

    public List<String> getPlayerSample() {
        return this.playerSample;
    }

    public boolean isPlayerSampleHidden() {
        return this.hidePlayerSample;
    }

    public CachedServerIcon getIcon() {
        return this.icon;
    }

    public void setOnlinePlayers(int onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setMOTD(String motd) {
        this.motd = motd;
    }

    public void setProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public void setPlayerSample(List<String> playerSample) {
        this.playerSample = playerSample;
    }

    public void hidePlayerSample(boolean hidePlayerSample) {
        this.hidePlayerSample = hidePlayerSample;
    }

    public void setIcon(CachedServerIcon icon) {
        this.icon = icon;
    }
}

