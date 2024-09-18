/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import de.tr7zw.nbtapi.utils.nmsmappings.ObjectCreator;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import java.io.InputStream;

public class NBTContainer
extends NBTCompound {
    private Object nbt;

    public NBTContainer() {
        super(null, null);
        this.nbt = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
    }

    public NBTContainer(Object nbt) {
        super(null, null);
        if (nbt == null) {
            throw new NullPointerException("The NBT-Object can't be null!");
        }
        if (!ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().isAssignableFrom(nbt.getClass())) {
            throw new NbtApiException("The object '" + nbt.getClass() + "' is not a valid NBT-Object!");
        }
        this.nbt = nbt;
    }

    public NBTContainer(InputStream inputsteam) {
        super(null, null);
        this.nbt = NBTReflectionUtil.readNBT(inputsteam);
    }

    public NBTContainer(String nbtString) {
        super(null, null);
        if (nbtString == null) {
            throw new NullPointerException("The String can't be null!");
        }
        try {
            this.nbt = ReflectionMethod.PARSE_NBT.run(null, nbtString);
        } catch (Exception ex) {
            throw new NbtApiException("Unable to parse Malformed Json!", ex);
        }
    }

    @Override
    public Object getCompound() {
        return this.nbt;
    }

    @Override
    public void setCompound(Object tag) {
        this.nbt = tag;
    }
}

