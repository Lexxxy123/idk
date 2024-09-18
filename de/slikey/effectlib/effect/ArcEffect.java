/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ArcEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public float height = 2.0f;
    public int particles = 100;
    protected int step = 0;

    public ArcEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        Location target = this.getTarget();
        if (target == null) {
            this.cancel();
            return;
        }
        Vector link = target.toVector().subtract(location.toVector());
        float length = (float)link.length();
        float pitch = (float)((double)(4.0f * this.height) / Math.pow(length, 2.0));
        for (int i2 = 0; i2 < this.particles; ++i2) {
            Vector v2 = link.clone().normalize().multiply(length * (float)i2 / (float)this.particles);
            float x2 = (float)i2 / (float)this.particles * length - length / 2.0f;
            float y2 = (float)((double)(-pitch) * Math.pow(x2, 2.0) + (double)this.height);
            location.add(v2).add(0.0, (double)y2, 0.0);
            this.display(this.particle, location);
            location.subtract(0.0, (double)y2, 0.0).subtract(v2);
            ++this.step;
        }
    }
}

