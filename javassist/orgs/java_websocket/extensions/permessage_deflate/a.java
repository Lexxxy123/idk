/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.extensions.permessage_deflate;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import javassist.orgs.java_websocket.extensions.c;
import javassist.orgs.java_websocket.extensions.d;
import javassist.orgs.java_websocket.framing.e;
import javassist.orgs.java_websocket.framing.f;
import javassist.orgs.java_websocket.framing.g;
import javassist.orgs.java_websocket.framing.j;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
extends javassist.orgs.java_websocket.extensions.a {
    private static final String a = "permessage-deflate";
    private static final String b = "server_no_context_takeover";
    private static final String c = "client_no_context_takeover";
    private static final String d = "server_max_window_bits";
    private static final String e = "client_max_window_bits";
    private static final int a = 32768;
    private static final int b = 32768;
    private static final byte[] a;
    private static final int c = 1024;
    private boolean a;
    private boolean b = false;
    private Map<String, String> a;
    private Inflater a;
    private Deflater a = new Deflater(-1, true);

    static {
        byte[] byArray = new byte[4];
        byArray[2] = -1;
        byArray[3] = -1;
        a = byArray;
    }

    @Override
    public void b(f f2) {
        if (!(f2 instanceof e)) {
            return;
        }
        if (f2.a() == javassist.orgs.java_websocket.enums.c.a && f2.b()) {
            throw new javassist.orgs.java_websocket.exceptions.c(1008, "RSV1 bit can only be set for the first frame.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.a(f2.a().array(), byteArrayOutputStream);
            if (this.a.getRemaining() > 0) {
                this.a = new Inflater(true);
                this.a(f2.a().array(), byteArrayOutputStream);
            }
            if (f2.a()) {
                this.a(a, byteArrayOutputStream);
                if (this.b) {
                    this.a = new Inflater(true);
                }
            }
        } catch (DataFormatException dataFormatException) {
            throw new javassist.orgs.java_websocket.exceptions.c(1008, dataFormatException.getMessage());
        }
        if (f2.b()) {
            ((e)f2).b(false);
        }
        ((g)f2).a(ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size()));
    }

    private void a(byte[] byArray, ByteArrayOutputStream byteArrayOutputStream) {
        int n2;
        this.a.setInput(byArray);
        byte[] byArray2 = new byte[1024];
        while ((n2 = this.a.inflate(byArray2)) > 0) {
            byteArrayOutputStream.write(byArray2, 0, n2);
        }
    }

    @Override
    public void c(f f2) {
        int n2;
        if (!(f2 instanceof e)) {
            return;
        }
        if (!(f2 instanceof javassist.orgs.java_websocket.framing.c)) {
            ((e)f2).b(true);
        }
        this.a.setInput(f2.a().array());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = new byte[1024];
        while ((n2 = this.a.deflate(byArray, 0, byArray.length, 2)) > 0) {
            byteArrayOutputStream.write(byArray, 0, n2);
        }
        byte[] byArray2 = byteArrayOutputStream.toByteArray();
        int n3 = byArray2.length;
        if (f2.a()) {
            if (this.a(byArray2)) {
                n3 -= a.length;
            }
            if (this.a) {
                this.a.end();
                this.a = new Deflater(-1, true);
            }
        }
        ((g)f2).a(ByteBuffer.wrap(byArray2, 0, n3));
    }

    private boolean a(byte[] byArray) {
        if (byArray.length < 4) {
            return false;
        }
        int n2 = byArray.length;
        int n3 = 0;
        while (n3 < a.length) {
            if (a[n3] != byArray[n2 - a.length + n3]) {
                return false;
            }
            ++n3;
        }
        return true;
    }

    @Override
    public boolean a(String string) {
        String[] stringArray;
        String[] stringArray2 = stringArray = string.split(",");
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String string2 = stringArray2[n3];
            c c2 = javassist.orgs.java_websocket.extensions.c.a(string2);
            if (a.equalsIgnoreCase(c2.a())) {
                Map<String, String> map = c2.a();
                this.a.putAll(map);
                if (this.a.containsKey(c)) {
                    this.b = true;
                }
                return true;
            }
            ++n3;
        }
        return false;
    }

    @Override
    public boolean b(String string) {
        String[] stringArray;
        String[] stringArray2 = stringArray = string.split(",");
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String string2 = stringArray2[n3];
            c c2 = javassist.orgs.java_websocket.extensions.c.a(string2);
            if (a.equalsIgnoreCase(c2.a())) {
                Map<String, String> map = c2.a();
                return true;
            }
            ++n3;
        }
        return false;
    }

    @Override
    public String a() {
        this.a.put(c, javassist.orgs.java_websocket.extensions.c.a);
        this.a.put(b, javassist.orgs.java_websocket.extensions.c.a);
        return "permessage-deflate; server_no_context_takeover; client_no_context_takeover";
    }

    @Override
    public String b() {
        return "permessage-deflate; server_no_context_takeover" + (this.b ? "; client_no_context_takeover" : "");
    }

    @Override
    public d a() {
        return new a();
    }

    @Override
    public void a(f f2) {
        if ((f2 instanceof j || f2 instanceof javassist.orgs.java_websocket.framing.a) && !f2.b()) {
            throw new javassist.orgs.java_websocket.exceptions.e("RSV1 bit must be set for DataFrames.");
        }
        if (f2 instanceof javassist.orgs.java_websocket.framing.c && (f2.b() || f2.c() || f2.d())) {
            throw new javassist.orgs.java_websocket.exceptions.e("bad rsv RSV1: " + f2.b() + " RSV2: " + f2.c() + " RSV3: " + f2.d());
        }
        super.a(f2);
    }

    @Override
    public String toString() {
        return "PerMessageDeflateExtension";
    }
}

