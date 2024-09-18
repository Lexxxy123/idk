/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import javassist.bytecode.i;
import javassist.bytecode.stackmap.b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a {
    protected int a;
    protected int b;
    protected int c;
    protected a[] a;
    protected boolean a;
    protected b a;

    protected a(int n2) {
        this.a = n2;
        this.b = 0;
        this.c = 0;
    }

    public static a a(a[] aArray, int n2) {
        for (a a2 : aArray) {
            if (a2.a > n2 || n2 >= a2.a + a2.b) continue;
            return a2;
        }
        throw new i("no basic block at " + n2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String string = this.getClass().getName();
        int n2 = string.lastIndexOf(46);
        stringBuffer.append(n2 < 0 ? string : string.substring(n2 + 1));
        stringBuffer.append("[");
        this.a(stringBuffer);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /*
     * WARNING - void declaration
     */
    protected void a(StringBuffer stringBuffer) {
        void var2_4;
        stringBuffer.append("pos=").append(this.a).append(", len=").append(this.b).append(", in=").append(this.c).append(", exit{");
        if (this.a != null) {
            for (a a2 : this.a) {
                stringBuffer.append(a2.a).append(",");
            }
        }
        stringBuffer.append("}, {");
        b b2 = this.a;
        while (var2_4 != null) {
            stringBuffer.append("(").append(var2_4.a.a).append(", ").append(var2_4.a).append("), ");
            b b3 = var2_4.a;
        }
        stringBuffer.append("}");
    }
}

