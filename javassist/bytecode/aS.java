/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.h;
import javassist.bytecode.l;

public class as
extends h {
    public static final String a = "NestMembers";

    as(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    private as(J j2, byte[] byArray) {
        super(j2, a, byArray);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        byte[] byArray = this.a();
        byte[] byArray2 = new byte[byArray.length];
        J j3 = this.a();
        int n2 = l.a(byArray, 0);
        l.a(n2, byArray2, 0);
        int n3 = 0;
        int n4 = 2;
        while (n3 < n2) {
            int n5 = l.a(byArray, n4);
            int n6 = j3.a(n5, j2, map);
            l.a(n6, byArray2, n4);
            ++n3;
            n4 += 2;
        }
        return new as(j2, byArray2);
    }

    public int a() {
        return l.a((byte[])this.a, 0);
    }

    public int a(int n2) {
        return l.a((byte[])this.a, n2 * 2 + 2);
    }
}

