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
import de.slikey.effectlib.util.MathUtils;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class AnimatedBallEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.SPELL_WITCH;
    public int particles = 150;
    public int particlesPerIteration = 10;
    public float size = 1.0f;
    public float xFactor = 1.0f;
    public float yFactor = 2.0f;
    public float zFactor = 1.0f;
    public float xOffset;
    public float yOffset = 0.8f;
    public float zOffset;
    public double xRotation;
    public double yRotation;
    public double zRotation = 0.0;
    protected int step;

    public AnimatedBallEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.iterations = 500;
        this.period = 1;
    }

    @Override
    public void onRun() {
        Vector vector = new Vector();
        Location location = this.getLocation();
        for (int i2 = 0; i2 < this.particlesPerIteration; ++i2) {
            ++this.step;
            float t2 = (float)Math.PI / (float)this.particles * (float)this.step;
            float r2 = MathUtils.sin(t2) * this.size;
            float s2 = (float)Math.PI * 2 * t2;
            vector.setX(this.xFactor * r2 * MathUtils.cos(s2) + this.xOffset);
            vector.setZ(this.zFactor * r2 * MathUtils.sin(s2) + this.zOffset);
            vector.setY(this.yFactor * this.size * MathUtils.cos(t2) + this.yOffset);
            VectorUtils.rotateVector(vector, this.xRotation, this.yRotation, this.zRotation);
            this.display(this.particle, location.add(vector));
            location.subtract(vector);
        }
    }
}

