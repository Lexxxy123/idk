/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.ws;

import java.lang.reflect.Method;
import javassist.ws.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class c
implements Runnable {
    final /* synthetic */ a a;
    private final /* synthetic */ Method a;
    private final /* synthetic */ Object a;

    c(a a2, Method method, Object object) {
        this.a = a2;
        this.a = method;
        this.a = object;
    }

    @Override
    public void run() {
        try {
            this.a.invoke(this.a, new Object[0]);
        } catch (Exception exception) {
            // empty catch block
        }
    }
}

