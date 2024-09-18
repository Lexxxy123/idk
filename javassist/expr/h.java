/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.a;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.al;
import javassist.bytecode.n;
import javassist.bytecode.u;
import javassist.compiler.e;
import javassist.compiler.f;
import javassist.expr.d;
import javassist.expr.i;
import javassist.expr.j;
import javassist.m;
import javassist.r;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class h
extends d {
    int d;

    protected h(int n2, u u2, CtClass ctClass, al al2, int n3) {
        super(n2, u2, ctClass, al2);
        this.d = n3;
    }

    @Override
    public m a() {
        return super.a();
    }

    @Override
    public int a() {
        return super.a();
    }

    @Override
    public String a() {
        return super.a();
    }

    public boolean a() {
        return h.a(this.d);
    }

    static boolean a(int n2) {
        return n2 == 178 || n2 == 179;
    }

    public boolean d() {
        return this.d == 180 || this.d == 178;
    }

    public boolean e() {
        return this.d == 181 || this.d == 179;
    }

    private CtClass a() {
        return this.a.a().c(this.b());
    }

    public String b() {
        int n2 = this.a.c(this.a + 1);
        return this.a().c(n2);
    }

    public String c() {
        int n2 = this.a.c(this.a + 1);
        return this.a().d(n2);
    }

    public r a() {
        CtClass ctClass = this.a();
        int n2 = this.a.c(this.a + 1);
        J j2 = this.a();
        return ctClass.a(j2.d(n2), j2.e(n2));
    }

    @Override
    public CtClass[] a() {
        return super.a();
    }

    public String d() {
        int n2 = this.a.c(this.a + 1);
        return this.a().e(n2);
    }

    @Override
    public void a(String string) {
        this.a.a();
        J j2 = this.a();
        int n2 = this.a;
        int n3 = this.a.c(n2 + 1);
        f f2 = new f(this.a);
        javassist.bytecode.r r2 = this.a.a();
        try {
            CtClass ctClass;
            CtClass[] ctClassArray;
            CtClass ctClass2 = M.b(j2.e(n3), this.a.a());
            boolean bl2 = this.d();
            if (bl2) {
                ctClassArray = new CtClass[]{};
                ctClass = ctClass2;
            } else {
                ctClassArray = new CtClass[]{ctClass2};
                ctClass = CtClass.i;
            }
            int n4 = r2.d();
            f2.a(j2.c(n3), ctClassArray, true, n4, this.c());
            boolean bl3 = h.a(ctClass, string);
            if (bl2) {
                bl3 = true;
            }
            int n5 = f2.a(ctClass, bl3);
            if (bl2) {
                f2.a(new i(ctClass, this.d, n3, n4));
            } else {
                f2.a(ctClass2);
                f2.a(new j(ctClassArray[0], this.d, n3, n4));
            }
            n n6 = f2.a();
            h.a(ctClassArray, this.a(), n4, n6);
            f2.a(r2, n2);
            if (bl3) {
                if (ctClass == CtClass.i) {
                    n6.g(1);
                    n6.l(n5);
                } else {
                    n6.a(ctClass);
                    n6.b(n5, ctClass);
                }
            }
            f2.a(string);
            if (bl2) {
                n6.a(n5, ctClass);
            }
            this.a(n2, n6, 3);
        } catch (e e2) {
            throw new a(e2);
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (javassist.bytecode.i i2) {
            throw new a("broken method");
        }
    }
}

