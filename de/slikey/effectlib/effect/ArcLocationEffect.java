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

public class ArcLocationEffect
extends LocationEffect {
    protected final Vector link;
    protected final float length;
    public ParticleEffect particle = ParticleEffect.FLAME;
    public float height = 2.0f;
    public int particles = 100;
    protected int step = 0;

    public ArcLocationEffect(EffectManager effectManager, Location start, Location stop) {
        super(effectManager, start);
        this.link = stop.toVector().subtract(start.toVector());
        this.length = (float)this.link.length();
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        float pitch = (float)((double)(4.0f * this.height) / Math.pow(this.length, 2.0));
        for (int i2 = 0; i2 < this.particles; ++i2) {
            Vector v2 = this.link.clone().normalize().multiply(this.length * (float)i2 / (float)this.particles);
            float x2 = (float)i2 / (float)this.particles * this.length - this.length / 2.0f;
            float y2 = (float)((double)(-pitch) * Math.pow(x2, 2.0) + (double)this.height);
            this.location.add(v2).add(0.0, (double)y2, 0.0);
            this.particle.display(this.location, this.visibleRange);
            this.location.subtract(0.0, (double)y2, 0.0).subtract(v2);
            ++this.step;
        }
    }
}

