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

class LongInfo
extends ConstInfo {
    static final int tag = 5;
    long value;

    public LongInfo(long l2, int index) {
        super(index);
        this.value = l2;
    }

    public LongInfo(DataInputStream in, int index) throws IOException {
        super(index);
        this.value = in.readLong();
    }

    public int hashCode() {
        return (int)(this.value ^ this.value >>> 32);
    }

    public boolean equals(Object obj) {
        return obj instanceof LongInfo && ((LongInfo)obj).value == this.value;
    }

    @Override
    public int getTag() {
        return 5;
    }

    @Override
    public int copy(ConstPool src, ConstPool dest, Map<String, String> map) {
        return dest.addLongInfo(this.value);
    }

    @Override
    public void write(DataOutputStream out) throws IOException {
        out.writeByte(5);
        out.writeLong(this.value);
    }

    @Override
    public void print(PrintWriter out) {
        out.print("Long ");
        out.println(this.value);
    }
}

