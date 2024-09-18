/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.aL;
import javassist.bytecode.aT;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class aM
extends aT {
    byte[] a;
    J a;
    J b;
    Map<String, String> a;

    aM(aL aL2, J j2, Map<String, String> map) {
        super(aL2);
        this.a = aL2.a();
        this.a = new byte[((J)this.b).length];
        this.b = j2;
        this.a = (byte[])map;
    }

    @Override
    public void a() {
        int n2 = l.a((byte[])this.b, 0);
        l.a(n2, this.a, 0);
        super.a();
    }

    @Override
    public int a(int n2, int n3, int n4) {
        l.a(n3, this.a, n2 - 4);
        return super.a(n2, n3, n4);
    }

    @Override
    public int a(int n2, int n3, int n4, boolean bl2) {
        l.a(n4, this.a, n2 - 2);
        return super.a(n2, n3, n4, bl2);
    }

    @Override
    public void a(int n2, byte by) {
        this.a[n2] = by;
    }

    @Override
    public void a(int n2, int n3) {
        this.a[n2] = 7;
        int n4 = this.a.a(n3, this.b, (Map<String, String>)this.a);
        l.a(n4, this.a, n2 + 1);
    }

    @Override
    public void b(int n2, int n3) {
        this.a[n2] = 8;
        l.a(n3, this.a, n2 + 1);
    }

    public aL a() {
        return new aL(this.b, this.a);
    }
}

