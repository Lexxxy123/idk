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

public class LineLocationEffect
extends LocationEffect {
    protected final Vector link;
    protected final float length;
    public ParticleEffect particle = ParticleEffect.FLAME;
    public int particles = 100;

    public LineLocationEffect(EffectManager effectManager, Location start, Location stop) {
        super(effectManager, start);
        this.link = stop.toVector().subtract(start.toVector());
        this.length = (float)this.link.length();
        this.link.normalize();
        this.type = EffectType.INSTANT;
        this.period = 5;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        float ratio = this.length / (float)this.particles;
        Vector v2 = this.link.clone().multiply(ratio);
        Location loc = this.location.clone().subtract(v2);
        for (int i2 = 0; i2 < this.particles; ++i2) {
            loc.add(v2);
            this.particle.display(loc, this.visibleRange);
        }
    }
}

