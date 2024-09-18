/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.net.URL;
import javassist.util.proxy.j;
import javassist.util.proxy.k;

class m
extends k {
    private m() {
        super(null);
    }

    @Override
    Package a(ClassLoader classLoader, String string, String string2, String string3, String string4, String string5, String string6, String string7, URL uRL) {
        throw new RuntimeException("define package has been disabled for jigsaw");
    }

    /* synthetic */ m(j j2) {
        this();
    }
}

