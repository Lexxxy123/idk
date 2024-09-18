/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.G;
import javassist.I;
import javassist.J;
import javassist.Q;
import javassist.a;
import javassist.aa;
import javassist.bytecode.n;
import javassist.c;
import javassist.compiler.e;
import javassist.compiler.f;
import javassist.q;

public class O {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;

    public static q a(String string, CtClass ctClass) {
        f f2 = new f(ctClass);
        try {
            G g2 = f2.a(string);
            if (g2 instanceof q) {
                return (q)g2;
            }
        } catch (e e2) {
            throw new a(e2);
        }
        throw new a("not a constructor");
    }

    public static q a(CtClass[] ctClassArray, CtClass[] ctClassArray2, String string, CtClass ctClass) {
        try {
            q q2 = new q(ctClassArray, ctClass);
            q2.a(ctClassArray2);
            q2.b(string);
            return q2;
        } catch (aa aa2) {
            throw new a(aa2);
        }
    }

    public static q a(q q2, CtClass ctClass, c c2) {
        return new q(q2, ctClass, c2);
    }

    public static q a(CtClass ctClass) {
        q q2 = new q((CtClass[])null, ctClass);
        javassist.bytecode.J j2 = ctClass.b().a();
        n n2 = new n(j2, 1, 1);
        n2.k(0);
        try {
            n2.c(ctClass.b(), "<init>", "()V");
        } catch (aa aa2) {
            throw new a(aa2);
        }
        n2.a(177);
        q2.b().a(n2.a());
        return q2;
    }

    public static q a(CtClass[] ctClassArray, CtClass[] ctClassArray2, CtClass ctClass) {
        return O.a(ctClassArray, ctClassArray2, 0, null, null, ctClass);
    }

    public static q b(CtClass[] ctClassArray, CtClass[] ctClassArray2, CtClass ctClass) {
        return O.a(ctClassArray, ctClassArray2, 2, null, null, ctClass);
    }

    public static q a(CtClass[] ctClassArray, CtClass[] ctClassArray2, int n2, I i2, J j2, CtClass ctClass) {
        return Q.a(ctClassArray, ctClassArray2, n2, i2, j2, ctClass);
    }
}

