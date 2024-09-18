/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import javassist.bytecode.J;

abstract class H {
    int c;

    public H(int n2) {
        this.c = n2;
    }

    public abstract int a();

    public String a(J j2) {
        return null;
    }

    public void a(J j2, String string, String string2, Map<H, H> map) {
    }

    public void a(J j2, Map<String, String> map, Map<H, H> map2) {
    }

    public abstract int a(J var1, J var2, Map<String, String> var3);

    public abstract void a(DataOutputStream var1);

    public abstract void a(PrintWriter var1);

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
        this.a(printWriter);
        return byteArrayOutputStream.toString();
    }
}

