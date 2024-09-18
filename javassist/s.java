/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class S
extends CtClass {
    private char a;
    private String e;
    private String f;
    private String g;
    private int a;
    private int b;
    private int c;

    S(String string, char c2, String string2, String string3, String string4, int n2, int n3, int n4) {
        super(string);
        this.a = c2;
        this.e = string2;
        this.f = string3;
        this.g = string4;
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    @Override
    public boolean d() {
        return true;
    }

    @Override
    public int a() {
        return 17;
    }

    public char a() {
        return this.a;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }
}

