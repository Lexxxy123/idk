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

public class k
extends p {
    int a;

    public k(int n2, J j2) {
        super('D', j2);
        this.a = n2;
    }

    public k(double d2, J j2) {
        super('D', j2);
        this.a(d2);
    }

    public k(J j2) {
        super('D', j2);
        this.a(0.0);
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return this.a();
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return Double.TYPE;
    }

    public double a() {
        return this.a.a(this.a);
    }

    public void a(double d2) {
        this.a = this.a.a(d2);
    }

    public String toString() {
        return Double.toString(this.a());
    }

    @Override
    public void a(e e2) {
        e2.a(this.a());
    }

    @Override
    public void a(q q2) {
        q2.a(this);
    }
}

