/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.S;
import javassist.bytecode.n;
import javassist.compiler.ast.a;
import javassist.compiler.e;
import javassist.compiler.k;
import javassist.compiler.l;
import javassist.compiler.v;
import javassist.expr.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class j
implements v {
    CtClass a;
    int a;
    int b;
    int c;

    j(CtClass ctClass, int n2, int n3, int n4) {
        this.a = ctClass;
        this.b = n4;
        this.a = n2;
        this.c = n3;
    }

    @Override
    public void a(k k2, n n2, a a2) {
        int n3;
        if (k2.a(a2) != 1) {
            throw new e("$proceed() cannot take more than one parameter for field writing");
        }
        if (h.a(this.a)) {
            n3 = 0;
        } else {
            n3 = -1;
            n2.k(this.b);
        }
        k2.a(a2, new int[1], new int[1], new String[1]);
        k2.c(this.a);
        n3 = this.a instanceof S ? (n3 -= ((S)this.a).d()) : --n3;
        n2.a(this.a);
        n2.j(this.c);
        n2.h(n3);
        k2.b(CtClass.i);
        k2.c();
    }

    @Override
    public void a(l l2, a a2) {
        l2.a(a2, new int[1], new int[1], new String[1]);
        l2.b(CtClass.i);
        l2.a();
    }
}

