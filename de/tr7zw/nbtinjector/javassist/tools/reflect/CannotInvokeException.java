/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.tools.reflect;

import java.lang.reflect.InvocationTargetException;

public class CannotInvokeException
extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Throwable err = null;

    public Throwable getReason() {
        return this.err;
    }

    public CannotInvokeException(String reason) {
        super(reason);
    }

    public CannotInvokeException(InvocationTargetException e2) {
        super("by " + e2.getTargetException().toString());
        this.err = e2.getTargetException();
    }

    public CannotInvokeException(IllegalAccessException e2) {
        super("by " + e2.toString());
        this.err = e2;
    }

    public CannotInvokeException(ClassNotFoundException e2) {
        super("by " + e2.toString());
        this.err = e2;
    }
}

