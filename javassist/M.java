/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.G;
import javassist.S;
import javassist.Z;
import javassist.a;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.V;
import javassist.bytecode.aL;
import javassist.bytecode.aV;
import javassist.bytecode.ad;
import javassist.bytecode.ae;
import javassist.bytecode.af;
import javassist.bytecode.ag;
import javassist.bytecode.al;
import javassist.bytecode.av;
import javassist.bytecode.aw;
import javassist.bytecode.c;
import javassist.bytecode.h;
import javassist.bytecode.i;
import javassist.bytecode.n;
import javassist.bytecode.r;
import javassist.bytecode.t;
import javassist.bytecode.u;
import javassist.bytecode.y;
import javassist.expr.e;
import javassist.f;
import javassist.p;
import javassist.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class m
extends G {
    protected al a;

    protected m(CtClass ctClass, al al2) {
        super(ctClass);
        this.a = al2;
    }

    void a(m m2, boolean bl2, javassist.c c2) {
        al al2 = this.a;
        al al3 = m2.a;
        CtClass ctClass = m2.a();
        J j2 = ((CtClass)((Object)al2)).b().a();
        c2 = new javassist.c(c2);
        c2.a(ctClass.a(), ((CtClass)((Object)al2)).a());
        try {
            String string;
            boolean bl3 = false;
            CtClass ctClass2 = ctClass.b();
            CtClass ctClass3 = ((CtClass)((Object)al2)).b();
            String string2 = null;
            if (ctClass2 != null && ctClass3 != null && !(string = ctClass2.a()).equals(string2 = ctClass3.a())) {
                if (string.equals("java.lang.Object")) {
                    bl3 = true;
                } else {
                    c2.a(string, string2);
                }
            }
            this.a = new al(j2, al3.a(), al3, c2);
            if (bl2 && bl3) {
                this.a.c(string2);
            }
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (i i2) {
            throw new a(i2);
        }
    }

    @Override
    protected void a(StringBuffer stringBuffer) {
        stringBuffer.append(' ');
        stringBuffer.append(this.d());
        stringBuffer.append(' ');
        stringBuffer.append(this.a.b());
    }

    public abstract String a();

    public al a() {
        ((CtClass)((Object)this.a)).b();
        return this.a;
    }

    public al b() {
        return this.a;
    }

    @Override
    public int a() {
        return javassist.bytecode.a.f(this.a.a());
    }

    @Override
    public void a(int n2) {
        ((CtClass)((Object)this.a)).b();
        this.a.a(javassist.bytecode.a.e(n2));
    }

    @Override
    public boolean a(String string) {
        al al2 = this.b();
        c c2 = (c)al2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)al2.a("RuntimeVisibleAnnotations");
        return p.a(string, this.a().a(), c2, c3);
    }

    @Override
    public Object a(Class<?> clazz) {
        al al2 = this.b();
        c c2 = (c)al2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)al2.a("RuntimeVisibleAnnotations");
        return p.a(clazz, this.a().a(), c2, c3);
    }

    @Override
    public Object[] a() {
        return this.a(false);
    }

    @Override
    public Object[] b() {
        try {
            return this.a(true);
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("Unexpected exception", classNotFoundException);
        }
    }

    private Object[] a(boolean bl2) {
        al al2 = this.b();
        c c2 = (c)al2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)al2.a("RuntimeVisibleAnnotations");
        return p.a(bl2, this.a().a(), c2, c3);
    }

    public Object[][] a() {
        return this.a(false);
    }

    public Object[][] b() {
        try {
            return this.a(true);
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("Unexpected exception", classNotFoundException);
        }
    }

    Object[][] a(boolean bl2) {
        al al2 = this.b();
        av av2 = (av)al2.a("RuntimeInvisibleParameterAnnotations");
        av av3 = (av)al2.a("RuntimeVisibleParameterAnnotations");
        return p.a(bl2, this.a().a(), av2, av3, al2);
    }

    public CtClass[] a() {
        return M.a(this.a.b(), ((CtClass)((Object)this.a)).a());
    }

    CtClass a_() {
        return M.a(this.a.b(), ((CtClass)((Object)this.a)).a());
    }

    @Override
    public String b() {
        return this.a.b();
    }

    @Override
    public String c() {
        aw aw2 = (aw)this.a.a("Signature");
        return aw2 == null ? null : aw2.b();
    }

    @Override
    public void a(String string) {
        ((CtClass)((Object)this.a)).b();
        this.a.a(new aw(this.a.a(), string));
    }

    public CtClass[] b() {
        V v2 = this.a.a();
        String[] stringArray = v2 == null ? null : v2.a();
        return ((CtClass)((Object)this.a)).a().a(stringArray);
    }

    public void a(CtClass[] ctClassArray) {
        ((CtClass)((Object)this.a)).b();
        if (ctClassArray == null || ctClassArray.length == 0) {
            this.a.a();
            return;
        }
        String[] stringArray = new String[ctClassArray.length];
        for (int i2 = 0; i2 < ctClassArray.length; ++i2) {
            stringArray[i2] = ctClassArray[i2].a();
        }
        V v2 = this.a.a();
        if (v2 == null) {
            v2 = new V(this.a.a());
            this.a.a(v2);
        }
        v2.a(stringArray);
    }

    public abstract boolean a();

    public void b(String string) {
        this.a(string, (String)null, (String)null);
    }

    public void a(String string, String string2, String string3) {
        al al2 = this.a;
        ((CtClass)((Object)al2)).b();
        try {
            javassist.compiler.f f2 = new javassist.compiler.f((CtClass)((Object)al2));
            if (string3 != null) {
                f2.a(string2, string3);
            }
            n n2 = f2.a(this, string);
            this.a.a(n2.a());
            this.a.a(this.a.a() & 0xFFFFFBFF);
            this.a.a(((CtClass)((Object)al2)).a(), ((CtClass)((Object)al2)).b());
            ((CtClass)((Object)this.a)).g();
        } catch (javassist.compiler.e e2) {
            throw new a(e2);
        } catch (i i2) {
            throw new a(i2);
        }
    }

    static void a(CtClass ctClass, al al2, CtClass ctClass2, al al3, javassist.c c2) {
        ctClass2.b();
        c2 = new javassist.c(c2);
        c2.a(ctClass.a(), ctClass2.a());
        try {
            r r2 = al2.a();
            if (r2 != null) {
                J j2 = al3.a();
                r r3 = (r)r2.a(j2, c2);
                al3.a(r3);
            }
        } catch (t t2) {
            throw new a(t2);
        }
        al3.a(al3.a() & 0xFFFFFBFF);
        ctClass2.g();
    }

    @Override
    public byte[] a(String string) {
        h h2 = this.a.a(string);
        if (h2 == null) {
            return null;
        }
        return h2.a();
    }

    @Override
    public void a(String string, byte[] byArray) {
        ((CtClass)((Object)this.a)).b();
        this.a.a(new h(this.a.a(), string, byArray));
    }

    public void c(String string) {
        al al2 = this.a;
        ((CtClass)((Object)al2)).b();
        f f2 = ((CtClass)((Object)al2)).a();
        int n2 = 0;
        while (true) {
            String string2 = "_cflow$" + n2++;
            try {
                ((CtClass)((Object)al2)).b(string2);
            } catch (aa aa2) {
                f2.a(string, ((CtClass)((Object)this.a)).a(), string2);
                try {
                    CtClass ctClass = f2.c("javassist.runtime.Cflow");
                    javassist.r r2 = new javassist.r(ctClass, string2, (CtClass)((Object)al2));
                    r2.a(9);
                    ((CtClass)((Object)al2)).a(r2, x.a(ctClass));
                    this.b(string2 + ".enter();", false);
                    String string3 = string2 + ".exit();";
                    this.a(string3, true);
                } catch (aa aa3) {
                    throw new a(aa3);
                }
                return;
            }
        }
    }

    public void a(String string, CtClass ctClass) {
        ((CtClass)((Object)this.a)).b();
        J j2 = this.a.a();
        r r2 = this.a.a();
        if (r2 == null) {
            throw new a("no method body");
        }
        af af2 = (af)r2.a("LocalVariableTable");
        if (af2 == null) {
            af2 = new af(j2);
            r2.a().add(af2);
        }
        int n2 = r2.d();
        String string2 = M.b(ctClass);
        af2.a(0, r2.e(), j2.c(string), j2.c(string2), n2);
        r2.b(n2 + M.c(string2));
    }

    public void a(CtClass ctClass) {
        ((CtClass)((Object)this.a)).b();
        String string = this.a.b();
        String string2 = M.b(ctClass, string);
        try {
            this.a(Z.e(this.a()) ? 0 : 1, ctClass, string);
        } catch (i i2) {
            throw new a(i2);
        }
        this.a.b(string2);
    }

    public void b(CtClass ctClass) {
        ((CtClass)((Object)this.a)).b();
        String string = this.a.b();
        String string2 = M.a(ctClass, string);
        int n2 = Z.e(this.a()) ? 0 : 1;
        try {
            this.a(n2 + M.d(string), ctClass, string);
        } catch (i i2) {
            throw new a(i2);
        }
        this.a.b(string2);
    }

    private void a(int n2, CtClass ctClass, String string) {
        r r2 = this.a.a();
        if (r2 != null) {
            aL aL2;
            aV aV2;
            ag ag2;
            Object object;
            int n3 = 1;
            char c2 = 'L';
            int n4 = 0;
            if (ctClass.d()) {
                object = (S)ctClass;
                n3 = ((S)object).d();
                c2 = ((S)object).a();
            } else {
                n4 = this.a.a().a(ctClass);
            }
            r2.a(n2, n3);
            object = (af)r2.a("LocalVariableTable");
            if (object != null) {
                ((af)object).a(n2, n3);
            }
            if ((ag2 = (ag)r2.a("LocalVariableTypeTable")) != null) {
                ag2.a(n2, n3);
            }
            if ((aV2 = (aV)r2.a("StackMapTable")) != null) {
                aV2.a(n2, aV.a(c2), n4);
            }
            if ((aL2 = (aL)r2.a("StackMap")) != null) {
                aL2.a(n2, aV.a(c2), n4);
            }
        }
    }

    public void a(javassist.h h2) {
        ((CtClass)((Object)this.a)).b();
        J j2 = this.a.a();
        h2.a(this.a(), this.a, j2);
    }

    public void a(e e2) {
        if (((CtClass)((Object)this.a)).c()) {
            ((CtClass)((Object)this.a)).b();
        }
        if (e2.a((CtClass)((Object)this.a), this.a)) {
            ((CtClass)((Object)this.a)).b();
        }
    }

    public void d(String string) {
        this.b(string, true);
    }

    private void b(String string, boolean bl2) {
        al al2 = this.a;
        ((CtClass)((Object)al2)).b();
        r r2 = this.a.a();
        if (r2 == null) {
            throw new a("no method body");
        }
        u u2 = r2.a();
        javassist.compiler.f f2 = new javassist.compiler.f((CtClass)((Object)al2));
        try {
            int n2 = f2.a(this.a(), Z.e(this.a()));
            f2.b(r2, n2);
            f2.a(r2, 0);
            f2.a(this.a_(), false);
            f2.a(string);
            n n3 = f2.a();
            int n4 = n3.c();
            int n5 = n3.d();
            if (n4 > r2.a()) {
                r2.a(n4);
            }
            if (n5 > r2.d()) {
                r2.b(n5);
            }
            int n6 = u2.b(n3.b());
            u2.a(n3.a(), n6);
            if (bl2) {
                this.a.a(((CtClass)((Object)al2)).a(), ((CtClass)((Object)al2)).b());
            }
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (javassist.compiler.e e2) {
            throw new a(e2);
        } catch (i i2) {
            throw new a(i2);
        }
    }

    public void e(String string) {
        this.a(string, false, false);
    }

    public void a(String string, boolean bl2) {
        this.a(string, bl2, false);
    }

    public void a(String string, boolean bl2, boolean bl3) {
        al al2 = this.a;
        ((CtClass)((Object)al2)).b();
        J j2 = this.a.a();
        r r2 = this.a.a();
        if (r2 == null) {
            throw new a("no method body");
        }
        u u2 = r2.a();
        int n2 = r2.d();
        n n3 = new n(j2, 0, n2 + 1);
        n3.i(r2.a() + 1);
        javassist.compiler.f f2 = new javassist.compiler.f(n3, (CtClass)((Object)al2));
        try {
            int n4;
            int n5 = f2.a(this.a(), Z.e(this.a()));
            f2.b(r2, n5);
            CtClass ctClass = this.a_();
            int n6 = f2.a(ctClass, true);
            f2.a(r2, 0);
            int n7 = this.a(bl2, n3, ctClass, n6, f2, string);
            int n8 = u2.c();
            if (bl2) {
                r2.a().a(this.a(r2), n8, n8, 0);
            }
            int n9 = 0;
            int n10 = 0;
            boolean bl4 = true;
            while (u2.a() && (n4 = u2.d()) < n8) {
                int n11 = u2.a(n4);
                if (n11 != 176 && n11 != 172 && n11 != 174 && n11 != 173 && n11 != 175 && n11 != 177) continue;
                if (bl3) {
                    int n12;
                    int n13;
                    javassist.compiler.f f3;
                    n n14;
                    u2.c(n8);
                    if (bl4) {
                        bl4 = false;
                        n14 = n3;
                        f3 = f2;
                        n13 = n6;
                    } else {
                        n14 = new n(j2, 0, n2 + 1);
                        n14.i(r2.a() + 1);
                        f3 = new javassist.compiler.f(n14, (CtClass)((Object)al2));
                        n12 = f3.a(this.a(), Z.e(this.a()));
                        f3.b(r2, n12);
                        n13 = f3.a(ctClass, true);
                        f3.a(r2, 0);
                    }
                    n12 = this.a(n14, f3, string, j2, ctClass, n13);
                    int n15 = u2.c(n14.b());
                    u2.b(n14.a(), n15);
                    int n16 = u2.c() - n12;
                    this.a(u2, n16, n4);
                    n8 = u2.b();
                    continue;
                }
                if (bl4) {
                    n9 = this.a(n3, f2, string, j2, ctClass, n6);
                    n8 = u2.c(n3.b());
                    u2.b(n3.a(), n8);
                    n10 = u2.c() - n9;
                    n7 = n10 - n8;
                    bl4 = false;
                }
                this.a(u2, n10, n4);
                n10 = u2.c() - n9;
                n8 = n10 - n7;
            }
            if (bl4) {
                n8 = u2.c(n3.b());
                u2.b(n3.a(), n8);
            }
            r2.a(n3.c());
            r2.b(n3.d());
            this.a.a(((CtClass)((Object)al2)).a(), ((CtClass)((Object)al2)).b());
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (javassist.compiler.e e2) {
            throw new a(e2);
        } catch (i i2) {
            throw new a(i2);
        }
    }

    private int a(n n2, javassist.compiler.f f2, String string, J j2, CtClass ctClass, int n3) {
        int n4 = n2.e();
        if (ctClass == CtClass.i) {
            n2.g(1);
            n2.l(n3);
            f2.a(string);
            n2.g(177);
            if (n2.d() < 1) {
                n2.d(1);
            }
        } else {
            n2.b(n3, ctClass);
            f2.a(string);
            n2.a(n3, ctClass);
            if (ctClass.d()) {
                n2.g(((S)ctClass).b());
            } else {
                n2.g(176);
            }
        }
        return n2.e() - n4;
    }

    private void a(u u2, int n2, int n3) {
        u2.b(n2);
        u2.a(0, n3);
        boolean bl2 = n2 + 2 - n3 > Short.MAX_VALUE;
        int n4 = bl2 ? 4 : 2;
        y y2 = u2.a(n3, n4, false);
        n3 = y2.a + y2.b - n4;
        int n5 = u2.a() - n3;
        if (bl2) {
            u2.a(200, n3);
            u2.c(n5, n3 + 1);
        } else if (n5 <= Short.MAX_VALUE) {
            u2.a(167, n3);
            u2.b(n5, n3 + 1);
        } else {
            if (y2.b < 4) {
                y y3 = u2.a(y2.a, 2, false);
                n3 = y3.a + y3.b + y2.b - 4;
            }
            u2.a(200, n3);
            u2.c(u2.a() - n3, n3 + 1);
        }
    }

    private int a(boolean bl2, n n2, CtClass ctClass, int n3, javassist.compiler.f f2, String string) {
        if (!bl2) {
            return 0;
        }
        int n4 = n2.d();
        n2.e(1);
        int n5 = n2.e();
        n2.l(n4);
        if (ctClass.d()) {
            char c2 = ((S)ctClass).a();
            if (c2 == 'D') {
                n2.a(0.0);
                n2.s(n3);
            } else if (c2 == 'F') {
                n2.a(0.0f);
                n2.u(n3);
            } else if (c2 == 'J') {
                n2.a(0L);
                n2.q(n3);
            } else if (c2 == 'V') {
                n2.g(1);
                n2.l(n3);
            } else {
                n2.m(0);
                n2.o(n3);
            }
        } else {
            n2.g(1);
            n2.l(n3);
        }
        f2.a(string);
        n2.k(n4);
        n2.g(191);
        return n2.e() - n5;
    }

    public void b(String string, CtClass ctClass) {
        this.a(string, ctClass, "$e");
    }

    public void a(String string, CtClass ctClass, String string2) {
        al al2 = this.a;
        ((CtClass)((Object)al2)).b();
        J j2 = this.a.a();
        r r2 = this.a.a();
        u u2 = r2.a();
        n n2 = new n(j2, r2.a(), r2.d());
        n2.i(1);
        javassist.compiler.f f2 = new javassist.compiler.f(n2, (CtClass)((Object)al2));
        try {
            f2.a(this.a(), Z.e(this.a()));
            int n3 = f2.a(ctClass, string2);
            n2.l(n3);
            f2.a(string);
            int n4 = n2.c();
            int n5 = n2.d();
            if (n4 > r2.a()) {
                r2.a(n4);
            }
            if (n5 > r2.d()) {
                r2.b(n5);
            }
            int n6 = u2.c();
            int n7 = u2.c(n2.b());
            r2.a().a(this.a(r2), n6, n6, j2.a(ctClass));
            u2.b(n2.a(), n7);
            this.a.a(((CtClass)((Object)al2)).a(), ((CtClass)((Object)al2)).b());
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (javassist.compiler.e e2) {
            throw new a(e2);
        } catch (i i2) {
            throw new a(i2);
        }
    }

    int a(r r2) {
        return 0;
    }

    public int a(int n2, String string) {
        return this.a(n2, true, string);
    }

    public int a(int n2, boolean bl2, String string) {
        r r2 = this.a.a();
        if (r2 == null) {
            throw new a("no method body");
        }
        ad ad2 = (ad)r2.a("LineNumberTable");
        if (ad2 == null) {
            throw new a("no line number info");
        }
        ae ae2 = ad2.a(n2);
        n2 = ae2.b;
        int n3 = ae2.a;
        if (!bl2) {
            return n2;
        }
        al al2 = this.a;
        ((CtClass)((Object)al2)).b();
        u u2 = r2.a();
        javassist.compiler.f f2 = new javassist.compiler.f((CtClass)((Object)al2));
        try {
            f2.a(r2, n3);
            f2.a(this.a(), Z.e(this.a()));
            f2.a(r2.d());
            f2.a(string);
            n n4 = f2.a();
            int n5 = n4.d();
            int n6 = n4.c();
            r2.b(n5);
            if (n6 > r2.a()) {
                r2.a(n6);
            }
            n3 = u2.a(n3, n4.b());
            u2.a(n4.a(), n3);
            this.a.a(((CtClass)((Object)al2)).a(), ((CtClass)((Object)al2)).b());
            return n2;
        } catch (aa aa2) {
            throw new a(aa2);
        } catch (javassist.compiler.e e2) {
            throw new a(e2);
        } catch (i i2) {
            throw new a(i2);
        }
    }
}

