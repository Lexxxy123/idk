/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import javassist.bytecode.H;
import javassist.bytecode.J;

class I
extends H {
    public I(int n2) {
        super(n2);
    }

    @Override
    public int a() {
        return 0;
    }

    @Override
    public int a(J j2, J j3, Map<String, String> map) {
        return j3.c();
    }

    @Override
    public void a(DataOutputStream dataOutputStream) {
    }

    @Override
    public void a(PrintWriter printWriter) {
        printWriter.println("padding");
    }
}

