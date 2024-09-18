/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 */
package com.xxmicloxx.NoteBlockAPI.utils;

import org.bukkit.Location;

public class MathUtils {
    private static MathUtils instance;
    private double[] cos = new double[360];
    private double[] sin = new double[360];

    public MathUtils() {
        instance = this;
        for (int deg = 0; deg < 360; ++deg) {
            this.cos[deg] = Math.cos(Math.toRadians(deg));
            this.sin[deg] = Math.sin(Math.toRadians(deg));
        }
    }

    private static double[] getCos() {
        return MathUtils.instance.cos;
    }

    private static double[] getSin() {
        return MathUtils.instance.sin;
    }

    public static Location stereoSourceLeft(Location location, float distance) {
        float yaw = location.getYaw();
        return location.clone().add(-MathUtils.getCos()[(int)(yaw + 360.0f) % 360] * (double)distance, 0.0, -MathUtils.getSin()[(int)(yaw + 360.0f) % 360] * (double)distance);
    }

    public static Location stereoSourceRight(Location location, float distance) {
        float yaw = location.getYaw();
        return location.clone().add(MathUtils.getCos()[(int)(yaw + 360.0f) % 360] * (double)distance, 0.0, MathUtils.getSin()[(int)(yaw + 360.0f) % 360] * (double)distance);
    }

    public static Location stereoPan(Location location, float distance) {
        float yaw = location.getYaw();
        return location.clone().add(MathUtils.getCos()[(int)(yaw + 360.0f) % 360] * (double)distance, 0.0, MathUtils.getSin()[(int)(yaw + 360.0f) % 360] * (double)distance);
    }
}

