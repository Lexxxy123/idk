/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.invoke.MethodHandles;
import java.security.ProtectionDomain;
import javassist.bytecode.o;
import javassist.util.proxy.c;
import javassist.util.proxy.d;
import javassist.util.proxy.e;
import javassist.util.proxy.f;
import javassist.util.proxy.h;

public class a {
    private static final c a = o.q > 54 ? new d(null) : (o.q >= 53 ? new f() : (o.q >= 51 ? new e(null) : new h(null)));

    public static Class<?> a(String string, Class<?> clazz, ClassLoader classLoader, ProtectionDomain protectionDomain, byte[] byArray) {
        try {
            return a.a(string, byArray, 0, byArray.length, clazz, classLoader, protectionDomain);
        } catch (RuntimeException runtimeException) {
            throw runtimeException;
        } catch (javassist.a a2) {
            throw a2;
        } catch (ClassFormatError classFormatError) {
            Throwable throwable = classFormatError.getCause();
            throw new javassist.a(throwable == null ? classFormatError : throwable);
        } catch (Exception exception) {
            throw new javassist.a(exception);
        }
    }

    public static Class<?> a(Class<?> clazz, byte[] byArray) {
        try {
            a.class.getModule().addReads(clazz.getModule());
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandles.Lookup lookup2 = MethodHandles.privateLookupIn(clazz, (MethodHandles.Lookup)lookup);
            return lookup2.defineClass(byArray);
        } catch (IllegalAccessException | IllegalArgumentException exception) {
            throw new javassist.a(exception.getMessage() + ": " + clazz.getName() + " has no permission to define the class");
        }
    }

    public static Class<?> a(MethodHandles.Lookup lookup, byte[] byArray) {
        try {
            return lookup.defineClass(byArray);
        } catch (IllegalAccessException | IllegalArgumentException exception) {
            throw new javassist.a(exception.getMessage());
        }
    }

    static Class<?> a(String string, byte[] byArray) {
        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            lookup = lookup.dropLookupMode(2);
            return lookup.defineClass(byArray);
        } catch (Throwable throwable) {
            throw new javassist.a(throwable);
        }
    }

    private a() {
    }

    static /* synthetic */ c a() {
        return a;
    }
}

