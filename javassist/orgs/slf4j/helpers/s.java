/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import javassist.orgs.slf4j.helpers.t;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class s {
    private static t a;
    private static boolean a;

    static {
        a = false;
    }

    private s() {
    }

    public static String a(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null input");
        }
        String string2 = null;
        try {
            string2 = System.getProperty(string);
        } catch (SecurityException securityException) {
            // empty catch block
        }
        return string2;
    }

    public static boolean a(String string) {
        String string2 = s.a(string);
        if (string2 == null) {
            return false;
        }
        return string2.equalsIgnoreCase("true");
    }

    private static t a() {
        if (a != null) {
            return a;
        }
        if (a) {
            return null;
        }
        a = s.b();
        a = true;
        return a;
    }

    private static t b() {
        try {
            return new t(null);
        } catch (SecurityException securityException) {
            return null;
        }
    }

    public static Class<?> a() {
        t t2 = s.a();
        if (t2 == null) {
            return null;
        }
        Class<?>[] classArray = t2.getClassContext();
        String string = s.class.getName();
        int n2 = 0;
        while (n2 < classArray.length) {
            if (string.equals(classArray[n2].getName())) break;
            ++n2;
        }
        if (n2 >= classArray.length || n2 + 2 >= classArray.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classArray[n2 + 2];
    }

    public static final void a(String string, Throwable throwable) {
        System.err.println(string);
        System.err.println("Reported exception:");
        throwable.printStackTrace();
    }

    public static final void a(String string) {
        System.err.println("SLF4J: " + string);
    }
}

