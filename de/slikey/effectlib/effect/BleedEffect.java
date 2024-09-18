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

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class BleedEffect
extends Effect {
    public boolean hurt = true;
    @Deprecated
    public int duration = 10;
    public int color = 152;

    public BleedEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 4;
        this.iterations = 25;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        location.add(0.0, (double)(RandomUtils.random.nextFloat() * 1.75f), 0.0);
        location.getWorld().playEffect(location, org.bukkit.Effect.STEP_SOUND, this.color);
        Entity entity = this.getEntity();
        if (this.hurt && entity != null) {
            entity.playEffect(EntityEffect.HURT);
        }
    }
}

