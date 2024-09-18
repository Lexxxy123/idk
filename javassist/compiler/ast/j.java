/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.b;
import javassist.compiler.ast.n;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class j
extends b {
    private static final long a = 1L;
    protected double a;
    protected int a;

    public j(double d2, int n2) {
        this.a = d2;
        this.a = n2;
    }

    public double a() {
        return this.a;
    }

    public void a(double d2) {
        this.a = d2;
    }

    public int a() {
        return this.a;
    }

    @Override
    public String toString() {
        return Double.toString(this.a);
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }

    public b a(int n2, b b2) {
        if (b2 instanceof n) {
            return this.a(n2, (n)b2);
        }
        if (b2 instanceof j) {
            return this.a(n2, (j)b2);
        }
        return null;
    }

    private j a(int n2, j j2) {
        int n3 = this.a == 405 || j2.a == 405 ? 405 : 404;
        return j.a(n2, this.a, j2.a, n3);
    }

    private j a(int n2, n n3) {
        return j.a(n2, this.a, n3.a, this.a);
    }

    private static j a(int n2, double d2, double d3, int n3) {
        double d4;
        switch (n2) {
            case 43: {
                d4 = d2 + d3;
                break;
            }
            case 45: {
                d4 = d2 - d3;
                break;
            }
            case 42: {
                d4 = d2 * d3;
                break;
            }
            case 47: {
                d4 = d2 / d3;
                break;
            }
            case 37: {
                d4 = d2 % d3;
                break;
            }
            default: {
                return null;
            }
        }
        return new j(d4, n3);
    }
}

