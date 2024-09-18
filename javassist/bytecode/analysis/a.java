/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import javassist.CtClass;
import javassist.I;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.T;
import javassist.bytecode.al;
import javassist.bytecode.analysis.c;
import javassist.bytecode.analysis.d;
import javassist.bytecode.analysis.e;
import javassist.bytecode.analysis.f;
import javassist.bytecode.analysis.k;
import javassist.bytecode.analysis.l;
import javassist.bytecode.analysis.m;
import javassist.bytecode.analysis.n;
import javassist.bytecode.at;
import javassist.bytecode.i;
import javassist.bytecode.r;
import javassist.bytecode.u;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
implements at {
    private final l a;
    private CtClass a;
    private c[] a;
    private e[] a;
    private k[] a = new l();

    public e[] a(CtClass ctClass, al al2) {
        this.a = ctClass;
        r r2 = al2.a();
        if (r2 == null) {
            return null;
        }
        int n2 = r2.d();
        int n3 = r2.a();
        int n4 = r2.e();
        u u2 = r2.a();
        f f2 = new f();
        this.a = this.a(al2);
        this.a = this.a.a(al2);
        d d2 = new d(ctClass.a(), al2.a());
        this.a = new e[n4];
        this.a[u2.e()] = this.a(al2, n2, n3);
        f2.a(u2.d());
        while (!f2.a()) {
            this.a(al2, u2, f2, d2);
        }
        return this.a;
    }

    public e[] a(I i2) {
        return this.a(i2.a(), i2.b());
    }

    private void a(al al2, u u2, f f2, d d2) {
        int n2 = f2.a();
        u2.a(n2);
        u2.d();
        e e2 = this.a[n2].a();
        k k2 = this.a[n2];
        try {
            d2.a(al2, n2, u2, e2, k2);
        } catch (RuntimeException runtimeException) {
            throw new i(runtimeException.getMessage() + "[pos = " + n2 + "]", (Throwable)runtimeException);
        }
        int n3 = u2.a(n2);
        if (n3 == 170) {
            this.b(f2, n2, u2, e2);
        } else if (n3 == 171) {
            this.a(f2, n2, u2, e2);
        } else if (n3 == 169) {
            this.a(f2, u2, n2, e2, k2);
        } else if (n.a(n3)) {
            int n4 = n.a(n2, u2);
            if (n.c(n3)) {
                this.a(f2, this.a[n2], this.a[n4], n2, this.a(u2, n2));
            } else if (!n.b(n3)) {
                this.a(f2, e2, this.a(u2, n2));
            }
            this.a(f2, e2, n4);
        } else if (n3 != 191 && !n.d(n3)) {
            this.a(f2, e2, this.a(u2, n2));
        }
        this.a(f2, al2, n2, e2);
    }

    private c[] a(al al2) {
        J j2 = al2.a();
        javassist.f f2 = this.a.a();
        T t2 = al2.a().a();
        c[] cArray = new c[t2.a()];
        for (int i2 = 0; i2 < t2.a(); ++i2) {
            m m2;
            int n2 = t2.d(i2);
            try {
                m2 = n2 == 0 ? m.q : m.a(f2.c(j2.a(n2)));
            } catch (aa aa2) {
                throw new IllegalStateException(aa2.getMessage());
            }
            cArray[i2] = new c(t2.a(i2), t2.b(i2), t2.c(i2), m2, null);
        }
        return cArray;
    }

    private e a(al al2, int n2, int n3) {
        CtClass[] ctClassArray;
        int n4 = 0;
        e e2 = new e(n2, n3);
        if ((al2.a() & 8) == 0) {
            e2.a(n4++, m.a(this.a));
        }
        try {
            ctClassArray = M.a(al2.b(), this.a.a());
        } catch (aa aa2) {
            throw new RuntimeException(aa2);
        }
        for (int i2 = 0; i2 < ctClassArray.length; ++i2) {
            m m2 = this.a(m.a(ctClassArray[i2]));
            e2.a(n4++, m2);
            if (m2.b() != 2) continue;
            e2.a(n4++, m.l);
        }
        return e2;
    }

    private int a(u u2, int n2, int n3) {
        u2.a(n2);
        u2.d();
        int n4 = u2.e();
        u2.a(n3);
        u2.d();
        return n4;
    }

    private int a(u u2, int n2) {
        if (!u2.a()) {
            throw new i("Execution falls off end! [pos = " + n2 + "]");
        }
        return u2.e();
    }

    private void a(f f2, e e2, int n2) {
        boolean bl2;
        e e3 = this.a[n2];
        if (e3 == null) {
            this.a[n2] = e2.a();
            bl2 = true;
        } else {
            bl2 = e3.b(e2);
        }
        if (bl2) {
            f2.a(n2);
        }
    }

    private void a(f f2, al al2, int n2, e e2) {
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            c c2 = this.a[i2];
            if (n2 < c.a(c2) || n2 >= c.b(c2)) continue;
            e e3 = e2.a();
            e3.a();
            e3.a(c.a(c2));
            this.a(f2, e3, c.c(c2));
        }
    }

    private void a(f f2, e e2, k k2, int n2, int n3) {
        if (k2 == null) {
            throw new i("No subroutine at jsr target! [pos = " + n2 + "]");
        }
        e e3 = this.a[n3];
        boolean bl2 = false;
        if (e3 == null) {
            e3 = this.a[n3] = e2.a();
            bl2 = true;
        } else {
            for (int i2 = 0; i2 < e2.b(); ++i2) {
                if (k2.a(i2)) continue;
                m m2 = e3.a(i2);
                m m3 = e2.a(i2);
                if (m2 == null) {
                    e3.a(i2, m3);
                    bl2 = true;
                    continue;
                }
                m3 = m2.a(m3);
                e3.a(i2, m3);
                if (m3.equals(m2) && !m3.a()) continue;
                bl2 = true;
            }
        }
        if (!e3.a()) {
            e3.a(true);
            bl2 = true;
        }
        if (bl2 && e3.b()) {
            f2.a(n3);
        }
    }

    private void a(f f2, int n2, u u2, e e2) {
        int n3 = (n2 & 0xFFFFFFFC) + 4;
        this.a(f2, e2, n2 + u2.e(n3));
        int n4 = u2.e(n3 += 4);
        int n5 = n4 * 8 + (n3 += 4);
        n3 += 4;
        while (n3 < n5) {
            int n6 = u2.e(n3) + n2;
            this.a(f2, e2, n6);
            n3 += 8;
        }
    }

    private void a(f f2, u u2, int n2, e e2, k k2) {
        if (k2 == null) {
            throw new i("Ret on no subroutine! [pos = " + n2 + "]");
        }
        for (int n3 : k2.b()) {
            int n4 = this.a(u2, n3, n2);
            boolean bl2 = false;
            e e3 = this.a[n4];
            if (e3 == null) {
                e3 = this.a[n4] = e2.b();
                bl2 = true;
            } else {
                bl2 = e3.a(e2);
            }
            for (int n5 : k2.a()) {
                m m2;
                m m3 = e3.a(n5);
                if (m3 == (m2 = e2.a(n5))) continue;
                e3.a(n5, m2);
                bl2 = true;
            }
            if (!e3.b()) {
                e3.b(true);
                bl2 = true;
            }
            if (!bl2 || !e3.a()) continue;
            f2.a(n4);
        }
    }

    private void b(f f2, int n2, u u2, e e2) {
        int n3 = (n2 & 0xFFFFFFFC) + 4;
        this.a(f2, e2, n2 + u2.e(n3));
        int n4 = u2.e(n3 += 4);
        int n5 = u2.e(n3 += 4);
        int n6 = (n5 - n4 + 1) * 4 + (n3 += 4);
        while (n3 < n6) {
            int n7 = u2.e(n3) + n2;
            this.a(f2, e2, n7);
            n3 += 4;
        }
    }

    private m a(m m2) {
        if (m2 == m.f || m2 == m.e || m2 == m.d || m2 == m.b) {
            return m.g;
        }
        return m2;
    }
}

