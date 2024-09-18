/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import javassist.CtClass;
import javassist.aa;
import javassist.bytecode.analysis.i;
import javassist.bytecode.analysis.j;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class m {
    private final CtClass a;
    private final boolean a;
    private static final Map<CtClass, m> a;
    public static final m a;
    public static final m b;
    public static final m c;
    public static final m d;
    public static final m e;
    public static final m f;
    public static final m g;
    public static final m h;
    public static final m i;
    public static final m j;
    public static final m k;
    public static final m l;
    public static final m m;
    public static final m n;
    public static final m o;
    public static final m p;
    public static final m q;

    public static m a(CtClass ctClass) {
        m m2 = (m)a.get(ctClass);
        return m2 != null ? m2 : new m(ctClass);
    }

    private static m a(String string) {
        try {
            return new m(javassist.f.a().c(string));
        } catch (aa aa2) {
            throw new RuntimeException(aa2);
        }
    }

    m(CtClass ctClass) {
        this(ctClass, false);
    }

    private m(CtClass ctClass, boolean bl2) {
        this.a = ctClass;
        this.a = bl2;
    }

    boolean a() {
        return false;
    }

    public int b() {
        return this.a == CtClass.h || this.a == CtClass.f || this == l ? 2 : 1;
    }

    public CtClass a() {
        return this.a;
    }

    public boolean c() {
        return !this.a && (this.a == null || !this.a.d());
    }

    public boolean d() {
        return this.a;
    }

    public boolean b() {
        return this.a != null && this.a.a();
    }

    public int a() {
        if (!this.b()) {
            return 0;
        }
        String string = this.a.a();
        int n2 = string.length() - 1;
        int n3 = 0;
        while (string.charAt(n2) == ']') {
            n2 -= 2;
            ++n3;
        }
        return n3;
    }

    public m a() {
        CtClass ctClass;
        if (this.a == null || !this.a.a()) {
            return null;
        }
        try {
            ctClass = this.a.a();
        } catch (aa aa2) {
            throw new RuntimeException(aa2);
        }
        m m2 = (m)a.get(ctClass);
        return m2 != null ? m2 : new m(ctClass);
    }

    public boolean a(m m2) {
        if (this == m2) {
            return true;
        }
        if (m2 == j && this.c() || this == j && m2.c()) {
            return true;
        }
        if (m2 instanceof j) {
            return ((j)m2).b(this);
        }
        if (m2 instanceof i) {
            return ((i)m2).b(this);
        }
        if (this.a == null || this.a.d()) {
            return false;
        }
        try {
            return m2.a.a(this.a);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public m a(m m2) {
        if (m2 == this) {
            return this;
        }
        if (m2 == null) {
            return this;
        }
        if (m2 == j) {
            return this;
        }
        if (this == j) {
            return m2;
        }
        if (!m2.c() || !this.c()) {
            return m;
        }
        if (m2 instanceof j) {
            return m2.a(this);
        }
        if (m2.b() && this.b()) {
            return this.c(m2);
        }
        try {
            return this.d(m2);
        } catch (aa aa2) {
            throw new RuntimeException(aa2);
        }
    }

    m b(m m2) {
        while (m2.b()) {
            m2 = m2.a();
        }
        return m2;
    }

    private m a(m m2, int n2) {
        m m3;
        if (m2 instanceof j) {
            return new i((j)m2, n2);
        }
        String string = this.a(m2.a.a(), n2);
        try {
            m3 = javassist.bytecode.analysis.m.a(this.a(m2).c(string));
        } catch (aa aa2) {
            throw new RuntimeException(aa2);
        }
        return m3;
    }

    String a(String string, int n2) {
        int n3 = string.length();
        int n4 = n3 + n2 * 2;
        char[] cArray = new char[n4];
        string.getChars(0, n3, cArray, 0);
        while (n3 < n4) {
            cArray[n3++] = 91;
            cArray[n3++] = 93;
        }
        string = new String(cArray);
        return string;
    }

    private f a(m m2) {
        f f2 = m2.a.a();
        return f2 != null ? f2 : javassist.f.a();
    }

    private m c(m m2) {
        int n2;
        m m3;
        int n3;
        m m4 = this.b(m2);
        m m5 = this.b(this);
        int n4 = m2.a();
        if (n4 == (n3 = this.a())) {
            m m6 = m5.a(m4);
            if (m6 == m) {
                return n;
            }
            return this.a(m6, n3);
        }
        if (n4 < n3) {
            m3 = m4;
            n2 = n4;
        } else {
            m3 = m5;
            n2 = n3;
        }
        if (javassist.bytecode.analysis.m.a(javassist.bytecode.analysis.m.p.a, m3.a) || javassist.bytecode.analysis.m.a(javassist.bytecode.analysis.m.o.a, m3.a)) {
            return this.a(m3, n2);
        }
        return this.a(n, n2);
    }

    private static CtClass a(CtClass ctClass, CtClass ctClass2) {
        CtClass ctClass3;
        CtClass ctClass4 = ctClass;
        CtClass ctClass5 = ctClass3 = ctClass2;
        CtClass ctClass6 = ctClass4;
        while (true) {
            if (javassist.bytecode.analysis.m.a(ctClass4, ctClass3) && ctClass4.b() != null) {
                return ctClass4;
            }
            CtClass ctClass7 = ctClass4.b();
            CtClass ctClass8 = ctClass3.b();
            if (ctClass8 == null) {
                ctClass3 = ctClass5;
                break;
            }
            if (ctClass7 == null) {
                ctClass4 = ctClass6;
                ctClass6 = ctClass5;
                ctClass5 = ctClass4;
                ctClass4 = ctClass3;
                ctClass3 = ctClass5;
                break;
            }
            ctClass4 = ctClass7;
            ctClass3 = ctClass8;
        }
        while ((ctClass4 = ctClass4.b()) != null) {
            ctClass6 = ctClass6.b();
        }
        ctClass4 = ctClass6;
        while (!javassist.bytecode.analysis.m.a(ctClass4, ctClass3)) {
            ctClass4 = ctClass4.b();
            ctClass3 = ctClass3.b();
        }
        return ctClass4;
    }

    private m d(m m2) {
        CtClass ctClass = javassist.bytecode.analysis.m.a(this.a, m2.a);
        if (ctClass.b() == null) {
            Map<String, CtClass> map = this.a(m2);
            if (map.size() == 1) {
                return new m(map.values().iterator().next());
            }
            if (map.size() > 1) {
                return new j(map);
            }
            return new m(ctClass);
        }
        Map<String, CtClass> map = this.a(m2, ctClass);
        if (map.size() > 0) {
            return new j(map, new m(ctClass));
        }
        return new m(ctClass);
    }

    private Map<String, CtClass> a(m m2) {
        Map<String, CtClass> map = this.a(m2.a, null);
        Map<String, CtClass> map2 = this.a(this.a, null);
        return this.a(map, map2);
    }

    private Map<String, CtClass> a(m m2, CtClass ctClass) {
        Map<String, CtClass> map = this.b(m2.a, null);
        Map<String, CtClass> map2 = this.b(this.a, null);
        Map<String, CtClass> map3 = this.a(ctClass, null);
        for (String string : map3.keySet()) {
            map.remove(string);
            map2.remove(string);
        }
        return this.a(map, map2);
    }

    Map<String, CtClass> a(Map<String, CtClass> map, Map<String, CtClass> map2) {
        if (map2 == null) {
            map2 = new HashMap<String, CtClass>();
        }
        if (map == null || map.isEmpty()) {
            map2.clear();
        }
        for (String object : map2.keySet()) {
            if (map.containsKey(object)) continue;
            map2.remove(object);
        }
        for (CtClass ctClass : map2.values()) {
            CtClass[] ctClassArray;
            try {
                ctClassArray = ctClass.a();
            } catch (aa aa2) {
                throw new RuntimeException(aa2);
            }
            for (CtClass ctClass2 : ctClassArray) {
                map2.remove(ctClass2.a());
            }
        }
        return map2;
    }

    Map<String, CtClass> a(CtClass ctClass, Map<String, CtClass> map) {
        if (map == null) {
            map = new HashMap<String, CtClass>();
        }
        if (ctClass.f()) {
            map.put(ctClass.a(), ctClass);
        }
        do {
            try {
                CtClass[] ctClassArray;
                for (CtClass ctClass2 : ctClassArray = ctClass.a()) {
                    map.put(ctClass2.a(), ctClass2);
                    this.a(ctClass2, map);
                }
                ctClass = ctClass.b();
            } catch (aa aa2) {
                throw new RuntimeException(aa2);
            }
        } while (ctClass != null);
        return map;
    }

    Map<String, CtClass> b(CtClass ctClass, Map<String, CtClass> map) {
        CtClass[] ctClassArray;
        if (map == null) {
            map = new HashMap<String, CtClass>();
        }
        if (ctClass.f()) {
            map.put(ctClass.a(), ctClass);
        }
        try {
            ctClassArray = ctClass.a();
        } catch (aa aa2) {
            throw new RuntimeException(aa2);
        }
        for (CtClass ctClass2 : ctClassArray) {
            map.put(ctClass2.a(), ctClass2);
            this.b(ctClass2, map);
        }
        return map;
    }

    public int hashCode() {
        return this.getClass().hashCode() + this.a.hashCode();
    }

    public boolean equals(Object object) {
        if (!(object instanceof m)) {
            return false;
        }
        return object.getClass() == this.getClass() && javassist.bytecode.analysis.m.a(this.a, ((m)object).a);
    }

    static boolean a(CtClass ctClass, CtClass ctClass2) {
        return ctClass == ctClass2 || ctClass != null && ctClass2 != null && ctClass.a().equals(ctClass2.a());
    }

    public String toString() {
        if (this == m) {
            return "BOGUS";
        }
        if (this == j) {
            return "UNINIT";
        }
        if (this == k) {
            return "RETURN ADDRESS";
        }
        if (this == l) {
            return "TOP";
        }
        return this.a == null ? "null" : this.a.a();
    }

    static {
        a = new IdentityHashMap();
        a = new m(CtClass.h);
        b = new m(CtClass.a);
        c = new m(CtClass.f);
        d = new m(CtClass.b);
        e = new m(CtClass.c);
        f = new m(CtClass.d);
        g = new m(CtClass.e);
        h = new m(CtClass.g);
        i = new m(CtClass.i);
        j = new m(null);
        k = new m(null, true);
        l = new m(null, true);
        m = new m(null, true);
        n = javassist.bytecode.analysis.m.a("java.lang.Object");
        o = javassist.bytecode.analysis.m.a("java.io.Serializable");
        p = javassist.bytecode.analysis.m.a("java.lang.Cloneable");
        q = javassist.bytecode.analysis.m.a("java.lang.Throwable");
        a.put(CtClass.h, a);
        a.put(CtClass.f, c);
        a.put(CtClass.b, d);
        a.put(CtClass.d, f);
        a.put(CtClass.e, g);
        a.put(CtClass.g, h);
        a.put(CtClass.c, e);
        a.put(CtClass.a, b);
        a.put(CtClass.i, i);
    }
}

