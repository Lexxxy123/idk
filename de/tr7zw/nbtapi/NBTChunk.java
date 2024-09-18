/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Chunk
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTPersistentDataContainer;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.annotations.AvailableSince;
import de.tr7zw.nbtapi.utils.annotations.CheckUtil;
import de.tr7zw.nbtapi.utils.annotations.FAUtil;
import org.bukkit.Chunk;

public class NBTChunk {
    private final Chunk chunk;

    public NBTChunk(Chunk chunk) {
        this.chunk = chunk;
    }

    @AvailableSince(version=MinecraftVersion.MC1_16_R3)
    public NBTCompound getPersistentDataContainer() {
        FAUtil.check(this::getPersistentDataContainer, CheckUtil::isAvaliable);
        return new NBTPersistentDataContainer(this.chunk.getPersistentDataContainer());
    }
}

