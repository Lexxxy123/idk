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
class h
implements v {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ javassist.compiler.f a;

    h(javassist.compiler.f f2, String string, String string2) {
        this.a = f2;
        this.a = string;
        this.b = string2;
    }

    @Override
    public void a(k k2, n n2, a a2) {
        javassist.compiler.ast.k k3 = javassist.compiler.ast.k.a(35, (b)new javassist.compiler.ast.v(this.a), (b)new p(this.b));
        k3 = f.a((b)k3, (b)a2);
        k2.a((b)k3);
        k2.c();
    }

    @Override
    public void a(l l2, a a2) {
        javassist.compiler.ast.k k2 = javassist.compiler.ast.k.a(35, (b)new javassist.compiler.ast.v(this.a), (b)new p(this.b));
        k2 = f.a((b)k2, (b)a2);
        k2.a(l2);
        l2.a();
    }
}

