/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package vn.giakhanhvn.skysim.features.item.rune;

import org.bukkit.ChatColor;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.Rune;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;

public class CoutureRune
implements Rune {
    @Override
    public String getDisplayName() {
        return ChatColor.AQUA + "\u25c6 Couture Rune";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.COSMETIC;
    }

    @Override
    public String getURL() {
        return "734fb3203233efbae82628bd4fca7348cd071e5b7b52407f1d1d2794e31799ff";
    }
}

