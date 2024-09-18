/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.exceptions;

import javassist.orgs.java_websocket.exceptions.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class g
extends c {
    private static final long a = 6908339749836826785L;
    private final int a;

    public g() {
        this(Integer.MAX_VALUE);
    }

    public g(int n2) {
        super(1009);
        this.a = n2;
    }

    public g(String string, int n2) {
        super(1009, string);
        this.a = n2;
    }

    public g(String string) {
        this(string, Integer.MAX_VALUE);
    }

    public int b() {
        return this.a;
    }
}

