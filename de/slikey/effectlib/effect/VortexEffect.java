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
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class VortexEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public float radius = 2.0f;
    public float grow = 0.05f;
    public double radials = 0.19634954084936207;
    public int circles = 3;
    public int helixes = 4;
    protected int step = 0;

    public VortexEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 200;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        for (int x2 = 0; x2 < this.circles; ++x2) {
            for (int i2 = 0; i2 < this.helixes; ++i2) {
                double angle = (double)this.step * this.radials + Math.PI * 2 * (double)i2 / (double)this.helixes;
                Vector v2 = new Vector(Math.cos(angle) * (double)this.radius, (double)((float)this.step * this.grow), Math.sin(angle) * (double)this.radius);
                VectorUtils.rotateAroundAxisX(v2, (location.getPitch() + 90.0f) * ((float)Math.PI / 180));
                VectorUtils.rotateAroundAxisY(v2, -location.getYaw() * ((float)Math.PI / 180));
                location.add(v2);
                this.display(this.particle, location);
                location.subtract(v2);
            }
            ++this.step;
        }
    }
}

