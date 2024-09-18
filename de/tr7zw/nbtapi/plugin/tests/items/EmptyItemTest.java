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

public class EmptyItemTest
implements Test {
    @Override
    public void test() throws Exception {
        ItemStack item = new ItemStack(Material.STONE);
        NBTItem nbti = new NBTItem(item);
        if (nbti.getBoolean("test") == null || nbti.getString("test") == null) {
            throw new NbtApiException("Getters return null instead of the default value");
        }
        try {
            Material barrel = Material.valueOf((String)"BARREL");
            item = new ItemStack(barrel);
            nbti = new NBTItem(item);
        } catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
    }
}

