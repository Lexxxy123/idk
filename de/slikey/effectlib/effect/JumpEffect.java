/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Entity
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class JumpEffect
extends Effect {
    public float power = 0.5f;

    public JumpEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.INSTANT;
        this.period = 20;
        this.iterations = 1;
        this.asynchronous = false;
    }

    @Override
    public void onRun() {
        Entity entity = this.getEntity();
        if (entity == null) {
            this.cancel();
            return;
        }
        Vector v2 = entity.getVelocity();
        v2.setY(v2.getY() + (double)this.power);
        entity.setVelocity(v2);
    }
}

