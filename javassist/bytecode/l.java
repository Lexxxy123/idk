/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.h;

public class L
extends h {
    public static final String a = "Deprecated";

    L(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public L(J j2) {
        super(j2, a, new byte[0]);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        return new L(j2);
    }
}

