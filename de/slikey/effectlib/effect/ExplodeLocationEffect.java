/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.Sound
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.LocationEffect;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.Sound;

public class ExplodeLocationEffect
extends LocationEffect {
    public int amount = 25;
    public float speed = 0.5f;

    public ExplodeLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.INSTANT;
    }

    @Override
    public void onRun() {
        this.location.getWorld().playSound(this.location, Sound.EXPLODE, 4.0f, (1.0f + (RandomUtils.random.nextFloat() - RandomUtils.random.nextFloat()) * 0.2f) * 0.7f);
        ParticleEffect.EXPLODE.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, this.speed, this.amount);
        ParticleEffect.HUGE_EXPLOSION.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, this.amount);
    }
}

