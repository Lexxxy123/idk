/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package vn.giakhanhvn.skysim.features.item.oddities;

import org.bukkit.ChatColor;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.Untradeable;

public class QuiverArrow
implements MaterialStatistics,
MaterialFunction,
Untradeable {
    @Override
    public String getDisplayName() {
        return ChatColor.DARK_GRAY + "Quiver Arrow";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public String getLore() {
        return "This item is in your inventory because you are holding your bow currently. Switch your held item to see the item that was here before.";
    }

    @Override
    public boolean displayRarity() {
        return false;
    }
}

