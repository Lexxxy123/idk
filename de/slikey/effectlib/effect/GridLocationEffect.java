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
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class GridLocationEffect
extends LocationEffect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public int rows = 5;
    public int columns = 10;
    public float widthCell = 1.0f;
    public float heightCell = 1.0f;
    public int particlesWidth = 4;
    public int particlesHeight = 3;
    public double rotation = 0.0;

    public GridLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.INSTANT;
        this.period = 5;
        this.iterations = 50;
    }

    @Override
    public void onRun() {
        int j2;
        int i2;
        Vector v2 = new Vector();
        for (i2 = 0; i2 <= this.rows + 1; ++i2) {
            for (j2 = 0; j2 < this.particlesWidth * (this.columns + 1); ++j2) {
                v2.setY((float)i2 * this.heightCell);
                v2.setX((float)j2 * this.widthCell / (float)this.particlesWidth);
                this.addParticle(v2);
            }
        }
        for (i2 = 0; i2 <= this.columns + 1; ++i2) {
            for (j2 = 0; j2 < this.particlesHeight * (this.rows + 1); ++j2) {
                v2.setX((float)i2 * this.widthCell);
                v2.setY((float)j2 * this.heightCell / (float)this.particlesHeight);
                this.addParticle(v2);
            }
        }
    }

    protected void addParticle(Vector v2) {
        v2.setZ(0);
        VectorUtils.rotateAroundAxisY(v2, this.rotation);
        this.location.add(v2);
        this.particle.display(this.location, (double)this.visibleRange, 0.0f, 0.0f, 0.0f, 0.0f, 0);
        this.location.subtract(v2);
    }
}

