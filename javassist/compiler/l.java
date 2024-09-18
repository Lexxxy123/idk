/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.CtClass;
import javassist.S;
import javassist.aa;
import javassist.compiler.A;
import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.f;
import javassist.compiler.ast.g;
import javassist.compiler.ast.p;
import javassist.compiler.ast.v;
import javassist.compiler.e;
import javassist.compiler.k;
import javassist.compiler.r;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class l
extends A {
    private k a;

    public l(CtClass ctClass, javassist.f f2, k k2) {
        super(ctClass, f2);
        this.a = k2;
    }

    public void a() {
        if (this.a == 344) {
            this.a = (k)307;
            this.b = 0;
            this.e = "java/lang/Object";
        }
    }

    @Override
    public void a(p p2) {
        String string = p2.b();
        if (string.equals(this.a.f)) {
            this.a = (k)307;
            this.b = 1;
            this.e = "java/lang/Object";
        } else if (string.equals("$sig")) {
            this.a = (k)307;
            this.b = 1;
            this.e = "java/lang/Class";
        } else if (string.equals("$type") || string.equals("$class")) {
            this.a = (k)307;
            this.b = 0;
            this.e = "java/lang/Class";
        } else {
            super.a(p2);
        }
    }

    @Override
    protected void a(javassist.compiler.ast.k k2, int n2, b b2, b b3) {
        if (b2 instanceof p && ((p)b2).b().equals(this.a.f)) {
            b3.a(this);
            CtClass[] ctClassArray = this.a.a;
            if (ctClassArray == null) {
                return;
            }
            int n3 = ctClassArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                this.a(ctClassArray[i2]);
            }
        } else {
            super.a(k2, n2, b2, b3);
        }
    }

    @Override
    public void a(g g2) {
        b b2;
        a a2 = g2.b();
        if (a2 != null && g2.c() == 0 && (b2 = a2.c()) instanceof v && a2.a() == null) {
            String string = ((v)b2).b();
            if (string.equals(this.a.k)) {
                this.b(g2);
                return;
            }
            if (string.equals("$w")) {
                this.c(g2);
                return;
            }
        }
        super.a(g2);
    }

    protected void b(g g2) {
        CtClass ctClass = this.a.a;
        g2.d().a(this);
        if (this.a == 344 || javassist.compiler.b.a((int)this.a) || this.b > 0) {
            this.a(ctClass);
        } else if (ctClass instanceof S) {
            S s2 = (S)ctClass;
            int n2 = r.a(s2.a());
            this.a = (k)n2;
            this.b = 0;
            this.e = null;
        }
    }

    protected void c(g g2) {
        g2.d().a(this);
        if (javassist.compiler.b.a((int)this.a) || this.b > 0) {
            return;
        }
        CtClass ctClass = ((r)((Object)this.a)).a((int)this.a, this.b, this.e);
        if (ctClass instanceof S) {
            this.a = (k)307;
            this.b = 0;
            this.e = "java/lang/Object";
        }
    }

    @Override
    public void a(f f2) {
        b b2 = f2.d();
        if (b2 instanceof p) {
            String string = ((p)b2).b();
            if (this.a.a != null && string.equals(this.a.m)) {
                this.a.a.a(this, (a)f2.e());
                return;
            }
            if (string.equals("$cflow")) {
                this.b((a)f2.e());
                return;
            }
        }
        super.a(f2);
    }

    protected void b(a a2) {
        this.a = (k)324;
        this.b = 0;
        this.e = null;
    }

    public boolean a(a a2) {
        if (this.a.a != null && a2 != null && a2.a() == null) {
            b b2 = a2.c();
            return b2 instanceof p && ((p)b2).b().equals(this.a.g);
        }
        return false;
    }

    @Override
    public int a(a b2) {
        String string = this.a.g;
        int n2 = 0;
        while (b2 != null) {
            b b3 = b2.c();
            if (b3 instanceof p && ((p)b3).b().equals(string)) {
                if (this.a.a != null) {
                    n2 += this.a.a.length;
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
        CtClass[] ctClassArray = this.a.a;
        String string = this.a.g;
        int n2 = 0;
        while (b2 != null) {
            b b3 = b2.c();
            if (b3 instanceof p && ((p)b3).b().equals(string)) {
                if (ctClassArray != null) {
                    int n3 = ctClassArray.length;
                    for (int i2 = 0; i2 < n3; ++i2) {
                        CtClass ctClass = ctClassArray[i2];
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

    void a(b b2, String string, String string2, String string3, a a2) {
        b2.a(this);
        int n2 = this.a(a2);
        this.a(a2, new int[n2], new int[n2], new String[n2]);
        this.a(string3);
        this.a();
    }

    protected void a(CtClass ctClass) {
        if (ctClass == CtClass.i) {
            this.a();
        } else {
            this.b(ctClass);
        }
    }

    public void b(CtClass ctClass) {
        this.a(ctClass, 0);
    }

    private void a(CtClass ctClass, int n2) {
        if (ctClass.d()) {
            S s2 = (S)ctClass;
            this.a = (k)r.a(s2.a());
            this.b = n2;
            this.e = null;
        } else if (ctClass.a()) {
            try {
                this.a(ctClass.a(), n2 + 1);
            } catch (aa aa2) {
                throw new e("undefined type: " + ctClass.a());
            }
        } else {
            this.a = (k)307;
            this.b = n2;
            this.e = r.b(ctClass.a());
        }
    }
}

