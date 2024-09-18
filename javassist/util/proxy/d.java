/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.security.ProtectionDomain;
import javassist.util.proxy.a;
import javassist.util.proxy.b;
import javassist.util.proxy.h;

class d
extends h {
    private d() {
        super(null);
    }

    @Override
    Class<?> a(String string, byte[] byArray, int n2, int n3, Class<?> clazz, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        if (clazz != null) {
            return a.a(clazz, byArray);
        }
        return super.a(string, byArray, n2, n3, clazz, classLoader, protectionDomain);
    }

    /* synthetic */ d(b b2) {
        this();
    }
}

