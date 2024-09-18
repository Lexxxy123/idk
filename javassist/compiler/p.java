/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import java.util.ArrayList;
import java.util.List;
import javassist.bytecode.n;
import javassist.compiler.b;
import javassist.compiler.d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class p
extends d {
    List<int[]> a;
    b a;
    int a = new ArrayList<int[]>();

    p(b b2) {
        super(b2);
        this.a = b2;
        this.a = -1;
    }

    private int a(int n2) {
        if (this.a < 0) {
            this.a = this.a.a();
            this.a.b(n2);
        }
        return this.a;
    }

    private void a(n n2) {
        n2.g(167);
        this.a.add(new int[]{n2.e(), this.a});
        n2.j(0);
    }

    @Override
    protected boolean a(n n2, int n3) {
        switch (n3) {
            case 177: {
                this.a(n2);
                break;
            }
            case 176: {
                n2.l(this.a(1));
                this.a(n2);
                n2.k(this.a);
                break;
            }
            case 172: {
                n2.o(this.a(1));
                this.a(n2);
                n2.n(this.a);
                break;
            }
            case 173: {
                n2.q(this.a(2));
                this.a(n2);
                n2.p(this.a);
                break;
            }
            case 175: {
                n2.s(this.a(2));
                this.a(n2);
                n2.r(this.a);
                break;
            }
            case 174: {
                n2.u(this.a(1));
                this.a(n2);
                n2.t(this.a);
                break;
            }
            default: {
                throw new RuntimeException("fatal");
            }
        }
        return false;
    }
}

