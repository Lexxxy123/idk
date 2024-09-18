/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.PlayerEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TurnPlayerEffect
extends PlayerEffect {
    public float step = 11.25f;

    public TurnPlayerEffect(EffectManager effectManager, Player player) {
        super(effectManager, player);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = (int)(1800.0f / this.step);
    }

    @Override
    public void onRun() {
        Location loc = this.player.getLocation();
        loc.setYaw(loc.getYaw() + this.step);
        this.player.teleport(loc);
    }
}

