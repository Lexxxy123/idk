/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.b;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
extends b {
    private static final long a = 1L;
    private b a;
    private a a;

    public a(b b2, a a2) {
        this.a = b2;
        this.a = a2;
    }

    public a(b b2) {
        this.a = b2;
        this.a = null;
    }

    public static a a(b b2, b b3, b b4) {
        return new a(b2, new a(b3, new a(b4)));
    }

    @Override
    public b a() {
        return this.a;
    }

    @Override
    public b b() {
        return this.a;
    }

    @Override
    public void a(b b2) {
        this.a = b2;
    }

    @Override
    public void b(b b2) {
        this.a = (a)b2;
    }

    public b c() {
        return this.a;
    }

    public void c(b b2) {
        this.a = b2;
    }

    @Override
    public a a() {
        return this.a;
    }

    public void a(a a2) {
        this.a = a2;
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(<");
        stringBuffer.append(this.a());
        stringBuffer.append('>');
        a a2 = this;
        while (a2 != null) {
            stringBuffer.append(' ');
            b b2 = a2.a;
            stringBuffer.append(b2 == null ? "<null>" : b2.toString());
            a2 = a2.a;
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public int a() {
        return javassist.compiler.ast.a.a(this);
    }

    public static int a(a a2) {
        if (a2 == null) {
            return 0;
        }
        int n2 = 0;
        while (a2 != null) {
            a2 = a2.a;
            ++n2;
        }
        return n2;
    }

    public a a(int n2) {
        a a2 = this;
        while (n2-- > 0) {
            a2 = a2.a;
        }
        return a2;
    }

    public boolean a(b b2, b b3) {
        a a2 = this;
        while (a2 != null) {
            if (a2.a == b3) {
                a2.a = b2;
                return true;
            }
            a2 = a2.a;
        }
        return false;
    }

    public static a a(a a2, b b2) {
        return javassist.compiler.ast.a.a(a2, new a(b2));
    }

    public static a a(a a2, a a3) {
        if (a2 == null) {
            return a3;
        }
        a a4 = a2;
        while (a4.a != null) {
            a4 = a4.a;
        }
        a4.a = a3;
        return a2;
    }
}

