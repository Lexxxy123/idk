/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.utils.nmsmappings;

import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import java.lang.reflect.Constructor;
import java.util.logging.Level;

public enum ObjectCreator {
    NMS_NBTTAGCOMPOUND(null, null, ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), new Class[0]),
    NMS_BLOCKPOSITION(null, null, ClassWrapper.NMS_BLOCKPOSITION.getClazz(), Integer.TYPE, Integer.TYPE, Integer.TYPE),
    NMS_COMPOUNDFROMITEM(MinecraftVersion.MC1_11_R1, null, ClassWrapper.NMS_ITEMSTACK.getClazz(), ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz());

    private Constructor<?> construct;
    private Class<?> targetClass;

    private ObjectCreator(MinecraftVersion from, MinecraftVersion to, Class<?> clazz, Class<?> ... args) {
        if (clazz == null) {
            return;
        }
        if (from != null && MinecraftVersion.getVersion().getVersionId() < from.getVersionId()) {
            return;
        }
        if (to != null && MinecraftVersion.getVersion().getVersionId() > to.getVersionId()) {
            return;
        }
        try {
            this.targetClass = clazz;
            this.construct = clazz.getDeclaredConstructor(args);
            this.construct.setAccessible(true);
        } catch (Exception ex) {
            MinecraftVersion.getLogger().log(Level.SEVERE, "Unable to find the constructor for the class '" + clazz.getName() + "'", ex);
        }
    }

    public Object getInstance(Object ... args) {
        try {
            return this.construct.newInstance(args);
        } catch (Exception ex) {
            throw new NbtApiException("Exception while creating a new instance of '" + this.targetClass + "'", ex);
        }
    }
}

