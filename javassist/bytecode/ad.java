/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aF;
import javassist.bytecode.aG;
import javassist.bytecode.aI;
import javassist.bytecode.az;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aD {
    aI[] a;
    aG[] a;
    aG a;
    aF[] a;

    public aD(aI[] aIArray, aG[] aGArray, aG aG2, aF[] aFArray) {
        this.a = aIArray == null ? new aI[]{} : aIArray;
        this.a = aGArray == null ? new aG[]{} : aGArray;
        this.a = aG2 == null ? new az("void") : aG2;
        this.a = aFArray == null ? new aF[]{} : aFArray;
    }

    public aI[] a() {
        return this.a;
    }

    public aG[] a() {
        return this.a;
    }

    public aG a() {
        return this.a;
    }

    public aF[] a() {
        return this.a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        aI.a(stringBuffer, this.a);
        stringBuffer.append(" (");
        aG.a(stringBuffer, this.a);
        stringBuffer.append(") ");
        stringBuffer.append(this.a);
        if (this.a.length > 0) {
            stringBuffer.append(" throws ");
            aG.a(stringBuffer, this.a);
        }
        return stringBuffer.toString();
    }

    public String a() {
        int n2;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.a.length > 0) {
            stringBuffer.append('<');
            for (n2 = 0; n2 < this.a.length; ++n2) {
                this.a[n2].a(stringBuffer);
            }
            stringBuffer.append('>');
        }
        stringBuffer.append('(');
        for (n2 = 0; n2 < this.a.length; ++n2) {
            this.a[n2].a(stringBuffer);
        }
        stringBuffer.append(')');
        this.a.a(stringBuffer);
        if (this.a.length > 0) {
            for (n2 = 0; n2 < this.a.length; ++n2) {
                stringBuffer.append('^');
                this.a[n2].a(stringBuffer);
            }
        }
        return stringBuffer.toString();
    }
}

