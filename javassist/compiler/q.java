/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.bytecode.n;
import javassist.compiler.b;
import javassist.compiler.d;

class q
extends d {
    int a;
    int b;

    q(b b2, int[] nArray) {
        super(b2);
        this.b = nArray[0];
        this.a = nArray[1];
    }

    @Override
    protected boolean a(n n2, int n3) {
        switch (n3) {
            case 177: {
                break;
            }
            case 176: {
                n2.l(this.a);
                break;
            }
            case 172: {
                n2.o(this.a);
                break;
            }
            case 173: {
                n2.q(this.a);
                break;
            }
            case 175: {
                n2.s(this.a);
                break;
            }
            case 174: {
                n2.u(this.a);
                break;
            }
            default: {
                throw new RuntimeException("fatal");
            }
        }
        n2.g(167);
        n2.j(this.b - n2.e() + 3);
        return true;
    }
}

