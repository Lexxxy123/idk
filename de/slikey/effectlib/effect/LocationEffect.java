/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang.Validate
 *  org.bukkit.Location
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import org.apache.commons.lang.Validate;
import org.bukkit.Location;

public abstract class LocationEffect
extends Effect {
    protected final Location location;

    public LocationEffect(EffectManager effectManager, Location location) {
        super(effectManager);
        Validate.notNull((Object)location, (String)"Location cannot be null!");
        this.location = location;
    }
}

