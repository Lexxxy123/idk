/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.util.ArrayList;
import javassist.orgs.java_websocket.a;
import javassist.orgs.java_websocket.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class b
implements Runnable {
    private ArrayList<g> a = new ArrayList();
    final /* synthetic */ a a;

    b(a a2) {
        this.a = a2;
    }

    @Override
    public void run() {
        this.a.clear();
        try {
            this.a.addAll(this.a.a());
            long l2 = (long)((double)System.nanoTime() - (double)javassist.orgs.java_websocket.a.a(this.a) * 1.5);
            for (g g2 : this.a) {
                javassist.orgs.java_websocket.a.a(this.a, g2, l2);
            }
        } catch (Exception exception) {
            // empty catch block
        }
        this.a.clear();
    }
}

