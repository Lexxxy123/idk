/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import javassist.bytecode.J;
import javassist.bytecode.K;
import javassist.bytecode.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class W {
    J a;
    int a;
    int b;
    String a;
    String b;
    int c;
    List<h> a;

    private W(J j2) {
        this.a = j2;
        this.a = 0;
        this.a = null;
    }

    public W(J j2, String string, String string2) {
        this(j2);
        this.b = j2.c(string);
        this.a = string;
        this.c = j2.c(string2);
    }

    W(J j2, DataInputStream dataInputStream) {
        this(j2);
        this.a(dataInputStream);
    }

    public String toString() {
        return this.a() + " " + this.b();
    }

    void a(J j2) {
        this.b = j2.c(this.a());
        this.c = j2.c(this.b());
        this.a = h.a((List<h>)((Object)this.a), j2);
        this.a = j2;
    }

    void b(J j2) {
        int n2;
        h h2;
        h h3;
        ArrayList<h> arrayList = new ArrayList<h>();
        h h4 = this.a("RuntimeInvisibleAnnotations");
        if (h4 != null) {
            h4 = h4.a(j2, null);
            arrayList.add(h4);
        }
        if ((h3 = this.a("RuntimeVisibleAnnotations")) != null) {
            h3 = h3.a(j2, null);
            arrayList.add(h3);
        }
        if ((h2 = this.a("Signature")) != null) {
            h2 = h2.a(j2, null);
            arrayList.add(h2);
        }
        if ((n2 = this.b()) != 0) {
            n2 = this.a.a(n2, j2, null);
            arrayList.add(new K(j2, n2));
        }
        this.a = arrayList;
        this.b = j2.c(this.a());
        this.c = j2.c(this.b());
        this.a = j2;
    }

    public J a() {
        return this.a;
    }

    public String a() {
        if (this.a == null) {
            this.a = this.a.m(this.b);
        }
        return this.a;
    }

    public void a(String string) {
        this.b = this.a.c(string);
        this.a = string;
    }

    public int a() {
        return this.a;
    }

    public void a(int n2) {
        this.a = n2;
    }

    public String b() {
        return this.a.m(this.c);
    }

    public void b(String string) {
        if (!string.equals(this.b())) {
            this.c = this.a.c(string);
        }
    }

    public int b() {
        if ((this.a & 8) == 0) {
            return 0;
        }
        K k2 = (K)this.a("ConstantValue");
        if (k2 == null) {
            return 0;
        }
        return k2.a();
    }

    public List<h> a() {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        return this.a;
    }

    public h a(String string) {
        return h.a((List<h>)((Object)this.a), string);
    }

    public h b(String string) {
        return h.b((List<h>)((Object)this.a), string);
    }

    public void a(h h2) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        h.b((List<h>)((Object)this.a), h2.a());
        this.a.add(h2);
    }

    private void a(DataInputStream dataInputStream) {
        this.a = dataInputStream.readUnsignedShort();
        this.b = dataInputStream.readUnsignedShort();
        this.c = dataInputStream.readUnsignedShort();
        int n2 = dataInputStream.readUnsignedShort();
        this.a = new ArrayList();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a.add(h.a(this.a, dataInputStream));
        }
    }

    void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.a);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.c);
        if (this.a == null) {
            dataOutputStream.writeShort(0);
        } else {
            dataOutputStream.writeShort(this.a.size());
            h.a((List<h>)((Object)this.a), dataOutputStream);
        }
    }
}

