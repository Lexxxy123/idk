/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javassist.orgs.slf4j.event.d;
import javassist.orgs.slf4j.event.e;
import javassist.orgs.slf4j.event.f;
import javassist.orgs.slf4j.helpers.p;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class h
implements f {
    e a;
    List<javassist.orgs.slf4j.h> a;
    String a;
    p a;
    String b;
    String c;
    Object[] a;
    List<d> b;
    long a;
    Throwable a;

    @Override
    public e a() {
        return this.a;
    }

    public void a(e e2) {
        this.a = e2;
    }

    @Override
    public List<javassist.orgs.slf4j.h> a() {
        return this.a;
    }

    public void a(javassist.orgs.slf4j.h h2) {
        if (h2 == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList(2);
        }
        this.a.add(h2);
    }

    @Override
    public String a() {
        return this.a;
    }

    public void a(String string) {
        this.a = string;
    }

    public p a() {
        return this.a;
    }

    public void a(p p2) {
        this.a = p2;
    }

    @Override
    public String b() {
        return this.c;
    }

    public void b(String string) {
        this.c = string;
    }

    @Override
    public Object[] a() {
        return this.a;
    }

    public void a(Object[] objectArray) {
        this.a = objectArray;
    }

    @Override
    public List<Object> b() {
        if (this.a == null) {
            return null;
        }
        return Arrays.asList(this.a);
    }

    @Override
    public long a() {
        return this.a;
    }

    public void a(long l2) {
        this.a = l2;
    }

    @Override
    public String c() {
        return this.b;
    }

    public void c(String string) {
        this.b = string;
    }

    @Override
    public Throwable a() {
        return this.a;
    }

    public void a(Throwable throwable) {
        this.a = throwable;
    }

    @Override
    public List<d> c() {
        return this.b;
    }
}

