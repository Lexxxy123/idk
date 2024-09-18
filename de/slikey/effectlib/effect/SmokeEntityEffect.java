/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.EntityEffect;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class SmokeEntityEffect
extends EntityEffect {
    public ParticleEffect particle = ParticleEffect.SMOKE;

    public SmokeEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 300;
    }

    @Override
    public void onRun() {
        for (int i2 = 0; i2 < 20; ++i2) {
            Location location = this.entity.getLocation();
            location.add(RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * 0.6));
            location.add(0.0, (double)(RandomUtils.random.nextFloat() * 2.0f), 0.0);
            this.particle.display(location, this.visibleRange);
        }
    }
}

