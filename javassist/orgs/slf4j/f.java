/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j;

import java.util.Map;
import javassist.orgs.slf4j.d;
import javassist.orgs.slf4j.g;
import javassist.orgs.slf4j.helpers.l;
import javassist.orgs.slf4j.helpers.s;
import javassist.orgs.slf4j.spi.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class f {
    static final String a = "http://www.slf4j.org/codes.html#null_MDCA";
    static final String b = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
    static javassist.orgs.slf4j.spi.f a;

    static {
        i i2 = d.a();
        if (i2 != null) {
            a = i2.a();
        } else {
            s.a("Failed to find provider.");
            s.a("Defaulting to no-operation MDCAdapter implementation.");
            a = new l();
        }
    }

    private f() {
    }

    public static void a(String string, String string2) {
        if (string == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (a == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        a.a(string, string2);
    }

    public static g a(String string, String string2) {
        f.a(string, string2);
        return new g(string, null);
    }

    public static String a(String string) {
        if (string == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (a == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        return a.a(string);
    }

    public static void a(String string) {
        if (string == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        if (a == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        a.a(string);
    }

    public static void a() {
        if (a == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        a.a();
    }

    public static Map<String, String> a() {
        if (a == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        return a.a();
    }

    public static void a(Map<String, String> map) {
        if (a == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        a.a(map);
    }

    public static javassist.orgs.slf4j.spi.f a() {
        return a;
    }
}

