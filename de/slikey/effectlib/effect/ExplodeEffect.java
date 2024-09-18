/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.Sound
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.Sound;

public class ExplodeEffect
extends Effect {
    public int amount = 25;
    public float speed = 0.5f;
    public Sound sound = Sound.EXPLODE;

    public ExplodeEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.INSTANT;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        location.getWorld().playSound(location, this.sound, 4.0f, (1.0f + (RandomUtils.random.nextFloat() - RandomUtils.random.nextFloat()) * 0.2f) * 0.7f);
        ParticleEffect.EXPLOSION_NORMAL.display(location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, this.speed, this.amount);
        ParticleEffect.EXPLOSION_HUGE.display(location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, this.amount);
    }
}

