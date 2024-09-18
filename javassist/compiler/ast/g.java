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
public class g
extends a
implements z {
    private static final long a = 1L;
    protected int a;
    protected int b;

    public g(a a2, int n2, b b2) {
        super(a2, new a(b2));
        this.a = 307;
        this.b = n2;
    }

    public g(int n2, int n3, b b2) {
        super(null, new a(b2));
        this.a = n2;
        this.b = n3;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    @Override
    public a b() {
        return (a)this.a();
    }

    public b d() {
        return this.b().a();
    }

    public void d(b b2) {
        this.b().a(b2);
    }

    @Override
    public String a() {
        return "cast:" + this.a + ":" + this.b;
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

