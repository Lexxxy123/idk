/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.h;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class S
extends h {
    public static final String a = "EnclosingMethod";

    S(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public S(J j2, String string, String string2, String string3) {
        super(j2, a);
        int n2 = j2.a(string);
        int n3 = j2.a(string2, string3);
        byte[] byArray = new byte[]{(byte)(n2 >>> 8), (byte)n2, (byte)(n3 >>> 8), (byte)n3};
        this.a(byArray);
    }

    public S(J j2, String string) {
        super(j2, a);
        int n2 = j2.a(string);
        int n3 = 0;
        byte[] byArray = new byte[]{(byte)(n2 >>> 8), (byte)n2, (byte)(n3 >>> 8), (byte)n3};
        this.a(byArray);
    }

    public int a() {
        return l.a(this.a(), 0);
    }

    public int c() {
        return l.a(this.a(), 2);
    }

    public String b() {
        return this.a().a(this.a());
    }

    public String c() {
        J j2 = this.a();
        int n2 = this.c();
        if (n2 == 0) {
            return "<clinit>";
        }
        int n3 = j2.b(n2);
        return j2.m(n3);
    }

    public String d() {
        J j2 = this.a();
        int n2 = this.c();
        int n3 = j2.c(n2);
        return j2.m(n3);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        if (this.c() == 0) {
            return new S(j2, this.b());
        }
        return new S(j2, this.b(), this.c(), this.d());
    }
}

