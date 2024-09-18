/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import java.util.List;
import javassist.CtClass;
import javassist.G;
import javassist.a;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.W;
import javassist.bytecode.aw;
import javassist.bytecode.c;
import javassist.bytecode.h;
import javassist.bytecode.o;
import javassist.compiler.ast.b;
import javassist.compiler.e;
import javassist.compiler.f;
import javassist.p;
import javassist.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class r
extends G {
    static final String a = "java.lang.String";
    protected W a;

    public r(CtClass ctClass, String string, CtClass ctClass2) {
        this(M.b(ctClass), string, ctClass2);
    }

    public r(r r2, CtClass ctClass) {
        this(r2.a.b(), r2.a.a(), ctClass);
        W w2 = this.a;
        w2.a(r2.a.a());
        J j2 = w2.a();
        List<h> list = r2.a.a();
        for (h h2 : list) {
            w2.a(h2.a(j2, null));
        }
    }

    private r(String string, String string2, CtClass ctClass) {
        super(ctClass);
        o o2 = ctClass.b();
        if (o2 == null) {
            throw new a("bad declaring class: " + ctClass.a());
        }
        this.a = new W(o2.a(), string2, string);
    }

    r(W w2, CtClass ctClass) {
        super(ctClass);
        this.a = w2;
    }

    @Override
    public String toString() {
        return this.a().a() + "." + this.d() + ":" + this.a.b();
    }

    @Override
    protected void a(StringBuffer stringBuffer) {
        stringBuffer.append(' ');
        stringBuffer.append(this.d());
        stringBuffer.append(' ');
        stringBuffer.append(this.a.b());
    }

    protected b a() {
        return null;
    }

    x a() {
        b b2 = this.a();
        if (b2 == null) {
            return null;
        }
        return x.a(b2);
    }

    public static r a(String string, CtClass ctClass) {
        f f2 = new f(ctClass);
        try {
            G g2 = f2.a(string);
            if (g2 instanceof r) {
                return (r)g2;
            }
        } catch (e e2) {
            throw new a(e2);
        }
        throw new a("not a field");
    }

    public W a() {
        ((CtClass)((Object)this.a)).b();
        return this.a;
    }

    public W b() {
        return this.a;
    }

    @Override
    public CtClass a() {
        return super.a();
    }

    @Override
    public String d() {
        return this.a.a();
    }

    public void b(String string) {
        ((CtClass)((Object)this.a)).b();
        this.a.a(string);
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
        W w2 = this.b();
        c c2 = (c)w2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)w2.a("RuntimeVisibleAnnotations");
        return p.a(string, this.a().a(), c2, c3);
    }

    @Override
    public Object a(Class<?> clazz) {
        W w2 = this.b();
        c c2 = (c)w2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)w2.a("RuntimeVisibleAnnotations");
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
        W w2 = this.b();
        c c2 = (c)w2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)w2.a("RuntimeVisibleAnnotations");
        return p.a(bl2, this.a().a(), c2, c3);
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

    public CtClass b() {
        return M.b(this.a.b(), ((CtClass)((Object)this.a)).a());
    }

    public void a(CtClass ctClass) {
        ((CtClass)((Object)this.a)).b();
        this.a.b(M.b(ctClass));
    }

    public Object a() {
        int n2 = this.a.b();
        if (n2 == 0) {
            return null;
        }
        J j2 = this.a.a();
        switch (j2.a(n2)) {
            case 5: {
                return j2.a(n2);
            }
            case 4: {
                return Float.valueOf(j2.a(n2));
            }
            case 6: {
                return j2.a(n2);
            }
            case 3: {
                int n3 = j2.l(n2);
                if ("Z".equals(this.a.b())) {
                    return n3 != 0;
                }
                return n3;
            }
            case 8: {
                return j2.l(n2);
            }
        }
        throw new RuntimeException("bad tag: " + j2.a(n2) + " at " + n2);
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
}

