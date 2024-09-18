/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Entity
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.EntityEffect;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class JumpEntityEffect
extends EntityEffect {
    public float power = 0.5f;

    public JumpEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.INSTANT;
        this.period = 20;
        this.iterations = 1;
    }

    @Override
    public void onRun() {
        Vector v2 = this.entity.getVelocity();
        v2.setY(v2.getY() + (double)this.power);
        this.entity.setVelocity(v2);
    }
}

