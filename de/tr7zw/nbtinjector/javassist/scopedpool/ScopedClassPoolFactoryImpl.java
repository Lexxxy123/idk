/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.scopedpool;

import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.scopedpool.ScopedClassPool;
import de.tr7zw.nbtinjector.javassist.scopedpool.ScopedClassPoolFactory;
import de.tr7zw.nbtinjector.javassist.scopedpool.ScopedClassPoolRepository;

public class ScopedClassPoolFactoryImpl
implements ScopedClassPoolFactory {
    @Override
    public ScopedClassPool create(ClassLoader cl, ClassPool src, ScopedClassPoolRepository repository) {
        return new ScopedClassPool(cl, src, repository, false);
    }

    @Override
    public ScopedClassPool create(ClassPool src, ScopedClassPoolRepository repository) {
        return new ScopedClassPool(null, src, repository, true);
    }
}

