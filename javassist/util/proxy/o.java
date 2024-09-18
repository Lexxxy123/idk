/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import javassist.util.proxy.p;
import javassist.util.proxy.q;
import javassist.util.proxy.r;
import javassist.util.proxy.s;
import javassist.util.proxy.t;
import javassist.util.proxy.u;
import javassist.util.proxy.v;
import javassist.util.proxy.w;
import javassist.util.proxy.x;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class o
extends SecurityManager {
    public static final o a = new o();

    o() {
    }

    public Class<?> a() {
        return this.getClassContext()[2];
    }

    static Method[] a(Class<?> clazz) {
        if (System.getSecurityManager() == null) {
            return clazz.getDeclaredMethods();
        }
        return AccessController.doPrivileged(new p(clazz));
    }

    static Constructor<?>[] a(Class<?> clazz) {
        if (System.getSecurityManager() == null) {
            return clazz.getDeclaredConstructors();
        }
        return AccessController.doPrivileged(new q(clazz));
    }

    static MethodHandle a(Class<?> clazz, String string, Class<?>[] classArray) {
        try {
            return AccessController.doPrivileged(new r(clazz, string, classArray));
        } catch (PrivilegedActionException privilegedActionException) {
            if (privilegedActionException.getCause() instanceof NoSuchMethodException) {
                throw (NoSuchMethodException)privilegedActionException.getCause();
            }
            throw new RuntimeException(privilegedActionException.getCause());
        }
    }

    static Method a(Class<?> clazz, String string, Class<?>[] classArray) {
        if (System.getSecurityManager() == null) {
            return clazz.getDeclaredMethod(string, classArray);
        }
        try {
            return AccessController.doPrivileged(new s(clazz, string, classArray));
        } catch (PrivilegedActionException privilegedActionException) {
            if (privilegedActionException.getCause() instanceof NoSuchMethodException) {
                throw (NoSuchMethodException)privilegedActionException.getCause();
            }
            throw new RuntimeException(privilegedActionException.getCause());
        }
    }

    static Constructor<?> a(Class<?> clazz, Class<?>[] classArray) {
        if (System.getSecurityManager() == null) {
            return clazz.getDeclaredConstructor(classArray);
        }
        try {
            return (Constructor)AccessController.doPrivileged(new t(clazz, classArray));
        } catch (PrivilegedActionException privilegedActionException) {
            if (privilegedActionException.getCause() instanceof NoSuchMethodException) {
                throw (NoSuchMethodException)privilegedActionException.getCause();
            }
            throw new RuntimeException(privilegedActionException.getCause());
        }
    }

    static void a(AccessibleObject accessibleObject, boolean bl2) {
        if (System.getSecurityManager() == null) {
            accessibleObject.setAccessible(bl2);
        } else {
            AccessController.doPrivileged(new u(accessibleObject, bl2));
        }
    }

    static void a(Field field, Object object, Object object2) {
        if (System.getSecurityManager() == null) {
            field.set(object, object2);
        } else {
            try {
                AccessController.doPrivileged(new v(field, object, object2));
            } catch (PrivilegedActionException privilegedActionException) {
                if (privilegedActionException.getCause() instanceof NoSuchMethodException) {
                    throw (IllegalAccessException)privilegedActionException.getCause();
                }
                throw new RuntimeException(privilegedActionException.getCause());
            }
        }
    }

    static x a() {
        try {
            return AccessController.doPrivileged(new w());
        } catch (PrivilegedActionException privilegedActionException) {
            if (privilegedActionException.getCause() instanceof ClassNotFoundException) {
                throw (ClassNotFoundException)privilegedActionException.getCause();
            }
            if (privilegedActionException.getCause() instanceof NoSuchFieldException) {
                throw new ClassNotFoundException("No such instance.", privilegedActionException.getCause());
            }
            if (privilegedActionException.getCause() instanceof IllegalAccessException || privilegedActionException.getCause() instanceof IllegalAccessException || privilegedActionException.getCause() instanceof SecurityException) {
                throw new ClassNotFoundException("Security denied access.", privilegedActionException.getCause());
            }
            throw new RuntimeException(privilegedActionException.getCause());
        }
    }

    static void a(x x2) {
        try {
            if (javassist.bytecode.o.q < 53) {
                return;
            }
            Class<?> clazz = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field field = clazz.getDeclaredField("logger");
            x2.a("putObjectVolatile", clazz, x2.a("staticFieldOffset", field), null);
        } catch (Exception exception) {
            // empty catch block
        }
    }
}

