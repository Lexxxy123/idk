/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Server
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.ReflectionTPS;

public class SkyServer {
    private Server server;

    public SkyServer(Server s2) {
        this.server = s2;
    }

    public Collection<? extends Player> getPlayersOnline() {
        return Bukkit.getOnlinePlayers();
    }

    public List<User> getUsers() {
        ArrayList<User> user = new ArrayList<User>();
        for (Player player : this.getPlayersOnline()) {
            user.add(User.getUser(player.getUniqueId()));
        }
        return user;
    }

    public double getTPS() {
        return ReflectionTPS.getTPS();
    }

    public void getPacketListener() {
    }
}

