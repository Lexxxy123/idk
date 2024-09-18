/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.LocationEffect;
import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Location;

public class HelixLocationEffect
extends LocationEffect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public int strands = 8;
    public int particles = 80;
    public float radius = 10.0f;
    public float curve = 10.0f;
    public double rotation = 0.7853981633974483;

    public HelixLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 10;
        this.iterations = 8;
    }

    @Override
    public void onRun() {
        for (int i2 = 1; i2 <= this.strands; ++i2) {
            for (int j2 = 1; j2 <= this.particles; ++j2) {
                float ratio = (float)j2 / (float)this.particles;
                double angle = (double)(this.curve * ratio * 2.0f) * Math.PI / (double)this.strands + Math.PI * 2 * (double)i2 / (double)this.strands + this.rotation;
                double x2 = Math.cos(angle) * (double)ratio * (double)this.radius;
                double z2 = Math.sin(angle) * (double)ratio * (double)this.radius;
                this.location.add(x2, 0.0, z2);
                this.particle.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 0);
                this.location.subtract(x2, 0.0, z2);
            }
        }
    }
}

