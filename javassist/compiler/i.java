/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.bytecode.n;
import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.f;
import javassist.compiler.k;
import javassist.compiler.l;
import javassist.compiler.v;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class i
implements v {
    final /* synthetic */ b a;
    final /* synthetic */ int a;
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ f a;

    i(f f2, b b2, int n2, String string, String string2, String string3) {
        this.a = f2;
        this.a = b2;
        this.a = n2;
        this.a = string;
        this.b = string2;
        this.c = string3;
    }

    @Override
    public void a(k k2, n n2, a a2) {
        k2.a(this.a, this.a, this.a, a2);
    }

    @Override
    public void a(l l2, a a2) {
        l2.a(this.a, this.b, this.c, this.a, a2);
    }
}

