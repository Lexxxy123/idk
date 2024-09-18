/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.a;
import javassist.bytecode.J;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.convert.k;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class h
extends k {
    private int a;
    private String a;
    private String b;
    private int b;
    private int c;
    private int d;

    public h(k k2, String string, String string2) {
        super(k2);
        this.a = string;
        this.b = string2;
    }

    @Override
    public void a(J j2, r r2) {
        this.a = 0;
        this.d = 0;
        this.c = 0;
        this.b = 0;
    }

    @Override
    public int a(CtClass ctClass, int n2, u u2, J j2) {
        int n3;
        int n4;
        int n5 = u2.a(n2);
        if (n5 == 187) {
            int n6 = u2.c(n2 + 1);
            if (j2.a(n6).equals(this.a)) {
                if (u2.a(n2 + 3) != 89) {
                    throw new a("NEW followed by no DUP was found");
                }
                if (this.b == 0) {
                    this.b = j2.a(this.b);
                }
                u2.b(this.b, n2 + 1);
                ++this.a;
            }
        } else if (n5 == 183 && (n4 = j2.a(this.a, n3 = u2.c(n2 + 1))) != 0 && this.a > 0) {
            int n7 = j2.i(n3);
            if (this.c != n7) {
                this.c = n7;
                this.d = j2.c(this.b, n7);
            }
            u2.b(this.d, n2 + 1);
            --this.a;
        }
        return n2;
    }
}

