/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.l;
import javassist.bytecode.x;

class z
extends x {
    z(int n2, int n3) {
        super(n2, n3);
    }

    @Override
    int b() {
        return this.d == 2 ? 5 : 0;
    }

    @Override
    void a(int n2, byte[] byArray, int n3, byte[] byArray2) {
        byArray2[n3] = (byte)this.a(byArray[n2] & 0xFF);
        byArray2[n3 + 1] = 0;
        byArray2[n3 + 2] = 8;
        byArray2[n3 + 3] = -56;
        l.b(this.c - 3, byArray2, n3 + 4);
    }

    int a(int n2) {
        if (n2 == 198) {
            return 199;
        }
        if (n2 == 199) {
            return 198;
        }
        if ((n2 - 153 & 1) == 0) {
            return n2 + 1;
        }
        return n2 - 1;
    }
}

