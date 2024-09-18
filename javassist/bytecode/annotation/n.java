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

public class n
extends p {
    int a;

    public n(int n2, J j2) {
        super('I', j2);
        this.a = n2;
    }

    public n(J j2, int n2) {
        super('I', j2);
        this.a(n2);
    }

    public n(J j2) {
        super('I', j2);
        this.a(0);
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return this.a();
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return Integer.TYPE;
    }

    public int a() {
        return this.a.l(this.a);
    }

    public void a(int n2) {
        this.a = this.a.t(n2);
    }

    public String toString() {
        return Integer.toString(this.a());
    }

    @Override
    public void a(e e2) {
        e2.d(this.a());
    }

    @Override
    public void a(q q2) {
        q2.a(this);
    }
}

