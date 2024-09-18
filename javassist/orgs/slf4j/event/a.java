/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javassist.orgs.slf4j.c;
import javassist.orgs.slf4j.event.d;
import javassist.orgs.slf4j.event.e;
import javassist.orgs.slf4j.event.f;
import javassist.orgs.slf4j.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
implements f {
    c a;
    e a;
    String a;
    List<h> a;
    List<Object> b;
    List<d> c;
    Throwable a;
    String b;
    long a;

    public a(e e2, c c2) {
        this.a = c2;
        this.a = e2;
    }

    public void a(h h2) {
        if (this.a == null) {
            this.a = new ArrayList(2);
        }
        this.a.add(h2);
    }

    @Override
    public List<h> a() {
        return this.a;
    }

    public void a(Object object) {
        this.d().add(object);
    }

    public void a(Object ... objectArray) {
        this.d().addAll(Arrays.asList(objectArray));
    }

    private List<Object> d() {
        if (this.b == null) {
            this.b = new ArrayList<Object>(3);
        }
        return this.b;
    }

    @Override
    public List<Object> b() {
        return this.b;
    }

    @Override
    public Object[] a() {
        if (this.b == null) {
            return null;
        }
        return this.b.toArray();
    }

    public void a(String string, Object object) {
        this.e().add(new d(string, object));
    }

    private List<d> e() {
        if (this.c == null) {
            this.c = new ArrayList<d>(4);
        }
        return this.c;
    }

    @Override
    public List<d> c() {
        return this.c;
    }

    public void a(Throwable throwable) {
        this.a = throwable;
    }

    @Override
    public e a() {
        return this.a;
    }

    @Override
    public String a() {
        return this.a.a();
    }

    @Override
    public String b() {
        return this.a;
    }

    public void a(String string) {
        this.a = string;
    }

    @Override
    public Throwable a() {
        return this.a;
    }

    @Override
    public String c() {
        return this.b;
    }

    @Override
    public long a() {
        return this.a;
    }
}

