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

class y
extends x {
    int a;

    y(int n2) {
        this.a = n2;
    }

    @Override
    void a(String string) {
        char c2 = string.charAt(0);
        if (c2 != 'I' && c2 != 'S' && c2 != 'B' && c2 != 'C' && c2 != 'Z') {
            throw new a("type mismatch");
        }
    }

    @Override
    int a(CtClass ctClass, String string, n n2, CtClass[] ctClassArray, f f2) {
        n2.k(0);
        n2.m(this.a);
        n2.f(n.a, string, M.b(ctClass));
        return 2;
    }

    @Override
    int a(CtClass ctClass, String string, n n2, f f2) {
        n2.m(this.a);
        n2.g(n.a, string, M.b(ctClass));
        return 1;
    }

    @Override
    int a(J j2, CtClass ctClass) {
        return j2.t(this.a);
    }
}

