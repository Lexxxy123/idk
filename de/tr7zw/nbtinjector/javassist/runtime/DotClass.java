/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.runtime;

public class DotClass {
    public static NoClassDefFoundError fail(ClassNotFoundException e2) {
        return new NoClassDefFoundError(e2.getMessage());
    }
}

