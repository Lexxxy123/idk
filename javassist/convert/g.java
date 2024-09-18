/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.a;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.aL;
import javassist.bytecode.aV;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.convert.k;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class g
extends k {
    private int a;
    private String a;
    private String b;
    private String c;

    public g(k k2, String string, String string2, String string3) {
        super(k2);
        this.a = string;
        this.b = string2;
        this.c = string3;
    }

    @Override
    public void a(J j2, r r2) {
        this.a = 0;
    }

    @Override
    public int a(CtClass ctClass, int n2, u u2, J j2) {
        int n3;
        int n4;
        int n5 = u2.a(n2);
        if (n5 == 187) {
            int n6 = u2.c(n2 + 1);
            if (j2.a(n6).equals(this.a)) {
                aL aL2;
                if (u2.a(n2 + 3) != 89) {
                    throw new a("NEW followed by no DUP was found");
                }
                u2.a(0, n2);
                u2.a(0, n2 + 1);
                u2.a(0, n2 + 2);
                u2.a(0, n2 + 3);
                ++this.a;
                aV aV2 = (aV)u2.a().a("StackMapTable");
                if (aV2 != null) {
                    aV2.a(n2);
                }
                if ((aL2 = (aL)u2.a().a("StackMap")) != null) {
                    aL2.a(n2);
                }
            }
        } else if (n5 == 183 && (n4 = j2.a(this.a, n3 = u2.c(n2 + 1))) != 0 && this.a > 0) {
            int n7 = this.a(n4, j2);
            u2.a(184, n2);
            u2.b(n7, n2 + 1);
            --this.a;
        }
        return n2;
    }

    private int a(int n2, J j2) {
        int n3 = j2.a(this.b);
        int n4 = j2.c(this.c);
        n2 = j2.c(M.c(this.a, j2.m(n2)));
        return j2.c(n3, j2.a(n4, n2));
    }
}

