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
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class FlameEffect
extends Effect {
    public FlameEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 600;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        for (int i2 = 0; i2 < 10; ++i2) {
            Vector v2 = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * 0.6);
            v2.setY((double)RandomUtils.random.nextFloat() * 1.8);
            location.add(v2);
            ParticleEffect.FLAME.display(location, this.visibleRange);
            location.subtract(v2);
        }
    }
}

