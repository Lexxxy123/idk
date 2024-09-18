/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javax.xml.bind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.GetPropertyAction;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBContextFactory;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Messages;
import javax.xml.bind.ModuleUtil;
import javax.xml.bind.ServiceLoaderUtil;

class ContextFinder {
    private static final String PLATFORM_DEFAULT_FACTORY_CLASS = "com.sun.xml.internal.bind.v2.ContextFactory";
    private static final String JAXB_CONTEXT_FACTORY_DEPRECATED = "javax.xml.bind.context.factory";
    private static final Logger logger = Logger.getLogger("javax.xml.bind");
    private static ServiceLoaderUtil.ExceptionHandler<JAXBException> EXCEPTION_HANDLER;

    ContextFinder() {
    }

    private static Throwable handleInvocationTargetException(InvocationTargetException x2) throws JAXBException {
        Throwable t2 = x2.getTargetException();
        if (t2 != null) {
            if (t2 instanceof JAXBException) {
                throw (JAXBException)t2;
            }
            if (t2 instanceof RuntimeException) {
                throw (RuntimeException)t2;
            }
            if (t2 instanceof Error) {
                throw (Error)t2;
            }
            return t2;
        }
        return x2;
    }

    private static JAXBException handleClassCastException(Class originalType, Class targetType) {
        URL targetTypeURL = ContextFinder.which(targetType);
        return new JAXBException(Messages.format("JAXBContext.IllegalCast", ContextFinder.getClassClassLoader(originalType).getResource("javax/xml/bind/JAXBContext.class"), targetTypeURL));
    }

    static JAXBContext newInstance(String contextPath, Class[] contextPathClasses, String className, ClassLoader classLoader, Map properties) throws JAXBException {
        try {
            Class spFactory = ServiceLoaderUtil.safeLoadClass(className, PLATFORM_DEFAULT_FACTORY_CLASS, classLoader);
            return ContextFinder.newInstance(contextPath, contextPathClasses, spFactory, classLoader, properties);
        } catch (ClassNotFoundException x2) {
            throw new JAXBException(Messages.format("ContextFinder.DefaultProviderNotFound"), x2);
        } catch (RuntimeException | JAXBException x3) {
            throw x3;
        } catch (Exception x4) {
            throw new JAXBException(Messages.format("ContextFinder.CouldNotInstantiate", className, x4), x4);
        }
    }

    static JAXBContext newInstance(String contextPath, Class[] contextPathClasses, Class spFactory, ClassLoader classLoader, Map properties) throws JAXBException {
        try {
            Object obj;
            Method m22;
            ModuleUtil.delegateAddOpensToImplModule(contextPathClasses, spFactory);
            Object context = null;
            try {
                m22 = spFactory.getMethod("createContext", String.class, ClassLoader.class, Map.class);
                obj = ContextFinder.instantiateProviderIfNecessary(spFactory);
                context = m22.invoke(obj, contextPath, classLoader, properties);
            } catch (NoSuchMethodException m22) {
                // empty catch block
            }
            if (context == null) {
                m22 = spFactory.getMethod("createContext", String.class, ClassLoader.class);
                obj = ContextFinder.instantiateProviderIfNecessary(spFactory);
                context = m22.invoke(obj, contextPath, classLoader);
            }
            if (!(context instanceof JAXBContext)) {
                throw ContextFinder.handleClassCastException(context.getClass(), JAXBContext.class);
            }
            return (JAXBContext)context;
        } catch (InvocationTargetException x2) {
            Throwable e2 = ContextFinder.handleInvocationTargetException(x2);
            throw new JAXBException(Messages.format("ContextFinder.CouldNotInstantiate", spFactory, e2), e2);
        } catch (Exception x3) {
            throw new JAXBException(Messages.format("ContextFinder.CouldNotInstantiate", spFactory, x3), x3);
        }
    }

    private static Object instantiateProviderIfNecessary(final Class<?> implClass) throws JAXBException {
        try {
            if (JAXBContextFactory.class.isAssignableFrom(implClass)) {
                return AccessController.doPrivileged(new PrivilegedExceptionAction<Object>(){

                    @Override
                    public Object run() throws Exception {
                        return implClass.newInstance();
                    }
                });
            }
            return null;
        } catch (PrivilegedActionException x2) {
            Throwable e2 = x2.getCause() == null ? x2 : x2.getCause();
            throw new JAXBException(Messages.format("ContextFinder.CouldNotInstantiate", implClass, e2), e2);
        }
    }

    static JAXBContext newInstance(Class[] classes, Map properties, String className) throws JAXBException {
        Class spi;
        try {
            spi = ServiceLoaderUtil.safeLoadClass(className, PLATFORM_DEFAULT_FACTORY_CLASS, ContextFinder.getContextClassLoader());
        } catch (ClassNotFoundException e2) {
            throw new JAXBException(Messages.format("ContextFinder.DefaultProviderNotFound"), e2);
        }
        if (logger.isLoggable(Level.FINE)) {
            logger.log(Level.FINE, "loaded {0} from {1}", new Object[]{className, ContextFinder.which(spi)});
        }
        return ContextFinder.newInstance(classes, properties, spi);
    }

    static JAXBContext newInstance(Class[] classes, Map properties, Class spFactory) throws JAXBException {
        try {
            ModuleUtil.delegateAddOpensToImplModule(classes, spFactory);
            Method m2 = spFactory.getMethod("createContext", Class[].class, Map.class);
            Object obj = ContextFinder.instantiateProviderIfNecessary(spFactory);
            Object context = m2.invoke(obj, classes, properties);
            if (!(context instanceof JAXBContext)) {
                throw ContextFinder.handleClassCastException(context.getClass(), JAXBContext.class);
            }
            return (JAXBContext)context;
        } catch (IllegalAccessException | NoSuchMethodException e2) {
            throw new JAXBException(e2);
        } catch (InvocationTargetException e3) {
            Throwable x2 = ContextFinder.handleInvocationTargetException(e3);
            throw new JAXBException(x2);
        }
    }

    static JAXBContext find(String factoryId, String contextPath, ClassLoader classLoader, Map properties) throws JAXBException {
        if (contextPath == null || contextPath.isEmpty()) {
            throw new JAXBException(Messages.format("ContextFinder.NoPackageInContextPath"));
        }
        Class[] contextPathClasses = ModuleUtil.getClassesFromContextPath(contextPath, classLoader);
        String factoryClassName = ContextFinder.jaxbProperties(contextPath, classLoader, factoryId);
        if (factoryClassName == null && contextPathClasses != null) {
            factoryClassName = ContextFinder.jaxbProperties(contextPathClasses, factoryId);
        }
        if (factoryClassName != null) {
            return ContextFinder.newInstance(contextPath, contextPathClasses, factoryClassName, classLoader, properties);
        }
        String factoryName = ContextFinder.classNameFromSystemProperties();
        if (factoryName != null) {
            return ContextFinder.newInstance(contextPath, contextPathClasses, factoryName, classLoader, properties);
        }
        JAXBContextFactory obj = ServiceLoaderUtil.firstByServiceLoader(JAXBContextFactory.class, logger, EXCEPTION_HANDLER);
        if (obj != null) {
            ModuleUtil.delegateAddOpensToImplModule(contextPathClasses, obj.getClass());
            return obj.createContext(contextPath, classLoader, properties);
        }
        factoryName = ContextFinder.firstByServiceLoaderDeprecated(JAXBContext.class, classLoader);
        if (factoryName != null) {
            return ContextFinder.newInstance(contextPath, contextPathClasses, factoryName, classLoader, properties);
        }
        Class ctxFactory = (Class)ServiceLoaderUtil.lookupUsingOSGiServiceLoader("javax.xml.bind.JAXBContext", logger);
        if (ctxFactory != null) {
            return ContextFinder.newInstance(contextPath, contextPathClasses, ctxFactory, classLoader, properties);
        }
        logger.fine("Trying to create the platform default provider");
        return ContextFinder.newInstance(contextPath, contextPathClasses, PLATFORM_DEFAULT_FACTORY_CLASS, classLoader, properties);
    }

    static JAXBContext find(Class<?>[] classes, Map<String, ?> properties) throws JAXBException {
        logger.fine("Searching jaxb.properties");
        for (Class<?> c2 : classes) {
            URL jaxbPropertiesUrl;
            if (c2.getPackage() == null || (jaxbPropertiesUrl = ContextFinder.getResourceUrl(c2, "jaxb.properties")) == null) continue;
            String factoryClassName = ContextFinder.classNameFromPackageProperties(jaxbPropertiesUrl, "javax.xml.bind.JAXBContextFactory", JAXB_CONTEXT_FACTORY_DEPRECATED);
            return ContextFinder.newInstance((Class[])classes, properties, factoryClassName);
        }
        String factoryClassName = ContextFinder.classNameFromSystemProperties();
        if (factoryClassName != null) {
            return ContextFinder.newInstance((Class[])classes, properties, factoryClassName);
        }
        JAXBContextFactory factory = ServiceLoaderUtil.firstByServiceLoader(JAXBContextFactory.class, logger, EXCEPTION_HANDLER);
        if (factory != null) {
            ModuleUtil.delegateAddOpensToImplModule(classes, factory.getClass());
            return factory.createContext(classes, properties);
        }
        String className = ContextFinder.firstByServiceLoaderDeprecated(JAXBContext.class, ContextFinder.getContextClassLoader());
        if (className != null) {
            return ContextFinder.newInstance((Class[])classes, properties, className);
        }
        logger.fine("Trying to create the platform default provider");
        Class ctxFactoryClass = (Class)ServiceLoaderUtil.lookupUsingOSGiServiceLoader("javax.xml.bind.JAXBContext", logger);
        if (ctxFactoryClass != null) {
            return ContextFinder.newInstance((Class[])classes, properties, ctxFactoryClass);
        }
        logger.fine("Trying to create the platform default provider");
        return ContextFinder.newInstance((Class[])classes, properties, PLATFORM_DEFAULT_FACTORY_CLASS);
    }

    private static String classNameFromPackageProperties(URL packagePropertiesUrl, String ... factoryIds) throws JAXBException {
        logger.log(Level.FINE, "Trying to locate {0}", packagePropertiesUrl.toString());
        Properties props = ContextFinder.loadJAXBProperties(packagePropertiesUrl);
        for (String factoryId : factoryIds) {
            if (!props.containsKey(factoryId)) continue;
            return props.getProperty(factoryId);
        }
        String propertiesUrl = packagePropertiesUrl.toExternalForm();
        String packageName = propertiesUrl.substring(0, propertiesUrl.indexOf("/jaxb.properties"));
        throw new JAXBException(Messages.format("ContextFinder.MissingProperty", packageName, factoryIds[0]));
    }

    private static String classNameFromSystemProperties() throws JAXBException {
        String factoryClassName = ContextFinder.getSystemProperty("javax.xml.bind.JAXBContextFactory");
        if (factoryClassName != null) {
            return factoryClassName;
        }
        factoryClassName = ContextFinder.getDeprecatedSystemProperty(JAXB_CONTEXT_FACTORY_DEPRECATED);
        if (factoryClassName != null) {
            return factoryClassName;
        }
        factoryClassName = ContextFinder.getDeprecatedSystemProperty(JAXBContext.class.getName());
        if (factoryClassName != null) {
            return factoryClassName;
        }
        return null;
    }

    private static String getDeprecatedSystemProperty(String property) {
        String value = ContextFinder.getSystemProperty(property);
        if (value != null) {
            logger.log(Level.WARNING, "Using non-standard property: {0}. Property {1} should be used instead.", new Object[]{property, "javax.xml.bind.JAXBContextFactory"});
        }
        return value;
    }

    private static String getSystemProperty(String property) {
        logger.log(Level.FINE, "Checking system property {0}", property);
        String value = AccessController.doPrivileged(new GetPropertyAction(property));
        if (value != null) {
            logger.log(Level.FINE, "  found {0}", value);
        } else {
            logger.log(Level.FINE, "  not found");
        }
        return value;
    }

    private static Properties loadJAXBProperties(URL url) throws JAXBException {
        try {
            logger.log(Level.FINE, "loading props from {0}", url);
            Properties props = new Properties();
            InputStream is = url.openStream();
            props.load(is);
            is.close();
            return props;
        } catch (IOException ioe) {
            logger.log(Level.FINE, "Unable to load " + url.toString(), ioe);
            throw new JAXBException(ioe.toString(), ioe);
        }
    }

    private static URL getResourceUrl(ClassLoader classLoader, String resourceName) {
        URL url = classLoader == null ? ClassLoader.getSystemResource(resourceName) : classLoader.getResource(resourceName);
        return url;
    }

    private static URL getResourceUrl(Class<?> clazz, String resourceName) {
        return clazz.getResource(resourceName);
    }

    static URL which(Class clazz, ClassLoader loader) {
        String classnameAsResource = clazz.getName().replace('.', '/') + ".class";
        if (loader == null) {
            loader = ContextFinder.getSystemClassLoader();
        }
        return loader.getResource(classnameAsResource);
    }

    static URL which(Class clazz) {
        return ContextFinder.which(clazz, ContextFinder.getClassClassLoader(clazz));
    }

    private static ClassLoader getContextClassLoader() {
        if (System.getSecurityManager() == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return (ClassLoader)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return Thread.currentThread().getContextClassLoader();
            }
        });
    }

    private static ClassLoader getClassClassLoader(final Class c2) {
        if (System.getSecurityManager() == null) {
            return c2.getClassLoader();
        }
        return (ClassLoader)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return c2.getClassLoader();
            }
        });
    }

    private static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    @Deprecated
    static String firstByServiceLoaderDeprecated(Class spiClass, ClassLoader classLoader) throws JAXBException {
        String jaxbContextFQCN = spiClass.getName();
        logger.fine("Searching META-INF/services");
        BufferedReader r2 = null;
        String resource = "META-INF/services/" + jaxbContextFQCN;
        try {
            InputStream resourceStream;
            InputStream inputStream = resourceStream = classLoader == null ? ClassLoader.getSystemResourceAsStream(resource) : classLoader.getResourceAsStream(resource);
            if (resourceStream != null) {
                r2 = new BufferedReader(new InputStreamReader(resourceStream, "UTF-8"));
                String factoryClassName = r2.readLine();
                if (factoryClassName != null) {
                    factoryClassName = factoryClassName.trim();
                }
                r2.close();
                logger.log(Level.FINE, "Configured factorty class:{0}", factoryClassName);
                String string = factoryClassName;
                return string;
            }
            logger.log(Level.FINE, "Unable to load:{0}", resource);
            String string = null;
            return string;
        } catch (IOException e2) {
            throw new JAXBException(e2);
        } finally {
            try {
                if (r2 != null) {
                    r2.close();
                }
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "Unable to close resource: " + resource, ex);
            }
        }
    }

    private static String jaxbProperties(String contextPath, ClassLoader classLoader, String factoryId) throws JAXBException {
        String[] packages;
        for (String pkg : packages = contextPath.split(":")) {
            String pkgUrl = pkg.replace('.', '/');
            URL jaxbPropertiesUrl = ContextFinder.getResourceUrl(classLoader, pkgUrl + "/jaxb.properties");
            if (jaxbPropertiesUrl == null) continue;
            return ContextFinder.classNameFromPackageProperties(jaxbPropertiesUrl, factoryId, JAXB_CONTEXT_FACTORY_DEPRECATED);
        }
        return null;
    }

    private static String jaxbProperties(Class[] classesFromContextPath, String factoryId) throws JAXBException {
        for (Class c2 : classesFromContextPath) {
            URL jaxbPropertiesUrl = ContextFinder.getResourceUrl(c2, "jaxb.properties");
            if (jaxbPropertiesUrl == null) continue;
            return ContextFinder.classNameFromPackageProperties(jaxbPropertiesUrl, factoryId, JAXB_CONTEXT_FACTORY_DEPRECATED);
        }
        return null;
    }

    static {
        try {
            if (AccessController.doPrivileged(new GetPropertyAction("jaxb.debug")) != null) {
                logger.setUseParentHandlers(false);
                logger.setLevel(Level.ALL);
                ConsoleHandler handler = new ConsoleHandler();
                handler.setLevel(Level.ALL);
                logger.addHandler(handler);
            }
        } catch (Throwable throwable) {
            // empty catch block
        }
        EXCEPTION_HANDLER = new ServiceLoaderUtil.ExceptionHandler<JAXBException>(){

            @Override
            public JAXBException createException(Throwable throwable, String message) {
                return new JAXBException(message, throwable);
            }
        };
    }
}

