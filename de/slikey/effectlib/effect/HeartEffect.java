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
import de.slikey.effectlib.util.MathUtils;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class HeartEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.CRIT_MAGIC;
    public int particles = 50;
    public double xRotation;
    public double yRotation;
    public double zRotation = 0.0;
    public double yFactor = 1.0;
    public double xFactor = 1.0;
    public double factorInnerSpike = 0.8;
    public double compressYFactorTotal = 2.0;
    public float compilaction = 2.0f;

    public HeartEffect(EffectManager effectManager) {
        super(effectManager);
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        Vector vector = new Vector();
        for (int i2 = 0; i2 < this.particles; ++i2) {
            float alpha = (float)Math.PI / this.compilaction / (float)this.particles * (float)i2;
            double phi = Math.pow((double)Math.abs(MathUtils.sin(2.0f * this.compilaction * alpha)) + this.factorInnerSpike * (double)Math.abs(MathUtils.sin(this.compilaction * alpha)), 1.0 / this.compressYFactorTotal);
            vector.setY(phi * (double)(MathUtils.sin(alpha) + MathUtils.cos(alpha)) * this.yFactor);
            vector.setZ(phi * (double)(MathUtils.cos(alpha) - MathUtils.sin(alpha)) * this.xFactor);
            VectorUtils.rotateVector(vector, this.xRotation, this.yRotation, this.zRotation);
            this.display(this.particle, location.add(vector));
            location.subtract(vector);
        }
    }
}

