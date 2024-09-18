/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.scopedpool;

import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.scopedpool.ScopedClassPool;
import de.tr7zw.nbtinjector.javassist.scopedpool.ScopedClassPoolRepository;

public interface ScopedClassPoolFactory {
    public ScopedClassPool create(ClassLoader var1, ClassPool var2, ScopedClassPoolRepository var3);

    public ScopedClassPool create(ClassPool var1, ScopedClassPoolRepository var2);
}

