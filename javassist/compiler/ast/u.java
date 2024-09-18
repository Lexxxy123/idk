/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.b;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class u
extends b {
    private static final long a = 1L;
    protected String a;

    public u(String string) {
        this.a = string;
    }

    public String b() {
        return this.a;
    }

    @Override
    public String toString() {
        return "\"" + this.a + "\"";
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

