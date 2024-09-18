/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import org.bukkit.entity.Player;

public abstract class PlayerEffect
extends Effect {
    protected final Player player;

    public PlayerEffect(EffectManager effectManager, Player player) {
        super(effectManager);
        this.player = player;
    }
}

