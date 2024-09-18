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
import javassist.bytecode.i;
import javassist.bytecode.n;
import javassist.bytecode.u;
import javassist.compiler.e;
import javassist.expr.d;
import javassist.expr.r;
import javassist.f;
import javassist.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class q
extends d {
    String b;
    int d;

    protected q(int n2, u u2, CtClass ctClass, al al2, String string, int n3) {
        super(n2, u2, ctClass, al2);
        this.b = string;
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

    private CtClass a() {
        return this.a.a().c(this.b);
    }

    public String b() {
        return this.b;
    }

    public String c() {
        J j2 = this.a();
        int n2 = this.a.c(this.a + 1);
        return j2.h(n2);
    }

    @Override
    public javassist.q a() {
        J j2 = this.a();
        int n2 = this.a.c(this.a + 1);
        String string = j2.h(n2);
        return this.a().a(string);
    }

    @Override
    public CtClass[] a() {
        return super.a();
    }

    private int e() {
        int n2 = this.a.a(this.d + 3);
        if (n2 == 89) {
            return this.a.a(this.d + 4) == 94 && this.a.a(this.d + 5) == 88 ? 6 : 4;
        }
        if (n2 == 90 && this.a.a(this.d + 4) == 95) {
            return 5;
        }
        return 3;
    }

    @Override
    public void a(String string) {
        this.a.a();
        int n2 = 3;
        int n3 = this.d;
        int n4 = this.a.c(n3 + 1);
        int n5 = this.e();
        int n6 = n3 + n5;
        for (int i2 = n3; i2 < n6; ++i2) {
            this.a.a(0, i2);
        }
        J j2 = this.a();
        n3 = this.a;
        int n7 = this.a.c(n3 + 1);
        String string2 = j2.h(n7);
        javassist.compiler.f f2 = new javassist.compiler.f(this.a);
        f f3 = this.a.a();
        javassist.bytecode.r r2 = this.a.a();
        try {
            CtClass[] ctClassArray = M.a(string2, f3);
            CtClass ctClass = f3.c(this.b);
            int n8 = r2.d();
            f2.a(this.b, ctClassArray, true, n8, this.c());
            int n9 = f2.a(ctClass, true);
            f2.a(new r(ctClass, n4, n7));
            q.a(ctClass, string);
            n n10 = f2.a();
            q.a(ctClassArray, true, n8, n10);
            f2.a(r2, n3);
            n10.a(ctClass);
            n10.b(n9, ctClass);
            f2.a(string);
            if (n5 > 3) {
                n10.k(n9);
            }
            this.a(n3, n10, 3);
        } catch (e e2) {
            throw new a(e2);
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (i i3) {
            throw new a("broken method");
        }
    }
}

