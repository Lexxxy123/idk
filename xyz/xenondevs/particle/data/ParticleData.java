/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.xenondevs.particle.data;

import xyz.xenondevs.particle.ParticleEffect;

public abstract class ParticleData {
    private ParticleEffect effect;

    public void setEffect(ParticleEffect effect) {
        this.effect = effect;
    }

    public abstract Object toNMSData();

    public ParticleEffect getEffect() {
        return this.effect;
    }
}

