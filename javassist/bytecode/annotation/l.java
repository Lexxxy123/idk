/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.lang.reflect.Method;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.annotation.e;
import javassist.bytecode.annotation.p;
import javassist.bytecode.annotation.q;
import javassist.f;

public class l
extends p {
    int a;
    int b;

    public l(int n2, int n3, J j2) {
        super('e', j2);
        this.a = n2;
        this.b = n3;
    }

    public l(J j2) {
        super('e', j2);
        this.b = 0;
        this.a = 0;
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        try {
            return this.a(classLoader).getField(this.b()).get(null);
        } catch (NoSuchFieldException noSuchFieldException) {
            throw new ClassNotFoundException(this.a() + "." + this.b());
        } catch (IllegalAccessException illegalAccessException) {
            throw new ClassNotFoundException(this.a() + "." + this.b());
        }
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return l.a(classLoader, this.a());
    }

    public String a() {
        return M.c(this.a.m(this.a));
    }

    public void a(String string) {
        this.a = this.a.c(M.d(string));
    }

    public String b() {
        return this.a.m(this.b);
    }

    public void b(String string) {
        this.b = this.a.c(string);
    }

    public String toString() {
        return this.a() + "." + this.b();
    }

    @Override
    public void a(e e2) {
        e2.a(this.a.m(this.a), this.b());
    }

    @Override
    public void a(q q2) {
        q2.a(this);
    }
}

