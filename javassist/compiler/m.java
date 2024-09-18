/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import java.util.HashMap;

public final class m
extends HashMap<String, Integer> {
    private static final long a = 1L;

    public int a(String string) {
        return this.containsKey(string) ? (Integer)this.get(string) : -1;
    }

    public void a(String string, int n2) {
        this.put(string, n2);
    }
}

