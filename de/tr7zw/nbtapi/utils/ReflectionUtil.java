/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.utils;

import de.tr7zw.nbtapi.NbtApiException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class ReflectionUtil {
    private static Field field_modifiers;

    public static Field makeNonFinal(Field field) throws IllegalArgumentException, IllegalAccessException {
        int mods = field.getModifiers();
        if (Modifier.isFinal(mods)) {
            field_modifiers.set(field, mods & 0xFFFFFFEF);
        }
        return field;
    }

    public static void setFinal(Object obj, Field field, Object newValue) throws IllegalArgumentException, IllegalAccessException {
        field.setAccessible(true);
        field = ReflectionUtil.makeNonFinal(field);
        field.set(obj, newValue);
    }

    static {
        try {
            field_modifiers = Field.class.getDeclaredField("modifiers");
            field_modifiers.setAccessible(true);
        } catch (NoSuchFieldException ex) {
            try {
                Field[] fields;
                Method fieldGetter = Class.class.getDeclaredMethod("getDeclaredFields0", Boolean.TYPE);
                fieldGetter.setAccessible(true);
                for (Field f2 : fields = (Field[])fieldGetter.invoke(Field.class, false)) {
                    if (!f2.getName().equals("modifiers")) continue;
                    field_modifiers = f2;
                    field_modifiers.setAccessible(true);
                }
            } catch (Exception e2) {
                throw new NbtApiException(e2);
            }
        }
        if (field_modifiers == null) {
            throw new NbtApiException("Unable to init the modifiers Field.");
        }
    }
}

