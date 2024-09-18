/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.configuration.ConfigurationSection
 */
package de.slikey.effectlib.math;

import de.slikey.effectlib.math.ConstantTransform;
import de.slikey.effectlib.math.EchoTransform;
import de.slikey.effectlib.math.EquationTransform;
import de.slikey.effectlib.math.Transform;
import de.slikey.effectlib.util.ConfigUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

public class Transforms {
    private static final String TRANSFORM_BUILTIN_CLASSPATH = "com.elmakers.mine.bukkit.math";
    private static Map<String, Class<?>> transformClasses = new HashMap();

    public static Transform loadTransform(ConfigurationSection base, String value) {
        if (base.isConfigurationSection(value)) {
            return Transforms.loadTransform(ConfigUtils.getConfigurationSection(base, value));
        }
        if (base.isDouble(value) || base.isInt(value)) {
            return new ConstantTransform(base.getDouble(value));
        }
        if (base.isString(value)) {
            String equation = base.getString(value);
            if (equation.equalsIgnoreCase("t") || equation.equalsIgnoreCase("time")) {
                return new EchoTransform();
            }
            return new EquationTransform(equation);
        }
        return new ConstantTransform(0.0);
    }

    public static Collection<Transform> loadTransformList(ConfigurationSection base, String value) {
        Collection<ConfigurationSection> transformConfigs = ConfigUtils.getNodeList(base, value);
        ArrayList<Transform> transforms = new ArrayList<Transform>();
        if (transformConfigs != null) {
            for (ConfigurationSection transformConfig : transformConfigs) {
                transforms.add(Transforms.loadTransform(transformConfig));
            }
        }
        return transforms;
    }

    public static Transform loadTransform(ConfigurationSection parameters) {
        Transform transform = null;
        if (parameters != null && parameters.contains("class")) {
            String className = parameters.getString("class");
            try {
                Class<?> genericClass;
                if (!className.contains(".")) {
                    className = "com.elmakers.mine.bukkit.math." + className;
                }
                if ((genericClass = transformClasses.get(className)) == null) {
                    try {
                        genericClass = Class.forName(className + "Transform");
                    } catch (Exception ex) {
                        genericClass = Class.forName(className);
                    }
                    if (!Transform.class.isAssignableFrom(genericClass)) {
                        throw new Exception("Must extend Transform");
                    }
                    transformClasses.put(className, genericClass);
                }
                Class<?> transformClass = genericClass;
                transform = (Transform)transformClass.newInstance();
                parameters.set("class", null);
                transform.load(parameters);
            } catch (Exception ex) {
                Bukkit.getLogger().warning("Error loading class " + className + ": " + ex.getMessage());
            }
        }
        return transform == null ? new ConstantTransform(0.0) : transform;
    }
}

