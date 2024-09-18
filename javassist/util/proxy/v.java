/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class v
implements PrivilegedExceptionAction<Void> {
    final /* synthetic */ Field a;
    final /* synthetic */ Object a;
    final /* synthetic */ Object b;

    v(Field field, Object object, Object object2) {
        this.a = field;
        this.a = object;
        this.b = object2;
    }

    public Void a() {
        this.a.set(this.a, this.b);
        return null;
    }

    @Override
    public /* synthetic */ Object run() {
        return this.a();
    }
}

