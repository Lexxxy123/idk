/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.util.org.apache.commons.lang3.Validate
 *  org.bukkit.entity.Entity
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import net.minecraft.util.org.apache.commons.lang3.Validate;
import org.bukkit.entity.Entity;

public abstract class EntityEffect
extends Effect {
    protected final Entity entity;

    public EntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager);
        Validate.notNull((Object)entity, (String)"Entity cannot be null!", (Object[])new Object[0]);
        this.entity = entity;
    }
}

