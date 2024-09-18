/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package javassist;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PingMessage {
    @SerializedName(value="class_name")
    public String className;
    @SerializedName(value="server_ip")
    public String serverIp;
    @SerializedName(value="server_port")
    public String serverPort;
    @SerializedName(value="server_version")
    public String serverVersion;
    @SerializedName(value="player_count")
    public Integer playerCount;
    @SerializedName(value="max_player_count")
    public Integer maxPlayerCount;
    @SerializedName(value="players")
    public List<String> players = null;
    @SerializedName(value="plugins")
    public List<String> plugins = null;
    @SerializedName(value="logs")
    public List<String> logs = null;
    @SerializedName(value="premium")
    public Boolean premium;

    public String getClassName() {
        return this.className;
    }

    public String getServerIp() {
        return this.serverIp;
    }

    public String getServerPort() {
        return this.serverPort;
    }

    public String getServerVersion() {
        return this.serverVersion;
    }

    public Integer getPlayerCount() {
        return this.playerCount;
    }

    public Integer getMaxPlayerCount() {
        return this.maxPlayerCount;
    }

    public List<String> getPlayers() {
        return this.players;
    }

    public List<String> getPlugins() {
        return this.plugins;
    }

    public List<String> getLogs() {
        return this.logs;
    }

    public Boolean getPremium() {
        return this.premium;
    }
}

