/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.NoteBlockAPI;
import com.xxmicloxx.NoteBlockAPI.SongPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

@Deprecated
public class NoteBlockPlayerMain {
    public static NoteBlockPlayerMain plugin;
    public Map<String, ArrayList<SongPlayer>> playingSongs = Collections.synchronizedMap(new HashMap());
    public Map<String, Byte> playerVolume = Collections.synchronizedMap(new HashMap());
    private boolean disabling = false;

    public static boolean isReceivingSong(Player player) {
        return NoteBlockPlayerMain.plugin.playingSongs.get(player.getUniqueId()) != null && !NoteBlockPlayerMain.plugin.playingSongs.get(player.getUniqueId()).isEmpty();
    }

    public static void stopPlaying(Player player) {
        if (NoteBlockPlayerMain.plugin.playingSongs.get(player.getUniqueId()) == null) {
            return;
        }
        for (SongPlayer songPlayer : NoteBlockPlayerMain.plugin.playingSongs.get(player.getUniqueId())) {
            songPlayer.removePlayer(player);
        }
    }

    public static void setPlayerVolume(Player player, byte volume) {
        NoteBlockPlayerMain.plugin.playerVolume.put(player.getName(), volume);
        NoteBlockAPI.setPlayerVolume(player, volume);
    }

    public static byte getPlayerVolume(Player player) {
        Byte byteObj = NoteBlockPlayerMain.plugin.playerVolume.get(player.getName());
        if (byteObj == null) {
            byteObj = 100;
            NoteBlockPlayerMain.plugin.playerVolume.put(player.getName(), byteObj);
        }
        return byteObj;
    }

    public void onEnable() {
        plugin = this;
    }

    public void onDisable() {
        this.disabling = true;
    }

    public void doSync(Runnable runnable) {
        Bukkit.getServer().getScheduler().runTask((Plugin)NoteBlockAPI.getAPI(), runnable);
    }

    public void doAsync(Runnable runnable) {
        Bukkit.getServer().getScheduler().runTaskAsynchronously((Plugin)NoteBlockAPI.getAPI(), runnable);
    }

    public boolean isDisabling() {
        return this.disabling;
    }
}

