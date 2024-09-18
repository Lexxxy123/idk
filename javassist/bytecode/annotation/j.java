/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.lang.reflect.Method;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.annotation.e;
import javassist.bytecode.annotation.p;
import javassist.bytecode.annotation.q;
import javassist.bytecode.aw;
import javassist.bytecode.i;
import javassist.f;

public class j
extends p {
    int a;

    public j(int n2, J j2) {
        super('c', j2);
        this.a = n2;
    }

    public j(String string, J j2) {
        super('c', j2);
        this.a(string);
    }

    public j(J j2) {
        super('c', j2);
        this.a("java.lang.Class");
    }

    @Override
    Object a(ClassLoader classLoader, f f2, Method method) {
        String string = this.a();
        if (string.equals("void")) {
            return Void.TYPE;
        }
        if (string.equals("int")) {
            return Integer.TYPE;
        }
        if (string.equals("byte")) {
            return Byte.TYPE;
        }
        if (string.equals("long")) {
            return Long.TYPE;
        }
        if (string.equals("double")) {
            return Double.TYPE;
        }
        if (string.equals("float")) {
            return Float.TYPE;
        }
        if (string.equals("char")) {
            return Character.TYPE;
        }
        if (string.equals("short")) {
            return Short.TYPE;
        }
        if (string.equals("boolean")) {
            return Boolean.TYPE;
        }
        return j.a(classLoader, string);
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        return j.a(classLoader, "java.lang.Class");
    }

    public String a() {
        String string = this.a.m(this.a);
        try {
            return aw.a(string).b();
        } catch (i i2) {
            throw new RuntimeException(i2);
        }
    }

    public void a(String string) {
        String string2 = M.d(string);
        this.a = this.a.c(string2);
    }

    public String toString() {
        return this.a().replace('$', '.') + ".class";
    }

    @Override
    public void a(e e2) {
        e2.c(this.a.m(this.a));
    }

    @Override
    public void a(q q2) {
        q2.a(this);
    }
}

