/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.Z;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.u;
import javassist.convert.k;
import javassist.f;
import javassist.r;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class i
extends k {
    protected String a;
    protected CtClass a;
    protected boolean a;
    protected String b;
    protected String c;

    public i(k k2, r r2, String string, String string2) {
        super(k2);
        this.a = r2.a();
        this.a = r2.d();
        this.b = string;
        this.c = string2;
        this.a = Z.b(r2.a());
    }

    static String a(f f2, J j2, CtClass ctClass, String string, boolean bl2, int n2) {
        if (!j2.d(n2).equals(string)) {
            return null;
        }
        try {
            CtClass ctClass2 = f2.c(j2.c(n2));
            if (ctClass2 == ctClass || !bl2 && i.a(ctClass2, ctClass, string)) {
                return j2.e(n2);
            }
        } catch (aa aa2) {
            // empty catch block
        }
        return null;
    }

    static boolean a(CtClass ctClass, CtClass ctClass2, String string) {
        if (!ctClass.b(ctClass2)) {
            return false;
        }
        try {
            r r2 = ctClass.a(string);
            return r2.a() == ctClass2;
        } catch (aa aa2) {
            return false;
        }
    }

    @Override
    public int a(CtClass ctClass, int n2, u u2, J j2) {
        int n3 = u2.a(n2);
        if (n3 == 180 || n3 == 178) {
            int n4 = u2.c(n2 + 1);
            String string = i.a(ctClass.a(), j2, this.a, this.a, this.a, n4);
            if (string != null) {
                if (n3 == 178) {
                    u2.a(n2);
                    n2 = u2.f(1);
                    u2.a(1, n2);
                    n2 = u2.d();
                }
                String string2 = "(Ljava/lang/Object;)" + string;
                int n5 = j2.a(this.b);
                int n6 = j2.b(n5, this.c, string2);
                u2.a(184, n2);
                u2.b(n6, n2 + 1);
                return n2;
            }
        }
        return n2;
    }
}

