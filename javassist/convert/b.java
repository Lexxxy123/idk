/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.I;
import javassist.bytecode.u;
import javassist.convert.c;
import javassist.convert.k;

public class b
extends c {
    public b(k k2, I i2, I i3) {
        super(k2, i2, i3);
    }

    @Override
    protected int a(int n2, u u2) {
        u2.a(n2);
        u2.a(this.a);
        u2.a(this.b);
        int n3 = u2.f(3);
        u2.b(n3);
        u2.a(this.b);
        n2 = u2.d();
        n3 = u2.a();
        u2.a(u2.a(n2), n3);
        u2.b(u2.c(n2 + 1), n3 + 1);
        u2.a(184, n2);
        u2.b(this.c, n2 + 1);
        u2.a(n3);
        return u2.d();
    }
}

