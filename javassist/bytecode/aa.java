/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.aB;
import javassist.bytecode.aG;
import javassist.bytecode.aI;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aA {
    aI[] a;
    aB a;
    aB[] a;

    public aA(aI[] aIArray, aB aB2, aB[] aBArray) {
        this.a = aIArray == null ? new aI[]{} : aIArray;
        this.a = aB2 == null ? aB.a : aB2;
        this.a = aBArray == null ? new aB[]{} : aBArray;
    }

    public aA(aI[] aIArray) {
        this(aIArray, null, null);
    }

    public aI[] a() {
        return this.a;
    }

    public aB a() {
        return this.a;
    }

    public aB[] a() {
        return this.a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        aI.a(stringBuffer, this.a);
        stringBuffer.append(" extends ").append(this.a);
        if (this.a.length > 0) {
            stringBuffer.append(" implements ");
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
        this.a.a(stringBuffer);
        for (n2 = 0; n2 < this.a.length; ++n2) {
            this.a[n2].a(stringBuffer);
        }
        return stringBuffer.toString();
    }
}

