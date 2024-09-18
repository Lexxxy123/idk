/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.expr;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.CtBehavior;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import de.tr7zw.nbtinjector.javassist.bytecode.Bytecode;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeIterator;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.ExceptionTable;
import de.tr7zw.nbtinjector.javassist.bytecode.MethodInfo;
import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.Javac;
import de.tr7zw.nbtinjector.javassist.expr.Expr;

public class Handler
extends Expr {
    private static String EXCEPTION_NAME = "$1";
    private ExceptionTable etable;
    private int index;

    protected Handler(ExceptionTable et, int nth, CodeIterator it, CtClass declaring, MethodInfo m2) {
        super(et.handlerPc(nth), it, declaring, m2);
        this.etable = et;
        this.index = nth;
    }

    @Override
    public CtBehavior where() {
        return super.where();
    }

    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }

    @Override
    public String getFileName() {
        return super.getFileName();
    }

    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    public CtClass getType() throws NotFoundException {
        int type = this.etable.catchType(this.index);
        if (type == 0) {
            return null;
        }
        ConstPool cp = this.getConstPool();
        String name = cp.getClassInfo(type);
        return this.thisClass.getClassPool().getCtClass(name);
    }

    public boolean isFinally() {
        return this.etable.catchType(this.index) == 0;
    }

    @Override
    public void replace(String statement) throws CannotCompileException {
        throw new RuntimeException("not implemented yet");
    }

    public void insertBefore(String src) throws CannotCompileException {
        this.edited = true;
        ConstPool cp = this.getConstPool();
        CodeAttribute ca = this.iterator.get();
        Javac jv = new Javac(this.thisClass);
        Bytecode b2 = jv.getBytecode();
        b2.setStackDepth(1);
        b2.setMaxLocals(ca.getMaxLocals());
        try {
            CtClass type = this.getType();
            int var = jv.recordVariable(type, EXCEPTION_NAME);
            jv.recordReturnType(type, false);
            b2.addAstore(var);
            jv.compileStmnt(src);
            b2.addAload(var);
            int oldHandler = this.etable.handlerPc(this.index);
            b2.addOpcode(167);
            b2.addIndex(oldHandler - this.iterator.getCodeLength() - b2.currentPc() + 1);
            this.maxStack = b2.getMaxStack();
            this.maxLocals = b2.getMaxLocals();
            int pos = this.iterator.append(b2.get());
            this.iterator.append(b2.getExceptionTable(), pos);
            this.etable.setHandlerPc(this.index, pos);
        } catch (NotFoundException e2) {
            throw new CannotCompileException(e2);
        } catch (CompileError e3) {
            throw new CannotCompileException(e3);
        }
    }
}

