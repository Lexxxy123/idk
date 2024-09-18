/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.compiler.m;
import javassist.compiler.y;
import javassist.compiler.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class n
implements z {
    private int a;
    private StringBuffer a;
    private y a;
    private y b;
    private String a = new y();
    private int b = null;
    private int aM;
    private int aN;
    private static final int[] b = new int[]{350, 0, 0, 0, 351, 352, 0, 0, 0, 353, 354, 0, 355, 0, 356, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 357, 358, 359, 0};
    private static final m a = new m();

    public n(String string) {
        this.a = string;
        this.b = 0;
        this.aM = string.length();
        this.aN = 0;
    }

    public int a() {
        y y2;
        if (this.b == null) {
            return this.a(this.a);
        }
        this.a = y2 = this.b;
        this.b = this.b.a;
        return y2.a;
    }

    public int b() {
        return this.a(0);
    }

    public int a(int n2) {
        y y2 = this.b;
        if (y2 == null) {
            this.b = y2 = this.a;
            y2.a = null;
            this.a(y2);
        }
        while (n2-- > 0) {
            if (y2.a == null) {
                y y3;
                y2.a = y3 = new y();
                this.a(y3);
            }
            y2 = y2.a;
        }
        this.a = y2;
        return y2.a;
    }

    public String a() {
        return this.a.a;
    }

    public long a() {
        return this.a.a;
    }

    public double a() {
        return this.a.a;
    }

    private int a(y y2) {
        int n2;
        while ((n2 = this.b(y2)) == 10) {
        }
        y2.a = n2;
        return n2;
    }

    private int b(y y2) {
        int n2 = this.c();
        if (n2 < 0) {
            return n2;
        }
        if (n2 == 10) {
            ++this.aN;
            return 10;
        }
        if (n2 == 39) {
            return this.c(y2);
        }
        if (n2 == 34) {
            return this.d(y2);
        }
        if (48 <= n2 && n2 <= 57) {
            return this.a(n2, y2);
        }
        if (n2 == 46) {
            n2 = this.e();
            if (48 <= n2 && n2 <= 57) {
                StringBuffer stringBuffer = this.a;
                stringBuffer.setLength(0);
                stringBuffer.append('.');
                return this.a(stringBuffer, n2, y2);
            }
            this.a(n2);
            return this.b(46);
        }
        if (Character.isJavaIdentifierStart((char)n2)) {
            return this.b(n2, y2);
        }
        return this.b(n2);
    }

    private int c() {
        int n2;
        block0: do {
            if ((n2 = this.e()) != 47) continue;
            n2 = this.e();
            if (n2 == 47) {
                while ((n2 = this.e()) != 10 && n2 != 13 && n2 != -1) {
                }
                continue;
            }
            if (n2 == 42) {
                while ((n2 = this.e()) != -1) {
                    if (n2 != 42) continue;
                    n2 = this.e();
                    if (n2 == 47) {
                        n2 = 32;
                        continue block0;
                    }
                    this.a(n2);
                }
            } else {
                this.a(n2);
                n2 = 47;
            }
        } while (n.a(n2));
        return n2;
    }

    private int c(y y2) {
        int n2;
        int n3 = 0;
        while ((n2 = this.e()) != 39) {
            if (n2 == 92) {
                n3 = this.d();
                continue;
            }
            if (n2 < 32) {
                if (n2 == 10) {
                    ++this.aN;
                }
                return 500;
            }
            n3 = n2;
        }
        y2.a = n3;
        return 401;
    }

    private int d() {
        int n2 = this.e();
        if (n2 == 110) {
            n2 = 10;
        } else if (n2 == 116) {
            n2 = 9;
        } else if (n2 == 114) {
            n2 = 13;
        } else if (n2 == 102) {
            n2 = 12;
        } else if (n2 == 10) {
            ++this.aN;
        }
        return n2;
    }

    private int d(y y2) {
        int n2;
        StringBuffer stringBuffer = this.a;
        stringBuffer.setLength(0);
        while (true) {
            if ((n2 = this.e()) != 34) {
                if (n2 == 92) {
                    n2 = this.d();
                } else if (n2 == 10 || n2 < 0) {
                    ++this.aN;
                    return 500;
                }
                stringBuffer.append((char)n2);
                continue;
            }
            while (true) {
                if ((n2 = this.e()) == 10) {
                    ++this.aN;
                    continue;
                }
                if (!n.a(n2)) break;
            }
            if (n2 != 34) break;
        }
        this.a(n2);
        y2.a = stringBuffer.toString();
        return 406;
    }

    private int a(int n2, y y2) {
        long l2 = 0L;
        int n3 = this.e();
        if (n2 == 48) {
            if (n3 == 88 || n3 == 120) {
                while (true) {
                    if (48 <= (n2 = this.e()) && n2 <= 57) {
                        l2 = l2 * 16L + (long)(n2 - 48);
                        continue;
                    }
                    if (65 <= n2 && n2 <= 70) {
                        l2 = l2 * 16L + (long)(n2 - 65 + 10);
                        continue;
                    }
                    if (97 > n2 || n2 > 102) break;
                    l2 = l2 * 16L + (long)(n2 - 97 + 10);
                }
                y2.a = l2;
                if (n2 == 76 || n2 == 108) {
                    return 403;
                }
                this.a(n2);
                return 402;
            }
            if (48 <= n3 && n3 <= 55) {
                l2 = n3 - 48;
                while (48 <= (n2 = this.e()) && n2 <= 55) {
                    l2 = l2 * 8L + (long)(n2 - 48);
                }
                y2.a = l2;
                if (n2 == 76 || n2 == 108) {
                    return 403;
                }
                this.a(n2);
                return 402;
            }
        }
        l2 = n2 - 48;
        while (48 <= n3 && n3 <= 57) {
            l2 = l2 * 10L + (long)n3 - 48L;
            n3 = this.e();
        }
        y2.a = l2;
        if (n3 == 70 || n3 == 102) {
            y2.a = l2;
            return 404;
        }
        if (n3 == 69 || n3 == 101 || n3 == 68 || n3 == 100 || n3 == 46) {
            StringBuffer stringBuffer = this.a;
            stringBuffer.setLength(0);
            stringBuffer.append(l2);
            return this.a(stringBuffer, n3, y2);
        }
        if (n3 == 76 || n3 == 108) {
            return 403;
        }
        this.a(n3);
        return 402;
    }

    private int a(StringBuffer stringBuffer, int n2, y y2) {
        if (n2 != 69 && n2 != 101 && n2 != 68 && n2 != 100) {
            stringBuffer.append((char)n2);
            while (48 <= (n2 = this.e()) && n2 <= 57) {
                stringBuffer.append((char)n2);
            }
        }
        if (n2 == 69 || n2 == 101) {
            stringBuffer.append((char)n2);
            n2 = this.e();
            if (n2 == 43 || n2 == 45) {
                stringBuffer.append((char)n2);
                n2 = this.e();
            }
            while (48 <= n2 && n2 <= 57) {
                stringBuffer.append((char)n2);
                n2 = this.e();
            }
        }
        try {
            y2.a = Double.parseDouble(stringBuffer.toString());
        } catch (NumberFormatException numberFormatException) {
            return 500;
        }
        if (n2 == 70 || n2 == 102) {
            return 404;
        }
        if (n2 != 68 && n2 != 100) {
            this.a(n2);
        }
        return 405;
    }

    private int b(int n2) {
        int n3;
        if (33 <= n2 && n2 <= 63) {
            int n4 = b[n2 - 33];
            if (n4 == 0) {
                return n2;
            }
            n3 = this.e();
            if (n2 == n3) {
                switch (n2) {
                    case 61: {
                        return 358;
                    }
                    case 43: {
                        return 362;
                    }
                    case 45: {
                        return 363;
                    }
                    case 38: {
                        return 369;
                    }
                    case 60: {
                        int n5 = this.e();
                        if (n5 == 61) {
                            return 365;
                        }
                        this.a(n5);
                        return 364;
                    }
                    case 62: {
                        int n6 = this.e();
                        if (n6 == 61) {
                            return 367;
                        }
                        if (n6 == 62) {
                            n6 = this.e();
                            if (n6 == 61) {
                                return 371;
                            }
                            this.a(n6);
                            return 370;
                        }
                        this.a(n6);
                        return 366;
                    }
                }
            } else if (n3 == 61) {
                return n4;
            }
        } else if (n2 == 94) {
            n3 = this.e();
            if (n3 == 61) {
                return 360;
            }
        } else if (n2 == 124) {
            n3 = this.e();
            if (n3 == 61) {
                return 361;
            }
            if (n3 == 124) {
                return 368;
            }
        } else {
            return n2;
        }
        this.a(n3);
        return n2;
    }

    private int b(int n2, y y2) {
        StringBuffer stringBuffer = this.a;
        stringBuffer.setLength(0);
        do {
            stringBuffer.append((char)n2);
        } while (Character.isJavaIdentifierPart((char)(n2 = this.e())));
        this.a(n2);
        String string = stringBuffer.toString();
        int n3 = a.a(string);
        if (n3 >= 0) {
            return n3;
        }
        y2.a = string;
        return 400;
    }

    private static boolean a(int n2) {
        return n2 == 32 || n2 == 9 || n2 == 12 || n2 == 13 || n2 == 10;
    }

    private static boolean b(int n2) {
        return 48 <= n2 && n2 <= 57;
    }

    private void a(int n2) {
        this.a = n2;
    }

    public String b() {
        int n2;
        int n3 = this.b - 10;
        if (n3 < 0) {
            n3 = 0;
        }
        if ((n2 = this.b + 10) > this.aM) {
            n2 = this.aM;
        }
        return this.a.substring(n3, n2);
    }

    private int e() {
        if (this.a < 0) {
            if (this.b < this.aM) {
                return this.a.charAt(this.b++);
            }
            return -1;
        }
        int n2 = this.a;
        this.a = -1;
        return n2;
    }

    static {
        a.a("abstract", 300);
        a.a("boolean", 301);
        a.a("break", 302);
        a.a("byte", 303);
        a.a("case", 304);
        a.a("catch", 305);
        a.a("char", 306);
        a.a("class", 307);
        a.a("const", 308);
        a.a("continue", 309);
        a.a("default", 310);
        a.a("do", 311);
        a.a("double", 312);
        a.a("else", 313);
        a.a("extends", 314);
        a.a("false", 411);
        a.a("final", 315);
        a.a("finally", 316);
        a.a("float", 317);
        a.a("for", 318);
        a.a("goto", 319);
        a.a("if", 320);
        a.a("implements", 321);
        a.a("import", 322);
        a.a("instanceof", 323);
        a.a("int", 324);
        a.a("interface", 325);
        a.a("long", 326);
        a.a("native", 327);
        a.a("new", 328);
        a.a("null", 412);
        a.a("package", 329);
        a.a("private", 330);
        a.a("protected", 331);
        a.a("public", 332);
        a.a("return", 333);
        a.a("short", 334);
        a.a("static", 335);
        a.a("strictfp", 347);
        a.a("super", 336);
        a.a("switch", 337);
        a.a("synchronized", 338);
        a.a("this", 339);
        a.a("throw", 340);
        a.a("throws", 341);
        a.a("transient", 342);
        a.a("true", 410);
        a.a("try", 343);
        a.a("void", 344);
        a.a("volatile", 345);
        a.a("while", 346);
    }
}

