/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.G;
import javassist.p;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class H
extends G {
    private G b = this;
    private G c = this;
    private G d = this;

    @Override
    protected void a(StringBuffer stringBuffer) {
    }

    @Override
    public boolean a(String string) {
        return false;
    }

    @Override
    public Object a(Class<?> clazz) {
        return null;
    }

    @Override
    public Object[] a() {
        return null;
    }

    @Override
    public byte[] a(String string) {
        return null;
    }

    @Override
    public Object[] b() {
        return null;
    }

    @Override
    public int a() {
        return 0;
    }

    @Override
    public String d() {
        return null;
    }

    @Override
    public String b() {
        return null;
    }

    @Override
    public void a(String string, byte[] byArray) {
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public String c() {
        return null;
    }

    @Override
    public void a(String string) {
    }

    H(p p2) {
        super(p2);
        this.d.a = this;
    }

    G b() {
        return this;
    }

    G c() {
        return this.b;
    }

    G d() {
        return this.b;
    }

    G e() {
        return this.c;
    }

    G f() {
        return this.c;
    }

    G g() {
        return this.d;
    }

    void a(G g2) {
        g2.a = this.b.a;
        this.b.a = g2;
        if (this.b == this.c) {
            this.c = g2;
            if (this.b == this.d) {
                this.d = g2;
            }
        }
        this.b = g2;
    }

    void b(G g2) {
        g2.a = this.c.a;
        this.c.a = g2;
        if (this.c == this.d) {
            this.d = g2;
        }
        this.c = g2;
    }

    void c(G g2) {
        g2.a = this;
        this.d.a = g2;
        this.d = g2;
    }

    static int a(G g2, G g3) {
        int n2 = 0;
        while (g2 != g3) {
            ++n2;
            g2 = g2.a;
        }
        return n2;
    }

    void d(G g2) {
        G g3;
        G g4 = this;
        while ((g3 = g4.a) != this) {
            if (g3 == g2) {
                g4.a = g3.a;
                if (g3 == this.b) {
                    this.b = g4;
                }
                if (g3 == this.c) {
                    this.c = g4;
                }
                if (g3 != this.d) break;
                this.d = g4;
                break;
            }
            g4 = g4.a;
        }
    }
}

