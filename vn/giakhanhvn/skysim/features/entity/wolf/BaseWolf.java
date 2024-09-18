/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Wolf
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.features.entity.wolf;

import java.util.stream.Collectors;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityType;
import vn.giakhanhvn.skysim.features.entity.wolf.WolfStatistics;
import vn.giakhanhvn.skysim.features.slayer.SlayerQuest;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SUtil;

public abstract class BaseWolf
implements WolfStatistics,
EntityFunction {
    private LivingEntity target;

    @Override
    public void onSpawn(final LivingEntity entity, SEntity sEntity) {
        new BukkitRunnable(){

            public void run() {
                if (entity.isDead()) {
                    return;
                }
                if (BaseWolf.this.target == null || BaseWolf.this.target.isDead()) {
                    BaseWolf.this.target = null;
                }
                if (BaseWolf.this.target != null) {
                    return;
                }
                Player found = (Player)SUtil.getRandom(entity.getNearbyEntities(16.0, 4.0, 16.0).stream().filter(e2 -> e2 instanceof Player && (((Player)e2).getGameMode() == GameMode.SURVIVAL || ((Player)e2).getGameMode() == GameMode.ADVENTURE)).collect(Collectors.toList()));
                if (found == null) {
                    return;
                }
                BaseWolf.this.target = (LivingEntity)found;
                ((Wolf)entity).setTarget(BaseWolf.this.target);
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 20L, 20L);
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        if (!(damager instanceof Player)) {
            return;
        }
        Player player = (Player)damager;
        User user = User.getUser(player.getUniqueId());
        SlayerQuest quest = user.getSlayerQuest();
        if (quest == null) {
            return;
        }
        if (quest.getSpawned() != 0L) {
            return;
        }
        if (quest.getType().getName() == "Sven Packmaster") {
            Location k2 = killed.getLocation().clone();
            if (SUtil.random(0, 8) == 0 && quest.getType().getTier() >= 3 && quest.getType().getTier() < 4) {
                SlayerQuest.playMinibossSpawn(k2, (Entity)player);
                SUtil.delay(() -> new SEntity(k2, SEntityType.SVEN_FOLLOWER, new Object[0]).setTarget((LivingEntity)player), 12L);
                return;
            }
            if (SUtil.random(0, 12) == 0 && quest.getType().getTier() >= 4) {
                SlayerQuest.playMinibossSpawn(k2, (Entity)player);
                SUtil.delay(() -> new SEntity(k2, SEntityType.PACK_ENFORCER, new Object[0]).setTarget((LivingEntity)player), 12L);
                return;
            }
            if (SUtil.random(0, 25) == 0 && quest.getType().getTier() >= 4) {
                SlayerQuest.playMinibossSpawn(k2, (Entity)player);
                SUtil.delay(() -> new SEntity(k2, SEntityType.SVEN_ALPHA, new Object[0]).setTarget((LivingEntity)player), 12L);
            }
        }
    }
}

