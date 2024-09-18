/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler;

import de.tr7zw.nbtinjector.javassist.bytecode.Bytecode;
import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.JvstCodeGen;
import de.tr7zw.nbtinjector.javassist.compiler.JvstTypeChecker;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTList;

public interface ProceedHandler {
    public void doit(JvstCodeGen var1, Bytecode var2, ASTList var3) throws CompileError;

    public void setReturnType(JvstTypeChecker var1, ASTList var2) throws CompileError;
}

