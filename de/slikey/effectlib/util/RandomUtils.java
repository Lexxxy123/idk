/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.util;

import java.util.Random;
import org.bukkit.Material;
import org.bukkit.util.Vector;

public final class RandomUtils {
    public static final Random random = new Random(System.nanoTime());

    private RandomUtils() {
    }

    public static Vector getRandomVector() {
        double x2 = random.nextDouble() * 2.0 - 1.0;
        double y2 = random.nextDouble() * 2.0 - 1.0;
        double z2 = random.nextDouble() * 2.0 - 1.0;
        return new Vector(x2, y2, z2).normalize();
    }

    public static Vector getRandomCircleVector() {
        double rnd = random.nextDouble() * 2.0 * Math.PI;
        double x2 = Math.cos(rnd);
        double z2 = Math.sin(rnd);
        return new Vector(x2, 0.0, z2);
    }

    public static Material getRandomMaterial(Material[] materials) {
        return materials[random.nextInt(materials.length)];
    }

    public static double getRandomAngle() {
        return random.nextDouble() * 2.0 * Math.PI;
    }
}

