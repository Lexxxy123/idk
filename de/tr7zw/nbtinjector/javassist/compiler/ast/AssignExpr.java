/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler.ast;

import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTList;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTree;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Expr;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Visitor;

public class AssignExpr
extends Expr {
    private static final long serialVersionUID = 1L;

    private AssignExpr(int op, ASTree _head, ASTList _tail) {
        super(op, _head, _tail);
    }

    public static AssignExpr makeAssign(int op, ASTree oprand1, ASTree oprand2) {
        return new AssignExpr(op, oprand1, new ASTList(oprand2));
    }

    @Override
    public void accept(Visitor v2) throws CompileError {
        v2.atAssignExpr(this);
    }
}

