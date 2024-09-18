/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.ConfigurationSection
 */
package de.slikey.effectlib.math;

import de.slikey.effectlib.math.Transform;
import de.slikey.effectlib.math.Transforms;
import java.util.Collection;
import org.bukkit.configuration.ConfigurationSection;

public class SumTransform
implements Transform {
    private Collection<Transform> inputs;

    @Override
    public void load(ConfigurationSection parameters) {
        this.inputs = Transforms.loadTransformList(parameters, "inputs");
    }

    @Override
    public double get(double t2) {
        double value = 0.0;
        for (Transform transform : this.inputs) {
            value += transform.get(t2);
        }
        return value;
    }
}

