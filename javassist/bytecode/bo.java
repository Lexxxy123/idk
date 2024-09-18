/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.bn;
import javassist.bytecode.g;

class bo
extends g {
    bn a;

    bo(byte[] byArray) {
        super(byArray);
        this.a = new bn(byArray);
    }

    @Override
    int a(int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.a[n2] & 0xFF;
            n2 = this.a.b(n2 + 1, n4);
            n2 = this.a.a(n2);
            n2 = this.e(n2);
        }
        return n2;
    }
}

