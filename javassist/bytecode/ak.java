/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.h;
import javassist.bytecode.l;

public class aK
extends h {
    public static final String a = "SourceFile";

    aK(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public aK(J j2, String string) {
        super(j2, a);
        int n2 = j2.c(string);
        byte[] byArray = new byte[]{(byte)(n2 >>> 8), (byte)n2};
        this.a(byArray);
    }

    public String b() {
        return this.a().m(l.a(this.a(), 0));
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        return new aK(j2, this.b());
    }
}

