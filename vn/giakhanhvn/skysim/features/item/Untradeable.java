/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.NBTTagCompound
 */
package vn.giakhanhvn.skysim.features.item;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import vn.giakhanhvn.skysim.features.item.ItemData;

public interface Untradeable
extends ItemData {
    @Override
    default public NBTTagCompound getData() {
        return new NBTTagCompound();
    }
}

