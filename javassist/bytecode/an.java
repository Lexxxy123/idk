/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aL;
import javassist.bytecode.aR;

class aN
extends aR {
    private int a;
    private int b;
    private int c;

    aN(aL aL2, int n2, int n3, int n4) {
        super(aL2);
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    @Override
    public int a(int n2, int n3, int n4, boolean bl2) {
        if (!bl2 || n4 < this.a) {
            return super.a(n2, n3, n4, bl2);
        }
        this.a.a(n4 + 1);
        for (int i2 = 0; i2 < n4; ++i2) {
            if (i2 == this.a) {
                this.b();
            }
            n2 = this.a(i2, n2);
        }
        if (n4 == this.a) {
            this.b();
        }
        return n2;
    }

    private void b() {
        if (this.b == 7) {
            this.a.a(7, this.c);
        } else if (this.b == 8) {
            this.a.a(8, this.c);
        } else {
            this.a.a(this.b, 0);
        }
    }
}

