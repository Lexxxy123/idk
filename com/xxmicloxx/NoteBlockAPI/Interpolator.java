/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI;

@Deprecated
public class Interpolator {
    public static double[] interpLinear(double[] x2, double[] y2, double[] xi) throws IllegalArgumentException {
        return com.xxmicloxx.NoteBlockAPI.utils.Interpolator.interpLinear(x2, y2, xi);
    }

    public static double[] interpLinear(long[] x2, double[] y2, long[] xi) throws IllegalArgumentException {
        return com.xxmicloxx.NoteBlockAPI.utils.Interpolator.interpLinear(x2, y2, xi);
    }

    public static double interpLinear(double[] xy, double xx) {
        return com.xxmicloxx.NoteBlockAPI.utils.Interpolator.interpLinear(xy, xx);
    }
}

