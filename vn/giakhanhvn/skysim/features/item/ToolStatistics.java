/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.NBTTagCompound
 */
package vn.giakhanhvn.skysim.features.item;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import vn.giakhanhvn.skysim.features.item.Enchantable;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.PlayerBoostStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.Reforgable;

public interface ToolStatistics
extends PlayerBoostStatistics,
Enchantable,
Reforgable {
    @Override
    public String getDisplayName();

    @Override
    public Rarity getRarity();

    @Override
    public GenericItemType getType();

    @Override
    default public boolean isStackable() {
        return false;
    }

    @Override
    default public NBTTagCompound getData() {
        return new NBTTagCompound();
    }
}

