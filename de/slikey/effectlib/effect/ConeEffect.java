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
import de.slikey.effectlib.util.RandomUtils;
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ConeEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public float lengthGrow = 0.05f;
    public double angularVelocity = 0.19634954084936207;
    public int particles = 10;
    public float radiusGrow = 0.006f;
    public int particlesCone = 180;
    public double rotation = 0.0;
    public boolean randomize = false;
    protected int step = 0;

    public ConeEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        for (int x2 = 0; x2 < this.particles; ++x2) {
            if (this.step > this.particlesCone) {
                this.step = 0;
            }
            if (this.randomize && this.step == 0) {
                this.rotation = RandomUtils.getRandomAngle();
            }
            double angle = (double)this.step * this.angularVelocity + this.rotation;
            float radius = (float)this.step * this.radiusGrow;
            float length = (float)this.step * this.lengthGrow;
            Vector v2 = new Vector(Math.cos(angle) * (double)radius, (double)length, Math.sin(angle) * (double)radius);
            VectorUtils.rotateAroundAxisX(v2, (location.getPitch() + 90.0f) * ((float)Math.PI / 180));
            VectorUtils.rotateAroundAxisY(v2, -location.getYaw() * ((float)Math.PI / 180));
            location.add(v2);
            this.display(this.particle, location);
            location.subtract(v2);
            ++this.step;
        }
    }
}

