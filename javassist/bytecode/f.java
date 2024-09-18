/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.E;
import javassist.bytecode.l;
import javassist.bytecode.w;

abstract class F
extends w {
    int c;
    int d;
    int[] b;
    E a;

    F(int n2, int n3, int[] nArray, E e2) {
        super(n2);
        this.c = 3 - (n2 & 3);
        this.d = n3;
        this.b = nArray;
        this.a = e2;
    }

    @Override
    void a(int n2, int n3, boolean bl2) {
        E e2 = this.a;
        this.d = F.a((int)e2, this.d, n2, n3, bl2);
        int n4 = this.b.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            this.b[i2] = F.a((int)e2, this.b[i2], n2, n3, bl2);
        }
        super.a(n2, n3, bl2);
    }

    @Override
    int a() {
        int n2 = 3 - (this.a & 3);
        if (n2 > this.c) {
            int n3 = n2 - this.c;
            this.c = n2;
            return n3;
        }
        return 0;
    }

    @Override
    int b() {
        return this.c - (3 - (this.b & 3));
    }

    @Override
    int a(int n2, byte[] byArray, int n3, byte[] byArray2) {
        int n4 = 3 - (this.a & 3);
        int n5 = this.c - n4;
        int n6 = 5 + (3 - (this.b & 3)) + this.c();
        if (n5 > 0) {
            this.a(n6, n5);
        }
        byArray2[n3++] = byArray[n2];
        while (n4-- > 0) {
            byArray2[n3++] = 0;
        }
        l.b(this.d, byArray2, n3);
        int n7 = this.a(n3 + 4, byArray2);
        n3 += n7 + 4;
        while (n5-- > 0) {
            byArray2[n3++] = 0;
        }
        return 5 + (3 - (this.b & 3)) + n7;
    }

    abstract int a(int var1, byte[] var2);

    abstract int c();

    void a(int n2, int n3) {
        this.a.a((int)(this.a + n2), n3);
        if (this.d == n2) {
            this.d -= n3;
        }
        for (int i2 = 0; i2 < this.b.length; ++i2) {
            if (this.b[i2] != n2) continue;
            int n4 = i2;
            this.b[n4] = this.b[n4] - n3;
        }
    }
}

