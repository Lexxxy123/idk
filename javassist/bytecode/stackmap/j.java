/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.List;
import java.util.Set;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.i;
import javassist.bytecode.stackmap.k;
import javassist.bytecode.stackmap.l;
import javassist.bytecode.stackmap.m;
import javassist.bytecode.stackmap.o;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class j
extends i {
    private i a;

    private j(i i2) {
        this.a = i2;
    }

    public static h a(h h2) {
        if (h2 instanceof k) {
            return ((k)h2).a();
        }
        if (h2 instanceof i) {
            return new j((i)h2);
        }
        if (h2 instanceof m && !h2.b()) {
            return new m(j.b(h2.a()));
        }
        throw new javassist.bytecode.i("bad AASTORE: " + h2);
    }

    @Override
    public void a(h h2) {
        try {
            if (!h2.b()) {
                this.a.a(k.a(h2));
            }
        } catch (javassist.bytecode.i i2) {
            throw new RuntimeException("fatal: " + i2);
        }
    }

    @Override
    public String a() {
        return j.b(this.a.a());
    }

    @Override
    public i a() {
        return this.a;
    }

    @Override
    public l a() {
        return null;
    }

    @Override
    public boolean a() {
        return false;
    }

    private static String b(String string) {
        if (string.length() > 1 && string.charAt(0) == '[') {
            char c2 = string.charAt(1);
            if (c2 == 'L') {
                return string.substring(2, string.length() - 1).replace('/', '.');
            }
            if (c2 == '[') {
                return string.substring(1);
            }
        }
        return "java.lang.Object";
    }

    @Override
    public void a(String string, f f2) {
        this.a.a(k.a(string), f2);
    }

    @Override
    protected o a(int n2) {
        return this.a.a(n2 - 1);
    }

    @Override
    public h a(int n2) {
        return this.a.a(n2 - 1);
    }

    @Override
    public int a(List<h> list, int n2, f f2) {
        return this.a.a(list, n2, f2);
    }

    @Override
    String a(Set<h> set) {
        return "*" + this.a.a(set);
    }

    static /* synthetic */ String a(String string) {
        return j.b(string);
    }
}

