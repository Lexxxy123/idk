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

public class CubeEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public float edgeLength = 3.0f;
    public double angularVelocityX = 0.015707963267948967;
    public double angularVelocityY = 0.018479956785822312;
    public double angularVelocityZ = 0.02026833970057931;
    public int particles = 8;
    public boolean enableRotation = true;
    public boolean outlineOnly = true;
    protected int step = 0;

    public CubeEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 5;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        if (this.outlineOnly) {
            this.drawCubeOutline(location);
        } else {
            this.drawCubeWalls(location);
        }
        ++this.step;
    }

    private void drawCubeOutline(Location location) {
        double xRotation = 0.0;
        double yRotation = 0.0;
        double zRotation = 0.0;
        if (this.enableRotation) {
            xRotation = (double)this.step * this.angularVelocityX;
            yRotation = (double)this.step * this.angularVelocityY;
            zRotation = (double)this.step * this.angularVelocityZ;
        }
        float a2 = this.edgeLength / 2.0f;
        Vector v2 = new Vector();
        for (int i2 = 0; i2 < 4; ++i2) {
            double angleY = (double)i2 * Math.PI / 2.0;
            for (int j2 = 0; j2 < 2; ++j2) {
                double angleX = (double)j2 * Math.PI;
                for (int p2 = 0; p2 <= this.particles; ++p2) {
                    v2.setX(a2).setY(a2);
                    v2.setZ(this.edgeLength * (float)p2 / (float)this.particles - a2);
                    VectorUtils.rotateAroundAxisX(v2, angleX);
                    VectorUtils.rotateAroundAxisY(v2, angleY);
                    if (this.enableRotation) {
                        VectorUtils.rotateVector(v2, xRotation, yRotation, zRotation);
                    }
                    this.display(this.particle, location.add(v2));
                    location.subtract(v2);
                }
            }
            for (int p3 = 0; p3 <= this.particles; ++p3) {
                v2.setX(a2).setZ(a2);
                v2.setY(this.edgeLength * (float)p3 / (float)this.particles - a2);
                VectorUtils.rotateAroundAxisY(v2, angleY);
                if (this.enableRotation) {
                    VectorUtils.rotateVector(v2, xRotation, yRotation, zRotation);
                }
                this.display(this.particle, location.add(v2));
                location.subtract(v2);
            }
        }
    }

    private void drawCubeWalls(Location location) {
        double xRotation = 0.0;
        double yRotation = 0.0;
        double zRotation = 0.0;
        if (this.enableRotation) {
            xRotation = (double)this.step * this.angularVelocityX;
            yRotation = (double)this.step * this.angularVelocityY;
            zRotation = (double)this.step * this.angularVelocityZ;
        }
        float a2 = this.edgeLength / 2.0f;
        for (int x2 = 0; x2 <= this.particles; ++x2) {
            float posX = this.edgeLength * ((float)x2 / (float)this.particles) - a2;
            for (int y2 = 0; y2 <= this.particles; ++y2) {
                float posY = this.edgeLength * ((float)y2 / (float)this.particles) - a2;
                for (int z2 = 0; z2 <= this.particles; ++z2) {
                    if (x2 != 0 && x2 != this.particles && y2 != 0 && y2 != this.particles && z2 != 0 && z2 != this.particles) continue;
                    float posZ = this.edgeLength * ((float)z2 / (float)this.particles) - a2;
                    Vector v2 = new Vector(posX, posY, posZ);
                    if (this.enableRotation) {
                        VectorUtils.rotateVector(v2, xRotation, yRotation, zRotation);
                    }
                    this.display(this.particle, location.add(v2));
                    location.subtract(v2);
                }
            }
        }
    }
}

