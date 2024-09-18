/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.entity.end;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityType;
import vn.giakhanhvn.skysim.features.entity.end.EndermanStatistics;
import vn.giakhanhvn.skysim.features.slayer.SlayerQuest;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SUtil;

public abstract class BaseEnderman
implements EndermanStatistics,
EntityFunction {
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
        if (quest.getType().getName() == "Voidgloom Seraph") {
            Location k2 = killed.getLocation().clone();
            if (SUtil.random(0, 8) == 0 && quest.getType().getTier() == 3) {
                SlayerQuest.playMinibossSpawn(k2, (Entity)player);
                SUtil.delay(() -> new SEntity(k2, SEntityType.VOIDLING_DEVOTEE, new Object[0]).setTarget((LivingEntity)player), 12L);
                return;
            }
            if (SUtil.random(0, 16) == 0 && quest.getType().getTier() == 4) {
                SlayerQuest.playMinibossSpawn(k2, (Entity)player);
                SUtil.delay(() -> new SEntity(k2, SEntityType.VOIDLING_RADICAL, new Object[0]).setTarget((LivingEntity)player), 12L);
                return;
            }
            if (SUtil.random(0, 45) == 0 && quest.getType().getTier() == 4) {
                SlayerQuest.playMinibossSpawn(k2, (Entity)player);
                SUtil.delay(() -> new SEntity(k2, SEntityType.VOIDCRAZED_MANIAC, new Object[0]).setTarget((LivingEntity)player), 12L);
            }
        }
    }
}

