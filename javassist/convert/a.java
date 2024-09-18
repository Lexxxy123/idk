/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.convert;

import javassist.CtClass;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.al;
import javassist.bytecode.analysis.e;
import javassist.bytecode.u;
import javassist.bytecode.y;
import javassist.convert.k;
import javassist.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class a
extends k {
    private final String a;
    private final i a;
    private e[] a;
    private int a;

    public a(k k2, String string, i i2) {
        super(k2);
        this.a = string;
        this.a = i2;
    }

    @Override
    public void a(J j2, CtClass ctClass, al al2) {
        u u2 = al2.a().a();
        while (u2.a()) {
            try {
                int n2 = u2.d();
                int n3 = u2.a(n2);
                if (n3 == 50) {
                    this.a(ctClass, al2);
                }
                if (n3 == 50 || n3 == 51 || n3 == 52 || n3 == 49 || n3 == 48 || n3 == 46 || n3 == 47 || n3 == 53) {
                    n2 = this.a(j2, u2, n2, n3, this.c(n3));
                    continue;
                }
                if (n3 != 83 && n3 != 84 && n3 != 85 && n3 != 82 && n3 != 81 && n3 != 79 && n3 != 80 && n3 != 86) continue;
                n2 = this.a(j2, u2, n2, n3, this.d(n3));
            } catch (Exception exception) {
                throw new javassist.a(exception);
            }
        }
    }

    @Override
    public void a() {
        this.a = null;
        this.a = -1;
    }

    @Override
    public int a(CtClass ctClass, int n2, u u2, J j2) {
        return n2;
    }

    private e a(int n2) {
        return this.a[n2 - this.a];
    }

    private void a(CtClass ctClass, al al2) {
        if (this.a == null) {
            this.a = new javassist.bytecode.analysis.a().a(ctClass, al2);
            this.a = 0;
        }
    }

    private int a(int n2, int n3) {
        if (this.a > -1) {
            this.a += n3;
        }
        return n2 + n3;
    }

    private String a(int n2) {
        e e2 = this.a(n2);
        if (e2 == null) {
            return null;
        }
        CtClass ctClass = e2.a().a();
        return ctClass != null ? M.a(ctClass) : null;
    }

    private int a(J j2, u u2, int n2, int n3, String string) {
        String string2 = null;
        String string3 = this.b(n3);
        if (string3 != null) {
            if (n3 == 50) {
                string2 = this.a(u2.e());
                if (string2 == null) {
                    return n2;
                }
                if ("java/lang/Object".equals(string2)) {
                    string2 = null;
                }
            }
            u2.a(0, n2);
            y y2 = u2.a(n2, string2 != null ? 5 : 2, false);
            n2 = y2.a;
            int n4 = j2.a(this.a);
            int n5 = j2.b(n4, string3, string);
            u2.a(184, n2);
            u2.b(n5, n2 + 1);
            if (string2 != null) {
                int n6 = j2.a(string2);
                u2.a(192, n2 + 3);
                u2.b(n6, n2 + 4);
            }
            n2 = this.a(n2, y2.b);
        }
        return n2;
    }

    private String b(int n2) {
        String string = null;
        switch (n2) {
            case 50: {
                string = this.a.m();
                break;
            }
            case 51: {
                string = this.a.a();
                break;
            }
            case 52: {
                string = this.a.c();
                break;
            }
            case 49: {
                string = this.a.e();
                break;
            }
            case 48: {
                string = this.a.g();
                break;
            }
            case 46: {
                string = this.a.i();
                break;
            }
            case 53: {
                string = this.a.o();
                break;
            }
            case 47: {
                string = this.a.k();
                break;
            }
            case 83: {
                string = this.a.n();
                break;
            }
            case 84: {
                string = this.a.b();
                break;
            }
            case 85: {
                string = this.a.d();
                break;
            }
            case 82: {
                string = this.a.f();
                break;
            }
            case 81: {
                string = this.a.h();
                break;
            }
            case 79: {
                string = this.a.j();
                break;
            }
            case 86: {
                string = this.a.p();
                break;
            }
            case 80: {
                string = this.a.l();
            }
        }
        if (string.equals("")) {
            string = null;
        }
        return string;
    }

    private String c(int n2) {
        switch (n2) {
            case 50: {
                return "(Ljava/lang/Object;I)Ljava/lang/Object;";
            }
            case 51: {
                return "(Ljava/lang/Object;I)B";
            }
            case 52: {
                return "(Ljava/lang/Object;I)C";
            }
            case 49: {
                return "(Ljava/lang/Object;I)D";
            }
            case 48: {
                return "(Ljava/lang/Object;I)F";
            }
            case 46: {
                return "(Ljava/lang/Object;I)I";
            }
            case 53: {
                return "(Ljava/lang/Object;I)S";
            }
            case 47: {
                return "(Ljava/lang/Object;I)J";
            }
        }
        throw new javassist.bytecode.i(n2);
    }

    private String d(int n2) {
        switch (n2) {
            case 83: {
                return "(Ljava/lang/Object;ILjava/lang/Object;)V";
            }
            case 84: {
                return "(Ljava/lang/Object;IB)V";
            }
            case 85: {
                return "(Ljava/lang/Object;IC)V";
            }
            case 82: {
                return "(Ljava/lang/Object;ID)V";
            }
            case 81: {
                return "(Ljava/lang/Object;IF)V";
            }
            case 79: {
                return "(Ljava/lang/Object;II)V";
            }
            case 86: {
                return "(Ljava/lang/Object;IS)V";
            }
            case 80: {
                return "(Ljava/lang/Object;IJ)V";
            }
        }
        throw new javassist.bytecode.i(n2);
    }
}

