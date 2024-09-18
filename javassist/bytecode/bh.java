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

class bh
extends H {
    static final int a = 8;
    int b;

    public bh(int n2, int n3) {
        super(n3);
        this.b = n2;
    }

    public bh(DataInputStream dataInputStream, int n2) {
        super(n2);
        this.b = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return this.b;
    }

    public boolean equals(Object object) {
        return object instanceof bh && ((bh)object).b == this.b;
    }

    @Override
    public int a() {
        return 8;
    }

    @Override
    public int a(J j2, J j3, Map<String, String> map) {
        return j3.b(j2.m(this.b));
    }

    @Override
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(8);
        dataOutputStream.writeShort(this.b);
    }

    @Override
    public void a(PrintWriter printWriter) {
        printWriter.print("String #");
        printWriter.println(this.b);
    }
}

