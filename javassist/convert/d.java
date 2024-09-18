/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.I;
import javassist.Z;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.convert.k;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class d
extends k {
    protected String a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected boolean a;
    protected int c;
    protected J a;

    public d(k k2, I i2, I i3) {
        this(k2, i2.d(), i3);
        this.a = i2.a().a();
    }

    public d(k k2, String string, I i2) {
        super(k2);
        this.b = string;
        this.c = i2.b().b();
        this.a = this.d = i2.a().a();
        this.e = i2.d();
        this.a = null;
        this.a = Z.b(i2.a());
    }

    @Override
    public void a(J j2, r r2) {
        if (this.a != j2) {
            this.c = 0;
        }
    }

    @Override
    public int a(CtClass ctClass, int n2, u u2, J j2) {
        int n3;
        String string;
        int n4 = u2.a(n2);
        if ((n4 == 185 || n4 == 183 || n4 == 184 || n4 == 182) && (string = j2.a(this.b, this.c, n3 = u2.c(n2 + 1))) != null && this.a(string, ctClass.a())) {
            int n5 = j2.e(n3);
            n2 = this.a(n4, n2, u2, j2.c(n5), j2);
        }
        return n2;
    }

    private boolean a(String string, f f2) {
        if (this.a.equals(string)) {
            return true;
        }
        try {
            CtClass ctClass = f2.c(string);
            CtClass ctClass2 = f2.c(this.a);
            if (ctClass.a(ctClass2)) {
                try {
                    I i2 = ctClass.a(this.b, this.c);
                    return i2.a().a().equals(this.a);
                } catch (aa aa2) {
                    return true;
                }
            }
        } catch (aa aa3) {
            return false;
        }
        return false;
    }

    protected int a(int n2, int n3, u u2, int n4, J j2) {
        if (this.c == 0) {
            int n5 = j2.a(j2.c(this.e), n4);
            int n6 = j2.a(this.d);
            if (n2 == 185) {
                this.c = j2.d(n6, n5);
            } else {
                if (this.a && n2 == 182) {
                    u2.a(183, n3);
                }
                this.c = j2.c(n6, n5);
            }
            this.a = j2;
        }
        u2.b(this.c, n3 + 1);
        return n3;
    }
}

