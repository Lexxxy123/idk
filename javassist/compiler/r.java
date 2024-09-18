/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javassist.CtClass;
import javassist.Z;
import javassist.aa;
import javassist.bytecode.M;
import javassist.bytecode.al;
import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.i;
import javassist.compiler.ast.o;
import javassist.compiler.ast.v;
import javassist.compiler.e;
import javassist.compiler.s;
import javassist.compiler.t;
import javassist.compiler.z;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class r
implements z {
    private f a;
    private static final int a = 0;
    private static final int b = -1;
    private static final String a = "<invalid>";
    private static Map<f, Reference<Map<String, String>>> a;
    private Map<String, String> b = (int)null;

    public r(f f2) {
        this.a = f2;
    }

    public f a() {
        return this.a;
    }

    private static void a() {
        throw new e("fatal");
    }

    public s a(CtClass ctClass, CtClass ctClass2, al al2, String string, int[] nArray, int[] nArray2, String[] stringArray) {
        s s2;
        int n2;
        s s3 = null;
        if (al2 != null && ctClass == ctClass2 && al2.a().equals(string) && (n2 = this.a(al2.b(), nArray, nArray2, stringArray)) != -1) {
            s s4 = new s(ctClass, al2, n2);
            if (n2 == 0) {
                return s4;
            }
            s3 = s4;
        }
        if ((s2 = this.a(ctClass, string, nArray, nArray2, stringArray, s3 != null)) != null) {
            return s2;
        }
        return s3;
    }

    private s a(CtClass ctClass, String string, int[] nArray, int[] nArray2, String[] stringArray, boolean bl2) {
        s s2 = null;
        javassist.bytecode.o o2 = ctClass.b();
        if (o2 != null) {
            List<al> list = o2.b();
            for (al object2 : list) {
                int n2;
                if (!object2.a().equals(string) || (object2.a() & 0x40) != 0 || (n2 = this.a(object2.b(), nArray, nArray2, stringArray)) == -1) continue;
                s s3 = new s(ctClass, object2, n2);
                if (n2 == 0) {
                    return s3;
                }
                if (s2 != null && s2.a <= n2) continue;
                s2 = s3;
            }
        }
        if (bl2) {
            s2 = null;
        } else if (s2 != null) {
            return s2;
        }
        int n3 = ctClass.a();
        boolean bl3 = Z.k(n3);
        try {
            s s4;
            CtClass aa2;
            if (!bl3 && (aa2 = ctClass.b()) != null && (s4 = this.a(aa2, string, nArray, nArray2, stringArray, bl2)) != null) {
                return s4;
            }
        } catch (aa aa2) {
            // empty catch block
        }
        try {
            s s5;
            CtClass[] ctClassArray;
            Object object = ctClassArray = ctClass.a();
            int n4 = ((CtClass[])object).length;
            for (int i2 = 0; i2 < n4; ++i2) {
                CtClass ctClass2 = object[i2];
                s s6 = this.a(ctClass2, string, nArray, nArray2, stringArray, bl2);
                if (s6 == null) continue;
                return s6;
            }
            if (bl3 && (object = ctClass.b()) != null && (s5 = this.a((CtClass)object, string, nArray, nArray2, stringArray, bl2)) != null) {
                return s5;
            }
        } catch (aa aa3) {
            // empty catch block
        }
        return s2;
    }

    private int a(String string, int[] nArray, int[] nArray2, String[] stringArray) {
        int n2 = 0;
        int n3 = 1;
        int n4 = nArray.length;
        if (n4 != M.a(string)) {
            return -1;
        }
        int n5 = string.length();
        int n6 = 0;
        while (n3 < n5) {
            int n7;
            char c2;
            if ((c2 = string.charAt(n3++)) == ')') {
                return n6 == n4 ? n2 : -1;
            }
            if (n6 >= n4) {
                return -1;
            }
            int n8 = 0;
            while (c2 == '[') {
                ++n8;
                c2 = string.charAt(n3++);
            }
            if (nArray[n6] == 412) {
                if (n8 == 0 && c2 != 'L') {
                    return -1;
                }
                if (c2 == 'L') {
                    n3 = string.indexOf(59, n3) + 1;
                }
            } else if (nArray2[n6] != n8) {
                if (n8 != 0 || c2 != 'L' || !string.startsWith("java/lang/Object;", n3)) {
                    return -1;
                }
                n3 = string.indexOf(59, n3) + 1;
                ++n2;
                if (n3 <= 0) {
                    return -1;
                }
            } else if (c2 == 'L') {
                block23: {
                    n7 = string.indexOf(59, n3);
                    if (n7 < 0 || nArray[n6] != 307) {
                        return -1;
                    }
                    String string2 = string.substring(n3, n7);
                    if (!string2.equals(stringArray[n6])) {
                        CtClass ctClass = this.a(stringArray[n6]);
                        try {
                            if (ctClass.a(this.a(string2))) {
                                ++n2;
                                break block23;
                            }
                            return -1;
                        } catch (aa aa2) {
                            ++n2;
                        }
                    }
                }
                n3 = n7 + 1;
            } else {
                int n9;
                n7 = r.a(c2);
                if (n7 != (n9 = nArray[n6])) {
                    if (n7 == 324 && (n9 == 334 || n9 == 303 || n9 == 306)) {
                        ++n2;
                    } else {
                        return -1;
                    }
                }
            }
            ++n6;
        }
        return -1;
    }

    public javassist.r a(String string, v v2, b b2) {
        String string2 = v2.b();
        CtClass ctClass = null;
        try {
            ctClass = this.a(r.c(string), true);
        } catch (e e2) {
            throw new t(string + "/" + string2, b2);
        }
        try {
            return ctClass.a(string2);
        } catch (aa aa2) {
            string = r.b(ctClass.a());
            throw new t(string + "$" + string2, b2);
        }
    }

    public javassist.r a(String string, v v2) {
        return this.b(r.c(string), v2);
    }

    public javassist.r b(String string, v v2) {
        CtClass ctClass = this.a(string, false);
        try {
            return ctClass.a(v2.b());
        } catch (aa aa2) {
            throw new e("no such field: " + v2.b());
        }
    }

    public CtClass a(a a2) {
        return this.a(i.a(a2, '.'), false);
    }

    public CtClass a(String string) {
        return this.a(r.c(string), false);
    }

    public CtClass a(i i2) {
        return this.a(i2.b(), i2.c(), i2.b());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public CtClass a(int n2, int n3, String string) {
        String string2 = "";
        if (n2 == 307) {
            CtClass ctClass = this.a(string);
            if (n3 <= 0) return ctClass;
            string2 = ctClass.a();
        } else {
            string2 = r.a(n2);
        }
        while (n3-- > 0) {
            string2 = string2 + "[]";
        }
        return this.a(string2, false);
    }

    static String a(int n2) {
        String string = "";
        switch (n2) {
            case 301: {
                string = "boolean";
                break;
            }
            case 306: {
                string = "char";
                break;
            }
            case 303: {
                string = "byte";
                break;
            }
            case 334: {
                string = "short";
                break;
            }
            case 324: {
                string = "int";
                break;
            }
            case 326: {
                string = "long";
                break;
            }
            case 317: {
                string = "float";
                break;
            }
            case 312: {
                string = "double";
                break;
            }
            case 344: {
                string = "void";
                break;
            }
            default: {
                r.a();
            }
        }
        return string;
    }

    public CtClass a(String string, boolean bl2) {
        Map<String, String> map = this.a();
        String string2 = map.get(string);
        if (string2 == a) {
            throw new e("no such class: " + string);
        }
        if (string2 != null) {
            try {
                return this.a.c(string2);
            } catch (aa aa2) {
                // empty catch block
            }
        }
        CtClass ctClass = null;
        try {
            ctClass = this.b(string, bl2);
        } catch (aa aa3) {
            ctClass = this.b(string);
        }
        map.put(string, ctClass.a());
        return ctClass;
    }

    public static int a() {
        return a.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Map<String, String> a() {
        Object object = this.b;
        if (object != null) return object;
        Class<r> clazz = r.class;
        synchronized (r.class) {
            Reference reference = (Reference)a.get(this.a);
            if (reference != null) {
                object = (Map)reference.get();
            }
            if (object == null) {
                object = new Hashtable();
                a.put(this.a, new WeakReference<int>((int)object));
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            this.b = object;
            return object;
        }
    }

    private CtClass b(String string) {
        if (string.indexOf(46) < 0) {
            Iterator<String> iterator = this.a.a();
            while (iterator.hasNext()) {
                String string2 = iterator.next();
                String string3 = string2.replaceAll("\\.$", "") + "." + string;
                try {
                    return this.a.c(string3);
                } catch (aa aa2) {
                    try {
                        if (!string2.endsWith("." + string)) continue;
                        return this.a.c(string2);
                    } catch (aa aa3) {
                    }
                }
            }
        }
        this.a().put(string, a);
        throw new e("no such class: " + string);
    }

    private CtClass b(String string, boolean bl2) {
        CtClass ctClass = null;
        do {
            try {
                ctClass = this.a.c(string);
            } catch (aa aa2) {
                int n2 = string.lastIndexOf(46);
                if (bl2 || n2 < 0) {
                    throw aa2;
                }
                StringBuffer stringBuffer = new StringBuffer(string);
                stringBuffer.setCharAt(n2, '$');
                string = stringBuffer.toString();
            }
        } while (ctClass == null);
        return ctClass;
    }

    public String a(a a2) {
        if (a2 == null) {
            return null;
        }
        return r.b(this.a(a2).a());
    }

    public String a(String string) {
        if (string == null) {
            return null;
        }
        return r.b(this.a(string).a());
    }

    public static CtClass a(CtClass ctClass) {
        try {
            CtClass ctClass2 = ctClass.b();
            if (ctClass2 != null) {
                return ctClass2;
            }
        } catch (aa aa2) {
            // empty catch block
        }
        throw new e("cannot find the super class of " + ctClass.a());
    }

    public static CtClass a(CtClass ctClass, String string) {
        try {
            CtClass[] ctClassArray = ctClass.a();
            for (int i2 = 0; i2 < ctClassArray.length; ++i2) {
                if (!ctClassArray[i2].a().equals(string)) continue;
                return ctClassArray[i2];
            }
        } catch (aa aa2) {
            // empty catch block
        }
        throw new e("cannot find the super interface " + string + " of " + ctClass.a());
    }

    public static String b(String string) {
        return string.replace('.', '/');
    }

    public static String c(String string) {
        return string.replace('/', '.');
    }

    public static int a(char c2) {
        switch (c2) {
            case 'Z': {
                return 301;
            }
            case 'C': {
                return 306;
            }
            case 'B': {
                return 303;
            }
            case 'S': {
                return 334;
            }
            case 'I': {
                return 324;
            }
            case 'J': {
                return 326;
            }
            case 'F': {
                return 317;
            }
            case 'D': {
                return 312;
            }
            case 'V': {
                return 344;
            }
            case 'L': 
            case '[': {
                return 307;
            }
        }
        r.a();
        return 344;
    }

    public static int a(a b2) {
        int n2 = 0;
        while (b2 != null) {
            o o2 = (o)b2.c();
            b2 = b2.a();
            switch (o2.a()) {
                case 335: {
                    n2 |= 8;
                    break;
                }
                case 315: {
                    n2 |= 0x10;
                    break;
                }
                case 338: {
                    n2 |= 0x20;
                    break;
                }
                case 300: {
                    n2 |= 0x400;
                    break;
                }
                case 332: {
                    n2 |= 1;
                    break;
                }
                case 331: {
                    n2 |= 4;
                    break;
                }
                case 330: {
                    n2 |= 2;
                    break;
                }
                case 345: {
                    n2 |= 0x40;
                    break;
                }
                case 342: {
                    n2 |= 0x80;
                    break;
                }
                case 347: {
                    n2 |= 0x800;
                }
            }
        }
        return n2;
    }

    static {
        a = new WeakHashMap();
    }
}

