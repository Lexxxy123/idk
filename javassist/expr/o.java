/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.S;
import javassist.a;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.al;
import javassist.bytecode.i;
import javassist.bytecode.n;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.compiler.e;
import javassist.compiler.f;
import javassist.expr.d;
import javassist.expr.p;
import javassist.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class o
extends d {
    int d;

    protected o(int n2, u u2, CtClass ctClass, al al2, int n3) {
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

    @Override
    public CtClass[] a() {
        return super.a();
    }

    public CtClass a() {
        if (this.d == 188) {
            int n2 = this.a.a(this.a + 1);
            return this.a(n2);
        }
        if (this.d == 189 || this.d == 197) {
            int n3 = this.a.c(this.a + 1);
            String string = this.a().a(n3);
            int n4 = M.b(string);
            string = M.a(string, n4);
            return M.b(string, this.a.a());
        }
        throw new RuntimeException("bad opcode: " + this.d);
    }

    CtClass a(int n2) {
        switch (n2) {
            case 4: {
                return CtClass.a;
            }
            case 5: {
                return CtClass.b;
            }
            case 6: {
                return CtClass.g;
            }
            case 7: {
                return CtClass.h;
            }
            case 8: {
                return CtClass.c;
            }
            case 9: {
                return CtClass.d;
            }
            case 10: {
                return CtClass.e;
            }
            case 11: {
                return CtClass.f;
            }
        }
        throw new RuntimeException("bad atype: " + n2);
    }

    public int e() {
        if (this.d == 188) {
            return 1;
        }
        if (this.d == 189 || this.d == 197) {
            int n2 = this.a.c(this.a + 1);
            String string = this.a().a(n2);
            return M.b(string) + (this.d == 189 ? 1 : 0);
        }
        throw new RuntimeException("bad opcode: " + this.d);
    }

    public int f() {
        if (this.d == 197) {
            return this.a.a(this.a + 3);
        }
        return 1;
    }

    @Override
    public void a(String string) {
        try {
            this.b(string);
        } catch (e e2) {
            throw new a(e2);
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (i i2) {
            throw new a("broken method");
        }
    }

    private void b(String string) {
        int n2;
        int n3;
        String string2;
        Object object;
        this.a.a();
        J j2 = this.a();
        int n4 = this.a;
        int n5 = 0;
        int n6 = 1;
        if (this.d == 188) {
            n5 = this.a.a(this.a + 1);
            object = (S)this.a(n5);
            string2 = "[" + ((S)object).a();
            n3 = 2;
        } else if (this.d == 189) {
            n5 = this.a.c(n4 + 1);
            string2 = j2.a(n5);
            string2 = string2.startsWith("[") ? "[" + string2 : "[L" + string2 + ";";
            n3 = 3;
        } else if (this.d == 197) {
            n5 = this.a.c(this.a + 1);
            string2 = j2.a(n5);
            n6 = this.a.a(this.a + 3);
            n3 = 4;
        } else {
            throw new RuntimeException("bad opcode: " + this.d);
        }
        CtClass ctClass = M.b(string2, this.a.a());
        object = new f(this.a);
        r r2 = this.a.a();
        CtClass[] ctClassArray = new CtClass[n6];
        for (n2 = 0; n2 < n6; ++n2) {
            ctClassArray[n2] = CtClass.e;
        }
        n2 = r2.d();
        ((f)object).a("java.lang.Object", ctClassArray, true, n2, this.c());
        o.a(ctClass, string);
        int n7 = ((f)object).a(ctClass, true);
        ((f)object).a(new p(ctClass, this.d, n5, n6));
        n n8 = ((f)object).a();
        o.a(ctClassArray, true, n2, n8);
        ((f)object).a(r2, n4);
        n8.g(1);
        n8.l(n7);
        ((f)object).a(string);
        n8.k(n7);
        this.a(n4, n8, n3);
    }
}

