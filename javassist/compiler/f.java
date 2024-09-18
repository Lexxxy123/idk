/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.CtClass;
import javassist.G;
import javassist.I;
import javassist.S;
import javassist.Z;
import javassist.a;
import javassist.aa;
import javassist.bytecode.af;
import javassist.compiler.ast.b;
import javassist.compiler.ast.i;
import javassist.compiler.ast.l;
import javassist.compiler.ast.t;
import javassist.compiler.e;
import javassist.compiler.g;
import javassist.compiler.h;
import javassist.compiler.j;
import javassist.compiler.k;
import javassist.compiler.n;
import javassist.compiler.r;
import javassist.compiler.u;
import javassist.compiler.v;
import javassist.compiler.w;
import javassist.m;
import javassist.q;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class f {
    k a;
    w a;
    private javassist.bytecode.n a;
    public static final String a = "$0";
    public static final String b = "$_";
    public static final String c = "$proceed";

    public f(CtClass ctClass) {
        this(new javassist.bytecode.n(ctClass.b().a(), 0, 0), ctClass);
    }

    public f(javassist.bytecode.n n2, CtClass ctClass) {
        this.a = new k(n2, ctClass, ctClass.a());
        this.a = new w();
        this.a = n2;
    }

    public javassist.bytecode.n a() {
        return this.a;
    }

    public G a(String string) {
        u u2 = new u(new n(string));
        javassist.compiler.ast.a a2 = u2.b(this.a);
        try {
            if (a2 instanceof l) {
                return this.a((l)a2);
            }
            m m2 = this.a(u2, (javassist.compiler.ast.q)a2);
            CtClass ctClass = m2.a();
            m2.b().a(ctClass.a(), ctClass.b());
            return m2;
        } catch (javassist.bytecode.i i2) {
            throw new e(i2.getMessage());
        } catch (a a3) {
            throw new e(a3.getMessage());
        }
    }

    private javassist.r a(l l2) {
        i i2 = l2.a();
        j j2 = new j(this.a.a.a(i2), i2.a().b(), this.a.a());
        j2.a(r.a(l2.b()));
        if (l2.d() != null) {
            j2.a(l2.d());
        }
        return j2;
    }

    private m a(u u2, javassist.compiler.ast.q q2) {
        int n2 = r.a(q2.b());
        CtClass[] ctClassArray = this.a.a(q2);
        CtClass[] ctClassArray2 = this.a.b(q2);
        this.a(ctClassArray, Z.e(n2));
        q2 = u2.a(this.a, q2);
        try {
            if (q2.a()) {
                q q3 = new q(ctClassArray, this.a.a());
                q3.a(n2);
                q2.a(this.a);
                q3.a().a(this.a.a());
                q3.a(ctClassArray2);
                return q3;
            }
            i i2 = q2.a();
            CtClass ctClass = this.a.a.a(i2);
            this.a(ctClass, false);
            I i3 = new I(ctClass, i2.a().b(), ctClassArray, this.a.a());
            i3.a(n2);
            this.a.a(i3);
            q2.a(this.a);
            if (q2.a() != null) {
                i3.a().a(this.a.a());
            } else {
                i3.a(n2 | 0x400);
            }
            i3.a(ctClassArray2);
            return i3;
        } catch (aa aa2) {
            throw new e(aa2.toString());
        }
    }

    public javassist.bytecode.n a(m m2, String string) {
        try {
            boolean bl2;
            CtClass ctClass;
            int n2 = m2.a();
            this.a(m2.a(), Z.e(n2));
            if (m2 instanceof I) {
                this.a.a((I)m2);
                ctClass = ((I)m2).b();
            } else {
                ctClass = CtClass.i;
            }
            this.a(ctClass, false);
            boolean bl3 = bl2 = ctClass == CtClass.i;
            if (string == null) {
                f.a(this.a, ctClass);
            } else {
                u u2 = new u(new n(string));
                w w2 = new w(this.a);
                javassist.compiler.ast.a a2 = u2.a(w2);
                if (u2.a()) {
                    throw new e("the method/constructor body must be surrounded by {}");
                }
                boolean bl4 = false;
                if (m2 instanceof q) {
                    bl4 = !((q)m2).c();
                }
                this.a.a((t)a2, bl4, bl2);
            }
            return this.a;
        } catch (aa aa2) {
            throw new e(aa2.toString());
        }
    }

    private static void a(javassist.bytecode.n n2, CtClass ctClass) {
        int n3;
        int n4;
        if (ctClass instanceof S) {
            S s2 = (S)ctClass;
            n4 = s2.b();
            n3 = n4 == 175 ? 14 : (n4 == 174 ? 11 : (n4 == 173 ? 9 : (n4 == 177 ? 0 : 3)));
        } else {
            n4 = 176;
            n3 = 1;
        }
        if (n3 != 0) {
            n2.g(n3);
        }
        n2.g(n4);
    }

    public boolean a(javassist.bytecode.r r2, int n2) {
        af af2 = (af)r2.a("LocalVariableTable");
        if (af2 == null) {
            return false;
        }
        int n3 = af2.a();
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = af2.a(i2);
            int n5 = af2.b(i2);
            if (n4 > n2 || n2 >= n4 + n5) continue;
            this.a.a(af2.b(i2), af2.a(i2), af2.f(i2), this.a);
        }
        return true;
    }

    public boolean b(javassist.bytecode.r r2, int n2) {
        af af2 = (af)r2.a("LocalVariableTable");
        if (af2 == null) {
            return false;
        }
        int n3 = af2.a();
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = af2.f(i2);
            if (n4 >= n2) continue;
            this.a.a(af2.b(i2), af2.a(i2), n4, this.a);
        }
        return true;
    }

    public int a(CtClass[] ctClassArray, boolean bl2) {
        return this.a.a(ctClassArray, bl2, "$", "$args", "$$", this.a);
    }

    public int a(String string, CtClass[] ctClassArray, boolean bl2, int n2, boolean bl3) {
        return this.a.a(ctClassArray, bl3, "$", "$args", "$$", bl2, n2, string, this.a);
    }

    public void a(int n2) {
        this.a.a(n2);
    }

    public int a(CtClass ctClass, boolean bl2) {
        this.a.a(ctClass);
        return this.a.a(ctClass, "$r", bl2 ? b : null, this.a);
    }

    public void a(CtClass ctClass) {
        this.a.a(ctClass);
    }

    public int a(CtClass ctClass, String string) {
        return this.a.a(ctClass, string, this.a);
    }

    public void a(String string, String string2) {
        u u2 = new u(new n(string));
        b b2 = u2.a(this.a);
        String string3 = string2;
        g g2 = new g(this, string3, b2);
        this.a.a(g2, c);
    }

    public void b(String string, String string2) {
        String string3 = string;
        String string4 = string2;
        h h2 = new h(this, string3, string4);
        this.a.a(h2, c);
    }

    public void a(String string, String string2, String string3, String string4, int n2) {
        u u2 = new u(new n(string));
        b b2 = u2.a(this.a);
        javassist.compiler.i i2 = new javassist.compiler.i(this, b2, n2, string4, string2, string3);
        this.a.a(i2, c);
    }

    public void a(v v2) {
        this.a.a(v2, c);
    }

    public void a(String string) {
        u u2 = new u(new n(string));
        w w2 = new w(this.a);
        while (u2.a()) {
            javassist.compiler.ast.a a2 = u2.a(w2);
            if (a2 == null) continue;
            ((t)a2).a(this.a);
        }
    }

    public void b(String string) {
        b b2 = f.a(string, this.a);
        this.a(b2);
    }

    public static b a(String string, w w2) {
        u u2 = new u(new n(string));
        return u2.a(w2);
    }

    public void a(b b2) {
        if (b2 != null) {
            this.a.a(b2);
        }
    }
}

