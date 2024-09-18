/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.drafts;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javassist.orgs.java_websocket.enums.b;
import javassist.orgs.java_websocket.enums.c;
import javassist.orgs.java_websocket.enums.e;
import javassist.orgs.java_websocket.exceptions.f;
import javassist.orgs.java_websocket.handshake.d;
import javassist.orgs.java_websocket.handshake.h;
import javassist.orgs.java_websocket.handshake.i;
import javassist.orgs.java_websocket.j;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class a {
    protected e a;
    protected c a = null;

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer.remaining());
        byte by = 48;
        while (byteBuffer.hasRemaining()) {
            byte by2 = by;
            by = byteBuffer.get();
            byteBuffer2.put(by);
            if (by2 != 13 || by != 10) continue;
            byteBuffer2.limit(byteBuffer2.position() - 2);
            byteBuffer2.position(0);
            return byteBuffer2;
        }
        byteBuffer.position(byteBuffer.position() - byteBuffer2.position());
        return null;
    }

    public static String a(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = javassist.orgs.java_websocket.drafts.a.a(byteBuffer);
        return byteBuffer2 == null ? null : javassist.orgs.java_websocket.util.d.a(byteBuffer2.array(), 0, byteBuffer2.limit());
    }

    public static javassist.orgs.java_websocket.handshake.c a(ByteBuffer byteBuffer, e e2) {
        String string = javassist.orgs.java_websocket.drafts.a.a(byteBuffer);
        if (string == null) {
            throw new javassist.orgs.java_websocket.exceptions.b(byteBuffer.capacity() + 128);
        }
        String[] stringArray = string.split(" ", 3);
        if (stringArray.length != 3) {
            throw new f();
        }
        javassist.orgs.java_websocket.handshake.c c2 = e2 == e.a ? javassist.orgs.java_websocket.drafts.a.b(stringArray, string) : javassist.orgs.java_websocket.drafts.a.a(stringArray, string);
        string = javassist.orgs.java_websocket.drafts.a.a(byteBuffer);
        while (string != null && string.length() > 0) {
            String[] stringArray2 = string.split(":", 2);
            if (stringArray2.length != 2) {
                throw new f("not an http header");
            }
            if (c2.a(stringArray2[0])) {
                c2.a(stringArray2[0], String.valueOf(c2.a(stringArray2[0])) + "; " + stringArray2[1].replaceFirst("^ +", ""));
            } else {
                c2.a(stringArray2[0], stringArray2[1].replaceFirst("^ +", ""));
            }
            string = javassist.orgs.java_websocket.drafts.a.a(byteBuffer);
        }
        if (string == null) {
            throw new javassist.orgs.java_websocket.exceptions.b();
        }
        return c2;
    }

    private static javassist.orgs.java_websocket.handshake.c a(String[] stringArray, String string) {
        if (!"GET".equalsIgnoreCase(stringArray[0])) {
            throw new f(String.format("Invalid request method received: %s Status line: %s", stringArray[0], string));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(stringArray[2])) {
            throw new f(String.format("Invalid status line received: %s Status line: %s", stringArray[2], string));
        }
        d d2 = new d();
        d2.a(stringArray[1]);
        return d2;
    }

    private static javassist.orgs.java_websocket.handshake.c b(String[] stringArray, String string) {
        if (!"101".equals(stringArray[1])) {
            throw new f(String.format("Invalid status code received: %s Status line: %s", stringArray[1], string));
        }
        if (!"HTTP/1.1".equalsIgnoreCase(stringArray[0])) {
            throw new f(String.format("Invalid status line received: %s Status line: %s", stringArray[0], string));
        }
        javassist.orgs.java_websocket.handshake.e e2 = new javassist.orgs.java_websocket.handshake.e();
        i i2 = e2;
        i2.a(Short.parseShort(stringArray[1]));
        i2.a(stringArray[2]);
        return e2;
    }

    public abstract b a(javassist.orgs.java_websocket.handshake.a var1, h var2);

    public abstract b a(javassist.orgs.java_websocket.handshake.a var1);

    protected boolean a(javassist.orgs.java_websocket.handshake.f f2) {
        return f2.a("Upgrade").equalsIgnoreCase("websocket") && f2.a("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public abstract ByteBuffer a(javassist.orgs.java_websocket.framing.f var1);

    public abstract List<javassist.orgs.java_websocket.framing.f> a(ByteBuffer var1, boolean var2);

    public abstract List<javassist.orgs.java_websocket.framing.f> a(String var1, boolean var2);

    public abstract void a(j var1, javassist.orgs.java_websocket.framing.f var2);

    public List<javassist.orgs.java_websocket.framing.f> a(c c2, ByteBuffer byteBuffer, boolean bl2) {
        if (c2 != c.c && c2 != c.b) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        javassist.orgs.java_websocket.framing.e e2 = null;
        if (this.a != null) {
            e2 = new javassist.orgs.java_websocket.framing.c();
        } else {
            this.a = c2;
            if (c2 == c.c) {
                e2 = new javassist.orgs.java_websocket.framing.a();
            } else if (c2 == c.b) {
                e2 = new javassist.orgs.java_websocket.framing.j();
            }
        }
        e2.a(byteBuffer);
        e2.a(bl2);
        try {
            e2.a();
        } catch (javassist.orgs.java_websocket.exceptions.c c3) {
            throw new IllegalArgumentException(c3);
        }
        this.a = bl2 ? null : c2;
        return Collections.singletonList(e2);
    }

    public abstract void a();

    @Deprecated
    public List<ByteBuffer> a(javassist.orgs.java_websocket.handshake.f f2, e e2) {
        return this.a(f2);
    }

    public List<ByteBuffer> a(javassist.orgs.java_websocket.handshake.f f2) {
        return this.a(f2, true);
    }

    @Deprecated
    public List<ByteBuffer> a(javassist.orgs.java_websocket.handshake.f f2, e e2, boolean bl2) {
        return this.a(f2, bl2);
    }

    public List<ByteBuffer> a(javassist.orgs.java_websocket.handshake.f f2, boolean bl2) {
        Object object;
        Object object2;
        StringBuilder stringBuilder = new StringBuilder(100);
        if (f2 instanceof javassist.orgs.java_websocket.handshake.a) {
            stringBuilder.append("GET ").append(((javassist.orgs.java_websocket.handshake.a)f2).a()).append(" HTTP/1.1");
        } else if (f2 instanceof h) {
            stringBuilder.append("HTTP/1.1 101 ").append(((h)f2).a());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        stringBuilder.append("\r\n");
        Iterator<String> iterator = f2.a();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            object = f2.a((String)object2);
            stringBuilder.append((String)object2);
            stringBuilder.append(": ");
            stringBuilder.append((String)object);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        object2 = javassist.orgs.java_websocket.util.d.b(stringBuilder.toString());
        object = bl2 ? f2.a() : null;
        ByteBuffer byteBuffer = ByteBuffer.allocate((object == null ? 0 : ((Object)object).length) + ((Object)object2).length);
        byteBuffer.put((byte[])object2);
        if (object != null) {
            byteBuffer.put((byte[])object);
        }
        byteBuffer.flip();
        return Collections.singletonList(byteBuffer);
    }

    public abstract javassist.orgs.java_websocket.handshake.b a(javassist.orgs.java_websocket.handshake.b var1);

    public abstract javassist.orgs.java_websocket.handshake.c a(javassist.orgs.java_websocket.handshake.a var1, i var2);

    public abstract List<javassist.orgs.java_websocket.framing.f> a(ByteBuffer var1);

    public abstract javassist.orgs.java_websocket.enums.a a();

    public abstract a a();

    public javassist.orgs.java_websocket.handshake.f a(ByteBuffer byteBuffer) {
        return javassist.orgs.java_websocket.drafts.a.a(byteBuffer, this.a);
    }

    public int a(int n2) {
        if (n2 < 0) {
            throw new javassist.orgs.java_websocket.exceptions.c(1002, "Negative count");
        }
        return n2;
    }

    int a(javassist.orgs.java_websocket.handshake.f f2) {
        String string = f2.a("Sec-WebSocket-Version");
        if (string.length() > 0) {
            try {
                int n2 = new Integer(string.trim());
                return n2;
            } catch (NumberFormatException numberFormatException) {
                return -1;
            }
        }
        return -1;
    }

    public void a(e e2) {
        this.a = e2;
    }

    public e a() {
        return this.a;
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }
}

