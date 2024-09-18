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

public class LineEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public boolean isZigZag = false;
    public int zigZags = 10;
    public Vector zigZagOffset = new Vector(0.0, 0.1, 0.0);
    public int particles = 100;
    public double length = 0.0;
    protected boolean zag = false;
    protected int step = 0;

    public LineEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 1;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        Location target = null;
        target = this.length > 0.0 ? location.clone().add(location.getDirection().normalize().multiply(this.length)) : this.getTarget();
        double amount = this.particles / this.zigZags;
        if (target == null) {
            this.cancel();
            return;
        }
        Vector link = target.toVector().subtract(location.toVector());
        float length = (float)link.length();
        link.normalize();
        float ratio = length / (float)this.particles;
        Vector v2 = link.multiply(ratio);
        Location loc = location.clone().subtract(v2);
        for (int i2 = 0; i2 < this.particles; ++i2) {
            if (this.isZigZag) {
                if (this.zag) {
                    loc.add(this.zigZagOffset);
                } else {
                    loc.subtract(this.zigZagOffset);
                }
            }
            if ((double)this.step >= amount) {
                this.zag = !this.zag;
                this.step = 0;
            }
            ++this.step;
            loc.add(v2);
            this.display(this.particle, loc);
        }
    }
}

