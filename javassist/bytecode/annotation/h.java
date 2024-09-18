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

public class h
extends p {
    int a;

    public h(int n2, J j2) {
        super('B', j2);
        this.a = n2;
    }

    public h(byte by, J j2) {
        super('B', j2);
        this.a(by);
    }

    public h(J j2) {
        super('B', j2);
        this.a((byte)0);
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return this.a();
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return Byte.TYPE;
    }

    public byte a() {
        return (byte)this.a.l(this.a);
    }

    public void a(byte by) {
        this.a = this.a.t(by);
    }

    public String toString() {
        return Byte.toString(this.a());
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

