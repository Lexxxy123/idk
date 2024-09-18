/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import javassist.bytecode.analysis.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class h {
    private h a;
    private int a;

    private h(int n2) {
        this.a = n2;
    }

    /* synthetic */ h(int n2, g g2) {
        this(n2);
    }

    static /* synthetic */ h a(h h2, h h3) {
        h2.a = h3;
        return h2.a;
    }

    static /* synthetic */ int a(h h2) {
        return h2.a;
    }

    static /* synthetic */ h a(h h2) {
        return h2.a;
    }
}

