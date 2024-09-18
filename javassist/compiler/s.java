/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import javassist.CtClass;
import javassist.bytecode.al;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class s {
    public CtClass a;
    public al a;
    public int a;

    public s(CtClass ctClass, al al2, int n2) {
        this.a = ctClass;
        this.a = al2;
        this.a = n2;
    }

    public boolean a() {
        int n2 = this.a.a();
        return (n2 & 8) != 0;
    }
}

