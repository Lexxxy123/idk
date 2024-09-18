/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package de.tr7zw.nbtapi.plugin.tests.items;

import com.google.common.collect.Lists;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemConvertionTest
implements Test {
    @Override
    public void test() throws Exception {
        ItemStack item = new ItemStack(Material.STONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Lists.newArrayList("Firest Line", "Second Line"));
        item.setItemMeta(meta);
        String nbt = NBTItem.convertItemtoNBT(item).toString();
        if (!nbt.contains("Firest Line") || !nbt.contains("Second Line")) {
            throw new NbtApiException("The Item nbt '" + nbt + "' didn't contain the lore");
        }
        ItemStack rebuild = NBTItem.convertNBTtoItem(new NBTContainer(nbt));
        if (!item.isSimilar(rebuild)) {
            throw new NbtApiException("Rebuilt item did not match the original!");
        }
        NBTContainer cont = new NBTContainer();
        cont.setItemStack("testItem", item);
        if (!cont.getItemStack("testItem").isSimilar(item)) {
            throw new NbtApiException("Rebuilt item did not match the original!");
        }
    }
}

