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

public class FlameEntityEffect
extends EntityEffect {
    public FlameEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 600;
    }

    @Override
    public void onRun() {
        for (int i2 = 0; i2 < 10; ++i2) {
            Location location = this.entity.getLocation();
            Vector v2 = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * 0.6);
            v2.setY((double)RandomUtils.random.nextFloat() * 1.8);
            location.add(v2);
            ParticleEffect.FLAME.display(location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 0);
            location.subtract(v2);
        }
    }
}

