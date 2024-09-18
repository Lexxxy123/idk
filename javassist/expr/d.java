/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import java.util.LinkedList;
import java.util.List;
import javassist.CtClass;
import javassist.S;
import javassist.a;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.V;
import javassist.bytecode.al;
import javassist.bytecode.at;
import javassist.bytecode.h;
import javassist.bytecode.n;
import javassist.bytecode.o;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.expr.e;
import javassist.expr.f;
import javassist.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class d
implements at {
    int a;
    u a;
    CtClass a;
    al a;
    boolean a;
    int b;
    int c;
    static final String a = "java.lang.Object";

    protected d(int n2, u u2, CtClass ctClass, al al2) {
        this.a = n2;
        this.a = u2;
        this.a = ctClass;
        this.a = al2;
    }

    public CtClass b() {
        return this.a;
    }

    protected final J a() {
        return this.a.a();
    }

    protected final boolean b() {
        return this.a;
    }

    protected final int b() {
        return this.b;
    }

    protected final int c() {
        return this.c;
    }

    protected final boolean c() {
        return (this.a.a() & 8) != 0;
    }

    public m a() {
        al al2 = this.a;
        m[] mArray = this.a.a();
        for (int i2 = mArray.length - 1; i2 >= 0; --i2) {
            if (mArray[i2].b() != al2) continue;
            return mArray[i2];
        }
        m m2 = this.a.a();
        if (m2 != null && m2.b() == al2) {
            return m2;
        }
        for (int i3 = mArray.length - 1; i3 >= 0; --i3) {
            if (!this.a.a().equals(mArray[i3].b().a()) || !this.a.b().equals(mArray[i3].b().b())) continue;
            return mArray[i3];
        }
        throw new RuntimeException("fatal: not found");
    }

    public CtClass[] a() {
        int n2;
        int n3;
        String[] stringArray;
        h h2;
        javassist.f f2 = this.a.a();
        J j2 = this.a.a();
        LinkedList<CtClass> linkedList = new LinkedList<CtClass>();
        try {
            h2 = this.a.a();
            stringArray = ((r)h2).a();
            n3 = this.a;
            n2 = stringArray.a();
            for (int i2 = 0; i2 < n2; ++i2) {
                int n4;
                if (stringArray.a(i2) > n3 || n3 >= stringArray.b(i2) || (n4 = stringArray.d(i2)) <= 0) continue;
                try {
                    d.a(linkedList, f2.c(j2.a(n4)));
                    continue;
                } catch (aa aa2) {
                    // empty catch block
                }
            }
        } catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        if ((h2 = this.a.a()) != null && (stringArray = ((V)h2).a()) != null) {
            n3 = stringArray.length;
            for (n2 = 0; n2 < n3; ++n2) {
                try {
                    d.a(linkedList, f2.c(stringArray[n2]));
                    continue;
                } catch (aa aa3) {
                    // empty catch block
                }
            }
        }
        return linkedList.toArray(new CtClass[linkedList.size()]);
    }

    private static void a(List<CtClass> list, CtClass ctClass) {
        if (list.contains(ctClass)) {
            return;
        }
        list.add(ctClass);
    }

    public int d() {
        return this.a;
    }

    public int a() {
        return this.a.a(this.a);
    }

    public String a() {
        o o2 = this.a.b();
        if (o2 == null) {
            return null;
        }
        return o2.c();
    }

    static final boolean a(CtClass ctClass, String string) {
        boolean bl2;
        boolean bl3 = bl2 = string.indexOf("$_") >= 0;
        if (!bl2 && ctClass != CtClass.i) {
            throw new a("the resulting value is not stored in $_");
        }
        return bl2;
    }

    static final void a(CtClass[] ctClassArray, boolean bl2, int n2, n n3) {
        d.a(0, ctClassArray.length, ctClassArray, n2 + 1, n3);
        if (bl2) {
            n3.g(1);
        }
        n3.l(n2);
    }

    private static void a(int n2, int n3, CtClass[] ctClassArray, int n4, n n5) {
        if (n2 >= n3) {
            return;
        }
        CtClass ctClass = ctClassArray[n2];
        int n6 = ctClass instanceof S ? ((S)ctClass).d() : 1;
        d.a(n2 + 1, n3, ctClassArray, n4 + n6, n5);
        n5.b(n4, ctClass);
    }

    public abstract void a(String var1);

    public void a(String string, e e2) {
        this.a(string);
        if (e2 != null) {
            this.a(e2, this.a);
        }
    }

    protected void a(int n2, n n3, int n4) {
        byte[] byArray = n3.b();
        this.a = true;
        int n5 = byArray.length - n4;
        for (int i2 = 0; i2 < n4; ++i2) {
            this.a.a(0, n2 + i2);
        }
        if (n5 > 0) {
            n2 = this.a.a((int)n2, (int)n5, (boolean)false).a;
        }
        this.a.a(byArray, n2);
        this.a.a(n3.a(), n2);
        this.b = n3.d();
        this.c = n3.c();
    }

    protected void a(e e2, u u2) {
        r r2 = u2.a();
        int n2 = r2.d();
        int n3 = r2.a();
        int n4 = this.b();
        r2.a(this.c());
        r2.b(n4);
        f f2 = new f(n4);
        int n5 = u2.c();
        int n6 = u2.e();
        u2.a(this.a);
        if (e2.a(this.a, this.a, f2, u2, n6)) {
            this.a = true;
        }
        u2.a(n6 + u2.c() - n5);
        r2.b(n2);
        r2.a(n3);
        this.b = f2.a;
        this.c += f2.b;
    }
}

