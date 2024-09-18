/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;

class p
implements PrivilegedAction<Method[]> {
    final /* synthetic */ Class a;

    p(Class clazz) {
        this.a = clazz;
    }

    public Method[] a() {
        return this.a.getDeclaredMethods();
    }

    @Override
    public /* synthetic */ Object run() {
        return this.a();
    }
}

