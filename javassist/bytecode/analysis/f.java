/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import java.util.NoSuchElementException;
import javassist.bytecode.analysis.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class f {
    private h a;
    private h b;

    f() {
    }

    void a(int n2) {
        h h2 = new h(n2, null);
        if (this.b != null) {
            h.a(this.b, h2);
        }
        this.b = h2;
        if (this.a == null) {
            this.a = h2;
        }
    }

    boolean a() {
        return this.a == null;
    }

    int a() {
        if (this.a == null) {
            throw new NoSuchElementException();
        }
        int n2 = h.a(this.a);
        this.a = h.a(this.a);
        if (this.a == null) {
            this.b = null;
        }
        return n2;
    }
}

