/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.A;
import javassist.B;
import javassist.C;
import javassist.CtClass;
import javassist.D;
import javassist.E;
import javassist.F;
import javassist.bytecode.J;
import javassist.bytecode.n;
import javassist.compiler.ast.b;
import javassist.compiler.f;
import javassist.s;
import javassist.t;
import javassist.v;
import javassist.w;
import javassist.y;
import javassist.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class x {
    public static x a(int n2) {
        return new y(n2);
    }

    public static x a(boolean bl2) {
        return new y(bl2 ? 1 : 0);
    }

    public static x a(long l2) {
        return new z(l2);
    }

    public static x a(float f2) {
        return new w(f2);
    }

    public static x a(double d2) {
        return new v(d2);
    }

    public static x a(String string) {
        return new F(string);
    }

    public static x b(int n2) {
        D d2 = new D();
        d2.a = n2;
        return d2;
    }

    public static x a(CtClass ctClass) {
        C c2 = new C();
        c2.a = ctClass;
        c2.a = null;
        c2.a = false;
        return c2;
    }

    public static x a(CtClass ctClass, String[] stringArray) {
        C c2 = new C();
        c2.a = ctClass;
        c2.a = stringArray;
        c2.a = false;
        return c2;
    }

    public static x b(CtClass ctClass) {
        C c2 = new C();
        c2.a = ctClass;
        c2.a = null;
        c2.a = true;
        return c2;
    }

    public static x b(CtClass ctClass, String[] stringArray) {
        C c2 = new C();
        c2.a = ctClass;
        c2.a = stringArray;
        c2.a = true;
        return c2;
    }

    public static x a(CtClass ctClass, String string) {
        A a2 = new A();
        a2.a = ctClass;
        a2.a = string;
        a2.a = null;
        a2.a = (String)false;
        return a2;
    }

    public static x a(CtClass ctClass, String string, String[] stringArray) {
        A a2 = new A();
        a2.a = ctClass;
        a2.a = string;
        a2.a = stringArray;
        a2.a = (String)false;
        return a2;
    }

    public static x b(CtClass ctClass, String string) {
        A a2 = new A();
        a2.a = ctClass;
        a2.a = string;
        a2.a = null;
        a2.a = (String)true;
        return a2;
    }

    public static x b(CtClass ctClass, String string, String[] stringArray) {
        A a2 = new A();
        a2.a = ctClass;
        a2.a = string;
        a2.a = stringArray;
        a2.a = (String)true;
        return a2;
    }

    public static x a(CtClass ctClass, int n2) {
        return new s(ctClass.a(), n2);
    }

    public static x a(CtClass ctClass, int[] nArray) {
        return new B(ctClass, nArray);
    }

    public static x b(String string) {
        return new t(string);
    }

    static x a(b b2) {
        return new E(b2);
    }

    void a(String string) {
    }

    abstract int a(CtClass var1, String var2, n var3, CtClass[] var4, f var5);

    abstract int a(CtClass var1, String var2, n var3, f var4);

    int a(J j2, CtClass ctClass) {
        return 0;
    }
}

