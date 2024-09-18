/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.expr;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.CtBehavior;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.CtPrimitiveType;
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

public class NewArray
extends Expr {
    int opcode;

    protected NewArray(int pos, CodeIterator i2, CtClass declaring, MethodInfo m2, int op) {
        super(pos, i2, declaring, m2);
        this.opcode = op;
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

    public CtClass getComponentType() throws NotFoundException {
        if (this.opcode == 188) {
            int atype = this.iterator.byteAt(this.currentPos + 1);
            return this.getPrimitiveType(atype);
        }
        if (this.opcode == 189 || this.opcode == 197) {
            int index = this.iterator.u16bitAt(this.currentPos + 1);
            String desc = this.getConstPool().getClassInfo(index);
            int dim = Descriptor.arrayDimension(desc);
            desc = Descriptor.toArrayComponent(desc, dim);
            return Descriptor.toCtClass(desc, this.thisClass.getClassPool());
        }
        throw new RuntimeException("bad opcode: " + this.opcode);
    }

    CtClass getPrimitiveType(int atype) {
        switch (atype) {
            case 4: {
                return CtClass.booleanType;
            }
            case 5: {
                return CtClass.charType;
            }
            case 6: {
                return CtClass.floatType;
            }
            case 7: {
                return CtClass.doubleType;
            }
            case 8: {
                return CtClass.byteType;
            }
            case 9: {
                return CtClass.shortType;
            }
            case 10: {
                return CtClass.intType;
            }
            case 11: {
                return CtClass.longType;
            }
        }
        throw new RuntimeException("bad atype: " + atype);
    }

    public int getDimension() {
        if (this.opcode == 188) {
            return 1;
        }
        if (this.opcode == 189 || this.opcode == 197) {
            int index = this.iterator.u16bitAt(this.currentPos + 1);
            String desc = this.getConstPool().getClassInfo(index);
            return Descriptor.arrayDimension(desc) + (this.opcode == 189 ? 1 : 0);
        }
        throw new RuntimeException("bad opcode: " + this.opcode);
    }

    public int getCreatedDimensions() {
        if (this.opcode == 197) {
            return this.iterator.byteAt(this.currentPos + 3);
        }
        return 1;
    }

    @Override
    public void replace(String statement) throws CannotCompileException {
        try {
            this.replace2(statement);
        } catch (CompileError e2) {
            throw new CannotCompileException(e2);
        } catch (NotFoundException e3) {
            throw new CannotCompileException(e3);
        } catch (BadBytecode e4) {
            throw new CannotCompileException("broken method");
        }
    }

    private void replace2(String statement) throws CompileError, NotFoundException, BadBytecode, CannotCompileException {
        int codeLength;
        String desc;
        this.thisClass.getClassFile();
        ConstPool constPool = this.getConstPool();
        int pos = this.currentPos;
        int index = 0;
        int dim = 1;
        if (this.opcode == 188) {
            index = this.iterator.byteAt(this.currentPos + 1);
            CtPrimitiveType cpt = (CtPrimitiveType)this.getPrimitiveType(index);
            desc = "[" + cpt.getDescriptor();
            codeLength = 2;
        } else if (this.opcode == 189) {
            index = this.iterator.u16bitAt(pos + 1);
            desc = constPool.getClassInfo(index);
            desc = desc.startsWith("[") ? "[" + desc : "[L" + desc + ";";
            codeLength = 3;
        } else if (this.opcode == 197) {
            index = this.iterator.u16bitAt(this.currentPos + 1);
            desc = constPool.getClassInfo(index);
            dim = this.iterator.byteAt(this.currentPos + 3);
            codeLength = 4;
        } else {
            throw new RuntimeException("bad opcode: " + this.opcode);
        }
        CtClass retType = Descriptor.toCtClass(desc, this.thisClass.getClassPool());
        Javac jc = new Javac(this.thisClass);
        CodeAttribute ca = this.iterator.get();
        CtClass[] params = new CtClass[dim];
        for (int i2 = 0; i2 < dim; ++i2) {
            params[i2] = CtClass.intType;
        }
        int paramVar = ca.getMaxLocals();
        jc.recordParams("java.lang.Object", params, true, paramVar, this.withinStatic());
        NewArray.checkResultValue(retType, statement);
        int retVar = jc.recordReturnType(retType, true);
        jc.recordProceed(new ProceedForArray(retType, this.opcode, index, dim));
        Bytecode bytecode = jc.getBytecode();
        NewArray.storeStack(params, true, paramVar, bytecode);
        jc.recordLocalVariables(ca, pos);
        bytecode.addOpcode(1);
        bytecode.addAstore(retVar);
        jc.compileStmnt(statement);
        bytecode.addAload(retVar);
        this.replace0(pos, bytecode, codeLength);
    }

    static class ProceedForArray
    implements ProceedHandler {
        CtClass arrayType;
        int opcode;
        int index;
        int dimension;

        ProceedForArray(CtClass type, int op, int i2, int dim) {
            this.arrayType = type;
            this.opcode = op;
            this.index = i2;
            this.dimension = dim;
        }

        @Override
        public void doit(JvstCodeGen gen, Bytecode bytecode, ASTList args) throws CompileError {
            int num = gen.getMethodArgsLength(args);
            if (num != this.dimension) {
                throw new CompileError("$proceed() with a wrong number of parameters");
            }
            gen.atMethodArgs(args, new int[num], new int[num], new String[num]);
            bytecode.addOpcode(this.opcode);
            if (this.opcode == 189) {
                bytecode.addIndex(this.index);
            } else if (this.opcode == 188) {
                bytecode.add(this.index);
            } else {
                bytecode.addIndex(this.index);
                bytecode.add(this.dimension);
                bytecode.growStack(1 - this.dimension);
            }
            gen.setType(this.arrayType);
        }

        @Override
        public void setReturnType(JvstTypeChecker c2, ASTList args) throws CompileError {
            c2.setType(this.arrayType);
        }
    }
}

