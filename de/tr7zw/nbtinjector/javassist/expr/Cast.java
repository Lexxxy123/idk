/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.expr;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.CtBehavior;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import de.tr7zw.nbtinjector.javassist.bytecode.BadBytecode;
import de.tr7zw.nbtinjector.javassist.bytecode.Bytecode;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeIterator;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.MethodInfo;
import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.Javac;
import de.tr7zw.nbtinjector.javassist.compiler.JvstCodeGen;
import de.tr7zw.nbtinjector.javassist.compiler.JvstTypeChecker;
import de.tr7zw.nbtinjector.javassist.compiler.ProceedHandler;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTList;
import de.tr7zw.nbtinjector.javassist.expr.Expr;

public class Cast
extends Expr {
    protected Cast(int pos, CodeIterator i2, CtClass declaring, MethodInfo m2) {
        super(pos, i2, declaring, m2);
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

    public CtClass getType() throws NotFoundException {
        ConstPool cp = this.getConstPool();
        int pos = this.currentPos;
        int index = this.iterator.u16bitAt(pos + 1);
        String name = cp.getClassInfo(index);
        return this.thisClass.getClassPool().getCtClass(name);
    }

    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    @Override
    public void replace(String statement) throws CannotCompileException {
        this.thisClass.getClassFile();
        ConstPool constPool = this.getConstPool();
        int pos = this.currentPos;
        int index = this.iterator.u16bitAt(pos + 1);
        Javac jc = new Javac(this.thisClass);
        ClassPool cp = this.thisClass.getClassPool();
        CodeAttribute ca = this.iterator.get();
        try {
            CtClass[] params = new CtClass[]{cp.get("java.lang.Object")};
            CtClass retType = this.getType();
            int paramVar = ca.getMaxLocals();
            jc.recordParams("java.lang.Object", params, true, paramVar, this.withinStatic());
            int retVar = jc.recordReturnType(retType, true);
            jc.recordProceed(new ProceedForCast(index, retType));
            Cast.checkResultValue(retType, statement);
            Bytecode bytecode = jc.getBytecode();
            Cast.storeStack(params, true, paramVar, bytecode);
            jc.recordLocalVariables(ca, pos);
            bytecode.addConstZero(retType);
            bytecode.addStore(retVar, retType);
            jc.compileStmnt(statement);
            bytecode.addLoad(retVar, retType);
            this.replace0(pos, bytecode, 3);
        } catch (CompileError e2) {
            throw new CannotCompileException(e2);
        } catch (NotFoundException e3) {
            throw new CannotCompileException(e3);
        } catch (BadBytecode e4) {
            throw new CannotCompileException("broken method");
        }
    }

    static class ProceedForCast
    implements ProceedHandler {
        int index;
        CtClass retType;

        ProceedForCast(int i2, CtClass t2) {
            this.index = i2;
            this.retType = t2;
        }

        @Override
        public void doit(JvstCodeGen gen, Bytecode bytecode, ASTList args) throws CompileError {
            if (gen.getMethodArgsLength(args) != 1) {
                throw new CompileError("$proceed() cannot take more than one parameter for cast");
            }
            gen.atMethodArgs(args, new int[1], new int[1], new String[1]);
            bytecode.addOpcode(192);
            bytecode.addIndex(this.index);
            gen.setType(this.retType);
        }

        @Override
        public void setReturnType(JvstTypeChecker c2, ASTList args) throws CompileError {
            c2.atMethodArgs(args, new int[1], new int[1], new String[1]);
            c2.setType(this.retType);
        }
    }
}

