/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package vn.giakhanhvn.skysim.features.item.accessory;

import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.accessory.AccessoryStatistics;

public class CrackedPiggyBank
implements AccessoryStatistics,
MaterialFunction {
    @Override
    public String getURL() {
        return "14a7aac08593a1a0bc6666fe0aeedfb195d413fc9cf87c73f4a8c04da6418857";
    }

    @Override
    public String getDisplayName() {
        return "Cracked Piggy Bank";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public List<String> getListLore() {
        return Arrays.asList("Saves " + ChatColor.RED + "75%" + ChatColor.GRAY + " of your coins on death.", "Only when in player inventory.", ChatColor.RED + "Very fragile!", "", ChatColor.DARK_GRAY + "Triggers when losing 20k+ coins.");
    }
}

