/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import java.io.DataOutputStream;
import javassist.CtClass;
import javassist.O;
import javassist.Z;
import javassist.a;
import javassist.aa;
import javassist.bytecode.o;
import javassist.f;
import javassist.p;
import javassist.q;

class N
extends p {
    protected boolean d;

    N(String string, f f2, boolean bl2, CtClass ctClass) {
        super(string, f2);
        this.a = true;
        String string2 = bl2 || ctClass == null ? null : ctClass.a();
        this.a = new o(bl2, string, string2);
        if (bl2 && ctClass != null) {
            this.a.a(new String[]{ctClass.a()});
        }
        this.a(Z.a(this.a()));
        this.d = bl2;
    }

    @Override
    protected void a(StringBuffer stringBuffer) {
        if (this.d) {
            stringBuffer.append("hasConstructor ");
        }
        super.a(stringBuffer);
    }

    @Override
    public void a(q q2) {
        this.d = true;
        super.a(q2);
    }

    @Override
    public void a(DataOutputStream dataOutputStream) {
        if (!this.d) {
            try {
                this.k();
                this.d = true;
            } catch (aa aa2) {
                throw new a(aa2);
            }
        }
        super.a(dataOutputStream);
    }

    public void k() {
        CtClass ctClass = this.b();
        q[] qArray = ctClass.b();
        int n2 = 0;
        for (int i2 = 0; i2 < qArray.length; ++i2) {
            q q2 = qArray[i2];
            int n3 = q2.a();
            if (!this.a(n3, ctClass)) continue;
            q q3 = O.b(q2.a(), q2.b(), this);
            q3.a(n3 & 7);
            this.a(q3);
            ++n2;
        }
        if (n2 < 1) {
            throw new a("no inheritable constructor in " + ctClass.a());
        }
    }

    private boolean a(int n2, CtClass ctClass) {
        if (Z.b(n2)) {
            return false;
        }
        if (Z.d(n2)) {
            String string = this.c();
            String string2 = ctClass.c();
            if (string == null) {
                return string2 == null;
            }
            return string.equals(string2);
        }
        return true;
    }
}

