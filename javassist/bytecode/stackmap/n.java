/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import javassist.bytecode.J;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.m;

public class n
extends m {
    public n() {
        super("null-type");
    }

    @Override
    public int a() {
        return 5;
    }

    @Override
    public boolean b() {
        return true;
    }

    @Override
    public int a(J j2) {
        return 0;
    }

    @Override
    public h a(int n2) {
        return this;
    }
}

