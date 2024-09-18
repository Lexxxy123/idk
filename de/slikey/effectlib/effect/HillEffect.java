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

public class HillEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public float height = 2.5f;
    public float particles = 30.0f;
    public float edgeLength = 6.5f;
    public double yRotation = 0.4487989505128276;

    public HillEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 10;
        this.iterations = 20;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        Vector v2 = new Vector();
        int x2 = 0;
        while ((float)x2 <= this.particles) {
            double y1 = Math.sin(Math.PI * (double)x2 / (double)this.particles);
            int z2 = 0;
            while ((float)z2 <= this.particles) {
                double y2 = Math.sin(Math.PI * (double)z2 / (double)this.particles);
                v2.setX(this.edgeLength * (float)x2 / this.particles).setZ(this.edgeLength * (float)z2 / this.particles);
                v2.setY((double)this.height * y1 * y2);
                VectorUtils.rotateAroundAxisY(v2, this.yRotation);
                this.display(this.particle, location.add(v2));
                location.subtract(v2);
                ++z2;
            }
            ++x2;
        }
    }
}

