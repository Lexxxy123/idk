/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import javassist.bytecode.at;
import javassist.bytecode.u;

public class n
implements at {
    public static int a(int n2, u u2) {
        int n3;
        return n2 += (n3 = u2.a(n2)) == 201 || n3 == 200 ? u2.e(n2 + 1) : u2.d(n2 + 1);
    }

    public static boolean a(int n2) {
        return n2 >= 153 && n2 <= 168 || n2 == 198 || n2 == 199 || n2 == 201 || n2 == 200;
    }

    public static boolean b(int n2) {
        return n2 == 167 || n2 == 200;
    }

    public static boolean c(int n2) {
        return n2 == 168 || n2 == 201;
    }

    public static boolean d(int n2) {
        return n2 >= 172 && n2 <= 177;
    }
}

