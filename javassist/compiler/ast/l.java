/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.i;
import javassist.compiler.ast.x;

public class l
extends a {
    private static final long a = 1L;

    public l(b b2, a a2) {
        super(b2, a2);
    }

    @Override
    public a b() {
        return (a)this.a();
    }

    @Override
    public i a() {
        return (i)((a)this.a()).c();
    }

    public b d() {
        return this.a(2).c();
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

