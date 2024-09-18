/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist;

import de.tr7zw.nbtinjector.javassist.NotFoundException;
import java.io.InputStream;
import java.net.URL;

public interface ClassPath {
    public InputStream openClassfile(String var1) throws NotFoundException;

    public URL find(String var1);
}

