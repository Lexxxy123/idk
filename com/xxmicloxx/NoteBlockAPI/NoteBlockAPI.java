/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.HandlerList
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.RegisteredListener
 *  org.bukkit.plugin.java.JavaPlugin
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.NoteBlockPlayerMain;
import com.xxmicloxx.NoteBlockAPI.PlayerRangeStateChangeEvent;
import com.xxmicloxx.NoteBlockAPI.SongDestroyingEvent;
import com.xxmicloxx.NoteBlockAPI.SongEndEvent;
import com.xxmicloxx.NoteBlockAPI.SongStoppedEvent;
import com.xxmicloxx.NoteBlockAPI.bukkit.Metrics;
import com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.MathUtils;
import com.xxmicloxx.NoteBlockAPI.utils.Updater;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.java.JavaPlugin;

public class NoteBlockAPI
extends JavaPlugin {
    private static NoteBlockAPI plugin;
    private Map<UUID, ArrayList<SongPlayer>> playingSongs = new ConcurrentHashMap<UUID, ArrayList<SongPlayer>>();
    private Map<UUID, Byte> playerVolume = new ConcurrentHashMap<UUID, Byte>();
    private boolean disabling = false;
    private HashMap<Plugin, Boolean> dependentPlugins = new HashMap();

    public static boolean isReceivingSong(Player player) {
        return NoteBlockAPI.isReceivingSong(player.getUniqueId());
    }

    public static boolean isReceivingSong(UUID uuid) {
        ArrayList<SongPlayer> songs = NoteBlockAPI.plugin.playingSongs.get(uuid);
        return songs != null && !songs.isEmpty();
    }

    public static void stopPlaying(Player player) {
        NoteBlockAPI.stopPlaying(player.getUniqueId());
    }

    public static void stopPlaying(UUID uuid) {
        ArrayList<SongPlayer> songs = NoteBlockAPI.plugin.playingSongs.get(uuid);
        if (songs == null) {
            return;
        }
        for (SongPlayer songPlayer : songs) {
            songPlayer.removePlayer(uuid);
        }
    }

    public static void setPlayerVolume(Player player, byte volume) {
        NoteBlockAPI.setPlayerVolume(player.getUniqueId(), volume);
    }

    public static void setPlayerVolume(UUID uuid, byte volume) {
        NoteBlockAPI.plugin.playerVolume.put(uuid, volume);
    }

    public static byte getPlayerVolume(Player player) {
        return NoteBlockAPI.getPlayerVolume(player.getUniqueId());
    }

    public static byte getPlayerVolume(UUID uuid) {
        Byte byteObj = NoteBlockAPI.plugin.playerVolume.get(uuid);
        if (byteObj == null) {
            byteObj = 100;
            NoteBlockAPI.plugin.playerVolume.put(uuid, byteObj);
        }
        return byteObj;
    }

    public static ArrayList<SongPlayer> getSongPlayersByPlayer(Player player) {
        return NoteBlockAPI.getSongPlayersByPlayer(player.getUniqueId());
    }

    public static ArrayList<SongPlayer> getSongPlayersByPlayer(UUID player) {
        return NoteBlockAPI.plugin.playingSongs.get(player);
    }

    public static void setSongPlayersByPlayer(Player player, ArrayList<SongPlayer> songs) {
        NoteBlockAPI.setSongPlayersByPlayer(player.getUniqueId(), songs);
    }

    public static void setSongPlayersByPlayer(UUID player, ArrayList<SongPlayer> songs) {
        NoteBlockAPI.plugin.playingSongs.put(player, songs);
    }

    public void onEnable() {
        plugin = this;
        for (Plugin pl : this.getServer().getPluginManager().getPlugins()) {
            if (!pl.getDescription().getDepend().contains("NoteBlockAPI") && !pl.getDescription().getSoftDepend().contains("NoteBlockAPI")) continue;
            this.dependentPlugins.put(pl, false);
        }
        final Metrics metrics = new Metrics((Plugin)this);
        new NoteBlockPlayerMain().onEnable();
        this.getServer().getScheduler().runTaskLater((Plugin)this, new Runnable(){

            @Override
            public void run() {
                Plugin[] plugins = NoteBlockAPI.this.getServer().getPluginManager().getPlugins();
                Type[] types = new Type[]{PlayerRangeStateChangeEvent.class, SongDestroyingEvent.class, SongEndEvent.class, SongStoppedEvent.class};
                for (Plugin plugin : plugins) {
                    ArrayList rls = HandlerList.getRegisteredListeners((Plugin)plugin);
                    for (RegisteredListener rl : rls) {
                        Method[] methods;
                        block2: for (Method m2 : methods = rl.getListener().getClass().getDeclaredMethods()) {
                            Class<?>[] params;
                            for (Class<?> paramType : params = m2.getParameterTypes()) {
                                for (Type type : types) {
                                    if (!paramType.equals(type)) continue;
                                    NoteBlockAPI.this.dependentPlugins.put(plugin, true);
                                    continue block2;
                                }
                            }
                        }
                    }
                }
                metrics.addCustomChart(new Metrics.DrilldownPie("deprecated", () -> {
                    HashMap map = new HashMap();
                    for (Plugin pl : NoteBlockAPI.this.dependentPlugins.keySet()) {
                        String deprecated = (Boolean)NoteBlockAPI.this.dependentPlugins.get(pl) != false ? "yes" : "no";
                        HashMap<String, Integer> entry = new HashMap<String, Integer>();
                        entry.put(pl.getDescription().getFullName(), 1);
                        map.put(deprecated, entry);
                    }
                    return map;
                }));
            }
        }, 1L);
        this.getServer().getScheduler().runTaskTimerAsynchronously((Plugin)this, new Runnable(){

            @Override
            public void run() {
                try {
                    if (Updater.checkUpdate("19287", NoteBlockAPI.this.getDescription().getVersion())) {
                        Bukkit.getLogger().info(String.format("[%s] New update available!", plugin.getDescription().getName()));
                    }
                } catch (IOException e2) {
                    Bukkit.getLogger().info(String.format("[%s] Cannot receive update from Spigot resource page!", plugin.getDescription().getName()));
                }
            }
        }, 200L, 1728000L);
        new MathUtils();
    }

    public void onDisable() {
        this.disabling = true;
        Bukkit.getScheduler().cancelTasks((Plugin)this);
        NoteBlockPlayerMain.plugin.onDisable();
    }

    public void doSync(Runnable runnable) {
        this.getServer().getScheduler().runTask((Plugin)this, runnable);
    }

    public void doAsync(Runnable runnable) {
        this.getServer().getScheduler().runTaskAsynchronously((Plugin)this, runnable);
    }

    public boolean isDisabling() {
        return this.disabling;
    }

    public static NoteBlockAPI getAPI() {
        return plugin;
    }

    protected void handleDeprecated(StackTraceElement[] ste) {
        int pom = 1;
        String clazz = ste[pom].getClassName();
        while (clazz.startsWith("com.xxmicloxx.NoteBlockAPI")) {
            clazz = ste[++pom].getClassName();
        }
        String[] packageParts = clazz.split("\\.");
        ArrayList<Plugin> plugins = new ArrayList<Plugin>();
        plugins.addAll(this.dependentPlugins.keySet());
        ArrayList<Plugin> notResult = new ArrayList<Plugin>();
        block1: for (int i2 = 0; i2 < packageParts.length - 1; ++i2) {
            for (Plugin pl : plugins) {
                if (notResult.contains(pl)) continue;
                if (plugins.size() - notResult.size() == 1) break block1;
                String[] plParts = pl.getDescription().getMain().split("\\.");
                if (packageParts[i2].equalsIgnoreCase(plParts[i2])) continue;
                notResult.add(pl);
            }
            plugins.removeAll(notResult);
            notResult.clear();
        }
        plugins.removeAll(notResult);
        notResult.clear();
        if (plugins.size() == 1) {
            this.dependentPlugins.put((Plugin)plugins.get(0), true);
        }
    }
}

