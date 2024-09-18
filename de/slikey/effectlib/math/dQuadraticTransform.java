/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.ConfigurationSection
 */
package de.slikey.effectlib.math;

import de.slikey.effectlib.math.Transform;
import de.slikey.effectlib.math.Transforms;
import org.bukkit.configuration.ConfigurationSection;

public class dQuadraticTransform
implements Transform {
    private Transform a;
    private Transform b;
    private Transform c;

    @Override
    public void load(ConfigurationSection parameters) {
        this.a = Transforms.loadTransform(parameters, "a");
        this.b = Transforms.loadTransform(parameters, "b");
        this.c = Transforms.loadTransform(parameters, "c");
    }

    @Override
    public double get(double t2) {
        return 2.0 * this.a.get(t2) * (t2 + this.b.get(t2)) + this.c.get(t2);
    }
}

