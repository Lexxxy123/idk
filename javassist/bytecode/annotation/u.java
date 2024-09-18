/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.io.OutputStream;
import javassist.bytecode.J;
import javassist.bytecode.annotation.e;

public class u
extends e {
    public u(OutputStream outputStream, J j2) {
        super(outputStream, j2);
    }

    @Override
    public void b(int n2) {
        super.b(n2);
    }

    public void d(int n2, int n3) {
        this.a.write(n2);
        this.a.write(n3);
    }

    public void h(int n2) {
        this.a.write(16);
        this.g(n2);
    }

    public void a(int n2, int n3, int n4) {
        this.a.write(n2);
        this.a.write(n3);
        this.a.write(n4);
    }

    public void i(int n2) {
        this.a.write(n2);
    }

    public void j(int n2) {
        this.a.write(22);
        this.a.write(n2);
    }

    public void k(int n2) {
        this.a.write(23);
        this.g(n2);
    }

    public void e(int n2, int n3) {
        this.a.write(n2);
        this.g(n3);
    }

    public void b(int n2, int n3, int n4) {
        this.g(n2);
        this.g(n3);
        this.g(n4);
    }

    public void l(int n2) {
        this.a.write(66);
        this.g(n2);
    }

    public void f(int n2, int n3) {
        this.a.write(n2);
        this.g(n3);
    }

    public void c(int n2, int n3, int n4) {
        this.a.write(n2);
        this.g(n3);
        this.a.write(n4);
    }

    public void m(int n2) {
        this.a.write(n2);
    }

    public void g(int n2, int n3) {
        this.a.write(n2);
        this.a.write(n3);
    }
}

