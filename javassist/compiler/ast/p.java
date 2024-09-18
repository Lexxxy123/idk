/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.v;
import javassist.compiler.ast.x;
import javassist.r;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class p
extends v {
    private static final long a = 1L;
    private r a = null;

    public p(String string) {
        super(string);
    }

    public void a(r r2) {
        this.a = r2;
    }

    public r a() {
        return this.a;
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

