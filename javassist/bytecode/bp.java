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

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class bp
extends H {
    static final int a = 1;
    String a;

    public bp(String string, int n2) {
        super(n2);
        this.a = string;
    }

    public bp(DataInputStream dataInputStream, int n2) {
        super(n2);
        this.a = dataInputStream.readUTF();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean equals(Object object) {
        return object instanceof bp && ((bp)object).a.equals(this.a);
    }

    @Override
    public int a() {
        return 1;
    }

    @Override
    public int a(J j2, J j3, Map<String, String> map) {
        return j3.c(this.a);
    }

    @Override
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(1);
        dataOutputStream.writeUTF(this.a);
    }

    @Override
    public void a(PrintWriter printWriter) {
        printWriter.print("UTF8 \"");
        printWriter.print(this.a);
        printWriter.println("\"");
    }
}

