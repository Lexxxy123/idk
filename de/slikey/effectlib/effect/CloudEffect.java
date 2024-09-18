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
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class CloudEffect
extends Effect {
    public ParticleEffect cloudParticle = ParticleEffect.CLOUD;
    public Color cloudColor = null;
    public ParticleEffect mainParticle = ParticleEffect.DRIP_WATER;
    public float cloudSize = 0.7f;
    public float particleRadius = this.cloudSize - 0.1f;
    public double yOffset = 0.8;

    public CloudEffect(EffectManager manager) {
        super(manager);
        this.type = EffectType.REPEATING;
        this.period = 5;
        this.iterations = 50;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        location.add(0.0, this.yOffset, 0.0);
        for (int i2 = 0; i2 < 50; ++i2) {
            Vector v2 = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * (double)this.cloudSize);
            this.display(this.cloudParticle, location.add(v2), this.cloudColor, 0.0f, 7);
            location.subtract(v2);
        }
        Location l2 = location.add(0.0, 0.2, 0.0);
        for (int i3 = 0; i3 < 15; ++i3) {
            int r2 = RandomUtils.random.nextInt(2);
            double x2 = RandomUtils.random.nextDouble() * (double)this.particleRadius;
            double z2 = RandomUtils.random.nextDouble() * (double)this.particleRadius;
            l2.add(x2, 0.0, z2);
            if (r2 != 1) {
                this.display(this.mainParticle, l2);
            }
            l2.subtract(x2, 0.0, z2);
            l2.subtract(x2, 0.0, z2);
            if (r2 != 1) {
                this.display(this.mainParticle, l2);
            }
            l2.add(x2, 0.0, z2);
        }
    }
}

