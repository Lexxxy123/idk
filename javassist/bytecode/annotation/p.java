/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.lang.reflect.Method;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.annotation.e;
import javassist.bytecode.annotation.q;
import javassist.bytecode.annotation.r;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class p {
    J a;
    char a;

    p(char c2, J j2) {
        this.a = j2;
        this.a = c2;
    }

    abstract Object a(ClassLoader var1, f var2, Method var3);

    abstract Class<?> a(ClassLoader var1);

    static Class<?> a(ClassLoader classLoader, String string) {
        try {
            return Class.forName(p.a(string), true, classLoader);
        } catch (LinkageError linkageError) {
            throw new r(string, linkageError);
        }
    }

    private static String a(String string) {
        int n2 = string.indexOf("[]");
        if (n2 != -1) {
            String string2 = string.substring(0, n2);
            StringBuffer stringBuffer = new StringBuffer(M.d(string2));
            while (n2 != -1) {
                stringBuffer.insert(0, "[");
                n2 = string.indexOf("[]", n2 + 1);
            }
            return stringBuffer.toString().replace('/', '.');
        }
        return string;
    }

    public abstract void a(q var1);

    public abstract void a(e var1);
}

