/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aE;
import javassist.bytecode.aF;
import javassist.bytecode.aH;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aB
extends aF {
    String a;
    aH[] a;
    public static aB a = new aB("java.lang.Object", null);

    static aB a(String string, int n2, int n3, aH[] aHArray, aB aB2) {
        if (aB2 == null) {
            return new aB(string, n2, n3, aHArray);
        }
        return new aE(string, n2, n3, aHArray, aB2);
    }

    aB(String string, int n2, int n3, aH[] aHArray) {
        this.a = string.substring(n2, n3).replace('/', '.');
        this.a = aHArray;
    }

    public aB(String string, aH[] aHArray) {
        this.a = string;
        this.a = aHArray;
    }

    public aB(String string) {
        this(string, null);
    }

    public String a() {
        return this.a;
    }

    public aH[] a() {
        return this.a;
    }

    public aB a() {
        return null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        aB aB2 = this.a();
        if (aB2 != null) {
            stringBuffer.append(aB2.toString()).append('.');
        }
        return this.a(stringBuffer);
    }

    private String a(StringBuffer stringBuffer) {
        stringBuffer.append(this.a);
        if (this.a != null) {
            stringBuffer.append('<');
            int n2 = this.a.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (i2 > 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(this.a[i2].toString());
            }
            stringBuffer.append('>');
        }
        return stringBuffer.toString();
    }

    @Override
    public String b() {
        StringBuffer stringBuffer = new StringBuffer();
        aB aB2 = this.a();
        if (aB2 != null) {
            stringBuffer.append(aB2.b()).append('$');
        }
        return this.a(stringBuffer);
    }

    @Override
    void a(StringBuffer stringBuffer) {
        stringBuffer.append('L');
        this.b(stringBuffer);
        stringBuffer.append(';');
    }

    void b(StringBuffer stringBuffer) {
        aB aB2 = this.a();
        if (aB2 != null) {
            aB2.b(stringBuffer);
            stringBuffer.append('$');
        }
        stringBuffer.append(this.a.replace('.', '/'));
        if (this.a != null) {
            aH.a(stringBuffer, this.a);
        }
    }
}

