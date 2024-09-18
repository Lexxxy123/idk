/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class s
implements PrivilegedExceptionAction<Method> {
    final /* synthetic */ Class a;
    final /* synthetic */ String a;
    final /* synthetic */ Class[] a;

    s(Class clazz, String string, Class[] classArray) {
        this.a = clazz;
        this.a = string;
        this.a = classArray;
    }

    public Method a() {
        return this.a.getDeclaredMethod(this.a, this.a);
    }

    @Override
    public /* synthetic */ Object run() {
        return this.a();
    }
}

