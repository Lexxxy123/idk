/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.tools.reflect;

import de.tr7zw.nbtinjector.javassist.tools.reflect.ClassMetaobject;
import de.tr7zw.nbtinjector.javassist.tools.reflect.Metaobject;

public interface Metalevel {
    public ClassMetaobject _getClass();

    public Metaobject _getMetaobject();

    public void _setMetaobject(Metaobject var1);
}

