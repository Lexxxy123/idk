/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.expr;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.CtBehavior;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.CtConstructor;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import de.tr7zw.nbtinjector.javassist.bytecode.BadBytecode;
import de.tr7zw.nbtinjector.javassist.bytecode.Bytecode;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeIterator;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.Descriptor;
import de.tr7zw.nbtinjector.javassist.bytecode.MethodInfo;
import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.Javac;
import de.tr7zw.nbtinjector.javassist.compiler.JvstCodeGen;
import de.tr7zw.nbtinjector.javassist.compiler.JvstTypeChecker;
import de.tr7zw.nbtinjector.javassist.compiler.ProceedHandler;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTList;
import de.tr7zw.nbtinjector.javassist.expr.Expr;

public class NewExpr
extends Expr {
    String newTypeName;
    int newPos;

    protected NewExpr(int pos, CodeIterator i2, CtClass declaring, MethodInfo m2, String type, int np) {
        super(pos, i2, declaring, m2);
        this.newTypeName = type;
        this.newPos = np;
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

    private CtClass getCtClass() throws NotFoundException {
        return this.thisClass.getClassPool().get(this.newTypeName);
    }

    public String getClassName() {
        return this.newTypeName;
    }

    public String getSignature() {
        ConstPool constPool = this.getConstPool();
        int methodIndex = this.iterator.u16bitAt(this.currentPos + 1);
        return constPool.getMethodrefType(methodIndex);
    }

    public CtConstructor getConstructor() throws NotFoundException {
        ConstPool cp = this.getConstPool();
        int index = this.iterator.u16bitAt(this.currentPos + 1);
        String desc = cp.getMethodrefType(index);
        return this.getCtClass().getConstructor(desc);
    }

    @Override
    public CtClass[] mayThrow() {
        return super.mayThrow();
    }

    private int canReplace() throws CannotCompileException {
        int op = this.iterator.byteAt(this.newPos + 3);
        if (op == 89) {
            return this.iterator.byteAt(this.newPos + 4) == 94 && this.iterator.byteAt(this.newPos + 5) == 88 ? 6 : 4;
        }
        if (op == 90 && this.iterator.byteAt(this.newPos + 4) == 95) {
            return 5;
        }
        return 3;
    }

    @Override
    public void replace(String statement) throws CannotCompileException {
        this.thisClass.getClassFile();
        int bytecodeSize = 3;
        int pos = this.newPos;
        int newIndex = this.iterator.u16bitAt(pos + 1);
        int codeSize = this.canReplace();
        int end = pos + codeSize;
        for (int i2 = pos; i2 < end; ++i2) {
            this.iterator.writeByte(0, i2);
        }
        ConstPool constPool = this.getConstPool();
        pos = this.currentPos;
        int methodIndex = this.iterator.u16bitAt(pos + 1);
        String signature = constPool.getMethodrefType(methodIndex);
        Javac jc = new Javac(this.thisClass);
        ClassPool cp = this.thisClass.getClassPool();
        CodeAttribute ca = this.iterator.get();
        try {
            CtClass[] params = Descriptor.getParameterTypes(signature, cp);
            CtClass newType = cp.get(this.newTypeName);
            int paramVar = ca.getMaxLocals();
            jc.recordParams(this.newTypeName, params, true, paramVar, this.withinStatic());
            int retVar = jc.recordReturnType(newType, true);
            jc.recordProceed(new ProceedForNew(newType, newIndex, methodIndex));
            NewExpr.checkResultValue(newType, statement);
            Bytecode bytecode = jc.getBytecode();
            NewExpr.storeStack(params, true, paramVar, bytecode);
            jc.recordLocalVariables(ca, pos);
            bytecode.addConstZero(newType);
            bytecode.addStore(retVar, newType);
            jc.compileStmnt(statement);
            if (codeSize > 3) {
                bytecode.addAload(retVar);
            }
            this.replace0(pos, bytecode, 3);
        } catch (CompileError e2) {
            throw new CannotCompileException(e2);
        } catch (NotFoundException e3) {
            throw new CannotCompileException(e3);
        } catch (BadBytecode e4) {
            throw new CannotCompileException("broken method");
        }
    }

    static class ProceedForNew
    implements ProceedHandler {
        CtClass newType;
        int newIndex;
        int methodIndex;

        ProceedForNew(CtClass nt, int ni, int mi) {
            this.newType = nt;
            this.newIndex = ni;
            this.methodIndex = mi;
        }

        @Override
        public void doit(JvstCodeGen gen, Bytecode bytecode, ASTList args) throws CompileError {
            bytecode.addOpcode(187);
            bytecode.addIndex(this.newIndex);
            bytecode.addOpcode(89);
            gen.atMethodCallCore(this.newType, "<init>", args, false, true, -1, null);
            gen.setType(this.newType);
        }

        @Override
        public void setReturnType(JvstTypeChecker c2, ASTList args) throws CompileError {
            c2.atMethodCallCore(this.newType, "<init>", args);
            c2.setType(this.newType);
        }
    }
}

