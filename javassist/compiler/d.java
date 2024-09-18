/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.bytecode.n;
import javassist.compiler.b;

public abstract class d {
    d a;

    protected abstract boolean a(n var1, int var2);

    protected d(b b2) {
        this.a = b2.a;
        b2.a = this;
    }

    protected void a(b b2) {
        b2.a = this.a;
    }
}

