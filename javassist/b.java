/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.a;
import javassist.bytecode.M;
import javassist.bytecode.n;
import javassist.compiler.f;
import javassist.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class B
extends x {
    CtClass a;
    int[] a;

    B(CtClass ctClass, int[] nArray) {
        this.a = ctClass;
        this.a = nArray;
    }

    @Override
    void a(String string) {
        if (string.charAt(0) != '[') {
            throw new a("type mismatch");
        }
    }

    @Override
    int a(CtClass ctClass, String string, n n2, CtClass[] ctClassArray, f f2) {
        n2.k(0);
        int n3 = n2.a(ctClass, this.a);
        n2.f(n.a, string, M.b(ctClass));
        return n3 + 1;
    }

    @Override
    int a(CtClass ctClass, String string, n n2, f f2) {
        int n3 = n2.a(ctClass, this.a);
        n2.g(n.a, string, M.b(ctClass));
        return n3;
    }
}

