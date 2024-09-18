/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.io.OutputStream;
import javassist.bytecode.J;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e {
    protected OutputStream a;
    private J a;

    public e(OutputStream outputStream, J j2) {
        this.a = outputStream;
        this.a = j2;
    }

    public J a() {
        return this.a;
    }

    public void a() {
        this.a.close();
    }

    public void a(int n2) {
        this.a.write(n2);
    }

    public void b(int n2) {
        this.g(n2);
    }

    public void a(String string, int n2) {
        this.a(this.a.c(string), n2);
    }

    public void a(int n2, int n3) {
        this.g(n2);
        this.g(n3);
    }

    public void a(String string) {
        this.c(this.a.c(string));
    }

    public void c(int n2) {
        this.g(n2);
    }

    public void a(boolean bl2) {
        this.b(90, this.a.t(bl2 ? 1 : 0));
    }

    public void a(byte by) {
        this.b(66, this.a.t(by));
    }

    public void a(char c2) {
        this.b(67, this.a.t(c2));
    }

    public void a(short s2) {
        this.b(83, this.a.t(s2));
    }

    public void d(int n2) {
        this.b(73, this.a.t(n2));
    }

    public void a(long l2) {
        this.b(74, this.a.a(l2));
    }

    public void a(float f2) {
        this.b(70, this.a.a(f2));
    }

    public void a(double d2) {
        this.b(68, this.a.a(d2));
    }

    public void b(String string) {
        this.b(115, this.a.c(string));
    }

    public void b(int n2, int n3) {
        this.a.write(n2);
        this.g(n3);
    }

    public void a(String string, String string2) {
        this.c(this.a.c(string), this.a.c(string2));
    }

    public void c(int n2, int n3) {
        this.a.write(101);
        this.g(n2);
        this.g(n3);
    }

    public void c(String string) {
        this.e(this.a.c(string));
    }

    public void e(int n2) {
        this.a.write(99);
        this.g(n2);
    }

    public void b() {
        this.a.write(64);
    }

    public void f(int n2) {
        this.a.write(91);
        this.g(n2);
    }

    protected void g(int n2) {
        byte[] byArray = new byte[2];
        l.a(n2, byArray, 0);
        this.a.write(byArray);
    }
}

