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

class au
extends H {
    static final int a = 20;
    int b;

    public au(int n2, int n3) {
        super(n3);
        this.b = n2;
    }

    public au(DataInputStream dataInputStream, int n2) {
        super(n2);
        this.b = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return this.b;
    }

    public boolean equals(Object object) {
        return object instanceof au && ((au)object).b == this.b;
    }

    @Override
    public int a() {
        return 20;
    }

    public String b(J j2) {
        return j2.m(this.b);
    }

    @Override
    public int a(J j2, J j3, Map<String, String> map) {
        String string = j2.m(this.b);
        int n2 = j3.c(string);
        return j3.v(n2);
    }

    @Override
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(20);
        dataOutputStream.writeShort(this.b);
    }

    @Override
    public void a(PrintWriter printWriter) {
        printWriter.print("Package #");
        printWriter.println(this.b);
    }
}

