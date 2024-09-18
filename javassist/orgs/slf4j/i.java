/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j;

import javassist.orgs.slf4j.b;
import javassist.orgs.slf4j.d;
import javassist.orgs.slf4j.h;
import javassist.orgs.slf4j.helpers.e;
import javassist.orgs.slf4j.helpers.s;

public class i {
    static b a;

    static {
        javassist.orgs.slf4j.spi.i i2 = d.a();
        if (i2 != null) {
            a = i2.a();
        } else {
            s.a("Failed to find provider");
            s.a("Defaulting to BasicMarkerFactory.");
            a = new e();
        }
    }

    private i() {
    }

    public static h a(String string) {
        return a.a(string);
    }

    public static h b(String string) {
        return a.b(string);
    }

    public static b a() {
        return a;
    }
}

