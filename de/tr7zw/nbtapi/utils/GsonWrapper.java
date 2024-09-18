/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 */
package de.tr7zw.nbtapi.utils;

import com.google.gson.Gson;
import de.tr7zw.nbtapi.NbtApiException;

public class GsonWrapper {
    private static final Gson gson = new Gson();

    private GsonWrapper() {
    }

    public static String getString(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T deserializeJson(String json, Class<T> type) {
        try {
            if (json == null) {
                return null;
            }
            Object obj = gson.fromJson(json, type);
            return type.cast(obj);
        } catch (Exception ex) {
            throw new NbtApiException("Error while converting json to " + type.getName(), ex);
        }
    }
}

