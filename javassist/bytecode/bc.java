/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aV;
import javassist.bytecode.bf;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class bc
extends bf {
    private aV a;
    int a;
    int b;
    int c;
    byte[] a;
    boolean a;

    public bc(aV aV2, int n2, int n3, boolean bl2) {
        super(aV2);
        this.a = aV2;
        this.a = n2;
        this.b = n3;
        this.c = 0;
        this.a = null;
        this.a = bl2;
    }

    public void a() {
        this.b();
        if (this.a != null) {
            this.a.a(this.a);
        }
    }

    @Override
    public void a(int n2, int n3) {
        this.b(n2, n3, 0, 251);
    }

    @Override
    public void a(int n2, int n3, int n4, int n5) {
        this.b(n2, n3, 64, 247);
    }

    void b(int n2, int n3, int n4, int n5) {
        boolean bl2;
        int n6;
        this.c = n6 + n3 + ((n6 = this.c) == 0 ? 0 : 1);
        if (this.a) {
            bl2 = n6 < this.a && this.a <= this.c;
        } else {
            boolean bl3 = bl2 = n6 <= this.a && this.a < this.c;
        }
        if (bl2) {
            int n7 = n3 + this.b;
            this.c += this.b;
            if (n7 < 64) {
                this.b[n2] = (byte)(n7 + n4);
            } else if (n3 < 64) {
                byte[] byArray = bc.a((byte[])this.b, n2, 2);
                byArray[n2] = (byte)n5;
                l.a(n7, byArray, n2 + 1);
                this.a = byArray;
            } else {
                l.a(n7, (byte[])this.b, n2 + 1);
            }
        }
    }

    static byte[] a(byte[] byArray, int n2, int n3) {
        int n4 = byArray.length;
        byte[] byArray2 = new byte[n4 + n3];
        for (int i2 = 0; i2 < n4; ++i2) {
            byArray2[i2 + (i2 < n2 ? 0 : n3)] = byArray[i2];
        }
        return byArray2;
    }

    @Override
    public void b(int n2, int n3, int n4) {
        this.b(n2, n3);
    }

    @Override
    public void a(int n2, int n3, int[] nArray, int[] nArray2) {
        this.b(n2, n3);
    }

    @Override
    public void a(int n2, int n3, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4) {
        this.b(n2, n3);
    }

    void b(int n2, int n3) {
        boolean bl2;
        int n4;
        this.c = n4 + n3 + ((n4 = this.c) == 0 ? 0 : 1);
        if (this.a) {
            bl2 = n4 < this.a && this.a <= this.c;
        } else {
            boolean bl3 = bl2 = n4 <= this.a && this.a < this.c;
        }
        if (bl2) {
            int n5 = n3 + this.b;
            l.a(n5, (byte[])this.b, n2 + 1);
            this.c += this.b;
        }
    }
}

