/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aL;
import javassist.bytecode.aT;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class aQ
extends aT {
    private int a;
    private int b;
    private boolean a;

    public aQ(aL aL2, int n2, int n3, boolean bl2) {
        super(aL2);
        this.a = n2;
        this.b = n3;
        this.a = bl2;
    }

    @Override
    public int a(int n2, int n3, int n4) {
        if (this.a ? this.a <= n3 : this.a < n3) {
            l.a(n3 + this.b, (byte[])this.b, n2 - 4);
        }
        return super.a(n2, n3, n4);
    }

    @Override
    public void b(int n2, int n3) {
        if (this.a <= n3) {
            l.a(n3 + this.b, (byte[])this.b, n2 + 1);
        }
    }
}

