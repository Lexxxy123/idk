/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.util.proxy;

import de.tr7zw.nbtinjector.javassist.util.proxy.MethodHandler;
import de.tr7zw.nbtinjector.javassist.util.proxy.Proxy;

public interface ProxyObject
extends Proxy {
    @Override
    public void setHandler(MethodHandler var1);

    public MethodHandler getHandler();
}

