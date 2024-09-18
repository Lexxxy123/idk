/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;

public class DuplicateMemberException
extends CannotCompileException {
    private static final long serialVersionUID = 1L;

    public DuplicateMemberException(String msg) {
        super(msg);
    }
}

