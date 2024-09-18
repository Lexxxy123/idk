/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.item.armor;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.item.Ability;
import vn.giakhanhvn.skysim.features.item.AbilityActivation;
import vn.giakhanhvn.skysim.features.item.FlightStatistics;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.TickingMaterial;
import vn.giakhanhvn.skysim.features.item.ToolStatistics;

public class SpidersBoots
implements ToolStatistics,
TickingMaterial,
FlightStatistics,
Ability {
    @Override
    public String getAbilityName() {
        return "Double Jump";
    }

    @Override
    public String getAbilityDescription() {
        return "Allows you to Double Jump! " + ChatColor.RED + "Temporary Disabled!";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public AbilityActivation getAbilityActivation() {
        return AbilityActivation.FLIGHT;
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem) {
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public String getDisplayName() {
        return "Spider's Boots";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense() {
        return 45.0;
    }

    @Override
    public double getBaseSpeed() {
        return 0.05;
    }

    @Override
    public double getBaseIntelligence() {
        return 50.0;
    }

    @Override
    public void tick(SItem item, Player owner) {
    }

    @Override
    public boolean enableFlight() {
        return false;
    }
}

