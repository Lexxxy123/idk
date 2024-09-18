/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.lang.reflect.Method;
import javassist.bytecode.J;
import javassist.bytecode.annotation.a;
import javassist.bytecode.annotation.c;
import javassist.bytecode.annotation.e;
import javassist.bytecode.annotation.p;
import javassist.bytecode.annotation.q;
import javassist.f;

public class d
extends p {
    a a;

    public d(J j2) {
        this(null, j2);
    }

    public d(a a2, J j2) {
        super('@', j2);
        this.a = a2;
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return c.a(classLoader, this.a(classLoader), f2, this.a);
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        if (this.a == null) {
            throw new ClassNotFoundException("no type specified");
        }
        return d.a(classLoader, this.a.a());
    }

    public a a() {
        return this.a;
    }

    public void a(a a2) {
        this.a = a2;
    }

    public String toString() {
        return this.a.toString();
    }

    @Override
    public void a(e e2) {
        e2.b();
        this.a.a(e2);
    }

    @Override
    public void a(q q2) {
        q2.a(this);
    }
}

