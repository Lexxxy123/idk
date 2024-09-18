/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.utils.annotations;

import de.tr7zw.nbtapi.utils.annotations.ref.MethodRefrence;
import de.tr7zw.nbtapi.utils.annotations.ref.MethodRefrence1;
import de.tr7zw.nbtapi.utils.annotations.ref.MethodRefrence2;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.function.Function;

public class FAUtil {
    private static HashSet<String> cache = new HashSet();

    public static <T> T getAnnotation(MethodRefrence method, Class<T> annotation) {
        return FAUtil.getInternalMethod(method).getAnnotation(annotation);
    }

    public static <T, Z> T getAnnotation(MethodRefrence1<Z> method, Class<T> annotation) {
        return FAUtil.getInternalMethod(method).getAnnotation(annotation);
    }

    public static <T, Z, X> T getAnnotation(MethodRefrence2<Z, X> method, Class<T> annotation) {
        return FAUtil.getInternalMethod(method).getAnnotation(annotation);
    }

    public static Method getMethod(MethodRefrence method) {
        return FAUtil.getInternalMethod(method);
    }

    public static <Z> Method getMethod(MethodRefrence1<Z> method) {
        return FAUtil.getInternalMethod(method);
    }

    public static <T, Z> Method getMethod(MethodRefrence2<T, Z> method) {
        return FAUtil.getInternalMethod(method);
    }

    public static void check(MethodRefrence method, Function<Method, Boolean> checker) {
        FAUtil.checkLambda(method, checker);
    }

    public static <T> T check(MethodRefrence1<T> method, Function<Method, Boolean> checker) {
        FAUtil.checkLambda(method, checker);
        return null;
    }

    public static <T, Z> T check(MethodRefrence2<T, Z> method, Function<Method, Boolean> checker) {
        FAUtil.checkLambda(method, checker);
        return null;
    }

    private static void checkLambda(Object obj, Function<Method, Boolean> callable) {
        Boolean noRechecking;
        if (cache.contains(obj.toString().split("/")[0])) {
            return;
        }
        Method method = FAUtil.getInternalMethod(obj);
        if (method != null && (noRechecking = callable.apply(method)).booleanValue()) {
            cache.add(obj.toString().split("/")[0]);
        }
        cache.add(obj.toString().split("/")[0]);
    }

    private static Method getInternalMethod(Object obj) {
        for (Class<?> cl = obj.getClass(); cl != null; cl = cl.getSuperclass()) {
            try {
                Method m2 = cl.getDeclaredMethod("writeReplace", new Class[0]);
                m2.setAccessible(true);
                Object replacement = m2.invoke(obj, new Object[0]);
                if (!(replacement instanceof SerializedLambda)) break;
                SerializedLambda l2 = (SerializedLambda)replacement;
                for (Method method : Class.forName(l2.getImplClass().replace('/', '.')).getDeclaredMethods()) {
                    if (!method.getName().equals(l2.getImplMethodName())) continue;
                    return method;
                }
                continue;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                break;
            } catch (Exception exception) {
                // empty catch block
            }
        }
        return null;
    }
}

