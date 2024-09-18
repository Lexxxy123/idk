/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Location;

public class WarpEffect
extends Effect {
    public float radius = 1.0f;
    public int particles = 20;
    public ParticleEffect particle = ParticleEffect.FIREWORKS_SPARK;
    public float grow = 0.2f;
    public int rings = 12;
    protected int step = 0;

    public WarpEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = this.rings;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        if (this.step > this.rings) {
            this.step = 0;
        }
        double y2 = (float)this.step * this.grow;
        location.add(0.0, y2, 0.0);
        for (int i2 = 0; i2 < this.particles; ++i2) {
            double angle = Math.PI * 2 * (double)i2 / (double)this.particles;
            double x2 = Math.cos(angle) * (double)this.radius;
            double z2 = Math.sin(angle) * (double)this.radius;
            location.add(x2, 0.0, z2);
            this.display(this.particle, location);
            location.subtract(x2, 0.0, z2);
        }
        location.subtract(0.0, y2, 0.0);
        ++this.step;
    }
}

