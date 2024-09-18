/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.xenondevs.particle.data.color;

import xyz.xenondevs.particle.ParticleEffect;
import xyz.xenondevs.particle.data.color.ParticleColor;
import xyz.xenondevs.particle.utils.MathUtils;

public final class NoteColor
extends ParticleColor {
    public NoteColor(int note) {
        super(MathUtils.getMaxOrMin(note, 24, 0), 0, 0);
        this.setEffect(ParticleEffect.NOTE);
    }

    @Override
    public void setEffect(ParticleEffect effect) {
        super.setEffect(ParticleEffect.NOTE);
    }

    @Override
    public float getRed() {
        return super.getRed() / 24.0f;
    }

    @Override
    public float getGreen() {
        return 0.0f;
    }

    @Override
    public float getBlue() {
        return 0.0f;
    }

    @Override
    public Object toNMSData() {
        return new int[0];
    }

    public static NoteColor random() {
        return new NoteColor(MathUtils.generateRandomInteger(0, 24));
    }
}

