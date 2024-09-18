/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import javassist.orgs.slf4j.a;
import javassist.orgs.slf4j.helpers.b;
import javassist.orgs.slf4j.helpers.q;
import javassist.orgs.slf4j.spi.f;
import javassist.orgs.slf4j.spi.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class r
implements i {
    private q a;
    private javassist.orgs.slf4j.b a;
    private f a = new b();

    @Override
    public a a() {
        return this.a;
    }

    @Override
    public q a() {
        return this.a;
    }

    @Override
    public javassist.orgs.slf4j.b a() {
        return this.a;
    }

    @Override
    public f a() {
        return this.a;
    }

    @Override
    public String a() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a() {
    }
}

