/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javassist.CtClass;
import javassist.bytecode.J;
import javassist.bytecode.stackmap.i;
import javassist.bytecode.stackmap.j;
import javassist.bytecode.stackmap.k;
import javassist.bytecode.stackmap.l;
import javassist.bytecode.stackmap.m;
import javassist.bytecode.stackmap.o;
import javassist.bytecode.stackmap.s;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class h {
    public static h[] a(int n2) {
        h[] hArray = new h[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            hArray[i2] = s.a;
        }
        return hArray;
    }

    protected h() {
    }

    private static void a(h h2, String string, f f2) {
        h2.a(string, f2);
    }

    public abstract int a();

    public abstract int a(J var1);

    public h a() {
        return new o(this);
    }

    public abstract l a();

    public abstract boolean a();

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public abstract boolean a(h var1);

    public abstract String a();

    public abstract void a(String var1, f var2);

    public abstract h a(int var1);

    public int a(List<h> list, int n2, f f2) {
        return n2;
    }

    protected o a(int n2) {
        return null;
    }

    public void a(int n2) {
    }

    public String toString() {
        return super.toString() + "(" + this.a(new HashSet<h>()) + ")";
    }

    abstract String a(Set<h> var1);

    public static CtClass a(CtClass ctClass, CtClass ctClass2) {
        if (ctClass == ctClass2) {
            return ctClass;
        }
        if (ctClass.a() && ctClass2.a()) {
            CtClass ctClass3;
            CtClass ctClass4 = ctClass.a();
            CtClass ctClass5 = h.a(ctClass4, ctClass3 = ctClass2.a());
            if (ctClass5 == ctClass4) {
                return ctClass;
            }
            if (ctClass5 == ctClass3) {
                return ctClass2;
            }
            return ctClass.a().c(ctClass5 == null ? "java.lang.Object" : ctClass5.a() + "[]");
        }
        if (ctClass.d() || ctClass2.d()) {
            return null;
        }
        if (ctClass.a() || ctClass2.a()) {
            return ctClass.a().c("java.lang.Object");
        }
        return h.b(ctClass, ctClass2);
    }

    public static CtClass b(CtClass ctClass, CtClass ctClass2) {
        CtClass ctClass3;
        CtClass ctClass4 = ctClass;
        CtClass ctClass5 = ctClass3 = ctClass2;
        CtClass ctClass6 = ctClass4;
        while (true) {
            if (h.a(ctClass4, ctClass3) && ctClass4.b() != null) {
                return ctClass4;
            }
            CtClass ctClass7 = ctClass4.b();
            CtClass ctClass8 = ctClass3.b();
            if (ctClass8 == null) {
                ctClass3 = ctClass5;
                break;
            }
            if (ctClass7 == null) {
                ctClass4 = ctClass6;
                ctClass6 = ctClass5;
                ctClass5 = ctClass4;
                ctClass4 = ctClass3;
                ctClass3 = ctClass5;
                break;
            }
            ctClass4 = ctClass7;
            ctClass3 = ctClass8;
        }
        while ((ctClass4 = ctClass4.b()) != null) {
            ctClass6 = ctClass6.b();
        }
        ctClass4 = ctClass6;
        while (!h.a(ctClass4, ctClass3)) {
            ctClass4 = ctClass4.b();
            ctClass3 = ctClass3.b();
        }
        return ctClass4;
    }

    static boolean a(CtClass ctClass, CtClass ctClass2) {
        return ctClass == ctClass2 || ctClass != null && ctClass2 != null && ctClass.a().equals(ctClass2.a());
    }

    public static void a(h h2, h h3, f f2) {
        if (h2 instanceof i && !h3.b()) {
            ((i)h2).a(k.a(h3));
        }
        if (h3 instanceof i) {
            if (h2 instanceof i) {
                j.a(h2);
            } else if (h2 instanceof m) {
                if (!h2.b()) {
                    String string = j.a(h2.a());
                    h3.a(string, f2);
                }
            } else {
                throw new javassist.bytecode.i("bad AASTORE: " + h2);
            }
        }
    }
}

