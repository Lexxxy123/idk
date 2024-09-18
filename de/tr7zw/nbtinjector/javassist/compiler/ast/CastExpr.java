/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler.ast;

import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.TokenId;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTList;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTree;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Visitor;

public class CastExpr
extends ASTList
implements TokenId {
    private static final long serialVersionUID = 1L;
    protected int castType;
    protected int arrayDim;

    public CastExpr(ASTList className, int dim, ASTree expr) {
        super(className, new ASTList(expr));
        this.castType = 307;
        this.arrayDim = dim;
    }

    public CastExpr(int type, int dim, ASTree expr) {
        super(null, new ASTList(expr));
        this.castType = type;
        this.arrayDim = dim;
    }

    public int getType() {
        return this.castType;
    }

    public int getArrayDim() {
        return this.arrayDim;
    }

    public ASTList getClassName() {
        return (ASTList)this.getLeft();
    }

    public ASTree getOprand() {
        return this.getRight().getLeft();
    }

    public void setOprand(ASTree t2) {
        this.getRight().setLeft(t2);
    }

    @Override
    public String getTag() {
        return "cast:" + this.castType + ":" + this.arrayDim;
    }

    @Override
    public void accept(Visitor v2) throws CompileError {
        v2.atCastExpr(this);
    }
}

