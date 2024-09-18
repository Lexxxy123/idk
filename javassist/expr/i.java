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
class i
implements v {
    CtClass a;
    int a;
    int b;
    int c;

    i(CtClass ctClass, int n2, int n3, int n4) {
        this.a = ctClass;
        this.b = n4;
        this.a = n2;
        this.c = n3;
    }

    @Override
    public void a(k k2, n n2, a a2) {
        int n3;
        if (a2 != null && !k2.a(a2)) {
            throw new e("$proceed() cannot take a parameter for field reading");
        }
        if (h.a(this.a)) {
            n3 = 0;
        } else {
            n3 = -1;
            n2.k(this.b);
        }
        n3 = this.a instanceof S ? (n3 += ((S)this.a).d()) : ++n3;
        n2.a(this.a);
        n2.j(this.c);
        n2.h(n3);
        k2.b(this.a);
    }

    @Override
    public void a(l l2, a a2) {
        l2.b(this.a);
    }
}

