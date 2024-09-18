/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javassist.orgs.slf4j.b;
import javassist.orgs.slf4j.h;
import javassist.orgs.slf4j.helpers.d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e
implements b {
    private final ConcurrentMap<String, h> a = new ConcurrentHashMap<String, h>();

    @Override
    public h a(String string) {
        h h2;
        if (string == null) {
            throw new IllegalArgumentException("Marker name cannot be null");
        }
        h h3 = (h)this.a.get(string);
        if (h3 == null && (h2 = this.a.putIfAbsent(string, h3 = new d(string))) != null) {
            h3 = h2;
        }
        return h3;
    }

    @Override
    public boolean a(String string) {
        if (string == null) {
            return false;
        }
        return this.a.containsKey(string);
    }

    @Override
    public boolean b(String string) {
        if (string == null) {
            return false;
        }
        return this.a.remove(string) != null;
    }

    @Override
    public h b(String string) {
        return new d(string);
    }
}

