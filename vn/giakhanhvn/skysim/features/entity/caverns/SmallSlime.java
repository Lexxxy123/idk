/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.features.entity.caverns;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.SlimeStatistics;

public class SmallSlime
implements SlimeStatistics,
EntityFunction {
    @Override
    public String getEntityName() {
        return "Slime";
    }

    @Override
    public double getEntityMaxHealth() {
        return 80.0;
    }

    @Override
    public double getDamageDealt() {
        return 70.0;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public void onAttack(final EntityDamageByEntityEvent e2) {
        new BukkitRunnable(){

            public void run() {
                e2.getEntity().setVelocity(e2.getEntity().getVelocity().clone().setY(1.5));
            }
        }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 1L);
    }

    @Override
    public double getXPDropped() {
        return 12.0;
    }
}

