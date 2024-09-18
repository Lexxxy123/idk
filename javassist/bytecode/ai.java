/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aF;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aI {
    String a;
    aF a;
    aF[] a;

    aI(String string, int n2, int n3, aF aF2, aF[] aFArray) {
        this.a = string.substring(n2, n3);
        this.a = aF2;
        this.a = aFArray;
    }

    public aI(String string, aF aF2, aF[] aFArray) {
        this.a = string;
        this.a = aF2;
        this.a = aFArray == null ? new aF[0] : aFArray;
    }

    public aI(String string) {
        this(string, null, null);
    }

    public String a() {
        return this.a;
    }

    public aF a() {
        return this.a;
    }

    public aF[] a() {
        return this.a;
    }

    public String toString() {
        int n2;
        StringBuffer stringBuffer = new StringBuffer(this.a());
        if (this.a != null) {
            stringBuffer.append(" extends ").append(this.a.toString());
        }
        if ((n2 = this.a.length) > 0) {
            for (int i2 = 0; i2 < n2; ++i2) {
                if (i2 > 0 || this.a != null) {
                    stringBuffer.append(" & ");
                } else {
                    stringBuffer.append(" extends ");
                }
                stringBuffer.append(this.a[i2].toString());
            }
        }
        return stringBuffer.toString();
    }

    static void a(StringBuffer stringBuffer, aI[] aIArray) {
        stringBuffer.append('<');
        for (int i2 = 0; i2 < aIArray.length; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(aIArray[i2]);
        }
        stringBuffer.append('>');
    }

    void a(StringBuffer stringBuffer) {
        stringBuffer.append(this.a);
        if (this.a == null) {
            stringBuffer.append(":Ljava/lang/Object;");
        } else {
            stringBuffer.append(':');
            this.a.a(stringBuffer);
        }
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            stringBuffer.append(':');
            this.a[i2].a(stringBuffer);
        }
    }
}

