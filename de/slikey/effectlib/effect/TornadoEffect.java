/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Color
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import java.util.ArrayList;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class TornadoEffect
extends Effect {
    public ParticleEffect tornadoParticle = ParticleEffect.FLAME;
    public Color tornadoColor = null;
    public ParticleEffect cloudParticle = ParticleEffect.CLOUD;
    public Color cloudColor = null;
    public float cloudSize = 2.5f;
    public double yOffset = 0.8;
    public float tornadoHeight = 5.0f;
    public float maxTornadoRadius = 5.0f;
    public boolean showCloud = true;
    public boolean showTornado = true;
    public double distance = 0.375;
    protected int step = 0;

    public TornadoEffect(EffectManager manager) {
        super(manager);
        this.type = EffectType.REPEATING;
        this.period = 5;
        this.iterations = 20;
    }

    @Override
    public void onRun() {
        Location l2 = this.getLocation().add(0.0, this.yOffset, 0.0);
        int i2 = 0;
        while ((float)i2 < 100.0f * this.cloudSize) {
            Vector v2 = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * (double)this.cloudSize);
            if (this.showCloud) {
                this.display(this.cloudParticle, l2.add(v2), this.cloudColor, 0.0f, 7);
                l2.subtract(v2);
            }
            ++i2;
        }
        Location t2 = l2.clone().add(0.0, 0.2, 0.0);
        double r2 = 0.45 * ((double)this.maxTornadoRadius * (2.35 / (double)this.tornadoHeight));
        for (double y2 = 0.0; y2 < (double)this.tornadoHeight; y2 += this.distance) {
            double fr = r2 * y2;
            if (fr > (double)this.maxTornadoRadius) {
                fr = this.maxTornadoRadius;
            }
            for (Vector v3 : this.createCircle(y2, fr)) {
                if (!this.showTornado) continue;
                this.display(this.tornadoParticle, t2.add(v3), this.tornadoColor);
                t2.subtract(v3);
                ++this.step;
            }
        }
        l2.subtract(0.0, this.yOffset, 0.0);
    }

    public ArrayList<Vector> createCircle(double y2, double radius) {
        double amount = radius * 64.0;
        double inc = Math.PI * 2 / amount;
        ArrayList<Vector> vecs = new ArrayList<Vector>();
        int i2 = 0;
        while ((double)i2 < amount) {
            double angle = (double)i2 * inc;
            double x2 = radius * Math.cos(angle);
            double z2 = radius * Math.sin(angle);
            Vector v2 = new Vector(x2, y2, z2);
            vecs.add(v2);
            ++i2;
        }
        return vecs;
    }
}

