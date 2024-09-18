/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.l;
import javassist.bytecode.w;

class B
extends w {
    int c;

    B(int n2, int n3) {
        super(n2);
        this.c = n3;
    }

    @Override
    void a(int n2, int n3, boolean bl2) {
        this.c = B.a(this.a, this.c, n2, n3, bl2);
        super.a(n2, n3, bl2);
    }

    @Override
    int a(int n2, byte[] byArray, int n3, byte[] byArray2) {
        byArray2[n3] = byArray[n2];
        l.b(this.c, byArray2, n3 + 1);
        return 5;
    }
}

