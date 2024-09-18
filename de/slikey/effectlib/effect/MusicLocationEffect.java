/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.LocationEffect;
import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class MusicLocationEffect
extends LocationEffect {
    public ParticleEffect particle = ParticleEffect.NOTE;
    public double radialsPerStep = 0.39269908169872414;
    public float radius = 0.4f;
    protected float step = 0.0f;

    public MusicLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.iterations = 500;
        this.period = 4;
    }

    @Override
    public void onRun() {
        Vector v2 = new Vector(Math.cos(this.radialsPerStep * (double)this.step) * (double)this.radius, (double)0.2f, Math.sin(this.radialsPerStep * (double)this.step) * (double)this.radius);
        this.location.add(v2);
        this.particle.display(this.location, this.visibleRange);
        this.location.subtract(v2);
        this.step += 1.0f;
    }
}

