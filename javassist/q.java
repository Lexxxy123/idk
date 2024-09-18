/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.I;
import javassist.J;
import javassist.R;
import javassist.a;
import javassist.aa;
import javassist.bytecode.M;
import javassist.bytecode.n;
import javassist.bytecode.o;
import javassist.q;

class Q
extends R {
    private static final int a = 0;
    private static final int b = 2;

    Q() {
    }

    public static q a(CtClass[] ctClassArray, CtClass[] ctClassArray2, int n2, I i2, J j2, CtClass ctClass) {
        try {
            q q2 = new q(ctClassArray, ctClass);
            q2.a(ctClassArray2);
            n n3 = Q.a(ctClass, ctClass.b(), n2, i2, ctClassArray, j2);
            q2.b().a(n3.a());
            return q2;
        } catch (aa aa2) {
            throw new a(aa2);
        }
    }

    protected static n a(CtClass ctClass, o o2, int n2, I i2, CtClass[] ctClassArray, J j2) {
        int n3;
        int n4;
        int n5 = o2.c();
        n n6 = new n(o2.a(), 0, 0);
        n6.a(false, ctClassArray, 0);
        n6.k(0);
        if (n2 == 0) {
            n4 = 1;
            n6.a(n5, "<init>", "()V");
        } else if (n2 == 2) {
            n4 = n6.a(ctClassArray, 1) + 1;
            n6.a(n5, "<init>", M.a(ctClassArray));
        } else {
            String string;
            n4 = Q.a(n6, ctClassArray, 1);
            if (j2 == null) {
                n3 = 2;
                string = J.d();
            } else {
                n3 = j2.a(n6) + 2;
                string = j2.c();
            }
            if (n4 < n3) {
                n4 = n3;
            }
            n6.a(n5, "<init>", string);
        }
        if (i2 == null) {
            n6.a(177);
        } else {
            n3 = Q.a(ctClass, o2, i2, false, ctClassArray, CtClass.i, j2, n6);
            if (n4 < n3) {
                n4 = n3;
            }
        }
        n6.c(n4);
        return n6;
    }
}

