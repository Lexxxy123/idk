/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.block.BlockState
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.annotations.AvailableSince;
import de.tr7zw.nbtapi.utils.annotations.CheckUtil;
import de.tr7zw.nbtapi.utils.annotations.FAUtil;
import org.bukkit.block.BlockState;

public class NBTTileEntity
extends NBTCompound {
    private final BlockState tile;

    public NBTTileEntity(BlockState tile) {
        super(null, null);
        if (tile == null || MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3) && !tile.isPlaced()) {
            throw new NullPointerException("Tile can't be null/not placed!");
        }
        this.tile = tile;
    }

    @Override
    public Object getCompound() {
        return NBTReflectionUtil.getTileEntityNBTTagCompound(this.tile);
    }

    @Override
    protected void setCompound(Object compound) {
        NBTReflectionUtil.setTileEntityNBTTagCompound(this.tile, compound);
    }

    @AvailableSince(version=MinecraftVersion.MC1_14_R1)
    public NBTCompound getPersistentDataContainer() {
        FAUtil.check(this::getPersistentDataContainer, CheckUtil::isAvaliable);
        if (this.hasKey("PublicBukkitValues").booleanValue()) {
            return this.getCompound("PublicBukkitValues");
        }
        NBTContainer container = new NBTContainer();
        container.addCompound("PublicBukkitValues").setString("__nbtapi", "Marker to make the PersistentDataContainer have content");
        this.mergeCompound(container);
        return this.getCompound("PublicBukkitValues");
    }
}

