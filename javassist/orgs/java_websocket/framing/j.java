/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.framing;

import javassist.orgs.java_websocket.enums.c;
import javassist.orgs.java_websocket.framing.e;
import javassist.orgs.java_websocket.util.d;

public class j
extends e {
    public j() {
        super(c.b);
    }

    @Override
    public void a() {
        super.a();
        if (!d.a(this.a())) {
            throw new javassist.orgs.java_websocket.exceptions.c(1007, "Received text is no valid utf8 string!");
        }
    }
}

