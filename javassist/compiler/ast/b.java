/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import java.io.Serializable;
import javassist.compiler.ast.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class b
implements Serializable {
    private static final long a = 1L;

    public b a() {
        return null;
    }

    public b b() {
        return null;
    }

    public void a(b b2) {
    }

    public void b(b b2) {
    }

    public abstract void a(x var1);

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('<');
        stringBuffer.append(this.a());
        stringBuffer.append('>');
        return stringBuffer.toString();
    }

    protected String a() {
        String string = this.getClass().getName();
        return string.substring(string.lastIndexOf(46) + 1);
    }
}

