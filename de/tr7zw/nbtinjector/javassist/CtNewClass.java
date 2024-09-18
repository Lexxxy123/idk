/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.CtClassType;
import de.tr7zw.nbtinjector.javassist.CtConstructor;
import de.tr7zw.nbtinjector.javassist.CtNewConstructor;
import de.tr7zw.nbtinjector.javassist.Modifier;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import de.tr7zw.nbtinjector.javassist.bytecode.ClassFile;
import java.io.DataOutputStream;
import java.io.IOException;

class CtNewClass
extends CtClassType {
    protected boolean hasConstructor;

    CtNewClass(String name, ClassPool cp, boolean isInterface, CtClass superclass) {
        super(name, cp);
        this.wasChanged = true;
        String superName = isInterface || superclass == null ? null : superclass.getName();
        this.classfile = new ClassFile(isInterface, name, superName);
        if (isInterface && superclass != null) {
            this.classfile.setInterfaces(new String[]{superclass.getName()});
        }
        this.setModifiers(Modifier.setPublic(this.getModifiers()));
        this.hasConstructor = isInterface;
    }

    @Override
    protected void extendToString(StringBuffer buffer) {
        if (this.hasConstructor) {
            buffer.append("hasConstructor ");
        }
        super.extendToString(buffer);
    }

    @Override
    public void addConstructor(CtConstructor c2) throws CannotCompileException {
        this.hasConstructor = true;
        super.addConstructor(c2);
    }

    @Override
    public void toBytecode(DataOutputStream out) throws CannotCompileException, IOException {
        if (!this.hasConstructor) {
            try {
                this.inheritAllConstructors();
                this.hasConstructor = true;
            } catch (NotFoundException e2) {
                throw new CannotCompileException(e2);
            }
        }
        super.toBytecode(out);
    }

    public void inheritAllConstructors() throws CannotCompileException, NotFoundException {
        CtClass superclazz = this.getSuperclass();
        CtConstructor[] cs = superclazz.getDeclaredConstructors();
        int n2 = 0;
        for (int i2 = 0; i2 < cs.length; ++i2) {
            CtConstructor c2 = cs[i2];
            int mod = c2.getModifiers();
            if (!this.isInheritable(mod, superclazz)) continue;
            CtConstructor cons = CtNewConstructor.make(c2.getParameterTypes(), c2.getExceptionTypes(), this);
            cons.setModifiers(mod & 7);
            this.addConstructor(cons);
            ++n2;
        }
        if (n2 < 1) {
            throw new CannotCompileException("no inheritable constructor in " + superclazz.getName());
        }
    }

    private boolean isInheritable(int mod, CtClass superclazz) {
        if (Modifier.isPrivate(mod)) {
            return false;
        }
        if (Modifier.isPackage(mod)) {
            String pname = this.getPackageName();
            String pname2 = superclazz.getPackageName();
            if (pname == null) {
                return pname2 == null;
            }
            return pname.equals(pname2);
        }
        return true;
    }
}

