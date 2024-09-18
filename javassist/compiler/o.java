/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import java.util.ArrayList;
import java.util.List;
import javassist.CtClass;
import javassist.I;
import javassist.Z;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.W;
import javassist.bytecode.al;
import javassist.bytecode.n;
import javassist.compiler.A;
import javassist.compiler.ast.a;
import javassist.compiler.ast.c;
import javassist.compiler.ast.i;
import javassist.compiler.ast.k;
import javassist.compiler.ast.v;
import javassist.compiler.b;
import javassist.compiler.e;
import javassist.compiler.p;
import javassist.compiler.q;
import javassist.compiler.r;
import javassist.compiler.s;
import javassist.compiler.t;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class o
extends b {
    protected r a;
    protected CtClass b;
    protected al a;
    protected boolean c;

    public o(n n2, CtClass ctClass, f f2) {
        super(n2);
        this.a = new r(f2);
        this.b = ctClass;
        this.a = null;
    }

    public int c() {
        javassist.bytecode.o o2 = this.b.b();
        if (o2 == null) {
            return javassist.bytecode.o.q;
        }
        return o2.d();
    }

    public void a(I i2) {
        this.a = i2.b();
        if (this.a != null) {
            ((A)((Object)this.a)).a(this.a);
        }
    }

    public CtClass a() {
        return this.b;
    }

    @Override
    protected String a() {
        return r.b(this.b.a());
    }

    @Override
    protected String b() {
        return r.b(r.a(this.b).a());
    }

    @Override
    protected void b() {
        ((n)((Object)this.a)).k(0);
        ((n)((Object)this.a)).c(r.a(this.b), "<init>", "()V");
    }

    @Override
    protected void c(javassist.compiler.ast.t t2) {
        boolean bl2;
        r r2 = this.a;
        javassist.compiler.ast.t t3 = (javassist.compiler.ast.t)t2.a();
        if (t3 == null) {
            return;
        }
        javassist.compiler.ast.b b2 = (a)t2.b().a();
        javassist.compiler.ast.t t4 = (javassist.compiler.ast.t)t2.b().b().a();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        p p2 = null;
        if (t4 != null) {
            p2 = new p(this);
        }
        int n2 = ((n)((Object)r2)).e();
        t3.a(this);
        int n3 = ((n)((Object)r2)).e();
        if (n2 == n3) {
            throw new e("empty try block");
        }
        boolean bl3 = bl2 = this.a == false;
        if (bl2) {
            ((n)((Object)r2)).g(167);
            arrayList.add(((n)((Object)r2)).e());
            ((n)((Object)r2)).j(0);
        }
        int n4 = this.a();
        this.b(1);
        while (b2 != null) {
            javassist.compiler.ast.s s2 = (javassist.compiler.ast.s)b2.c();
            b2 = b2.a();
            i i2 = (i)s2.a();
            javassist.compiler.ast.t t5 = (javassist.compiler.ast.t)s2.b();
            i2.b(n4);
            CtClass ctClass = this.a.a(i2.b());
            i2.a(r.b(ctClass.a()));
            ((n)((Object)r2)).a(n2, n3, ((n)((Object)r2)).e(), ctClass);
            ((n)((Object)r2)).h(1);
            ((n)((Object)r2)).l(n4);
            this.a = (r)false;
            if (t5 != null) {
                t5.a(this);
            }
            if (this.a != false) continue;
            ((n)((Object)r2)).g(167);
            arrayList.add(((n)((Object)r2)).e());
            ((n)((Object)r2)).j(0);
            bl2 = true;
        }
        if (t4 != null) {
            p2.a(this);
            int n5 = ((n)((Object)r2)).e();
            ((n)((Object)r2)).b(n2, n5, n5, 0);
            ((n)((Object)r2)).h(1);
            ((n)((Object)r2)).l(n4);
            this.a = (r)false;
            t4.a(this);
            if (this.a == false) {
                ((n)((Object)r2)).k(n4);
                ((n)((Object)r2)).g(191);
            }
            this.a(p2.a, t4);
        }
        int n6 = ((n)((Object)r2)).e();
        this.a(arrayList, n6);
        this.a = (r)(!bl2 ? 1 : 0);
        if (t4 != null && bl2) {
            t4.a(this);
        }
    }

    private void a(List<int[]> list, javassist.compiler.ast.t t2) {
        r r2 = this.a;
        for (int[] nArray : list) {
            int n2 = nArray[0];
            ((n)((Object)r2)).c(n2, ((n)((Object)r2)).e() - n2 + 1);
            q q2 = new q(this, nArray);
            t2.a(this);
            q2.a(this);
            if (this.a != false) continue;
            ((n)((Object)r2)).g(167);
            ((n)((Object)r2)).j(n2 + 3 - ((n)((Object)r2)).e());
        }
    }

    @Override
    public void a(javassist.compiler.ast.r r2) {
        if (r2.a()) {
            this.b(r2);
        } else {
            CtClass ctClass = this.a.a(r2.b());
            String string = ctClass.a();
            a a2 = r2.c();
            ((n)((Object)this.a)).d(string);
            ((n)((Object)this.a)).g(89);
            this.a(ctClass, "<init>", a2, false, true, -1, null);
            this.a = (r)307;
            this.b = (CtClass)false;
            this.e = r.b(string);
        }
    }

    public void b(javassist.compiler.ast.r r2) {
        int n2 = r2.b();
        a a2 = r2.d();
        a a3 = r2.b();
        c c2 = r2.a();
        if (a2.a() > 1) {
            if (c2 != null) {
                throw new e("sorry, multi-dimensional array initializer for new is not supported");
            }
            this.a(n2, a3, a2);
            return;
        }
        javassist.compiler.ast.b b2 = a2.c();
        this.a(n2, b2, i.a(a3, '/'), c2);
    }

    private void a(int n2, javassist.compiler.ast.b b2, String string, c c2) {
        int n3;
        String string2;
        if (c2 == null) {
            if (b2 == null) {
                throw new e("no array size");
            }
            b2.a(this);
        } else if (b2 == null) {
            int n4 = c2.b();
            ((n)((Object)this.a)).m(n4);
        } else {
            throw new e("unnecessary array size specified for new");
        }
        if (n2 == 307) {
            string2 = this.a(string);
            ((n)((Object)this.a)).e(r.c(string2));
        } else {
            string2 = null;
            n3 = 0;
            switch (n2) {
                case 301: {
                    n3 = 4;
                    break;
                }
                case 306: {
                    n3 = 5;
                    break;
                }
                case 317: {
                    n3 = 6;
                    break;
                }
                case 312: {
                    n3 = 7;
                    break;
                }
                case 303: {
                    n3 = 8;
                    break;
                }
                case 334: {
                    n3 = 9;
                    break;
                }
                case 324: {
                    n3 = 10;
                    break;
                }
                case 326: {
                    n3 = 11;
                    break;
                }
                default: {
                    o.c();
                }
            }
            ((n)((Object)this.a)).g(188);
            ((n)((Object)this.a)).a(n3);
        }
        if (c2 != null) {
            n3 = c2.b();
            javassist.compiler.ast.b b3 = c2;
            for (int i2 = 0; i2 < n3; ++i2) {
                ((n)((Object)this.a)).g(89);
                ((n)((Object)this.a)).m(i2);
                b3.c().a(this);
                if (!o.a(n2)) {
                    this.a((int)this.a, n2);
                }
                ((n)((Object)this.a)).g(o.b(n2, 0));
                b3 = b3.a();
            }
        }
        this.a = (r)n2;
        this.b = (CtClass)true;
        this.e = string2;
    }

    private static void c() {
        throw new e("bad new expression");
    }

    @Override
    protected void a(c c2, int n2, int n3, String string) {
        this.a(n2, null, string, c2);
    }

    @Override
    public void a(c c2) {
        throw new e("array initializer is not supported");
    }

    protected void a(int n2, a a2, a b2) {
        Object object;
        int n3 = b2.a();
        int n4 = 0;
        while (b2 != null && (object = b2.c()) != null) {
            ++n4;
            ((javassist.compiler.ast.b)object).a(this);
            if (this.a != 324) {
                throw new e("bad type for array size");
            }
            b2 = b2.a();
        }
        this.a = (r)n2;
        this.b = (CtClass)n3;
        if (n2 == 307) {
            this.e = this.a(a2);
            object = o.a(this.e, n3);
        } else {
            object = o.a(n2, n3);
        }
        ((n)((Object)this.a)).a((String)object, n4);
    }

    @Override
    public void a(javassist.compiler.ast.f f2) {
        String string = null;
        CtClass ctClass = null;
        javassist.compiler.ast.b b2 = f2.d();
        a a2 = (a)f2.e();
        boolean bl2 = false;
        boolean bl3 = false;
        int n2 = -1;
        s s2 = f2.a();
        if (b2 instanceof javassist.compiler.ast.p) {
            string = ((javassist.compiler.ast.p)b2).b();
            ctClass = this.b;
            if (this.b != false || s2 != null && s2.a()) {
                bl2 = true;
            } else {
                n2 = ((n)((Object)this.a)).e();
                ((n)((Object)this.a)).k(0);
            }
        } else if (b2 instanceof javassist.compiler.ast.o) {
            bl3 = true;
            string = "<init>";
            ctClass = this.b;
            if (this.b != false) {
                throw new e("a constructor cannot be static");
            }
            ((n)((Object)this.a)).k(0);
            if (((javassist.compiler.ast.o)b2).a() == 336) {
                ctClass = r.a(ctClass);
            }
        } else if (b2 instanceof k) {
            k k2 = (k)b2;
            string = ((v)k2.e()).b();
            int n3 = k2.b();
            if (n3 == 35) {
                ctClass = this.a.a(((v)k2.d()).b(), false);
                bl2 = true;
            } else if (n3 == 46) {
                javassist.compiler.ast.b b3 = k2.d();
                String string2 = A.a(b3);
                if (string2 != null) {
                    bl3 = true;
                    ctClass = r.a(this.b, string2);
                    if (this.b != false || s2 != null && s2.a()) {
                        bl2 = true;
                    } else {
                        n2 = ((n)((Object)this.a)).e();
                        ((n)((Object)this.a)).k(0);
                    }
                } else {
                    if (b3 instanceof javassist.compiler.ast.o && ((javassist.compiler.ast.o)b3).a() == 336) {
                        bl3 = true;
                    }
                    try {
                        b3.a(this);
                    } catch (t t2) {
                        if (t2.a() != b3) {
                            throw t2;
                        }
                        this.a = (r)307;
                        this.b = (CtClass)false;
                        this.e = t2.a();
                        bl2 = true;
                    }
                    if (this.b > 0) {
                        ctClass = this.a.a("java.lang.Object", true);
                    } else if (this.a == 307) {
                        ctClass = this.a.a(this.e);
                    } else {
                        o.d();
                    }
                }
            } else {
                o.d();
            }
        } else {
            o.a();
        }
        this.a(ctClass, string, a2, bl2, bl3, n2, s2);
    }

    private static void d() {
        throw new e("bad method");
    }

    public void a(CtClass ctClass, String string, a a2, boolean bl2, boolean bl3, int n2, s s2) {
        int n3 = this.a(a2);
        int[] nArray = new int[n3];
        int[] nArray2 = new int[n3];
        String[] stringArray = new String[n3];
        if (!bl2 && s2 != null && s2.a()) {
            ((n)((Object)this.a)).g(87);
            bl2 = true;
        }
        int n4 = ((n)((Object)this.a)).f();
        this.a(a2, nArray, nArray2, stringArray);
        if (s2 == null) {
            s2 = this.a.a(ctClass, this.b, this.a, string, nArray, nArray2, stringArray);
        }
        if (s2 == null) {
            String string2 = string.equals("<init>") ? "constructor not found" : "Method " + string + " not found in " + ctClass.a();
            throw new e(string2);
        }
        this.a(ctClass, string, bl2, bl3, n2, s2);
    }

    private boolean a(CtClass ctClass, CtClass ctClass2) {
        try {
            while (ctClass != null) {
                if (this.b(ctClass, ctClass2)) {
                    return true;
                }
                ctClass = ctClass.c();
            }
        } catch (aa aa2) {
            // empty catch block
        }
        return false;
    }

    private void a(CtClass ctClass, String string, boolean bl2, boolean bl3, int n2, s s2) {
        CtClass ctClass2 = s2.a;
        al al2 = s2.a;
        String string2 = al2.b();
        int n3 = al2.a();
        if (string.equals("<init>")) {
            bl3 = true;
            if (ctClass2 != ctClass) {
                throw new e("no such constructor: " + ctClass.a());
            }
            if (ctClass2 != this.b && javassist.bytecode.a.c(n3) && (ctClass2.a().d() < 55 || !this.a(ctClass2, this.b))) {
                string2 = this.a(string2, ctClass2, al2);
                ((n)((Object)this.a)).g(1);
            }
        } else if (javassist.bytecode.a.c(n3)) {
            if (ctClass2 == this.b) {
                bl3 = true;
            } else {
                bl3 = false;
                bl2 = true;
                String string3 = string2;
                if ((n3 & 8) == 0) {
                    string2 = M.b(ctClass2.a(), string3);
                }
                n3 = javassist.bytecode.a.d(n3) | 8;
                string = this.a(string, string3, string2, al2, ctClass2);
            }
        }
        boolean bl4 = false;
        if ((n3 & 8) != 0) {
            if (!bl2) {
                bl2 = true;
                if (n2 >= 0) {
                    ((n)((Object)this.a)).a(n2, 0);
                } else {
                    bl4 = true;
                }
            }
            ((n)((Object)this.a)).d(ctClass2, string, string2);
        } else if (bl3) {
            ((n)((Object)this.a)).c(ctClass, string, string2);
        } else {
            if (!Z.a(ctClass2.a()) || ctClass2.f() != ctClass.f()) {
                ctClass2 = ctClass;
            }
            if (ctClass2.f()) {
                int n4 = M.d(string2) + 1;
                ((n)((Object)this.a)).a(ctClass2, string, string2, n4);
            } else {
                if (bl2) {
                    throw new e(string + " is not static");
                }
                ((n)((Object)this.a)).e(ctClass2, string, string2);
            }
        }
        this.a(string2, bl2, bl4);
    }

    protected String a(String string, String string2, String string3, al al2, CtClass ctClass) {
        javassist.compiler.a a2;
        if (this.b(ctClass, this.b) && (a2 = ctClass.a()) != null) {
            return a2.a(string, string2, string3, al2);
        }
        throw new e("Method " + string + " is private");
    }

    protected String a(String string, CtClass ctClass, al al2) {
        javassist.compiler.a a2;
        if (this.b(ctClass, this.b) && (a2 = ctClass.a()) != null) {
            return a2.a(ctClass, string, al2);
        }
        throw new e("the called constructor is private in " + ctClass.a());
    }

    private boolean b(CtClass ctClass, CtClass ctClass2) {
        try {
            while (ctClass2 != null) {
                if ((ctClass2 = ctClass2.c()) != ctClass) continue;
                return true;
            }
        } catch (aa aa2) {
            // empty catch block
        }
        return false;
    }

    public int a(a a2) {
        return javassist.compiler.ast.a.a(a2);
    }

    public void a(a b2, int[] nArray, int[] nArray2, String[] stringArray) {
        int n2 = 0;
        while (b2 != null) {
            javassist.compiler.ast.b b3 = b2.c();
            b3.a(this);
            nArray[n2] = (int)this.a;
            nArray2[n2] = (int)this.b;
            stringArray[n2] = this.e;
            ++n2;
            b2 = b2.a();
        }
    }

    void a(String string, boolean bl2, boolean bl3) {
        Object object;
        int n2 = string.indexOf(41);
        if (n2 < 0) {
            o.d();
        }
        char c2 = string.charAt(++n2);
        int n3 = 0;
        while (c2 == '[') {
            ++n3;
            c2 = string.charAt(++n2);
        }
        this.b = (CtClass)n3;
        if (c2 == 'L') {
            object = string.indexOf(59, n2 + 1);
            if (object < 0) {
                o.d();
            }
            this.a = (r)307;
            this.e = string.substring(n2 + 1, (int)object);
        } else {
            this.a = (r)r.a(c2);
            this.e = null;
        }
        object = this.a;
        if (bl2 && bl3) {
            if (o.a(object, n3)) {
                ((n)((Object)this.a)).g(93);
                ((n)((Object)this.a)).g(88);
                ((n)((Object)this.a)).g(87);
            } else if (object == 344) {
                ((n)((Object)this.a)).g(87);
            } else {
                ((n)((Object)this.a)).g(95);
                ((n)((Object)this.a)).g(87);
            }
        }
    }

    @Override
    protected void a(k k2, int n2, javassist.compiler.ast.b b2, javassist.compiler.ast.b b3, boolean bl2) {
        int n3;
        javassist.r r2 = this.a(b2, false);
        boolean bl3 = this.c;
        if (n2 != 61 && !bl3) {
            ((n)((Object)this.a)).g(89);
        }
        if (n2 == 61) {
            W w2 = r2.b();
            this.a(w2);
            javassist.compiler.a a2 = this.a(r2, w2);
            n3 = a2 == null ? this.a(r2, w2) : 0;
        } else {
            n3 = this.a(r2, bl3);
        }
        r r3 = this.a;
        CtClass ctClass = this.b;
        String string = this.e;
        this.a(k2, n2, b3, (int)r3, (int)ctClass, string);
        boolean bl4 = o.a((int)r3, (int)ctClass);
        if (bl2) {
            int n4 = bl3 ? (bl4 ? 92 : 89) : (bl4 ? 93 : 90);
            ((n)((Object)this.a)).g(n4);
        }
        this.a(r2, bl3, n3, bl4);
        this.a = r3;
        this.b = ctClass;
        this.e = string;
    }

    private void a(javassist.r r2, boolean bl2, int n2, boolean bl3) {
        if (n2 != 0) {
            if (bl2) {
                ((n)((Object)this.a)).a(179);
                ((n)((Object)this.a)).h(bl3 ? -2 : -1);
            } else {
                ((n)((Object)this.a)).a(181);
                ((n)((Object)this.a)).h(bl3 ? -3 : -2);
            }
            ((n)((Object)this.a)).j(n2);
        } else {
            CtClass ctClass = r2.a();
            javassist.compiler.a a2 = ctClass.a();
            W w2 = r2.b();
            al al2 = a2.b(w2, bl2);
            ((n)((Object)this.a)).d(ctClass, al2.a(), al2.b());
        }
    }

    @Override
    public void a(javassist.compiler.ast.p p2) {
        this.d(p2);
    }

    @Override
    protected void d(javassist.compiler.ast.b b2) {
        javassist.r r2 = this.a(b2, true);
        if (r2 == null) {
            this.e(b2);
            return;
        }
        boolean bl2 = this.c;
        javassist.compiler.ast.b b3 = A.a(r2);
        if (b3 == null) {
            this.a(r2, bl2);
        } else {
            b3.a(this);
            this.a(r2.b());
        }
    }

    private void e(javassist.compiler.ast.b b2) {
        if (this.b == false) {
            throw new e(".length applied to a non array");
        }
        ((n)((Object)this.a)).g(190);
        this.a = (r)324;
        this.b = (CtClass)false;
    }

    private int a(javassist.r r2, boolean bl2) {
        W w2 = r2.b();
        boolean bl3 = this.a(w2);
        javassist.compiler.a a2 = this.a(r2, w2);
        if (a2 != null) {
            al al2 = a2.a(w2, bl2);
            ((n)((Object)this.a)).d(r2.a(), al2.a(), al2.b());
            return 0;
        }
        int n2 = this.a(r2, w2);
        if (bl2) {
            ((n)((Object)this.a)).a(178);
            ((n)((Object)this.a)).h(bl3 ? 2 : 1);
        } else {
            ((n)((Object)this.a)).a(180);
            ((n)((Object)this.a)).h(bl3 ? 1 : 0);
        }
        ((n)((Object)this.a)).j(n2);
        return n2;
    }

    private javassist.compiler.a a(javassist.r r2, W w2) {
        if (javassist.bytecode.a.c(w2.a()) && r2.a() != this.b) {
            javassist.compiler.a a2;
            CtClass ctClass = r2.a();
            if (this.b(ctClass, this.b) && (a2 = ctClass.a()) != null) {
                return a2;
            }
            throw new e("Field " + r2.d() + " in " + ctClass.a() + " is private.");
        }
        return null;
    }

    private boolean a(W w2) {
        String string = w2.b();
        int n2 = 0;
        int n3 = 0;
        char c2 = string.charAt(n2);
        while (c2 == '[') {
            ++n3;
            c2 = string.charAt(++n2);
        }
        this.b = (CtClass)n3;
        this.a = (r)r.a(c2);
        this.e = c2 == 'L' ? string.substring(n2 + 1, string.indexOf(59, n2 + 1)) : null;
        boolean bl2 = n3 == 0 && (c2 == 'J' || c2 == 'D');
        return bl2;
    }

    private int a(javassist.r r2, W w2) {
        J j2 = ((n)((Object)this.a)).a();
        String string = r2.a().a();
        int n2 = j2.a(string);
        String string2 = w2.a();
        String string3 = w2.b();
        return j2.a(n2, string2, string3);
    }

    @Override
    protected void a(String string) {
        if (this.c() < 49) {
            super.a(string);
        } else {
            ((n)((Object)this.a)).v(((n)((Object)this.a)).a().a(string));
        }
    }

    @Override
    protected void a(int n2, boolean bl2, javassist.compiler.ast.b b2, k k2, boolean bl3) {
        javassist.r r2 = this.a(b2, false);
        boolean bl4 = this.c;
        if (!bl4) {
            ((n)((Object)this.a)).g(89);
        }
        int n3 = this.a(r2, bl4);
        r r3 = this.a;
        boolean bl5 = o.a((int)r3, (int)this.b);
        int n4 = bl4 ? (bl5 ? 92 : 89) : (bl5 ? 93 : 90);
        this.a(n4, bl3, n2, bl2, k2);
        this.a(r2, bl4, n3, bl5);
    }

    protected javassist.r a(javassist.compiler.ast.b b2, boolean bl2) {
        if (b2 instanceof javassist.compiler.ast.p) {
            String string = ((javassist.compiler.ast.p)b2).b();
            javassist.r r2 = null;
            try {
                r2 = this.b.a(string);
            } catch (aa aa2) {
                throw new t(string, b2);
            }
            boolean bl3 = Z.e(r2.a());
            if (!bl3) {
                if (this.b != false) {
                    throw new e("not available in a static method: " + string);
                }
                ((n)((Object)this.a)).k(0);
            }
            this.c = bl3;
            return r2;
        }
        if (b2 instanceof k) {
            k k2 = (k)b2;
            int n2 = k2.b();
            if (n2 == 35) {
                javassist.r r3 = this.a.b(((v)k2.d()).b(), (v)k2.e());
                this.c = true;
                return r3;
            }
            if (n2 == 46) {
                javassist.r r4 = null;
                try {
                    k2.d().a(this);
                    if (this.a == 307 && this.b == false) {
                        r4 = this.a.a(this.e, (v)k2.e());
                    } else {
                        if (bl2 && this.b > 0 && ((v)k2.e()).b().equals("length")) {
                            return null;
                        }
                        o.e();
                    }
                    boolean bl4 = Z.e(r4.a());
                    if (bl4) {
                        ((n)((Object)this.a)).g(87);
                    }
                    this.c = bl4;
                    return r4;
                } catch (t t2) {
                    if (t2.a() != k2.d()) {
                        throw t2;
                    }
                    v v2 = (v)k2.e();
                    String string = t2.a();
                    r4 = this.a.a(string, v2, b2);
                    this.c = true;
                    return r4;
                }
            }
            o.e();
        } else {
            o.e();
        }
        this.c = false;
        return null;
    }

    private static void e() {
        throw new e("bad l-value");
    }

    public CtClass[] a(javassist.compiler.ast.q q2) {
        CtClass[] ctClassArray;
        javassist.compiler.ast.b b2 = q2.c();
        if (b2 == null) {
            ctClassArray = new CtClass[]{};
        } else {
            int n2 = 0;
            ctClassArray = new CtClass[b2.a()];
            while (b2 != null) {
                ctClassArray[n2++] = this.a.a((i)b2.c());
                b2 = b2.a();
            }
        }
        return ctClassArray;
    }

    public CtClass[] b(javassist.compiler.ast.q q2) {
        javassist.compiler.ast.b b2 = q2.d();
        if (b2 == null) {
            return null;
        }
        int n2 = 0;
        CtClass[] ctClassArray = new CtClass[b2.a()];
        while (b2 != null) {
            ctClassArray[n2++] = this.a.a((a)b2.c());
            b2 = b2.a();
        }
        return ctClassArray;
    }

    @Override
    protected String a(a a2) {
        return this.a.a(a2);
    }

    @Override
    protected String a(String string) {
        return this.a.a(string);
    }
}

