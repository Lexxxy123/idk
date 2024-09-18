/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.n;
import javassist.compiler.ast.a;
import javassist.compiler.e;
import javassist.compiler.k;
import javassist.compiler.l;
import javassist.compiler.v;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class p
implements v {
    CtClass a;
    int a;
    int b;
    int c;

    p(CtClass ctClass, int n2, int n3, int n4) {
        this.a = ctClass;
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    @Override
    public void a(k k2, n n2, a a2) {
        int n3 = k2.a(a2);
        if (n3 != this.c) {
            throw new e("$proceed() with a wrong number of parameters");
        }
        k2.a(a2, new int[n3], new int[n3], new String[n3]);
        n2.g(this.a);
        if (this.a == 189) {
            n2.j(this.b);
        } else if (this.a == 188) {
            n2.a(this.b);
        } else {
            n2.j(this.b);
            n2.a(this.c);
            n2.h(1 - this.c);
        }
        k2.b(this.a);
    }

    @Override
    public void a(l l2, a a2) {
        l2.b(this.a);
    }
}

