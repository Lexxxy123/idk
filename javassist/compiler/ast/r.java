/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.c;
import javassist.compiler.ast.x;
import javassist.compiler.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class r
extends a
implements z {
    private static final long a = 1L;
    protected boolean a;
    protected int a;

    public r(a a2, a a3) {
        super(a2, new a(a3));
        this.a = false;
        this.a = 307;
    }

    public r(int n2, a a2, c c2) {
        super(null, new a(a2));
        this.a = true;
        this.a = n2;
        if (c2 != null) {
            r.a((a)this, (b)c2);
        }
    }

    public static r a(a a2, a a3, c c2) {
        r r2 = new r(a2, a3);
        r2.a = true;
        if (c2 != null) {
            r.a((a)r2, (b)c2);
        }
        return r2;
    }

    public boolean a() {
        return this.a;
    }

    public int b() {
        return this.a;
    }

    @Override
    public a b() {
        return (a)this.a();
    }

    @Override
    public a c() {
        return (a)this.b().a();
    }

    public a d() {
        return this.c();
    }

    @Override
    public c a() {
        b b2 = this.b().b();
        if (b2 == null) {
            return null;
        }
        return (c)b2.a();
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }

    @Override
    protected String a() {
        return this.a ? "new[]" : "new";
    }
}

