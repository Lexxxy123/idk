/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.x;

public class c
extends a {
    private static final long a = 1L;

    public c(b b2) {
        super(b2);
    }

    public int b() {
        int n2 = this.a();
        if (n2 == 1 && this.c() == null) {
            return 0;
        }
        return n2;
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }

    @Override
    public String a() {
        return "array";
    }
}

