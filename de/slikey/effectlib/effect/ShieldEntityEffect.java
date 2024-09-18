/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.EntityEffect;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class ShieldEntityEffect
extends EntityEffect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public int radius = 3;
    public int particles = 50;
    public boolean sphere = false;

    public ShieldEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.REPEATING;
        this.iterations = 500;
        this.period = 1;
    }

    @Override
    public void onRun() {
        Location location = this.entity.getLocation();
        for (int i2 = 0; i2 < this.particles; ++i2) {
            Vector vector = RandomUtils.getRandomVector().multiply(this.radius);
            if (!this.sphere) {
                vector.setY(Math.abs(vector.getY()));
            }
            location.add(vector);
            this.particle.display(location, this.visibleRange);
            location.subtract(vector);
        }
    }
}

