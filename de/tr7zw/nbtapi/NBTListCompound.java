/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTList;

public class NBTListCompound
extends NBTCompound {
    private NBTList<?> owner;
    private Object compound;

    protected NBTListCompound(NBTList<?> parent, Object obj) {
        super(null, null);
        this.owner = parent;
        this.compound = obj;
    }

    public NBTList<?> getListParent() {
        return this.owner;
    }

    @Override
    public Object getCompound() {
        return this.compound;
    }

    @Override
    protected void setCompound(Object compound) {
        this.compound = compound;
    }

    @Override
    protected void saveCompound() {
        this.owner.save();
    }
}

