/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.a;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.al;
import javassist.bytecode.i;
import javassist.bytecode.n;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.compiler.e;
import javassist.expr.d;
import javassist.f;
import javassist.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class l
extends d {
    protected l(int n2, u u2, CtClass ctClass, al al2) {
        super(n2, u2, ctClass, al2);
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

    public CtClass a() {
        J j2 = this.a();
        int n2 = this.a;
        int n3 = this.a.c(n2 + 1);
        String string = j2.a(n3);
        return this.a.a().e(string);
    }

    @Override
    public CtClass[] a() {
        return super.a();
    }

    @Override
    public void a(String string) {
        this.a.a();
        J j2 = this.a();
        int n2 = this.a;
        int n3 = this.a.c(n2 + 1);
        javassist.compiler.f f2 = new javassist.compiler.f(this.a);
        f f3 = this.a.a();
        r r2 = this.a.a();
        try {
            CtClass[] ctClassArray = new CtClass[]{f3.c("java.lang.Object")};
            CtClass ctClass = CtClass.a;
            int n4 = r2.d();
            f2.a("java.lang.Object", ctClassArray, true, n4, this.c());
            int n5 = f2.a(ctClass, true);
            f2.a(new javassist.expr.m(n3));
            f2.a(this.a());
            l.a(ctClass, string);
            n n6 = f2.a();
            l.a(ctClassArray, true, n4, n6);
            f2.a(r2, n2);
            n6.a(ctClass);
            n6.b(n5, ctClass);
            f2.a(string);
            n6.a(n5, ctClass);
            this.a(n2, n6, 3);
        } catch (e e2) {
            throw new a(e2);
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (i i2) {
            throw new a("broken method");
        }
    }
}

