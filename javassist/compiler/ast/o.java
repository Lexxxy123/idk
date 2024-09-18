/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.b;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class o
extends b {
    private static final long a = 1L;
    protected int a;

    public o(int n2) {
        this.a = n2;
    }

    public int a() {
        return this.a;
    }

    @Override
    public String toString() {
        return "id:" + this.a;
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

