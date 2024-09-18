/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

class ServiceLoaderUtil {
    private static final String OSGI_SERVICE_LOADER_CLASS_NAME = "org.glassfish.hk2.osgiresourcelocator.ServiceLoader";
    private static final String OSGI_SERVICE_LOADER_METHOD_NAME = "lookupProviderClasses";

    ServiceLoaderUtil() {
    }

    static <P, T extends Exception> P firstByServiceLoader(Class<P> spiClass, Logger logger, ExceptionHandler<T> handler) throws T {
        try {
            ServiceLoader<P> serviceLoader = ServiceLoader.load(spiClass);
            Iterator<P> iterator = serviceLoader.iterator();
            if (iterator.hasNext()) {
                P impl = iterator.next();
                logger.fine("ServiceProvider loading Facility used; returning object [" + impl.getClass().getName() + "]");
                return impl;
            }
        } catch (Throwable t2) {
            throw handler.createException(t2, "Error while searching for service [" + spiClass.getName() + "]");
        }
        return null;
    }

    static Object lookupUsingOSGiServiceLoader(String factoryId, Logger logger) {
        try {
            Class<?> serviceClass = Class.forName(factoryId);
            Class<?> target = Class.forName(OSGI_SERVICE_LOADER_CLASS_NAME);
            Method m2 = target.getMethod(OSGI_SERVICE_LOADER_METHOD_NAME, Class.class);
            Iterator iter = ((Iterable)m2.invoke(null, serviceClass)).iterator();
            if (iter.hasNext()) {
                Object next = iter.next();
                logger.fine("Found implementation using OSGi facility; returning object [" + next.getClass().getName() + "].");
                return next;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ignored) {
            logger.log(Level.FINE, "Unable to find from OSGi: [" + factoryId + "]", ignored);
            return null;
        }
    }

    static void checkPackageAccess(String className) {
        int i2;
        SecurityManager s2 = System.getSecurityManager();
        if (s2 != null && (i2 = className.lastIndexOf(46)) != -1) {
            s2.checkPackageAccess(className.substring(0, i2));
        }
    }

    static Class nullSafeLoadClass(String className, ClassLoader classLoader) throws ClassNotFoundException {
        if (classLoader == null) {
            return Class.forName(className);
        }
        return classLoader.loadClass(className);
    }

    static <T extends Exception> Object newInstance(String className, String defaultImplClassName, ExceptionHandler<T> handler) throws T {
        try {
            return ServiceLoaderUtil.safeLoadClass(className, defaultImplClassName, ServiceLoaderUtil.contextClassLoader(handler)).newInstance();
        } catch (ClassNotFoundException x2) {
            throw handler.createException(x2, "Provider " + className + " not found");
        } catch (Exception x3) {
            throw handler.createException(x3, "Provider " + className + " could not be instantiated: " + x3);
        }
    }

    static Class safeLoadClass(String className, String defaultImplClassName, ClassLoader classLoader) throws ClassNotFoundException {
        try {
            ServiceLoaderUtil.checkPackageAccess(className);
        } catch (SecurityException se) {
            if (defaultImplClassName != null && defaultImplClassName.equals(className)) {
                return Class.forName(className);
            }
            throw se;
        }
        return ServiceLoaderUtil.nullSafeLoadClass(className, classLoader);
    }

    static ClassLoader contextClassLoader(ExceptionHandler exceptionHandler) throws Exception {
        try {
            return Thread.currentThread().getContextClassLoader();
        } catch (Exception x2) {
            throw exceptionHandler.createException(x2, x2.toString());
        }
    }

    static abstract class ExceptionHandler<T extends Exception> {
        ExceptionHandler() {
        }

        public abstract T createException(Throwable var1, String var2);
    }
}

