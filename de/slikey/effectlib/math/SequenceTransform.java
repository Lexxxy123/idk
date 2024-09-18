/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.ConfigurationSection
 */
package de.slikey.effectlib.math;

import de.slikey.effectlib.math.Transform;
import de.slikey.effectlib.math.Transforms;
import de.slikey.effectlib.util.ConfigUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.bukkit.configuration.ConfigurationSection;

public class SequenceTransform
implements Transform {
    private List<Sequence> steps;

    @Override
    public void load(ConfigurationSection parameters) {
        this.steps = new ArrayList<Sequence>();
        Collection<ConfigurationSection> stepConfigurations = ConfigUtils.getNodeList(parameters, "steps");
        if (stepConfigurations != null) {
            for (ConfigurationSection stepConfig : stepConfigurations) {
                this.steps.add(new Sequence(stepConfig));
            }
        }
        Collections.reverse(this.steps);
    }

    @Override
    public double get(double t2) {
        double value = 0.0;
        for (Sequence step : this.steps) {
            if (!(step.getStart() <= t2)) continue;
            return step.get(t2);
        }
        return value;
    }

    private class Sequence {
        private final Transform transform;
        private final double start;

        public Sequence(ConfigurationSection configuration) {
            this.transform = Transforms.loadTransform(configuration, "transform");
            this.start = configuration.getDouble("start", 0.0);
        }

        public double getStart() {
            return this.start;
        }

        public double get(double t2) {
            return this.transform.get(t2);
        }
    }
}

