/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTList;
import de.tr7zw.nbtapi.NBTType;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NBTLongList
extends NBTList<Long> {
    protected NBTLongList(NBTCompound owner, String name, NBTType type, Object list) {
        super(owner, name, type, list);
    }

    @Override
    protected Object asTag(Long object) {
        try {
            Constructor<?> con = ClassWrapper.NMS_NBTTAGLONG.getClazz().getDeclaredConstructor(Long.TYPE);
            con.setAccessible(true);
            return con.newInstance(object);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            throw new NbtApiException("Error while wrapping the Object " + object + " to it's NMS object!", e2);
        }
    }

    @Override
    public Long get(int index) {
        try {
            Object obj = ReflectionMethod.LIST_GET.run(this.listObject, index);
            return Long.valueOf(obj.toString().replace("L", ""));
        } catch (NumberFormatException nf) {
            return 0L;
        } catch (Exception ex) {
            throw new NbtApiException(ex);
        }
    }
}

