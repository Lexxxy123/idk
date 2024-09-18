/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Effect
 *  org.bukkit.EntityEffect
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.EntityEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class BleedEntityEffect
extends EntityEffect {
    public boolean hurt = true;
    @Deprecated
    public int duration = 10;
    public int color = 152;

    public BleedEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.REPEATING;
        this.period = 4;
        this.iterations = 25;
    }

    @Override
    public void onRun() {
        Location spawn = this.entity.getLocation();
        spawn.add(0.0, (double)(RandomUtils.random.nextFloat() * 1.75f), 0.0);
        spawn.getWorld().playEffect(spawn, Effect.STEP_SOUND, this.color);
        if (this.hurt) {
            this.entity.playEffect(org.bukkit.EntityEffect.HURT);
        }
    }
}

