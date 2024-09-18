/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import javassist.orgs.slf4j.a;
import javassist.orgs.slf4j.c;
import javassist.orgs.slf4j.event.h;
import javassist.orgs.slf4j.helpers.p;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class q
implements a {
    volatile boolean a;
    final Map<String, p> a;
    final LinkedBlockingQueue<h> a = new LinkedBlockingQueue();

    @Override
    public synchronized c a(String string) {
        p p2 = (p)this.a.get(string);
        if (p2 == null) {
            p2 = new p(string, (Queue<h>)this.a, this.a);
            this.a.put(string, p2);
        }
        return p2;
    }

    public List<String> a() {
        return new ArrayList<String>(this.a.keySet());
    }

    public List<p> b() {
        return new ArrayList<p>(this.a.values());
    }

    public LinkedBlockingQueue<h> a() {
        return this.a;
    }

    public void a() {
        this.a = true;
    }

    public void b() {
        this.a.clear();
        this.a.clear();
    }
}

