/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.bd;

class aY
extends bd {
    int a;

    public aY(byte[] byArray, int n2) {
        super(byArray);
        this.a = n2;
    }

    @Override
    public void a(int n2, int n3, int n4, int n5) {
        if (n4 == 8 && n5 == this.a) {
            super.a(n2, n3);
        } else {
            super.a(n2, n3, n4, n5);
        }
    }

    @Override
    public void a(int n2, int n3, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4) {
        int n4 = nArray3.length - 1;
        for (int i2 = 0; i2 < n4; ++i2) {
            if (nArray3[i2] != 8 || nArray4[i2] != this.a || nArray3[i2 + 1] != 8 || nArray4[i2 + 1] != this.a) continue;
            int[] nArray5 = new int[++n4 - 2];
            int[] nArray6 = new int[n4 - 2];
            int n5 = 0;
            for (int i3 = 0; i3 < n4; ++i3) {
                if (i3 == i2) {
                    ++i3;
                    continue;
                }
                nArray5[n5] = nArray3[i3];
                nArray6[n5++] = nArray4[i3];
            }
            nArray3 = nArray5;
            nArray4 = nArray6;
            break;
        }
        super.a(n2, n3, nArray, nArray2, nArray3, nArray4);
    }
}

