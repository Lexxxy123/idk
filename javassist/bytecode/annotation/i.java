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

public class i
extends p {
    int a;

    public i(int n2, J j2) {
        super('C', j2);
        this.a = n2;
    }

    public i(char c2, J j2) {
        super('C', j2);
        this.a(c2);
    }

    public i(J j2) {
        super('C', j2);
        this.a('\u0000');
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        return Character.valueOf(this.a());
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return Character.TYPE;
    }

    public char a() {
        return (char)this.a.l(this.a);
    }

    public void a(char c2) {
        this.a = this.a.t(c2);
    }

    public String toString() {
        return Character.toString(this.a());
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

