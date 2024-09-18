/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.Set;
import javassist.bytecode.J;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.p;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class q
extends p {
    q(String string) {
        super(-1, string);
    }

    @Override
    public p a() {
        return new q(this.a());
    }

    @Override
    public int a() {
        return 6;
    }

    @Override
    public int a(J j2) {
        return 0;
    }

    @Override
    String a(Set<h> set) {
        return "uninit:this";
    }
}

