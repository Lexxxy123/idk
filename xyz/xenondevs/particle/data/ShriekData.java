/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.xenondevs.particle.data;

import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.ParticleEffect;
import xyz.xenondevs.particle.data.ParticleData;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public final class ShriekData
extends ParticleData {
    private final int delay;

    public ShriekData(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return this.delay;
    }

    @Override
    public Object toNMSData() {
        if (ReflectionUtils.MINECRAFT_VERSION < 19.0 || this.getEffect() != ParticleEffect.SHRIEK) {
            return null;
        }
        try {
            return ParticleConstants.PARTICLE_PARAM_SHRIEK_CONSTRUCTOR.newInstance(this.getDelay());
        } catch (Exception ex) {
            return null;
        }
    }
}

