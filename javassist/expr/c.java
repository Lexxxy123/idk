/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.CtClass;
import javassist.I;
import javassist.aa;
import javassist.bytecode.al;
import javassist.bytecode.u;
import javassist.expr.n;
import javassist.q;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c
extends n {
    protected c(int n2, u u2, CtClass ctClass, al al2) {
        super(n2, u2, ctClass, al2);
    }

    @Override
    public String b() {
        return this.a() ? "super" : "this";
    }

    @Override
    public I a() {
        throw new aa("this is a constructor call.  Call getConstructor().");
    }

    @Override
    public q a() {
        return this.a().a(this.d());
    }

    @Override
    public boolean a() {
        return super.a();
    }
}

