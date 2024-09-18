/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.ConfigurationSection
 *  org.bukkit.configuration.MemoryConfiguration
 */
package de.slikey.effectlib.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemoryConfiguration;

public class ConfigUtils {
    public static Collection<ConfigurationSection> getNodeList(ConfigurationSection node, String path) {
        ArrayList<ConfigurationSection> results = new ArrayList<ConfigurationSection>();
        List mapList = node.getMapList(path);
        for (Map map : mapList) {
            results.add(ConfigUtils.toNodeList(map));
        }
        return results;
    }

    public static ConfigurationSection toNodeList(Map<?, ?> nodeMap) {
        MemoryConfiguration newSection = new MemoryConfiguration();
        for (Map.Entry<?, ?> entry : nodeMap.entrySet()) {
            ConfigUtils.set((ConfigurationSection)newSection, entry.getKey().toString(), entry.getValue());
        }
        return newSection;
    }

    public static void set(ConfigurationSection node, String path, Object value) {
        if (value == null) {
            node.set(path, value);
            return;
        }
        boolean isTrue = value.equals("true");
        boolean isFalse = value.equals("false");
        if (isTrue || isFalse) {
            node.set(path, (Object)isTrue);
        } else {
            try {
                Double d2 = value instanceof Double ? (Double)value : (value instanceof Float ? (double)((Float)value).floatValue() : Double.parseDouble(value.toString()));
                node.set(path, (Object)d2);
            } catch (Exception ex) {
                try {
                    Integer i2 = value instanceof Integer ? (Integer)value : Integer.parseInt(value.toString());
                    node.set(path, (Object)i2);
                } catch (Exception ex2) {
                    node.set(path, value);
                }
            }
        }
    }

    public static ConfigurationSection getConfigurationSection(ConfigurationSection base, String key) {
        Object value = base.get(key);
        if (value == null) {
            return null;
        }
        if (value instanceof ConfigurationSection) {
            return (ConfigurationSection)value;
        }
        if (value instanceof Map) {
            ConfigurationSection newChild = base.createSection(key);
            Map map = (Map)value;
            for (Map.Entry entry : map.entrySet()) {
                newChild.set((String)entry.getKey(), entry.getValue());
            }
            base.set(key, (Object)newChild);
            return newChild;
        }
        return null;
    }
}

