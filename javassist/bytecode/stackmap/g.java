/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.at;
import javassist.bytecode.i;
import javassist.bytecode.l;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.j;
import javassist.bytecode.stackmap.m;
import javassist.bytecode.stackmap.n;
import javassist.bytecode.stackmap.p;
import javassist.bytecode.stackmap.r;
import javassist.bytecode.stackmap.s;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class g
implements s {
    protected f a;
    protected J a;
    protected String a;
    protected int a;
    protected h[] a;
    protected h[] b;

    public g(f f2, J j2, int n2, int n3, String string) {
        this.a = f2;
        this.a = j2;
        this.a = string;
        this.a = 0;
        this.a = h.a(n2);
        this.b = h.a(n3);
    }

    public g(g g2) {
        this.a = g2.a;
        this.a = g2.a;
        this.a = g2.a;
        this.a = g2.a;
        this.a = h.a(g2.a.length);
        this.b = h.a(g2.b.length);
    }

    protected int a(int n2, byte[] byArray) {
        try {
            int n3 = byArray[n2] & 0xFF;
            if (n3 < 54) {
                return this.a(n2, byArray, n3);
            }
            if (n3 < 96) {
                return this.b(n2, byArray, n3);
            }
            if (n3 < 148) {
                return this.c(n2, byArray, n3);
            }
            return this.d(n2, byArray, n3);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            throw new i("inconsistent stack height " + arrayIndexOutOfBoundsException.getMessage(), (Throwable)arrayIndexOutOfBoundsException);
        }
    }

    protected void a(int n2, byte[] byArray, int n3) {
    }

    protected void b(int n2, byte[] byArray, int n3) {
    }

    protected void a(int n2, byte[] byArray) {
    }

    protected void b(int n2, byte[] byArray) {
    }

    protected void a(int n2, byte[] byArray, int n3, int n4, int n5) {
    }

    protected void b(int n2, byte[] byArray, int n3, int n4, int n5) {
    }

    protected void c(int n2, byte[] byArray) {
    }

    protected void d(int n2, byte[] byArray) {
    }

    private int a(int n2, byte[] byArray, int n3) {
        Object object = this.a--;
        switch (n3) {
            case 0: {
                break;
            }
            case 1: {
                object[this.a++] = new n();
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                object[this.a++] = b;
                break;
            }
            case 9: 
            case 10: {
                object[this.a++] = e;
                object[this.a++] = a;
                break;
            }
            case 11: 
            case 12: 
            case 13: {
                object[this.a++] = c;
                break;
            }
            case 14: 
            case 15: {
                object[this.a++] = d;
                object[this.a++] = a;
                break;
            }
            case 16: 
            case 17: {
                object[this.a++] = b;
                return n3 == 17 ? 3 : 2;
            }
            case 18: {
                this.a(byArray[n2 + 1] & 0xFF);
                return 2;
            }
            case 19: 
            case 20: {
                this.a(l.a(byArray, n2 + 1));
                return 3;
            }
            case 21: {
                return this.a((h)b, byArray, n2);
            }
            case 22: {
                return this.a(e, byArray, n2);
            }
            case 23: {
                return this.a(c, byArray, n2);
            }
            case 24: {
                return this.a(d, byArray, n2);
            }
            case 25: {
                return this.a(byArray[n2 + 1] & 0xFF);
            }
            case 26: 
            case 27: 
            case 28: 
            case 29: {
                object[this.a++] = b;
                break;
            }
            case 30: 
            case 31: 
            case 32: 
            case 33: {
                object[this.a++] = e;
                object[this.a++] = a;
                break;
            }
            case 34: 
            case 35: 
            case 36: 
            case 37: {
                object[this.a++] = c;
                break;
            }
            case 38: 
            case 39: 
            case 40: 
            case 41: {
                object[this.a++] = d;
                object[this.a++] = a;
                break;
            }
            case 42: 
            case 43: 
            case 44: 
            case 45: {
                int n4 = n3 - 42;
                object[this.a++] = this.b[n4];
                break;
            }
            case 46: {
                object[this.a - 1] = b;
                break;
            }
            case 47: {
                object[this.a - 2] = e;
                object[this.a - 1] = a;
                break;
            }
            case 48: {
                object[--this.a - 1] = c;
                break;
            }
            case 49: {
                object[this.a - 2] = d;
                object[this.a - 1] = a;
                break;
            }
            case 50: {
                int n5 = --this.a - 1;
                h h2 = object[n5];
                object[n5] = j.a(h2);
                break;
            }
            case 51: 
            case 52: 
            case 53: {
                object[--this.a - 1] = b;
                break;
            }
            default: {
                throw new RuntimeException("fatal");
            }
        }
        return 1;
    }

    private void a(int n2) {
        h[] hArray = this.a;
        int n3 = this.a.a(n2);
        if (n3 == 8) {
            hArray[this.a++] = new m("java.lang.String");
        } else if (n3 == 3) {
            hArray[this.a++] = b;
        } else if (n3 == 4) {
            hArray[this.a++] = c;
        } else if (n3 == 5) {
            hArray[this.a++] = e;
            hArray[this.a++] = a;
        } else if (n3 == 6) {
            hArray[this.a++] = d;
            hArray[this.a++] = a;
        } else if (n3 == 7) {
            hArray[this.a++] = new m("java.lang.Class");
        } else if (n3 == 17) {
            String string = this.a.o(n2);
            this.a(string);
        } else {
            throw new RuntimeException("bad LDC: " + n3);
        }
    }

    private int a(h h2, byte[] byArray, int n2) {
        int n3 = byArray[n2 + 1] & 0xFF;
        return this.a(n3, h2);
    }

    private int a(int n2, h h2) {
        this.a[this.a++] = h2;
        if (h2.a()) {
            this.a[this.a++] = a;
        }
        return 2;
    }

    private int a(int n2) {
        this.a[this.a++] = this.b[n2];
        return 2;
    }

    private int b(int n2, byte[] byArray, int n3) {
        switch (n3) {
            case 54: {
                return this.a(n2, byArray, (h)b);
            }
            case 55: {
                return this.a(n2, byArray, e);
            }
            case 56: {
                return this.a(n2, byArray, c);
            }
            case 57: {
                return this.a(n2, byArray, d);
            }
            case 58: {
                return this.b(byArray[n2 + 1] & 0xFF);
            }
            case 59: 
            case 60: 
            case 61: 
            case 62: {
                int n4 = n3 - 59;
                this.b[n4] = b;
                --this.a;
                break;
            }
            case 63: 
            case 64: 
            case 65: 
            case 66: {
                int n5 = n3 - 63;
                this.b[n5] = e;
                this.b[n5 + 1] = a;
                this.a -= 2;
                break;
            }
            case 67: 
            case 68: 
            case 69: 
            case 70: {
                int n6 = n3 - 67;
                this.b[n6] = c;
                --this.a;
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: {
                int n7 = n3 - 71;
                this.b[n7] = d;
                this.b[n7 + 1] = a;
                this.a -= 2;
                break;
            }
            case 75: 
            case 76: 
            case 77: 
            case 78: {
                int n8 = n3 - 75;
                this.b(n8);
                break;
            }
            case 79: 
            case 80: 
            case 81: 
            case 82: {
                this.a -= n3 == 80 || n3 == 82 ? 4 : 3;
                break;
            }
            case 83: {
                j.a(this.a[this.a - 3], this.a[this.a - 1], this.a);
                this.a -= 3;
                break;
            }
            case 84: 
            case 85: 
            case 86: {
                this.a -= 3;
                break;
            }
            case 87: {
                --this.a;
                break;
            }
            case 88: {
                this.a -= 2;
                break;
            }
            case 89: {
                int n9 = this.a;
                this.a[n9] = this.a[n9 - 1];
                this.a = n9 + 1;
                break;
            }
            case 90: 
            case 91: {
                int n10 = n3 - 90 + 2;
                this.a(1, n10);
                int n11 = this.a;
                this.a[n11 - n10] = this.a[n11];
                this.a = n11 + 1;
                break;
            }
            case 92: {
                this.a(2, 2);
                this.a += 2;
                break;
            }
            case 93: 
            case 94: {
                int n12 = n3 - 93 + 3;
                this.a(2, n12);
                int n13 = this.a;
                this.a[n13 - n12] = this.a[n13];
                this.a[n13 - n12 + 1] = this.a[n13 + 1];
                this.a = n13 + 2;
                break;
            }
            case 95: {
                int n14 = this.a - 1;
                h h2 = this.a[n14];
                this.a[n14] = this.a[n14 - 1];
                this.a[n14 - 1] = h2;
                break;
            }
            default: {
                throw new RuntimeException("fatal");
            }
        }
        return 1;
    }

    private int a(int n2, byte[] byArray, h h2) {
        int n3 = byArray[n2 + 1] & 0xFF;
        return this.b(n3, h2);
    }

    private int b(int n2, h h2) {
        --this.a;
        this.b[n2] = h2;
        if (h2.a()) {
            --this.a;
            this.b[n2 + 1] = a;
        }
        return 2;
    }

    private int b(int n2) {
        --this.a;
        this.b[n2] = this.a[this.a];
        return 2;
    }

    private void a(int n2, int n3) {
        int n4;
        h[] hArray = this.a;
        int n5 = n4 - n3;
        for (n4 = this.a - 1; n4 > n5; --n4) {
            hArray[n4 + n2] = hArray[n4];
        }
    }

    private int c(int n2, byte[] byArray, int n3) {
        if (n3 <= 131) {
            this.a += at.a[n3];
            return 1;
        }
        switch (n3) {
            case 132: {
                return 3;
            }
            case 133: {
                this.a[this.a - 1] = e;
                this.a[this.a] = a;
                ++this.a;
                break;
            }
            case 134: {
                this.a[this.a - 1] = c;
                break;
            }
            case 135: {
                this.a[this.a - 1] = d;
                this.a[this.a] = a;
                ++this.a;
                break;
            }
            case 136: {
                this.a[--this.a - 1] = b;
                break;
            }
            case 137: {
                this.a[--this.a - 1] = c;
                break;
            }
            case 138: {
                this.a[this.a - 2] = d;
                break;
            }
            case 139: {
                this.a[this.a - 1] = b;
                break;
            }
            case 140: {
                this.a[this.a - 1] = e;
                this.a[this.a] = a;
                ++this.a;
                break;
            }
            case 141: {
                this.a[this.a - 1] = d;
                this.a[this.a] = a;
                ++this.a;
                break;
            }
            case 142: {
                this.a[--this.a - 1] = b;
                break;
            }
            case 143: {
                this.a[this.a - 2] = e;
                break;
            }
            case 144: {
                this.a[--this.a - 1] = c;
                break;
            }
            case 145: 
            case 146: 
            case 147: {
                break;
            }
            default: {
                throw new RuntimeException("fatal");
            }
        }
        return 1;
    }

    private int d(int n2, byte[] byArray, int n3) {
        switch (n3) {
            case 148: {
                this.a[this.a - 4] = b;
                this.a -= 3;
                break;
            }
            case 149: 
            case 150: {
                this.a[--this.a - 1] = b;
                break;
            }
            case 151: 
            case 152: {
                this.a[this.a - 4] = b;
                this.a -= 3;
                break;
            }
            case 153: 
            case 154: 
            case 155: 
            case 156: 
            case 157: 
            case 158: {
                --this.a;
                this.a(n2, byArray, l.b(byArray, n2 + 1));
                return 3;
            }
            case 159: 
            case 160: 
            case 161: 
            case 162: 
            case 163: 
            case 164: 
            case 165: 
            case 166: {
                this.a -= 2;
                this.a(n2, byArray, l.b(byArray, n2 + 1));
                return 3;
            }
            case 167: {
                this.b(n2, byArray, l.b(byArray, n2 + 1));
                return 3;
            }
            case 168: {
                this.c(n2, byArray);
                return 3;
            }
            case 169: {
                this.d(n2, byArray);
                return 2;
            }
            case 170: {
                --this.a;
                int n4 = (n2 & 0xFFFFFFFC) + 8;
                int n5 = l.c(byArray, n4);
                int n6 = l.c(byArray, n4 + 4);
                int n7 = n6 - n5 + 1;
                this.a(n2, byArray, n7, n4 + 8, l.c(byArray, n4 - 4));
                return n7 * 4 + 16 - (n2 & 3);
            }
            case 171: {
                --this.a;
                int n8 = (n2 & 0xFFFFFFFC) + 8;
                int n9 = l.c(byArray, n8);
                this.b(n2, byArray, n9, n8 + 4, l.c(byArray, n8 - 4));
                return n9 * 8 + 12 - (n2 & 3);
            }
            case 172: {
                --this.a;
                this.a(n2, byArray);
                break;
            }
            case 173: {
                this.a -= 2;
                this.a(n2, byArray);
                break;
            }
            case 174: {
                --this.a;
                this.a(n2, byArray);
                break;
            }
            case 175: {
                this.a -= 2;
                this.a(n2, byArray);
                break;
            }
            case 176: {
                this.a[--this.a].a(this.a, this.a);
                this.a(n2, byArray);
                break;
            }
            case 177: {
                this.a(n2, byArray);
                break;
            }
            case 178: {
                return this.b(n2, byArray, false);
            }
            case 179: {
                return this.a(n2, byArray, false);
            }
            case 180: {
                return this.b(n2, byArray, true);
            }
            case 181: {
                return this.a(n2, byArray, true);
            }
            case 182: 
            case 183: {
                return this.c(n2, byArray, true);
            }
            case 184: {
                return this.c(n2, byArray, false);
            }
            case 185: {
                return this.e(n2, byArray);
            }
            case 186: {
                return this.f(n2, byArray);
            }
            case 187: {
                int n10 = l.a(byArray, n2 + 1);
                this.a[this.a++] = new p(n2, this.a.a(n10));
                return 3;
            }
            case 188: {
                return this.c(n2, byArray);
            }
            case 189: {
                int n11 = l.a(byArray, n2 + 1);
                String string = this.a.a(n11).replace('.', '/');
                string = string.charAt(0) == '[' ? "[" + string : "[L" + string + ";";
                this.a[this.a - 1] = new m(string);
                return 3;
            }
            case 190: {
                this.a[this.a - 1].a("[Ljava.lang.Object;", this.a);
                this.a[this.a - 1] = b;
                break;
            }
            case 191: {
                this.a[--this.a].a("java.lang.Throwable", this.a);
                this.b(n2, byArray);
                break;
            }
            case 192: {
                int n12 = l.a(byArray, n2 + 1);
                String string = this.a.a(n12);
                if (string.charAt(0) == '[') {
                    string = string.replace('.', '/');
                }
                this.a[this.a - 1] = new m(string);
                return 3;
            }
            case 193: {
                this.a[this.a - 1] = b;
                return 3;
            }
            case 194: 
            case 195: {
                --this.a;
                break;
            }
            case 196: {
                return this.b(n2, byArray);
            }
            case 197: {
                return this.d(n2, byArray);
            }
            case 198: 
            case 199: {
                --this.a;
                this.a(n2, byArray, l.b(byArray, n2 + 1));
                return 3;
            }
            case 200: {
                this.b(n2, byArray, l.c(byArray, n2 + 1));
                return 5;
            }
            case 201: {
                this.c(n2, byArray);
                return 5;
            }
        }
        return 1;
    }

    private int b(int n2, byte[] byArray) {
        int n3 = byArray[n2 + 1] & 0xFF;
        switch (n3) {
            case 21: {
                this.a(n2, byArray, (h)b);
                break;
            }
            case 22: {
                this.a(n2, byArray, e);
                break;
            }
            case 23: {
                this.a(n2, byArray, c);
                break;
            }
            case 24: {
                this.a(n2, byArray, d);
                break;
            }
            case 25: {
                int n4 = l.a(byArray, n2 + 2);
                this.a(n4);
                break;
            }
            case 54: {
                this.b(n2, byArray, (h)b);
                break;
            }
            case 55: {
                this.b(n2, byArray, e);
                break;
            }
            case 56: {
                this.b(n2, byArray, c);
                break;
            }
            case 57: {
                this.b(n2, byArray, d);
                break;
            }
            case 58: {
                int n5 = l.a(byArray, n2 + 2);
                this.b(n5);
                break;
            }
            case 132: {
                return 6;
            }
            case 169: {
                this.d(n2, byArray);
                break;
            }
            default: {
                throw new RuntimeException("bad WIDE instruction: " + n3);
            }
        }
        return 4;
    }

    private void a(int n2, byte[] byArray, h h2) {
        int n3 = l.a(byArray, n2 + 2);
        this.a(n3, h2);
    }

    private void b(int n2, byte[] byArray, h h2) {
        int n3 = l.a(byArray, n2 + 2);
        this.b(n3, h2);
    }

    private int a(int n2, byte[] byArray, boolean bl2) {
        int n3 = l.a(byArray, n2 + 1);
        String string = this.a.e(n3);
        this.a -= M.c(string);
        char c2 = string.charAt(0);
        if (c2 == 'L') {
            this.a[this.a].a(g.a(string, 0), this.a);
        } else if (c2 == '[') {
            this.a[this.a].a(string, this.a);
        }
        this.a(bl2, n3);
        return 3;
    }

    private int b(int n2, byte[] byArray, boolean bl2) {
        int n3 = l.a(byArray, n2 + 1);
        this.a(bl2, n3);
        String string = this.a.e(n3);
        this.a(string);
        return 3;
    }

    private void a(boolean bl2, int n2) {
        if (bl2) {
            String string = this.a.c(n2);
            this.a[--this.a].a(string, this.a);
        }
    }

    private int c(int n2, byte[] byArray) {
        String string;
        int n3 = this.a - 1;
        switch (byArray[n2 + 1] & 0xFF) {
            case 4: {
                string = "[Z";
                break;
            }
            case 5: {
                string = "[C";
                break;
            }
            case 6: {
                string = "[F";
                break;
            }
            case 7: {
                string = "[D";
                break;
            }
            case 8: {
                string = "[B";
                break;
            }
            case 9: {
                string = "[S";
                break;
            }
            case 10: {
                string = "[I";
                break;
            }
            case 11: {
                string = "[J";
                break;
            }
            default: {
                throw new RuntimeException("bad newarray");
            }
        }
        this.a[n3] = new m(string);
        return 2;
    }

    private int d(int n2, byte[] byArray) {
        int n3 = l.a(byArray, n2 + 1);
        int n4 = byArray[n2 + 3] & 0xFF;
        this.a -= n4 - 1;
        String string = this.a.a(n3).replace('.', '/');
        this.a[this.a - 1] = new m(string);
        return 4;
    }

    private int c(int n2, byte[] byArray, boolean bl2) {
        int n3 = l.a(byArray, n2 + 1);
        String string = this.a.h(n3);
        this.a(string, 1);
        if (bl2) {
            h h2;
            String string2 = this.a.f(n3);
            if ((h2 = (--this.a)[this.a]) instanceof r && h2.c()) {
                this.a(h2, ((r)h2).b());
            } else if (h2 instanceof p) {
                this.a(h2, ((p)h2).b());
            }
            h2.a(string2, this.a);
        }
        this.a(string);
        return 3;
    }

    private void a(h h2, int n2) {
        int n3;
        h2.a(n2);
        for (n3 = 0; n3 < this.a; ++n3) {
            this.a[n3].a(n2);
        }
        for (n3 = 0; n3 < this.b.length; ++n3) {
            this.b[n3].a(n2);
        }
    }

    private int e(int n2, byte[] byArray) {
        int n3 = l.a(byArray, n2 + 1);
        String string = this.a.k(n3);
        this.a(string, 1);
        String string2 = this.a.i(n3);
        this.a[--this.a].a(string2, this.a);
        this.a(string);
        return 5;
    }

    private int f(int n2, byte[] byArray) {
        int n3 = l.a(byArray, n2 + 1);
        String string = this.a.n(n3);
        this.a(string, 1);
        this.a(string);
        return 5;
    }

    private void a(String string) {
        int n2 = 0;
        if (string.charAt(0) == '(' && (n2 = string.indexOf(41) + 1) < 1) {
            throw new IndexOutOfBoundsException("bad descriptor: " + string);
        }
        h[] hArray = this.a;
        int n3 = this.a;
        switch (string.charAt(n2)) {
            case '[': {
                hArray[n3] = new m(string.substring(n2));
                break;
            }
            case 'L': {
                hArray[n3] = new m(g.a(string, n2));
                break;
            }
            case 'J': {
                hArray[n3] = e;
                hArray[n3 + 1] = a;
                this.a += 2;
                return;
            }
            case 'F': {
                hArray[n3] = c;
                break;
            }
            case 'D': {
                hArray[n3] = d;
                hArray[n3 + 1] = a;
                this.a += 2;
                return;
            }
            case 'V': {
                return;
            }
            default: {
                hArray[n3] = b;
            }
        }
        ++this.a;
    }

    private static String a(String string, int n2) {
        return string.substring(n2 + 1, string.length() - 1).replace('/', '.');
    }

    private void a(String string, int n2) {
        char c2 = string.charAt(n2);
        if (c2 == ')') {
            return;
        }
        int n3 = n2;
        boolean bl2 = false;
        while (c2 == '[') {
            bl2 = true;
            c2 = string.charAt(++n3);
        }
        if (c2 == 'L') {
            if ((n3 = string.indexOf(59, n3) + 1) <= 0) {
                throw new IndexOutOfBoundsException("bad descriptor");
            }
        } else {
            ++n3;
        }
        this.a(string, n3);
        this.a = !(bl2 || c2 != 'J' && c2 != 'D') ? (this.a -= 2) : --this.a;
        if (bl2) {
            this.a[this.a].a(string.substring(n2, n3), this.a);
        } else if (c2 == 'L') {
            this.a[this.a].a(string.substring(n2 + 1, n3 - 1).replace('/', '.'), this.a);
        }
    }
}

