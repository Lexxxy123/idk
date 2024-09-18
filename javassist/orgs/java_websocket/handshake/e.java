/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.handshake;

import javassist.orgs.java_websocket.handshake.g;
import javassist.orgs.java_websocket.handshake.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e
extends g
implements i {
    private short a;
    private String a;

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public short a() {
        return this.a;
    }

    @Override
    public void a(String string) {
        this.a = string;
    }

    @Override
    public void a(short s2) {
        this.a = s2;
    }
}

