/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import javassist.bytecode.stackmap.a;
import javassist.bytecode.stackmap.d;
import javassist.bytecode.stackmap.t;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class u
extends d {
    @Override
    protected a a(int n2) {
        return new t(n2);
    }

    @Override
    protected a[] a(int n2) {
        return new t[n2];
    }
}

