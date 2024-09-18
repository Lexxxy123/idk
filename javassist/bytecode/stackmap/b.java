/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import javassist.bytecode.stackmap.a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b {
    public b a;
    public a a;
    public int a;

    b(a a2, int n2, b b2) {
        this.a = a2;
        this.a = n2;
        this.a = b2;
    }
}

