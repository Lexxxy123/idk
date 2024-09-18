/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 */
package de.tr7zw.nbtapi.plugin.tests.compounds;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import java.util.Arrays;
import java.util.Collection;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EqualsTest
implements Test {
    @Override
    public void test() throws Exception {
        NBTContainer cont = new NBTContainer();
        cont.setString("hello", "world");
        cont.setInteger("theAnswer", 42);
        cont.addCompound("sub").setString("me", "too");
        cont.getStringList("somelist").addAll((Collection<String>)Arrays.asList("a", "b", "c"));
        ItemStack item = new ItemStack(Material.STONE);
        NBTItem nbti = new NBTItem(item);
        NBTCompound customData = nbti.addCompound("customData");
        customData.addCompound("sub").setString("me", "too");
        customData.setInteger("theAnswer", 42);
        customData.setString("hello", "world");
        customData.getStringList("somelist").addAll((Collection<String>)Arrays.asList("a", "b", "c"));
        if (!customData.equals(cont)) {
            throw new NbtApiException("Compounds did not match! " + customData + " " + cont);
        }
    }
}

