/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.tools.rmi;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.CtConstructor;
import de.tr7zw.nbtinjector.javassist.CtField;
import de.tr7zw.nbtinjector.javassist.CtMethod;
import de.tr7zw.nbtinjector.javassist.CtNewConstructor;
import de.tr7zw.nbtinjector.javassist.CtNewMethod;
import de.tr7zw.nbtinjector.javassist.Modifier;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import de.tr7zw.nbtinjector.javassist.Translator;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Map;

public class StubGenerator
implements Translator {
    private static final String fieldImporter = "importer";
    private static final String fieldObjectId = "objectId";
    private static final String accessorObjectId = "_getObjectId";
    private static final String sampleClass = "de.tr7zw.nbtinjector.javassist.tools.rmi.Sample";
    private ClassPool classPool;
    private Map<String, CtClass> proxyClasses = new Hashtable<String, CtClass>();
    private CtMethod forwardMethod;
    private CtMethod forwardStaticMethod;
    private CtClass[] proxyConstructorParamTypes;
    private CtClass[] interfacesForProxy;
    private CtClass[] exceptionForProxy;

    @Override
    public void start(ClassPool pool) throws NotFoundException {
        this.classPool = pool;
        CtClass c2 = pool.get(sampleClass);
        this.forwardMethod = c2.getDeclaredMethod("forward");
        this.forwardStaticMethod = c2.getDeclaredMethod("forwardStatic");
        this.proxyConstructorParamTypes = pool.get(new String[]{"de.tr7zw.nbtinjector.javassist.tools.rmi.ObjectImporter", "int"});
        this.interfacesForProxy = pool.get(new String[]{"java.io.Serializable", "de.tr7zw.nbtinjector.javassist.tools.rmi.Proxy"});
        this.exceptionForProxy = new CtClass[]{pool.get("de.tr7zw.nbtinjector.javassist.tools.rmi.RemoteException")};
    }

    @Override
    public void onLoad(ClassPool pool, String classname) {
    }

    public boolean isProxyClass(String name) {
        return this.proxyClasses.get(name) != null;
    }

    public synchronized boolean makeProxyClass(Class<?> clazz) throws CannotCompileException, NotFoundException {
        String classname = clazz.getName();
        if (this.proxyClasses.get(classname) != null) {
            return false;
        }
        CtClass ctclazz = this.produceProxyClass(this.classPool.get(classname), clazz);
        this.proxyClasses.put(classname, ctclazz);
        this.modifySuperclass(ctclazz);
        return true;
    }

    private CtClass produceProxyClass(CtClass orgclass, Class<?> orgRtClass) throws CannotCompileException, NotFoundException {
        int modify = orgclass.getModifiers();
        if (Modifier.isAbstract(modify) || Modifier.isNative(modify) || !Modifier.isPublic(modify)) {
            throw new CannotCompileException(orgclass.getName() + " must be public, non-native, and non-abstract.");
        }
        CtClass proxy = this.classPool.makeClass(orgclass.getName(), orgclass.getSuperclass());
        proxy.setInterfaces(this.interfacesForProxy);
        CtField f2 = new CtField(this.classPool.get("de.tr7zw.nbtinjector.javassist.tools.rmi.ObjectImporter"), fieldImporter, proxy);
        f2.setModifiers(2);
        proxy.addField(f2, CtField.Initializer.byParameter(0));
        f2 = new CtField(CtClass.intType, fieldObjectId, proxy);
        f2.setModifiers(2);
        proxy.addField(f2, CtField.Initializer.byParameter(1));
        proxy.addMethod(CtNewMethod.getter(accessorObjectId, f2));
        proxy.addConstructor(CtNewConstructor.defaultConstructor(proxy));
        CtConstructor cons = CtNewConstructor.skeleton(this.proxyConstructorParamTypes, null, proxy);
        proxy.addConstructor(cons);
        try {
            this.addMethods(proxy, orgRtClass.getMethods());
            return proxy;
        } catch (SecurityException e2) {
            throw new CannotCompileException(e2);
        }
    }

    private CtClass toCtClass(Class<?> rtclass) throws NotFoundException {
        String name;
        if (!rtclass.isArray()) {
            name = rtclass.getName();
        } else {
            StringBuffer sbuf = new StringBuffer();
            do {
                sbuf.append("[]");
            } while ((rtclass = rtclass.getComponentType()).isArray());
            sbuf.insert(0, rtclass.getName());
            name = sbuf.toString();
        }
        return this.classPool.get(name);
    }

    private CtClass[] toCtClass(Class<?>[] rtclasses) throws NotFoundException {
        int n2 = rtclasses.length;
        CtClass[] ctclasses = new CtClass[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            ctclasses[i2] = this.toCtClass(rtclasses[i2]);
        }
        return ctclasses;
    }

    private void addMethods(CtClass proxy, Method[] ms) throws CannotCompileException, NotFoundException {
        for (int i2 = 0; i2 < ms.length; ++i2) {
            Method m2 = ms[i2];
            int mod = m2.getModifiers();
            if (m2.getDeclaringClass() == Object.class || Modifier.isFinal(mod)) continue;
            if (Modifier.isPublic(mod)) {
                CtMethod body = Modifier.isStatic(mod) ? this.forwardStaticMethod : this.forwardMethod;
                CtMethod wmethod = CtNewMethod.wrapped(this.toCtClass(m2.getReturnType()), m2.getName(), this.toCtClass(m2.getParameterTypes()), this.exceptionForProxy, body, CtMethod.ConstParameter.integer(i2), proxy);
                wmethod.setModifiers(mod);
                proxy.addMethod(wmethod);
                continue;
            }
            if (Modifier.isProtected(mod) || Modifier.isPrivate(mod)) continue;
            throw new CannotCompileException("the methods must be public, protected, or private.");
        }
    }

    private void modifySuperclass(CtClass orgclass) throws CannotCompileException, NotFoundException {
        CtClass superclazz;
        while ((superclazz = orgclass.getSuperclass()) != null) {
            try {
                superclazz.getDeclaredConstructor(null);
                break;
            } catch (NotFoundException notFoundException) {
                superclazz.addConstructor(CtNewConstructor.defaultConstructor(superclazz));
                orgclass = superclazz;
            }
        }
    }
}

