/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aF;

public class aJ
extends aF {
    String a;

    aJ(String string, int n2, int n3) {
        this.a = string.substring(n2, n3);
    }

    public aJ(String string) {
        this.a = string;
    }

    public String a() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }

    @Override
    void a(StringBuffer stringBuffer) {
        stringBuffer.append('T').append(this.a).append(';');
    }
}

