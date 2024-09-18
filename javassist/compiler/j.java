/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.CtClass;
import javassist.compiler.ast.b;
import javassist.r;

public class j
extends r {
    private b a = null;

    j(CtClass ctClass, String string, CtClass ctClass2) {
        super(ctClass, string, ctClass2);
    }

    protected void a(b b2) {
        this.a = b2;
    }

    @Override
    protected b a() {
        return this.a;
    }
}

