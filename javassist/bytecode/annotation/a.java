/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javassist.CtClass;
import javassist.I;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.annotation.b;
import javassist.bytecode.annotation.c;
import javassist.bytecode.annotation.d;
import javassist.bytecode.annotation.e;
import javassist.bytecode.annotation.g;
import javassist.bytecode.annotation.h;
import javassist.bytecode.annotation.i;
import javassist.bytecode.annotation.j;
import javassist.bytecode.annotation.k;
import javassist.bytecode.annotation.l;
import javassist.bytecode.annotation.m;
import javassist.bytecode.annotation.n;
import javassist.bytecode.annotation.o;
import javassist.bytecode.annotation.p;
import javassist.bytecode.annotation.s;
import javassist.bytecode.annotation.t;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a {
    J a;
    int a;
    Map<String, b> a;

    public a(int n2, J j2) {
        this.a = j2;
        this.a = n2;
        this.a = null;
    }

    public a(String string, J j2) {
        this(j2.c(M.d(string)), j2);
    }

    public a(J j2, CtClass ctClass) {
        this(j2.c(M.d(ctClass.a())), j2);
        if (!ctClass.f()) {
            throw new RuntimeException("Only interfaces are allowed for Annotation creation.");
        }
        I[] iArray = ctClass.b();
        if (iArray.length > 0) {
            this.a = new LinkedHashMap();
        }
        for (I i2 : iArray) {
            this.a(i2.d(), javassist.bytecode.annotation.a.a(j2, i2.b()));
        }
    }

    public static p a(J j2, CtClass ctClass) {
        if (ctClass == CtClass.a) {
            return new g(j2);
        }
        if (ctClass == CtClass.c) {
            return new h(j2);
        }
        if (ctClass == CtClass.b) {
            return new i(j2);
        }
        if (ctClass == CtClass.d) {
            return new s(j2);
        }
        if (ctClass == CtClass.e) {
            return new n(j2);
        }
        if (ctClass == CtClass.f) {
            return new o(j2);
        }
        if (ctClass == CtClass.g) {
            return new m(j2);
        }
        if (ctClass == CtClass.h) {
            return new k(j2);
        }
        if (ctClass.a().equals("java.lang.Class")) {
            return new j(j2);
        }
        if (ctClass.a().equals("java.lang.String")) {
            return new t(j2);
        }
        if (ctClass.a()) {
            CtClass ctClass2 = ctClass.a();
            p p2 = javassist.bytecode.annotation.a.a(j2, ctClass2);
            return new javassist.bytecode.annotation.f(p2, j2);
        }
        if (ctClass.f()) {
            a a2 = new a(j2, ctClass);
            return new d(a2, j2);
        }
        l l2 = new l(j2);
        l2.a(ctClass.a());
        return l2;
    }

    public void a(int n2, p p2) {
        b b2 = new b();
        b2.a = n2;
        b2.a = p2;
        this.a(b2);
    }

    public void a(String string, p p2) {
        b b2 = new b();
        b2.a = this.a.c(string);
        b2.a = p2;
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
        this.a.put(string, b2);
    }

    private void a(b b2) {
        String string = this.a.m(b2.a);
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
        this.a.put(string, b2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("@");
        stringBuffer.append(this.a());
        if (this.a != null) {
            stringBuffer.append("(");
            for (String string : this.a.keySet()) {
                stringBuffer.append(string).append("=").append(this.a(string)).append(", ");
            }
            stringBuffer.setLength(stringBuffer.length() - 2);
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }

    public String a() {
        return M.c(this.a.m(this.a));
    }

    public Set<String> a() {
        if (this.a == null) {
            return null;
        }
        return this.a.keySet();
    }

    public p a(String string) {
        if (this.a == null || this.a.get(string) == null) {
            return null;
        }
        return ((b)this.a.get((Object)string)).a;
    }

    public Object a(ClassLoader classLoader, f f2) {
        Class<?> clazz = p.a(classLoader, this.a());
        try {
            return c.a(classLoader, clazz, f2, this);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new ClassNotFoundException(clazz.getName(), illegalArgumentException);
        } catch (IllegalAccessError illegalAccessError) {
            throw new ClassNotFoundException(clazz.getName(), illegalAccessError);
        }
    }

    public void a(e e2) {
        String string = this.a.m(this.a);
        if (this.a == null) {
            e2.a(string, 0);
            return;
        }
        e2.a(string, this.a.size());
        for (b b2 : this.a.values()) {
            e2.c(b2.a);
            b2.a.a(e2);
        }
    }

    public int hashCode() {
        return this.a().hashCode() + (this.a == null ? 0 : this.a.hashCode());
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || !(object instanceof a)) {
            return false;
        }
        a a2 = (a)object;
        if (!this.a().equals(a2.a())) {
            return false;
        }
        J j2 = a2.a;
        if (this.a == j2) {
            return true;
        }
        if (this.a == null) {
            return j2 == null;
        }
        if (j2 == null) {
            return false;
        }
        return this.a.equals(j2);
    }
}

