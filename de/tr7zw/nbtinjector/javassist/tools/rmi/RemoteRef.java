/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.tools.rmi;

import java.io.Serializable;

public class RemoteRef
implements Serializable {
    private static final long serialVersionUID = 1L;
    public int oid;
    public String classname;

    public RemoteRef(int i2) {
        this.oid = i2;
        this.classname = null;
    }

    public RemoteRef(int i2, String name) {
        this.oid = i2;
        this.classname = name;
    }
}

