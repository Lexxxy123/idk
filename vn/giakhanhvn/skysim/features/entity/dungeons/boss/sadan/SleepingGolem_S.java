/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 */
package vn.giakhanhvn.skysim.features.entity.dungeons.boss.sadan;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityType;
import vn.giakhanhvn.skysim.features.entity.zombie.BaseZombie;
import vn.giakhanhvn.skysim.util.EntityManager;
import vn.giakhanhvn.skysim.util.Sputnik;

public class SleepingGolem_S
extends BaseZombie {
    @Override
    public String getEntityName() {
        return Sputnik.trans("&5&lSleeping Golem");
    }

    @Override
    public double getEntityMaxHealth() {
        return 1.0;
    }

    @Override
    public double getDamageDealt() {
        return 0.0;
    }

    @Override
    public void onSpawn(LivingEntity entity, SEntity sEntity) {
        ((CraftZombie)entity).setBaby(false);
        Location l2 = entity.getLocation().clone();
        l2.setPitch(45.0f);
        entity.teleport(l2);
        EntityManager.noAI((Entity)entity);
        Sputnik.applyPacketGolem((Entity)entity);
        EntityManager.DEFENSE_PERCENTAGE.put((Entity)entity, 0);
        entity.setMetadata("NNP", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        new SEntity(killed.getLocation(), SEntityType.WOKE_GOLEM, new Object[0]);
        killed.remove();
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    public boolean hasNameTag() {
        return false;
    }

    @Override
    public boolean isVillager() {
        return false;
    }

    @Override
    public double getXPDropped() {
        return 0.0;
    }

    @Override
    public double getMovementSpeed() {
        return 0.0;
    }
}

