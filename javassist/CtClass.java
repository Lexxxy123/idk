/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.Collection;
import javassist.I;
import javassist.S;
import javassist.a;
import javassist.aa;
import javassist.bytecode.M;
import javassist.bytecode.o;
import javassist.c;
import javassist.expr.e;
import javassist.f;
import javassist.h;
import javassist.m;
import javassist.n;
import javassist.q;
import javassist.r;
import javassist.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class CtClass {
    protected String a;
    public static String b = null;
    public static final String c = "3.27.0-GA";
    static final String d = "java.lang.Object";
    public static CtClass a;
    public static CtClass b;
    public static CtClass c;
    public static CtClass d;
    public static CtClass e;
    public static CtClass f;
    public static CtClass g;
    public static CtClass h;
    public static CtClass i;
    static CtClass[] a;

    public static void main(String[] stringArray) {
        System.out.println("Javassist version 3.27.0-GA");
        System.out.println("Copyright (C) 1999-2020 Shigeru Chiba. All Rights Reserved.");
    }

    protected CtClass(String string) {
        this.a = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.getClass().getName());
        stringBuffer.append("@");
        stringBuffer.append(Integer.toHexString(this.hashCode()));
        stringBuffer.append("[");
        this.a(stringBuffer);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    protected void a(StringBuffer stringBuffer) {
        stringBuffer.append(this.a());
    }

    public f a() {
        return null;
    }

    public o a() {
        this.b();
        return this.b();
    }

    public o b() {
        return null;
    }

    public javassist.compiler.a a() {
        return null;
    }

    public URL a() {
        throw new aa(this.a());
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    public void a() {
    }

    void b() {
        if (this.c()) {
            throw new RuntimeException(this.a() + " class is frozen");
        }
    }

    public void c() {
        throw new RuntimeException("cannot defrost " + this.a());
    }

    public boolean d() {
        return false;
    }

    public boolean a() {
        return false;
    }

    public boolean e() {
        return this.a("kotlin.Metadata");
    }

    public CtClass a() {
        return null;
    }

    public boolean a(CtClass ctClass) {
        return this == ctClass || this.a().equals(ctClass.a());
    }

    public String a() {
        return this.a;
    }

    public final String b() {
        String string = this.a;
        int n2 = string.lastIndexOf(46);
        if (n2 < 0) {
            return string;
        }
        return string.substring(n2 + 1);
    }

    public final String c() {
        String string = this.a;
        int n2 = string.lastIndexOf(46);
        if (n2 < 0) {
            return null;
        }
        return string.substring(0, n2);
    }

    public void a(String string) {
        this.b();
        if (string != null) {
            this.a = string;
        }
    }

    public String d() {
        return null;
    }

    public void b(String string) {
        this.b();
    }

    public void a(String string, String string2) {
        this.b();
    }

    public void a(c c2) {
        this.b();
    }

    public synchronized Collection<String> a() {
        o o2 = this.b();
        if (o2 != null) {
            n n2 = new n(this);
            o2.b(n2);
            return n2.values();
        }
        return null;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public int a() {
        return 0;
    }

    public boolean a(Class<?> clazz) {
        return this.a(clazz.getName());
    }

    public boolean a(String string) {
        return false;
    }

    public Object a(Class<?> clazz) {
        return null;
    }

    public Object[] a() {
        return new Object[0];
    }

    public Object[] b() {
        return new Object[0];
    }

    public CtClass[] b() {
        return this.c();
    }

    public CtClass[] c() {
        return new CtClass[0];
    }

    public void a(int n2) {
        this.b();
    }

    public boolean b(CtClass ctClass) {
        return false;
    }

    public CtClass b() {
        return null;
    }

    public void a(CtClass ctClass) {
        this.b();
    }

    public CtClass[] a() {
        return new CtClass[0];
    }

    public void a(CtClass[] ctClassArray) {
        this.b();
    }

    public void b(CtClass ctClass) {
        this.b();
    }

    public CtClass c() {
        return null;
    }

    @Deprecated
    public final I a() {
        m m2 = this.a();
        if (m2 == null) {
            return null;
        }
        if (m2 instanceof I) {
            return (I)m2;
        }
        throw new aa(m2.a() + " is enclosing " + this.a());
    }

    public m a() {
        return null;
    }

    public CtClass a(String string, boolean bl2) {
        throw new RuntimeException(this.a() + " is not a class");
    }

    public r[] a() {
        return new r[0];
    }

    public r a(String string) {
        return this.a(string, (String)null);
    }

    public r a(String string, String string2) {
        throw new aa(string);
    }

    r b(String string, String string2) {
        return null;
    }

    public r[] b() {
        return new r[0];
    }

    public r b(String string) {
        throw new aa(string);
    }

    public r c(String string, String string2) {
        throw new aa(string);
    }

    public m[] a() {
        return new m[0];
    }

    public q[] a() {
        return new q[0];
    }

    public q a(String string) {
        throw new aa("no such constructor");
    }

    public q[] b() {
        return new q[0];
    }

    public q a(CtClass[] ctClassArray) {
        String string = M.a(ctClassArray);
        return this.a(string);
    }

    public q a() {
        return null;
    }

    public I[] a() {
        return new I[0];
    }

    public I a(String string, String string2) {
        throw new aa(string);
    }

    public I[] b() {
        return new I[0];
    }

    public I a(String string, CtClass[] ctClassArray) {
        throw new aa(string);
    }

    public I[] a(String string) {
        throw new aa(string);
    }

    public I a(String string) {
        throw new aa(string);
    }

    public q b() {
        throw new a("not a class");
    }

    public void a(q q2) {
        this.b();
    }

    public void b(q q2) {
        this.b();
    }

    public void a(I i2) {
        this.b();
    }

    public void b(I i2) {
        this.b();
    }

    public void a(r r2) {
        this.a(r2, (x)null);
    }

    public void a(r r2, String string) {
        this.b();
    }

    public void a(r r2, x x2) {
        this.b();
    }

    public void b(r r2) {
        this.b();
    }

    public byte[] a(String string) {
        return null;
    }

    public void a(String string, byte[] byArray) {
        this.b();
    }

    public void a(h h2) {
        this.b();
    }

    public void a(e e2) {
        this.b();
    }

    public Class<?> a() {
        return this.a().a(this);
    }

    public Class<?> a(Class<?> clazz) {
        return this.a().a(this, clazz);
    }

    public Class<?> a(MethodHandles.Lookup lookup) {
        return this.a().a(this, lookup);
    }

    public Class<?> a(ClassLoader classLoader, ProtectionDomain protectionDomain) {
        f f2 = this.a();
        if (classLoader == null) {
            classLoader = f2.a();
        }
        return f2.a(this, null, classLoader, protectionDomain);
    }

    @Deprecated
    public final Class<?> a(ClassLoader classLoader) {
        return this.a().a(this, null, classLoader, null);
    }

    public void d() {
        f f2 = this.a();
        CtClass ctClass = f2.b(this.a());
        if (ctClass != this) {
            f2.a(this.a(), ctClass, false);
        }
    }

    public boolean a(boolean bl2) {
        return true;
    }

    public void e() {
    }

    void f() {
    }

    public void g() {
    }

    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);){
            this.a(dataOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void h() {
        this.c(".");
    }

    public void c(String string) {
        try (DataOutputStream dataOutputStream = this.a(string);){
            this.a(dataOutputStream);
        }
    }

    protected DataOutputStream a(String string) {
        String string2;
        String string3 = this.a();
        String string4 = string + File.separatorChar + string3.replace('.', File.separatorChar) + ".class";
        int n2 = string4.lastIndexOf(File.separatorChar);
        if (n2 > 0 && !(string2 = string4.substring(0, n2)).equals(".")) {
            new File(string2).mkdirs();
        }
        return new DataOutputStream(new BufferedOutputStream(new javassist.o(string4)));
    }

    public void i() {
        this.d(".");
    }

    public void d(String string) {
        try {
            boolean bl2 = this.a(true);
            this.c(string);
            this.c();
            this.a(bl2);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void a(DataOutputStream dataOutputStream) {
        throw new a("not a class");
    }

    public String a(String string) {
        throw new RuntimeException("not available in " + this.a());
    }

    void j() {
    }

    static {
        a = new CtClass[9];
        CtClass.a[0] = a = new S("boolean", 'Z', "java.lang.Boolean", "booleanValue", "()Z", 172, 4, 1);
        CtClass.a[1] = b = new S("char", 'C', "java.lang.Character", "charValue", "()C", 172, 5, 1);
        CtClass.a[2] = c = new S("byte", 'B', "java.lang.Byte", "byteValue", "()B", 172, 8, 1);
        CtClass.a[3] = d = new S("short", 'S', "java.lang.Short", "shortValue", "()S", 172, 9, 1);
        CtClass.a[4] = e = new S("int", 'I', "java.lang.Integer", "intValue", "()I", 172, 10, 1);
        CtClass.a[5] = f = new S("long", 'J', "java.lang.Long", "longValue", "()J", 173, 11, 2);
        CtClass.a[6] = g = new S("float", 'F', "java.lang.Float", "floatValue", "()F", 174, 6, 1);
        CtClass.a[7] = h = new S("double", 'D', "java.lang.Double", "doubleValue", "()D", 175, 7, 2);
        CtClass.a[8] = i = new S("void", 'V', "java.lang.Void", null, null, 177, 0, 0);
    }
}

