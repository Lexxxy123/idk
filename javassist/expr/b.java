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
class b
implements v {
    int a;
    CtClass a;

    b(int n2, CtClass ctClass) {
        this.a = n2;
        this.a = ctClass;
    }

    @Override
    public void a(k k2, n n2, a a2) {
        if (k2.a(a2) != 1) {
            throw new e("$proceed() cannot take more than one parameter for cast");
        }
        k2.a(a2, new int[1], new int[1], new String[1]);
        n2.g(192);
        n2.j(this.a);
        k2.b(this.a);
    }

    @Override
    public void a(l l2, a a2) {
        l2.a(a2, new int[1], new int[1], new String[1]);
        l2.b(this.a);
    }
}

