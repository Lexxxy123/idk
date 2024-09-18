/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.x;
import javassist.compiler.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class t
extends a
implements z {
    private static final long a = 1L;
    protected int a;

    public t(int n2, b b2, a a2) {
        super(b2, a2);
        this.a = n2;
    }

    public t(int n2, b b2) {
        super(b2);
        this.a = n2;
    }

    public t(int n2) {
        this(n2, null);
    }

    public static t a(int n2, b b2, b b3) {
        return new t(n2, b2, new a(b3));
    }

    public static t a(int n2, b b2, b b3, b b4) {
        return new t(n2, b2, new a(b3, new a(b4)));
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }

    public int b() {
        return this.a;
    }

    @Override
    protected String a() {
        if (this.a < 128) {
            return "stmnt:" + (char)this.a;
        }
        return "stmnt:" + this.a;
    }
}

