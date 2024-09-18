/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.i;
import javassist.compiler.ast.t;
import javassist.compiler.ast.v;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class q
extends a {
    private static final long a = 1L;
    public static final String a = "<init>";

    public q(b b2, a a2) {
        super(b2, a2);
    }

    public boolean a() {
        v v2 = this.a().a();
        return v2 != null && a.equals(v2.b());
    }

    @Override
    public a b() {
        return (a)this.a();
    }

    @Override
    public i a() {
        return (i)((a)this.a()).c();
    }

    @Override
    public a c() {
        return (a)this.a(2).c();
    }

    public a d() {
        return (a)this.a(3).c();
    }

    @Override
    public t a() {
        return (t)this.a(4).c();
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

