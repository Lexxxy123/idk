/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aL;
import javassist.bytecode.aR;
import javassist.bytecode.l;

class aO
extends aR {
    int a;

    aO(aL aL2, int n2) {
        super(aL2);
        this.a = n2;
    }

    @Override
    public int b(int n2, int n3, int n4) {
        return this.c(n2, n3, n4);
    }

    private int c(int n2, int n3, int n4) {
        int n5;
        byte by;
        int n6;
        int n7 = n2;
        int n8 = 0;
        for (n6 = 0; n6 < n4; ++n6) {
            by = this.b[n7];
            if (by == 7) {
                n7 += 3;
                continue;
            }
            if (by == 8) {
                n5 = l.a(this.b, n7 + 1);
                if (n5 == this.a) {
                    ++n8;
                }
                n7 += 3;
                continue;
            }
            ++n7;
        }
        this.a.a(n4 - n8);
        for (n6 = 0; n6 < n4; ++n6) {
            by = this.b[n2];
            if (by == 7) {
                n5 = l.a(this.b, n2 + 1);
                this.a(n2, n5);
                n2 += 3;
                continue;
            }
            if (by == 8) {
                n5 = l.a(this.b, n2 + 1);
                if (n5 != this.a) {
                    this.b(n2, n5);
                }
                n2 += 3;
                continue;
            }
            this.a(n2, by);
            ++n2;
        }
        return n2;
    }
}

