/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.n;
import javassist.compiler.ast.a;
import javassist.compiler.k;
import javassist.compiler.l;
import javassist.compiler.v;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class r
implements v {
    CtClass a;
    int a;
    int b;

    r(CtClass ctClass, int n2, int n3) {
        this.a = ctClass;
        this.a = n2;
        this.b = n3;
    }

    @Override
    public void a(k k2, n n2, a a2) {
        n2.g(187);
        n2.j(this.a);
        n2.g(89);
        k2.a(this.a, "<init>", a2, false, true, -1, null);
        k2.b(this.a);
    }

    @Override
    public void a(l l2, a a2) {
        l2.a(this.a, "<init>", a2);
        l2.b(this.a);
    }
}

