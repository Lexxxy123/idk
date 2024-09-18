/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aL;
import javassist.bytecode.aT;
import javassist.bytecode.aU;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class aR
extends aT {
    aU a = new aU();

    aR(aL aL2) {
        super(aL2);
    }

    byte[] a() {
        this.a();
        return this.a.a();
    }

    @Override
    public void a() {
        int n2 = l.a(this.b, 0);
        this.a.a(n2);
        super.a();
    }

    @Override
    public int a(int n2, int n3, int n4) {
        this.a.a(n3);
        return super.a(n2, n3, n4);
    }

    @Override
    public int a(int n2, int n3, int n4, boolean bl2) {
        this.a.a(n4);
        return super.a(n2, n3, n4, bl2);
    }

    @Override
    public void a(int n2, byte by) {
        this.a.a(by, 0);
    }

    @Override
    public void a(int n2, int n3) {
        this.a.a(7, n3);
    }

    @Override
    public void b(int n2, int n3) {
        this.a.a(8, n3);
    }
}

