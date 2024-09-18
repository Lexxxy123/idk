/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.GenericAttributes
 *  org.bukkit.Material
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftSkeleton
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
package vn.giakhanhvn.skysim.features.entity.end;

import java.util.Arrays;
import java.util.List;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftSkeleton;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import vn.giakhanhvn.skysim.features.entity.EntityDrop;
import vn.giakhanhvn.skysim.features.entity.EntityDropType;
import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.EntityStatistics;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityEquipment;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.util.SUtil;

public class ObsidianDefender
implements EntityFunction,
EntityStatistics {
    @Override
    public String getEntityName() {
        return "Obsidian Defender";
    }

    @Override
    public double getEntityMaxHealth() {
        return 10000.0;
    }

    @Override
    public double getDamageDealt() {
        return 200.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.OBSIDIAN, SUtil.random(6, 7)), EntityDropType.GUARANTEED, 1.0), new EntityDrop(SItem.of(SMaterial.ENCHANTED_OBSIDIAN).getStack(), EntityDropType.RARE, 0.05), new EntityDrop(SItem.of(SMaterial.OBSIDIAN_CHESTPLATE).getStack(), EntityDropType.EXTRAORDINARILY_RARE, 0.001));
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(new ItemStack(Material.AIR), new ItemStack(Material.OBSIDIAN), SItem.of(SMaterial.OBSIDIAN_CHESTPLATE).getStack(), null, null);
    }

    @Override
    public void onSpawn(LivingEntity entity, SEntity sEntity) {
        ((CraftLivingEntity)entity).getHandle().getAttributeInstance(GenericAttributes.c).setValue(1.0);
        ((CraftSkeleton)entity).getHandle().setSkeletonType(1);
        entity.getEquipment().setItemInHand(null);
    }

    @Override
    public double getMovementSpeed() {
        return 0.6;
    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e2) {
        PlayerInventory inventory;
        SItem sItem;
        if (!(e2.getEntity() instanceof LivingEntity)) {
            return;
        }
        if (e2.getEntity() instanceof Player && (sItem = SItem.find((inventory = ((Player)e2.getEntity()).getInventory()).getChestplate())) != null && sItem.getType() == SMaterial.OBSIDIAN_CHESTPLATE) {
            return;
        }
        ((LivingEntity)e2.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 80, 1));
    }

    @Override
    public double getXPDropped() {
        return 43.2;
    }

    @Override
    public int mobLevel() {
        return 55;
    }
}

