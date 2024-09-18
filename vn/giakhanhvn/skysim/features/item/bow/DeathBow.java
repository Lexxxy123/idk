/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 */
package vn.giakhanhvn.skysim.features.item.bow;

import net.md_5.bungee.api.ChatColor;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.ToolStatistics;
import vn.giakhanhvn.skysim.features.item.bow.BowFunction;

public class DeathBow
implements ToolStatistics,
BowFunction {
    @Override
    public String getDisplayName() {
        return "Death Bow";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public int getBaseDamage() {
        return 300;
    }

    @Override
    public String getLore() {
        return "Deal " + ChatColor.GREEN + "+100% " + ChatColor.GRAY + "more damage to Undead Monsters, Your arrows have a" + ChatColor.YELLOW + " 50.0%" + ChatColor.GRAY + " chance to bounce to another target after hitting an enemy.";
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.RANGED_WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOW;
    }
}

