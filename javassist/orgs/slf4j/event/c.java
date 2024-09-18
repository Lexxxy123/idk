/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.event;

import java.util.Queue;
import javassist.orgs.slf4j.event.e;
import javassist.orgs.slf4j.h;
import javassist.orgs.slf4j.helpers.g;
import javassist.orgs.slf4j.helpers.p;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c
extends g {
    private static final long a = -176083308134819629L;
    String b;
    p a;
    Queue<javassist.orgs.slf4j.event.h> a;
    static final boolean a = true;

    public c(p p2, Queue<javassist.orgs.slf4j.event.h> queue) {
        this.a = p2;
        this.b = p2.a();
        this.a = (long)queue;
    }

    @Override
    public String a() {
        return this.b;
    }

    @Override
    public boolean a() {
        return true;
    }

    @Override
    public boolean b() {
        return true;
    }

    @Override
    public boolean c() {
        return true;
    }

    @Override
    public boolean d() {
        return true;
    }

    @Override
    public boolean e() {
        return true;
    }

    @Override
    protected void a(e e2, h h2, String string, Object[] objectArray, Throwable throwable) {
        javassist.orgs.slf4j.event.h h3 = new javassist.orgs.slf4j.event.h();
        h3.a(System.currentTimeMillis());
        h3.a(e2);
        h3.a(this.a);
        h3.a(this.b);
        if (h2 != null) {
            h3.a(h2);
        }
        h3.b(string);
        h3.c(Thread.currentThread().getName());
        h3.a(objectArray);
        h3.a(throwable);
        this.a.add(h3);
    }

    @Override
    protected String b() {
        return null;
    }
}

