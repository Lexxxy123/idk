/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.I;
import javassist.a;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.al;
import javassist.bytecode.i;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.compiler.e;
import javassist.expr.d;
import javassist.f;
import javassist.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class n
extends d {
    protected n(int n2, u u2, CtClass ctClass, al al2) {
        super(n2, u2, ctClass, al2);
    }

    private int a(J j2) {
        int n2 = this.a;
        int n3 = this.a.a(n2);
        int n4 = this.a.c(n2 + 1);
        if (n3 == 185) {
            return j2.k(n4);
        }
        return j2.i(n4);
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

    protected CtClass a() {
        return this.a.a().c(this.c());
    }

    public String c() {
        J j2 = this.a();
        int n2 = this.a;
        int n3 = this.a.a(n2);
        int n4 = this.a.c(n2 + 1);
        String string = n3 == 185 ? j2.i(n4) : j2.f(n4);
        if (string.charAt(0) == '[') {
            string = M.c(string);
        }
        return string;
    }

    public String b() {
        J j2 = this.a();
        int n2 = this.a(j2);
        return j2.m(j2.b(n2));
    }

    @Override
    public I a() {
        return this.a().a(this.b(), this.d());
    }

    public String d() {
        J j2 = this.a();
        int n2 = this.a(j2);
        return j2.m(j2.c(n2));
    }

    @Override
    public CtClass[] a() {
        return super.a();
    }

    public boolean a() {
        return this.a.a(this.a) == 183 && !this.a().a().a().equals(this.c());
    }

    @Override
    public void a(String string) {
        String string2;
        String string3;
        String string4;
        int n2;
        this.a.a();
        J j2 = this.a();
        int n3 = this.a;
        int n4 = this.a.c(n3 + 1);
        int n5 = this.a.a(n3);
        if (n5 == 185) {
            n2 = 5;
            string4 = j2.i(n4);
            string3 = j2.j(n4);
            string2 = j2.k(n4);
        } else if (n5 == 184 || n5 == 183 || n5 == 182) {
            n2 = 3;
            string4 = j2.f(n4);
            string3 = j2.g(n4);
            string2 = j2.h(n4);
        } else {
            throw new a("not method invocation");
        }
        javassist.compiler.f f2 = new javassist.compiler.f(this.a);
        f f3 = this.a.a();
        r r2 = this.a.a();
        try {
            CtClass[] ctClassArray = M.a(string2, f3);
            CtClass ctClass = M.a(string2, f3);
            int n6 = r2.d();
            f2.a(string4, ctClassArray, true, n6, this.c());
            int n7 = f2.a(ctClass, true);
            if (n5 == 184) {
                f2.b(string4, string3);
            } else if (n5 == 183) {
                f2.a("$0", string4, string3, string2, n4);
            } else {
                f2.a("$0", string3);
            }
            n.a(ctClass, string);
            javassist.bytecode.n n8 = f2.a();
            n.a(ctClassArray, n5 == 184, n6, n8);
            f2.a(r2, n3);
            if (ctClass != CtClass.i) {
                n8.a(ctClass);
                n8.b(n7, ctClass);
            }
            f2.a(string);
            if (ctClass != CtClass.i) {
                n8.a(n7, ctClass);
            }
            this.a(n3, n8, n2);
        } catch (e e2) {
            throw new a(e2);
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (i i2) {
            throw new a("broken method");
        }
    }
}

