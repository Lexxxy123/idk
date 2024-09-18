/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.ItemDespawnEvent
 *  org.bukkit.event.player.PlayerPickupItemEvent
 */
package de.slikey.effectlib.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemListener
implements Listener {
    public static final String ITEM_IDENTIFIER = "EffectItem";

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        if (event.getItem().hasMetadata(ITEM_IDENTIFIER)) {
            event.setCancelled(true);
            return;
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onItemDespawn(ItemDespawnEvent event) {
        if (event.getEntity().hasMetadata(ITEM_IDENTIFIER)) {
            event.setCancelled(true);
            return;
        }
    }
}

