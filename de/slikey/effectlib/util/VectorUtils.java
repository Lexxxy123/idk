/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.util;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public final class VectorUtils {
    private VectorUtils() {
    }

    public static final Vector rotateAroundAxisX(Vector v2, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double y2 = v2.getY() * cos - v2.getZ() * sin;
        double z2 = v2.getY() * sin + v2.getZ() * cos;
        return v2.setY(y2).setZ(z2);
    }

    public static final Vector rotateAroundAxisY(Vector v2, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x2 = v2.getX() * cos + v2.getZ() * sin;
        double z2 = v2.getX() * -sin + v2.getZ() * cos;
        return v2.setX(x2).setZ(z2);
    }

    public static final Vector rotateAroundAxisZ(Vector v2, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double x2 = v2.getX() * cos - v2.getY() * sin;
        double y2 = v2.getX() * sin + v2.getY() * cos;
        return v2.setX(x2).setY(y2);
    }

    public static final Vector rotateVector(Vector v2, double angleX, double angleY, double angleZ) {
        VectorUtils.rotateAroundAxisX(v2, angleX);
        VectorUtils.rotateAroundAxisY(v2, angleY);
        VectorUtils.rotateAroundAxisZ(v2, angleZ);
        return v2;
    }

    public static final Vector rotateVector(Vector v2, Location location) {
        return VectorUtils.rotateVector(v2, location.getYaw(), location.getPitch());
    }

    public static final Vector rotateVector(Vector v2, float yawDegrees, float pitchDegrees) {
        double yaw = Math.toRadians(-1.0f * (yawDegrees + 90.0f));
        double pitch = Math.toRadians(-pitchDegrees);
        double cosYaw = Math.cos(yaw);
        double cosPitch = Math.cos(pitch);
        double sinYaw = Math.sin(yaw);
        double sinPitch = Math.sin(pitch);
        double initialX = v2.getX();
        double initialY = v2.getY();
        double x2 = initialX * cosPitch - initialY * sinPitch;
        double y2 = initialX * sinPitch + initialY * cosPitch;
        double initialZ = v2.getZ();
        initialX = x2;
        double z2 = initialZ * cosYaw - initialX * sinYaw;
        x2 = initialZ * sinYaw + initialX * cosYaw;
        return new Vector(x2, y2, z2);
    }

    public static final double angleToXAxis(Vector vector) {
        return Math.atan2(vector.getX(), vector.getY());
    }
}

