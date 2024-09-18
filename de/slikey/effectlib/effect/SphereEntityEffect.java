/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.EntityEffect;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class SphereEntityEffect
extends EntityEffect {
    public ParticleEffect particle = ParticleEffect.MOB_SPELL;
    public double radius = 0.6;
    public double yOffset = 1.5;
    public int particles = 50;

    public SphereEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.REPEATING;
        this.iterations = 500;
        this.period = 1;
    }

    @Override
    public void onRun() {
        Location location = this.entity.getLocation();
        location.add(0.0, this.yOffset, 0.0);
        for (int i2 = 0; i2 < this.particles; ++i2) {
            Vector v2 = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * this.radius);
            this.particle.display(location.add(v2), this.visibleRange);
            location.subtract(v2);
        }
    }
}

