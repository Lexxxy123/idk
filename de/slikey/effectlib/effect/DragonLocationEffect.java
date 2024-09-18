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
import de.slikey.effectlib.util.RandomUtils;
import de.slikey.effectlib.util.VectorUtils;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class DragonLocationEffect
extends LocationEffect {
    protected final List<Float> rndF;
    protected final List<Double> rndAngle;
    public ParticleEffect particle = ParticleEffect.FLAME;
    public float pitch = 0.1f;
    public int arcs = 20;
    public int particles = 30;
    public int stepsPerIteration = 2;
    public float length = 4.0f;
    protected int step = 0;

    public DragonLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 200;
        this.rndF = new ArrayList<Float>(this.arcs);
        this.rndAngle = new ArrayList<Double>(this.arcs);
    }

    @Override
    public void onRun() {
        for (int j2 = 0; j2 < this.stepsPerIteration; ++j2) {
            if (this.step % this.particles == 0) {
                this.rndF.clear();
                this.rndAngle.clear();
            }
            while (this.rndF.size() < this.arcs) {
                this.rndF.add(Float.valueOf(RandomUtils.random.nextFloat()));
            }
            while (this.rndAngle.size() < this.arcs) {
                this.rndAngle.add(RandomUtils.getRandomAngle());
            }
            for (int i2 = 0; i2 < this.arcs; ++i2) {
                float pitch = this.rndF.get(i2).floatValue() * 2.0f * this.pitch - this.pitch;
                float x2 = (float)(this.step % this.particles) * this.length / (float)this.particles;
                float y2 = (float)((double)pitch * Math.pow(x2, 2.0));
                Vector v2 = new Vector(x2, y2, 0.0f);
                VectorUtils.rotateAroundAxisX(v2, this.rndAngle.get(i2));
                VectorUtils.rotateAroundAxisZ(v2, -this.location.getPitch() * ((float)Math.PI / 180));
                VectorUtils.rotateAroundAxisY(v2, -(this.location.getYaw() + 90.0f) * ((float)Math.PI / 180));
                this.particle.display(this.location.add(v2), (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 1);
                this.location.subtract(v2);
            }
            ++this.step;
        }
    }
}

