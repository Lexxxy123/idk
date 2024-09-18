/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import java.util.HashMap;
import javassist.CtClass;
import javassist.bytecode.M;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c
extends HashMap<String, String> {
    private static final long a = 1L;
    private c a;

    public c() {
        this.a = null;
    }

    c(c c2) {
        this.a = c2;
    }

    public void a(CtClass ctClass, CtClass ctClass2) {
        this.a(ctClass.a(), ctClass2.a());
    }

    public String a(String string, String string2) {
        if (string == string2) {
            return string;
        }
        String string3 = c.a(string);
        String string4 = this.a((Object)string3);
        if (string4 == null || !string4.equals(string3)) {
            return super.put(string3, c.a(string2));
        }
        return string4;
    }

    public void a(String string, String string2) {
        if (string == string2) {
            return;
        }
        String string3 = c.a(string);
        String string4 = this.a((Object)string3);
        if (string4 == null) {
            super.put(string3, c.a(string2));
        }
    }

    protected final String b(String string, String string2) {
        return super.put(string, string2);
    }

    public String a(Object object) {
        String string = (String)super.get(object);
        if (string == null && this.a != null) {
            return this.a.a(object);
        }
        return string;
    }

    public void a(CtClass ctClass) {
        this.a(ctClass.a());
    }

    public void a(String string) {
        String string2 = c.a(string);
        super.put(string2, string2);
    }

    public static String a(String string) {
        return M.a(string);
    }

    public static String b(String string) {
        return M.b(string);
    }

    @Override
    public /* synthetic */ Object put(Object object, Object object2) {
        return this.a((String)object, (String)object2);
    }

    @Override
    public /* synthetic */ Object get(Object object) {
        return this.a(object);
    }
}

