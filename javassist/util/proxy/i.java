/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import javassist.a;
import javassist.bytecode.o;
import javassist.util.proxy.k;
import javassist.util.proxy.l;
import javassist.util.proxy.m;
import javassist.util.proxy.n;

public class i {
    private static final k a = o.q >= 53 ? new m(null) : (o.q >= 51 ? new l(null) : new n(null));

    public static void a(String string, ClassLoader classLoader) {
        try {
            a.a(classLoader, string, null, null, null, null, null, null, null);
        } catch (IllegalArgumentException illegalArgumentException) {
            return;
        } catch (Exception exception) {
            throw new a(exception);
        }
    }

    private i() {
    }
}

