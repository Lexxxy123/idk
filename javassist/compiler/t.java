/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.compiler.ast.b;
import javassist.compiler.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class t
extends e {
    private static final long a = 1L;
    private String a;
    private b a;

    public t(String string, b b2) {
        super("no such field: " + string);
        this.a = string;
        this.a = b2;
    }

    public String a() {
        return this.a;
    }

    public b a() {
        return this.a;
    }
}

