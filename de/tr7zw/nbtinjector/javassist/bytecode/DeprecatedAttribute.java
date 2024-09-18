/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode;

import de.tr7zw.nbtinjector.javassist.bytecode.AttributeInfo;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;

public class DeprecatedAttribute
extends AttributeInfo {
    public static final String tag = "Deprecated";

    DeprecatedAttribute(ConstPool cp, int n2, DataInputStream in) throws IOException {
        super(cp, n2, in);
    }

    public DeprecatedAttribute(ConstPool cp) {
        super(cp, tag, new byte[0]);
    }

    @Override
    public AttributeInfo copy(ConstPool newCp, Map<String, String> classnames) {
        return new DeprecatedAttribute(newCp);
    }
}

