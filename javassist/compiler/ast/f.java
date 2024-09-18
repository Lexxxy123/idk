/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.k;
import javassist.compiler.ast.x;
import javassist.compiler.s;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class f
extends k {
    private static final long a = 1L;
    private s a = null;

    private f(b b2, a a2) {
        super(67, b2, a2);
    }

    public void a(s s2) {
        this.a = s2;
    }

    public s a() {
        return this.a;
    }

    public static f a(b b2, b b3) {
        return new f(b2, new a(b3));
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

