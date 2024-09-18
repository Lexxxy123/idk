/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Entity
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTPersistentDataContainer;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.annotations.AvailableSince;
import de.tr7zw.nbtapi.utils.annotations.CheckUtil;
import de.tr7zw.nbtapi.utils.annotations.FAUtil;
import org.bukkit.entity.Entity;

public class NBTEntity
extends NBTCompound {
    private final Entity ent;

    public NBTEntity(Entity entity) {
        super(null, null);
        if (entity == null) {
            throw new NullPointerException("Entity can't be null!");
        }
        this.ent = entity;
    }

    @Override
    public Object getCompound() {
        return NBTReflectionUtil.getEntityNBTTagCompound(NBTReflectionUtil.getNMSEntity(this.ent));
    }

    @Override
    protected void setCompound(Object compound) {
        NBTReflectionUtil.setEntityNBTTag(compound, NBTReflectionUtil.getNMSEntity(this.ent));
    }

    @AvailableSince(version=MinecraftVersion.MC1_14_R1)
    public NBTCompound getPersistentDataContainer() {
        FAUtil.check(this::getPersistentDataContainer, CheckUtil::isAvaliable);
        return new NBTPersistentDataContainer(this.ent.getPersistentDataContainer());
    }
}

