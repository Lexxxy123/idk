/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
import javassist.orgs.java_websocket.handshake.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class g
implements c {
    private byte[] a;
    private TreeMap<String, String> a = (byte[])new TreeMap(String.CASE_INSENSITIVE_ORDER);

    @Override
    public Iterator<String> a() {
        return Collections.unmodifiableSet(this.a.keySet()).iterator();
    }

    @Override
    public String a(String string) {
        String string2 = (String)this.a.get(string);
        if (string2 == null) {
            return "";
        }
        return string2;
    }

    @Override
    public byte[] a() {
        return this.a;
    }

    @Override
    public void a(byte[] byArray) {
        this.a = byArray;
    }

    @Override
    public void a(String string, String string2) {
        this.a.put(string, string2);
    }

    @Override
    public boolean a(String string) {
        return this.a.containsKey(string);
    }
}

