/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javassist.CtClass;
import javassist.G;
import javassist.H;
import javassist.I;
import javassist.U;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.K;
import javassist.bytecode.M;
import javassist.bytecode.S;
import javassist.bytecode.W;
import javassist.bytecode.Z;
import javassist.bytecode.a;
import javassist.bytecode.al;
import javassist.bytecode.av;
import javassist.bytecode.aw;
import javassist.bytecode.c;
import javassist.bytecode.h;
import javassist.bytecode.i;
import javassist.bytecode.n;
import javassist.bytecode.o;
import javassist.bytecode.r;
import javassist.bytecode.u;
import javassist.expr.e;
import javassist.f;
import javassist.m;
import javassist.q;
import javassist.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class p
extends CtClass {
    f a;
    boolean a;
    private boolean d;
    boolean b;
    boolean c;
    o a;
    byte[] a;
    private Reference<H> a;
    private javassist.compiler.a a;
    private U a;
    private Map<I, String> a;
    private int a;
    private boolean e = javassist.f.b;
    private int b;
    private static final int c = 2;

    p(String string, f f2) {
        super(string);
        this.a = f2;
        this.c = false;
        this.b = false;
        this.d = false;
        this.a = false;
        this.a = null;
        this.a = null;
        this.a = null;
        this.a = null;
        this.a = null;
        this.a = null;
        this.a = 0;
        this.b = 0;
    }

    p(InputStream inputStream, f f2) {
        this((String)null, f2);
        this.a = new o(new DataInputStream(inputStream));
        this.a = this.a.a();
    }

    p(o o2, f f2) {
        this((String)null, f2);
        this.a = o2;
        this.a = this.a.a();
    }

    @Override
    protected void a(StringBuffer stringBuffer) {
        Object object;
        if (this.a) {
            stringBuffer.append("changed ");
        }
        if (this.d) {
            stringBuffer.append("frozen ");
        }
        if (this.b) {
            stringBuffer.append("pruned ");
        }
        stringBuffer.append(javassist.Z.a(this.a()));
        stringBuffer.append(" class ");
        stringBuffer.append(this.a());
        try {
            String string;
            object = this.b();
            if (object != null && !(string = ((CtClass)object).a()).equals("java.lang.Object")) {
                stringBuffer.append(" extends " + ((CtClass)object).a());
            }
        } catch (aa aa2) {
            stringBuffer.append(" extends ??");
        }
        try {
            object = this.a();
            if (((CtClass[])object).length > 0) {
                stringBuffer.append(" implements ");
            }
            for (int i2 = 0; i2 < ((CtClass[])object).length; ++i2) {
                stringBuffer.append(((CtClass)object[i2]).a());
                stringBuffer.append(", ");
            }
        } catch (aa aa3) {
            stringBuffer.append(" extends ??");
        }
        object = this.b();
        this.a(stringBuffer, " fields=", ((H)object).f(), ((H)object).g());
        this.a(stringBuffer, " constructors=", ((H)object).d(), ((H)object).e());
        this.a(stringBuffer, " methods=", ((H)object).b(), ((H)object).c());
    }

    private void a(StringBuffer stringBuffer, String string, G g2, G g3) {
        stringBuffer.append(string);
        while (g2 != g3) {
            g2 = g2.a();
            stringBuffer.append(g2);
            stringBuffer.append(", ");
        }
    }

    @Override
    public javassist.compiler.a a() {
        if (this.a == null) {
            this.a = new javassist.compiler.a(this);
        }
        return this.a;
    }

    @Override
    public o b() {
        return this.a(true);
    }

    public o a(boolean bl2) {
        o o2 = this.a;
        if (o2 != null) {
            return o2;
        }
        if (bl2) {
            this.a.a();
        }
        if (this.a != null) {
            try {
                o o3 = new o(new DataInputStream(new ByteArrayInputStream(this.a)));
                this.a = null;
                this.b = 2;
                return this.a(o3);
            } catch (IOException iOException) {
                throw new RuntimeException(iOException.toString(), iOException);
            }
        }
        InputStream inputStream = null;
        try {
            inputStream = this.a.a(this.a());
            if (inputStream == null) {
                throw new aa(this.a());
            }
            o o4 = new o(new DataInputStream(inputStream = new BufferedInputStream(inputStream)));
            if (!o4.a().equals(this.a)) {
                throw new RuntimeException("cannot find " + (String)((Object)this.a) + ": " + o4.a() + " found in " + ((String)((Object)this.a)).replace('.', '/') + ".class");
            }
            o o5 = this.a(o4);
            return o5;
        } catch (aa aa2) {
            throw new RuntimeException(aa2.toString(), aa2);
        } catch (IOException iOException) {
            throw new RuntimeException(iOException.toString(), iOException);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException iOException) {}
            }
        }
    }

    @Override
    final void f() {
        ++this.b;
    }

    @Override
    void j() {
        if (this.b < 2) {
            if (!this.b() && javassist.f.c) {
                this.l();
            } else if (this.c() && !this.b) {
                this.k();
            }
        }
        this.b = 0;
    }

    private synchronized void k() {
        if (this.a == null || this.a() != null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            this.a.a(dataOutputStream);
            byteArrayOutputStream.close();
            this.a = byteArrayOutputStream.toByteArray();
            this.a = null;
        } catch (IOException iOException) {
            // empty catch block
        }
    }

    private synchronized void l() {
        if (this.a != null && !this.b() && this.a() == null) {
            this.a = null;
        }
    }

    private synchronized o a(o o2) {
        if (this.a == null) {
            this.a = o2;
        }
        return this.a;
    }

    @Override
    public f a() {
        return this.a;
    }

    void a(f f2) {
        this.a = f2;
    }

    @Override
    public URL a() {
        URL uRL = this.a.a(this.a());
        if (uRL == null) {
            throw new aa(this.a());
        }
        return uRL;
    }

    @Override
    public boolean b() {
        return this.a;
    }

    @Override
    public boolean c() {
        return this.d;
    }

    @Override
    public void a() {
        this.d = true;
    }

    @Override
    void b() {
        if (this.c()) {
            String string = this.a() + " class is frozen";
            if (this.b) {
                string = string + " and pruned";
            }
            throw new RuntimeException(string);
        }
        this.a = true;
    }

    @Override
    public void c() {
        this.e("defrost");
        this.d = false;
    }

    @Override
    public boolean a(CtClass ctClass) {
        int n2;
        String string = ctClass.a();
        if (this == ctClass || this.a().equals(string)) {
            return true;
        }
        o o2 = this.b();
        String string2 = o2.b();
        if (string2 != null && string2.equals(string)) {
            return true;
        }
        String[] stringArray = o2.a();
        int n3 = stringArray.length;
        for (n2 = 0; n2 < n3; ++n2) {
            if (!stringArray[n2].equals(string)) continue;
            return true;
        }
        if (string2 != null && this.a.c(string2).a(ctClass)) {
            return true;
        }
        for (n2 = 0; n2 < n3; ++n2) {
            if (!this.a.c(stringArray[n2]).a(ctClass)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void a(String string) {
        String string2 = this.a();
        if (string.equals(string2)) {
            return;
        }
        this.a.c(string);
        o o2 = this.b();
        super.a(string);
        o2.a(string);
        this.m();
        this.a.a(string2, this);
    }

    @Override
    public String d() {
        aw aw2 = (aw)this.b().a("Signature");
        return aw2 == null ? null : aw2.b();
    }

    @Override
    public void b(String string) {
        o o2 = this.a();
        aw aw2 = new aw(o2.a(), string);
        o2.a(aw2);
    }

    @Override
    public void a(javassist.c c2) {
        String string = this.a();
        String string2 = c2.a((Object)M.a(string));
        if (string2 != null) {
            string2 = M.b(string2);
            this.a.c(string2);
        }
        super.a(c2);
        o o2 = this.b();
        o2.a(c2);
        this.m();
        if (string2 != null) {
            super.a(string2);
            this.a.a(string, this);
        }
    }

    @Override
    public void a(String string, String string2) {
        String string3 = this.a();
        if (string3.equals(string)) {
            this.a(string2);
        } else {
            super.a(string, string2);
            this.b().a(string, string2);
            this.m();
        }
    }

    @Override
    public boolean f() {
        return javassist.Z.k(this.a());
    }

    @Override
    public boolean g() {
        return javassist.Z.l(this.a());
    }

    @Override
    public boolean h() {
        return javassist.Z.m(this.a());
    }

    @Override
    public int a() {
        o o2 = this.b();
        int n2 = o2.a();
        n2 = javassist.bytecode.a.a(n2, 32);
        int n3 = o2.b();
        if (n3 != -1) {
            if ((n3 & 8) != 0) {
                n2 |= 8;
            }
            if ((n3 & 1) != 0) {
                n2 |= 1;
            } else {
                n2 &= 0xFFFFFFFE;
                if ((n3 & 4) != 0) {
                    n2 |= 4;
                } else if ((n3 & 2) != 0) {
                    n2 |= 2;
                }
            }
        }
        return javassist.bytecode.a.f(n2);
    }

    @Override
    public CtClass[] c() {
        o o2 = this.b();
        Z z2 = (Z)o2.a("InnerClasses");
        if (z2 == null) {
            return new CtClass[0];
        }
        String string = o2.a() + "$";
        int n2 = z2.a();
        ArrayList<CtClass> arrayList = new ArrayList<CtClass>(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            String string2 = z2.a(i2);
            if (string2 == null || !string2.startsWith(string) || string2.lastIndexOf(36) >= string.length()) continue;
            arrayList.add(this.a.c(string2));
        }
        return arrayList.toArray(new CtClass[arrayList.size()]);
    }

    @Override
    public void a(int n2) {
        this.b();
        p.a(n2, this.a(), this, true);
        o o2 = this.b();
        o2.a(javassist.bytecode.a.e(n2 & 0xFFFFFFF7));
    }

    private static void a(int n2, String string, CtClass ctClass, boolean bl2) {
        o o2 = ctClass.b();
        Z z2 = (Z)o2.a("InnerClasses");
        if (z2 != null) {
            int n3;
            int n4 = n2 & 0xFFFFFFF7;
            int n5 = z2.a(string);
            if (!(n5 < 0 || (n3 = z2.d(n5) & 8) == 0 && javassist.Z.e(n2))) {
                ctClass.b();
                z2.d(n5, javassist.bytecode.a.e(n4) | n3);
                String string2 = z2.b(n5);
                if (string2 != null && bl2) {
                    try {
                        CtClass ctClass2 = ctClass.a().c(string2);
                        p.a(n4, string, ctClass2, false);
                    } catch (aa aa2) {
                        throw new RuntimeException("cannot find the declaring class: " + string2);
                    }
                }
                return;
            }
        }
        if (javassist.Z.e(n2)) {
            throw new RuntimeException("cannot change " + M.b(string) + " into a static class");
        }
    }

    @Override
    public boolean a(String string) {
        o o2 = this.b();
        c c2 = (c)o2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)o2.a("RuntimeVisibleAnnotations");
        return p.a(string, this.a(), c2, c3);
    }

    @Deprecated
    static boolean a(Class<?> clazz, f f2, c c2, c c3) {
        return p.a(clazz.getName(), f2, c2, c3);
    }

    static boolean a(String string, f f2, c c2, c c3) {
        int n2;
        javassist.bytecode.annotation.a[] aArray = c2 == null ? null : c2.a();
        javassist.bytecode.annotation.a[] aArray2 = c3 == null ? null : c3.a();
        if (aArray != null) {
            for (n2 = 0; n2 < aArray.length; ++n2) {
                if (!aArray[n2].a().equals(string)) continue;
                return true;
            }
        }
        if (aArray2 != null) {
            for (n2 = 0; n2 < aArray2.length; ++n2) {
                if (!aArray2[n2].a().equals(string)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object a(Class<?> clazz) {
        o o2 = this.b();
        c c2 = (c)o2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)o2.a("RuntimeVisibleAnnotations");
        return p.a(clazz, this.a(), c2, c3);
    }

    static Object a(Class<?> clazz, f f2, c c2, c c3) {
        int n2;
        javassist.bytecode.annotation.a[] aArray = c2 == null ? null : c2.a();
        javassist.bytecode.annotation.a[] aArray2 = c3 == null ? null : c3.a();
        String string = clazz.getName();
        if (aArray != null) {
            for (n2 = 0; n2 < aArray.length; ++n2) {
                if (!aArray[n2].a().equals(string)) continue;
                return p.a(aArray[n2], f2);
            }
        }
        if (aArray2 != null) {
            for (n2 = 0; n2 < aArray2.length; ++n2) {
                if (!aArray2[n2].a().equals(string)) continue;
                return p.a(aArray2[n2], f2);
            }
        }
        return null;
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
            throw new RuntimeException("Unexpected exception ", classNotFoundException);
        }
    }

    private Object[] a(boolean bl2) {
        o o2 = this.b();
        c c2 = (c)o2.a("RuntimeInvisibleAnnotations");
        c c3 = (c)o2.a("RuntimeVisibleAnnotations");
        return p.a(bl2, this.a(), c2, c3);
    }

    static Object[] a(boolean bl2, f f2, c c2, c c3) {
        int n2;
        int n3;
        javassist.bytecode.annotation.a[] aArray;
        int n4;
        javassist.bytecode.annotation.a[] aArray2;
        if (c2 == null) {
            aArray2 = null;
            n4 = 0;
        } else {
            aArray2 = c2.a();
            n4 = aArray2.length;
        }
        if (c3 == null) {
            aArray = null;
            n3 = 0;
        } else {
            aArray = c3.a();
            n3 = aArray.length;
        }
        if (!bl2) {
            int n5;
            Object[] objectArray = new Object[n4 + n3];
            for (n5 = 0; n5 < n4; ++n5) {
                objectArray[n5] = p.a(aArray2[n5], f2);
            }
            for (n5 = 0; n5 < n3; ++n5) {
                objectArray[n5 + n4] = p.a(aArray[n5], f2);
            }
            return objectArray;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (n2 = 0; n2 < n4; ++n2) {
            try {
                arrayList.add(p.a(aArray2[n2], f2));
                continue;
            } catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
        }
        for (n2 = 0; n2 < n3; ++n2) {
            try {
                arrayList.add(p.a(aArray[n2], f2));
                continue;
            } catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
        }
        return arrayList.toArray();
    }

    static Object[][] a(boolean bl2, f f2, av av2, av av3, al al2) {
        int n2 = 0;
        n2 = av2 != null ? av2.a() : (av3 != null ? av3.a() : M.a(al2.b()));
        Object[][] objectArray = new Object[n2][];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            int n4;
            javassist.bytecode.annotation.a[] aArray;
            int n5;
            javassist.bytecode.annotation.a[] aArray2;
            if (av2 == null) {
                aArray2 = null;
                n5 = 0;
            } else {
                aArray2 = av2.a()[i2];
                n5 = aArray2.length;
            }
            if (av3 == null) {
                aArray = null;
                n4 = 0;
            } else {
                aArray = av3.a()[i2];
                n4 = aArray.length;
            }
            if (!bl2) {
                int n6;
                objectArray[i2] = new Object[n5 + n4];
                for (n6 = 0; n6 < n5; ++n6) {
                    objectArray[i2][n6] = p.a(aArray2[n6], f2);
                }
                for (n6 = 0; n6 < n4; ++n6) {
                    objectArray[i2][n6 + n5] = p.a(aArray[n6], f2);
                }
                continue;
            }
            ArrayList<Object> arrayList = new ArrayList<Object>();
            for (n3 = 0; n3 < n5; ++n3) {
                try {
                    arrayList.add(p.a(aArray2[n3], f2));
                    continue;
                } catch (ClassNotFoundException classNotFoundException) {
                    // empty catch block
                }
            }
            for (n3 = 0; n3 < n4; ++n3) {
                try {
                    arrayList.add(p.a(aArray[n3], f2));
                    continue;
                } catch (ClassNotFoundException classNotFoundException) {
                    // empty catch block
                }
            }
            objectArray[i2] = arrayList.toArray();
        }
        return objectArray;
    }

    private static Object a(javassist.bytecode.annotation.a a2, f f2) {
        try {
            ClassLoader classLoader = f2.a();
            return a2.a(classLoader, f2);
        } catch (ClassNotFoundException classNotFoundException) {
            ClassLoader classLoader = f2.getClass().getClassLoader();
            try {
                return a2.a(classLoader, f2);
            } catch (ClassNotFoundException classNotFoundException2) {
                try {
                    Class<?> clazz = f2.c(a2.a()).a();
                    return javassist.bytecode.annotation.c.a(clazz.getClassLoader(), clazz, f2, a2);
                } catch (Throwable throwable) {
                    throw new ClassNotFoundException(a2.a());
                }
            }
        }
    }

    @Override
    public boolean b(CtClass ctClass) {
        if (ctClass == null) {
            return false;
        }
        String string = ctClass.a();
        try {
            for (CtClass ctClass2 = this; ctClass2 != null; ctClass2 = ((CtClass)ctClass2).b()) {
                if (!ctClass2.a().equals(string)) continue;
                return true;
            }
        } catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    @Override
    public CtClass b() {
        String string = this.b().b();
        if (string == null) {
            return null;
        }
        return this.a.c(string);
    }

    @Override
    public void a(CtClass ctClass) {
        this.b();
        if (this.f()) {
            this.b(ctClass);
        } else {
            this.b().b(ctClass.a());
        }
    }

    @Override
    public CtClass[] a() {
        String[] stringArray = this.b().a();
        int n2 = stringArray.length;
        CtClass[] ctClassArray = new CtClass[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            ctClassArray[i2] = this.a.c(stringArray[i2]);
        }
        return ctClassArray;
    }

    @Override
    public void a(CtClass[] ctClassArray) {
        String[] stringArray;
        this.b();
        if (ctClassArray == null) {
            stringArray = new String[]{};
        } else {
            int n2 = ctClassArray.length;
            stringArray = new String[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                stringArray[i2] = ctClassArray[i2].a();
            }
        }
        this.b().a(stringArray);
    }

    @Override
    public void b(CtClass ctClass) {
        this.b();
        if (ctClass != null) {
            this.b().c(ctClass.a());
        }
    }

    @Override
    public CtClass c() {
        o o2 = this.b();
        Z z2 = (Z)o2.a("InnerClasses");
        if (z2 == null) {
            return null;
        }
        String string = this.a();
        int n2 = z2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string.equals(z2.a(i2))) continue;
            String string2 = z2.b(i2);
            if (string2 != null) {
                return this.a.c(string2);
            }
            S s2 = (S)o2.a("EnclosingMethod");
            if (s2 == null) continue;
            return this.a.c(s2.b());
        }
        return null;
    }

    @Override
    public m a() {
        o o2 = this.b();
        S s2 = (S)o2.a("EnclosingMethod");
        if (s2 == null) {
            return null;
        }
        CtClass ctClass = this.a.c(s2.b());
        String string = s2.c();
        if ("<init>".equals(string)) {
            return ctClass.a(s2.d());
        }
        if ("<clinit>".equals(string)) {
            return ctClass.a();
        }
        return ctClass.a(string, s2.d());
    }

    @Override
    public CtClass a(String string, boolean bl2) {
        if (!bl2) {
            throw new RuntimeException("sorry, only nested static class is supported");
        }
        this.b();
        CtClass ctClass = this.a.h(this.a() + "$" + string);
        o o2 = this.b();
        o o3 = ctClass.b();
        Z z2 = (Z)o2.a("InnerClasses");
        if (z2 == null) {
            z2 = new Z(o2.a());
            o2.a(z2);
        }
        z2.a(ctClass.a(), this.a(), string, o3.a() & 0xFFFFFFDF | 8);
        o3.a(z2.a(o3.a(), null));
        return ctClass;
    }

    private void m() {
        H h2 = this.a();
        if (h2 != null) {
            G g2 = h2.c();
            for (G g3 = h2.b(); g3 != g2; g3 = g3.a()) {
                g3.a();
            }
        }
    }

    protected H a() {
        if (this.a != null) {
            return (H)((Reference)((Object)this.a)).get();
        }
        return null;
    }

    protected synchronized H b() {
        H h2 = null;
        if (this.a == null || (h2 = (H)((Reference)((Object)this.a)).get()) == null) {
            h2 = new H(this);
            this.a(h2);
            this.b(h2);
            this.a = new WeakReference<H>(h2);
        }
        return h2;
    }

    private void a(H h2) {
        List<W> list = this.a(false).a();
        for (W w2 : list) {
            h2.c(new javassist.r(w2, (CtClass)this));
        }
    }

    private void b(H h2) {
        List<al> list = this.a(false).b();
        for (al al2 : list) {
            if (al2.a()) {
                h2.a(new I(al2, this));
                continue;
            }
            h2.b(new q(al2, (CtClass)this));
        }
    }

    @Override
    public javassist.r[] a() {
        ArrayList<G> arrayList = new ArrayList<G>();
        p.a(arrayList, (CtClass)this);
        return arrayList.toArray(new javassist.r[arrayList.size()]);
    }

    private static void a(List<G> list, CtClass ctClass) {
        Object object;
        if (ctClass == null) {
            return;
        }
        try {
            p.a(list, ctClass.b());
        } catch (aa aa2) {
            // empty catch block
        }
        try {
            for (CtClass ctClass2 : object = ctClass.a()) {
                p.a(list, ctClass2);
            }
        } catch (aa aa3) {
            // empty catch block
        }
        object = ((p)ctClass).b();
        Object object2 = ((H)object).f();
        G g2 = ((H)object).g();
        while (object2 != g2) {
            if (javassist.Z.b(((G)(object2 = ((G)object2).a())).a())) continue;
            list.add((G)object2);
        }
    }

    @Override
    public javassist.r a(String string, String string2) {
        javassist.r r2 = this.b(string, string2);
        return this.a(r2, string, string2);
    }

    private javassist.r a(javassist.r r2, String string, String string2) {
        if (r2 == null) {
            String string3 = "field: " + string;
            if (string2 != null) {
                string3 = string3 + " type " + string2;
            }
            throw new aa(string3 + " in " + this.a());
        }
        return r2;
    }

    @Override
    javassist.r b(String string, String string2) {
        javassist.r r2 = this.d(string, string2);
        if (r2 != null) {
            return r2;
        }
        try {
            CtClass[] ctClassArray = this.a();
            for (CtClass ctClass : ctClassArray) {
                javassist.r r3 = ctClass.b(string, string2);
                if (r3 == null) continue;
                return r3;
            }
            CtClass ctClass = this.b();
            if (ctClass != null) {
                return ctClass.b(string, string2);
            }
        } catch (aa aa2) {
            // empty catch block
        }
        return null;
    }

    @Override
    public javassist.r[] b() {
        G g2;
        H h2 = this.b();
        G g3 = h2.g();
        int n2 = H.a(g2, g3);
        javassist.r[] rArray = new javassist.r[n2];
        int n3 = 0;
        for (g2 = h2.f(); g2 != g3; g2 = g2.a()) {
            rArray[n3++] = (javassist.r)g2;
        }
        return rArray;
    }

    @Override
    public javassist.r b(String string) {
        return this.c(string, null);
    }

    @Override
    public javassist.r c(String string, String string2) {
        javassist.r r2 = this.d(string, string2);
        return this.a(r2, string, string2);
    }

    private javassist.r d(String string, String string2) {
        H h2 = this.b();
        G g2 = h2.f();
        G g3 = h2.g();
        while (g2 != g3) {
            if (!(g2 = g2.a()).d().equals(string) || string2 != null && !string2.equals(g2.b())) continue;
            return (javassist.r)g2;
        }
        return null;
    }

    @Override
    public m[] a() {
        G g2;
        H h2 = this.b();
        G g3 = h2.e();
        int n2 = H.a(g2, g3);
        G g4 = h2.b();
        G g5 = h2.c();
        int n3 = H.a(g4, g5);
        m[] mArray = new m[n2 + n3];
        int n4 = 0;
        for (g2 = h2.d(); g2 != g3; g2 = g2.a()) {
            mArray[n4++] = (m)g2;
        }
        while (g4 != g5) {
            g4 = g4.a();
            mArray[n4++] = (m)g4;
        }
        return mArray;
    }

    @Override
    public q[] a() {
        H h2 = this.b();
        G g2 = h2.d();
        G g3 = h2.e();
        int n2 = 0;
        G g4 = g2;
        while (g4 != g3) {
            if (!p.a((q)(g4 = g4.a()))) continue;
            ++n2;
        }
        q[] qArray = new q[n2];
        int n3 = 0;
        g4 = g2;
        while (g4 != g3) {
            q q2 = (q)(g4 = g4.a());
            if (!p.a(q2)) continue;
            qArray[n3++] = q2;
        }
        return qArray;
    }

    private static boolean a(q q2) {
        return !javassist.Z.b(q2.a()) && q2.b();
    }

    @Override
    public q a(String string) {
        H h2 = this.b();
        G g2 = h2.d();
        G g3 = h2.e();
        while (g2 != g3) {
            q q2 = (q)(g2 = g2.a());
            if (!q2.b().b().equals(string) || !q2.b()) continue;
            return q2;
        }
        return super.a(string);
    }

    @Override
    public q[] b() {
        Object object;
        H h2 = this.b();
        G g2 = h2.d();
        G g3 = h2.e();
        int n2 = 0;
        G g4 = g2;
        while (g4 != g3) {
            object = (q)(g4 = g4.a());
            if (!((q)object).b()) continue;
            ++n2;
        }
        object = new q[n2];
        int n3 = 0;
        g4 = g2;
        while (g4 != g3) {
            q q2 = (q)(g4 = g4.a());
            if (!q2.b()) continue;
            object[n3++] = q2;
        }
        return object;
    }

    @Override
    public q a() {
        H h2 = this.b();
        G g2 = h2.d();
        G g3 = h2.e();
        while (g2 != g3) {
            q q2 = (q)(g2 = g2.a());
            if (!q2.c()) continue;
            return q2;
        }
        return null;
    }

    @Override
    public I[] a() {
        HashMap<String, G> hashMap = new HashMap<String, G>();
        p.a(hashMap, (CtClass)this);
        return hashMap.values().toArray(new I[hashMap.size()]);
    }

    private static void a(Map<String, G> map, CtClass ctClass) {
        Object object;
        try {
            for (CtClass ctClass2 : object = ctClass.a()) {
                p.a(map, ctClass2);
            }
        } catch (aa aa2) {
            // empty catch block
        }
        try {
            object = ctClass.b();
            if (object != null) {
                p.a(map, (CtClass)object);
            }
        } catch (aa aa3) {
            // empty catch block
        }
        if (ctClass instanceof p) {
            object = ((p)ctClass).b();
            Object object2 = ((H)object).b();
            G g2 = ((H)object).c();
            while (object2 != g2) {
                if (javassist.Z.b(((G)(object2 = ((G)object2).a())).a())) continue;
                map.put(((I)object2).e(), (G)object2);
            }
        }
    }

    @Override
    public I a(String string, String string2) {
        I i2 = p.a(this, string, string2);
        if (i2 != null) {
            return i2;
        }
        throw new aa(string + "(..) is not found in " + this.a());
    }

    private static I a(CtClass ctClass, String string, String string2) {
        Object object;
        CtClass[] ctClassArray;
        if (ctClass instanceof p) {
            ctClassArray = ((p)ctClass).b();
            object = ctClassArray.b();
            G g2 = ctClassArray.c();
            while (object != g2) {
                if (!((G)(object = ((G)object).a())).d().equals(string) || !((I)object).b().b().equals(string2)) continue;
                return (I)object;
            }
        }
        try {
            ctClassArray = ctClass.b();
            if (ctClassArray != null && (object = p.a((CtClass)ctClassArray, string, string2)) != null) {
                return object;
            }
        } catch (aa aa2) {
            // empty catch block
        }
        try {
            ctClassArray = ctClass.a();
            for (CtClass ctClass2 : ctClassArray) {
                I i2 = p.a(ctClass2, string, string2);
                if (i2 == null) continue;
                return i2;
            }
        } catch (aa aa3) {
            // empty catch block
        }
        return null;
    }

    @Override
    public I[] b() {
        H h2 = this.b();
        G g2 = h2.c();
        ArrayList<G> arrayList = new ArrayList<G>();
        for (G g3 = h2.b(); g3 != g2; g3 = g3.a()) {
            arrayList.add(g3);
        }
        return arrayList.toArray(new I[arrayList.size()]);
    }

    @Override
    public I[] a(String string) {
        H h2 = this.b();
        G g2 = h2.b();
        G g3 = h2.c();
        ArrayList<G> arrayList = new ArrayList<G>();
        while (g2 != g3) {
            if (!(g2 = g2.a()).d().equals(string)) continue;
            arrayList.add(g2);
        }
        return arrayList.toArray(new I[arrayList.size()]);
    }

    @Override
    public I a(String string) {
        H h2 = this.b();
        G g2 = h2.b();
        G g3 = h2.c();
        while (g2 != g3) {
            if (!(g2 = g2.a()).d().equals(string)) continue;
            return (I)g2;
        }
        throw new aa(string + "(..) is not found in " + this.a());
    }

    @Override
    public I a(String string, CtClass[] ctClassArray) {
        String string2 = M.b(ctClassArray);
        H h2 = this.b();
        G g2 = h2.b();
        G g3 = h2.c();
        while (g2 != g3) {
            if (!(g2 = g2.a()).d().equals(string) || !((I)g2).b().b().startsWith(string2)) continue;
            return (I)g2;
        }
        throw new aa(string + "(..) is not found in " + this.a());
    }

    @Override
    public void a(javassist.r r2, String string) {
        this.a(r2, x.b(string));
    }

    @Override
    public void a(javassist.r r2, x x2) {
        Object object;
        this.b();
        if (r2.a() != this) {
            throw new javassist.a("cannot add");
        }
        if (x2 == null) {
            x2 = r2.a();
        }
        if (x2 != null) {
            x2.a(r2.b());
            int n2 = r2.a();
            if (javassist.Z.e(n2) && javassist.Z.f(n2)) {
                try {
                    object = this.b().a();
                    int n3 = x2.a((J)object, r2.b());
                    if (n3 != 0) {
                        r2.b().a(new K((J)object, n3));
                        x2 = null;
                    }
                } catch (aa aa2) {
                    // empty catch block
                }
            }
        }
        this.b().c(r2);
        this.b().a(r2.b());
        if (x2 != null) {
            U u2 = new U(r2, x2);
            object = this.a;
            if (object == null) {
                this.a = u2;
            } else {
                while (((U)object).a != null) {
                    object = ((U)object).a;
                }
                ((U)object).a = u2;
            }
        }
    }

    @Override
    public void b(javassist.r r2) {
        this.b();
        W w2 = r2.b();
        o o2 = this.b();
        if (!o2.a().remove(w2)) {
            throw new aa(r2.toString());
        }
        this.b().d(r2);
        this.c = true;
    }

    @Override
    public q b() {
        m m2 = this.a();
        if (m2 != null) {
            return m2;
        }
        this.b();
        o o2 = this.b();
        n n2 = new n(o2.a(), 0, 0);
        this.a(o2, n2, 0, 0);
        return this.a();
    }

    @Override
    public void a(q q2) {
        this.b();
        if (q2.a() != this) {
            throw new javassist.a("cannot add");
        }
        this.b().b(q2);
        this.b().a(q2.b());
    }

    @Override
    public void b(q q2) {
        this.b();
        al al2 = q2.b();
        o o2 = this.b();
        if (!o2.b().remove(al2)) {
            throw new aa(q2.toString());
        }
        this.b().d(q2);
        this.c = true;
    }

    @Override
    public void a(I i2) {
        this.b();
        if (i2.a() != this) {
            throw new javassist.a("bad declaring class");
        }
        int n2 = i2.a();
        if ((this.a() & 0x200) != 0) {
            if (javassist.Z.c(n2) || javassist.Z.b(n2)) {
                throw new javassist.a("an interface method must be public: " + i2.toString());
            }
            i2.a(n2 | 1);
        }
        this.b().a(i2);
        this.b().a(i2.b());
        if ((n2 & 0x400) != 0) {
            this.a(this.a() | 0x400);
        }
    }

    @Override
    public void b(I i2) {
        this.b();
        al al2 = i2.b();
        o o2 = this.b();
        if (!o2.b().remove(al2)) {
            throw new aa(i2.toString());
        }
        this.b().d(i2);
        this.c = true;
    }

    @Override
    public byte[] a(String string) {
        h h2 = this.b().a(string);
        if (h2 == null) {
            return null;
        }
        return h2.a();
    }

    @Override
    public void a(String string, byte[] byArray) {
        this.b();
        o o2 = this.b();
        o2.a(new h(o2.a(), string, byArray));
    }

    @Override
    public void a(javassist.h h2) {
        this.b();
        o o2 = this.b();
        J j2 = o2.a();
        List<al> list = o2.b();
        for (al al2 : list.toArray(new al[list.size()])) {
            h2.a((CtClass)this, al2, j2);
        }
    }

    @Override
    public void a(e e2) {
        this.b();
        o o2 = this.b();
        List<al> list = o2.b();
        for (al al2 : list.toArray(new al[list.size()])) {
            e2.a(this, al2);
        }
    }

    @Override
    public void e() {
        if (this.b) {
            return;
        }
        this.d = true;
        this.b = true;
        this.b().b();
    }

    @Override
    public void g() {
        this.c = true;
    }

    @Override
    public void a(DataOutputStream dataOutputStream) {
        try {
            if (this.b()) {
                this.e("toBytecode");
                o o2 = this.b();
                if (this.c) {
                    o2.a();
                    this.c = false;
                }
                this.b(o2);
                this.c(o2);
                if (b != null) {
                    this.a(o2);
                }
                o2.a(dataOutputStream);
                dataOutputStream.flush();
                this.a = null;
                if (this.e) {
                    o2.b();
                    this.b = true;
                }
            } else {
                this.a.a(this.a(), dataOutputStream);
            }
            this.b = 0;
            this.d = true;
        } catch (aa aa2) {
            throw new javassist.a(aa2);
        } catch (IOException iOException) {
            throw new javassist.a(iOException);
        }
    }

    private void a(o o2) {
        try (DataOutputStream dataOutputStream = this.a((String)b);){
            o2.a(dataOutputStream);
        }
    }

    private void e(String string) {
        if (this.b) {
            throw new RuntimeException(string + "(): " + this.a() + " was pruned.");
        }
    }

    @Override
    public boolean a(boolean bl2) {
        boolean bl3 = !this.e;
        this.e = !bl2;
        return bl3;
    }

    private void b(o o2) {
        if (this.a == null) {
            return;
        }
        n n2 = new n(o2.a(), 0, 0);
        javassist.compiler.f f2 = new javassist.compiler.f(n2, this);
        int n3 = 0;
        boolean bl2 = false;
        U u2 = this.a;
        while (u2 != null) {
            javassist.r r2 = u2.a;
            if (javassist.Z.e(r2.a())) {
                bl2 = true;
                int n4 = u2.a.a(r2.b(), r2.d(), n2, f2);
                if (n3 < n4) {
                    n3 = n4;
                }
            }
            u2 = u2.a;
        }
        if (bl2) {
            this.a(o2, n2, n3, 0);
        }
    }

    private void a(o o2, n n2, int n3, int n4) {
        Object object;
        al al2 = o2.a();
        if (al2 == null) {
            n2.a(177);
            n2.c(n3);
            n2.d(n4);
            al2 = new al(o2.a(), "<clinit>", "()V");
            al2.a(8);
            al2.a(n2.a());
            o2.a(al2);
            object = this.a();
            if (object != null) {
                ((H)object).b(new q(al2, (CtClass)this));
            }
        } else {
            object = al2.a();
            if (object == null) {
                throw new javassist.a("empty <clinit>");
            }
            try {
                int n5;
                u u2 = ((r)object).a();
                int n6 = u2.b(n2.b());
                u2.a(n2.a(), n6);
                int n7 = ((r)object).a();
                if (n7 < n3) {
                    ((r)object).a(n3);
                }
                if ((n5 = ((r)object).d()) < n4) {
                    ((r)object).b(n4);
                }
            } catch (i i2) {
                throw new javassist.a(i2);
            }
        }
        try {
            al2.a(this.a, o2);
        } catch (i i3) {
            throw new javassist.a(i3);
        }
    }

    private void c(o o2) {
        if (this.a == null) {
            return;
        }
        J j2 = o2.a();
        List<al> list = o2.b();
        for (al al2 : list) {
            r r2;
            if (!al2.b() || (r2 = al2.a()) == null) continue;
            try {
                n n2 = new n(j2, 0, r2.d());
                CtClass[] ctClassArray = M.a(al2.b(), this.a);
                int n3 = this.a(n2, ctClassArray);
                p.a(r2, n2, n3);
                al2.a(this.a, o2);
            } catch (i i2) {
                throw new javassist.a(i2);
            }
        }
    }

    private static void a(r r2, n n2, int n3) {
        u u2 = r2.a();
        int n4 = u2.g();
        if (n4 < 0 && (n4 = u2.h()) >= 0) {
            return;
        }
        int n5 = u2.b(n2.b());
        u2.a(n2.a(), n5);
        int n6 = r2.a();
        if (n6 < n3) {
            r2.a(n3);
        }
    }

    private int a(n n2, CtClass[] ctClassArray) {
        int n3 = 0;
        javassist.compiler.f f2 = new javassist.compiler.f(n2, this);
        try {
            f2.a(ctClassArray, false);
        } catch (javassist.compiler.e e2) {
            throw new javassist.a(e2);
        }
        U u2 = this.a;
        while (u2 != null) {
            int n4;
            javassist.r r2 = u2.a;
            if (!javassist.Z.e(r2.a()) && n3 < (n4 = u2.a.a(r2.b(), r2.d(), n2, ctClassArray, f2))) {
                n3 = n4;
            }
            u2 = u2.a;
        }
        return n3;
    }

    Map<I, String> a() {
        if (this.a == null) {
            this.a = new Hashtable();
        }
        return this.a;
    }

    int b() {
        return this.a++;
    }

    @Override
    public String a(String string) {
        String string2;
        HashMap<Object, p> hashMap = new HashMap<Object, p>();
        this.a(hashMap);
        Set set = hashMap.keySet();
        String[] stringArray = new String[set.size()];
        set.toArray(stringArray);
        if (p.a(string, stringArray)) {
            return string;
        }
        int n2 = 100;
        do {
            if (n2 <= 999) continue;
            throw new RuntimeException("too many unique name");
        } while (!p.a(string2 = string + n2++, stringArray));
        return string2;
    }

    private static boolean a(String string, String[] stringArray) {
        int n2 = stringArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!stringArray[i2].startsWith(string)) continue;
            return false;
        }
        return true;
    }

    private void a(Map<Object, p> map) {
        Object object;
        int n2 = this.a();
        if (javassist.Z.n(n2) || javassist.Z.k(n2)) {
            try {
                for (Object object2 : object = this.a()) {
                    if (object2 == null || !(object2 instanceof p)) continue;
                    ((p)object2).a(map);
                }
            } catch (aa aa2) {
                // empty catch block
            }
        }
        try {
            object = this.b();
            if (object != null && object instanceof p) {
                ((p)object).a(map);
            }
        } catch (aa aa3) {
            // empty catch block
        }
        object = this.b().b();
        Object object3 = object.iterator();
        while (object3.hasNext()) {
            al al2 = (al)object3.next();
            map.put(al2.a(), this);
        }
        object3 = this.b().a();
        Iterator iterator = object3.iterator();
        while (iterator.hasNext()) {
            W w2 = (W)iterator.next();
            map.put(w2.a(), this);
        }
    }
}

