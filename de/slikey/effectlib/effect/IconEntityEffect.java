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
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class IconEntityEffect
extends EntityEffect {
    public ParticleEffect particle = ParticleEffect.ANGRY_VILLAGER;
    public int yOffset = 2;

    public IconEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.REPEATING;
        this.period = 4;
        this.iterations = 25;
    }

    @Override
    public void onRun() {
        Location spawn = this.entity.getLocation();
        spawn.add(0.0, (double)this.yOffset, 0.0);
        this.particle.display(spawn, this.visibleRange);
    }
}

