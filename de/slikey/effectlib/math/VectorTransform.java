/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.configuration.ConfigurationSection
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.math;

import de.slikey.effectlib.math.Transform;
import de.slikey.effectlib.math.Transforms;
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.util.Vector;

public class VectorTransform {
    private Transform xTransform;
    private Transform yTransform;
    private Transform zTransform;
    private boolean orient;

    public VectorTransform(ConfigurationSection configuration) {
        this.xTransform = Transforms.loadTransform(configuration, "x");
        this.yTransform = Transforms.loadTransform(configuration, "y");
        this.zTransform = Transforms.loadTransform(configuration, "z");
        this.orient = configuration.getBoolean("orient", true);
    }

    public Vector get(Location source, double t2) {
        Double xValue = this.xTransform.get(t2);
        Double yValue = this.yTransform.get(t2);
        Double zValue = this.zTransform.get(t2);
        Vector result = new Vector(xValue.doubleValue(), yValue.doubleValue(), zValue.doubleValue());
        if (this.orient && source != null) {
            result = VectorUtils.rotateVector(result, source);
        }
        return result;
    }
}

