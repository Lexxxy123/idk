/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Color
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class AtomEffect
extends Effect {
    public ParticleEffect particleNucleus = ParticleEffect.DRIP_WATER;
    public Color colorNucleus = null;
    public ParticleEffect particleOrbital = ParticleEffect.DRIP_LAVA;
    public Color colorOrbital = null;
    public double radius = 3.0;
    public float radiusNucleus = 0.2f;
    public int particlesNucleus = 10;
    public int particlesOrbital = 10;
    public int orbitals = 3;
    public double rotation = 0.0;
    public double angularVelocity = 0.039269908169872414;
    protected int step = 0;

    public AtomEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        int i2;
        Location location = this.getLocation();
        for (i2 = 0; i2 < this.particlesNucleus; ++i2) {
            Vector v2 = RandomUtils.getRandomVector().multiply(this.radius * (double)this.radiusNucleus);
            location.add(v2);
            this.display(this.particleNucleus, location, this.colorNucleus);
            location.subtract(v2);
        }
        for (i2 = 0; i2 < this.particlesOrbital; ++i2) {
            double angle = (double)this.step * this.angularVelocity;
            for (int j2 = 0; j2 < this.orbitals; ++j2) {
                double xRotation = Math.PI / (double)this.orbitals * (double)j2;
                Vector v3 = new Vector(Math.cos(angle), Math.sin(angle), 0.0).multiply(this.radius);
                VectorUtils.rotateAroundAxisX(v3, xRotation);
                VectorUtils.rotateAroundAxisY(v3, this.rotation);
                location.add(v3);
                this.display(this.particleOrbital, location, this.colorOrbital);
                location.subtract(v3);
            }
            ++this.step;
        }
    }
}

