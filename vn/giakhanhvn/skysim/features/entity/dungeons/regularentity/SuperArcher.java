/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 */
package vn.giakhanhvn.skysim.features.entity.dungeons.regularentity;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.EntityDrop;
import vn.giakhanhvn.skysim.features.entity.EntityDropType;
import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.EntityStatistics;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityEquipment;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.util.EntityManager;
import vn.giakhanhvn.skysim.util.SUtil;

public class SuperArcher
implements EntityFunction,
EntityStatistics {
    @Override
    public String getEntityName() {
        return "Super Archer";
    }

    @Override
    public double getEntityMaxHealth() {
        return 1.0E8;
    }

    @Override
    public double getDamageDealt() {
        return 3000000.0;
    }

    @Override
    public double getXPDropped() {
        return 60.0;
    }

    @Override
    public void onSpawn(LivingEntity entity, SEntity sEntity) {
        entity.setMetadata("SlayerBoss", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
        entity.setMetadata("DungeonMobs", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
        EntityManager.DEFENSE_PERCENTAGE.put((Entity)entity, 55);
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.ARROW, SUtil.random(2, 4)), EntityDropType.GUARANTEED, 1.0), new EntityDrop(SMaterial.ENCHANTED_BONE, EntityDropType.RARE, 0.05));
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(new ItemStack(Material.BOW), null, null, null, null);
    }
}

