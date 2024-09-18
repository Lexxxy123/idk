/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode;

import de.tr7zw.nbtinjector.javassist.bytecode.ConstInfo;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

class ConstInfoPadding
extends ConstInfo {
    public ConstInfoPadding(int i2) {
        super(i2);
    }

    @Override
    public int getTag() {
        return 0;
    }

    @Override
    public int copy(ConstPool src, ConstPool dest, Map<String, String> map) {
        return dest.addConstInfoPadding();
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
    }

    @Override
    public void print(PrintWriter out) {
        out.println("padding");
    }
}

