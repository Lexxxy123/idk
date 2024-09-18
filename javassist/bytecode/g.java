/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.E;
import javassist.bytecode.F;
import javassist.bytecode.l;

class G
extends F {
    int e;
    int f;

    G(int n2, int n3, int n4, int n5, int[] nArray, E e2) {
        super(n2, n3, nArray, e2);
        this.e = n4;
        this.f = n5;
    }

    @Override
    int a(int n2, byte[] byArray) {
        l.b(this.e, byArray, n2);
        l.b(this.f, byArray, n2 + 4);
        int n3 = this.b.length;
        n2 += 8;
        for (int i2 = 0; i2 < n3; ++i2) {
            l.b(this.b[i2], byArray, n2);
            n2 += 4;
        }
        return 8 + 4 * n3;
    }

    @Override
    int c() {
        return 8 + 4 * this.b.length;
    }
}

