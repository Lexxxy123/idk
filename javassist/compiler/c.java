/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.bytecode.n;
import javassist.compiler.b;
import javassist.compiler.d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class c
extends d {
    final /* synthetic */ int a;
    final /* synthetic */ b a;

    c(b b2, b b3, int n2) {
        this.a = b2;
        this.a = n2;
        super(b3);
    }

    @Override
    protected boolean a(n n2, int n3) {
        n2.k(this.a);
        n2.g(195);
        return false;
    }
}

