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

public class StarEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public int particles = 50;
    public float spikeHeight = 3.5f;
    public int spikesHalf = 3;
    public float innerRadius = 0.5f;

    public StarEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 4;
        this.iterations = 50;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        float radius = 3.0f * this.innerRadius / 1.73205f;
        for (int i2 = 0; i2 < this.spikesHalf * 2; ++i2) {
            double xRotation = (double)i2 * Math.PI / (double)this.spikesHalf;
            for (int x2 = 0; x2 < this.particles; ++x2) {
                double angle = Math.PI * 2 * (double)x2 / (double)this.particles;
                float height = RandomUtils.random.nextFloat() * this.spikeHeight;
                Vector v2 = new Vector(Math.cos(angle), 0.0, Math.sin(angle));
                v2.multiply((this.spikeHeight - height) * radius / this.spikeHeight);
                v2.setY(this.innerRadius + height);
                VectorUtils.rotateAroundAxisX(v2, xRotation);
                location.add(v2);
                this.display(this.particle, location);
                location.subtract(v2);
                VectorUtils.rotateAroundAxisX(v2, Math.PI);
                VectorUtils.rotateAroundAxisY(v2, 1.5707963267948966);
                location.add(v2);
                this.display(this.particle, location);
                location.subtract(v2);
            }
        }
    }
}

