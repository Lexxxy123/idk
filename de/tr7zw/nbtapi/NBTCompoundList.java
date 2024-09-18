/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang.NotImplementedException
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTList;
import de.tr7zw.nbtapi.NBTListCompound;
import de.tr7zw.nbtapi.NBTType;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import org.apache.commons.lang.NotImplementedException;

public class NBTCompoundList
extends NBTList<NBTListCompound> {
    protected NBTCompoundList(NBTCompound owner, String name, NBTType type, Object list) {
        super(owner, name, type, list);
    }

    public NBTListCompound addCompound() {
        return (NBTListCompound)this.addCompound(null);
    }

    public NBTCompound addCompound(NBTCompound comp) {
        try {
            Object compound = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
            if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
                ReflectionMethod.LIST_ADD.run(this.listObject, this.size(), compound);
            } else {
                ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, compound);
            }
            this.getParent().saveCompound();
            NBTListCompound listcomp = new NBTListCompound(this, compound);
            if (comp != null) {
                listcomp.mergeCompound(comp);
            }
            return listcomp;
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        }
    }

    @Override
    @Deprecated
    public boolean add(NBTListCompound empty) {
        return this.addCompound(empty) != null;
    }

    @Override
    public void add(int index, NBTListCompound element) {
        if (element != null) {
            throw new NotImplementedException("You need to pass null! ListCompounds from other lists won't work.");
        }
        try {
            Object compound = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
            if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_14_R1.getVersionId()) {
                ReflectionMethod.LIST_ADD.run(this.listObject, index, compound);
            } else {
                ReflectionMethod.LEGACY_LIST_ADD.run(this.listObject, compound);
            }
            super.getParent().saveCompound();
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        }
    }

    @Override
    public NBTListCompound get(int index) {
        try {
            Object compound = ReflectionMethod.LIST_GET_COMPOUND.run(this.listObject, index);
            return new NBTListCompound(this, compound);
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        }
    }

    @Override
    public NBTListCompound set(int index, NBTListCompound element) {
        throw new NotImplementedException("This method doesn't work in the ListCompound context.");
    }

    @Override
    protected Object asTag(NBTListCompound object) {
        return null;
    }
}

