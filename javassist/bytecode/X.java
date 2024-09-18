/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.l;
import javassist.bytecode.w;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class x
extends w {
    int c;
    int d;
    static final int e = 0;
    static final int f = 1;
    static final int g = 2;

    x(int n2, int n3) {
        super(n2);
        this.c = n3;
        this.d = 0;
    }

    @Override
    void a(int n2, int n3, boolean bl2) {
        this.c = x.a(this.a, this.c, n2, n3, bl2);
        super.a(n2, n3, bl2);
        if (this.d == 0 && (this.c < Short.MIN_VALUE || Short.MAX_VALUE < this.c)) {
            this.d = 1;
        }
    }

    @Override
    boolean a() {
        if (this.d == 1) {
            this.d = 2;
            return true;
        }
        return false;
    }

    @Override
    abstract int b();

    abstract void a(int var1, byte[] var2, int var3, byte[] var4);

    @Override
    int a(int n2, byte[] byArray, int n3, byte[] byArray2) {
        if (this.d == 2) {
            this.a(n2, byArray, n3, byArray2);
        } else {
            byArray2[n3] = byArray[n2];
            l.a(this.c, byArray2, n3 + 1);
        }
        return 3;
    }
}

