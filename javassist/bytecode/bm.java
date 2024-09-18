/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.annotation.u;
import javassist.bytecode.bn;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class bm
extends bn {
    J a;
    J b;
    Map<String, String> a;
    u a;

    bm(byte[] byArray, J j2, J j3, Map<String, String> map, u u2) {
        super(byArray);
        this.a = j2;
        this.b = j3;
        this.a = map;
        this.a = u2;
    }

    @Override
    void a(int n2, int n3, int n4) {
        this.a.d(n3, n4);
    }

    @Override
    void a(int n2, int n3) {
        this.a.h(n3);
    }

    @Override
    void a(int n2, int n3, int n4, int n5) {
        this.a.a(n3, n4, n5);
    }

    @Override
    void b(int n2, int n3) {
        this.a.i(n3);
    }

    @Override
    void c(int n2, int n3) {
        this.a.j(n3);
    }

    @Override
    void d(int n2, int n3) {
        this.a.k(n3);
    }

    @Override
    int a(int n2, int n3, int n4) {
        this.a.e(n3, n4);
        return super.a(n2, n3, n4);
    }

    @Override
    void a(int n2, int n3, int n4, int n5, int n6) {
        this.a.b(n4, n5, n6);
    }

    @Override
    void e(int n2, int n3) {
        this.a.l(n3);
    }

    @Override
    void b(int n2, int n3, int n4) {
        this.a.f(n3, n4);
    }

    @Override
    void b(int n2, int n3, int n4, int n5) {
        this.a.c(n3, n4, n5);
    }

    @Override
    int a(int n2, int n3) {
        this.a.m(n3);
        return super.a(n2, n3);
    }

    @Override
    void c(int n2, int n3, int n4) {
        this.a.g(n3, n4);
    }
}

