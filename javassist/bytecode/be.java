/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aV;
import javassist.bytecode.bc;
import javassist.bytecode.l;

class be
extends bc {
    be(aV aV2, int n2, int n3) {
        super(aV2, n2, n3, false);
    }

    @Override
    void b(int n2, int n3, int n4, int n5) {
        int n6;
        this.c = n6 + n3 + ((n6 = this.c) == 0 ? 0 : 1);
        int n7 = n3;
        if (this.a == this.c) {
            n7 = n3 - this.b;
        } else if (this.a == n6) {
            n7 = n3 + this.b;
        } else {
            return;
        }
        if (n3 < 64) {
            if (n7 < 64) {
                this.b[n2] = (byte)(n7 + n4);
            } else {
                byte[] byArray = be.a(this.b, n2, 2);
                byArray[n2] = (byte)n5;
                l.a(n7, byArray, n2 + 1);
                this.a = byArray;
            }
        } else if (n7 < 64) {
            byte[] byArray = be.b(this.b, n2, 2);
            byArray[n2] = (byte)(n7 + n4);
            this.a = byArray;
        } else {
            l.a(n7, this.b, n2 + 1);
        }
    }

    static byte[] b(byte[] byArray, int n2, int n3) {
        n2 += n3;
        int n4 = byArray.length;
        byte[] byArray2 = new byte[n4 - n3];
        for (int i2 = 0; i2 < n4; ++i2) {
            byArray2[i2 - (i2 < n2 ? 0 : n3)] = byArray[i2];
        }
        return byArray2;
    }

    @Override
    void b(int n2, int n3) {
        int n4;
        this.c = n4 + n3 + ((n4 = this.c) == 0 ? 0 : 1);
        int n5 = n3;
        if (this.a == this.c) {
            n5 = n3 - this.b;
        } else if (this.a == n4) {
            n5 = n3 + this.b;
        } else {
            return;
        }
        l.a(n5, this.b, n2 + 1);
    }
}

