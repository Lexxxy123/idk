/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.expr;

import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.CtConstructor;
import de.tr7zw.nbtinjector.javassist.CtMethod;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeIterator;
import de.tr7zw.nbtinjector.javassist.bytecode.MethodInfo;
import de.tr7zw.nbtinjector.javassist.expr.MethodCall;

public class ConstructorCall
extends MethodCall {
    protected ConstructorCall(int pos, CodeIterator i2, CtClass decl, MethodInfo m2) {
        super(pos, i2, decl, m2);
    }

    @Override
    public String getMethodName() {
        return this.isSuper() ? "super" : "this";
    }

    @Override
    public CtMethod getMethod() throws NotFoundException {
        throw new NotFoundException("this is a constructor call.  Call getConstructor().");
    }

    public CtConstructor getConstructor() throws NotFoundException {
        return this.getCtClass().getConstructor(this.getSignature());
    }

    @Override
    public boolean isSuper() {
        return super.isSuper();
    }
}

