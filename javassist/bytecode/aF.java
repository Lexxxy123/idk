/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.h;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class af
extends h {
    public static final String a = "LocalVariableTable";
    public static final String b = "LocalVariableTypeTable";

    public af(J j2) {
        super(j2, a, new byte[2]);
        l.a(0, (byte[])this.a, 0);
    }

    @Deprecated
    public af(J j2, String string) {
        super(j2, string, new byte[2]);
        l.a(0, (byte[])this.a, 0);
    }

    af(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    af(J j2, String string, byte[] byArray) {
        super(j2, string, byArray);
    }

    public void a(int n2, int n3, int n4, int n5, int n6) {
        int n7 = ((String)this.a).length;
        byte[] byArray = new byte[n7 + 10];
        l.a(this.a() + 1, byArray, 0);
        for (int i2 = 2; i2 < n7; ++i2) {
            byArray[i2] = (byte)this.a[i2];
        }
        l.a(n2, byArray, n7);
        l.a(n3, byArray, n7 + 2);
        l.a(n4, byArray, n7 + 4);
        l.a(n5, byArray, n7 + 6);
        l.a(n6, byArray, n7 + 8);
        this.a = byArray;
    }

    @Override
    void a(String string, String string2) {
        J j2 = this.a();
        int n2 = this.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2 * 10 + 2;
            int n4 = l.a((byte[])this.a, n3 + 6);
            if (n4 == 0) continue;
            String string3 = j2.m(n4);
            string3 = this.a(string3, string, string2);
            l.a(j2.c(string3), (byte[])this.a, n3 + 6);
        }
    }

    String a(String string, String string2, String string3) {
        return M.a(string, string2, string3);
    }

    @Override
    void a(Map<String, String> map) {
        J j2 = this.a();
        int n2 = this.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = i2 * 10 + 2;
            int n4 = l.a((byte[])this.a, n3 + 6);
            if (n4 == 0) continue;
            String string = j2.m(n4);
            string = this.a(string, map);
            l.a(j2.c(string), (byte[])this.a, n3 + 6);
        }
    }

    String a(String string, Map<String, String> map) {
        return M.a(string, map);
    }

    public void a(int n2, int n3) {
        int n4 = ((String)this.a).length;
        for (int i2 = 2; i2 < n4; i2 += 10) {
            int n5 = l.a((byte[])this.a, i2 + 8);
            if (n5 < n2) continue;
            l.a(n5 + n3, (byte[])this.a, i2 + 8);
        }
    }

    public int a() {
        return l.a((byte[])this.a, 0);
    }

    public int a(int n2) {
        return l.a((byte[])this.a, n2 * 10 + 2);
    }

    public int b(int n2) {
        return l.a((byte[])this.a, n2 * 10 + 4);
    }

    void a(int n2, int n3, boolean bl2) {
        int n4 = this.a();
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5 = i2 * 10 + 2;
            int n6 = l.a((byte[])this.a, n5);
            int n7 = l.a((byte[])this.a, n5 + 2);
            if (n6 > n2 || bl2 && n6 == n2 && n6 != 0) {
                l.a(n6 + n3, (byte[])this.a, n5);
                continue;
            }
            if (n6 + n7 <= n2 && (!bl2 || n6 + n7 != n2)) continue;
            l.a(n7 + n3, (byte[])this.a, n5 + 2);
        }
    }

    public int c(int n2) {
        return l.a((byte[])this.a, n2 * 10 + 6);
    }

    public String a(int n2) {
        return this.a().m(this.c(n2));
    }

    public int d(int n2) {
        return l.a((byte[])this.a, n2 * 10 + 8);
    }

    public int e(int n2) {
        return this.d(n2);
    }

    public String b(int n2) {
        return this.a().m(this.d(n2));
    }

    public String c(int n2) {
        return this.b(n2);
    }

    public int f(int n2) {
        return l.a((byte[])this.a, n2 * 10 + 10);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        byte[] byArray = this.a();
        byte[] byArray2 = new byte[byArray.length];
        J j3 = this.a();
        af af2 = this.a(j2, byArray2);
        int n2 = l.a(byArray, 0);
        l.a(n2, byArray2, 0);
        int n3 = 2;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4 = l.a(byArray, n3);
            int n5 = l.a(byArray, n3 + 2);
            int n6 = l.a(byArray, n3 + 4);
            int n7 = l.a(byArray, n3 + 6);
            int n8 = l.a(byArray, n3 + 8);
            l.a(n4, byArray2, n3);
            l.a(n5, byArray2, n3 + 2);
            if (n6 != 0) {
                n6 = j3.a(n6, j2, null);
            }
            l.a(n6, byArray2, n3 + 4);
            if (n7 != 0) {
                String string = j3.m(n7);
                string = M.a(string, map);
                n7 = j2.c(string);
            }
            l.a(n7, byArray2, n3 + 6);
            l.a(n8, byArray2, n3 + 8);
            n3 += 10;
        }
        return af2;
    }

    af a(J j2, byte[] byArray) {
        return new af(j2, a, byArray);
    }
}

