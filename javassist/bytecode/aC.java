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

class ac
extends H {
    static final int a = 18;
    int b;
    int d;

    public ac(int n2, int n3, int n4) {
        super(n4);
        this.b = n2;
        this.d = n3;
    }

    public ac(DataInputStream dataInputStream, int n2) {
        super(n2);
        this.b = dataInputStream.readUnsignedShort();
        this.d = dataInputStream.readUnsignedShort();
    }

    public int hashCode() {
        return this.b << 16 ^ this.d;
    }

    public boolean equals(Object object) {
        if (object instanceof ac) {
            ac ac2 = (ac)object;
            return ac2.b == this.b && ac2.d == this.d;
        }
        return false;
    }

    @Override
    public int a() {
        return 18;
    }

    @Override
    public int a(J j2, J j3, Map<String, String> map) {
        return j3.f(this.b, j2.a(this.d).a(j2, j3, map));
    }

    @Override
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(18);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.d);
    }

    @Override
    public void a(PrintWriter printWriter) {
        printWriter.print("InvokeDynamic #");
        printWriter.print(this.b);
        printWriter.print(", name&type #");
        printWriter.println(this.d);
    }
}

