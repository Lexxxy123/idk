/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.I;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.u;
import javassist.convert.d;
import javassist.convert.k;

public class e
extends d {
    public e(k k2, I i2, I i3) {
        super(k2, i2, i3);
        this.c = i2.b().b();
    }

    @Override
    protected int a(int n2, int n3, u u2, int n4, J j2) {
        if (this.c == 0) {
            String string = M.b(this.a, this.c);
            int n5 = j2.a(this.e, string);
            int n6 = j2.a(this.d);
            this.c = j2.c(n6, n5);
            this.a = j2;
        }
        u2.a(184, n3);
        u2.b(this.c, n3 + 1);
        return n3;
    }
}

