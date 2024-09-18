/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.item;

import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.item.AbilityActivation;
import vn.giakhanhvn.skysim.features.item.SItem;

public interface Ability {
    public String getAbilityName();

    public String getAbilityDescription();

    default public void onAbilityUse(Player player, SItem sItem) {
    }

    public int getAbilityCooldownTicks();

    public int getManaCost();

    default public AbilityActivation getAbilityActivation() {
        return AbilityActivation.RIGHT_CLICK;
    }

    default public boolean displayUsage() {
        return true;
    }

    default public boolean requirementsUse(Player player, SItem sItem) {
        return false;
    }

    default public String getAbilityReq() {
        return "";
    }

    default public boolean displayCooldown() {
        return true;
    }
}

