/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import java.io.Serializable;
import javassist.orgs.slf4j.c;
import javassist.orgs.slf4j.d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
abstract class n
implements Serializable,
c {
    private static final long a = 7535258609338176893L;
    protected String b;

    n() {
    }

    @Override
    public String a() {
        return this.b;
    }

    protected Object a() {
        return d.a(this.a());
    }
}

