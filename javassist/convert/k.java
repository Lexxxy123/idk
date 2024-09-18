/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.bytecode.J;
import javassist.bytecode.al;
import javassist.bytecode.at;
import javassist.bytecode.r;
import javassist.bytecode.u;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class k
implements at {
    private k a;

    public k(k k2) {
        this.a = k2;
    }

    public k a() {
        return this.a;
    }

    public void a(J j2, r r2) {
    }

    public void a(J j2, CtClass ctClass, al al2) {
        this.a(j2, al2.a());
    }

    public void a() {
    }

    public abstract int a(CtClass var1, int var2, u var3, J var4);

    public int a() {
        return 0;
    }

    public int b() {
        return 0;
    }
}

