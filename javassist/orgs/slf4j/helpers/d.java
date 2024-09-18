/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javassist.orgs.slf4j.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class d
implements h {
    private static final long a = -2849567615646933777L;
    private final String c;
    private List<h> a = (long)new CopyOnWriteArrayList();
    private static String d = "[ ";
    private static String e = " ]";
    private static String f = ", ";

    d(String string) {
        if (string == null) {
            throw new IllegalArgumentException("A marker name cannot be null");
        }
        this.c = string;
    }

    @Override
    public String a() {
        return this.c;
    }

    @Override
    public void a(h h2) {
        if (h2 == null) {
            throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
        }
        if (this.b(h2)) {
            return;
        }
        if (h2.b(this)) {
            return;
        }
        this.a.add(h2);
    }

    @Override
    public boolean b() {
        return this.a.size() > 0;
    }

    @Override
    @Deprecated
    public boolean a() {
        return this.b();
    }

    @Override
    public Iterator<h> a() {
        return this.a.iterator();
    }

    @Override
    public boolean a(h h2) {
        return this.a.remove(h2);
    }

    @Override
    public boolean b(h h2) {
        if (h2 == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }
        if (this.equals(h2)) {
            return true;
        }
        if (this.b()) {
            for (h h3 : this.a) {
                if (!h3.b(h2)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean a(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }
        if (this.c.equals(string)) {
            return true;
        }
        if (this.b()) {
            for (h h2 : this.a) {
                if (!h2.a(string)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof h)) {
            return false;
        }
        h h2 = (h)object;
        return this.c.equals(h2.a());
    }

    @Override
    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        if (!this.b()) {
            return this.a();
        }
        Iterator<h> iterator = this.a();
        StringBuilder stringBuilder = new StringBuilder(this.a());
        stringBuilder.append(' ').append(d);
        while (iterator.hasNext()) {
            h h2 = iterator.next();
            stringBuilder.append(h2.a());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(f);
        }
        stringBuilder.append(e);
        return stringBuilder.toString();
    }
}

