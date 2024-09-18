/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j;

import java.io.Serializable;
import java.util.Iterator;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface h
extends Serializable {
    public static final String a = "*";
    public static final String b = "+";

    public String a();

    public void a(h var1);

    public boolean a(h var1);

    @Deprecated
    public boolean a();

    public boolean b();

    public Iterator<h> a();

    public boolean b(h var1);

    public boolean a(String var1);

    public boolean equals(Object var1);

    public int hashCode();
}

