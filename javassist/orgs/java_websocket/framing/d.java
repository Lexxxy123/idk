/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.framing;

import javassist.orgs.java_websocket.enums.c;
import javassist.orgs.java_websocket.exceptions.e;
import javassist.orgs.java_websocket.framing.g;

public abstract class d
extends g {
    public d(c c2) {
        super(c2);
    }

    @Override
    public void a() {
        if (!this.a()) {
            throw new e("Control frame cant have fin==false set");
        }
        if (this.b()) {
            throw new e("Control frame cant have rsv1==true set");
        }
        if (this.c()) {
            throw new e("Control frame cant have rsv2==true set");
        }
        if (this.d()) {
            throw new e("Control frame cant have rsv3==true set");
        }
    }
}

