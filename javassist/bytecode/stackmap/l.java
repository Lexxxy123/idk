/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.Set;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.i;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.m;
import javassist.bytecode.stackmap.s;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class l
extends h {
    private String a;
    private int a;
    private char a;

    public l(String string, int n2, char c2) {
        this.a = string;
        this.a = n2;
        this.a = c2;
    }

    @Override
    public int a() {
        return this.a;
    }

    @Override
    public int a(J j2) {
        return 0;
    }

    @Override
    public h a() {
        if (this == s.a) {
            return this;
        }
        return super.a();
    }

    @Override
    public l a() {
        return this;
    }

    @Override
    public boolean a() {
        return this.a == 4 || this.a == 3;
    }

    @Override
    public boolean a(h h2) {
        return this == h2;
    }

    @Override
    public String a() {
        return this.a;
    }

    public char a() {
        return this.a;
    }

    @Override
    public void a(String string, f f2) {
        throw new i("conflict: " + this.a + " and " + string);
    }

    @Override
    public h a(int n2) {
        if (this == s.a) {
            return this;
        }
        if (n2 < 0) {
            throw new aa("no element type: " + this.a);
        }
        if (n2 == 0) {
            return this;
        }
        char[] cArray = new char[n2 + 1];
        for (int i2 = 0; i2 < n2; ++i2) {
            cArray[i2] = 91;
        }
        cArray[n2] = this.a;
        return new m(new String(cArray));
    }

    @Override
    String a(Set<h> set) {
        return this.a;
    }

    static /* synthetic */ char a(l l2) {
        return l2.a;
    }
}

