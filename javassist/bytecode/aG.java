/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.af;
import javassist.bytecode.aw;
import javassist.bytecode.l;

public class ag
extends af {
    public static final String c = "LocalVariableTypeTable";

    public ag(J j2) {
        super(j2, c, new byte[2]);
        l.a(0, this.a, 0);
    }

    ag(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    private ag(J j2, byte[] byArray) {
        super(j2, c, byArray);
    }

    @Override
    String a(String string, String string2, String string3) {
        return aw.a(string, string2, string3);
    }

    @Override
    String a(String string, Map<String, String> map) {
        return aw.a(string, map);
    }

    @Override
    af a(J j2, byte[] byArray) {
        return new ag(j2, byArray);
    }
}

