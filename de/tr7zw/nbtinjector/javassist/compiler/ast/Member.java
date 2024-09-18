/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler.ast;

import de.tr7zw.nbtinjector.javassist.CtField;
import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Symbol;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Visitor;

public class Member
extends Symbol {
    private static final long serialVersionUID = 1L;
    private CtField field = null;

    public Member(String name) {
        super(name);
    }

    public void setField(CtField f2) {
        this.field = f2;
    }

    public CtField getField() {
        return this.field;
    }

    @Override
    public void accept(Visitor v2) throws CompileError {
        v2.atMember(this);
    }
}

