/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class bn {
    byte[] a;

    bn(byte[] byArray) {
        this.a = byArray;
    }

    final int b(int n2, int n3) {
        switch (n3) {
            case 0: 
            case 1: {
                int n4 = this.a[n2] & 0xFF;
                this.a(n2, n3, n4);
                return n2 + 1;
            }
            case 16: {
                int n5 = l.a(this.a, n2);
                this.a(n2, n5);
                return n2 + 2;
            }
            case 17: 
            case 18: {
                int n6 = this.a[n2] & 0xFF;
                int n7 = this.a[n2 + 1] & 0xFF;
                this.a(n2, n3, n6, n7);
                return n2 + 2;
            }
            case 19: 
            case 20: 
            case 21: {
                this.b(n2, n3);
                return n2;
            }
            case 22: {
                int n8 = this.a[n2] & 0xFF;
                this.c(n2, n8);
                return n2 + 1;
            }
            case 23: {
                int n9 = l.a(this.a, n2);
                this.d(n2, n9);
                return n2 + 2;
            }
            case 64: 
            case 65: {
                int n10 = l.a(this.a, n2);
                return this.a(n2 + 2, n3, n10);
            }
            case 66: {
                int n11 = l.a(this.a, n2);
                this.e(n2, n11);
                return n2 + 2;
            }
            case 67: 
            case 68: 
            case 69: 
            case 70: {
                int n12 = l.a(this.a, n2);
                this.b(n2, n3, n12);
                return n2 + 2;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                int n13 = l.a(this.a, n2);
                int n14 = this.a[n2 + 2] & 0xFF;
                this.b(n2, n3, n13, n14);
                return n2 + 3;
            }
        }
        throw new RuntimeException("invalid target type: " + n3);
    }

    void a(int n2, int n3, int n4) {
    }

    void a(int n2, int n3) {
    }

    void a(int n2, int n3, int n4, int n5) {
    }

    void b(int n2, int n3) {
    }

    void c(int n2, int n3) {
    }

    void d(int n2, int n3) {
    }

    int a(int n2, int n3, int n4) {
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = l.a(this.a, n2);
            int n6 = l.a(this.a, n2 + 2);
            int n7 = l.a(this.a, n2 + 4);
            this.a(n2, n3, n5, n6, n7);
            n2 += 6;
        }
        return n2;
    }

    void a(int n2, int n3, int n4, int n5, int n6) {
    }

    void e(int n2, int n3) {
    }

    void b(int n2, int n3, int n4) {
    }

    void b(int n2, int n3, int n4, int n5) {
    }

    final int a(int n2) {
        int n3 = this.a[n2++] & 0xFF;
        return this.a(n2, n3);
    }

    int a(int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.a[n2] & 0xFF;
            int n5 = this.a[n2 + 1] & 0xFF;
            this.c(n2, n4, n5);
            n2 += 2;
        }
        return n2;
    }

    void c(int n2, int n3, int n4) {
    }
}

