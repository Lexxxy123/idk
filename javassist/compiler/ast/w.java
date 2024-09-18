/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.i;
import javassist.compiler.ast.v;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class w
extends v {
    private static final long a = 1L;
    protected i a;

    public w(String string, i i2) {
        super(string);
        this.a = i2;
    }

    @Override
    public i a() {
        return this.a;
    }

    @Override
    public String toString() {
        return (String)this.a + ":" + this.a.b();
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

