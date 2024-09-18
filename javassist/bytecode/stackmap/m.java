/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.Set;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.l;
import javassist.bytecode.stackmap.s;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class m
extends h {
    private String a;

    public m(String string) {
        this.a = string;
    }

    @Override
    public String a() {
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

    @Override
    public int a() {
        return 7;
    }

    @Override
    public int a(J j2) {
        return j2.a(this.a());
    }

    @Override
    public boolean a(h h2) {
        return this.a.equals(h2.a());
    }

    @Override
    public void a(String string, f f2) {
    }

    @Override
    public h a(int n2) {
        int n3;
        if (n2 == 0) {
            return this;
        }
        if (n2 > 0) {
            char[] cArray = new char[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                cArray[i2] = 91;
            }
            String string = this.a();
            if (string.charAt(0) != '[') {
                string = "L" + string.replace('.', '/') + ";";
            }
            return new m(new String(cArray) + string);
        }
        for (n3 = 0; n3 < -n2; ++n3) {
            if (this.a.charAt(n3) == '[') continue;
            throw new aa("no " + n2 + " dimensional array type: " + this.a());
        }
        n3 = this.a.charAt(-n2);
        if (n3 == 91) {
            return new m(this.a.substring(-n2));
        }
        if (n3 == 76) {
            return new m(this.a.substring(-n2 + 1, this.a.length() - 1).replace('/', '.'));
        }
        if (n3 == l.a(s.d)) {
            return s.d;
        }
        if (n3 == l.a(s.c)) {
            return s.c;
        }
        if (n3 == l.a(s.e)) {
            return s.e;
        }
        return s.b;
    }

    @Override
    String a(Set<h> set) {
        return this.a;
    }
}

