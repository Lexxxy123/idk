/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.invoke.MethodHandle;
import java.net.URL;
import javassist.util.proxy.i;
import javassist.util.proxy.j;
import javassist.util.proxy.k;
import javassist.util.proxy.o;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class l
extends k {
    private final o a;
    private final MethodHandle a = this.a();

    private l() {
        super(null);
    }

    private MethodHandle a() {
        if (this.a.a() != this.getClass()) {
            throw new IllegalAccessError("Access denied for caller.");
        }
        try {
            return o.a(ClassLoader.class, "definePackage", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class});
        } catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("cannot initialize", noSuchMethodException);
        }
    }

    @Override
    Package a(ClassLoader classLoader, String string, String string2, String string3, String string4, String string5, String string6, String string7, URL uRL) {
        if (this.a.a() != i.class) {
            throw new IllegalAccessError("Access denied for caller.");
        }
        try {
            return (Package)this.a.invokeWithArguments(classLoader, string, string2, string3, string4, string5, string6, string7, uRL);
        } catch (Throwable throwable) {
            if (throwable instanceof IllegalArgumentException) {
                throw (IllegalArgumentException)throwable;
            }
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            return null;
        }
    }

    /* synthetic */ l(j j2) {
        this();
    }
}

