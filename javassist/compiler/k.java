/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.CtClass;
import javassist.S;
import javassist.aa;
import javassist.bytecode.M;
import javassist.bytecode.n;
import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.g;
import javassist.compiler.ast.i;
import javassist.compiler.ast.p;
import javassist.compiler.ast.t;
import javassist.compiler.e;
import javassist.compiler.l;
import javassist.compiler.o;
import javassist.compiler.r;
import javassist.compiler.v;
import javassist.compiler.w;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class k
extends o {
    String f = null;
    String g = null;
    CtClass[] a;
    private int dg = 0;
    private boolean d = false;
    private String o = null;
    public static final String h = "$sig";
    public static final String i = "$type";
    public static final String j = "$class";
    private CtClass c = null;
    CtClass a;
    String k = null;
    private String p = null;
    public static final String l = "$w";
    String m = null;
    public static final String n = "$cflow";
    v a = null;

    public k(n n2, CtClass ctClass, f f2) {
        super(n2, ctClass, f2);
        this.a(new l(ctClass, f2, this));
    }

    private int d() {
        return this.dg + (this.d ? 1 : 0);
    }

    public void a(v v2, String string) {
        this.m = string;
        this.a = v2;
    }

    public void c() {
        if (this.a == 344) {
            this.a.g(1);
            this.a = (CtClass[])307;
            this.b = 0;
            this.e = "java/lang/Object";
        }
    }

    @Override
    public void a(p p2) {
        String string = p2.b();
        if (string.equals(this.f)) {
            javassist.compiler.k.a((n)this.a, this.a, this.d());
            this.a = (CtClass[])307;
            this.b = 1;
            this.e = "java/lang/Object";
        } else if (string.equals(h)) {
            this.a.c(M.a(this.a, this.a));
            this.a.d("javassist/runtime/Desc", "getParams", "(Ljava/lang/String;)[Ljava/lang/Class;");
            this.a = (CtClass[])307;
            this.b = 1;
            this.e = "java/lang/Class";
        } else if (string.equals(i)) {
            if (this.c == null) {
                throw new e("$type is not available");
            }
            this.a.c(M.b(this.c));
            this.b("getType");
        } else if (string.equals(j)) {
            if (this.o == null) {
                throw new e("$class is not available");
            }
            this.a.c(this.o);
            this.b("getClazz");
        } else {
            super.a(p2);
        }
    }

    private void b(String string) {
        this.a.d("javassist/runtime/Desc", string, "(Ljava/lang/String;)Ljava/lang/Class;");
        this.a = (CtClass[])307;
        this.b = 0;
        this.e = "java/lang/Class";
    }

    @Override
    protected void a(javassist.compiler.ast.k k2, int n2, b b2, b b3, boolean bl2) {
        if (b2 instanceof p && ((p)b2).b().equals(this.f)) {
            if (n2 != 61) {
                throw new e("bad operator for " + this.f);
            }
            b3.a(this);
            if (this.b != 1 || this.a != 307) {
                throw new e("invalid type for " + this.f);
            }
            this.a(this.a, (n)this.a);
            if (!bl2) {
                this.a.g(87);
            }
        } else {
            super.a(k2, n2, b2, b3, bl2);
        }
    }

    protected void a(CtClass[] ctClassArray, n n2) {
        if (ctClassArray == null) {
            return;
        }
        int n3 = this.d();
        int n4 = ctClassArray.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            n2.g(89);
            n2.m(i2);
            n2.g(50);
            this.a(ctClassArray[i2], n2);
            n2.b(n3, ctClassArray[i2]);
            n3 += javassist.compiler.k.a((int)this.a, this.b) ? 2 : 1;
        }
    }

    @Override
    public void a(g g2) {
        b b2;
        a a2 = g2.b();
        if (a2 != null && g2.c() == 0 && (b2 = a2.c()) instanceof javassist.compiler.ast.v && a2.a() == null) {
            String string = ((javassist.compiler.ast.v)b2).b();
            if (string.equals(this.k)) {
                this.b(g2);
                return;
            }
            if (string.equals(l)) {
                this.c(g2);
                return;
            }
        }
        super.a(g2);
    }

    protected void b(g g2) {
        g2.d().a(this);
        if (this.a == 344 || javassist.compiler.k.a((int)this.a) || this.b > 0) {
            this.a(this.a, (n)this.a);
        } else if (this.a instanceof S) {
            S s2 = (S)this.a;
            int n2 = r.a(s2.a());
            this.a((int)this.a, n2);
            this.a = (CtClass[])n2;
            this.b = 0;
            this.e = null;
        } else {
            throw new e("invalid cast");
        }
    }

    protected void c(g g2) {
        g2.d().a(this);
        if (javassist.compiler.k.a((int)this.a) || this.b > 0) {
            return;
        }
        CtClass ctClass = this.a.a((int)this.a, this.b, this.e);
        if (ctClass instanceof S) {
            S s2 = (S)ctClass;
            String string = s2.e();
            this.a.d(string);
            this.a.g(89);
            if (s2.d() > 1) {
                this.a.g(94);
            } else {
                this.a.g(93);
            }
            this.a.g(88);
            this.a.c(string, "<init>", "(" + s2.a() + ")V");
            this.a = (CtClass[])307;
            this.b = 0;
            this.e = "java/lang/Object";
        }
    }

    @Override
    public void a(javassist.compiler.ast.f f2) {
        b b2 = f2.d();
        if (b2 instanceof p) {
            String string = ((p)b2).b();
            if (this.a != null && string.equals(this.m)) {
                this.a.a(this, (n)this.a, (a)f2.e());
                return;
            }
            if (string.equals(n)) {
                this.b((a)f2.e());
                return;
            }
        }
        super.a(f2);
    }

    protected void b(a a2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (a2 == null || a2.a() != null) {
            throw new e("bad $cflow");
        }
        javassist.compiler.k.a(stringBuffer, a2.c());
        String string = stringBuffer.toString();
        Object[] objectArray = this.a.a().a(string);
        if (objectArray == null) {
            throw new e("no such $cflow: " + string);
        }
        this.a.b((String)objectArray[0], (String)objectArray[1], "Ljavassist/runtime/Cflow;");
        this.a.e("javassist.runtime.Cflow", "value", "()I");
        this.a = (CtClass[])324;
        this.b = 0;
        this.e = null;
    }

    private static void a(StringBuffer stringBuffer, b b2) {
        javassist.compiler.ast.k k2;
        if (b2 instanceof javassist.compiler.ast.v) {
            stringBuffer.append(((javassist.compiler.ast.v)b2).b());
            return;
        }
        if (b2 instanceof javassist.compiler.ast.k && (k2 = (javassist.compiler.ast.k)b2).b() == 46) {
            javassist.compiler.k.a(stringBuffer, k2.d());
            stringBuffer.append('.');
            javassist.compiler.k.a(stringBuffer, k2.e());
            return;
        }
        throw new e("bad $cflow");
    }

    public boolean a(a a2) {
        if (this.a != null && a2 != null && a2.a() == null) {
            b b2 = a2.c();
            return b2 instanceof p && ((p)b2).b().equals(this.g);
        }
        return false;
    }

    @Override
    public int a(a b2) {
        String string = this.g;
        int n2 = 0;
        while (b2 != null) {
            b b3 = b2.c();
            if (b3 instanceof p && ((p)b3).b().equals(string)) {
                if (this.a != null) {
                    n2 += this.a.length;
                }
            } else {
                ++n2;
            }
            b2 = b2.a();
        }
        return n2;
    }

    @Override
    public void a(a b2, int[] nArray, int[] nArray2, String[] stringArray) {
        CtClass[] ctClassArray = this.a;
        String string = this.g;
        int n2 = 0;
        while (b2 != null) {
            b b3 = b2.c();
            if (b3 instanceof p && ((p)b3).b().equals(string)) {
                if (ctClassArray != null) {
                    int n3 = ctClassArray.length;
                    int n4 = this.d();
                    for (int i2 = 0; i2 < n3; ++i2) {
                        CtClass ctClass = ctClassArray[i2];
                        n4 += this.a.a(n4, ctClass);
                        this.b(ctClass);
                        nArray[n2] = (int)this.a;
                        nArray2[n2] = this.b;
                        stringArray[n2] = this.e;
                        ++n2;
                    }
                }
            } else {
                b3.a(this);
                nArray[n2] = (int)this.a;
                nArray2[n2] = this.b;
                stringArray[n2] = this.e;
                ++n2;
            }
            b2 = b2.a();
        }
    }

    void a(b b2, int n2, String string, a a2) {
        b2.a(this);
        int n3 = this.a(a2);
        this.a(a2, new int[n3], new int[n3], new String[n3]);
        this.a.a(n2, string);
        this.a(string, false, false);
        this.c();
    }

    @Override
    protected void b(t t2) {
        b b2 = t2.a();
        if (b2 != null && this.a == CtClass.i) {
            this.a(b2);
            if (javassist.compiler.k.a((int)this.a, this.b)) {
                this.a.g(88);
            } else if (this.a != 344) {
                this.a.g(87);
            }
            b2 = null;
        }
        this.c(b2);
    }

    public int a(CtClass ctClass, String string, String string2, w w2) {
        this.a = ctClass;
        this.k = string;
        this.p = string2;
        if (string2 == null) {
            return -1;
        }
        int n2 = this.a();
        int n3 = n2 + this.a(ctClass, string2, n2, w2);
        this.a(n3);
        return n2;
    }

    public void a(CtClass ctClass) {
        this.c = ctClass;
    }

    public int a(CtClass[] ctClassArray, boolean bl2, String string, String string2, String string3, w w2) {
        return this.a(ctClassArray, bl2, string, string2, string3, !bl2, 0, this.a(), w2);
    }

    public int a(CtClass[] ctClassArray, boolean bl2, String string, String string2, String string3, boolean bl3, int n2, String string4, w w2) {
        this.a = ctClassArray;
        this.f = string2;
        this.g = string3;
        this.dg = n2;
        this.d = bl3;
        if (string4 != null) {
            this.o = r.c(string4);
        }
        this.b = bl2;
        int n3 = n2;
        if (bl3) {
            String string5 = string + "0";
            i i2 = new i(307, r.b(string4), 0, n3++, new javassist.compiler.ast.v(string5));
            w2.a(string5, i2);
        }
        for (int i3 = 0; i3 < ctClassArray.length; ++i3) {
            n3 += this.a(ctClassArray[i3], string + (i3 + 1), n3, w2);
        }
        if (this.a() < n3) {
            this.a(n3);
        }
        return n3;
    }

    public int a(CtClass ctClass, String string, w w2) {
        if (string == null) {
            return -1;
        }
        int n2 = this.a();
        int n3 = n2 + this.a(ctClass, string, n2, w2);
        this.a(n3);
        return n2;
    }

    private int a(CtClass ctClass, String string, int n2, w w2) {
        if (ctClass == CtClass.i) {
            this.a = (CtClass[])307;
            this.b = 0;
            this.e = "java/lang/Object";
        } else {
            this.b(ctClass);
        }
        i i2 = new i((int)this.a, this.e, this.b, n2, new javassist.compiler.ast.v(string));
        w2.a(string, i2);
        return javassist.compiler.k.a((int)this.a, this.b) ? 2 : 1;
    }

    public void a(String string, String string2, int n2, w w2) {
        char c2;
        int n3 = 0;
        while ((c2 = string.charAt(n3)) == '[') {
            ++n3;
        }
        int n4 = r.a(c2);
        String string3 = null;
        if (n4 == 307) {
            string3 = n3 == 0 ? string.substring(1, string.length() - 1) : string.substring(n3 + 1, string.length() - 1);
        }
        i i2 = new i(n4, string3, n3, n2, new javassist.compiler.ast.v(string2));
        w2.a(string2, i2);
    }

    public static int a(n n2, CtClass[] ctClassArray, int n3) {
        if (ctClassArray == null) {
            n2.m(0);
            n2.e("java.lang.Object");
            return 1;
        }
        CtClass[] ctClassArray2 = new CtClass[1];
        int n4 = ctClassArray.length;
        n2.m(n4);
        n2.e("java.lang.Object");
        for (int i2 = 0; i2 < n4; ++i2) {
            n2.g(89);
            n2.m(i2);
            if (ctClassArray[i2].d()) {
                S s2 = (S)ctClassArray[i2];
                String string = s2.e();
                n2.d(string);
                n2.g(89);
                int n5 = n2.a(n3, s2);
                n3 += n5;
                ctClassArray2[0] = s2;
                n2.c(string, "<init>", M.a(CtClass.i, ctClassArray2));
            } else {
                n2.k(n3);
                ++n3;
            }
            n2.g(83);
        }
        return 8;
    }

    protected void a(CtClass ctClass, n n2) {
        if (ctClass == CtClass.i) {
            this.c();
            return;
        }
        if (this.a == 344) {
            throw new e("invalid type for " + this.k);
        }
        if (ctClass instanceof S) {
            S s2 = (S)ctClass;
            String string = s2.e();
            n2.a(string);
            n2.e(string, s2.f(), s2.g());
            this.b(ctClass);
        } else {
            n2.b(ctClass);
            this.b(ctClass);
        }
    }

    public void b(CtClass ctClass) {
        this.a(ctClass, 0);
    }

    private void a(CtClass ctClass, int n2) {
        if (ctClass.d()) {
            S s2 = (S)ctClass;
            this.a = (CtClass[])r.a(s2.a());
            this.b = n2;
            this.e = null;
        } else if (ctClass.a()) {
            try {
                this.a(ctClass.a(), n2 + 1);
            } catch (aa aa2) {
                throw new e("undefined type: " + ctClass.a());
            }
        } else {
            this.a = (CtClass[])307;
            this.b = n2;
            this.e = r.b(ctClass.a());
        }
    }

    public void c(CtClass ctClass) {
        if (this.b == 0 && !javassist.compiler.k.a((int)this.a)) {
            if (ctClass instanceof S) {
                S s2 = (S)ctClass;
                this.a((int)this.a, r.a(s2.a()));
            } else {
                throw new e("type mismatch");
            }
        }
    }
}

