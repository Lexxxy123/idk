/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javassist.CtClass;
import javassist.aa;
import javassist.bytecode.al;
import javassist.bytecode.annotation.a;
import javassist.bytecode.annotation.p;
import javassist.bytecode.b;
import javassist.bytecode.o;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c
implements InvocationHandler {
    private static final String a = "java.lang.annotation.Annotation";
    private static Method a = null;
    private a a;
    private f a;
    private ClassLoader a;
    private transient Class<?> a;
    private transient int a = Integer.MIN_VALUE;

    public static Object a(ClassLoader classLoader, Class<?> clazz, f f2, a a2) {
        c c2 = new c(a2, f2, classLoader);
        return Proxy.newProxyInstance(classLoader, new Class[]{clazz}, c2);
    }

    private c(a a2, f f2, ClassLoader classLoader) {
        this.a = a2;
        this.a = f2;
        this.a = classLoader;
    }

    public String a() {
        return this.a.a();
    }

    private Class<?> a() {
        if (this.a == null) {
            String string = this.a.a();
            try {
                this.a = this.a.loadClass(string);
            } catch (ClassNotFoundException classNotFoundException) {
                NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError("Error loading annotation class: " + string);
                noClassDefFoundError.setStackTrace(classNotFoundException.getStackTrace());
                throw noClassDefFoundError;
            }
        }
        return this.a;
    }

    public a a() {
        return this.a;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) {
        p p2;
        String string = method.getName();
        if (Object.class == method.getDeclaringClass()) {
            if ("equals".equals(string)) {
                Object object2 = objectArray[0];
                return this.a(object2);
            }
            if ("toString".equals(string)) {
                return this.a.toString();
            }
            if ("hashCode".equals(string)) {
                return this.hashCode();
            }
        } else if ("annotationType".equals(string) && method.getParameterTypes().length == 0) {
            return this.a();
        }
        if ((p2 = this.a.a(string)) == null) {
            return this.a(string, method);
        }
        return p2.a(this.a, this.a, method);
    }

    private Object a(String string, Method method) {
        String string2 = this.a.a();
        if (this.a != null) {
            try {
                b b2;
                CtClass ctClass = this.a.c(string2);
                o o2 = ctClass.b();
                al al2 = o2.a(string);
                if (al2 != null && (b2 = (b)al2.a("AnnotationDefault")) != null) {
                    p p2 = b2.a();
                    return p2.a(this.a, this.a, method);
                }
            } catch (aa aa2) {
                throw new RuntimeException("cannot find a class file: " + string2);
            }
        }
        throw new RuntimeException("no default value: " + string2 + "." + string + "()");
    }

    public int hashCode() {
        if (this.a == Integer.MIN_VALUE) {
            int n2 = 0;
            this.a();
            Method[] methodArray = ((Class)((Object)this.a)).getDeclaredMethods();
            for (int i2 = 0; i2 < methodArray.length; ++i2) {
                String string = methodArray[i2].getName();
                int n3 = 0;
                p p2 = this.a.a(string);
                Object object = null;
                try {
                    if (p2 != null) {
                        object = p2.a(this.a, this.a, methodArray[i2]);
                    }
                    if (object == null) {
                        object = this.a(string, methodArray[i2]);
                    }
                } catch (RuntimeException runtimeException) {
                    throw runtimeException;
                } catch (Exception exception) {
                    throw new RuntimeException("Error retrieving value " + string + " for annotation " + this.a.a(), exception);
                }
                if (object != null) {
                    n3 = object.getClass().isArray() ? c.a(object) : object.hashCode();
                }
                n2 += 127 * string.hashCode() ^ n3;
            }
            this.a = n2;
        }
        return this.a;
    }

    private boolean a(Object object) {
        Object object2;
        if (object == null) {
            return false;
        }
        if (object instanceof Proxy && (object2 = Proxy.getInvocationHandler(object)) instanceof c) {
            c c2 = (c)object2;
            return this.a.equals(c2.a);
        }
        object2 = (Class)a.invoke(object, new Object[0]);
        if (!this.a().equals(object2)) {
            return false;
        }
        Method[] methodArray = ((Class)((Object)this.a)).getDeclaredMethods();
        for (int i2 = 0; i2 < methodArray.length; ++i2) {
            String string = methodArray[i2].getName();
            p p2 = this.a.a(string);
            Object object3 = null;
            Object object4 = null;
            try {
                if (p2 != null) {
                    object3 = p2.a(this.a, this.a, methodArray[i2]);
                }
                if (object3 == null) {
                    object3 = this.a(string, methodArray[i2]);
                }
                object4 = methodArray[i2].invoke(object, new Object[0]);
            } catch (RuntimeException runtimeException) {
                throw runtimeException;
            } catch (Exception exception) {
                throw new RuntimeException("Error retrieving value " + string + " for annotation " + this.a.a(), exception);
            }
            if (object3 == null && object4 != null) {
                return false;
            }
            if (object3 == null || object3.equals(object4)) continue;
            return false;
        }
        return true;
    }

    private static int a(Object object) {
        if (object == null) {
            return 0;
        }
        int n2 = 1;
        Object[] objectArray = (Object[])object;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            int n3 = 0;
            if (objectArray[i2] != null) {
                n3 = objectArray[i2].hashCode();
            }
            n2 = 31 * n2 + n3;
        }
        return n2;
    }

    static {
        try {
            Class<?> clazz = Class.forName(a);
            a = clazz.getMethod("annotationType", null);
        } catch (Exception exception) {
            // empty catch block
        }
    }
}

