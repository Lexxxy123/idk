/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.Z;
import javassist.bytecode.J;
import javassist.bytecode.u;
import javassist.convert.i;
import javassist.convert.k;
import javassist.r;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class f
extends k {
    private String a;
    private String b;
    private String c;
    private CtClass a;
    private boolean a;
    private int a;
    private J a;

    public f(k k2, r r2, String string, String string2) {
        super(k2);
        this.a = r2.a();
        this.c = r2.d();
        this.a = Z.b(r2.a());
        this.a = string;
        this.b = string2;
        this.a = null;
    }

    @Override
    public void a(J j2, javassist.bytecode.r r2) {
        if (this.a != j2) {
            this.a = 0;
        }
    }

    @Override
    public int a(CtClass ctClass, int n2, u u2, J j2) {
        int n3 = u2.a(n2);
        if (n3 == 180 || n3 == 178 || n3 == 181 || n3 == 179) {
            int n4 = u2.c(n2 + 1);
            String string = i.a(ctClass.a(), j2, this.a, this.c, this.a, n4);
            if (string != null) {
                if (this.a == 0) {
                    int n5 = j2.a(this.b, string);
                    this.a = j2.b(j2.a(this.a), n5);
                    this.a = j2;
                }
                u2.b(this.a, n2 + 1);
            }
        }
        return n2;
    }
}

