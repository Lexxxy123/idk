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

public class m
extends p {
    int a;

    public m(int n2, J j2) {
        super('F', j2);
        this.a = n2;
    }

    public m(float f2, J j2) {
        super('F', j2);
        this.a(f2);
    }

    public m(J j2) {
        super('F', j2);
        this.a(0.0f);
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return Float.valueOf(this.a());
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return Float.TYPE;
    }

    public float a() {
        return this.a.a(this.a);
    }

    public void a(float f2) {
        this.a = this.a.a(f2);
    }

    public String toString() {
        return Float.toString(this.a());
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

