/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.effectlib.util;

import java.util.Random;

public final class MathUtils {
    public static final float nanoToSec = 1.0E-9f;
    public static final float FLOAT_ROUNDING_ERROR = 1.0E-6f;
    public static final float PI = (float)Math.PI;
    public static final float PI2 = (float)Math.PI * 2;
    public static final float SQRT_3 = 1.73205f;
    public static final float E = (float)Math.E;
    private static final int SIN_BITS = 14;
    private static final int SIN_MASK = 16383;
    private static final int SIN_COUNT = 16384;
    private static final float radFull = (float)Math.PI * 2;
    private static final float degFull = 360.0f;
    private static final float radToIndex = 2607.5945f;
    private static final float degToIndex = 45.511112f;
    public static final float radiansToDegrees = 57.295776f;
    public static final float radDeg = 57.295776f;
    public static final float degreesToRadians = (float)Math.PI / 180;
    public static final float degRad = (float)Math.PI / 180;
    private static final int ATAN2_BITS = 7;
    private static final int ATAN2_BITS2 = 14;
    private static final int ATAN2_MASK = 16383;
    private static final int ATAN2_COUNT = 16384;
    static final int ATAN2_DIM = (int)Math.sqrt(16384.0);
    private static final float INV_ATAN2_DIM_MINUS_1 = 1.0f / (float)(ATAN2_DIM - 1);
    public static Random random = new Random();
    private static final int BIG_ENOUGH_INT = 16384;
    private static final double BIG_ENOUGH_FLOOR = 16384.0;
    private static final double CEIL = 0.9999999;
    private static final double BIG_ENOUGH_CEIL = 16384.999999999996;
    private static final double BIG_ENOUGH_ROUND = 16384.5;

    public static final float sin(float radians) {
        return Sin.table[(int)(radians * 2607.5945f) & 0x3FFF];
    }

    public static final float cos(float radians) {
        return Sin.table[(int)((radians + 1.5707964f) * 2607.5945f) & 0x3FFF];
    }

    public static final float sinDeg(float degrees) {
        return Sin.table[(int)(degrees * 45.511112f) & 0x3FFF];
    }

    public static final float cosDeg(float degrees) {
        return Sin.table[(int)((degrees + 90.0f) * 45.511112f) & 0x3FFF];
    }

    public static final float atan2(float y2, float x2) {
        float add;
        float mul;
        if (x2 < 0.0f) {
            if (y2 < 0.0f) {
                y2 = -y2;
                mul = 1.0f;
            } else {
                mul = -1.0f;
            }
            x2 = -x2;
            add = (float)(-Math.PI);
        } else {
            if (y2 < 0.0f) {
                y2 = -y2;
                mul = -1.0f;
            } else {
                mul = 1.0f;
            }
            add = 0.0f;
        }
        float invDiv = 1.0f / ((x2 < y2 ? y2 : x2) * INV_ATAN2_DIM_MINUS_1);
        if (invDiv == Float.POSITIVE_INFINITY) {
            return ((float)Math.atan2(y2, x2) + add) * mul;
        }
        int xi = (int)(x2 * invDiv);
        int yi = (int)(y2 * invDiv);
        return (Atan2.table[yi * ATAN2_DIM + xi] + add) * mul;
    }

    public static final int random(int range) {
        return random.nextInt(range + 1);
    }

    public static final int random(int start, int end) {
        return start + random.nextInt(end - start + 1);
    }

    public static final boolean randomBoolean() {
        return random.nextBoolean();
    }

    public static final boolean randomBoolean(float chance) {
        return MathUtils.random() < chance;
    }

    public static final float random() {
        return random.nextFloat();
    }

    public static final float random(float range) {
        return random.nextFloat() * range;
    }

    public static final float random(float start, float end) {
        return start + random.nextFloat() * (end - start);
    }

    public static int nextPowerOfTwo(int value) {
        if (value == 0) {
            return 1;
        }
        --value;
        value |= value >> 1;
        value |= value >> 2;
        value |= value >> 4;
        value |= value >> 8;
        value |= value >> 16;
        return value + 1;
    }

    public static boolean isPowerOfTwo(int value) {
        return value != 0 && (value & value - 1) == 0;
    }

    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static short clamp(short value, short min, short max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static int floor(float x2) {
        return (int)((double)x2 + 16384.0) - 16384;
    }

    public static int floorPositive(float x2) {
        return (int)x2;
    }

    public static int ceil(float x2) {
        return (int)((double)x2 + 16384.999999999996) - 16384;
    }

    public static int ceilPositive(float x2) {
        return (int)((double)x2 + 0.9999999);
    }

    public static int round(float x2) {
        return (int)((double)x2 + 16384.5) - 16384;
    }

    public static int roundPositive(float x2) {
        return (int)(x2 + 0.5f);
    }

    public static boolean isZero(float value) {
        return Math.abs(value) <= 1.0E-6f;
    }

    public static boolean isZero(float value, float tolerance) {
        return Math.abs(value) <= tolerance;
    }

    public static boolean isEqual(float a2, float b2) {
        return Math.abs(a2 - b2) <= 1.0E-6f;
    }

    public static boolean isEqual(float a2, float b2, float tolerance) {
        return Math.abs(a2 - b2) <= tolerance;
    }

    private static class Atan2 {
        static final float[] table = new float[16384];

        private Atan2() {
        }

        static {
            for (int i2 = 0; i2 < ATAN2_DIM; ++i2) {
                for (int j2 = 0; j2 < ATAN2_DIM; ++j2) {
                    float x0 = (float)i2 / (float)ATAN2_DIM;
                    float y0 = (float)j2 / (float)ATAN2_DIM;
                    Atan2.table[j2 * MathUtils.ATAN2_DIM + i2] = (float)Math.atan2(y0, x0);
                }
            }
        }
    }

    private static class Sin {
        static final float[] table;

        private Sin() {
        }

        static {
            int i2;
            table = new float[16384];
            for (i2 = 0; i2 < 16384; ++i2) {
                Sin.table[i2] = (float)Math.sin(((float)i2 + 0.5f) / 16384.0f * ((float)Math.PI * 2));
            }
            for (i2 = 0; i2 < 360; i2 += 90) {
                Sin.table[(int)((float)i2 * 45.511112f) & 0x3FFF] = (float)Math.sin((float)i2 * ((float)Math.PI / 180));
            }
        }
    }
}

