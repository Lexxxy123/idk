/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.expr;

import javassist.expr.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
final class f {
    g a;
    int a;
    int b;

    f(int n2) {
        this.a = n2;
        this.b = 0;
        this.a = null;
    }

    void a(int n2, int n3) {
        if (this.a < n2) {
            this.a = n2;
        }
        if (this.b < n3) {
            this.b = n3;
        }
    }
}

