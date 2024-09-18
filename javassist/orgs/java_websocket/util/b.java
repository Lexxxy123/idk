/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javassist.orgs.java_websocket.util.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
extends FilterOutputStream {
    private boolean a;
    private int a;
    private byte[] a;
    private int b;
    private int c;
    private boolean b;
    private byte[] b;
    private boolean c;
    private int d;
    private byte[] c;

    public b(OutputStream outputStream) {
        this(outputStream, 1);
    }

    public b(OutputStream outputStream, int n2) {
        super(outputStream);
        this.b = (n2 & 8) != 0;
        this.a = (n2 & 1) != 0;
        this.b = this.a ? 3 : 4;
        this.a = new byte[this.b];
        this.a = 0;
        this.c = 0;
        this.c = false;
        this.b = new byte[4];
        this.d = n2;
        this.c = javassist.orgs.java_websocket.util.a.a(n2);
    }

    @Override
    public void write(int n2) {
        if (this.c) {
            this.out.write(n2);
            return;
        }
        if (this.a) {
            this.a[this.a++] = (byte)n2;
            if (this.a >= this.b) {
                this.out.write(javassist.orgs.java_websocket.util.a.a(this.b, this.a, this.b, this.d));
                this.c += 4;
                if (this.b && this.c >= 76) {
                    this.out.write(10);
                    this.c = 0;
                }
                this.a = 0;
            }
        } else if (this.c[n2 & 0x7F] > -5) {
            this.a[this.a++] = (byte)n2;
            if (this.a >= this.b) {
                int n3 = javassist.orgs.java_websocket.util.a.a(this.a, 0, this.b, 0, this.d);
                this.out.write(this.b, 0, n3);
                this.a = 0;
            }
        } else if (this.c[n2 & 0x7F] != -5) {
            throw new IOException("Invalid character in Base64 data.");
        }
    }

    @Override
    public void write(byte[] byArray, int n2, int n3) {
        if (this.c) {
            this.out.write(byArray, n2, n3);
            return;
        }
        int n4 = 0;
        while (n4 < n3) {
            this.write(byArray[n2 + n4]);
            ++n4;
        }
    }

    public void a() {
        if (this.a > 0) {
            if (this.a) {
                this.out.write(javassist.orgs.java_websocket.util.a.a(this.b, this.a, this.a, this.d));
                this.a = 0;
            } else {
                throw new IOException("Base64 input not properly padded.");
            }
        }
    }

    @Override
    public void close() {
        this.a();
        super.close();
        this.a = null;
        this.out = null;
    }
}

