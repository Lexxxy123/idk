/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import java.util.HashMap;
import java.util.Map;
import javassist.CtClass;
import javassist.bytecode.analysis.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class j
extends m {
    private Map<String, CtClass> a;
    private m r;
    private m s;
    private j a;
    private boolean a = false;

    public j(Map<String, CtClass> map) {
        this(map, null);
    }

    public j(Map<String, CtClass> map, m m2) {
        super(null);
        this.a = map;
        this.s = m2;
    }

    @Override
    public CtClass a() {
        if (this.r != null) {
            return this.r.a();
        }
        return javassist.bytecode.analysis.m.n.a();
    }

    @Override
    public m a() {
        return null;
    }

    @Override
    public int b() {
        return 1;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    boolean a() {
        boolean bl2 = this.a;
        this.a = false;
        return bl2;
    }

    @Override
    public boolean a(m m2) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean b(m m2) {
        Map<String, CtClass> map;
        if (this.r != null) {
            return m2.a(this.r);
        }
        if (javassist.bytecode.analysis.m.n.equals(m2)) {
            return true;
        }
        if (this.s != null && !m2.a(this.s)) {
            this.s = null;
        }
        if ((map = this.a(this, m2)).size() == 1 && this.s == null) {
            this.r = javassist.bytecode.analysis.m.a(map.values().iterator().next());
            this.b();
            return true;
        }
        if (map.size() >= 1) {
            this.a = map;
            this.a();
            return true;
        }
        if (this.s != null) {
            this.r = this.s;
            this.b();
            return true;
        }
        return false;
    }

    private void a() {
        j j2 = this.a;
        while (j2 != null) {
            j2.a = this.a;
            j2.s = this.s;
            j2 = j2.a;
        }
    }

    private void b() {
        j j2 = this.a;
        while (j2 != null) {
            j2.r = this.r;
            j2 = j2.a;
        }
    }

    @Override
    public boolean c() {
        return true;
    }

    private Map<String, CtClass> a(j j2) {
        HashMap<String, CtClass> hashMap = new HashMap<String, CtClass>();
        for (CtClass ctClass : j2.a.values()) {
            hashMap.put(ctClass.a(), ctClass);
            this.a(ctClass, hashMap);
        }
        return hashMap;
    }

    private Map<String, CtClass> a(j j2, j j3) {
        Map<String, CtClass> map = this.a(j2);
        Map<String, CtClass> map2 = this.a(j3);
        return this.a(map, map2);
    }

    private Map<String, CtClass> a(j j2, m m2) {
        Map<String, CtClass> map = this.a(j2);
        Map<String, CtClass> map2 = this.a(m2.a(), null);
        return this.a(map, map2);
    }

    private boolean a(j j2) {
        while (j2 != null) {
            if (j2 == this) {
                return true;
            }
            j2 = j2.a;
        }
        return false;
    }

    @Override
    public m a(m m2) {
        Map<String, CtClass> map;
        if (this == m2) {
            return this;
        }
        if (m2 == j) {
            return this;
        }
        if (m2 == m) {
            return m;
        }
        if (m2 == null) {
            return this;
        }
        if (this.r != null) {
            return this.r.a(m2);
        }
        if (this.s != null && (!((m)((Object)(map = this.s.a(m2)))).equals(this.s) || ((m)((Object)map)).a())) {
            this.s = javassist.bytecode.analysis.m.n.equals(map) ? null : map;
            this.a = true;
        }
        if (m2 instanceof j) {
            j j2 = (j)m2;
            if (j2.r != null) {
                map = this.a(this, j2.r);
            } else {
                map = this.a(j2, this);
                if (!this.a(j2)) {
                    this.a = j2;
                }
            }
        } else {
            map = this.a(this, m2);
        }
        if (map.size() > 1 || map.size() == 1 && this.s != null) {
            if (map.size() != this.a.size()) {
                this.a = true;
            } else if (!this.a) {
                for (String string : map.keySet()) {
                    if (this.a.containsKey(string)) continue;
                    this.a = true;
                }
            }
            this.a = map;
            this.a();
            return this;
        }
        this.r = map.size() == 1 ? javassist.bytecode.analysis.m.a(map.values().iterator().next()) : (this.s != null ? this.s : n);
        this.b();
        return this.r;
    }

    @Override
    public int hashCode() {
        if (this.r != null) {
            return this.r.hashCode();
        }
        return this.a.keySet().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof j)) {
            return false;
        }
        j j2 = (j)object;
        if (this.r != null) {
            return this.r.equals(j2.r);
        }
        if (j2.r != null) {
            return false;
        }
        return this.a.keySet().equals(j2.a.keySet());
    }

    @Override
    public String toString() {
        if (this.r != null) {
            return this.r.toString();
        }
        StringBuffer stringBuffer = new StringBuffer("{");
        for (String string : this.a.keySet()) {
            stringBuffer.append(string).append(", ");
        }
        if (this.s != null) {
            stringBuffer.append("*").append(this.s.toString());
        } else {
            stringBuffer.setLength(stringBuffer.length() - 2);
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

