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
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class DonutLocationEffect
extends LocationEffect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public int particlesCircle = 10;
    public int circles = 36;
    public float radiusDonut = 2.0f;
    public float radiusTube = 0.5f;
    public double xRotation;
    public double yRotation;
    public double zRotation = 0.0;

    public DonutLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 10;
        this.iterations = 20;
    }

    @Override
    public void onRun() {
        Vector v2 = new Vector();
        for (int i2 = 0; i2 < this.circles; ++i2) {
            double theta = Math.PI * 2 * (double)i2 / (double)this.circles;
            for (int j2 = 0; j2 < this.particlesCircle; ++j2) {
                double phi = Math.PI * 2 * (double)j2 / (double)this.particlesCircle;
                double cosPhi = Math.cos(phi);
                v2.setX(((double)this.radiusDonut + (double)this.radiusTube * cosPhi) * Math.cos(theta));
                v2.setY(((double)this.radiusDonut + (double)this.radiusTube * cosPhi) * Math.sin(theta));
                v2.setZ((double)this.radiusTube * Math.sin(phi));
                VectorUtils.rotateVector(v2, this.xRotation, this.yRotation, this.zRotation);
                this.particle.display(this.location.add(v2), (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 0);
                this.location.subtract(v2);
            }
        }
    }
}

