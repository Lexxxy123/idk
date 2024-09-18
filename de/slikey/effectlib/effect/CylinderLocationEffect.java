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
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class CylinderLocationEffect
extends LocationEffect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public float radius = 1.0f;
    public float height = 3.0f;
    public double angularVelocityX = 0.015707963267948967;
    public double angularVelocityY = 0.018479956785822312;
    public double angularVelocityZ = 0.02026833970057931;
    public double rotationX;
    public double rotationY;
    public double rotationZ;
    public int particles = 100;
    public boolean enableRotation = true;
    public boolean solid = false;
    protected int step = 0;
    protected float sideRatio = 0.0f;

    public CylinderLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        if (this.sideRatio == 0.0f) {
            this.calculateSideRatio();
        }
        Random r2 = RandomUtils.random;
        double xRotation = this.rotationX;
        double yRotation = this.rotationY;
        double zRotation = this.rotationZ;
        if (this.enableRotation) {
            xRotation += (double)this.step * this.angularVelocityX;
            yRotation += (double)this.step * this.angularVelocityY;
            zRotation += (double)this.step * this.angularVelocityZ;
        }
        for (int i2 = 0; i2 < this.particles; ++i2) {
            float multi = this.solid ? r2.nextFloat() : 1.0f;
            Vector v2 = RandomUtils.getRandomCircleVector().multiply(this.radius);
            if (r2.nextFloat() <= this.sideRatio) {
                v2.multiply(multi);
                v2.setY((r2.nextFloat() * 2.0f - 1.0f) * (this.height / 2.0f));
            } else {
                v2.multiply(r2.nextFloat());
                if ((double)r2.nextFloat() < 0.5) {
                    v2.setY(multi * (this.height / 2.0f));
                } else {
                    v2.setY(-multi * (this.height / 2.0f));
                }
            }
            if (this.enableRotation) {
                VectorUtils.rotateVector(v2, xRotation, yRotation, zRotation);
            }
            this.particle.display(this.location.add(v2), this.visibleRange);
            this.location.subtract(v2);
        }
        this.particle.display(this.location, this.visibleRange);
        ++this.step;
    }

    protected void calculateSideRatio() {
        float grounds = 9.869605f * this.radius * 2.0f;
        float side = (float)Math.PI * 2 * this.radius * this.height;
        this.sideRatio = side / (side + grounds);
    }
}

