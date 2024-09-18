/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.List;
import javassist.util.proxy.a;
import javassist.util.proxy.c;
import javassist.util.proxy.g;
import javassist.util.proxy.o;
import javassist.util.proxy.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class f
extends c {
    private final Object a;
    private final Method a;
    private final g a = this.a();

    f() {
        super(null);
        Class<?> clazz = null;
        try {
            clazz = Class.forName("java.lang.StackWalker");
        } catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        if (clazz != null) {
            try {
                Class<?> clazz2 = Class.forName("java.lang.StackWalker$Option");
                this.a = clazz.getMethod("getInstance", clazz2).invoke(null, clazz2.getEnumConstants()[0]);
                this.a = clazz.getMethod("getCallerClass", new Class[0]);
            } catch (Throwable throwable) {
                throw new RuntimeException("cannot initialize", throwable);
            }
        } else {
            this.a = null;
            this.a = null;
        }
    }

    private final g a() {
        try {
            if (javassist.util.proxy.a.a() != null && this.a.invoke(this.a, new Object[0]) != this.getClass()) {
                throw new IllegalAccessError("Access denied for caller.");
            }
        } catch (Exception exception) {
            throw new RuntimeException("cannot initialize", exception);
        }
        try {
            x x2 = o.a();
            List list = (List)x2.a.get("defineClass");
            if (null == list) {
                return null;
            }
            MethodHandle methodHandle = MethodHandles.lookup().unreflect((Method)list.get(0));
            return new g(this, x2, methodHandle);
        } catch (Throwable throwable) {
            throw new RuntimeException("cannot initialize", throwable);
        }
    }

    @Override
    Class<?> a(String string, byte[] byArray, int n2, int n3, Class<?> clazz, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        try {
            if (this.a.invoke(this.a, new Object[0]) != a.class) {
                throw new IllegalAccessError("Access denied for caller.");
            }
        } catch (Exception exception) {
            throw new RuntimeException("cannot initialize", exception);
        }
        return this.a.a(string, byArray, n2, n3, classLoader, protectionDomain);
    }

    static /* synthetic */ Object a(f f2) {
        return f2.a;
    }

    static /* synthetic */ Method a(f f2) {
        return f2.a;
    }
}

