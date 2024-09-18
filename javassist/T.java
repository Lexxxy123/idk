/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.bytecode.J;
import javassist.compiler.ast.b;
import javassist.compiler.e;
import javassist.compiler.f;
import javassist.compiler.w;
import javassist.u;

class t
extends u {
    private String a;

    t(String string) {
        this.a = string;
    }

    @Override
    void a(f f2) {
        f2.b(this.a);
    }

    @Override
    int a(J j2, CtClass ctClass) {
        try {
            b b2 = f.a(this.a, new w());
            return this.a(j2, ctClass, b2);
        } catch (e e2) {
            return 0;
        }
    }
}

