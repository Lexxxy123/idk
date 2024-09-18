/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.bytecode.n;
import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.f;
import javassist.compiler.ast.p;
import javassist.compiler.k;
import javassist.compiler.l;
import javassist.compiler.v;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class g
implements v {
    final /* synthetic */ String a;
    final /* synthetic */ b a;
    final /* synthetic */ javassist.compiler.f a;

    g(javassist.compiler.f f2, String string, b b2) {
        this.a = f2;
        this.a = string;
        this.a = b2;
    }

    @Override
    public void a(k k2, n n2, a a2) {
        b b2 = new p(this.a);
        if (this.a != null) {
            b2 = javassist.compiler.ast.k.a(46, this.a, b2);
        }
        b2 = f.a(b2, (b)a2);
        k2.a(b2);
        k2.c();
    }

    @Override
    public void a(l l2, a a2) {
        b b2 = new p(this.a);
        if (this.a != null) {
            b2 = javassist.compiler.ast.k.a(46, this.a, b2);
        }
        b2 = f.a(b2, (b)a2);
        ((b)b2).a(l2);
        l2.a();
    }
}

