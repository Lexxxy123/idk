/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.J;
import javassist.bytecode.annotation.a;
import javassist.bytecode.annotation.d;
import javassist.bytecode.annotation.f;
import javassist.bytecode.annotation.h;
import javassist.bytecode.annotation.i;
import javassist.bytecode.annotation.j;
import javassist.bytecode.annotation.k;
import javassist.bytecode.annotation.l;
import javassist.bytecode.annotation.m;
import javassist.bytecode.annotation.n;
import javassist.bytecode.annotation.o;
import javassist.bytecode.annotation.p;
import javassist.bytecode.annotation.s;
import javassist.bytecode.annotation.t;
import javassist.bytecode.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class e
extends g {
    J a;
    a[][] a;
    a[] a;
    a a;
    p a;

    e(byte[] byArray, J j2) {
        super(byArray);
        this.a = j2;
    }

    a[][] a() {
        this.a();
        return this.a;
    }

    a[] a() {
        this.b();
        return this.a;
    }

    p a() {
        this.g(0);
        return this.a;
    }

    @Override
    void a(int n2, int n3) {
        a[][] aArrayArray = new a[n2][];
        for (int i2 = 0; i2 < n2; ++i2) {
            n3 = this.d(n3);
            aArrayArray[i2] = this.a;
        }
        this.a = aArrayArray;
    }

    @Override
    int a(int n2, int n3) {
        a[] aArray = new a[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = this.e(n2);
            aArray[i2] = this.a;
        }
        this.a = aArray;
        return n2;
    }

    @Override
    int a(int n2, int n3, int n4) {
        this.a = new a(n3, this.a);
        return super.a(n2, n3, n4);
    }

    @Override
    int b(int n2, int n3) {
        n2 = super.b(n2, n3);
        this.a.a(n3, this.a);
        return n2;
    }

    @Override
    void b(int n2, int n3) {
        p p2;
        J j2 = this.a;
        switch (n2) {
            case 66: {
                p2 = new h(n3, j2);
                break;
            }
            case 67: {
                p2 = new i(n3, j2);
                break;
            }
            case 68: {
                p2 = new k(n3, j2);
                break;
            }
            case 70: {
                p2 = new m(n3, j2);
                break;
            }
            case 73: {
                p2 = new n(n3, j2);
                break;
            }
            case 74: {
                p2 = new o(n3, j2);
                break;
            }
            case 83: {
                p2 = new s(n3, j2);
                break;
            }
            case 90: {
                p2 = new javassist.bytecode.annotation.g(n3, j2);
                break;
            }
            case 115: {
                p2 = new t(n3, j2);
                break;
            }
            default: {
                throw new RuntimeException("unknown tag:" + n2);
            }
        }
        this.a = p2;
        super.b(n2, n3);
    }

    @Override
    void a(int n2, int n3, int n4) {
        this.a = new l(n3, n4, this.a);
        super.a(n2, n3, n4);
    }

    @Override
    void c(int n2, int n3) {
        this.a = new j(n3, this.a);
        super.c(n2, n3);
    }

    @Override
    int a(int n2) {
        a a2 = this.a;
        n2 = super.a(n2);
        this.a = new d(this.a, this.a);
        this.a = a2;
        return n2;
    }

    @Override
    int c(int n2, int n3) {
        f f2 = new f(this.a);
        p[] pArray = new p[n3];
        for (int i2 = 0; i2 < n3; ++i2) {
            n2 = this.g(n2);
            pArray[i2] = this.a;
        }
        f2.a(pArray);
        this.a = f2;
        return n2;
    }
}

