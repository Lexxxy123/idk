/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  net.minecraft.server.v1_8_R3.ItemStack
 *  net.minecraft.server.v1_8_R3.NBTBase
 *  net.minecraft.server.v1_8_R3.NBTTagCompound
 *  net.minecraft.server.v1_8_R3.NBTTagInt
 *  org.bukkit.Material
 *  org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.features.item.weapon;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.NBTBase;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagInt;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.item.Ability;
import vn.giakhanhvn.skysim.features.item.AbilityActivation;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.ToolStatistics;
import vn.giakhanhvn.skysim.util.FerocityCalculation;
import vn.giakhanhvn.skysim.util.Sputnik;

public class AtomsplitKatana
implements ToolStatistics,
MaterialFunction,
Ability {
    @Override
    public int getBaseDamage() {
        return 245;
    }

    @Override
    public double getBaseStrength() {
        return 100.0;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.3;
    }

    @Override
    public double getBaseIntelligence() {
        return 300.0;
    }

    @Override
    public String getDisplayName() {
        return "Atomsplit Katana";
    }

    @Override
    public String getLore() {
        return "Deal " + ChatColor.GREEN + "+250% " + ChatColor.GRAY + "damage to Endermen.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    @Override
    public void onAbilityUse(final Player player, SItem sItem) {
        final ItemStack item = player.getInventory().getItemInHand();
        final Integer itemslot = player.getInventory().getHeldItemSlot();
        this.start(player, item, itemslot);
        Sputnik.playActivateSound(player);
        FerocityCalculation.ONE_TYPE_FEROCITY_BONUS_ENDERMAN.put(player.getUniqueId(), 400);
        new BukkitRunnable(){

            public void run() {
                FerocityCalculation.ONE_TYPE_FEROCITY_BONUS_ENDERMAN.put(player.getUniqueId(), 0);
                AtomsplitKatana.this.done(player, item, itemslot);
                Sputnik.playDeActivateSound(player);
            }
        }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 75L);
    }

    @Override
    public String getAbilityName() {
        return "Soulcry";
    }

    @Override
    public String getAbilityDescription() {
        return "Gain " + ChatColor.RED + "+400\u2afd Ferocity " + ChatColor.GRAY + "against Endermen for " + ChatColor.GREEN + "4s.";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 80;
    }

    @Override
    public AbilityActivation getAbilityActivation() {
        return AbilityActivation.RIGHT_CLICK;
    }

    @Override
    public int getManaCost() {
        return 300;
    }

    public void start(Player player, ItemStack stack, Integer slot) {
        net.minecraft.server.v1_8_R3.ItemStack tagStack = CraftItemStack.asNMSCopy((ItemStack)stack);
        NBTTagCompound tagCompound = tagStack.hasTag() ? tagStack.getTag() : new NBTTagCompound();
        tagCompound.set("isGoldSword", (NBTBase)new NBTTagInt(1));
        tagStack.setTag(tagCompound);
        ItemStack itemStack = CraftItemStack.asBukkitCopy((net.minecraft.server.v1_8_R3.ItemStack)tagStack);
        if (tagStack.getTag().getInt("isGoldSword") == 1) {
            itemStack.setType(Material.GOLD_SWORD);
            player.getInventory().setItem(slot.intValue(), itemStack);
        }
    }

    public void done(Player player, ItemStack stack, Integer slot) {
        net.minecraft.server.v1_8_R3.ItemStack tagStack = CraftItemStack.asNMSCopy((ItemStack)stack);
        NBTTagCompound tagCompound = tagStack.hasTag() ? tagStack.getTag() : new NBTTagCompound();
        tagCompound.set("isGoldSword", (NBTBase)new NBTTagInt(0));
        tagStack.setTag(tagCompound);
        SItem sitem = SItem.find(player.getInventory().getItem(slot.intValue()));
        if (sitem != null && sitem.getType() == SMaterial.ATOMSPLIT_KATANA) {
            ItemStack itemStack = CraftItemStack.asBukkitCopy((net.minecraft.server.v1_8_R3.ItemStack)tagStack);
            if (tagStack.getTag().getInt("isGoldSword") == 0) {
                itemStack.setType(Material.DIAMOND_SWORD);
                player.getInventory().setItem(slot.intValue(), itemStack);
            }
        }
    }
}

