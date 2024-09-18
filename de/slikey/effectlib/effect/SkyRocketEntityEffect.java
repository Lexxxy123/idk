/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Entity
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.effect.JumpEntityEffect;
import org.bukkit.entity.Entity;

public class SkyRocketEntityEffect
extends JumpEntityEffect {
    public SkyRocketEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.power = 10.0f;
    }
}

