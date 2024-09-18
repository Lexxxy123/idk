/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.r;
import javassist.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class U {
    U a;
    r a;
    x a = null;

    U(r r2, x x2) {
        this.a = r2;
        this.a = x2;
    }
}

