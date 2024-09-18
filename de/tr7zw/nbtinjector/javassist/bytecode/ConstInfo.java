/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode;

import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

abstract class ConstInfo {
    int index;

    public ConstInfo(int i2) {
        this.index = i2;
    }

    public abstract int getTag();

    public String getClassName(ConstPool cp) {
        return null;
    }

    public void renameClass(ConstPool cp, String oldName, String newName, Map<ConstInfo, ConstInfo> cache) {
    }

    public void renameClass(ConstPool cp, Map<String, String> classnames, Map<ConstInfo, ConstInfo> cache) {
    }

    public abstract int copy(ConstPool var1, ConstPool var2, Map<String, String> var3);

    public abstract void write(DataOutputStream var1) throws IOException;

    public abstract void print(PrintWriter var1);

    public String toString() {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintWriter out = new PrintWriter(bout);
        this.print(out);
        return bout.toString();
    }
}

