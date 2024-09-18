/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.I;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.n;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.convert.d;
import javassist.convert.k;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c
extends d {
    protected CtClass[] a;
    protected int a;
    protected int b;
    protected byte[] a;
    protected byte[] b;

    public c(k k2, I i2, I i3) {
        super(k2, i2, i3);
        this.c = i2.b().b();
        this.a = i2.a();
        this.a = 0;
        this.b = 0;
        this.b = null;
        this.a = null;
    }

    @Override
    public void a(J j2, r r2) {
        super.a(j2, r2);
        this.a = 0;
        this.b = r2.d();
        this.b = null;
        this.a = null;
    }

    @Override
    protected int a(int n2, int n3, u u2, int n4, J j2) {
        if (this.c == 0) {
            String string = M.b(this.a) + 'V';
            string = M.b((String)this.a, string);
            int n5 = j2.a(this.e, string);
            int n6 = j2.a(this.d);
            this.c = j2.c(n6, n5);
            this.a = j2;
        }
        if (this.a == null) {
            this.a(this.a, j2);
        }
        return this.a(n3, u2);
    }

    protected int a(int n2, u u2) {
        u2.a(n2);
        u2.a(this.a);
        u2.a(this.b);
        int n3 = u2.f(3);
        u2.a(184, n3);
        u2.b(this.c, n3 + 1);
        u2.a(this.b);
        return u2.d();
    }

    @Override
    public int a() {
        return this.a;
    }

    protected void a(CtClass[] ctClassArray, J j2) {
        n n2 = new n(j2, 0, 0);
        n n3 = new n(j2, 0, 0);
        int n4 = this.b;
        int n5 = ctClassArray == null ? 0 : ctClassArray.length;
        n3.k(n4);
        this.a(n2, n3, 0, n5, ctClassArray, n4 + 1);
        n2.l(n4);
        this.a = n2.b();
        this.b = n3.b();
    }

    private void a(n n2, n n3, int n4, int n5, CtClass[] ctClassArray, int n6) {
        if (n4 < n5) {
            int n7 = n3.a(n6, ctClassArray[n4]);
            this.a(n2, n3, n4 + 1, n5, ctClassArray, n6 + n7);
            n2.b(n6, ctClassArray[n4]);
        } else {
            this.a = n6 - this.b;
        }
    }
}

