/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.item.accessory;

import com.google.common.util.concurrent.AtomicDouble;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.SItem;

public interface AccessoryFunction
extends MaterialFunction {
    default public void onDamageInInventory(SItem weapon, Player damager, Entity damaged, SItem accessory, AtomicDouble damage) {
    }

    default public void update(SItem instance, Player player, int accessorySlot) {
    }
}

