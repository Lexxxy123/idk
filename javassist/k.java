/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.J;
import javassist.bytecode.n;

class K
extends J {
    int a;

    K(int n2) {
        this.a = n2;
    }

    @Override
    int a(n n2) {
        n2.m(this.a);
        return 1;
    }

    @Override
    String a() {
        return "([Ljava/lang/Object;I)Ljava/lang/Object;";
    }

    @Override
    String c() {
        return "([Ljava/lang/Object;I)V";
    }
}

