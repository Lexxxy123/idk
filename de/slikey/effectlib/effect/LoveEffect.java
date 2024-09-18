/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;

public class LoveEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.HEART;

    public LoveEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 600;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        location.add(RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * 0.6));
        location.add(0.0, (double)(RandomUtils.random.nextFloat() * 2.0f), 0.0);
        this.display(this.particle, location);
    }
}

