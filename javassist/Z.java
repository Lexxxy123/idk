/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.a;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.n;
import javassist.compiler.f;
import javassist.x;

class z
extends x {
    long a;

    z(long l2) {
        this.a = l2;
    }

    @Override
    void a(String string) {
        if (!string.equals("J")) {
            throw new a("type mismatch");
        }
    }

    @Override
    int a(CtClass ctClass, String string, n n2, CtClass[] ctClassArray, f f2) {
        n2.k(0);
        n2.b(this.a);
        n2.f(n.a, string, M.b(ctClass));
        return 3;
    }

    @Override
    int a(CtClass ctClass, String string, n n2, f f2) {
        n2.b(this.a);
        n2.g(n.a, string, M.b(ctClass));
        return 2;
    }

    @Override
    int a(J j2, CtClass ctClass) {
        if (ctClass == CtClass.f) {
            return j2.a(this.a);
        }
        return 0;
    }
}

