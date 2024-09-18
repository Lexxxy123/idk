/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.LocationEffect;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class FountainLocationEffect
extends LocationEffect {
    public ParticleEffect particle = ParticleEffect.SPLASH;
    public int strands = 10;
    public int particlesStrand = 150;
    public int particlesSpout = 200;
    public float radius = 5.0f;
    public float radiusSpout = 0.1f;
    public float height = 3.0f;
    public float heightSpout = 7.0f;
    public double rotation = 0.7853981633974483;

    public FountainLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 100;
    }

    @Override
    public void onRun() {
        int i2;
        for (i2 = 1; i2 <= this.strands; ++i2) {
            double angle = (double)(2 * i2) * Math.PI / (double)this.strands + this.rotation;
            for (int j2 = 1; j2 <= this.particlesStrand; ++j2) {
                float ratio = (float)j2 / (float)this.particlesStrand;
                double x2 = Math.cos(angle) * (double)this.radius * (double)ratio;
                double y2 = Math.sin(Math.PI * (double)j2 / (double)this.particlesStrand) * (double)this.height;
                double z2 = Math.sin(angle) * (double)this.radius * (double)ratio;
                this.location.add(x2, y2, z2);
                this.particle.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 0);
                this.location.subtract(x2, y2, z2);
            }
        }
        for (i2 = 0; i2 < this.particlesSpout; ++i2) {
            Vector v2 = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextFloat() * this.radius * this.radiusSpout);
            v2.setY(RandomUtils.random.nextFloat() * this.heightSpout);
            this.location.add(v2);
            this.particle.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 0);
            this.location.subtract(v2);
        }
    }
}

