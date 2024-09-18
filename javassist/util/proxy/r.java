/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class r
implements PrivilegedExceptionAction<MethodHandle> {
    final /* synthetic */ Class a;
    final /* synthetic */ String a;
    final /* synthetic */ Class[] a;

    r(Class clazz, String string, Class[] classArray) {
        this.a = clazz;
        this.a = string;
        this.a = classArray;
    }

    public MethodHandle a() {
        Method method = this.a.getDeclaredMethod(this.a, this.a);
        method.setAccessible(true);
        MethodHandle methodHandle = MethodHandles.lookup().unreflect(method);
        method.setAccessible(false);
        return methodHandle;
    }

    @Override
    public /* synthetic */ Object run() {
        return this.a();
    }
}

