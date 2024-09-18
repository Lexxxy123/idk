/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.exceptions;

import java.io.IOException;
import javassist.orgs.java_websocket.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class j
extends Exception {
    private final g a;
    private final IOException a;

    public j(g g2, IOException iOException) {
        this.a = g2;
        this.a = iOException;
    }

    public g a() {
        return this.a;
    }

    public IOException a() {
        return this.a;
    }
}

