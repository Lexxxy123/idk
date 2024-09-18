/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j.function;

import de.slikey.exp4j.function.Function;

public class Functions {
    private static final int INDEX_SIN = 0;
    private static final int INDEX_COS = 1;
    private static final int INDEX_TAN = 2;
    private static final int INDEX_LOG = 3;
    private static final int INDEX_LOG1P = 4;
    private static final int INDEX_ABS = 5;
    private static final int INDEX_ACOS = 6;
    private static final int INDEX_ASIN = 7;
    private static final int INDEX_ATAN = 8;
    private static final int INDEX_CBRT = 9;
    private static final int INDEX_CEIL = 10;
    private static final int INDEX_FLOOR = 11;
    private static final int INDEX_SINH = 12;
    private static final int INDEX_SQRT = 13;
    private static final int INDEX_TANH = 14;
    private static final int INDEX_COSH = 15;
    private static final int INDEX_POW = 16;
    private static final int INDEX_EXP = 17;
    private static final int INDEX_EXPM1 = 18;
    private static final int INDEX_LOG10 = 19;
    private static final int INDEX_LOG2 = 20;
    private static final Function[] builtinFunctions = new Function[21];

    public static Function getBuiltinFunction(String name) {
        if (name.equals("sin")) {
            return builtinFunctions[0];
        }
        if (name.equals("cos")) {
            return builtinFunctions[1];
        }
        if (name.equals("tan")) {
            return builtinFunctions[2];
        }
        if (name.equals("asin")) {
            return builtinFunctions[7];
        }
        if (name.equals("acos")) {
            return builtinFunctions[6];
        }
        if (name.equals("atan")) {
            return builtinFunctions[8];
        }
        if (name.equals("sinh")) {
            return builtinFunctions[12];
        }
        if (name.equals("cosh")) {
            return builtinFunctions[15];
        }
        if (name.equals("tanh")) {
            return builtinFunctions[14];
        }
        if (name.equals("abs")) {
            return builtinFunctions[5];
        }
        if (name.equals("log")) {
            return builtinFunctions[3];
        }
        if (name.equals("log10")) {
            return builtinFunctions[19];
        }
        if (name.equals("log2")) {
            return builtinFunctions[20];
        }
        if (name.equals("log1p")) {
            return builtinFunctions[4];
        }
        if (name.equals("ceil")) {
            return builtinFunctions[10];
        }
        if (name.equals("floor")) {
            return builtinFunctions[11];
        }
        if (name.equals("sqrt")) {
            return builtinFunctions[13];
        }
        if (name.equals("cbrt")) {
            return builtinFunctions[9];
        }
        if (name.equals("pow")) {
            return builtinFunctions[16];
        }
        if (name.equals("exp")) {
            return builtinFunctions[17];
        }
        if (name.equals("expm1")) {
            return builtinFunctions[18];
        }
        return null;
    }

    static {
        Functions.builtinFunctions[0] = new Function("sin"){

            @Override
            public double apply(double ... args) {
                return Math.sin(args[0]);
            }
        };
        Functions.builtinFunctions[1] = new Function("cos"){

            @Override
            public double apply(double ... args) {
                return Math.cos(args[0]);
            }
        };
        Functions.builtinFunctions[2] = new Function("tan"){

            @Override
            public double apply(double ... args) {
                return Math.tan(args[0]);
            }
        };
        Functions.builtinFunctions[3] = new Function("log"){

            @Override
            public double apply(double ... args) {
                return Math.log(args[0]);
            }
        };
        Functions.builtinFunctions[20] = new Function("log2"){

            @Override
            public double apply(double ... args) {
                return Math.log(args[0]) / Math.log(2.0);
            }
        };
        Functions.builtinFunctions[19] = new Function("log10"){

            @Override
            public double apply(double ... args) {
                return Math.log10(args[0]);
            }
        };
        Functions.builtinFunctions[4] = new Function("log1p"){

            @Override
            public double apply(double ... args) {
                return Math.log1p(args[0]);
            }
        };
        Functions.builtinFunctions[5] = new Function("abs"){

            @Override
            public double apply(double ... args) {
                return Math.abs(args[0]);
            }
        };
        Functions.builtinFunctions[6] = new Function("acos"){

            @Override
            public double apply(double ... args) {
                return Math.acos(args[0]);
            }
        };
        Functions.builtinFunctions[7] = new Function("asin"){

            @Override
            public double apply(double ... args) {
                return Math.asin(args[0]);
            }
        };
        Functions.builtinFunctions[8] = new Function("atan"){

            @Override
            public double apply(double ... args) {
                return Math.atan(args[0]);
            }
        };
        Functions.builtinFunctions[9] = new Function("cbrt"){

            @Override
            public double apply(double ... args) {
                return Math.cbrt(args[0]);
            }
        };
        Functions.builtinFunctions[11] = new Function("floor"){

            @Override
            public double apply(double ... args) {
                return Math.floor(args[0]);
            }
        };
        Functions.builtinFunctions[12] = new Function("sinh"){

            @Override
            public double apply(double ... args) {
                return Math.sinh(args[0]);
            }
        };
        Functions.builtinFunctions[13] = new Function("sqrt"){

            @Override
            public double apply(double ... args) {
                return Math.sqrt(args[0]);
            }
        };
        Functions.builtinFunctions[14] = new Function("tanh"){

            @Override
            public double apply(double ... args) {
                return Math.tanh(args[0]);
            }
        };
        Functions.builtinFunctions[15] = new Function("cosh"){

            @Override
            public double apply(double ... args) {
                return Math.cosh(args[0]);
            }
        };
        Functions.builtinFunctions[10] = new Function("ceil"){

            @Override
            public double apply(double ... args) {
                return Math.ceil(args[0]);
            }
        };
        Functions.builtinFunctions[16] = new Function("pow", 2){

            @Override
            public double apply(double ... args) {
                return Math.pow(args[0], args[1]);
            }
        };
        Functions.builtinFunctions[17] = new Function("exp", 1){

            @Override
            public double apply(double ... args) {
                return Math.exp(args[0]);
            }
        };
        Functions.builtinFunctions[18] = new Function("expm1", 1){

            @Override
            public double apply(double ... args) {
                return Math.expm1(args[0]);
            }
        };
    }
}

