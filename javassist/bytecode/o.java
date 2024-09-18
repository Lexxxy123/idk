/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.CtClass;
import javassist.bytecode.M;

class O {
    O() {
    }

    static String a(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        if (string.charAt(0) == '(') {
            int n2 = 1;
            stringBuffer.append('(');
            while (string.charAt(n2) != ')') {
                if (n2 > 1) {
                    stringBuffer.append(',');
                }
                n2 = O.a(stringBuffer, n2, string);
            }
            stringBuffer.append(')');
        } else {
            O.a(stringBuffer, 0, string);
        }
        return stringBuffer.toString();
    }

    static int a(StringBuffer stringBuffer, int n2, String string) {
        char c2 = string.charAt(n2);
        int n3 = 0;
        while (c2 == '[') {
            ++n3;
            c2 = string.charAt(++n2);
        }
        if (c2 == 'L') {
            while ((c2 = string.charAt(++n2)) != ';') {
                if (c2 == '/') {
                    c2 = '.';
                }
                stringBuffer.append(c2);
            }
        } else {
            CtClass ctClass = M.a(c2);
            stringBuffer.append(ctClass.a());
        }
        while (n3-- > 0) {
            stringBuffer.append("[]");
        }
        return n2 + 1;
    }
}

