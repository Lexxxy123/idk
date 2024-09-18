/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import javassist.bytecode.analysis.b;
import javassist.bytecode.analysis.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class c {
    private int a;
    private int b;
    private int c;
    private m a;

    private c(int n2, int n3, int n4, m m2) {
        this.c = n2;
        this.a = n3;
        this.b = n4;
        this.a = m2;
    }

    /* synthetic */ c(int n2, int n3, int n4, m m2, b b2) {
        this(n2, n3, n4, m2);
    }

    static /* synthetic */ int a(c c2) {
        return c2.c;
    }

    static /* synthetic */ int b(c c2) {
        return c2.a;
    }

    static /* synthetic */ m a(c c2) {
        return c2.a;
    }

    static /* synthetic */ int c(c c2) {
        return c2.b;
    }
}

