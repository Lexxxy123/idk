/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aF;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aH {
    aF a;
    char a;

    aH(aF aF2, char c2) {
        this.a = aF2;
        this.a = c2;
    }

    public aH(aF aF2) {
        this(aF2, ' ');
    }

    public aH() {
        this(null, '*');
    }

    public static aH a(aF aF2) {
        return new aH(aF2, '+');
    }

    public static aH b(aF aF2) {
        return new aH(aF2, '-');
    }

    public char a() {
        return this.a;
    }

    public boolean a() {
        return this.a != ' ';
    }

    public aF a() {
        return this.a;
    }

    public String toString() {
        if (this.a == '*') {
            return "?";
        }
        String string = this.a.toString();
        if (this.a == ' ') {
            return string;
        }
        if (this.a == '+') {
            return "? extends " + string;
        }
        return "? super " + string;
    }

    static void a(StringBuffer stringBuffer, aH[] aHArray) {
        stringBuffer.append('<');
        for (int i2 = 0; i2 < aHArray.length; ++i2) {
            aH aH2 = aHArray[i2];
            if (aH2.a()) {
                stringBuffer.append(aH2.a);
            }
            if (aH2.a() == null) continue;
            aH2.a().a(stringBuffer);
        }
        stringBuffer.append('>');
    }
}

