/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import javassist.orgs.slf4j.a;
import javassist.orgs.slf4j.b;
import javassist.orgs.slf4j.helpers.l;
import javassist.orgs.slf4j.spi.f;
import javassist.orgs.slf4j.spi.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class m
implements i {
    public static String a = "1.8.99";
    private a a;
    private b a;
    private f a = new l();

    @Override
    public a a() {
        return this.a;
    }

    @Override
    public b a() {
        return this.a;
    }

    @Override
    public f a() {
        return this.a;
    }

    @Override
    public String a() {
        return a;
    }

    @Override
    public void a() {
    }
}

