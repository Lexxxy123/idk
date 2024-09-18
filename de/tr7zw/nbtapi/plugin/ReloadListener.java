/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerCommandPreprocessEvent
 *  org.bukkit.event.server.ServerCommandEvent
 */
package de.tr7zw.nbtapi.plugin;

import de.tr7zw.nbtinjector.NBTInjector;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class ReloadListener
implements Listener {
    @EventHandler
    public void onCommand(ServerCommandEvent event) {
        if (event.getCommand().toLowerCase().startsWith("reload") && NBTInjector.isInjected()) {
            event.setCancelled(true);
            event.getSender().sendMessage("[NBTAPI] The NBTInjector is currently enabled. Reloading will turn the server into an unstable state and data-loss may accure. Please do a clean restart. Canceled reload!");
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().toLowerCase().startsWith("/reload") && NBTInjector.isInjected()) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("[NBTAPI] The NBTInjector is currently enabled. Reloading will turn the server into an unstable state and data-loss may accure. Please do a clean restart. Canceled reload!");
        }
    }
}

