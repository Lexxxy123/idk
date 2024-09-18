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
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class DnaEffect
extends Effect {
    public ParticleEffect particleHelix = ParticleEffect.FLAME;
    public Color colorHelix = null;
    public ParticleEffect particleBase1 = ParticleEffect.WATER_WAKE;
    public Color colorBase1 = null;
    public ParticleEffect particleBase2 = ParticleEffect.REDSTONE;
    public Color colorBase2 = null;
    public double radials = 0.10471975511965977;
    public float radius = 1.5f;
    public int particlesHelix = 3;
    public int particlesBase = 15;
    public float length = 15.0f;
    public float grow = 0.2f;
    public float baseInterval = 10.0f;
    protected int step = 0;

    public DnaEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 500;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        for (int j2 = 0; j2 < this.particlesHelix; ++j2) {
            int i2;
            if ((float)this.step * this.grow > this.length) {
                this.step = 0;
            }
            for (i2 = 0; i2 < 2; ++i2) {
                double angle = (double)this.step * this.radials + Math.PI * (double)i2;
                Vector v2 = new Vector(Math.cos(angle) * (double)this.radius, (double)((float)this.step * this.grow), Math.sin(angle) * (double)this.radius);
                this.drawParticle(location, v2, this.particleHelix, this.colorHelix);
            }
            if ((float)this.step % this.baseInterval == 0.0f) {
                for (i2 = -this.particlesBase; i2 <= this.particlesBase; ++i2) {
                    if (i2 == 0) continue;
                    ParticleEffect particle = this.particleBase1;
                    Color color = this.colorBase1;
                    if (i2 < 0) {
                        particle = this.particleBase2;
                        color = this.colorBase2;
                    }
                    double angle = (double)this.step * this.radials;
                    Vector v3 = new Vector(Math.cos(angle), 0.0, Math.sin(angle)).multiply(this.radius * (float)i2 / (float)this.particlesBase).setY((float)this.step * this.grow);
                    this.drawParticle(location, v3, particle, color);
                }
            }
            ++this.step;
        }
    }

    protected void drawParticle(Location location, Vector v2, ParticleEffect particle, Color color) {
        VectorUtils.rotateAroundAxisX(v2, (location.getPitch() + 90.0f) * ((float)Math.PI / 180));
        VectorUtils.rotateAroundAxisY(v2, -location.getYaw() * ((float)Math.PI / 180));
        location.add(v2);
        this.display(particle, location, color);
        location.subtract(v2);
    }
}

