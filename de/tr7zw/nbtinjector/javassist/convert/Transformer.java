/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.convert;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.bytecode.BadBytecode;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeIterator;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.MethodInfo;
import de.tr7zw.nbtinjector.javassist.bytecode.Opcode;

public abstract class Transformer
implements Opcode {
    private Transformer next;

    public Transformer(Transformer t2) {
        this.next = t2;
    }

    public Transformer getNext() {
        return this.next;
    }

    public void initialize(ConstPool cp, CodeAttribute attr) {
    }

    public void initialize(ConstPool cp, CtClass clazz, MethodInfo minfo) throws CannotCompileException {
        this.initialize(cp, minfo.getCodeAttribute());
    }

    public void clean() {
    }

    public abstract int transform(CtClass var1, int var2, CodeIterator var3, ConstPool var4) throws CannotCompileException, BadBytecode;

    public int extraLocals() {
        return 0;
    }

    public int extraStack() {
        return 0;
    }
}

