/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import javassist.bytecode.J;
import javassist.bytecode.stackmap.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class i
extends h {
    public abstract void a(h var1);

    @Override
    public int a() {
        return 7;
    }

    @Override
    public int a(J j2) {
        return j2.a(this.a());
    }

    @Override
    public boolean a(h h2) {
        return this.a().equals(h2.a());
    }
}

