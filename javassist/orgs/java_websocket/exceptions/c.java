/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.exceptions;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c
extends Exception {
    private static final long a = 3731842424390998726L;
    private final int a;

    public c(int n2) {
        this.a = n2;
    }

    public c(int n2, String string) {
        super(string);
        this.a = n2;
    }

    public c(int n2, Throwable throwable) {
        super(throwable);
        this.a = n2;
    }

    public c(int n2, String string, Throwable throwable) {
        super(string, throwable);
        this.a = n2;
    }

    public int a() {
        return this.a;
    }
}

