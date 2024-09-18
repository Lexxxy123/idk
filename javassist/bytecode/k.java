/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.h;
import javassist.bytecode.l;

public class K
extends h {
    public static final String a = "ConstantValue";

    K(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public K(J j2, int n2) {
        super(j2, a);
        byte[] byArray = new byte[]{(byte)(n2 >>> 8), (byte)n2};
        this.a(byArray);
    }

    public int a() {
        return l.a(this.a(), 0);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        int n2 = this.a().a(this.a(), j2, map);
        return new K(j2, n2);
    }
}

