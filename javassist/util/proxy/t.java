/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.Constructor;
import java.security.PrivilegedExceptionAction;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class t
implements PrivilegedExceptionAction<Constructor<?>> {
    final /* synthetic */ Class a;
    final /* synthetic */ Class[] a;

    t(Class clazz, Class[] classArray) {
        this.a = clazz;
        this.a = classArray;
    }

    public Constructor<?> a() {
        return this.a.getDeclaredConstructor(this.a);
    }

    @Override
    public /* synthetic */ Object run() {
        return this.a();
    }
}

