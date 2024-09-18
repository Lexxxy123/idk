/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.Set;
import javassist.bytecode.J;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.i;
import javassist.bytecode.stackmap.l;
import javassist.bytecode.stackmap.o;
import javassist.bytecode.stackmap.p;
import javassist.bytecode.stackmap.s;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class r
extends i {
    protected h a;

    public r(p p2) {
        this.a = p2;
    }

    @Override
    public int a() {
        return this.a.a();
    }

    @Override
    public int a(J j2) {
        return this.a.a(j2);
    }

    @Override
    public l a() {
        return this.a.a();
    }

    @Override
    public boolean a() {
        return this.a.a();
    }

    @Override
    public boolean c() {
        return this.a.c();
    }

    @Override
    public boolean a(h h2) {
        return this.a.a(h2);
    }

    @Override
    public String a() {
        return this.a.a();
    }

    @Override
    protected o a(int n2) {
        return null;
    }

    @Override
    public h a() {
        return this.a.a();
    }

    @Override
    public void a(String string, f f2) {
        this.a.a(string, f2);
    }

    @Override
    public void a(h h2) {
        if (!h2.a(this.a)) {
            this.a = s.a;
        }
    }

    @Override
    public void a(int n2) {
        this.a.a(n2);
    }

    public int b() {
        if (this.a instanceof p) {
            return ((p)this.a).a;
        }
        throw new RuntimeException("not available");
    }

    @Override
    public h a(int n2) {
        return this.a.a(n2);
    }

    @Override
    String a(Set<h> set) {
        return "";
    }
}

