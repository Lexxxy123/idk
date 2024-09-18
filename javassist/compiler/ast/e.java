/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.k;
import javassist.compiler.ast.x;

public class e
extends k {
    private static final long a = 1L;

    private e(int n2, b b2, a a2) {
        super(n2, b2, a2);
    }

    public static e a(int n2, b b2, b b3) {
        return new e(n2, b2, new a(b3));
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

