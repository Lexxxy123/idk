/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.v;
import javassist.compiler.ast.x;
import javassist.compiler.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class i
extends a
implements z {
    private static final long a = 1L;
    protected int a;
    protected int b;
    protected int aM;
    protected String a;

    public i(int n2, int n3) {
        super(null);
        this.a = n2;
        this.b = n3;
        this.aM = -1;
        this.a = null;
    }

    public i(a a2, int n2) {
        super(null);
        this.a = 307;
        this.b = n2;
        this.aM = -1;
        this.a = i.a(a2, '/');
    }

    public i(int n2, String string, int n3, int n4, v v2) {
        super(null);
        this.a = n2;
        this.b = n3;
        this.aM = n4;
        this.a = string;
        this.a((b)v2);
        i.a((a)this, null);
    }

    public i a(v v2, int n2, b b2) {
        i i2 = new i(this.a, this.b + n2);
        i2.a = this.a;
        i2.a((b)v2);
        i.a((a)i2, b2);
        return i2;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public void a(int n2) {
        this.b += n2;
    }

    public String b() {
        return this.a;
    }

    public void a(String string) {
        this.a = string;
    }

    @Override
    public v a() {
        return (v)this.a();
    }

    public void a(v v2) {
        this.a((b)v2);
    }

    public b d() {
        b b2 = this.a();
        if (b2 != null) {
            return ((a)b2).c();
        }
        return null;
    }

    public void b(int n2) {
        this.aM = n2;
    }

    public int d() {
        return this.aM;
    }

    @Override
    public String a() {
        return "decl";
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }

    public static String a(a a2, char c2) {
        if (a2 == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        i.a(stringBuffer, a2, c2);
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, a b2, char c2) {
        while (true) {
            b b3;
            if ((b3 = b2.c()) instanceof v) {
                stringBuffer.append(((v)b3).b());
            } else if (b3 instanceof a) {
                i.a(stringBuffer, (a)b3, c2);
            }
            b2 = b2.a();
            if (b2 == null) break;
            stringBuffer.append(c2);
        }
    }
}

