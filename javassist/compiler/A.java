/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import java.util.HashMap;
import java.util.Map;
import javassist.CtClass;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.V;
import javassist.bytecode.W;
import javassist.bytecode.al;
import javassist.bytecode.bi;
import javassist.bytecode.n;
import javassist.bytecode.o;
import javassist.compiler.e;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a {
    private CtClass a;
    private int a;
    private Map<String, Object> a;
    static final String a = "javassist.runtime.Inner";

    public a(CtClass ctClass) {
        this.a = ctClass;
        this.a = 1;
        this.a = new HashMap();
    }

    public String a(CtClass ctClass, String string, al al2) {
        String string2 = "<init>:" + string;
        String string3 = (String)this.a.get(string2);
        if (string3 != null) {
            return string3;
        }
        string3 = M.a(a, string);
        o o2 = this.a.a();
        try {
            J j2 = o2.a();
            f f2 = this.a.a();
            al al3 = new al(j2, "<init>", string3);
            al3.a(0);
            al3.a(new bi(j2));
            V v2 = al2.a();
            if (v2 != null) {
                al3.a(v2.a(j2, null));
            }
            CtClass[] ctClassArray = M.a(string, f2);
            n n2 = new n(j2);
            n2.k(0);
            int n3 = 1;
            for (int i2 = 0; i2 < ctClassArray.length; ++i2) {
                n3 += n2.a(n3, ctClassArray[i2]);
            }
            n2.d(n3 + 1);
            n2.c(this.a, "<init>", string);
            n2.d((CtClass)null);
            al3.a(n2.a());
            o2.a(al3);
        } catch (javassist.a a2) {
            throw new e(a2);
        } catch (aa aa2) {
            throw new e(aa2);
        }
        this.a.put(string2, string3);
        return string3;
    }

    public String a(String string, String string2, String string3, al al2) {
        String string4 = string + ":" + string2;
        String string5 = (String)this.a.get(string4);
        if (string5 != null) {
            return string5;
        }
        o o2 = this.a.a();
        string5 = this.a(o2);
        try {
            J j2 = o2.a();
            f f2 = this.a.a();
            al al3 = new al(j2, string5, string3);
            al3.a(8);
            al3.a(new bi(j2));
            V v2 = al2.a();
            if (v2 != null) {
                al3.a(v2.a(j2, null));
            }
            CtClass[] ctClassArray = M.a(string3, f2);
            int n2 = 0;
            n n3 = new n(j2);
            for (int i2 = 0; i2 < ctClassArray.length; ++i2) {
                n2 += n3.a(n2, ctClassArray[i2]);
            }
            n3.d(n2);
            if (string2 == string3) {
                n3.d(this.a, string, string2);
            } else {
                n3.e(this.a, string, string2);
            }
            n3.d(M.a(string2, f2));
            al3.a(n3.a());
            o2.a(al3);
        } catch (javassist.a a2) {
            throw new e(a2);
        } catch (aa aa2) {
            throw new e(aa2);
        }
        this.a.put(string4, string5);
        return string5;
    }

    public al a(W w2, boolean bl2) {
        String string = w2.a();
        String string2 = string + ":getter";
        Object v2 = this.a.get(string2);
        if (v2 != null) {
            return (al)v2;
        }
        o o2 = this.a.a();
        String string3 = this.a(o2);
        try {
            J j2 = o2.a();
            f f2 = this.a.a();
            String string4 = w2.b();
            String string5 = bl2 ? "()" + string4 : "(" + M.b(this.a) + ")" + string4;
            al al2 = new al(j2, string3, string5);
            al2.a(8);
            al2.a(new bi(j2));
            n n2 = new n(j2);
            if (bl2) {
                n2.b(n.a, string, string4);
            } else {
                n2.k(0);
                n2.a(n.a, string, string4);
                n2.d(1);
            }
            n2.d(M.b(string4, f2));
            al2.a(n2.a());
            o2.a(al2);
            this.a.put(string2, al2);
            return al2;
        } catch (javassist.a a2) {
            throw new e(a2);
        } catch (aa aa2) {
            throw new e(aa2);
        }
    }

    public al b(W w2, boolean bl2) {
        String string = w2.a();
        String string2 = string + ":setter";
        Object v2 = this.a.get(string2);
        if (v2 != null) {
            return (al)v2;
        }
        o o2 = this.a.a();
        String string3 = this.a(o2);
        try {
            int n2;
            J j2 = o2.a();
            f f2 = this.a.a();
            String string4 = w2.b();
            String string5 = bl2 ? "(" + string4 + ")V" : "(" + M.b(this.a) + string4 + ")V";
            al al2 = new al(j2, string3, string5);
            al2.a(8);
            al2.a(new bi(j2));
            n n3 = new n(j2);
            if (bl2) {
                n2 = n3.a(0, M.b(string4, f2));
                n3.g(n.a, string, string4);
            } else {
                n3.k(0);
                n2 = n3.a(1, M.b(string4, f2)) + 1;
                n3.f(n.a, string, string4);
            }
            n3.d((CtClass)null);
            n3.d(n2);
            al2.a(n3.a());
            o2.a(al2);
            this.a.put(string2, al2);
            return al2;
        } catch (javassist.a a2) {
            throw new e(a2);
        } catch (aa aa2) {
            throw new e(aa2);
        }
    }

    private String a(o o2) {
        String string;
        while (o2.a(string = "access$" + this.a++) != null) {
        }
        return string;
    }
}

