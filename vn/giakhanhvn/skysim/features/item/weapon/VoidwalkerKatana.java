/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 */
package vn.giakhanhvn.skysim.features.item.weapon;

import net.md_5.bungee.api.ChatColor;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.ToolStatistics;

public class VoidwalkerKatana
implements ToolStatistics,
MaterialFunction {
    @Override
    public int getBaseDamage() {
        return 80;
    }

    @Override
    public double getBaseStrength() {
        return 40.0;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.1;
    }

    @Override
    public String getDisplayName() {
        return "Voidwalker Katana";
    }

    @Override
    public String getLore() {
        return "Deal " + ChatColor.GREEN + "+100% " + ChatColor.GRAY + "damage to Endermen.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }
}

