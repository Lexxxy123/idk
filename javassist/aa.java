/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

public class aa
extends Exception {
    private static final long a = 1L;

    public aa(String string) {
        super(string);
    }

    public aa(String string, Exception exception) {
        super(string + " because of " + exception.toString());
    }
}

