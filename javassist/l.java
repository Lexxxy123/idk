/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.J;
import javassist.bytecode.n;

class L
extends J {
    long a;

    L(long l2) {
        this.a = l2;
    }

    @Override
    int a(n n2) {
        n2.a(this.a);
        return 2;
    }

    @Override
    String a() {
        return "([Ljava/lang/Object;J)Ljava/lang/Object;";
    }

    @Override
    String c() {
        return "([Ljava/lang/Object;J)V";
    }
}

