/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import javassist.util.proxy.a;
import javassist.util.proxy.b;
import javassist.util.proxy.c;
import javassist.util.proxy.o;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class h
extends c {
    private final Method a;
    private final o a = o.a;

    private h() {
        super(null);
    }

    private final Method a() {
        if (javassist.util.proxy.a.a() != null && this.a.a() != this.getClass()) {
            throw new IllegalAccessError("Access denied for caller.");
        }
        try {
            return o.a(ClassLoader.class, "defineClass", new Class[]{String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class});
        } catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("cannot initialize", noSuchMethodException);
        }
    }

    @Override
    Class<?> a(String string, byte[] byArray, int n2, int n3, Class<?> clazz, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        Class<?> clazz2 = this.a.a();
        if (clazz2 != a.class && clazz2 != this.getClass()) {
            throw new IllegalAccessError("Access denied for caller.");
        }
        try {
            o.a(this.a, true);
            return (Class)this.a.invoke(classLoader, string, byArray, n2, n3, protectionDomain);
        } catch (Throwable throwable) {
            if (throwable instanceof ClassFormatError) {
                throw (ClassFormatError)throwable;
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            throw new javassist.a(throwable);
        }
    }

    /* synthetic */ h(b b2) {
        this();
    }
}

