/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.entity.EntityShootBowEvent
 */
package vn.giakhanhvn.skysim.features.item.bow;

import com.google.common.util.concurrent.AtomicDouble;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityShootBowEvent;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.SItem;

public interface BowFunction
extends MaterialFunction {
    default public void onBowShoot(SItem bow, EntityShootBowEvent e2) {
    }

    default public void onBowHit(Entity hit, Player shooter, Arrow arrow, SItem weapon, AtomicDouble damage) {
    }
}

