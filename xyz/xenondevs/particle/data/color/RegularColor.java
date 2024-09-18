/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.xenondevs.particle.data.color;

import java.awt.Color;
import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.ParticleEffect;
import xyz.xenondevs.particle.data.color.ParticleColor;
import xyz.xenondevs.particle.utils.MathUtils;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public class RegularColor
extends ParticleColor {
    public RegularColor(Color color) {
        super(color.getRed(), color.getGreen(), color.getBlue());
    }

    public RegularColor(int red, int green, int blue) {
        super(MathUtils.getMaxOrMin(red, 255, 0), MathUtils.getMaxOrMin(green, 255, 0), MathUtils.getMaxOrMin(blue, 255, 0));
    }

    @Override
    public float getRed() {
        return super.getRed() / 255.0f;
    }

    @Override
    public float getGreen() {
        return super.getGreen() / 255.0f;
    }

    @Override
    public float getBlue() {
        return super.getBlue() / 255.0f;
    }

    @Override
    public Object toNMSData() {
        if (ReflectionUtils.MINECRAFT_VERSION < 13.0 || this.getEffect() != ParticleEffect.REDSTONE && this.getEffect() != ParticleEffect.DUST_COLOR_TRANSITION) {
            return new int[0];
        }
        try {
            if (this.getEffect() == ParticleEffect.REDSTONE) {
                return ReflectionUtils.MINECRAFT_VERSION < 17.0 ? ParticleConstants.PARTICLE_PARAM_REDSTONE_CONSTRUCTOR.newInstance(Float.valueOf(this.getRed()), Float.valueOf(this.getGreen()), Float.valueOf(this.getBlue()), Float.valueOf(1.0f)) : ParticleConstants.PARTICLE_PARAM_REDSTONE_CONSTRUCTOR.newInstance(ReflectionUtils.createVector3fa(this.getRed(), this.getGreen(), this.getBlue()), Float.valueOf(1.0f));
            }
            if (ReflectionUtils.MINECRAFT_VERSION < 17.0) {
                return null;
            }
            Object colorVector = ReflectionUtils.createVector3fa(this.getRed(), this.getGreen(), this.getBlue());
            return ParticleConstants.PARTICLE_PARAM_DUST_COLOR_TRANSITION_CONSTRUCTOR.newInstance(colorVector, colorVector, Float.valueOf(1.0f));
        } catch (Exception ex) {
            return null;
        }
    }

    public static RegularColor random() {
        return RegularColor.random(true);
    }

    public static RegularColor random(boolean highSaturation) {
        if (highSaturation) {
            return RegularColor.fromHSVHue(MathUtils.generateRandomInteger(0, 360));
        }
        return new RegularColor(new Color(MathUtils.RANDOM.nextInt(256), MathUtils.RANDOM.nextInt(256), MathUtils.RANDOM.nextInt(256)));
    }

    public static RegularColor fromHSVHue(int hue) {
        return new RegularColor(new Color(Color.HSBtoRGB((float)hue / 360.0f, 1.0f, 1.0f)));
    }
}

