/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import javassist.CtClass;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.al;
import javassist.bytecode.analysis.e;
import javassist.bytecode.analysis.k;
import javassist.bytecode.analysis.m;
import javassist.bytecode.at;
import javassist.bytecode.i;
import javassist.bytecode.u;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class d
implements at {
    private final J a;
    private final f a;
    private final m a;
    private final m b;
    private final m c;
    private int a;

    public d(f f2, J j2) {
        this.a = j2;
        this.a = f2;
        try {
            this.a = this.a("java.lang.String");
            this.b = this.a("java.lang.Class");
            this.c = this.a("java.lang.Throwable");
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void a(al al2, int n2, u u2, e e2, k k2) {
        this.a = n2;
        int n3 = u2.a(n2);
        switch (n3) {
            case 0: {
                break;
            }
            case 1: {
                e2.a(m.j);
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                e2.a(m.g);
                break;
            }
            case 9: 
            case 10: {
                e2.a(m.c);
                e2.a(m.l);
                break;
            }
            case 11: 
            case 12: 
            case 13: {
                e2.a(m.h);
                break;
            }
            case 14: 
            case 15: {
                e2.a(m.a);
                e2.a(m.l);
                break;
            }
            case 16: 
            case 17: {
                e2.a(m.g);
                break;
            }
            case 18: {
                this.a(u2.a(n2 + 1), e2);
                break;
            }
            case 19: 
            case 20: {
                this.a(u2.c(n2 + 1), e2);
                break;
            }
            case 21: {
                this.a(m.g, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 22: {
                this.a(m.c, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 23: {
                this.a(m.h, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 24: {
                this.a(m.a, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 25: {
                this.a(m.n, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 26: 
            case 27: 
            case 28: 
            case 29: {
                this.a(m.g, n3 - 26, e2, k2);
                break;
            }
            case 30: 
            case 31: 
            case 32: 
            case 33: {
                this.a(m.c, n3 - 30, e2, k2);
                break;
            }
            case 34: 
            case 35: 
            case 36: 
            case 37: {
                this.a(m.h, n3 - 34, e2, k2);
                break;
            }
            case 38: 
            case 39: 
            case 40: 
            case 41: {
                this.a(m.a, n3 - 38, e2, k2);
                break;
            }
            case 42: 
            case 43: 
            case 44: 
            case 45: {
                this.a(m.n, n3 - 42, e2, k2);
                break;
            }
            case 46: {
                this.a(m.g, e2);
                break;
            }
            case 47: {
                this.a(m.c, e2);
                break;
            }
            case 48: {
                this.a(m.h, e2);
                break;
            }
            case 49: {
                this.a(m.a, e2);
                break;
            }
            case 50: {
                this.a(m.n, e2);
                break;
            }
            case 51: 
            case 52: 
            case 53: {
                this.a(m.g, e2);
                break;
            }
            case 54: {
                this.b(m.g, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 55: {
                this.b(m.c, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 56: {
                this.b(m.h, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 57: {
                this.b(m.a, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 58: {
                this.b(m.n, u2.a(n2 + 1), e2, k2);
                break;
            }
            case 59: 
            case 60: 
            case 61: 
            case 62: {
                this.b(m.g, n3 - 59, e2, k2);
                break;
            }
            case 63: 
            case 64: 
            case 65: 
            case 66: {
                this.b(m.c, n3 - 63, e2, k2);
                break;
            }
            case 67: 
            case 68: 
            case 69: 
            case 70: {
                this.b(m.h, n3 - 67, e2, k2);
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: {
                this.b(m.a, n3 - 71, e2, k2);
                break;
            }
            case 75: 
            case 76: 
            case 77: 
            case 78: {
                this.b(m.n, n3 - 75, e2, k2);
                break;
            }
            case 79: {
                this.b(m.g, e2);
                break;
            }
            case 80: {
                this.b(m.c, e2);
                break;
            }
            case 81: {
                this.b(m.h, e2);
                break;
            }
            case 82: {
                this.b(m.a, e2);
                break;
            }
            case 83: {
                this.b(m.n, e2);
                break;
            }
            case 84: 
            case 85: 
            case 86: {
                this.b(m.g, e2);
                break;
            }
            case 87: {
                if (e2.b() != m.l) break;
                throw new i("POP can not be used with a category 2 value, pos = " + n2);
            }
            case 88: {
                e2.b();
                e2.b();
                break;
            }
            case 89: {
                m m2 = e2.a();
                if (m2 == m.l) {
                    throw new i("DUP can not be used with a category 2 value, pos = " + n2);
                }
                e2.a(e2.a());
                break;
            }
            case 90: 
            case 91: {
                int n4;
                m m3 = e2.a();
                if (m3 == m.l) {
                    throw new i("DUP can not be used with a category 2 value, pos = " + n2);
                }
                int n5 = n4 - (n3 - 90) - 1;
                e2.a(m3);
                for (n4 = e2.a(); n4 > n5; --n4) {
                    e2.b(n4, e2.b(n4 - 1));
                }
                e2.b(n5, m3);
                break;
            }
            case 92: {
                e2.a(e2.b(e2.a() - 1));
                e2.a(e2.b(e2.a() - 1));
                break;
            }
            case 93: 
            case 94: {
                int n6;
                int n7 = n6 - (n3 - 93) - 1;
                m m4 = e2.b(e2.a() - 1);
                m m5 = e2.a();
                e2.a(m4);
                e2.a(m5);
                for (n6 = e2.a(); n6 > n7; --n6) {
                    e2.b(n6, e2.b(n6 - 2));
                }
                e2.b(n7, m5);
                e2.b(n7 - 1, m4);
                break;
            }
            case 95: {
                m m6 = e2.b();
                m m7 = e2.b();
                if (m6.b() == 2 || m7.b() == 2) {
                    throw new i("Swap can not be used with category 2 values, pos = " + n2);
                }
                e2.a(m6);
                e2.a(m7);
                break;
            }
            case 96: {
                this.c(m.g, e2);
                break;
            }
            case 97: {
                this.c(m.c, e2);
                break;
            }
            case 98: {
                this.c(m.h, e2);
                break;
            }
            case 99: {
                this.c(m.a, e2);
                break;
            }
            case 100: {
                this.c(m.g, e2);
                break;
            }
            case 101: {
                this.c(m.c, e2);
                break;
            }
            case 102: {
                this.c(m.h, e2);
                break;
            }
            case 103: {
                this.c(m.a, e2);
                break;
            }
            case 104: {
                this.c(m.g, e2);
                break;
            }
            case 105: {
                this.c(m.c, e2);
                break;
            }
            case 106: {
                this.c(m.h, e2);
                break;
            }
            case 107: {
                this.c(m.a, e2);
                break;
            }
            case 108: {
                this.c(m.g, e2);
                break;
            }
            case 109: {
                this.c(m.c, e2);
                break;
            }
            case 110: {
                this.c(m.h, e2);
                break;
            }
            case 111: {
                this.c(m.a, e2);
                break;
            }
            case 112: {
                this.c(m.g, e2);
                break;
            }
            case 113: {
                this.c(m.c, e2);
                break;
            }
            case 114: {
                this.c(m.h, e2);
                break;
            }
            case 115: {
                this.c(m.a, e2);
                break;
            }
            case 116: {
                this.a(m.g, this.a(e2));
                break;
            }
            case 117: {
                this.a(m.c, this.a(e2));
                break;
            }
            case 118: {
                this.a(m.h, this.a(e2));
                break;
            }
            case 119: {
                this.a(m.a, this.a(e2));
                break;
            }
            case 120: {
                this.d(m.g, e2);
                break;
            }
            case 121: {
                this.d(m.c, e2);
                break;
            }
            case 122: {
                this.d(m.g, e2);
                break;
            }
            case 123: {
                this.d(m.c, e2);
                break;
            }
            case 124: {
                this.d(m.g, e2);
                break;
            }
            case 125: {
                this.d(m.c, e2);
                break;
            }
            case 126: {
                this.c(m.g, e2);
                break;
            }
            case 127: {
                this.c(m.c, e2);
                break;
            }
            case 128: {
                this.c(m.g, e2);
                break;
            }
            case 129: {
                this.c(m.c, e2);
                break;
            }
            case 130: {
                this.c(m.g, e2);
                break;
            }
            case 131: {
                this.c(m.c, e2);
                break;
            }
            case 132: {
                int n8 = u2.a(n2 + 1);
                this.a(m.g, e2.a(n8));
                this.a(n8, m.g, k2);
                break;
            }
            case 133: {
                this.a(m.g, this.b(e2));
                this.e(m.c, e2);
                break;
            }
            case 134: {
                this.a(m.g, this.b(e2));
                this.e(m.h, e2);
                break;
            }
            case 135: {
                this.a(m.g, this.b(e2));
                this.e(m.a, e2);
                break;
            }
            case 136: {
                this.a(m.c, this.b(e2));
                this.e(m.g, e2);
                break;
            }
            case 137: {
                this.a(m.c, this.b(e2));
                this.e(m.h, e2);
                break;
            }
            case 138: {
                this.a(m.c, this.b(e2));
                this.e(m.a, e2);
                break;
            }
            case 139: {
                this.a(m.h, this.b(e2));
                this.e(m.g, e2);
                break;
            }
            case 140: {
                this.a(m.h, this.b(e2));
                this.e(m.c, e2);
                break;
            }
            case 141: {
                this.a(m.h, this.b(e2));
                this.e(m.a, e2);
                break;
            }
            case 142: {
                this.a(m.a, this.b(e2));
                this.e(m.g, e2);
                break;
            }
            case 143: {
                this.a(m.a, this.b(e2));
                this.e(m.c, e2);
                break;
            }
            case 144: {
                this.a(m.a, this.b(e2));
                this.e(m.h, e2);
                break;
            }
            case 145: 
            case 146: 
            case 147: {
                this.a(m.g, e2.a());
                break;
            }
            case 148: {
                this.a(m.c, this.b(e2));
                this.a(m.c, this.b(e2));
                e2.a(m.g);
                break;
            }
            case 149: 
            case 150: {
                this.a(m.h, this.b(e2));
                this.a(m.h, this.b(e2));
                e2.a(m.g);
                break;
            }
            case 151: 
            case 152: {
                this.a(m.a, this.b(e2));
                this.a(m.a, this.b(e2));
                e2.a(m.g);
                break;
            }
            case 153: 
            case 154: 
            case 155: 
            case 156: 
            case 157: 
            case 158: {
                this.a(m.g, this.b(e2));
                break;
            }
            case 159: 
            case 160: 
            case 161: 
            case 162: 
            case 163: 
            case 164: {
                this.a(m.g, this.b(e2));
                this.a(m.g, this.b(e2));
                break;
            }
            case 165: 
            case 166: {
                this.a(m.n, this.b(e2));
                this.a(m.n, this.b(e2));
                break;
            }
            case 167: {
                break;
            }
            case 168: {
                e2.a(m.k);
                break;
            }
            case 169: {
                this.a(m.k, e2.a(u2.a(n2 + 1)));
                break;
            }
            case 170: 
            case 171: 
            case 172: {
                this.a(m.g, this.b(e2));
                break;
            }
            case 173: {
                this.a(m.c, this.b(e2));
                break;
            }
            case 174: {
                this.a(m.h, this.b(e2));
                break;
            }
            case 175: {
                this.a(m.a, this.b(e2));
                break;
            }
            case 176: {
                try {
                    CtClass ctClass = M.a(al2.b(), this.a);
                    this.a(m.a(ctClass), this.b(e2));
                    break;
                } catch (aa aa2) {
                    throw new RuntimeException(aa2);
                }
            }
            case 177: {
                break;
            }
            case 178: {
                this.a(n3, u2.c(n2 + 1), e2);
                break;
            }
            case 179: {
                this.e(n3, u2.c(n2 + 1), e2);
                break;
            }
            case 180: {
                this.a(n3, u2.c(n2 + 1), e2);
                break;
            }
            case 181: {
                this.e(n3, u2.c(n2 + 1), e2);
                break;
            }
            case 182: 
            case 183: 
            case 184: {
                this.c(n3, u2.c(n2 + 1), e2);
                break;
            }
            case 185: {
                this.b(n3, u2.c(n2 + 1), e2);
                break;
            }
            case 186: {
                this.d(n3, u2.c(n2 + 1), e2);
                break;
            }
            case 187: {
                e2.a(this.c(this.a.a(u2.c(n2 + 1))));
                break;
            }
            case 188: {
                this.a(n2, u2, e2);
                break;
            }
            case 189: {
                this.b(n2, u2, e2);
                break;
            }
            case 190: {
                m m8 = this.b(e2);
                if (!m8.b() && m8 != m.j) {
                    throw new i("Array length passed a non-array [pos = " + n2 + "]: " + m8);
                }
                e2.a(m.g);
                break;
            }
            case 191: {
                this.a(this.c, this.b(e2));
                break;
            }
            case 192: {
                this.a(m.n, this.b(e2));
                e2.a(this.d(this.a.b(u2.c(n2 + 1))));
                break;
            }
            case 193: {
                this.a(m.n, this.b(e2));
                e2.a(m.g);
                break;
            }
            case 194: 
            case 195: {
                this.a(m.n, this.b(e2));
                break;
            }
            case 196: {
                this.a(n2, u2, e2, k2);
                break;
            }
            case 197: {
                this.b(n2, u2, e2);
                break;
            }
            case 198: 
            case 199: {
                this.a(m.n, this.b(e2));
                break;
            }
            case 200: {
                break;
            }
            case 201: {
                e2.a(m.k);
            }
        }
    }

    private m a(m m2) {
        if (m2 == m.f || m2 == m.e || m2 == m.d || m2 == m.b) {
            return m.g;
        }
        return m2;
    }

    private void a(m m2, e e2) {
        m m3 = e2.b();
        m m4 = e2.b();
        if (m4 == m.j) {
            this.a(m.g, m3);
            if (m2 == m.n) {
                this.e(m.j, e2);
            } else {
                this.e(m2, e2);
            }
            return;
        }
        m m5 = m4.a();
        if (m5 == null) {
            throw new i("Not an array! [pos = " + this.a + "]: " + m5);
        }
        m5 = this.a(m5);
        this.a(m2, m5);
        this.a(m.g, m3);
        this.e(m5, e2);
    }

    private void b(m m2, e e2) {
        m m3 = this.b(e2);
        m m4 = e2.b();
        m m5 = e2.b();
        if (m5 == m.j) {
            this.a(m.g, m4);
            return;
        }
        m m6 = m5.a();
        if (m6 == null) {
            throw new i("Not an array! [pos = " + this.a + "]: " + m6);
        }
        m6 = this.a(m6);
        this.a(m2, m6);
        this.a(m.g, m4);
        if (m2 == m.n) {
            this.a(m2, m3);
        } else {
            this.a(m6, m3);
        }
    }

    private void c(m m2, e e2) {
        m m3 = this.b(e2);
        m m4 = this.b(e2);
        this.a(m2, m3);
        this.a(m2, m4);
        this.e(m4, e2);
    }

    private void a(int n2, int n3, e e2) {
        String string = this.a.e(n3);
        m m2 = this.a(this.d(string));
        if (n2 == 180) {
            m m3 = this.c(this.a.c(n3));
            this.a(m3, this.b(e2));
        }
        this.e(m2, e2);
    }

    private void b(int n2, int n3, e e2) {
        String string = this.a.k(n3);
        m[] mArray = this.a(string);
        int n4 = mArray.length;
        while (n4 > 0) {
            this.a(this.a(mArray[--n4]), this.b(e2));
        }
        String string2 = this.a.i(n3);
        m m2 = this.c(string2);
        this.a(m2, this.b(e2));
        m m3 = this.b(string);
        if (m3 != m.i) {
            this.e(this.a(m3), e2);
        }
    }

    private void c(int n2, int n3, e e2) {
        m m2;
        String string = this.a.h(n3);
        m[] mArray = this.a(string);
        int n4 = mArray.length;
        while (n4 > 0) {
            this.a(this.a(mArray[--n4]), this.b(e2));
        }
        if (n2 != 184) {
            m2 = this.c(this.a.f(n3));
            this.a(m2, this.b(e2));
        }
        if ((m2 = this.b(string)) != m.i) {
            this.e(this.a(m2), e2);
        }
    }

    private void d(int n2, int n3, e e2) {
        String string = this.a.n(n3);
        m[] mArray = this.a(string);
        int n4 = mArray.length;
        while (n4 > 0) {
            this.a(this.a(mArray[--n4]), this.b(e2));
        }
        m m2 = this.b(string);
        if (m2 != m.i) {
            this.e(this.a(m2), e2);
        }
    }

    private void a(int n2, e e2) {
        m m2;
        int n3 = this.a.a(n2);
        switch (n3) {
            case 8: {
                m2 = this.a;
                break;
            }
            case 3: {
                m2 = m.g;
                break;
            }
            case 4: {
                m2 = m.h;
                break;
            }
            case 5: {
                m2 = m.c;
                break;
            }
            case 6: {
                m2 = m.a;
                break;
            }
            case 7: {
                m2 = this.b;
                break;
            }
            default: {
                throw new i("bad LDC [pos = " + this.a + "]: " + n3);
            }
        }
        this.e(m2, e2);
    }

    private void a(m m2, int n2, e e2, k k2) {
        m m3 = e2.a(n2);
        this.a(m2, m3);
        this.e(m3, e2);
        this.a(n2, m3, k2);
    }

    private void a(int n2, u u2, e e2) {
        this.a(m.g, this.b(e2));
        m m2 = null;
        int n3 = u2.a(n2 + 1);
        switch (n3) {
            case 4: {
                m2 = this.a("boolean[]");
                break;
            }
            case 5: {
                m2 = this.a("char[]");
                break;
            }
            case 8: {
                m2 = this.a("byte[]");
                break;
            }
            case 9: {
                m2 = this.a("short[]");
                break;
            }
            case 10: {
                m2 = this.a("int[]");
                break;
            }
            case 11: {
                m2 = this.a("long[]");
                break;
            }
            case 6: {
                m2 = this.a("float[]");
                break;
            }
            case 7: {
                m2 = this.a("double[]");
                break;
            }
            default: {
                throw new i("Invalid array type [pos = " + n2 + "]: " + n3);
            }
        }
        e2.a(m2);
    }

    private void b(int n2, u u2, e e2) {
        int n3;
        m m2 = this.c(this.a.a(u2.c(n2 + 1)));
        String string = m2.a().a();
        int n4 = u2.a(n2);
        if (n4 == 197) {
            n3 = u2.a(n2 + 3);
        } else {
            string = string + "[]";
            n3 = 1;
        }
        while (n3-- > 0) {
            this.a(m.g, this.b(e2));
        }
        this.e(this.a(string), e2);
    }

    private void e(int n2, int n3, e e2) {
        String string = this.a.e(n3);
        m m2 = this.a(this.d(string));
        this.a(m2, this.b(e2));
        if (n2 == 181) {
            m m3 = this.c(this.a.c(n3));
            this.a(m3, this.b(e2));
        }
    }

    private void d(m m2, e e2) {
        m m3 = this.b(e2);
        m m4 = this.b(e2);
        this.a(m.g, m3);
        this.a(m2, m4);
        this.e(m4, e2);
    }

    private void b(m m2, int n2, e e2, k k2) {
        m m3 = this.b(e2);
        if (m2 != m.n || m3 != m.k) {
            this.a(m2, m3);
        }
        this.a(n2, m3, e2);
        this.a(n2, m3, k2);
    }

    private void a(int n2, u u2, e e2, k k2) {
        int n3 = u2.a(n2 + 1);
        int n4 = u2.c(n2 + 2);
        switch (n3) {
            case 21: {
                this.a(m.g, n4, e2, k2);
                break;
            }
            case 22: {
                this.a(m.c, n4, e2, k2);
                break;
            }
            case 23: {
                this.a(m.h, n4, e2, k2);
                break;
            }
            case 24: {
                this.a(m.a, n4, e2, k2);
                break;
            }
            case 25: {
                this.a(m.n, n4, e2, k2);
                break;
            }
            case 54: {
                this.b(m.g, n4, e2, k2);
                break;
            }
            case 55: {
                this.b(m.c, n4, e2, k2);
                break;
            }
            case 56: {
                this.b(m.h, n4, e2, k2);
                break;
            }
            case 57: {
                this.b(m.a, n4, e2, k2);
                break;
            }
            case 58: {
                this.b(m.n, n4, e2, k2);
                break;
            }
            case 132: {
                this.a(m.g, e2.a(n4));
                break;
            }
            case 169: {
                this.a(m.k, e2.a(n4));
                break;
            }
            default: {
                throw new i("Invalid WIDE operand [pos = " + n2 + "]: " + n3);
            }
        }
    }

    private m a(String string) {
        try {
            return m.a(this.a.c(string));
        } catch (aa aa2) {
            throw new i("Could not find class [pos = " + this.a + "]: " + string);
        }
    }

    private m[] a(String string) {
        CtClass[] ctClassArray = null;
        try {
            ctClassArray = M.a(string, this.a);
        } catch (aa aa2) {
            throw new i("Could not find class in descriptor [pos = " + this.a + "]: " + aa2.getMessage());
        }
        if (ctClassArray == null) {
            throw new i("Could not obtain parameters for descriptor [pos = " + this.a + "]: " + string);
        }
        m[] mArray = new m[ctClassArray.length];
        for (int i2 = 0; i2 < mArray.length; ++i2) {
            mArray[i2] = m.a(ctClassArray[i2]);
        }
        return mArray;
    }

    private m b(String string) {
        CtClass ctClass = null;
        try {
            ctClass = M.a(string, this.a);
        } catch (aa aa2) {
            throw new i("Could not find class in descriptor [pos = " + this.a + "]: " + aa2.getMessage());
        }
        if (ctClass == null) {
            throw new i("Could not obtain return type for descriptor [pos = " + this.a + "]: " + string);
        }
        return m.a(ctClass);
    }

    private m a(e e2) {
        m m2 = e2.a();
        return m2 == m.l ? e2.b(e2.a() - 1) : m2;
    }

    private m b(e e2) {
        m m2 = e2.b();
        return m2 == m.l ? e2.b() : m2;
    }

    private void e(m m2, e e2) {
        e2.a(m2);
        if (m2.b() == 2) {
            e2.a(m.l);
        }
    }

    private void a(int n2, m m2, k k2) {
        if (k2 == null) {
            return;
        }
        k2.b(n2);
        if (m2.b() == 2) {
            k2.b(n2 + 1);
        }
    }

    private void a(int n2, m m2, e e2) {
        e2.a(n2, m2);
        if (m2.b() == 2) {
            e2.a(n2 + 1, m.l);
        }
    }

    private m c(String string) {
        CtClass ctClass = null;
        try {
            ctClass = string.charAt(0) == '[' ? M.b(string, this.a) : this.a.c(string);
        } catch (aa aa2) {
            throw new i("Could not find class in descriptor [pos = " + this.a + "]: " + aa2.getMessage());
        }
        if (ctClass == null) {
            throw new i("Could not obtain type for descriptor [pos = " + this.a + "]: " + string);
        }
        return m.a(ctClass);
    }

    private m d(String string) {
        CtClass ctClass = null;
        try {
            ctClass = M.b(string, this.a);
        } catch (aa aa2) {
            throw new i("Could not find class in descriptor [pos = " + this.a + "]: " + aa2.getMessage());
        }
        if (ctClass == null) {
            throw new i("Could not obtain type for descriptor [pos = " + this.a + "]: " + string);
        }
        return m.a(ctClass);
    }

    private void a(m m2, m m3) {
        if (!m2.a(m3)) {
            throw new i("Expected type: " + m2 + " Got: " + m3 + " [pos = " + this.a + "]");
        }
    }
}

