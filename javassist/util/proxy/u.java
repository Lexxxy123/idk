/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedAction;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class u
implements PrivilegedAction<Void> {
    final /* synthetic */ AccessibleObject a;
    final /* synthetic */ boolean a;

    u(AccessibleObject accessibleObject, boolean bl2) {
        this.a = accessibleObject;
        this.a = bl2;
    }

    public Void a() {
        this.a.setAccessible(this.a);
        return null;
    }

    @Override
    public /* synthetic */ Object run() {
        return this.a();
    }
}

