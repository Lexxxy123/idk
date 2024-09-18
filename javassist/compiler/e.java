/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.a;
import javassist.aa;
import javassist.compiler.n;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e
extends Exception {
    private static final long a = 1L;
    private n a;
    private String a;

    public e(String string, n n2) {
        this.a = string;
        this.a = n2;
    }

    public e(String string) {
        this.a = string;
        this.a = null;
    }

    public e(a a2) {
        this(a2.a());
    }

    public e(aa aa2) {
        this("cannot find " + aa2.getMessage());
    }

    public n a() {
        return this.a;
    }

    @Override
    public String getMessage() {
        return this.a;
    }

    @Override
    public String toString() {
        return "compile error: " + this.a;
    }
}

