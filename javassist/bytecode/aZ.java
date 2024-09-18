/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.CtClass;
import javassist.bytecode.M;
import javassist.bytecode.aG;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class az
extends aG {
    char a;

    az(char c2) {
        this.a = c2;
    }

    public az(String string) {
        this(M.d(string).charAt(0));
    }

    public char a() {
        return this.a;
    }

    public CtClass a() {
        return M.a(this.a);
    }

    public String toString() {
        return M.c(Character.toString(this.a));
    }

    @Override
    void a(StringBuffer stringBuffer) {
        stringBuffer.append(this.a);
    }
}

