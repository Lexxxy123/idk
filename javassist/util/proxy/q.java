/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.Constructor;
import java.security.PrivilegedAction;

class q
implements PrivilegedAction<Constructor<?>[]> {
    final /* synthetic */ Class a;

    q(Class clazz) {
        this.a = clazz;
    }

    public Constructor<?>[] a() {
        return this.a.getDeclaredConstructors();
    }

    @Override
    public /* synthetic */ Object run() {
        return this.a();
    }
}

