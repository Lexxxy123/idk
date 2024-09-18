/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.ws;

import java.io.File;
import java.io.FileFilter;

class d
implements FileFilter {
    d() {
    }

    @Override
    public boolean accept(File file) {
        return !file.isDirectory() && file.getName().endsWith(".jar");
    }
}

