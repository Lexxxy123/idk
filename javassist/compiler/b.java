/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javassist.bytecode.at;
import javassist.compiler.A;
import javassist.compiler.ast.a;
import javassist.compiler.ast.f;
import javassist.compiler.ast.g;
import javassist.compiler.ast.h;
import javassist.compiler.ast.i;
import javassist.compiler.ast.j;
import javassist.compiler.ast.k;
import javassist.compiler.ast.l;
import javassist.compiler.ast.m;
import javassist.compiler.ast.n;
import javassist.compiler.ast.o;
import javassist.compiler.ast.p;
import javassist.compiler.ast.q;
import javassist.compiler.ast.s;
import javassist.compiler.ast.t;
import javassist.compiler.ast.u;
import javassist.compiler.ast.v;
import javassist.compiler.ast.w;
import javassist.compiler.ast.x;
import javassist.compiler.c;
import javassist.compiler.d;
import javassist.compiler.e;
import javassist.compiler.r;
import javassist.compiler.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class b
extends x
implements at,
z {
    static final String a = "java.lang.Object";
    static final String b = "java/lang/Object";
    static final String c = "java.lang.String";
    static final String d = "java/lang/String";
    protected javassist.bytecode.n a;
    private int dg;
    A a;
    protected boolean a;
    public boolean b;
    protected List<Integer> a;
    protected List<Integer> b;
    protected d a;
    protected int a;
    protected int b;
    protected String e;
    static final int[] b = new int[]{43, 99, 98, 97, 96, 45, 103, 102, 101, 100, 42, 107, 106, 105, 104, 47, 111, 110, 109, 108, 37, 115, 114, 113, 112, 124, 0, 0, 129, 128, 94, 0, 0, 131, 130, 38, 0, 0, 127, 126, 364, 0, 0, 121, 120, 366, 0, 0, 123, 122, 370, 0, 0, 125, 124};
    private static final int[] c = new int[]{358, 159, 160, 350, 160, 159, 357, 164, 163, 359, 162, 161, 60, 161, 162, 62, 163, 164};
    private static final int[] d = new int[]{358, 153, 154, 350, 154, 153, 357, 158, 157, 359, 156, 155, 60, 155, 156, 62, 157, 158};
    private static final int dh = 0;
    private static final int di = 1;
    private static final int dj = 2;
    private static final int dk = 3;
    private static final int dl = -1;
    private static final int[] e = new int[]{0, 144, 143, 142, 141, 0, 140, 139, 138, 137, 0, 136, 135, 134, 133, 0};

    public b(javassist.bytecode.n n2) {
        this.a = n2;
        this.dg = -1;
        this.a = null;
        this.a = false;
        this.b = false;
        this.a = null;
        this.b = null;
        this.a = null;
    }

    public void a(A a2) {
        this.a = a2;
    }

    protected static void a() {
        throw new e("fatal");
    }

    public static boolean a(int n2, int n3) {
        return n3 == 0 && (n2 == 312 || n2 == 326);
    }

    public int a() {
        return this.a.d();
    }

    public void a(int n2) {
        this.a.d(n2);
    }

    protected void b(int n2) {
        this.a.e(n2);
    }

    protected int b() {
        if (this.dg < 0) {
            this.dg = this.a();
            this.b(2);
        }
        return this.dg;
    }

    protected int a(i i2) {
        int n2 = i2.d();
        if (n2 < 0) {
            n2 = this.a();
            i2.b(n2);
            this.b(1);
        }
        return n2;
    }

    protected abstract String a();

    protected abstract String b();

    protected abstract String a(a var1);

    protected abstract String a(String var1);

    protected static String a(String string, int n2) {
        if (string == null) {
            return null;
        }
        if (n2 == 0) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = n2;
        while (n3-- > 0) {
            stringBuffer.append('[');
        }
        stringBuffer.append('L');
        stringBuffer.append(string);
        stringBuffer.append(';');
        return stringBuffer.toString();
    }

    protected static String a(int n2, int n3) {
        char c2 = 'I';
        switch (n2) {
            case 301: {
                c2 = 'Z';
                break;
            }
            case 303: {
                c2 = 'B';
                break;
            }
            case 306: {
                c2 = 'C';
                break;
            }
            case 334: {
                c2 = 'S';
                break;
            }
            case 324: {
                c2 = 'I';
                break;
            }
            case 326: {
                c2 = 'J';
                break;
            }
            case 317: {
                c2 = 'F';
                break;
            }
            case 312: {
                c2 = 'D';
                break;
            }
            case 344: {
                c2 = 'V';
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (n3-- > 0) {
            stringBuffer.append('[');
        }
        stringBuffer.append(c2);
        return stringBuffer.toString();
    }

    public void a(javassist.compiler.ast.b b2) {
        this.b(b2);
        b2.a(this);
    }

    public boolean a(boolean bl2, javassist.compiler.ast.b b2) {
        this.b(b2);
        return this.b(bl2, b2);
    }

    public void b(javassist.compiler.ast.b b2) {
        if (this.a != null) {
            b2.a(this.a);
        }
    }

    @Override
    public void a(a a2) {
        javassist.compiler.b.a();
    }

    @Override
    public void a(s s2) {
        javassist.compiler.b.a();
    }

    @Override
    public void a(v v2) {
        javassist.compiler.b.a();
    }

    @Override
    public void a(l l2) {
        l2.d().a(this);
    }

    @Override
    public void a(q q2) {
        javassist.compiler.ast.b b2;
        this.a(1);
        for (javassist.compiler.ast.b b3 = q2.b(); b3 != null; b3 = b3.a()) {
            b2 = (o)b3.c();
            if (((o)b2).a() != 335) continue;
            this.a(0);
            this.b = true;
        }
        for (b2 = q2.c(); b2 != null; b2 = ((a)b2).a()) {
            this.a((i)((a)b2).c());
        }
        t t2 = q2.a();
        this.a(t2, q2.a(), q2.a().b() == 344);
    }

    public void a(t t2, boolean bl2, boolean bl3) {
        if (t2 == null) {
            return;
        }
        if (bl2 && this.a(t2)) {
            this.b();
        }
        this.a = false;
        t2.a(this);
        if (!this.a) {
            if (bl3) {
                this.a.g(177);
                this.a = true;
            } else {
                throw new e("no return statement");
            }
        }
    }

    private boolean a(t t2) {
        javassist.compiler.ast.b b2;
        javassist.compiler.ast.b b3;
        if (t2.b() == 66) {
            t2 = (t)t2.c();
        }
        if (t2 != null && t2.b() == 69 && (b3 = t2.c()) != null && b3 instanceof k && ((k)b3).b() == 67 && (b2 = ((k)b3).c()) instanceof o) {
            int n2 = ((o)b2).a();
            return n2 != 339 && n2 != 336;
        }
        return true;
    }

    protected abstract void b();

    @Override
    public void a(t t2) {
        if (t2 == null) {
            return;
        }
        int n2 = t2.b();
        if (n2 == 69) {
            javassist.compiler.ast.b b2 = t2.a();
            this.b(b2);
            if (b2 instanceof javassist.compiler.ast.d) {
                this.a((javassist.compiler.ast.d)b2, false);
            } else if (javassist.compiler.b.a(b2)) {
                k k2 = (k)b2;
                this.a(k2.b(), k2.d(), k2, false);
            } else {
                b2.a(this);
                if (javassist.compiler.b.a(this.a, this.b)) {
                    this.a.g(88);
                } else if (this.a != 344) {
                    this.a.g(87);
                }
            }
        } else if (n2 == 68 || n2 == 66) {
            for (javassist.compiler.ast.b b3 = t2; b3 != null; b3 = b3.a()) {
                javassist.compiler.ast.b b4 = b3.c();
                if (b4 == null) continue;
                b4.a(this);
            }
        } else if (n2 == 320) {
            this.d(t2);
        } else if (n2 == 346 || n2 == 311) {
            this.a(t2, n2 == 346);
        } else if (n2 == 318) {
            this.e(t2);
        } else if (n2 == 302 || n2 == 309) {
            this.b(t2, n2 == 302);
        } else if (n2 == 333) {
            this.b(t2);
        } else if (n2 == 340) {
            this.g(t2);
        } else if (n2 == 343) {
            this.c(t2);
        } else if (n2 == 337) {
            this.f(t2);
        } else if (n2 == 338) {
            this.h(t2);
        } else {
            this.a = false;
            throw new e("sorry, not supported statement: TokenId " + n2);
        }
    }

    private void d(t t2) {
        javassist.compiler.ast.b b2 = t2.c();
        t t3 = (t)((a)t2.a()).c();
        t t4 = (t)((a)((a)t2.a()).a()).c();
        if (this.a(false, b2)) {
            this.a = false;
            if (t4 != null) {
                t4.a(this);
            }
            return;
        }
        int n2 = this.a.e();
        int n3 = 0;
        this.a.j(0);
        this.a = false;
        if (t3 != null) {
            t3.a(this);
        }
        boolean bl2 = this.a;
        this.a = false;
        if (t4 != null && !bl2) {
            this.a.g(167);
            n3 = this.a.e();
            this.a.j(0);
        }
        this.a.c(n2, this.a.e() - n2 + 1);
        if (t4 != null) {
            t4.a(this);
            if (!bl2) {
                this.a.c(n3, this.a.e() - n3 + 1);
            }
            this.a = bl2 && this.a;
        }
    }

    private void a(t t2, boolean bl2) {
        boolean bl3;
        String string = this.a;
        String string2 = this.b;
        this.a = new ArrayList();
        this.b = new ArrayList();
        javassist.compiler.ast.b b2 = t2.c();
        t t3 = (t)t2.a();
        int n2 = 0;
        if (bl2) {
            this.a.g(167);
            n2 = this.a.e();
            this.a.j(0);
        }
        int n3 = this.a.e();
        if (t3 != null) {
            t3.a(this);
        }
        int n4 = this.a.e();
        if (bl2) {
            this.a.c(n2, n4 - n2 + 1);
        }
        if (bl3 = this.a(true, b2)) {
            this.a.g(167);
            bl3 = this.a.size() == 0;
        }
        this.a.j(n3 - this.a.e() + 1);
        this.a((List<Integer>)((Object)this.a), this.a.e());
        this.a((List<Integer>)((Object)this.b), n4);
        this.b = string2;
        this.a = string;
        this.a = bl3;
    }

    protected void a(List<Integer> list, int n2) {
        for (int n3 : list) {
            this.a.c(n3, n2 - n3 + 1);
        }
    }

    private void e(t t2) {
        String string = this.a;
        String string2 = this.b;
        this.a = new ArrayList();
        this.b = new ArrayList();
        t t3 = (t)t2.c();
        javassist.compiler.ast.b b2 = t2.a();
        javassist.compiler.ast.b b3 = ((a)b2).c();
        b2 = ((a)b2).a();
        t t4 = (t)((a)b2).c();
        t t5 = (t)((a)b2).a();
        if (t3 != null) {
            t3.a(this);
        }
        int n2 = this.a.e();
        int n3 = 0;
        if (b3 != null) {
            if (this.a(false, b3)) {
                this.b = string2;
                this.a = string;
                this.a = false;
                return;
            }
            n3 = this.a.e();
            this.a.j(0);
        }
        if (t5 != null) {
            t5.a(this);
        }
        int n4 = this.a.e();
        if (t4 != null) {
            t4.a(this);
        }
        this.a.g(167);
        this.a.j(n2 - this.a.e() + 1);
        int n5 = this.a.e();
        if (b3 != null) {
            this.a.c(n3, n5 - n3 + 1);
        }
        this.a((List<Integer>)((Object)this.a), n5);
        this.a((List<Integer>)((Object)this.b), n4);
        this.b = string2;
        this.a = string;
        this.a = false;
    }

    private void f(t t2) {
        int n2;
        boolean bl2 = false;
        if (this.a != null) {
            this.b(t2.c());
            bl2 = this.a.a == 307 && this.a.b == 0 && d.equals(this.a.e);
        }
        this.a(t2.c());
        int n3 = -1;
        if (bl2) {
            n3 = this.a();
            this.b(1);
            this.a.l(n3);
            this.a.k(n3);
            this.a.e(d, "hashCode", "()I");
        }
        String string = this.a;
        this.a = new ArrayList();
        int n4 = this.a.e();
        this.a.g(171);
        int n5 = 3 - (n4 & 3);
        while (n5-- > 0) {
            this.a.a(0);
        }
        t t3 = (t)t2.a();
        int n6 = 0;
        for (javassist.compiler.ast.b b2 = t3; b2 != null; b2 = b2.a()) {
            if (((t)b2.c()).b() != 304) continue;
            ++n6;
        }
        int n7 = this.a.e();
        this.a.b(4);
        this.a.f(n6);
        this.a.b(n6 * 8);
        long[] lArray = new long[n6];
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n8 = 0;
        int n9 = -1;
        for (javassist.compiler.ast.b b3 = t3; b3 != null; b3 = b3.a()) {
            t t4 = (t)b3.c();
            int n10 = t4.b();
            if (n10 == 310) {
                n9 = this.a.e();
            } else if (n10 != 304) {
                javassist.compiler.b.a();
            } else {
                int n11 = this.a.e();
                long l2 = bl2 ? (long)this.a(t4.c(), n3, arrayList) : (long)this.b(t4.c());
                lArray[n8++] = (l2 << 32) + ((long)(n11 - n4) & 0xFFFFFFFFFFFFFFFFL);
            }
            this.a = false;
            ((t)t4.a()).a(this);
        }
        Arrays.sort(lArray);
        int n12 = n7 + 8;
        for (n2 = 0; n2 < n6; ++n2) {
            this.a.d(n12, (int)(lArray[n2] >>> 32));
            this.a.d(n12 + 4, (int)lArray[n2]);
            n12 += 8;
        }
        if (n9 < 0 || this.a.size() > 0) {
            this.a = false;
        }
        n2 = this.a.e();
        if (n9 < 0) {
            n9 = n2;
        }
        this.a.d(n7, n9 - n4);
        for (int n11 : arrayList) {
            this.a.c(n11, n9 - n11 + 1);
        }
        this.a((List<Integer>)((Object)this.a), n2);
        this.a = string;
    }

    private int b(javassist.compiler.ast.b b2) {
        this.b(b2);
        b2 = A.a(b2);
        if (b2 instanceof n) {
            return (int)((n)b2).a();
        }
        throw new e("bad case label");
    }

    private int a(javassist.compiler.ast.b b2, int n2, List<Integer> list) {
        this.b(b2);
        b2 = A.a(b2);
        if (b2 instanceof u) {
            String string = ((u)b2).b();
            this.a.k(n2);
            this.a.c(string);
            this.a.e(d, "equals", "(Ljava/lang/Object;)Z");
            this.a.g(153);
            Integer n3 = this.a.e();
            this.a.j(0);
            list.add(n3);
            return string.hashCode();
        }
        throw new e("bad case label");
    }

    private void b(t t2, boolean bl2) {
        if (t2.c() != null) {
            throw new e("sorry, not support labeled break or continue");
        }
        this.a.g(167);
        Integer n2 = this.a.e();
        this.a.j(0);
        if (bl2) {
            this.a.add(n2);
        } else {
            this.b.add(n2);
        }
    }

    protected void b(t t2) {
        this.c(t2.a());
    }

    protected final void c(javassist.compiler.ast.b b2) {
        int n2;
        if (b2 == null) {
            n2 = 177;
        } else {
            int n3;
            this.a(b2);
            n2 = this.b > 0 ? 176 : ((n3 = this.a) == 312 ? 175 : (n3 == 317 ? 174 : (n3 == 326 ? 173 : (javassist.compiler.b.a(n3) ? 176 : 172))));
        }
        d d2 = this.a;
        while (d2 != null) {
            if (d2.a(this.a, n2)) {
                this.a = true;
                return;
            }
            d2 = d2.a;
        }
        this.a.g(n2);
        this.a = true;
    }

    private void g(t t2) {
        javassist.compiler.ast.b b2 = t2.a();
        this.a(b2);
        if (this.a != 307 || this.b > 0) {
            throw new e("bad throw statement");
        }
        this.a.g(191);
        this.a = true;
    }

    protected void c(t t2) {
        this.a = false;
    }

    private void h(t t2) {
        int n2 = javassist.compiler.b.a((List<Integer>)((Object)this.a));
        int n3 = javassist.compiler.b.a((List<Integer>)((Object)this.b));
        this.a(t2.c());
        if (this.a != 307 && this.b == 0) {
            throw new e("bad type expr for synchronized block");
        }
        javassist.bytecode.n n4 = this.a;
        int n5 = n4.d();
        n4.e(1);
        n4.g(89);
        n4.l(n5);
        n4.g(194);
        c c2 = new c(this, this, n5);
        int n6 = n4.e();
        t t3 = (t)t2.a();
        if (t3 != null) {
            t3.a(this);
        }
        int n7 = n4.e();
        int n8 = 0;
        if (!this.a) {
            ((d)c2).a(n4, 0);
            n4.g(167);
            n8 = n4.e();
            n4.j(0);
        }
        if (n6 < n7) {
            int n9 = n4.e();
            ((d)c2).a(n4, 0);
            n4.g(191);
            n4.b(n6, n7, n9, 0);
        }
        if (!this.a) {
            n4.c(n8, n4.e() - n8 + 1);
        }
        c2.a(this);
        if (javassist.compiler.b.a((List<Integer>)((Object)this.a)) != n2 || javassist.compiler.b.a((List<Integer>)((Object)this.b)) != n3) {
            throw new e("sorry, cannot break/continue in synchronized block");
        }
    }

    private static int a(List<Integer> list) {
        return list == null ? 0 : list.size();
    }

    private static boolean a(javassist.compiler.ast.b b2) {
        if (b2 instanceof k) {
            int n2 = ((k)b2).b();
            return n2 == 362 || n2 == 363;
        }
        return false;
    }

    @Override
    public void a(i i2) {
        i2.b(this.a());
        i2.a(this.a(i2.b()));
        int n2 = javassist.compiler.b.a(i2.b(), i2.c()) ? 2 : 1;
        this.b(n2);
        javassist.compiler.ast.b b2 = i2.d();
        if (b2 != null) {
            this.b(b2);
            this.a(null, 61, null, i2, b2, false);
        }
    }

    @Override
    public abstract void a(javassist.compiler.ast.r var1);

    @Override
    public abstract void a(javassist.compiler.ast.c var1);

    @Override
    public void a(javassist.compiler.ast.d d2) {
        this.a(d2, true);
    }

    protected void a(javassist.compiler.ast.d d2, boolean bl2) {
        int n2 = d2.b();
        javassist.compiler.ast.b b2 = d2.d();
        javassist.compiler.ast.b b3 = d2.e();
        if (b2 instanceof w) {
            this.a((k)d2, n2, (w)b2, ((w)b2).a(), b3, bl2);
        } else {
            k k2;
            if (b2 instanceof k && (k2 = (k)b2).b() == 65) {
                this.a((k)d2, n2, (k)b2, b3, bl2);
                return;
            }
            this.a((k)d2, n2, b2, b3, bl2);
        }
    }

    protected static void a(k k2) {
        String string = k2 == null ? "incompatible type for assignment" : "incompatible type for " + k2.b();
        throw new e(string);
    }

    private void a(k k2, int n2, w w2, i i2, javassist.compiler.ast.b b2, boolean bl2) {
        int n3 = i2.b();
        int n4 = i2.c();
        String string = i2.b();
        int n5 = this.a(i2);
        if (n2 != 61) {
            this.a(w2);
        }
        if (k2 == null && b2 instanceof javassist.compiler.ast.c) {
            this.a((javassist.compiler.ast.c)b2, n3, n4, string);
        } else {
            this.a(k2, n2, b2, n3, n4, string);
        }
        if (bl2) {
            if (javassist.compiler.b.a(n3, n4)) {
                this.a.g(92);
            } else {
                this.a.g(89);
            }
        }
        if (n4 > 0) {
            this.a.l(n5);
        } else if (n3 == 312) {
            this.a.s(n5);
        } else if (n3 == 317) {
            this.a.u(n5);
        } else if (n3 == 326) {
            this.a.q(n5);
        } else if (javassist.compiler.b.a(n3)) {
            this.a.l(n5);
        } else {
            this.a.o(n5);
        }
        this.a = n3;
        this.b = n4;
        this.e = string;
    }

    protected abstract void a(javassist.compiler.ast.c var1, int var2, int var3, String var4);

    private void a(k k2, int n2, k k3, javassist.compiler.ast.b b2, boolean bl2) {
        this.b(k3.d(), k3.e());
        if (n2 != 61) {
            this.a.g(92);
            this.a.g(javassist.compiler.b.a(this.a, this.b));
        }
        int n3 = this.a;
        int n4 = this.b;
        String string = this.e;
        this.a(k2, n2, b2, n3, n4, string);
        if (bl2) {
            if (javassist.compiler.b.a(n3, n4)) {
                this.a.g(94);
            } else {
                this.a.g(91);
            }
        }
        this.a.g(javassist.compiler.b.b(n3, n4));
        this.a = n3;
        this.b = n4;
        this.e = string;
    }

    protected abstract void a(k var1, int var2, javassist.compiler.ast.b var3, javassist.compiler.ast.b var4, boolean var5);

    protected void a(k k2, int n2, javassist.compiler.ast.b b2, int n3, int n4, String string) {
        if (n2 == 354 && n4 == 0 && n3 == 307) {
            this.a(k2, n3, n4, string, b2);
        } else {
            b2.a(this);
            if (this.a(this.a, this.b, this.e, n3, n4, string, false) || n2 != 61 && n4 > 0) {
                javassist.compiler.b.a(k2);
            }
            if (n2 != 61) {
                int n5 = a_[n2 - 351];
                int n6 = javassist.compiler.b.a(n5);
                if (n6 < 0) {
                    javassist.compiler.b.a();
                }
                this.a(k2, n5, n6, n3);
            }
        }
        if (n2 != 61 || n4 == 0 && !javassist.compiler.b.a(n3)) {
            this.a(this.a, n3);
        }
    }

    private void a(k k2, int n2, int n3, String string, javassist.compiler.ast.b b2) {
        if (!d.equals(string)) {
            javassist.compiler.b.a(k2);
        }
        this.b(n2, n3);
        b2.a(this);
        this.b(this.a, this.b);
        this.a.e(c, "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        this.a = 307;
        this.b = 0;
        this.e = d;
    }

    private boolean a(int n2, int n3, String string, int n4, int n5, String string2, boolean bl2) {
        if (n3 != n5) {
            if (n2 == 412) {
                return false;
            }
            if (n5 == 0 && n4 == 307 && b.equals(string2)) {
                return false;
            }
            return !bl2 || n3 != 0 || n2 != 307 || !b.equals(string);
        }
        return false;
    }

    @Override
    public void a(h h2) {
        if (this.b(false, h2.d())) {
            h2.f().a(this);
        } else {
            int n2 = this.a.e();
            this.a.j(0);
            h2.e().a(this);
            int n3 = this.b;
            this.a.g(167);
            int n4 = this.a.e();
            this.a.j(0);
            this.a.c(n2, this.a.e() - n2 + 1);
            h2.f().a(this);
            if (n3 != this.b) {
                throw new e("type mismatch in ?:");
            }
            this.a.c(n4, this.a.e() - n4 + 1);
        }
    }

    static int a(int n2) {
        int[] nArray = b;
        int n3 = nArray.length;
        for (int i2 = 0; i2 < n3; i2 += 5) {
            if (nArray[i2] != n2) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public void a(javassist.compiler.ast.e e2) {
        int n2 = e2.b();
        int n3 = javassist.compiler.b.a(n2);
        if (n3 >= 0) {
            e2.d().a(this);
            javassist.compiler.ast.b b2 = e2.e();
            if (b2 == null) {
                return;
            }
            int n4 = this.a;
            int n5 = this.b;
            String string = this.e;
            b2.a(this);
            if (n5 != this.b) {
                throw new e("incompatible array types");
            }
            if (n2 == 43 && n5 == 0 && (n4 == 307 || this.a == 307)) {
                this.a((k)e2, n4, n5, string);
            } else {
                this.a((k)e2, n2, n3, n4);
            }
        } else {
            if (!this.b(true, (javassist.compiler.ast.b)e2)) {
                this.a.j(7);
                this.a.m(0);
                this.a.g(167);
                this.a.j(4);
            }
            this.a.m(1);
        }
    }

    private void a(k k2, int n2, int n3, int n4) {
        int n5;
        if (this.b != 0) {
            javassist.compiler.b.b(k2);
        }
        int n6 = this.a;
        if (n2 == 364 || n2 == 366 || n2 == 370) {
            if (n6 == 324 || n6 == 334 || n6 == 306 || n6 == 303) {
                this.a = n4;
            } else {
                javassist.compiler.b.b(k2);
            }
        } else {
            this.a(n4, n6, k2);
        }
        int n7 = javassist.compiler.b.b(this.a);
        if (n7 >= 0 && (n5 = b[n3 + n7 + 1]) != 0) {
            if (n7 == 3 && this.a != 301) {
                this.a = 324;
            }
            this.a.g(n5);
            return;
        }
        javassist.compiler.b.b(k2);
    }

    private void a(k k2, int n2, int n3, String string) {
        boolean bl2;
        int n4 = this.a;
        int n5 = this.b;
        boolean bl3 = javassist.compiler.b.a(n4, n5);
        boolean bl4 = bl2 = n4 == 307 && d.equals(this.e);
        if (bl3) {
            this.b(n4, n5);
        }
        if (javassist.compiler.b.a(n2, n3)) {
            this.a.g(91);
            this.a.g(87);
        } else {
            this.a.g(95);
        }
        this.b(n2, n3);
        this.a.g(95);
        if (!bl3 && !bl2) {
            this.b(n4, n5);
        }
        this.a.e(c, "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        this.a = 307;
        this.b = 0;
        this.e = d;
    }

    private void b(int n2, int n3) {
        String string = "valueOf";
        if (javassist.compiler.b.a(n2) || n3 > 0) {
            this.a.d(c, "valueOf", "(Ljava/lang/Object;)Ljava/lang/String;");
        } else if (n2 == 312) {
            this.a.d(c, "valueOf", "(D)Ljava/lang/String;");
        } else if (n2 == 317) {
            this.a.d(c, "valueOf", "(F)Ljava/lang/String;");
        } else if (n2 == 326) {
            this.a.d(c, "valueOf", "(J)Ljava/lang/String;");
        } else if (n2 == 301) {
            this.a.d(c, "valueOf", "(Z)Ljava/lang/String;");
        } else if (n2 == 306) {
            this.a.d(c, "valueOf", "(C)Ljava/lang/String;");
        } else {
            if (n2 == 344) {
                throw new e("void type expression");
            }
            this.a.d(c, "valueOf", "(I)Ljava/lang/String;");
        }
    }

    private boolean b(boolean bl2, javassist.compiler.ast.b b2) {
        int n2 = javassist.compiler.b.a(b2);
        if (n2 == 358) {
            javassist.compiler.ast.e e2 = (javassist.compiler.ast.e)b2;
            int n3 = this.a(e2);
            this.a(bl2, e2.b(), n3, e2);
        } else {
            if (n2 == 33) {
                return this.b(!bl2, ((k)b2).d());
            }
            boolean bl3 = n2 == 369;
            if (bl3 || n2 == 368) {
                javassist.compiler.ast.e e3;
                if (this.b(!bl3, (e3 = (javassist.compiler.ast.e)b2).d())) {
                    this.a = 301;
                    this.b = 0;
                    return true;
                }
                int n4 = this.a.e();
                this.a.j(0);
                if (this.b(bl3, e3.e())) {
                    this.a.g(167);
                }
                this.a.c(n4, this.a.e() - n4 + 3);
                if (bl2 != bl3) {
                    this.a.j(6);
                    this.a.g(167);
                }
            } else {
                if (javassist.compiler.b.a(b2, bl2)) {
                    this.a = 301;
                    this.b = 0;
                    return true;
                }
                b2.a(this);
                if (this.a != 301 || this.b != 0) {
                    throw new e("boolean expr is required");
                }
                this.a.g(bl2 ? 154 : 153);
            }
        }
        this.a = 301;
        this.b = 0;
        return false;
    }

    private static boolean a(javassist.compiler.ast.b b2, boolean bl2) {
        if (b2 instanceof o) {
            int n2 = ((o)b2).a();
            return bl2 ? n2 == 410 : n2 == 411;
        }
        return false;
    }

    static int a(javassist.compiler.ast.b b2) {
        if (b2 instanceof k) {
            k k2 = (k)b2;
            int n2 = k2.b();
            if (n2 == 33) {
                return 33;
            }
            if (k2 instanceof javassist.compiler.ast.e && n2 != 368 && n2 != 369 && n2 != 38 && n2 != 124) {
                return 358;
            }
            return n2;
        }
        return 32;
    }

    private int a(javassist.compiler.ast.e e2) {
        e2.d().a(this);
        int n2 = this.a;
        int n3 = this.b;
        e2.e().a(this);
        if (n3 != this.b) {
            if (n2 != 412 && this.a != 412) {
                throw new e("incompatible array types");
            }
            if (this.a == 412) {
                this.b = n3;
            }
        }
        if (n2 == 412) {
            return this.a;
        }
        return n2;
    }

    private void a(boolean bl2, int n2, int n3, javassist.compiler.ast.e e2) {
        int n4;
        if (this.b == 0) {
            this.a(n3, this.a, e2);
        }
        if ((n4 = javassist.compiler.b.b(this.a)) == -1 || this.b > 0) {
            if (n2 == 358) {
                this.a.g(bl2 ? 165 : 166);
            } else if (n2 == 350) {
                this.a.g(bl2 ? 166 : 165);
            } else {
                javassist.compiler.b.b(e2);
            }
        } else if (n4 == 3) {
            int[] nArray = c;
            for (int i2 = 0; i2 < nArray.length; i2 += 3) {
                if (nArray[i2] != n2) continue;
                this.a.g(nArray[i2 + (bl2 ? 1 : 2)]);
                return;
            }
            javassist.compiler.b.b(e2);
        } else {
            if (n4 == 0) {
                if (n2 == 60 || n2 == 357) {
                    this.a.g(152);
                } else {
                    this.a.g(151);
                }
            } else if (n4 == 1) {
                if (n2 == 60 || n2 == 357) {
                    this.a.g(150);
                } else {
                    this.a.g(149);
                }
            } else if (n4 == 2) {
                this.a.g(148);
            } else {
                javassist.compiler.b.a();
            }
            int[] nArray = d;
            for (int i3 = 0; i3 < nArray.length; i3 += 3) {
                if (nArray[i3] != n2) continue;
                this.a.g(nArray[i3 + (bl2 ? 1 : 2)]);
                return;
            }
            javassist.compiler.b.b(e2);
        }
    }

    protected static void b(k k2) {
        throw new e("invalid types for " + k2.b());
    }

    protected static boolean a(int n2) {
        return n2 == 307 || n2 == 412;
    }

    private static int b(int n2) {
        if (n2 == 312) {
            return 0;
        }
        if (n2 == 317) {
            return 1;
        }
        if (n2 == 326) {
            return 2;
        }
        if (javassist.compiler.b.a(n2)) {
            return -1;
        }
        if (n2 == 344) {
            return -1;
        }
        return 3;
    }

    static boolean b(int n2) {
        return javassist.compiler.b.b(n2) == 3;
    }

    static boolean b(int n2, int n3) {
        int n4 = javassist.compiler.b.b(n2);
        int n5 = javassist.compiler.b.b(n3);
        return n4 >= 0 && n5 >= 0 && n4 > n5;
    }

    private void a(int n2, int n3, k k2) {
        int n4;
        int n5;
        boolean bl2;
        int n6 = javassist.compiler.b.b(n2);
        int n7 = javassist.compiler.b.b(n3);
        if (n7 < 0 && n6 < 0) {
            return;
        }
        if (n7 < 0 || n6 < 0) {
            javassist.compiler.b.b(k2);
        }
        if (n6 <= n7) {
            bl2 = false;
            this.a = n2;
            n5 = e[n7 * 4 + n6];
            n4 = n6;
        } else {
            bl2 = true;
            n5 = e[n6 * 4 + n7];
            n4 = n7;
        }
        if (bl2) {
            if (n4 == 0 || n4 == 2) {
                if (n6 == 0 || n6 == 2) {
                    this.a.g(94);
                } else {
                    this.a.g(93);
                }
                this.a.g(88);
                this.a.g(n5);
                this.a.g(94);
                this.a.g(88);
            } else if (n4 == 1) {
                if (n6 == 2) {
                    this.a.g(91);
                    this.a.g(87);
                } else {
                    this.a.g(95);
                }
                this.a.g(n5);
                this.a.g(95);
            } else {
                javassist.compiler.b.a();
            }
        } else if (n5 != 0) {
            this.a.g(n5);
        }
    }

    @Override
    public void a(g g2) {
        String string = this.a(g2.b());
        String string2 = this.a(g2, string);
        int n2 = this.a;
        this.a = g2.b();
        this.b = g2.c();
        this.e = string;
        if (string2 == null) {
            this.a(n2, this.a);
        } else {
            this.a.a(string2);
        }
    }

    @Override
    public void a(m m2) {
        String string = this.a(m2.b());
        String string2 = this.a(m2, string);
        this.a.b(string2);
        this.a = 301;
        this.b = 0;
    }

    private String a(g g2, String string) {
        String string2 = "invalid cast";
        javassist.compiler.ast.b b2 = g2.d();
        int n2 = g2.c();
        int n3 = g2.b();
        b2.a(this);
        int n4 = this.a;
        int n5 = this.b;
        if (this.a(n4, this.b, this.e, n3, n2, string, true) || n4 == 344 || n3 == 344) {
            throw new e("invalid cast");
        }
        if (n3 == 307) {
            if (!javassist.compiler.b.a(n4) && n5 == 0) {
                throw new e("invalid cast");
            }
            return javassist.compiler.b.a(string, n2);
        }
        if (n2 > 0) {
            return javassist.compiler.b.a(n3, n2);
        }
        return null;
    }

    void a(int n2, int n3) {
        if (n2 == n3) {
            return;
        }
        int n4 = javassist.compiler.b.b(n2);
        int n5 = javassist.compiler.b.b(n3);
        int n6 = 0 <= n4 && n4 < 3 ? e[n4 * 4 + n5] : 0;
        int n7 = n3 == 312 ? 135 : (n3 == 317 ? 134 : (n3 == 326 ? 133 : (n3 == 334 ? 147 : (n3 == 306 ? 146 : (n3 == 303 ? 145 : 0)))));
        if (n6 != 0) {
            this.a.g(n6);
        }
        if ((n6 == 0 || n6 == 136 || n6 == 139 || n6 == 142) && n7 != 0) {
            this.a.g(n7);
        }
    }

    @Override
    public void c(k k2) {
        int n2 = k2.b();
        javassist.compiler.ast.b b2 = k2.d();
        if (n2 == 46) {
            String string = ((v)k2.e()).b();
            if (string.equals("class")) {
                this.e(k2);
            } else {
                this.d(k2);
            }
        } else if (n2 == 35) {
            this.d(k2);
        } else if (n2 == 65) {
            this.a(b2, k2.e());
        } else if (n2 == 362 || n2 == 363) {
            this.a(n2, b2, k2, true);
        } else if (n2 == 33) {
            if (!this.b(false, (javassist.compiler.ast.b)k2)) {
                this.a.j(7);
                this.a.m(1);
                this.a.g(167);
                this.a.j(4);
            }
            this.a.m(0);
        } else if (n2 == 67) {
            javassist.compiler.b.a();
        } else {
            k2.d().a(this);
            int n3 = javassist.compiler.b.b(this.a);
            if (this.b > 0) {
                javassist.compiler.b.d(k2);
            }
            if (n2 == 45) {
                if (n3 == 0) {
                    this.a.g(119);
                } else if (n3 == 1) {
                    this.a.g(118);
                } else if (n3 == 2) {
                    this.a.g(117);
                } else if (n3 == 3) {
                    this.a.g(116);
                    this.a = 324;
                } else {
                    javassist.compiler.b.d(k2);
                }
            } else if (n2 == 126) {
                if (n3 == 3) {
                    this.a.m(-1);
                    this.a.g(130);
                    this.a = 324;
                } else if (n3 == 2) {
                    this.a.a(-1L);
                    this.a.g(131);
                } else {
                    javassist.compiler.b.d(k2);
                }
            } else if (n2 == 43) {
                if (n3 == -1) {
                    javassist.compiler.b.d(k2);
                }
            } else {
                javassist.compiler.b.a();
            }
        }
    }

    protected static void d(k k2) {
        throw new e("invalid type for " + k2.b());
    }

    @Override
    public abstract void a(f var1);

    protected abstract void d(javassist.compiler.ast.b var1);

    public void e(k k2) {
        javassist.compiler.ast.b b2 = k2.d();
        if (!(b2 instanceof v)) {
            throw new e("fatal error: badly parsed .class expr");
        }
        String string = ((v)b2).b();
        if (string.startsWith("[")) {
            String string2;
            String string3;
            int n2 = string.indexOf("[L");
            if (n2 >= 0 && !(string3 = string.substring(n2 + 2, string.length() - 1)).equals(string2 = this.a(string3))) {
                string2 = r.c(string2);
                StringBuffer stringBuffer = new StringBuffer();
                while (n2-- >= 0) {
                    stringBuffer.append('[');
                }
                stringBuffer.append('L').append(string2).append(';');
                string = stringBuffer.toString();
            }
        } else {
            string = this.a(r.b(string));
            string = r.c(string);
        }
        this.a(string);
        this.a = 307;
        this.b = 0;
        this.e = "java/lang/Class";
    }

    protected void a(String string) {
        int n2 = this.a.e();
        this.a.c(string);
        this.a.d("java.lang.Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        int n3 = this.a.e();
        this.a.g(167);
        int n4 = this.a.e();
        this.a.j(0);
        this.a.a(n2, n3, this.a.e(), "java.lang.ClassNotFoundException");
        this.a.h(1);
        this.a.d("javassist.runtime.DotClass", "fail", "(Ljava/lang/ClassNotFoundException;)Ljava/lang/NoClassDefFoundError;");
        this.a.g(191);
        this.a.c(n4, this.a.e() - n4 + 1);
    }

    public void a(javassist.compiler.ast.b b2, javassist.compiler.ast.b b3) {
        this.b(b2, b3);
        this.a.g(javassist.compiler.b.a(this.a, this.b));
    }

    protected void b(javassist.compiler.ast.b b2, javassist.compiler.ast.b b3) {
        b2.a(this);
        int n2 = this.a;
        int n3 = this.b;
        if (n3 == 0) {
            throw new e("bad array access");
        }
        String string = this.e;
        b3.a(this);
        if (javassist.compiler.b.b(this.a) != 3 || this.b > 0) {
            throw new e("bad array index");
        }
        this.a = n2;
        this.b = n3 - 1;
        this.e = string;
    }

    protected static int a(int n2, int n3) {
        if (n3 > 0) {
            return 50;
        }
        switch (n2) {
            case 312: {
                return 49;
            }
            case 317: {
                return 48;
            }
            case 326: {
                return 47;
            }
            case 324: {
                return 46;
            }
            case 334: {
                return 53;
            }
            case 306: {
                return 52;
            }
            case 301: 
            case 303: {
                return 51;
            }
        }
        return 50;
    }

    protected static int b(int n2, int n3) {
        if (n3 > 0) {
            return 83;
        }
        switch (n2) {
            case 312: {
                return 82;
            }
            case 317: {
                return 81;
            }
            case 326: {
                return 80;
            }
            case 324: {
                return 79;
            }
            case 334: {
                return 86;
            }
            case 306: {
                return 85;
            }
            case 301: 
            case 303: {
                return 84;
            }
        }
        return 83;
    }

    private void a(int n2, javassist.compiler.ast.b b2, k k2, boolean bl2) {
        boolean bl3;
        boolean bl4 = bl3 = b2 == null;
        if (bl3) {
            b2 = k2.e();
        }
        if (b2 instanceof w) {
            i i2 = ((w)b2).a();
            int n3 = this.a = i2.b();
            this.b = i2.c();
            int n4 = this.a(i2);
            if (this.b > 0) {
                javassist.compiler.b.d(k2);
            }
            if (n3 == 312) {
                this.a.r(n4);
                if (bl2 && bl3) {
                    this.a.g(92);
                }
                this.a.a(1.0);
                this.a.g(n2 == 362 ? 99 : 103);
                if (bl2 && !bl3) {
                    this.a.g(92);
                }
                this.a.s(n4);
            } else if (n3 == 326) {
                this.a.p(n4);
                if (bl2 && bl3) {
                    this.a.g(92);
                }
                this.a.a(1L);
                this.a.g(n2 == 362 ? 97 : 101);
                if (bl2 && !bl3) {
                    this.a.g(92);
                }
                this.a.q(n4);
            } else if (n3 == 317) {
                this.a.t(n4);
                if (bl2 && bl3) {
                    this.a.g(89);
                }
                this.a.a(1.0f);
                this.a.g(n2 == 362 ? 98 : 102);
                if (bl2 && !bl3) {
                    this.a.g(89);
                }
                this.a.u(n4);
            } else if (n3 == 303 || n3 == 306 || n3 == 334 || n3 == 324) {
                int n5;
                if (bl2 && bl3) {
                    this.a.n(n4);
                }
                int n6 = n5 = n2 == 362 ? 1 : -1;
                if (n4 > 255) {
                    this.a.g(196);
                    this.a.g(132);
                    this.a.j(n4);
                    this.a.j(n5);
                } else {
                    this.a.g(132);
                    this.a.a(n4);
                    this.a.a(n5);
                }
                if (bl2 && !bl3) {
                    this.a.n(n4);
                }
            } else {
                javassist.compiler.b.d(k2);
            }
        } else {
            k k3;
            if (b2 instanceof k && (k3 = (k)b2).b() == 65) {
                this.a(n2, bl3, k3, bl2);
                return;
            }
            this.a(n2, bl3, b2, k2, bl2);
        }
    }

    public void a(int n2, boolean bl2, k k2, boolean bl3) {
        this.b(k2.d(), k2.e());
        int n3 = this.a;
        int n4 = this.b;
        if (n4 > 0) {
            javassist.compiler.b.d(k2);
        }
        this.a.g(92);
        this.a.g(javassist.compiler.b.a(n3, this.b));
        int n5 = javassist.compiler.b.a(n3, n4) ? 94 : 91;
        this.a(n5, bl3, n2, bl2, k2);
        this.a.g(javassist.compiler.b.b(n3, n4));
    }

    protected void a(int n2, boolean bl2, int n3, boolean bl3, k k2) {
        int n4 = this.a;
        if (bl2 && bl3) {
            this.a.g(n2);
        }
        if (n4 == 324 || n4 == 303 || n4 == 306 || n4 == 334) {
            this.a.m(1);
            this.a.g(n3 == 362 ? 96 : 100);
            this.a = 324;
        } else if (n4 == 326) {
            this.a.a(1L);
            this.a.g(n3 == 362 ? 97 : 101);
        } else if (n4 == 317) {
            this.a.a(1.0f);
            this.a.g(n3 == 362 ? 98 : 102);
        } else if (n4 == 312) {
            this.a.a(1.0);
            this.a.g(n3 == 362 ? 99 : 103);
        } else {
            javassist.compiler.b.d(k2);
        }
        if (bl2 && !bl3) {
            this.a.g(n2);
        }
    }

    protected abstract void a(int var1, boolean var2, javassist.compiler.ast.b var3, k var4, boolean var5);

    @Override
    public abstract void a(p var1);

    @Override
    public void a(w w2) {
        i i2 = w2.a();
        this.a = i2.b();
        this.b = i2.c();
        this.e = i2.b();
        int n2 = this.a(i2);
        if (this.b > 0) {
            this.a.k(n2);
        } else {
            switch (this.a) {
                case 307: {
                    this.a.k(n2);
                    break;
                }
                case 326: {
                    this.a.p(n2);
                    break;
                }
                case 317: {
                    this.a.t(n2);
                    break;
                }
                case 312: {
                    this.a.r(n2);
                    break;
                }
                default: {
                    this.a.n(n2);
                }
            }
        }
    }

    @Override
    public void a(o o2) {
        this.b = 0;
        int n2 = o2.a();
        switch (n2) {
            case 410: {
                this.a.m(1);
                this.a = 301;
                break;
            }
            case 411: {
                this.a.m(0);
                this.a = 301;
                break;
            }
            case 412: {
                this.a.g(1);
                this.a = 412;
                break;
            }
            case 336: 
            case 339: {
                if (this.b) {
                    throw new e("not-available: " + (n2 == 339 ? "this" : "super"));
                }
                this.a.k(0);
                this.a = 307;
                if (n2 == 339) {
                    this.e = this.a();
                    break;
                }
                this.e = this.b();
                break;
            }
            default: {
                javassist.compiler.b.a();
            }
        }
    }

    @Override
    public void a(u u2) {
        this.a = 307;
        this.b = 0;
        this.e = d;
        this.a.c(u2.b());
    }

    @Override
    public void a(n n2) {
        this.b = 0;
        long l2 = n2.a();
        int n3 = n2.a();
        if (n3 == 402 || n3 == 401) {
            this.a = n3 == 402 ? 324 : 306;
            this.a.m((int)l2);
        } else {
            this.a = 326;
            this.a.a(l2);
        }
    }

    @Override
    public void a(j j2) {
        this.b = 0;
        if (j2.a() == 405) {
            this.a = 312;
            this.a.a(j2.a());
        } else {
            this.a = 317;
            this.a.a((float)j2.a());
        }
    }
}

