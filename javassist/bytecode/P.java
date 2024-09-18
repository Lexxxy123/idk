/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import javassist.bytecode.H;
import javassist.bytecode.J;
import javassist.bytecode.M;

class p
extends H {
    static final int a = 7;
    int b;

    public p(int n2, int n3) {
        super(n3);
        this.b = n2;
    }

    public p(DataInputStream dataInputStream, int n2) {
        super(n2);
        this.b = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return this.b;
    }

    public boolean equals(Object object) {
        return object instanceof p && ((p)object).b == this.b;
    }

    @Override
    public int a() {
        return 7;
    }

    @Override
    public String a(J j2) {
        return j2.m(this.b);
    }

    @Override
    public void a(J j2, String string, String string2, Map<H, H> map) {
        String string3;
        String string4 = j2.m(this.b);
        String string5 = null;
        if (string4.equals(string)) {
            string5 = string2;
        } else if (string4.charAt(0) == '[' && string4 != (string3 = M.a(string4, string, string2))) {
            string5 = string3;
        }
        if (string5 != null) {
            if (map == null) {
                this.b = j2.c(string5);
            } else {
                map.remove(this);
                this.b = j2.c(string5);
                map.put(this, this);
            }
        }
    }

    @Override
    public void a(J j2, Map<String, String> map, Map<H, H> map2) {
        String string = j2.m(this.b);
        String string2 = null;
        if (string.charAt(0) == '[') {
            String string3 = M.a(string, map);
            if (string != string3) {
                string2 = string3;
            }
        } else {
            String string4 = map.get(string);
            if (string4 != null && !string4.equals(string)) {
                string2 = string4;
            }
        }
        if (string2 != null) {
            if (map2 == null) {
                this.b = j2.c(string2);
            } else {
                map2.remove(this);
                this.b = j2.c(string2);
                map2.put(this, this);
            }
        }
    }

    @Override
    public int a(J j2, J j3, Map<String, String> map) {
        String string;
        String string2 = j2.m(this.b);
        if (map != null && (string = map.get(string2)) != null) {
            string2 = string;
        }
        return j3.a(string2);
    }

    @Override
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(7);
        dataOutputStream.writeShort(this.b);
    }

    @Override
    public void a(PrintWriter printWriter) {
        printWriter.print("Class #");
        printWriter.println(this.b);
    }
}

