/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.bytecode.T;
import javassist.bytecode.al;
import javassist.bytecode.i;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.expr.a;
import javassist.expr.c;
import javassist.expr.d;
import javassist.expr.f;
import javassist.expr.g;
import javassist.expr.h;
import javassist.expr.k;
import javassist.expr.l;
import javassist.expr.n;
import javassist.expr.o;
import javassist.expr.q;

public class e {
    public boolean a(CtClass ctClass, al al2) {
        r r2 = al2.a();
        if (r2 == null) {
            return false;
        }
        u u2 = r2.a();
        boolean bl2 = false;
        f f2 = new f(r2.d());
        while (u2.a()) {
            if (!this.a(u2, ctClass, al2, f2)) continue;
            bl2 = true;
        }
        T t2 = r2.a();
        int n2 = t2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            k k2 = new k(t2, i2, u2, ctClass, al2);
            this.a(k2);
            if (!k2.b()) continue;
            bl2 = true;
            f2.a(k2.b(), k2.c());
        }
        if (r2.d() < f2.a) {
            r2.b(f2.a);
        }
        r2.a(r2.a() + f2.b);
        try {
            if (bl2) {
                al2.a(ctClass.a(), ctClass.b());
            }
        } catch (i i3) {
            throw new javassist.a(i3.getMessage(), i3);
        }
        return bl2;
    }

    boolean a(CtClass ctClass, al al2, f f2, u u2, int n2) {
        boolean bl2 = false;
        while (u2.a() && u2.e() < n2) {
            int n3 = u2.c();
            if (!this.a(u2, ctClass, al2, f2)) continue;
            bl2 = true;
            int n4 = u2.c();
            if (n3 == n4) continue;
            n2 += n4 - n3;
        }
        return bl2;
    }

    final boolean a(u u2, CtClass ctClass, al al2, f f2) {
        try {
            d d2 = null;
            int n2 = u2.d();
            int n3 = u2.a(n2);
            if (n3 >= 178) {
                if (n3 < 188) {
                    if (n3 == 184 || n3 == 185 || n3 == 182) {
                        d2 = new n(n2, u2, ctClass, al2);
                        this.a((n)d2);
                    } else if (n3 == 180 || n3 == 178 || n3 == 181 || n3 == 179) {
                        d2 = new h(n2, u2, ctClass, al2, n3);
                        this.a((h)d2);
                    } else if (n3 == 187) {
                        int n4 = u2.c(n2 + 1);
                        f2.a = new g(f2.a, n2, al2.a().a(n4));
                    } else if (n3 == 183) {
                        g g2 = f2.a;
                        if (g2 != null && al2.a().a(g2.a, u2.c(n2 + 1)) > 0) {
                            d2 = new q(n2, u2, ctClass, al2, g2.a, g2.a);
                            this.a((q)d2);
                            f2.a = g2.a;
                        } else {
                            n n5 = new n(n2, u2, ctClass, al2);
                            if (n5.b().equals("<init>")) {
                                c c2 = new c(n2, u2, ctClass, al2);
                                d2 = c2;
                                this.a(c2);
                            } else {
                                d2 = n5;
                                this.a(n5);
                            }
                        }
                    }
                } else if (n3 == 188 || n3 == 189 || n3 == 197) {
                    d2 = new o(n2, u2, ctClass, al2, n3);
                    this.a((o)d2);
                } else if (n3 == 193) {
                    d2 = new l(n2, u2, ctClass, al2);
                    this.a((l)d2);
                } else if (n3 == 192) {
                    d2 = new a(n2, u2, ctClass, al2);
                    this.a((a)d2);
                }
            }
            if (d2 != null && d2.b()) {
                f2.a(d2.b(), d2.c());
                return true;
            }
            return false;
        } catch (i i2) {
            throw new javassist.a(i2);
        }
    }

    public void a(q q2) {
    }

    public void a(o o2) {
    }

    public void a(n n2) {
    }

    public void a(c c2) {
    }

    public void a(h h2) {
    }

    public void a(l l2) {
    }

    public void a(a a2) {
    }

    public void a(k k2) {
    }
}

