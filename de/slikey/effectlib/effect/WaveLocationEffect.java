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
import de.slikey.effectlib.util.VectorUtils;
import java.util.Collection;
import java.util.HashSet;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class WaveLocationEffect
extends LocationEffect {
    public final Vector velocity = new Vector();
    protected final Collection<Vector> waterCache;
    protected final Collection<Vector> cloudCache;
    public int particlesFront = 10;
    public int particlesBack = 10;
    public int rows = 20;
    public float lengthFront = 1.5f;
    public float lengthBack = 3.0f;
    public float depthFront = 1.0f;
    public float heightBack = 0.5f;
    public float height = 2.0f;
    public float width = 5.0f;
    protected boolean firstStep = true;

    public WaveLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 5;
        this.iterations = 50;
        this.velocity.copy(location.getDirection().setY(0).normalize().multiply(0.2));
        this.waterCache = new HashSet<Vector>();
        this.cloudCache = new HashSet<Vector>();
    }

    public void invalidate() {
        Vector vec;
        float z2;
        int j2;
        Vector v2;
        float y2;
        float x2;
        float ratio;
        int i2;
        this.firstStep = false;
        this.waterCache.clear();
        this.cloudCache.clear();
        Vector s1 = new Vector(-this.lengthFront, 0.0f, 0.0f);
        Vector s2 = new Vector(this.lengthBack, 0.0f, 0.0f);
        Vector h2 = new Vector(-0.5 * (double)this.lengthFront, (double)this.height, 0.0);
        Vector s1ToH = h2.clone().subtract(s1);
        Vector c1 = s1.clone().add(s1ToH.clone().multiply(0.5));
        float len_s1ToH = (float)s1ToH.length();
        Vector n_s1ToH = s1ToH.clone().multiply(1.0f / len_s1ToH);
        Vector n1 = new Vector(s1ToH.getY(), -s1ToH.getX(), 0.0).normalize();
        if (n1.getX() < 0.0) {
            n1.multiply(-1);
        }
        Vector s2ToH = h2.clone().subtract(s2);
        Vector c2 = s2.clone().add(s2ToH.clone().multiply(0.5));
        float len_s2ToH = (float)s2ToH.length();
        Vector n_s2ToH = s2ToH.clone().multiply(1.0f / len_s2ToH);
        Vector n2 = new Vector(s2ToH.getY(), -s2ToH.getX(), 0.0).normalize();
        if (n2.getX() < 0.0) {
            n2.multiply(-1);
        }
        float yaw = (-this.location.getYaw() + 90.0f) * ((float)Math.PI / 180);
        for (i2 = 0; i2 < this.particlesFront; ++i2) {
            ratio = (float)i2 / (float)this.particlesFront;
            x2 = (ratio - 0.5f) * len_s1ToH;
            y2 = (float)((double)(-this.depthFront) / Math.pow(len_s1ToH / 2.0f, 2.0) * Math.pow(x2, 2.0) + (double)this.depthFront);
            v2 = c1.clone();
            v2.add(n_s1ToH.clone().multiply(x2));
            v2.add(n1.clone().multiply(y2));
            for (j2 = 0; j2 < this.rows; ++j2) {
                z2 = ((float)j2 / (float)this.rows - 0.5f) * this.width;
                vec = v2.clone().setZ(v2.getZ() + (double)z2);
                VectorUtils.rotateAroundAxisY(vec, yaw);
                if (i2 == 0 || i2 == this.particlesFront - 1) {
                    this.cloudCache.add(vec);
                    continue;
                }
                this.waterCache.add(vec);
            }
        }
        for (i2 = 0; i2 < this.particlesBack; ++i2) {
            ratio = (float)i2 / (float)this.particlesBack;
            x2 = (ratio - 0.5f) * len_s2ToH;
            y2 = (float)((double)(-this.heightBack) / Math.pow(len_s2ToH / 2.0f, 2.0) * Math.pow(x2, 2.0) + (double)this.heightBack);
            v2 = c2.clone();
            v2.add(n_s2ToH.clone().multiply(x2));
            v2.add(n2.clone().multiply(y2));
            for (j2 = 0; j2 < this.rows; ++j2) {
                z2 = ((float)j2 / (float)this.rows - 0.5f) * this.width;
                vec = v2.clone().setZ(v2.getZ() + (double)z2);
                VectorUtils.rotateAroundAxisY(vec, yaw);
                if (i2 == this.particlesFront - 1) {
                    this.cloudCache.add(vec);
                    continue;
                }
                this.waterCache.add(vec);
            }
        }
    }

    @Override
    public void onRun() {
        if (this.firstStep) {
            this.invalidate();
        }
        this.location.add(this.velocity);
        for (Vector v2 : this.cloudCache) {
            this.location.add(v2);
            ParticleEffect.CLOUD.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 1);
            this.location.subtract(v2);
        }
        for (Vector v2 : this.waterCache) {
            this.location.add(v2);
            ParticleEffect.DRIP_WATER.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 1);
            this.location.subtract(v2);
        }
    }
}

