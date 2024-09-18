/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.utils.annotations;

import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.annotations.AvailableSince;
import java.lang.reflect.Method;

public class CheckUtil {
    public static boolean isAvaliable(Method method) {
        if (MinecraftVersion.getVersion().getVersionId() < method.getAnnotation(AvailableSince.class).version().getVersionId()) {
            throw new NbtApiException("The Method '" + method.getName() + "' is only avaliable for the Versions " + (Object)((Object)method.getAnnotation(AvailableSince.class).version()) + "+, but still got called!");
        }
        return true;
    }
}

