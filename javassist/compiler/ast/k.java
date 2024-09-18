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
public class k
extends a
implements z {
    private static final long a = 1L;
    protected int a;

    k(int n2, b b2, a a2) {
        super(b2, a2);
        this.a = n2;
    }

    k(int n2, b b2) {
        super(b2);
        this.a = n2;
    }

    public static k a(int n2, b b2, b b3) {
        return new k(n2, b2, new a(b3));
    }

    public static k a(int n2, b b2) {
        return new k(n2, b2);
    }

    public int b() {
        return this.a;
    }

    public void a(int n2) {
        this.a = n2;
    }

    public b d() {
        return this.a();
    }

    public void d(b b2) {
        this.a(b2);
    }

    public b e() {
        return this.b().a();
    }

    public void e(b b2) {
        this.b().a(b2);
    }

    @Override
    public void a(x x2) {
        x2.c(this);
    }

    public String b() {
        int n2 = this.a;
        if (n2 < 128) {
            return String.valueOf((char)n2);
        }
        if (350 <= n2 && n2 <= 371) {
            return a[n2 - 350];
        }
        if (n2 == 323) {
            return "instanceof";
        }
        return String.valueOf(n2);
    }

    @Override
    protected String a() {
        return "op:" + this.b();
    }
}

