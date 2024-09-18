/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.block.Block
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTChunk;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import org.bukkit.block.Block;

public class NBTBlock {
    private final Block block;
    private final NBTChunk nbtChunk;

    public NBTBlock(Block block) {
        this.block = block;
        if (!MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_16_R3)) {
            throw new NbtApiException("NBTBlock is only working for 1.16.4+!");
        }
        this.nbtChunk = new NBTChunk(block.getChunk());
    }

    public NBTCompound getData() {
        return this.nbtChunk.getPersistentDataContainer().getOrCreateCompound("blocks").getOrCreateCompound(this.block.getX() + "_" + this.block.getY() + "_" + this.block.getZ());
    }
}

