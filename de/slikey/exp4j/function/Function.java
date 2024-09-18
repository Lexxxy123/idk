/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j.function;

public abstract class Function {
    protected final String name;
    protected final int numArguments;

    public Function(String name, int numArguments) {
        if (numArguments < 0) {
            throw new IllegalArgumentException("The number of function arguments can not be less than 0 for '" + name + "'");
        }
        if (!Function.isValidFunctionName(name)) {
            throw new IllegalArgumentException("The function name '" + name + "' is invalid");
        }
        this.name = name;
        this.numArguments = numArguments;
    }

    public Function(String name) {
        this(name, 1);
    }

    public String getName() {
        return this.name;
    }

    public int getNumArguments() {
        return this.numArguments;
    }

    public abstract double apply(double ... var1);

    public static char[] getAllowedFunctionCharacters() {
        int i2;
        char[] chars = new char[53];
        int count = 0;
        for (i2 = 65; i2 < 91; ++i2) {
            chars[count++] = (char)i2;
        }
        for (i2 = 97; i2 < 123; ++i2) {
            chars[count++] = (char)i2;
        }
        chars[count] = 95;
        return chars;
    }

    public static boolean isValidFunctionName(String name) {
        if (name == null) {
            return false;
        }
        int size = name.length();
        if (size == 0) {
            return false;
        }
        for (int i2 = 0; i2 < size; ++i2) {
            char c2 = name.charAt(i2);
            if (Character.isLetter(c2) || c2 == '_' || Character.isDigit(c2) && i2 > 0) continue;
            return false;
        }
        return true;
    }
}

