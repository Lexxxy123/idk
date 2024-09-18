/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.g;
import javassist.compiler.ast.x;

public class m
extends g {
    private static final long a = 1L;

    public m(a a2, int n2, b b2) {
        super(a2, n2, b2);
    }

    public m(int n2, int n3, b b2) {
        super(n2, n3, b2);
    }

    @Override
    public String a() {
        return "instanceof:" + (int)this.a + ":" + this.b;
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

