/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import javassist.bytecode.stackmap.a;
import javassist.bytecode.stackmap.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class e
implements Comparable<e> {
    int a;
    a a;
    a[] a;
    boolean a;
    int b;
    b a;

    e(int n2) {
        this.a = n2;
        this.a = null;
        this.a = null;
        this.a = false;
        this.b = 0;
        this.a = null;
    }

    public int a(e e2) {
        if (null == e2) {
            return -1;
        }
        return this.a - e2.a;
    }

    void a(a[] aArray, int n2, boolean bl2) {
        this.a = aArray;
        this.b = n2;
        this.a = bl2;
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.a((e)object);
    }
}

