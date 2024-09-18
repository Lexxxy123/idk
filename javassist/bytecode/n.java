/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class N {
    private String a;
    private int a;
    private int b;
    private boolean a;

    public N(String string) {
        this.a = string;
        this.b = 0;
        this.a = 0;
        this.a = false;
    }

    public boolean a() {
        return this.a < this.a.length();
    }

    public boolean b() {
        return this.a;
    }

    public char a() {
        return this.a.charAt(this.b);
    }

    public boolean c() {
        char c2 = this.a();
        return c2 == 'D' || c2 == 'J';
    }

    public int a() {
        int n2 = this.a;
        char c2 = this.a.charAt(n2);
        if (c2 == '(') {
            ++this.a;
            c2 = this.a.charAt(++n2);
            this.a = true;
        }
        if (c2 == ')') {
            ++this.a;
            c2 = this.a.charAt(++n2);
            this.a = false;
        }
        while (c2 == '[') {
            c2 = this.a.charAt(++n2);
        }
        if (c2 == 'L') {
            if ((n2 = this.a.indexOf(59, n2) + 1) <= 0) {
                throw new IndexOutOfBoundsException("bad descriptor");
            }
        } else {
            ++n2;
        }
        this.b = this.a;
        this.a = n2;
        return this.b;
    }
}

