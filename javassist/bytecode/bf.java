/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aV;
import javassist.bytecode.i;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bf {
    byte[] b;
    int d;

    public bf(aV aV2) {
        this(aV2.a());
    }

    public bf(byte[] byArray) {
        this.b = byArray;
        this.d = l.a(byArray, 0);
    }

    public final int a() {
        return this.d;
    }

    public void b() {
        int n2 = this.d;
        int n3 = 2;
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = this.b(n3, i2);
        }
    }

    int b(int n2, int n3) {
        int n4 = this.b[n2] & 0xFF;
        if (n4 < 64) {
            this.a(n2, n4);
            ++n2;
        } else if (n4 < 128) {
            n2 = this.a(n2, n4);
        } else {
            if (n4 < 247) {
                throw new i("bad frame_type in StackMapTable");
            }
            if (n4 == 247) {
                n2 = this.a(n2, n4);
            } else if (n4 < 251) {
                int n5 = l.a(this.b, n2 + 1);
                this.b(n2, n5, 251 - n4);
                n2 += 3;
            } else if (n4 == 251) {
                int n6 = l.a(this.b, n2 + 1);
                this.a(n2, n6);
                n2 += 3;
            } else {
                n2 = n4 < 255 ? this.c(n2, n4) : this.a(n2);
            }
        }
        return n2;
    }

    public void a(int n2, int n3) {
    }

    private int a(int n2, int n3) {
        int n4;
        int n5 = n2;
        if (n3 < 128) {
            n4 = n3 - 64;
        } else {
            n4 = l.a(this.b, n2 + 1);
            n2 += 2;
        }
        int n6 = this.b[n2 + 1] & 0xFF;
        int n7 = 0;
        if (n6 == 7 || n6 == 8) {
            n7 = l.a(this.b, n2 + 2);
            this.a(n6, n7, n2 + 2);
            n2 += 2;
        }
        this.a(n5, n4, n6, n7);
        return n2 + 2;
    }

    public void a(int n2, int n3, int n4, int n5) {
    }

    public void b(int n2, int n3, int n4) {
    }

    private int c(int n2, int n3) {
        int n4 = n3 - 251;
        int n5 = l.a(this.b, n2 + 1);
        int[] nArray = new int[n4];
        int[] nArray2 = new int[n4];
        int n6 = n2 + 3;
        for (int i2 = 0; i2 < n4; ++i2) {
            int n7;
            nArray[i2] = n7 = this.b[n6] & 0xFF;
            if (n7 == 7 || n7 == 8) {
                nArray2[i2] = l.a(this.b, n6 + 1);
                this.a(n7, nArray2[i2], n6 + 1);
                n6 += 3;
                continue;
            }
            nArray2[i2] = 0;
            ++n6;
        }
        this.a(n2, n5, nArray, nArray2);
        return n6;
    }

    public void a(int n2, int n3, int[] nArray, int[] nArray2) {
    }

    private int a(int n2) {
        int n3 = l.a(this.b, n2 + 1);
        int n4 = l.a(this.b, n2 + 3);
        int[] nArray = new int[n4];
        int[] nArray2 = new int[n4];
        int n5 = this.a(n2 + 5, n4, nArray, nArray2);
        int n6 = l.a(this.b, n5);
        int[] nArray3 = new int[n6];
        int[] nArray4 = new int[n6];
        n5 = this.a(n5 + 2, n6, nArray3, nArray4);
        this.a(n2, n3, nArray, nArray2, nArray3, nArray4);
        return n5;
    }

    public void a(int n2, int n3, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4) {
    }

    private int a(int n2, int n3, int[] nArray, int[] nArray2) {
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4;
            nArray[i2] = n4 = this.b[n2++] & 0xFF;
            if (n4 != 7 && n4 != 8) continue;
            nArray2[i2] = l.a(this.b, n2);
            this.a(n4, nArray2[i2], n2);
            n2 += 2;
        }
        return n2;
    }

    public void a(int n2, int n3, int n4) {
    }
}

