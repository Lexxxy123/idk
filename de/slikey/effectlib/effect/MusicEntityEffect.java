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

public class MusicEntityEffect
extends EntityEffect {
    public double radialsPerStep = 0.39269908169872414;
    public float radius = 0.4f;
    protected float step = 0.0f;

    public MusicEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.REPEATING;
        this.iterations = 400;
        this.period = 1;
    }

    @Override
    public void onRun() {
        Location location = this.entity.getLocation();
        location.add(0.0, (double)1.9f, 0.0);
        location.add(Math.cos(this.radialsPerStep * (double)this.step) * (double)this.radius, 0.0, Math.sin(this.radialsPerStep * (double)this.step) * (double)this.radius);
        ParticleEffect.NOTE.display(location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.5f, 1);
        this.step += 1.0f;
    }
}

