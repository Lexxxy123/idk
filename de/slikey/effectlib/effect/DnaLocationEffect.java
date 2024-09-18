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

public class DnaLocationEffect
extends LocationEffect {
    public ParticleEffect particleHelix = ParticleEffect.FLAME;
    public ParticleEffect particleBase1 = ParticleEffect.WAKE;
    public ParticleEffect particleBase2 = ParticleEffect.RED_DUST;
    public double radials = 0.10471975511965977;
    public float radius = 1.5f;
    public int particlesHelix = 3;
    public int particlesBase = 15;
    public float lenght = 15.0f;
    public float grow = 0.2f;
    public float baseInterval = 10.0f;
    protected int step = 0;

    public DnaLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 500;
    }

    @Override
    public void onRun() {
        for (int j2 = 0; j2 < this.particlesHelix; ++j2) {
            int i2;
            if ((float)this.step * this.grow > this.lenght) {
                this.step = 0;
            }
            for (i2 = 0; i2 < 2; ++i2) {
                double angle = (double)this.step * this.radials + Math.PI * (double)i2;
                Vector v2 = new Vector(Math.cos(angle) * (double)this.radius, (double)((float)this.step * this.grow), Math.sin(angle) * (double)this.radius);
                this.drawParticle(v2, this.particleHelix);
            }
            if ((float)this.step % this.baseInterval == 0.0f) {
                for (i2 = -this.particlesBase; i2 <= this.particlesBase; ++i2) {
                    if (i2 == 0) continue;
                    ParticleEffect particle = this.particleBase1;
                    if (i2 < 0) {
                        particle = this.particleBase2;
                    }
                    double angle = (double)this.step * this.radials;
                    Vector v3 = new Vector(Math.cos(angle), 0.0, Math.sin(angle)).multiply(this.radius * (float)i2 / (float)this.particlesBase).setY((float)this.step * this.grow);
                    this.drawParticle(v3, particle);
                }
            }
            ++this.step;
        }
    }

    protected void drawParticle(Vector v2, ParticleEffect particle) {
        VectorUtils.rotateAroundAxisX(v2, (this.location.getPitch() + 90.0f) * ((float)Math.PI / 180));
        VectorUtils.rotateAroundAxisY(v2, -this.location.getYaw() * ((float)Math.PI / 180));
        this.location.add(v2);
        particle.display(this.location, this.visibleRange);
        this.location.subtract(v2);
    }
}

