/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.NBTTagCompound
 */
package vn.giakhanhvn.skysim.features.item.oddities;

import net.minecraft.server.v1_8_R3.NBTTagCompound;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.ItemData;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;

public class TeleporterLauncher
implements MaterialStatistics,
MaterialFunction,
ItemData {
    @Override
    public String getDisplayName() {
        return "Teleporter Launcher";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.BLOCK;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }

    @Override
    public NBTTagCompound getData() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setFloat("velX", 1.0f);
        compound.setFloat("velY", 1.0f);
        compound.setFloat("velZ", 1.0f);
        compound.setDouble("x", 0.0);
        compound.setDouble("y", 0.0);
        compound.setDouble("z", 0.0);
        compound.setString("world", "world");
        compound.setFloat("yaw", 0.0f);
        compound.setFloat("pitch", 0.0f);
        compound.setLong("delay", 60L);
        return compound;
    }
}

