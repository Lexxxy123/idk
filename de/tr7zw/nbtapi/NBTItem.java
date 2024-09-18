/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NBTItem
extends NBTCompound {
    private ItemStack bukkitItem;
    private boolean directApply;
    private ItemStack originalSrcStack = null;

    public NBTItem(ItemStack item) {
        this(item, false);
    }

    public NBTItem(ItemStack item, boolean directApply) {
        super(null, null);
        if (item == null || item.getType() == Material.AIR) {
            throw new NullPointerException("ItemStack can't be null/Air!");
        }
        this.directApply = directApply;
        this.bukkitItem = item.clone();
        if (directApply) {
            this.originalSrcStack = item;
        }
    }

    @Override
    public Object getCompound() {
        return NBTReflectionUtil.getItemRootNBTTagCompound(ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, this.bukkitItem));
    }

    @Override
    protected void setCompound(Object compound) {
        Object stack = ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, this.bukkitItem);
        ReflectionMethod.ITEMSTACK_SET_TAG.run(stack, compound);
        this.bukkitItem = (ItemStack)ReflectionMethod.ITEMSTACK_BUKKITMIRROR.run(null, stack);
    }

    public void applyNBT(ItemStack item) {
        if (item == null || item.getType() == Material.AIR) {
            throw new NullPointerException("ItemStack can't be null/Air!");
        }
        NBTItem nbti = new NBTItem(new ItemStack(item.getType()));
        nbti.mergeCompound(this);
        item.setItemMeta(nbti.getItem().getItemMeta());
    }

    public void mergeNBT(ItemStack item) {
        NBTItem nbti = new NBTItem(item);
        nbti.mergeCompound(this);
        item.setItemMeta(nbti.getItem().getItemMeta());
    }

    public void mergeCustomNBT(ItemStack item) {
        if (item == null || item.getType() == Material.AIR) {
            throw new NullPointerException("ItemStack can't be null/Air!");
        }
        ItemMeta meta = item.getItemMeta();
        NBTReflectionUtil.getUnhandledNBTTags(meta).putAll(NBTReflectionUtil.getUnhandledNBTTags(this.bukkitItem.getItemMeta()));
        item.setItemMeta(meta);
    }

    public void clearCustomNBT() {
        ItemMeta meta = this.bukkitItem.getItemMeta();
        NBTReflectionUtil.getUnhandledNBTTags(meta).clear();
        this.bukkitItem.setItemMeta(meta);
    }

    public ItemStack getItem() {
        return this.bukkitItem;
    }

    protected void setItem(ItemStack item) {
        this.bukkitItem = item;
    }

    public boolean hasNBTData() {
        return this.getCompound() != null;
    }

    public static NBTContainer convertItemtoNBT(ItemStack item) {
        return NBTReflectionUtil.convertNMSItemtoNBTCompound(ReflectionMethod.ITEMSTACK_NMSCOPY.run(null, item));
    }

    public static ItemStack convertNBTtoItem(NBTCompound comp) {
        return (ItemStack)ReflectionMethod.ITEMSTACK_BUKKITMIRROR.run(null, NBTReflectionUtil.convertNBTCompoundtoNMSItem(comp));
    }

    @Override
    protected void saveCompound() {
        if (this.directApply) {
            this.applyNBT(this.originalSrcStack);
        }
    }
}

