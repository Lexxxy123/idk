/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.annotation.e;
import javassist.bytecode.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class d
extends g {
    ByteArrayOutputStream a;
    e a;
    J a;
    J b;
    Map<String, String> a = new ByteArrayOutputStream();

    d(byte[] byArray, J j2, J j3, Map<String, String> map) {
        this(byArray, j2, j3, map, true);
    }

    d(byte[] byArray, J j2, J j3, Map<String, String> map, boolean bl2) {
        super(byArray);
        if (bl2) {
            this.a = new e(this.a, j3);
        }
        this.a = j2;
        this.b = j3;
        this.a = map;
    }

    byte[] a() {
        this.a.a();
        return this.a.toByteArray();
    }

    @Override
    void a(int n2, int n3) {
        this.a.a(n2);
        super.a(n2, n3);
    }

    @Override
    int a(int n2, int n3) {
        this.a.b(n3);
        return super.a(n2, n3);
    }

    @Override
    int a(int n2, int n3, int n4) {
        this.a.a(this.c(n3), n4);
        return super.a(n2, n3, n4);
    }

    @Override
    int b(int n2, int n3) {
        this.a.c(this.b(n3));
        return super.b(n2, n3);
    }

    @Override
    void b(int n2, int n3) {
        this.a.b(n2, this.b(n3));
        super.b(n2, n3);
    }

    @Override
    void a(int n2, int n3, int n4) {
        this.a.c(this.c(n3), this.b(n4));
        super.a(n2, n3, n4);
    }

    @Override
    void c(int n2, int n3) {
        this.a.e(this.c(n3));
        super.c(n2, n3);
    }

    @Override
    int a(int n2) {
        this.a.b();
        return super.a(n2);
    }

    @Override
    int c(int n2, int n3) {
        this.a.f(n3);
        return super.c(n2, n3);
    }

    int b(int n2) {
        return this.a.a(n2, this.b, (Map<String, String>)((Object)this.a));
    }

    int c(int n2) {
        String string = this.a.m(n2);
        String string2 = M.a(string, (Map<String, String>)((Object)this.a));
        return this.b.c(string2);
    }
}

