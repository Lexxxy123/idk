/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import javassist.orgs.slf4j.a;
import javassist.orgs.slf4j.c;
import javassist.orgs.slf4j.event.h;
import javassist.orgs.slf4j.helpers.m;
import javassist.orgs.slf4j.helpers.p;
import javassist.orgs.slf4j.helpers.q;
import javassist.orgs.slf4j.helpers.r;
import javassist.orgs.slf4j.helpers.s;
import javassist.orgs.slf4j.spi.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class d {
    static final String a = "http://www.slf4j.org/codes.html";
    static final String b = "http://www.slf4j.org/codes.html#noProviders";
    static final String c = "http://www.slf4j.org/codes.html#ignoredBindings";
    static final String d = "http://www.slf4j.org/codes.html#StaticLoggerBinder";
    static final String e = "http://www.slf4j.org/codes.html#multiple_bindings";
    static final String f = "http://www.slf4j.org/codes.html#null_LF";
    static final String g = "http://www.slf4j.org/codes.html#version_mismatch";
    static final String h = "http://www.slf4j.org/codes.html#substituteLogger";
    static final String i = "http://www.slf4j.org/codes.html#loggerNameMismatch";
    static final String j = "http://www.slf4j.org/codes.html#replay";
    static final String k = "http://www.slf4j.org/codes.html#unsuccessfulInit";
    static final String l = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit";
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    static final int e = 4;
    static volatile int f = 0;
    static final r a = new r();
    static final m a = new m();
    static final String m = "slf4j.detectLoggerNameMismatch";
    static final String n = "java.vendor.url";
    static boolean a = s.a("slf4j.detectLoggerNameMismatch");
    static volatile i a;
    private static final String[] a;
    private static String o;

    static {
        a = new String[]{"1.8", "1.7"};
        o = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    private static List<i> a() {
        ServiceLoader<i> serviceLoader = ServiceLoader.load(i.class);
        ArrayList<i> arrayList = new ArrayList<i>();
        for (i i2 : serviceLoader) {
            arrayList.add(i2);
        }
        return arrayList;
    }

    private d() {
    }

    static void a() {
        f = 0;
    }

    private static final void b() {
        javassist.orgs.slf4j.d.c();
        if (f == 3) {
            javassist.orgs.slf4j.d.h();
        }
    }

    private static final void c() {
        try {
            List<i> list = javassist.orgs.slf4j.d.a();
            javassist.orgs.slf4j.d.a(list);
            if (list != null && !list.isEmpty()) {
                a = list.get(0);
                a.a();
                f = 3;
                javassist.orgs.slf4j.d.b(list);
            } else {
                f = 4;
                s.a("No SLF4J providers were found.");
                s.a("Defaulting to no-operation (NOP) logger implementation");
                s.a("See http://www.slf4j.org/codes.html#noProviders for further details.");
                Set<URL> set = javassist.orgs.slf4j.d.a();
                javassist.orgs.slf4j.d.a(set);
            }
            javassist.orgs.slf4j.d.d();
        } catch (Exception exception) {
            javassist.orgs.slf4j.d.a(exception);
            throw new IllegalStateException("Unexpected initialization failure", exception);
        }
    }

    private static void a(Set<URL> set) {
        if (set.isEmpty()) {
            return;
        }
        s.a("Class path contains SLF4J bindings targeting slf4j-api versions prior to 1.8.");
        for (URL uRL : set) {
            s.a("Ignoring binding found at [" + uRL + "]");
        }
        s.a("See http://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    static Set<URL> a() {
        LinkedHashSet<URL> linkedHashSet = new LinkedHashSet<URL>();
        try {
            ClassLoader classLoader = d.class.getClassLoader();
            Enumeration<URL> enumeration = classLoader == null ? ClassLoader.getSystemResources(o) : classLoader.getResources(o);
            while (enumeration.hasMoreElements()) {
                URL uRL = enumeration.nextElement();
                linkedHashSet.add(uRL);
            }
        } catch (IOException iOException) {
            s.a("Error getting resources from path", iOException);
        }
        return linkedHashSet;
    }

    private static void d() {
        javassist.orgs.slf4j.d.e();
        javassist.orgs.slf4j.d.f();
        ((q)a.a()).b();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void e() {
        r r2 = a;
        synchronized (r2) {
            ((q)a.a()).a();
            for (p p2 : ((q)a.a()).b()) {
                c c2 = javassist.orgs.slf4j.d.a(p2.a());
                p2.a(c2);
            }
        }
    }

    static void a(Throwable throwable) {
        f = 2;
        s.a("Failed to instantiate SLF4J LoggerFactory", throwable);
    }

    private static void f() {
        int n2;
        LinkedBlockingQueue<h> linkedBlockingQueue = ((q)a.a()).a();
        int n3 = linkedBlockingQueue.size();
        int n4 = 0;
        int n5 = 128;
        ArrayList arrayList = new ArrayList(128);
        while ((n2 = linkedBlockingQueue.drainTo(arrayList, 128)) != 0) {
            for (h h2 : arrayList) {
                javassist.orgs.slf4j.d.a(h2);
                if (n4++ != 0) continue;
                javassist.orgs.slf4j.d.a(h2, n3);
            }
            arrayList.clear();
        }
    }

    private static void a(h h2, int n2) {
        if (h2.a().f()) {
            javassist.orgs.slf4j.d.a(n2);
        } else if (!h2.a().h()) {
            javassist.orgs.slf4j.d.g();
        }
    }

    private static void a(h h2) {
        if (h2 == null) {
            return;
        }
        p p2 = h2.a();
        String string = p2.a();
        if (p2.g()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (!p2.h()) {
            if (p2.f()) {
                p2.a(h2);
            } else {
                s.a(string);
            }
        }
    }

    private static void g() {
        s.a("The following set of substitute loggers may have been accessed");
        s.a("during the initialization phase. Logging calls during this");
        s.a("phase were not honored. However, subsequent logging calls to these");
        s.a("loggers will work as normally expected.");
        s.a("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    private static void a(int n2) {
        s.a("A number (" + n2 + ") of logging calls during the initialization phase have been intercepted and are");
        s.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        s.a("See also http://www.slf4j.org/codes.html#replay");
    }

    private static final void h() {
        try {
            String string = a.a();
            boolean bl2 = false;
            String[] stringArray = a;
            int n2 = a.length;
            int n3 = 0;
            while (n3 < n2) {
                String string2 = stringArray[n3];
                if (string.startsWith(string2)) {
                    bl2 = true;
                }
                ++n3;
            }
            if (!bl2) {
                s.a("The requested version " + string + " by your slf4j binding is not compatible with " + Arrays.asList(a).toString());
                s.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError noSuchFieldError) {
        } catch (Throwable throwable) {
            s.a("Unexpected problem occured during version sanity check", throwable);
        }
    }

    private static boolean a(List<i> list) {
        return list.size() > 1;
    }

    private static void a(List<i> list) {
        if (javassist.orgs.slf4j.d.a(list)) {
            s.a("Class path contains multiple SLF4J providers.");
            for (i i2 : list) {
                s.a("Found provider [" + i2 + "]");
            }
            s.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static void b(List<i> list) {
        if (!list.isEmpty() && javassist.orgs.slf4j.d.a(list)) {
            s.a("Actual provider is of type [" + list.get(0) + "]");
        }
    }

    public static c a(String string) {
        a a2 = javassist.orgs.slf4j.d.a();
        return a2.a(string);
    }

    public static c a(Class<?> clazz) {
        Class<?> clazz2;
        c c2 = javassist.orgs.slf4j.d.a(clazz.getName());
        if (a && (clazz2 = s.a()) != null && javassist.orgs.slf4j.d.a(clazz, clazz2)) {
            s.a(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", c2.a(), clazz2.getName()));
            s.a("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return c2;
    }

    private static boolean a(Class<?> clazz, Class<?> clazz2) {
        return !clazz2.isAssignableFrom(clazz);
    }

    public static a a() {
        return javassist.orgs.slf4j.d.a().a();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static i a() {
        if (f == 0) {
            Class<d> clazz = d.class;
            // MONITORENTER : javassist.orgs.slf4j.d.class
            if (f == 0) {
                f = 1;
                javassist.orgs.slf4j.d.b();
            }
            // MONITOREXIT : clazz
        }
        switch (f) {
            case 3: {
                return a;
            }
            case 4: {
                return a;
            }
            case 2: {
                throw new IllegalStateException(l);
            }
            case 1: {
                return a;
            }
        }
        throw new IllegalStateException("Unreachable code");
    }
}

