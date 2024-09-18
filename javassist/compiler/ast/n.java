/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.b;
import javassist.compiler.ast.j;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class n
extends b {
    private static final long b = 1L;
    protected long a;
    protected int a;

    public n(long l2, int n2) {
        this.a = l2;
        this.a = n2;
    }

    public long a() {
        return this.a;
    }

    public void a(long l2) {
        this.a = l2;
    }

    public int a() {
        return this.a;
    }

    @Override
    public String toString() {
        return Long.toString(this.a);
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

    private n a(int n2, n n3) {
        long l2;
        int n4 = this.a;
        int n5 = n3.a;
        int n6 = n4 == 403 || n5 == 403 ? 403 : (n4 == 401 && n5 == 401 ? 401 : 402);
        long l3 = this.a;
        long l4 = n3.a;
        switch (n2) {
            case 43: {
                l2 = l3 + l4;
                break;
            }
            case 45: {
                l2 = l3 - l4;
                break;
            }
            case 42: {
                l2 = l3 * l4;
                break;
            }
            case 47: {
                l2 = l3 / l4;
                break;
            }
            case 37: {
                l2 = l3 % l4;
                break;
            }
            case 124: {
                l2 = l3 | l4;
                break;
            }
            case 94: {
                l2 = l3 ^ l4;
                break;
            }
            case 38: {
                l2 = l3 & l4;
                break;
            }
            case 364: {
                l2 = this.a << (int)l4;
                n6 = n4;
                break;
            }
            case 366: {
                l2 = this.a >> (int)l4;
                n6 = n4;
                break;
            }
            case 370: {
                l2 = this.a >>> (int)l4;
                n6 = n4;
                break;
            }
            default: {
                return null;
            }
        }
        return new n(l2, n6);
    }

    private j a(int n2, j j2) {
        double d2;
        double d3 = this.a;
        double d4 = j2.a;
        switch (n2) {
            case 43: {
                d2 = d3 + d4;
                break;
            }
            case 45: {
                d2 = d3 - d4;
                break;
            }
            case 42: {
                d2 = d3 * d4;
                break;
            }
            case 47: {
                d2 = d3 / d4;
                break;
            }
            case 37: {
                d2 = d3 % d4;
                break;
            }
            default: {
                return null;
            }
        }
        return new j(d2, j2.a);
    }
}

