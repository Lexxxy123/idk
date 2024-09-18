/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Location;

public class IconEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.VILLAGER_ANGRY;
    public int yOffset = 2;

    public IconEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 4;
        this.iterations = 25;
    }

    @Override
    public void onRun() {
        Location location = this.getLocation();
        location.add(0.0, (double)this.yOffset, 0.0);
        this.display(this.particle, location);
    }
}

