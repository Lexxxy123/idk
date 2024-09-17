/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.utils;

import java.util.Arrays;

public class Interpolator {
    public static double[] interpLinear(double[] x2, double[] y2, double[] xi) throws IllegalArgumentException {
        if (x2.length != y2.length) {
            throw new IllegalArgumentException("X and Y must be the same length");
        }
        if (x2.length == 1) {
            throw new IllegalArgumentException("X must contain more than one value");
        }
        double[] dx = new double[x2.length - 1];
        double[] dy = new double[x2.length - 1];
        double[] slope = new double[x2.length - 1];
        double[] intercept = new double[x2.length - 1];
        for (int i2 = 0; i2 < x2.length - 1; ++i2) {
            dx[i2] = x2[i2 + 1] - x2[i2];
            if (dx[i2] == 0.0) {
                throw new IllegalArgumentException("X must be montotonic. A duplicate x-value was found");
            }
            if (dx[i2] < 0.0) {
                throw new IllegalArgumentException("X must be sorted");
            }
            dy[i2] = y2[i2 + 1] - y2[i2];
            slope[i2] = dy[i2] / dx[i2];
            intercept[i2] = y2[i2] - x2[i2] * slope[i2];
        }
        double[] yi = new double[xi.length];
        for (int i3 = 0; i3 < xi.length; ++i3) {
            if (xi[i3] > x2[x2.length - 1] || xi[i3] < x2[0]) {
                yi[i3] = Double.NaN;
                continue;
            }
            int loc = Arrays.binarySearch(x2, xi[i3]);
            if (loc < -1) {
                loc = -loc - 2;
                yi[i3] = slope[loc] * xi[i3] + intercept[loc];
                continue;
            }
            yi[i3] = y2[loc];
        }
        return yi;
    }

    public static double[] interpLinear(long[] x2, double[] y2, long[] xi) throws IllegalArgumentException {
        double[] xd = new double[x2.length];
        for (int i2 = 0; i2 < x2.length; ++i2) {
            xd[i2] = x2[i2];
        }
        double[] xid = new double[xi.length];
        for (int i3 = 0; i3 < xi.length; ++i3) {
            xid[i3] = xi[i3];
        }
        return Interpolator.interpLinear(xd, y2, xid);
    }

    public static double interpLinear(double[] xy, double xx) {
        if (xy.length % 2 != 0) {
            throw new IllegalArgumentException("XY must be divisible by two.");
        }
        double[] x2 = new double[xy.length / 2];
        double[] y2 = new double[x2.length];
        for (int i2 = 0; i2 < xy.length; ++i2) {
            if (i2 % 2 == 0) {
                x2[i2 / 2] = xy[i2];
                continue;
            }
            y2[i2 / 2] = xy[i2];
        }
        return Interpolator.interpLinear(x2, y2, new double[]{xx})[0];
    }
}

