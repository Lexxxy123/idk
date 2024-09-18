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

public class DiscoBallEffect
extends Effect {
    public float sphereRadius = 0.6f;
    public int max = 15;
    public ParticleEffect sphereParticle = ParticleEffect.FLAME;
    public ParticleEffect lineParticle = ParticleEffect.REDSTONE;
    public Color sphereColor = null;
    public Color lineColor = null;
    public int maxLines = 7;
    public int lineParticles = 100;
    public int sphereParticles = 50;
    public Direction direction = Direction.DOWN;

    public DiscoBallEffect(EffectManager manager) {
        super(manager);
        this.type = EffectType.REPEATING;
        this.period = 7;
        this.iterations = 500;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        int mL = RandomUtils.random.nextInt(this.maxLines - 2) + 2;
        for (int m2 = 0; m2 < mL * 2; ++m2) {
            double x2 = RandomUtils.random.nextInt(this.max - this.max * -1) + this.max * -1;
            double y2 = RandomUtils.random.nextInt(this.max - this.max * -1) + this.max * -1;
            double z2 = RandomUtils.random.nextInt(this.max - this.max * -1) + this.max * -1;
            if (this.direction == Direction.DOWN) {
                y2 = RandomUtils.random.nextInt(this.max * 2 - this.max) + this.max;
            } else if (this.direction == Direction.UP) {
                y2 = RandomUtils.random.nextInt(this.max * -1 - this.max * -2) + this.max * -2;
            }
            Location target = location.clone().subtract(x2, y2, z2);
            if (target == null) {
                this.cancel();
                return;
            }
            Vector link = target.toVector().subtract(location.toVector());
            float length = (float)link.length();
            link.normalize();
            float ratio = length / (float)this.lineParticles;
            Vector v2 = link.multiply(ratio);
            Location loc = location.clone().subtract(v2);
            for (int i2 = 0; i2 < this.lineParticles; ++i2) {
                loc.add(v2);
                this.display(this.lineParticle, loc, this.lineColor);
            }
        }
        for (int i3 = 0; i3 < this.sphereParticles; ++i3) {
            Vector vector = RandomUtils.getRandomVector().multiply(this.sphereRadius);
            location.add(vector);
            this.display(this.sphereParticle, location, this.sphereColor);
            location.subtract(vector);
        }
    }

    public static enum Direction {
        UP,
        DOWN,
        BOTH;

    }
}

