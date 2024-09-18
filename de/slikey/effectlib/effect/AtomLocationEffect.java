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
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class AtomLocationEffect
extends LocationEffect {
    public ParticleEffect particleNucleus = ParticleEffect.DRIP_WATER;
    public ParticleEffect particleOrbital = ParticleEffect.DRIP_LAVA;
    public int radius = 3;
    public float radiusNucleus = 0.2f;
    public int particlesNucleus = 10;
    public int particlesOrbital = 10;
    public int orbitals = 3;
    public double rotation = 0.0;
    public double angularVelocity = 0.039269908169872414;
    protected int step = 0;

    public AtomLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        int i2;
        for (i2 = 0; i2 < this.particlesNucleus; ++i2) {
            Vector v2 = RandomUtils.getRandomVector().multiply((float)this.radius * this.radiusNucleus);
            this.location.add(v2);
            this.particleNucleus.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 0);
            this.location.subtract(v2);
        }
        for (i2 = 0; i2 < this.particlesOrbital; ++i2) {
            double angle = (double)this.step * this.angularVelocity;
            for (int j2 = 0; j2 < this.orbitals; ++j2) {
                double xRotation = Math.PI / (double)this.orbitals * (double)j2;
                Vector v3 = new Vector(Math.cos(angle), Math.sin(angle), 0.0).multiply(this.radius);
                VectorUtils.rotateAroundAxisX(v3, xRotation);
                VectorUtils.rotateAroundAxisY(v3, this.rotation);
                this.location.add(v3);
                this.particleOrbital.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 0);
                this.location.subtract(v3);
            }
            ++this.step;
        }
    }
}

