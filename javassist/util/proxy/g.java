/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import javassist.util.proxy.f;
import javassist.util.proxy.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class g {
    private final x a;
    private final MethodHandle a;
    final /* synthetic */ f a;

    g(f f2, x x2, MethodHandle methodHandle) {
        this.a = f2;
        this.a = x2;
        this.a = methodHandle;
    }

    Class<?> a(String string, byte[] byArray, int n2, int n3, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        try {
            if (((Method)f.a(this.a)).invoke(f.a(this.a), new Object[0]) != f.class) {
                throw new IllegalAccessError("Access denied for caller.");
            }
        } catch (Exception exception) {
            throw new RuntimeException("cannot initialize", exception);
        }
        try {
            return (Class)this.a.invokeWithArguments(this.a.a, string, byArray, n2, n3, classLoader, protectionDomain);
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
}

