/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.lang.reflect.Method;
import javassist.bytecode.J;
import javassist.bytecode.annotation.e;
import javassist.bytecode.annotation.p;
import javassist.bytecode.annotation.q;
import javassist.f;

public class t
extends p {
    int a;

    public t(int n2, J j2) {
        super('s', j2);
        this.a = n2;
    }

    public t(String string, J j2) {
        super('s', j2);
        this.a(string);
    }

    public t(J j2) {
        super('s', j2);
        this.a("");
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return this.a();
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return String.class;
    }

    public String a() {
        return this.a.m(this.a);
    }

    public void a(String string) {
        this.a = this.a.c(string);
    }

    public String toString() {
        return "\"" + this.a() + "\"";
    }

    @Override
    public void a(e e2) {
        e2.b(this.a());
    }

    @Override
    public void a(q q2) {
        q2.a(this);
    }
}

