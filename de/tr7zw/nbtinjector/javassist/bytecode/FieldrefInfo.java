/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode;

import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.MemberrefInfo;
import java.io.DataInputStream;
import java.io.IOException;

class FieldrefInfo
extends MemberrefInfo {
    static final int tag = 9;

    public FieldrefInfo(int cindex, int ntindex, int thisIndex) {
        super(cindex, ntindex, thisIndex);
    }

    public FieldrefInfo(DataInputStream in, int thisIndex) throws IOException {
        super(in, thisIndex);
    }

    @Override
    public int getTag() {
        return 9;
    }

    @Override
    public String getTagName() {
        return "Field";
    }

    @Override
    protected int copy2(ConstPool dest, int cindex, int ntindex) {
        return dest.addFieldrefInfo(cindex, ntindex);
    }
}

