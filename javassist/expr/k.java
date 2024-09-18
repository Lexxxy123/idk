/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.a;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.T;
import javassist.bytecode.al;
import javassist.bytecode.n;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.compiler.e;
import javassist.compiler.f;
import javassist.expr.d;
import javassist.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class k
extends d {
    private static String b = "$1";
    private T a;
    private int d;

    protected k(T t2, int n2, u u2, CtClass ctClass, al al2) {
        super(t2.c(n2), u2, ctClass, al2);
        this.a = t2;
        this.d = n2;
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

    @Override
    public CtClass[] a() {
        return super.a();
    }

    public CtClass a() {
        int n2 = this.a.d(this.d);
        if (n2 == 0) {
            return null;
        }
        J j2 = this.a();
        String string = j2.a(n2);
        return ((CtClass)((Object)this.a)).a().e(string);
    }

    public boolean a() {
        return this.a.d(this.d) == 0;
    }

    @Override
    public void a(String string) {
        throw new RuntimeException("not implemented yet");
    }

    public void b(String string) {
        this.a = (T)true;
        J j2 = this.a();
        r r2 = ((u)((Object)this.a)).a();
        f f2 = new f((CtClass)((Object)this.a));
        n n2 = f2.a();
        n2.i(1);
        n2.d(r2.d());
        try {
            CtClass ctClass = this.a();
            int n3 = f2.a(ctClass, b);
            f2.a(ctClass, false);
            n2.l(n3);
            f2.a(string);
            n2.k(n3);
            int n4 = this.a.c(this.d);
            n2.g(167);
            n2.j(n4 - ((u)((Object)this.a)).c() - n2.e() + 1);
            this.c = n2.c();
            this.b = (String)n2.d();
            int n5 = ((u)((Object)this.a)).c(n2.b());
            ((u)((Object)this.a)).b(n2.a(), n5);
            this.a.c(this.d, n5);
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (e e2) {
            throw new a(e2);
        }
    }
}

