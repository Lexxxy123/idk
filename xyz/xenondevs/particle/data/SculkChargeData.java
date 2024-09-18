/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.xenondevs.particle.data;

import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.ParticleEffect;
import xyz.xenondevs.particle.data.ParticleData;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public final class SculkChargeData
extends ParticleData {
    private final float roll;

    public SculkChargeData(float roll) {
        this.roll = roll;
    }

    public float getRoll() {
        return this.roll;
    }

    @Override
    public Object toNMSData() {
        if (ReflectionUtils.MINECRAFT_VERSION < 19.0 || this.getEffect() != ParticleEffect.SCULK_CHARGE) {
            return null;
        }
        try {
            return ParticleConstants.PARTICLE_PARAM_SCULK_CHARGE_CONSTRUCTOR.newInstance(Float.valueOf(this.getRoll()));
        } catch (Exception ex) {
            return null;
        }
    }
}

