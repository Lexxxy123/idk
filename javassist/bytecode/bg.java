/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import javassist.bytecode.J;
import javassist.bytecode.aV;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bg {
    ByteArrayOutputStream a;
    int a;

    public bg(int n2) {
        this.a = new ByteArrayOutputStream(n2);
        this.a = 0;
        this.a.write(0);
        this.a.write(0);
    }

    public byte[] a() {
        byte[] byArray = this.a.toByteArray();
        l.a(this.a, byArray, 0);
        return byArray;
    }

    public aV a(J j2) {
        return new aV(j2, this.a());
    }

    public void a(int n2) {
        ++this.a;
        if (n2 < 64) {
            this.a.write(n2);
        } else {
            this.a.write(251);
            this.b(n2);
        }
    }

    public void a(int n2, int n3, int n4) {
        ++this.a;
        if (n2 < 64) {
            this.a.write(n2 + 64);
        } else {
            this.a.write(247);
            this.b(n2);
        }
        this.b(n3, n4);
    }

    public void a(int n2, int n3) {
        ++this.a;
        this.a.write(251 - n3);
        this.b(n2);
    }

    public void a(int n2, int[] nArray, int[] nArray2) {
        ++this.a;
        int n3 = nArray.length;
        this.a.write(n3 + 251);
        this.b(n2);
        for (int i2 = 0; i2 < n3; ++i2) {
            this.b(nArray[i2], nArray2[i2]);
        }
    }

    public void a(int n2, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4) {
        int n3;
        ++this.a;
        this.a.write(255);
        this.b(n2);
        int n4 = nArray.length;
        this.b(n4);
        for (n3 = 0; n3 < n4; ++n3) {
            this.b(nArray[n3], nArray2[n3]);
        }
        n4 = nArray3.length;
        this.b(n4);
        for (n3 = 0; n3 < n4; ++n3) {
            this.b(nArray3[n3], nArray4[n3]);
        }
    }

    private void b(int n2, int n3) {
        this.a.write(n2);
        if (n2 == 7 || n2 == 8) {
            this.b(n3);
        }
    }

    private void b(int n2) {
        this.a.write(n2 >>> 8 & 0xFF);
        this.a.write(n2 & 0xFF);
    }
}

