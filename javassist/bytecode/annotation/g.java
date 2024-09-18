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

public class g
extends p {
    int a;

    public g(int n2, J j2) {
        super('Z', j2);
        this.a = n2;
    }

    public g(boolean bl2, J j2) {
        super('Z', j2);
        this.a(bl2);
    }

    public g(J j2) {
        super('Z', j2);
        this.a(false);
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return this.a();
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return Boolean.TYPE;
    }

    public boolean a() {
        return this.a.l(this.a) != 0;
    }

    public void a(boolean bl2) {
        this.a = this.a.t(bl2 ? 1 : 0);
    }

    public String toString() {
        return this.a() ? "true" : "false";
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

