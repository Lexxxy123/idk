/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package vn.giakhanhvn.skysim.features.item.weapon;

import org.bukkit.ChatColor;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.ToolStatistics;

public class ReaperFalchion
implements ToolStatistics,
MaterialFunction {
    @Override
    public int getBaseDamage() {
        return 120;
    }

    @Override
    public double getBaseStrength() {
        return 100.0;
    }

    @Override
    public double getBaseIntelligence() {
        return 200.0;
    }

    @Override
    public String getDisplayName() {
        return "Reaper Falchion";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public String getLore() {
        return "Heal " + ChatColor.RED + "10" + ChatColor.RED + "\u2764" + ChatColor.GRAY + " per hit. Deal " + ChatColor.GREEN + "+200% " + ChatColor.GRAY + "damage to Zombies. Receive " + ChatColor.GREEN + "20% " + ChatColor.GRAY + "less damage from Zombies when held.";
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }
}

