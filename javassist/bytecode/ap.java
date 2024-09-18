/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.PrintWriter;
import javassist.bytecode.aL;
import javassist.bytecode.aT;
import javassist.bytecode.l;

class aP
extends aT {
    private PrintWriter a;

    public aP(aL aL2, PrintWriter printWriter) {
        super(aL2);
        this.a = printWriter;
    }

    public void b() {
        int n2 = l.a(this.b, 0);
        this.a.println(n2 + " entries");
        this.a();
    }

    @Override
    public int a(int n2, int n3, int n4) {
        this.a.println("  * offset " + n3);
        return super.a(n2, n3, n4);
    }
}

