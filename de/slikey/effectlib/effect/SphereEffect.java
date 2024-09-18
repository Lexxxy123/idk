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
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class SphereEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.SPELL_MOB;
    public double radius = 0.6;
    public double yOffset = 0.0;
    public int particles = 50;

    public SphereEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.iterations = 500;
        this.period = 1;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        location.add(0.0, this.yOffset, 0.0);
        for (int i2 = 0; i2 < this.particles; ++i2) {
            Vector vector = RandomUtils.getRandomVector().multiply(this.radius);
            location.add(vector);
            this.display(this.particle, location);
            location.subtract(vector);
        }
    }
}

