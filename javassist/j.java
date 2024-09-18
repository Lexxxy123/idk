/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.K;
import javassist.L;
import javassist.M;
import javassist.bytecode.n;

public class J {
    public static J a(int n2) {
        return new K(n2);
    }

    public static J a(long l2) {
        return new L(l2);
    }

    public static J a(String string) {
        return new M(string);
    }

    J() {
    }

    int a(n n2) {
        return 0;
    }

    String a() {
        return J.b();
    }

    static String b() {
        return "([Ljava/lang/Object;)Ljava/lang/Object;";
    }

    String c() {
        return J.d();
    }

    static String d() {
        return "([Ljava/lang/Object;)V";
    }
}

