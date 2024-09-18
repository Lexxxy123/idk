/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package xyz.xenondevs.particle.data.color;

import xyz.xenondevs.particle.data.ParticleData;

public abstract class ParticleColor
extends ParticleData {
    private final int red;
    private final int green;
    private final int blue;

    ParticleColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public abstract Object toNMSData();

    public float getRed() {
        return this.red;
    }

    public float getGreen() {
        return this.green;
    }

    public float getBlue() {
        return this.blue;
    }
}

