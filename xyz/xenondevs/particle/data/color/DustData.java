/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.xenondevs.particle.data.color;

import java.awt.Color;
import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.ParticleEffect;
import xyz.xenondevs.particle.PropertyType;
import xyz.xenondevs.particle.data.color.RegularColor;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public class DustData
extends RegularColor {
    private final float size;

    public DustData(Color color, float size) {
        super(color);
        this.size = size;
    }

    public DustData(int red, int green, int blue, float size) {
        super(red, green, blue);
        this.size = size;
    }

    public float getSize() {
        return this.size;
    }

    @Override
    public Object toNMSData() {
        try {
            if (ReflectionUtils.MINECRAFT_VERSION < 13.0 || this.getEffect() == null || !this.getEffect().hasProperty(PropertyType.DUST)) {
                return new int[0];
            }
            if (ReflectionUtils.MINECRAFT_VERSION < 17.0 && this.getEffect() == ParticleEffect.REDSTONE) {
                return ParticleConstants.PARTICLE_PARAM_REDSTONE_CONSTRUCTOR.newInstance(Float.valueOf(this.getRed()), Float.valueOf(this.getGreen()), Float.valueOf(this.getBlue()), Float.valueOf(this.getSize()));
            }
            if (ReflectionUtils.MINECRAFT_VERSION >= 17.0) {
                Object colorVector = ReflectionUtils.createVector3fa(this.getRed(), this.getGreen(), this.getBlue());
                return this.getEffect() == ParticleEffect.REDSTONE ? ParticleConstants.PARTICLE_PARAM_REDSTONE_CONSTRUCTOR.newInstance(colorVector, Float.valueOf(this.getSize())) : ParticleConstants.PARTICLE_PARAM_DUST_COLOR_TRANSITION_CONSTRUCTOR.newInstance(colorVector, colorVector, Float.valueOf(this.getSize()));
            }
        } catch (Exception exception) {
            // empty catch block
        }
        return null;
    }
}

