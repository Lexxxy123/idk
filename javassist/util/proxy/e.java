/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.invoke.MethodHandle;
import java.security.ProtectionDomain;
import javassist.util.proxy.a;
import javassist.util.proxy.b;
import javassist.util.proxy.c;
import javassist.util.proxy.o;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class e
extends c {
    private final o a;
    private final MethodHandle a = this.a();

    private e() {
        super(null);
    }

    private final MethodHandle a() {
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
        if (this.a.a() != a.class) {
            throw new IllegalAccessError("Access denied for caller.");
        }
        try {
            return (Class)this.a.invokeWithArguments(classLoader, string, byArray, n2, n3, protectionDomain);
        } catch (Throwable throwable) {
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (throwable instanceof ClassFormatError) {
                throw (ClassFormatError)throwable;
            }
            throw new ClassFormatError(throwable.getMessage());
        }
    }

    /* synthetic */ e(b b2) {
        this();
    }
}

