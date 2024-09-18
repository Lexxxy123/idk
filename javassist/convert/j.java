/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.bytecode.J;
import javassist.bytecode.u;
import javassist.convert.i;
import javassist.convert.k;
import javassist.r;

public final class j
extends i {
    public j(k k2, r r2, String string, String string2) {
        super(k2, r2, string, string2);
    }

    @Override
    public int a(CtClass ctClass, int n2, u u2, J j2) {
        int n3 = u2.a(n2);
        if (n3 == 181 || n3 == 179) {
            int n4 = u2.c(n2 + 1);
            String string = j.a(ctClass.a(), j2, this.a, this.a, this.a, n4);
            if (string != null) {
                if (n3 == 179) {
                    javassist.bytecode.r r2 = u2.a();
                    u2.a(n2);
                    char c2 = string.charAt(0);
                    if (c2 == 'J' || c2 == 'D') {
                        n2 = u2.f(3);
                        u2.a(1, n2);
                        u2.a(91, n2 + 1);
                        u2.a(87, n2 + 2);
                        r2.a(r2.a() + 2);
                    } else {
                        n2 = u2.f(2);
                        u2.a(1, n2);
                        u2.a(95, n2 + 1);
                        r2.a(r2.a() + 1);
                    }
                    n2 = u2.d();
                }
                int n5 = j2.a(this.b);
                String string2 = "(Ljava/lang/Object;" + string + ")V";
                int n6 = j2.b(n5, this.c, string2);
                u2.a(184, n2);
                u2.b(n6, n2 + 1);
            }
        }
        return n2;
    }
}

