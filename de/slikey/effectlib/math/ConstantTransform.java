/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.ConfigurationSection
 */
package de.slikey.effectlib.math;

import de.slikey.effectlib.math.Transform;
import org.bukkit.configuration.ConfigurationSection;

public class ConstantTransform
implements Transform {
    private double value;

    public ConstantTransform() {
    }

    public ConstantTransform(double value) {
        this.value = value;
    }

    @Override
    public void load(ConfigurationSection parameters) {
        this.value = parameters.getDouble("value");
    }

    @Override
    public double get(double t2) {
        return this.value;
    }
}

