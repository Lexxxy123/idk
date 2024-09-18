/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package xyz.xenondevs.particle;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public class ParticleMappings {
    private static final Map<String, String> mappings = new HashMap<String, String>();

    private static void processMapping(JsonObject object, double version) {
        if (version < object.get("min").getAsDouble() || version > object.get("max").getAsDouble()) {
            return;
        }
        String name = object.get("name").getAsString();
        JsonArray mappingsArray = object.get("mappings").getAsJsonArray();
        String bestMatch = null;
        double lastVersion = 0.0;
        for (int i2 = 0; i2 < mappingsArray.size(); ++i2) {
            JsonObject mapping = mappingsArray.get(i2).getAsJsonObject();
            double from = mapping.get("from").getAsDouble();
            if (!(version >= from) || !(from > lastVersion)) continue;
            bestMatch = mapping.get("value").getAsString();
        }
        if (bestMatch != null) {
            mappings.put(name, bestMatch);
        }
    }

    public static Class<?> getMappedClass(String name) {
        if (!mappings.containsKey(name)) {
            return null;
        }
        return ReflectionUtils.getNMSClass(mappings.get(name));
    }

    public static Method getMappedMethod(Class<?> targetClass, String name, Class<?> ... parameterTypes) {
        if (!mappings.containsKey(name)) {
            return null;
        }
        return ReflectionUtils.getMethodOrNull(targetClass, mappings.get(name), parameterTypes);
    }

    public static Field getMappedField(Class targetClass, String name, boolean declared) {
        if (!mappings.containsKey(name)) {
            return null;
        }
        return ReflectionUtils.getFieldOrNull(targetClass, mappings.get(name), declared);
    }

    static {
        double version = ReflectionUtils.MINECRAFT_VERSION;
        try (InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(ReflectionUtils.getResourceStreamSafe("mappings.json")));){
            JsonArray array = version < 18.0 ? new JsonParser().parse((Reader)reader).getAsJsonArray() : JsonParser.parseReader((Reader)reader).getAsJsonArray();
            for (int i2 = 0; i2 < array.size(); ++i2) {
                JsonObject object = array.get(i2).getAsJsonObject();
                ParticleMappings.processMapping(object, version);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Could not load mappings", ex);
        }
    }
}

