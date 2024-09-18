/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode;

import de.tr7zw.nbtinjector.javassist.bytecode.AttributeInfo;
import de.tr7zw.nbtinjector.javassist.bytecode.ByteArray;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;

public class MethodParametersAttribute
extends AttributeInfo {
    public static final String tag = "MethodParameters";

    MethodParametersAttribute(ConstPool cp, int n2, DataInputStream in) throws IOException {
        super(cp, n2, in);
    }

    public MethodParametersAttribute(ConstPool cp, String[] names, int[] flags) {
        super(cp, tag);
        byte[] data = new byte[names.length * 4 + 1];
        data[0] = (byte)names.length;
        for (int i2 = 0; i2 < names.length; ++i2) {
            ByteArray.write16bit(cp.addUtf8Info(names[i2]), data, i2 * 4 + 1);
            ByteArray.write16bit(flags[i2], data, i2 * 4 + 3);
        }
        this.set(data);
    }

    public int size() {
        return this.info[0] & 0xFF;
    }

    public int name(int i2) {
        return ByteArray.readU16bit(this.info, i2 * 4 + 1);
    }

    public String parameterName(int i2) {
        return this.getConstPool().getUtf8Info(this.name(i2));
    }

    public int accessFlags(int i2) {
        return ByteArray.readU16bit(this.info, i2 * 4 + 3);
    }

    @Override
    public AttributeInfo copy(ConstPool newCp, Map<String, String> classnames) {
        int s2 = this.size();
        ConstPool cp = this.getConstPool();
        String[] names = new String[s2];
        int[] flags = new int[s2];
        for (int i2 = 0; i2 < s2; ++i2) {
            names[i2] = cp.getUtf8Info(this.name(i2));
            flags[i2] = this.accessFlags(i2);
        }
        return new MethodParametersAttribute(newCp, names, flags);
    }
}

