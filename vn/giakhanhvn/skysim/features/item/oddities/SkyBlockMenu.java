/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 */
package vn.giakhanhvn.skysim.features.item.oddities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.Untradeable;
import vn.giakhanhvn.skysim.gui.GUIType;

public class SkyBlockMenu
implements MaterialStatistics,
MaterialFunction,
Untradeable {
    @Override
    public String getDisplayName() {
        return ChatColor.GREEN + "SkySim Menu " + ChatColor.GRAY + "(Right Click)";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public String getLore() {
        return "View all of your progress, including your Skills, Collections, Recipes, and more!";
    }

    @Override
    public boolean displayRarity() {
        return false;
    }

    @Override
    public void onInteraction(PlayerInteractEvent e2) {
        GUIType.SKYBLOCK_MENU.getGUI().open(e2.getPlayer());
    }

    @Override
    public void onInventoryClick(SItem instance, InventoryClickEvent e2) {
        e2.setCancelled(true);
        GUIType.SKYBLOCK_MENU.getGUI().open((Player)e2.getWhoClicked());
    }
}

