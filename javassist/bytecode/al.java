/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.io.PrintWriter;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.aM;
import javassist.bytecode.aN;
import javassist.bytecode.aO;
import javassist.bytecode.aP;
import javassist.bytecode.aQ;
import javassist.bytecode.aS;
import javassist.bytecode.h;
import javassist.bytecode.l;

public class aL
extends h {
    public static final String a = "StackMap";
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 6;
    public static final int i = 7;
    public static final int j = 8;

    aL(J j2, byte[] byArray) {
        super(j2, a, byArray);
    }

    aL(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public int a() {
        return l.a((byte[])this.a, 0);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        aM aM2 = new aM(this, j2, map);
        aM2.a();
        return aM2.a();
    }

    public void a(int n2, int n3, int n4) {
        byte[] byArray = new aN(this, n2, n3, n4).a();
        this.a(byArray);
    }

    void a(int n2, int n3, boolean bl2) {
        new aQ(this, n2, n3, bl2).a();
    }

    void a(int n2, int n3) {
        new aS(this, n2, n3).a();
    }

    public void a(int n2) {
        byte[] byArray = new aO(this, n2).a();
        this.a(byArray);
    }

    public void a(PrintWriter printWriter) {
        new aP(this, printWriter).b();
    }
}

