/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.MathUtils;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import de.slikey.effectlib.util.VectorUtils;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class EarthEffect
extends Effect {
    public int precision = 100;
    public int particles = 500;
    public float radius = 1.0f;
    public float mountainHeight = 0.5f;
    protected int step = 0;
    protected boolean firstStep = true;
    protected final Set<Vector> cacheGreen;
    protected final Set<Vector> cacheBlue;

    public EarthEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 5;
        this.iterations = 200;
        this.cacheGreen = new HashSet<Vector>();
        this.cacheBlue = new HashSet<Vector>();
    }

    public void invalidate() {
        this.firstStep = false;
        this.cacheGreen.clear();
        this.cacheBlue.clear();
        HashSet<Vector> cache = new HashSet<Vector>();
        int sqrtParticles = (int)Math.sqrt(this.particles);
        float theta = 0.0f;
        float thetaStep = (float)Math.PI / (float)sqrtParticles;
        float phiStep = (float)Math.PI * 2 / (float)sqrtParticles;
        for (int i2 = 0; i2 < sqrtParticles; ++i2) {
            theta += thetaStep;
            float phi = 0.0f;
            for (int j2 = 0; j2 < sqrtParticles; ++j2) {
                float x2 = this.radius * MathUtils.sin(theta) * MathUtils.cos(phi += phiStep);
                float y2 = this.radius * MathUtils.sin(theta) * MathUtils.sin(phi);
                float z2 = this.radius * MathUtils.cos(theta);
                cache.add(new Vector(x2, y2, z2));
            }
        }
        float increase = this.mountainHeight / (float)this.precision;
        for (int i3 = 0; i3 < this.precision; ++i3) {
            double r1 = RandomUtils.getRandomAngle();
            double r2 = RandomUtils.getRandomAngle();
            double r3 = RandomUtils.getRandomAngle();
            for (Vector v2 : cache) {
                if (v2.getY() > 0.0) {
                    v2.setY(v2.getY() + (double)increase);
                } else {
                    v2.setY(v2.getY() - (double)increase);
                }
                if (i3 == this.precision - 1) continue;
                VectorUtils.rotateVector(v2, r1, r2, r3);
            }
        }
        float minSquared = Float.POSITIVE_INFINITY;
        float maxSquared = Float.NEGATIVE_INFINITY;
        for (Vector current : cache) {
            float lengthSquared = (float)current.lengthSquared();
            if (minSquared > lengthSquared) {
                minSquared = lengthSquared;
            }
            if (!(maxSquared < lengthSquared)) continue;
            maxSquared = lengthSquared;
        }
        float average = (minSquared + maxSquared) / 2.0f;
        for (Vector v3 : cache) {
            float lengthSquared = (float)v3.lengthSquared();
            if (lengthSquared >= average) {
                this.cacheGreen.add(v3);
                continue;
            }
            this.cacheBlue.add(v3);
        }
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        if (this.firstStep) {
            this.invalidate();
        }
        for (Vector v2 : this.cacheGreen) {
            ParticleEffect.VILLAGER_HAPPY.display(location.add(v2), (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 3);
            location.subtract(v2);
        }
        for (Vector v2 : this.cacheBlue) {
            ParticleEffect.DRIP_WATER.display(location.add(v2), (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 1);
            location.subtract(v2);
        }
    }
}

