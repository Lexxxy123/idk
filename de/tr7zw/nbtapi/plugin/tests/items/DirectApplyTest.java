/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 */
package de.tr7zw.nbtapi.plugin.tests.items;

import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DirectApplyTest
implements Test {
    @Override
    public void test() throws Exception {
        ItemStack baseItem = new ItemStack(Material.STONE);
        NBTItem nbti = new NBTItem(baseItem, true);
        nbti.setString("SomeKey", "SomeValue");
        if (!baseItem.equals((Object)nbti.getItem()) || !new NBTItem(baseItem).hasKey("SomeKey").booleanValue()) {
            throw new NbtApiException("The item's where not equal!");
        }
    }
}

