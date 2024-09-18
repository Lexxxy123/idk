/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j;

import javassist.orgs.slf4j.h;
import javassist.orgs.slf4j.spi.a;
import javassist.orgs.slf4j.spi.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface c {
    public static final String a = "ROOT";

    public String a();

    default public e a(javassist.orgs.slf4j.event.e e2) {
        return new a(this, e2);
    }

    public boolean a();

    public void a(String var1);

    public void a(String var1, Object var2);

    public void a(String var1, Object var2, Object var3);

    public void a(String var1, Object ... var2);

    public void a(String var1, Throwable var2);

    public boolean a(h var1);

    default public e a() {
        if (this.a()) {
            return this.a(javassist.orgs.slf4j.event.e.e);
        }
        return javassist.orgs.slf4j.spi.h.a();
    }

    public void a(h var1, String var2);

    public void a(h var1, String var2, Object var3);

    public void a(h var1, String var2, Object var3, Object var4);

    public void a(h var1, String var2, Object ... var3);

    public void a(h var1, String var2, Throwable var3);

    public boolean b();

    public void b(String var1);

    public void b(String var1, Object var2);

    public void b(String var1, Object var2, Object var3);

    public void b(String var1, Object ... var2);

    public void b(String var1, Throwable var2);

    public boolean b(h var1);

    public void b(h var1, String var2);

    public void b(h var1, String var2, Object var3);

    public void b(h var1, String var2, Object var3, Object var4);

    public void b(h var1, String var2, Object ... var3);

    public void b(h var1, String var2, Throwable var3);

    default public e b() {
        if (this.b()) {
            return this.a(javassist.orgs.slf4j.event.e.d);
        }
        return javassist.orgs.slf4j.spi.h.a();
    }

    public boolean c();

    public void c(String var1);

    public void c(String var1, Object var2);

    public void c(String var1, Object var2, Object var3);

    public void c(String var1, Object ... var2);

    public void c(String var1, Throwable var2);

    public boolean c(h var1);

    public void c(h var1, String var2);

    public void c(h var1, String var2, Object var3);

    public void c(h var1, String var2, Object var3, Object var4);

    public void c(h var1, String var2, Object ... var3);

    public void c(h var1, String var2, Throwable var3);

    default public e c() {
        if (this.c()) {
            return this.a(javassist.orgs.slf4j.event.e.c);
        }
        return javassist.orgs.slf4j.spi.h.a();
    }

    public boolean d();

    public void d(String var1);

    public void d(String var1, Object var2);

    public void d(String var1, Object ... var2);

    public void d(String var1, Object var2, Object var3);

    public void d(String var1, Throwable var2);

    public boolean d(h var1);

    public void d(h var1, String var2);

    public void d(h var1, String var2, Object var3);

    public void d(h var1, String var2, Object var3, Object var4);

    public void d(h var1, String var2, Object ... var3);

    public void d(h var1, String var2, Throwable var3);

    default public e d() {
        if (this.d()) {
            return this.a(javassist.orgs.slf4j.event.e.b);
        }
        return javassist.orgs.slf4j.spi.h.a();
    }

    public boolean e();

    public void e(String var1);

    public void e(String var1, Object var2);

    public void e(String var1, Object var2, Object var3);

    public void e(String var1, Object ... var2);

    public void e(String var1, Throwable var2);

    public boolean e(h var1);

    public void e(h var1, String var2);

    public void e(h var1, String var2, Object var3);

    public void e(h var1, String var2, Object var3, Object var4);

    public void e(h var1, String var2, Object ... var3);

    public void e(h var1, String var2, Throwable var3);

    default public e e() {
        if (this.e()) {
            return this.a(javassist.orgs.slf4j.event.e.a);
        }
        return javassist.orgs.slf4j.spi.h.a();
    }
}

