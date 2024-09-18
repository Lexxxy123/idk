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

public class o
extends p {
    int a;

    public o(int n2, J j2) {
        super('J', j2);
        this.a = n2;
    }

    public o(long l2, J j2) {
        super('J', j2);
        this.a(l2);
    }

    public o(J j2) {
        super('J', j2);
        this.a(0L);
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return this.a();
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return Long.TYPE;
    }

    public long a() {
        return this.a.a(this.a);
    }

    public void a(long l2) {
        this.a = this.a.a(l2);
    }

    public String toString() {
        return Long.toString(this.a());
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

