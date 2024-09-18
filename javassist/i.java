/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.J;
import javassist.P;
import javassist.R;
import javassist.a;
import javassist.aa;
import javassist.bytecode.M;
import javassist.bytecode.al;
import javassist.bytecode.i;
import javassist.bytecode.n;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.c;
import javassist.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class I
extends m {
    protected String a = null;

    I(al al2, CtClass ctClass) {
        super(ctClass, al2);
    }

    public I(CtClass ctClass, String string, CtClass[] ctClassArray, CtClass ctClass2) {
        this(null, ctClass2);
        javassist.bytecode.J j2 = ctClass2.b().a();
        String string2 = M.a(ctClass, ctClassArray);
        this.a = new al(j2, string, string2);
        this.a(1025);
    }

    public I(I i2, CtClass ctClass, c c2) {
        this(null, ctClass);
        this.a(i2, false, c2);
    }

    public static I a(String string, CtClass ctClass) {
        return P.a(string, ctClass);
    }

    public static I a(al al2, CtClass ctClass) {
        if (ctClass.b().a() != al2.a()) {
            throw new a("bad declaring class");
        }
        return new I(al2, ctClass);
    }

    public int hashCode() {
        return this.e().hashCode();
    }

    @Override
    void a() {
        this.a = null;
    }

    final String e() {
        if (this.a == null) {
            this.a = ((al)((Object)this.a)).a() + M.e(((al)((Object)this.a)).b());
        }
        return this.a;
    }

    public boolean equals(Object object) {
        return object != null && object instanceof I && ((I)object).e().equals(this.e());
    }

    @Override
    public String a() {
        return this.a().a() + "." + this.d() + M.f(this.b());
    }

    @Override
    public String d() {
        return ((al)((Object)this.a)).a();
    }

    public void f(String string) {
        ((CtClass)((Object)this.a)).b();
        ((al)((Object)this.a)).a(string);
    }

    public CtClass b() {
        return this.a_();
    }

    @Override
    public boolean a() {
        r r2 = this.b().a();
        if (r2 == null) {
            return (this.a() & 0x400) != 0;
        }
        u u2 = r2.a();
        try {
            return u2.a() && u2.a(u2.d()) == 177 && !u2.a();
        } catch (i i2) {
            return false;
        }
    }

    public void a(I i2, c c2) {
        I.a((CtClass)((Object)i2.a), (al)((Object)i2.a), (CtClass)((Object)this.a), (al)((Object)this.a), c2);
    }

    public void a(I i2, J j2) {
        CtClass ctClass;
        CtClass[] ctClassArray;
        ((CtClass)((Object)this.a)).b();
        CtClass ctClass2 = this.a();
        try {
            ctClassArray = this.a();
            ctClass = this.b();
        } catch (aa aa2) {
            throw new a(aa2);
        }
        n n2 = R.a(ctClass2, ctClass2.b(), i2, ctClassArray, ctClass, j2);
        r r2 = n2.a();
        ((al)((Object)this.a)).a(r2);
        ((al)((Object)this.a)).a(((al)((Object)this.a)).a() & 0xFFFFFBFF);
    }
}

