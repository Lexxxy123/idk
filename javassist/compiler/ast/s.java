/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.b;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class s
extends b {
    private static final long a = 1L;
    protected b a;
    protected b b;

    public s(b b2, b b3) {
        this.a = b2;
        this.b = b3;
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(<Pair> ");
        stringBuffer.append(this.a == null ? "<null>" : this.a.toString());
        stringBuffer.append(" . ");
        stringBuffer.append(this.b == null ? "<null>" : this.b.toString());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    @Override
    public b a() {
        return this.a;
    }

    @Override
    public b b() {
        return this.b;
    }

    @Override
    public void a(b b2) {
        this.a = b2;
    }

    @Override
    public void b(b b2) {
        this.b = b2;
    }
}

