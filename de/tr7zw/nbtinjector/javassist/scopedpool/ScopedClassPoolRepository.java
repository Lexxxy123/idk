/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.scopedpool;

import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.scopedpool.ScopedClassPool;
import de.tr7zw.nbtinjector.javassist.scopedpool.ScopedClassPoolFactory;
import java.util.Map;

public interface ScopedClassPoolRepository {
    public void setClassPoolFactory(ScopedClassPoolFactory var1);

    public ScopedClassPoolFactory getClassPoolFactory();

    public boolean isPrune();

    public void setPrune(boolean var1);

    public ScopedClassPool createScopedClassPool(ClassLoader var1, ClassPool var2);

    public ClassPool findClassPool(ClassLoader var1);

    public ClassPool registerClassLoader(ClassLoader var1);

    public Map<ClassLoader, ScopedClassPool> getRegisteredCLs();

    public void clearUnregisteredClassLoaders();

    public void unregisterClassLoader(ClassLoader var1);
}

