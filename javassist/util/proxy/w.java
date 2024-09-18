/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.util.Objects;
import javassist.util.proxy.o;
import javassist.util.proxy.x;

class w
implements PrivilegedExceptionAction<x> {
    w() {
    }

    public x a() {
        Class<?> clazz = Class.forName("sun.misc.Unsafe");
        Field field = clazz.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        o o2 = o.a;
        Objects.requireNonNull(o2);
        x x2 = new x(o2, clazz, field.get(null));
        field.setAccessible(false);
        o.a(x2);
        return x2;
    }

    @Override
    public /* synthetic */ Object run() {
        return this.a();
    }
}

