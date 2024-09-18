/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler.ast;

import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTList;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTree;
import de.tr7zw.nbtinjector.javassist.compiler.ast.CastExpr;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Visitor;

public class InstanceOfExpr
extends CastExpr {
    private static final long serialVersionUID = 1L;

    public InstanceOfExpr(ASTList className, int dim, ASTree expr) {
        super(className, dim, expr);
    }

    public InstanceOfExpr(int type, int dim, ASTree expr) {
        super(type, dim, expr);
    }

    @Override
    public String getTag() {
        return "instanceof:" + this.castType + ":" + this.arrayDim;
    }

    @Override
    public void accept(Visitor v2) throws CompileError {
        v2.atInstanceOfExpr(this);
    }
}

