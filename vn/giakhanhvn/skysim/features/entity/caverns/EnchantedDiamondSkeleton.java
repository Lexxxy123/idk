/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 */
package vn.giakhanhvn.skysim.features.entity.caverns;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import vn.giakhanhvn.skysim.features.enchantment.Enchantment;
import vn.giakhanhvn.skysim.features.enchantment.EnchantmentType;
import vn.giakhanhvn.skysim.features.entity.EntityDrop;
import vn.giakhanhvn.skysim.features.entity.EntityDropType;
import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.EntityStatistics;
import vn.giakhanhvn.skysim.features.entity.SEntityEquipment;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.util.SUtil;

public class EnchantedDiamondSkeleton
implements EntityStatistics,
EntityFunction {
    @Override
    public String getEntityName() {
        return "Skeleton";
    }

    @Override
    public double getEntityMaxHealth() {
        return 300.0;
    }

    @Override
    public double getDamageDealt() {
        return 190.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SUtil.enchant(new ItemStack(Material.BOW)), SUtil.enchant(new ItemStack(Material.DIAMOND_BLOCK)), SUtil.enchant(new ItemStack(Material.DIAMOND_CHESTPLATE)), SUtil.enchant(new ItemStack(Material.DIAMOND_LEGGINGS)), SUtil.enchant(new ItemStack(Material.DIAMOND_BOOTS)));
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.BONE, 4), EntityDropType.GUARANTEED, 1.0), new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_HELMET), new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05), new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_CHESTPLATE), new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05), new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_LEGGINGS), new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05), new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_BOOTS), new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05));
    }

    @Override
    public double getXPDropped() {
        return 24.0;
    }
}

