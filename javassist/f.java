/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.n;
import javassist.compiler.f;
import javassist.x;

class F
extends x {
    String a;

    F(String string) {
        this.a = string;
    }

    @Override
    int a(CtClass ctClass, String string, n n2, CtClass[] ctClassArray, f f2) {
        n2.k(0);
        n2.c(this.a);
        n2.f(n.a, string, M.b(ctClass));
        return 2;
    }

    @Override
    int a(CtClass ctClass, String string, n n2, f f2) {
        n2.c(this.a);
        n2.g(n.a, string, M.b(ctClass));
        return 1;
    }

    @Override
    int a(J j2, CtClass ctClass) {
        if (ctClass.a().equals("java.lang.String")) {
            return j2.b(this.a);
        }
        return 0;
    }
}

