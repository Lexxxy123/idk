/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode;

import de.tr7zw.nbtinjector.javassist.bytecode.ConstInfo;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

class IntegerInfo
extends ConstInfo {
    static final int tag = 3;
    int value;

    public IntegerInfo(int v2, int index) {
        super(index);
        this.value = v2;
    }

    public IntegerInfo(DataInputStream in, int index) throws IOException {
        super(index);
        this.value = in.readInt();
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return obj instanceof IntegerInfo && ((IntegerInfo)obj).value == this.value;
    }

    @Override
    public int getTag() {
        return 3;
    }

    @Override
    public int copy(ConstPool src, ConstPool dest, Map<String, String> map) {
        return dest.addIntegerInfo(this.value);
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeByte(3);
        out.writeInt(this.value);
    }

    @Override
    public void print(PrintWriter out) {
        out.print("Integer ");
        out.println(this.value);
    }
}

