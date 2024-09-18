/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.Set;
import javassist.bytecode.J;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.m;
import javassist.bytecode.stackmap.o;
import javassist.bytecode.stackmap.r;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class p
extends m {
    int a;
    boolean a;

    p(int n2, String string) {
        super(string);
        this.a = n2;
        this.a = false;
    }

    @Override
    public p a() {
        return new p(this.a, this.a());
    }

    @Override
    public int a() {
        return 8;
    }

    @Override
    public int a(J j2) {
        return this.a;
    }

    @Override
    public h a() {
        if (this.a) {
            return new o(new m(this.a()));
        }
        return new r(this.a());
    }

    @Override
    public boolean c() {
        return true;
    }

    @Override
    public boolean a(h h2) {
        if (h2 instanceof p) {
            p p2 = (p)h2;
            return this.a == p2.a && this.a().equals(p2.a());
        }
        return false;
    }

    public int b() {
        return this.a;
    }

    @Override
    public void a(int n2) {
        if (n2 == this.a) {
            this.a = true;
        }
    }

    @Override
    String a(Set<h> set) {
        return this.a() + "," + this.a;
    }
}

