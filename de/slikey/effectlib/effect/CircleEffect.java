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
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class CircleEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.VILLAGER_HAPPY;
    public double xRotation;
    public double yRotation;
    public double zRotation = 0.0;
    public double angularVelocityX = 0.015707963267948967;
    public double angularVelocityY = 0.018479956785822312;
    public double angularVelocityZ = 0.02026833970057931;
    public float radius = 0.4f;
    protected float step = 0.0f;
    public double xSubtract;
    public double ySubtract;
    public double zSubtract;
    public boolean enableRotation = true;
    public int particles = 20;

    public CircleEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 50;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        location.subtract(this.xSubtract, this.ySubtract, this.zSubtract);
        double inc = Math.PI * 2 / (double)this.particles;
        double angle = (double)this.step * inc;
        Vector v2 = new Vector();
        v2.setX(Math.cos(angle) * (double)this.radius);
        v2.setZ(Math.sin(angle) * (double)this.radius);
        VectorUtils.rotateVector(v2, this.xRotation, this.yRotation, this.zRotation);
        if (this.enableRotation) {
            VectorUtils.rotateVector(v2, this.angularVelocityX * (double)this.step, this.angularVelocityY * (double)this.step, this.angularVelocityZ * (double)this.step);
        }
        this.display(this.particle, location.add(v2), 0.0f, 30);
        this.step += 1.0f;
    }
}

