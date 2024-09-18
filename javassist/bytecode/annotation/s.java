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

public class s
extends p {
    int a;

    public s(int n2, J j2) {
        super('S', j2);
        this.a = n2;
    }

    public s(short s2, J j2) {
        super('S', j2);
        this.a(s2);
    }

    public s(J j2) {
        super('S', j2);
        this.a((short)0);
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return this.a();
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return Short.TYPE;
    }

    public short a() {
        return (short)this.a.l(this.a);
    }

    public void a(short s2) {
        this.a = this.a.t(s2);
    }

    public String toString() {
        return Short.toString(this.a());
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

