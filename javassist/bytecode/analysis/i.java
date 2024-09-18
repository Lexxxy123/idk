/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import javassist.CtClass;
import javassist.aa;
import javassist.bytecode.analysis.j;
import javassist.bytecode.analysis.m;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class i
extends m {
    private j a;
    private int a;

    public i(j j2, int n2) {
        super(null);
        this.a = j2;
        this.a = n2;
    }

    @Override
    public CtClass a() {
        CtClass ctClass = this.a.a();
        if (ctClass == null) {
            return null;
        }
        f f2 = ctClass.a();
        if (f2 == null) {
            f2 = javassist.f.a();
        }
        String string = this.a(ctClass.a(), this.a);
        try {
            return f2.c(string);
        } catch (aa aa2) {
            throw new RuntimeException(aa2);
        }
    }

    @Override
    boolean a() {
        return this.a.a();
    }

    @Override
    public int a() {
        return this.a;
    }

    @Override
    public m a() {
        return this.a == 1 ? this.a : new i(this.a, this.a - 1);
    }

    @Override
    public int b() {
        return 1;
    }

    @Override
    public boolean b() {
        return true;
    }

    @Override
    public boolean a(m m2) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean c() {
        return true;
    }

    public boolean b(m m2) {
        if (javassist.bytecode.analysis.i.a(m2.a(), javassist.bytecode.analysis.m.n.a())) {
            return true;
        }
        if (javassist.bytecode.analysis.i.a(m2.a(), javassist.bytecode.analysis.m.p.a())) {
            return true;
        }
        if (javassist.bytecode.analysis.i.a(m2.a(), javassist.bytecode.analysis.m.o.a())) {
            return true;
        }
        if (!m2.b()) {
            return false;
        }
        m m3 = this.b(m2);
        int n2 = m2.a();
        if (n2 > this.a) {
            return false;
        }
        if (n2 < this.a) {
            if (javassist.bytecode.analysis.i.a(m3.a(), javassist.bytecode.analysis.m.n.a())) {
                return true;
            }
            if (javassist.bytecode.analysis.i.a(m3.a(), javassist.bytecode.analysis.m.p.a())) {
                return true;
            }
            return javassist.bytecode.analysis.i.a(m3.a(), javassist.bytecode.analysis.m.o.a());
        }
        return this.a.b(m3);
    }

    @Override
    public int hashCode() {
        return this.a.hashCode() + this.a;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof i)) {
            return false;
        }
        i i2 = (i)object;
        return this.a.equals(i2.a) && this.a == i2.a;
    }

    @Override
    public String toString() {
        return this.a(this.a.toString(), this.a);
    }
}

