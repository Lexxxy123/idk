/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javassist.orgs.slf4j.helpers.c;
import javassist.orgs.slf4j.spi.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
implements f {
    private InheritableThreadLocal<Map<String, String>> a = new c(this);

    @Override
    public void a(String string, String string2) {
        if (string == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        HashMap<String, String> hashMap = (HashMap<String, String>)this.a.get();
        if (hashMap == null) {
            hashMap = new HashMap<String, String>();
            this.a.set(hashMap);
        }
        hashMap.put(string, string2);
    }

    @Override
    public String a(String string) {
        Map map = (Map)this.a.get();
        if (map != null && string != null) {
            return (String)map.get(string);
        }
        return null;
    }

    @Override
    public void a(String string) {
        Map map = (Map)this.a.get();
        if (map != null) {
            map.remove(string);
        }
    }

    @Override
    public void a() {
        Map map = (Map)this.a.get();
        if (map != null) {
            map.clear();
            this.a.remove();
        }
    }

    public Set<String> a() {
        Map map = (Map)this.a.get();
        if (map != null) {
            return map.keySet();
        }
        return null;
    }

    @Override
    public Map<String, String> a() {
        Map map = (Map)this.a.get();
        if (map != null) {
            return new HashMap<String, String>(map);
        }
        return null;
    }

    @Override
    public void a(Map<String, String> map) {
        this.a.set(new HashMap<String, String>(map));
    }
}

