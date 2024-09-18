/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import javassist.orgs.java_websocket.drafts.a;
import javassist.orgs.java_websocket.drafts.c;
import javassist.orgs.java_websocket.enums.d;
import javassist.orgs.java_websocket.enums.e;
import javassist.orgs.java_websocket.g;
import javassist.orgs.java_websocket.handshake.f;
import javassist.orgs.java_websocket.handshake.h;
import javassist.orgs.java_websocket.handshake.i;
import javassist.orgs.java_websocket.j;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
extends a {
    private static final String a = "Sec-WebSocket-Key";
    private static final String b = "Sec-WebSocket-Protocol";
    private static final String c = "Sec-WebSocket-Extensions";
    private static final String d = "Sec-WebSocket-Accept";
    private static final String e = "Upgrade";
    private static final String f = "Connection";
    private final javassist.orgs.slf4j.c a;
    private javassist.orgs.java_websocket.extensions.d a;
    private List<javassist.orgs.java_websocket.extensions.d> a;
    private javassist.orgs.java_websocket.protocols.a a;
    private List<javassist.orgs.java_websocket.protocols.a> b;
    private javassist.orgs.java_websocket.framing.f a;
    private final List<ByteBuffer> c;
    private ByteBuffer a;
    private final Random a;
    private int a = new Random();

    public b() {
        this(Collections.emptyList());
    }

    public b(javassist.orgs.java_websocket.extensions.d d2) {
        this(Collections.singletonList(d2));
    }

    public b(List<javassist.orgs.java_websocket.extensions.d> list) {
        this(list, Collections.singletonList(new javassist.orgs.java_websocket.protocols.b("")));
    }

    public b(List<javassist.orgs.java_websocket.extensions.d> list, List<javassist.orgs.java_websocket.protocols.a> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public b(List<javassist.orgs.java_websocket.extensions.d> list, int n2) {
        this(list, Collections.singletonList(new javassist.orgs.java_websocket.protocols.b("")), n2);
    }

    public b(List<javassist.orgs.java_websocket.extensions.d> list, List<javassist.orgs.java_websocket.protocols.a> list2, int n2) {
        if (list == null || list2 == null || n2 < 1) {
            throw new IllegalArgumentException();
        }
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list2.size());
        boolean bl2 = false;
        this.c = new ArrayList();
        for (javassist.orgs.java_websocket.extensions.d d2 : list) {
            if (!d2.getClass().equals(javassist.orgs.java_websocket.extensions.b.class)) continue;
            bl2 = true;
        }
        this.a.addAll(list);
        if (!bl2) {
            this.a.add(this.a.size(), this.a);
        }
        this.b.addAll(list2);
        this.a = n2;
    }

    @Override
    public javassist.orgs.java_websocket.enums.b a(javassist.orgs.java_websocket.handshake.a a2) {
        Object object;
        int n2 = this.a((f)a2);
        if (n2 != 13) {
            this.a.a("acceptHandshakeAsServer - Wrong websocket version.");
            return javassist.orgs.java_websocket.enums.b.b;
        }
        javassist.orgs.java_websocket.enums.b b2 = javassist.orgs.java_websocket.enums.b.b;
        String string = a2.a(c);
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            object = (javassist.orgs.java_websocket.extensions.d)iterator.next();
            if (!object.a(string)) continue;
            this.a = object;
            b2 = javassist.orgs.java_websocket.enums.b.a;
            this.a.a("acceptHandshakeAsServer - Matching extension found: {}", (Object)this.a);
            break;
        }
        object = this.a(a2.a(b));
        if (object == javassist.orgs.java_websocket.enums.b.a && b2 == javassist.orgs.java_websocket.enums.b.a) {
            return javassist.orgs.java_websocket.enums.b.a;
        }
        this.a.a("acceptHandshakeAsServer - No matching extension or protocol found.");
        return javassist.orgs.java_websocket.enums.b.b;
    }

    private javassist.orgs.java_websocket.enums.b a(String string) {
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            javassist.orgs.java_websocket.protocols.a a2 = (javassist.orgs.java_websocket.protocols.a)iterator.next();
            if (!a2.a(string)) continue;
            this.a = a2;
            this.a.a("acceptHandshake - Matching protocol found: {}", (Object)this.a);
            return javassist.orgs.java_websocket.enums.b.a;
        }
        return javassist.orgs.java_websocket.enums.b.b;
    }

    @Override
    public javassist.orgs.java_websocket.enums.b a(javassist.orgs.java_websocket.handshake.a a2, h h2) {
        Object object;
        if (!this.a(h2)) {
            this.a.a("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return javassist.orgs.java_websocket.enums.b.b;
        }
        if (!a2.a(a) || !h2.a(d)) {
            this.a.a("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return javassist.orgs.java_websocket.enums.b.b;
        }
        String string = h2.a(d);
        String string2 = a2.a(a);
        if (!(string2 = this.a(string2)).equals(string)) {
            this.a.a("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
            return javassist.orgs.java_websocket.enums.b.b;
        }
        javassist.orgs.java_websocket.enums.b b2 = javassist.orgs.java_websocket.enums.b.b;
        String string3 = h2.a(c);
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            object = (javassist.orgs.java_websocket.extensions.d)iterator.next();
            if (!object.b(string3)) continue;
            this.a = object;
            b2 = javassist.orgs.java_websocket.enums.b.a;
            this.a.a("acceptHandshakeAsClient - Matching extension found: {}", (Object)this.a);
            break;
        }
        object = this.a(h2.a(b));
        if (object == javassist.orgs.java_websocket.enums.b.a && b2 == javassist.orgs.java_websocket.enums.b.a) {
            return javassist.orgs.java_websocket.enums.b.a;
        }
        this.a.a("acceptHandshakeAsClient - No matching extension or protocol found.");
        return javassist.orgs.java_websocket.enums.b.b;
    }

    public javassist.orgs.java_websocket.extensions.d a() {
        return this.a;
    }

    public List<javassist.orgs.java_websocket.extensions.d> a() {
        return this.a;
    }

    public javassist.orgs.java_websocket.protocols.a a() {
        return this.a;
    }

    public int a() {
        return this.a;
    }

    public List<javassist.orgs.java_websocket.protocols.a> b() {
        return this.b;
    }

    @Override
    public javassist.orgs.java_websocket.handshake.b a(javassist.orgs.java_websocket.handshake.b b2) {
        Object object;
        b2.a(e, "websocket");
        b2.a(f, e);
        byte[] byArray = new byte[16];
        this.a.nextBytes(byArray);
        b2.a(a, javassist.orgs.java_websocket.util.a.a(byArray));
        b2.a("Sec-WebSocket-Version", "13");
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = this.a.iterator();
        while (object2.hasNext()) {
            object = (javassist.orgs.java_websocket.extensions.d)object2.next();
            if (object.a() == null || object.a().length() == 0) continue;
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(object.a());
        }
        if (stringBuilder.length() != 0) {
            b2.a(c, stringBuilder.toString());
        }
        object = new StringBuilder();
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            object2 = (javassist.orgs.java_websocket.protocols.a)iterator.next();
            if (object2.a().length() == 0) continue;
            if (((StringBuilder)object).length() > 0) {
                ((StringBuilder)object).append(", ");
            }
            ((StringBuilder)object).append(object2.a());
        }
        if (((StringBuilder)object).length() != 0) {
            b2.a(b, ((StringBuilder)object).toString());
        }
        return b2;
    }

    @Override
    public javassist.orgs.java_websocket.handshake.c a(javassist.orgs.java_websocket.handshake.a a2, i i2) {
        i2.a(e, "websocket");
        i2.a(f, a2.a(f));
        String string = a2.a(a);
        if (string == null) {
            throw new javassist.orgs.java_websocket.exceptions.f("missing Sec-WebSocket-Key");
        }
        i2.a(d, this.a(string));
        if (this.a().b().length() != 0) {
            i2.a(c, this.a().b());
        }
        if (this.a() != null && this.a().a().length() != 0) {
            i2.a(b, this.a().a());
        }
        i2.a("Web Socket Protocol Handshake");
        i2.a("Server", "TooTallNate Java-WebSocket");
        i2.a("Date", this.a());
        return i2;
    }

    @Override
    public a a() {
        ArrayList<javassist.orgs.java_websocket.extensions.d> arrayList = new ArrayList<javassist.orgs.java_websocket.extensions.d>();
        for (javassist.orgs.java_websocket.extensions.d d2 : this.a()) {
            arrayList.add(d2.a());
        }
        ArrayList<javassist.orgs.java_websocket.protocols.a> arrayList2 = new ArrayList<javassist.orgs.java_websocket.protocols.a>();
        for (javassist.orgs.java_websocket.protocols.a a2 : this.b()) {
            arrayList2.add(a2.a());
        }
        return new b(arrayList, arrayList2, this.a);
    }

    @Override
    public ByteBuffer a(javassist.orgs.java_websocket.framing.f f2) {
        this.a().c(f2);
        if (this.a.a()) {
            this.a.a("afterEnconding({}): {}", (Object)f2.a().remaining(), (Object)(f2.a().remaining() > 1000 ? "too big to display" : new String(f2.a().array())));
        }
        return this.b(f2);
    }

    private ByteBuffer b(javassist.orgs.java_websocket.framing.f f2) {
        ByteBuffer byteBuffer = f2.a();
        boolean bl2 = this.a == javassist.orgs.java_websocket.enums.e.a;
        int n2 = this.a(byteBuffer);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1 + (n2 > 1 ? n2 + 1 : n2) + (bl2 ? 4 : 0) + byteBuffer.remaining());
        byte by = this.a(f2.a());
        byte by2 = (byte)(f2.a() ? -128 : 0);
        by2 = (byte)(by2 | by);
        if (f2.b()) {
            by2 = (byte)(by2 | this.a(1));
        }
        if (f2.c()) {
            by2 = (byte)(by2 | this.a(2));
        }
        if (f2.d()) {
            by2 = (byte)(by2 | this.a(3));
        }
        byteBuffer2.put(by2);
        byte[] byArray = this.a((long)byteBuffer.remaining(), n2);
        assert (byArray.length == n2);
        if (n2 == 1) {
            byteBuffer2.put((byte)(byArray[0] | this.a(bl2)));
        } else if (n2 == 2) {
            byteBuffer2.put((byte)(0x7E | this.a(bl2)));
            byteBuffer2.put(byArray);
        } else if (n2 == 8) {
            byteBuffer2.put((byte)(0x7F | this.a(bl2)));
            byteBuffer2.put(byArray);
        } else {
            throw new IllegalStateException("Size representation not supported/specified");
        }
        if (bl2) {
            ByteBuffer byteBuffer3 = ByteBuffer.allocate(4);
            byteBuffer3.putInt(this.a.nextInt());
            byteBuffer2.put(byteBuffer3.array());
            int n3 = 0;
            while (byteBuffer.hasRemaining()) {
                byteBuffer2.put((byte)(byteBuffer.get() ^ byteBuffer3.get(n3 % 4)));
                ++n3;
            }
        } else {
            byteBuffer2.put(byteBuffer);
            byteBuffer.flip();
        }
        assert (byteBuffer2.remaining() == 0) : byteBuffer2.remaining();
        byteBuffer2.flip();
        return byteBuffer2;
    }

    private javassist.orgs.java_websocket.framing.f a(ByteBuffer byteBuffer) {
        Object object;
        Object object2;
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        int n2 = byteBuffer.remaining();
        int n3 = 2;
        this.a(n2, n3);
        byte by = byteBuffer.get();
        boolean bl2 = by >> 8 != 0;
        boolean bl3 = (by & 0x40) != 0;
        boolean bl4 = (by & 0x20) != 0;
        boolean bl5 = (by & 0x10) != 0;
        byte by2 = byteBuffer.get();
        boolean bl6 = (by2 & 0xFFFFFF80) != 0;
        int n4 = by2 & 0x7F;
        javassist.orgs.java_websocket.enums.c c2 = this.a((byte)(by & 0xF));
        if (n4 < 0 || n4 > 125) {
            object2 = this.a(byteBuffer, c2, n4, n2, n3);
            n4 = javassist.orgs.java_websocket.drafts.c.a((c)object2);
            n3 = javassist.orgs.java_websocket.drafts.c.b((c)object2);
        }
        this.a((long)n4);
        n3 += bl6 ? 4 : 0;
        this.a(n2, n3 += n4);
        object2 = ByteBuffer.allocate(this.a(n4));
        if (bl6) {
            object = new byte[4];
            byteBuffer.get((byte[])object);
            int n5 = 0;
            while (n5 < n4) {
                ((ByteBuffer)object2).put((byte)(byteBuffer.get() ^ object[n5 % 4]));
                ++n5;
            }
        } else {
            ((ByteBuffer)object2).put(byteBuffer.array(), byteBuffer.position(), ((Buffer)object2).limit());
            byteBuffer.position(byteBuffer.position() + ((Buffer)object2).limit());
        }
        object = javassist.orgs.java_websocket.framing.g.a(c2);
        ((javassist.orgs.java_websocket.framing.g)object).a(bl2);
        ((javassist.orgs.java_websocket.framing.g)object).b(bl3);
        ((javassist.orgs.java_websocket.framing.g)object).c(bl4);
        ((javassist.orgs.java_websocket.framing.g)object).d(bl5);
        ((Buffer)object2).flip();
        ((javassist.orgs.java_websocket.framing.g)object).a((ByteBuffer)object2);
        this.a().a((javassist.orgs.java_websocket.framing.f)object);
        this.a().b((javassist.orgs.java_websocket.framing.f)object);
        if (this.a.a()) {
            this.a.a("afterDecoding({}): {}", (Object)((javassist.orgs.java_websocket.framing.g)object).a().remaining(), (Object)(((javassist.orgs.java_websocket.framing.g)object).a().remaining() > 1000 ? "too big to display" : new String(((javassist.orgs.java_websocket.framing.g)object).a().array())));
        }
        ((javassist.orgs.java_websocket.framing.g)object).a();
        return object;
    }

    private c a(ByteBuffer byteBuffer, javassist.orgs.java_websocket.enums.c c2, int n2, int n3, int n4) {
        int n5 = n2;
        int n6 = n4;
        if (c2 == javassist.orgs.java_websocket.enums.c.d || c2 == javassist.orgs.java_websocket.enums.c.e || c2 == javassist.orgs.java_websocket.enums.c.f) {
            this.a.a("Invalid frame: more than 125 octets");
            throw new javassist.orgs.java_websocket.exceptions.e("more than 125 octets");
        }
        if (n5 == 126) {
            this.a(n3, n6 += 2);
            byte[] byArray = new byte[3];
            byArray[1] = byteBuffer.get();
            byArray[2] = byteBuffer.get();
            n5 = new BigInteger(byArray).intValue();
        } else {
            this.a(n3, n6 += 8);
            byte[] byArray = new byte[8];
            int n7 = 0;
            while (n7 < 8) {
                byArray[n7] = byteBuffer.get();
                ++n7;
            }
            long l2 = new BigInteger(byArray).longValue();
            this.a(l2);
            n5 = (int)l2;
        }
        return new c(this, n5, n6);
    }

    private void a(long l2) {
        if (l2 > Integer.MAX_VALUE) {
            this.a.a("Limit exedeed: Payloadsize is to big...");
            throw new javassist.orgs.java_websocket.exceptions.g("Payloadsize is to big...");
        }
        if (l2 > (long)this.a) {
            this.a.a("Payload limit reached. Allowed: {} Current: {}", (Object)this.a, (Object)l2);
            throw new javassist.orgs.java_websocket.exceptions.g("Payload limit reached.", this.a);
        }
        if (l2 < 0L) {
            this.a.a("Limit underflow: Payloadsize is to little...");
            throw new javassist.orgs.java_websocket.exceptions.g("Payloadsize is to little...");
        }
    }

    private void a(int n2, int n3) {
        if (n2 < n3) {
            this.a.a("Incomplete frame: maxpacketsize < realpacketsize");
            throw new javassist.orgs.java_websocket.exceptions.a(n3);
        }
    }

    private byte a(int n2) {
        if (n2 == 1) {
            return 64;
        }
        if (n2 == 2) {
            return 32;
        }
        if (n2 == 3) {
            return 16;
        }
        return 0;
    }

    private byte a(boolean bl2) {
        return bl2 ? (byte)-128 : 0;
    }

    private int a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        if (byteBuffer.remaining() <= 65535) {
            return 2;
        }
        return 8;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public List<javassist.orgs.java_websocket.framing.f> a(ByteBuffer var1_1) {
        while (true) {
            var2_2 = new LinkedList<javassist.orgs.java_websocket.framing.f>();
            if (this.a == null) ** GOTO lbl50
            try {
                var1_1.mark();
                var4_4 = var1_1.remaining();
                var5_7 = this.a.remaining();
                if (var5_7 > var4_4) {
                    this.a.put(var1_1.array(), var1_1.position(), var4_4);
                    var1_1.position(var1_1.position() + var4_4);
                    return Collections.emptyList();
                }
                this.a.put(var1_1.array(), var1_1.position(), var5_7);
                var1_1.position(var1_1.position() + var5_7);
                var3_8 = this.a((ByteBuffer)this.a.duplicate().position(0));
                var2_2.add(var3_8);
                this.a = null;
                if (true) ** GOTO lbl50
            } catch (javassist.orgs.java_websocket.exceptions.a var4_3) {
                var5_6 = ByteBuffer.allocate(this.a(var4_3.a()));
                if (!javassist.orgs.java_websocket.drafts.b.a && var5_6.limit() <= this.a.limit()) {
                    throw new AssertionError();
                }
                this.a.rewind();
                var5_6.put(this.a);
                this.a = var5_6;
                continue;
            }
            break;
        }
        do {
            var1_1.mark();
            try {
                var3_8 = this.a(var1_1);
                var2_2.add(var3_8);
            } catch (javassist.orgs.java_websocket.exceptions.a var4_5) {
                var1_1.reset();
                var5_7 = var4_5.a();
                this.a = ByteBuffer.allocate(this.a(var5_7));
                this.a.put(var1_1);
                break;
            }
lbl50:
            // 3 sources

        } while (var1_1.hasRemaining());
        return var2_2;
    }

    @Override
    public List<javassist.orgs.java_websocket.framing.f> a(ByteBuffer byteBuffer, boolean bl2) {
        javassist.orgs.java_websocket.framing.a a2 = new javassist.orgs.java_websocket.framing.a();
        a2.a(byteBuffer);
        a2.e(bl2);
        try {
            a2.a();
        } catch (javassist.orgs.java_websocket.exceptions.c c2) {
            throw new javassist.orgs.java_websocket.exceptions.h(c2);
        }
        return Collections.singletonList(a2);
    }

    @Override
    public List<javassist.orgs.java_websocket.framing.f> a(String string, boolean bl2) {
        javassist.orgs.java_websocket.framing.j j2 = new javassist.orgs.java_websocket.framing.j();
        j2.a(ByteBuffer.wrap(javassist.orgs.java_websocket.util.d.a(string)));
        j2.e(bl2);
        try {
            j2.a();
        } catch (javassist.orgs.java_websocket.exceptions.c c2) {
            throw new javassist.orgs.java_websocket.exceptions.h(c2);
        }
        return Collections.singletonList(j2);
    }

    @Override
    public void a() {
        this.a = null;
        if (this.a != null) {
            this.a.a();
        }
        this.a = new javassist.orgs.java_websocket.extensions.b();
        this.a = null;
    }

    private String a() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String a(String string) {
        MessageDigest messageDigest;
        String string2 = string.trim();
        String string3 = String.valueOf(string2) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new IllegalStateException(noSuchAlgorithmException);
        }
        return javassist.orgs.java_websocket.util.a.a(messageDigest.digest(string3.getBytes()));
    }

    private byte[] a(long l2, int n2) {
        byte[] byArray = new byte[n2];
        int n3 = 8 * n2 - 8;
        int n4 = 0;
        while (n4 < n2) {
            byArray[n4] = (byte)(l2 >>> n3 - 8 * n4);
            ++n4;
        }
        return byArray;
    }

    private byte a(javassist.orgs.java_websocket.enums.c c2) {
        if (c2 == javassist.orgs.java_websocket.enums.c.a) {
            return 0;
        }
        if (c2 == javassist.orgs.java_websocket.enums.c.b) {
            return 1;
        }
        if (c2 == javassist.orgs.java_websocket.enums.c.c) {
            return 2;
        }
        if (c2 == javassist.orgs.java_websocket.enums.c.f) {
            return 8;
        }
        if (c2 == javassist.orgs.java_websocket.enums.c.d) {
            return 9;
        }
        if (c2 == javassist.orgs.java_websocket.enums.c.e) {
            return 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + c2.toString());
    }

    private javassist.orgs.java_websocket.enums.c a(byte by) {
        switch (by) {
            case 0: {
                return javassist.orgs.java_websocket.enums.c.a;
            }
            case 1: {
                return javassist.orgs.java_websocket.enums.c.b;
            }
            case 2: {
                return javassist.orgs.java_websocket.enums.c.c;
            }
            case 8: {
                return javassist.orgs.java_websocket.enums.c.f;
            }
            case 9: {
                return javassist.orgs.java_websocket.enums.c.d;
            }
            case 10: {
                return javassist.orgs.java_websocket.enums.c.e;
            }
        }
        throw new javassist.orgs.java_websocket.exceptions.e("Unknown opcode " + (short)by);
    }

    @Override
    public void a(j j2, javassist.orgs.java_websocket.framing.f f2) {
        javassist.orgs.java_websocket.enums.c c2 = f2.a();
        if (c2 == javassist.orgs.java_websocket.enums.c.f) {
            this.e(j2, f2);
        } else if (c2 == javassist.orgs.java_websocket.enums.c.d) {
            j2.a().a((g)j2, f2);
        } else if (c2 == javassist.orgs.java_websocket.enums.c.e) {
            j2.e();
            j2.a().b(j2, f2);
        } else if (!f2.a() || c2 == javassist.orgs.java_websocket.enums.c.a) {
            this.a(j2, f2, c2);
        } else {
            if (this.a != null) {
                this.a.e("Protocol error: Continuous frame sequence not completed.");
                throw new javassist.orgs.java_websocket.exceptions.c(1002, "Continuous frame sequence not completed.");
            }
            if (c2 == javassist.orgs.java_websocket.enums.c.b) {
                this.c(j2, f2);
            } else if (c2 == javassist.orgs.java_websocket.enums.c.c) {
                this.b(j2, f2);
            } else {
                this.a.e("non control or continious frame expected");
                throw new javassist.orgs.java_websocket.exceptions.c(1002, "non control or continious frame expected");
            }
        }
    }

    private void a(j j2, javassist.orgs.java_websocket.framing.f f2, javassist.orgs.java_websocket.enums.c c2) {
        if (c2 != javassist.orgs.java_websocket.enums.c.a) {
            this.a(f2);
        } else if (f2.a()) {
            this.d(j2, f2);
        } else if (this.a == null) {
            this.a.e("Protocol error: Continuous frame sequence was not started.");
            throw new javassist.orgs.java_websocket.exceptions.c(1002, "Continuous frame sequence was not started.");
        }
        if (c2 == javassist.orgs.java_websocket.enums.c.b && !javassist.orgs.java_websocket.util.d.a(f2.a())) {
            this.a.e("Protocol error: Payload is not UTF8");
            throw new javassist.orgs.java_websocket.exceptions.c(1007);
        }
        if (c2 == javassist.orgs.java_websocket.enums.c.a && this.a != null) {
            this.a(f2.a());
        }
    }

    private void b(j j2, javassist.orgs.java_websocket.framing.f f2) {
        try {
            j2.a().a((g)j2, f2.a());
        } catch (RuntimeException runtimeException) {
            this.a(j2, runtimeException);
        }
    }

    private void a(j j2, RuntimeException runtimeException) {
        this.a.e("Runtime exception during onWebsocketMessage", runtimeException);
        j2.a().a((g)j2, runtimeException);
    }

    private void c(j j2, javassist.orgs.java_websocket.framing.f f2) {
        try {
            j2.a().a((g)j2, javassist.orgs.java_websocket.util.d.a(f2.a()));
        } catch (RuntimeException runtimeException) {
            this.a(j2, runtimeException);
        }
    }

    private void d(j j2, javassist.orgs.java_websocket.framing.f f2) {
        if (this.a == null) {
            this.a.a("Protocol error: Previous continuous frame sequence not completed.");
            throw new javassist.orgs.java_websocket.exceptions.c(1002, "Continuous frame sequence was not started.");
        }
        this.a(f2.a());
        this.c();
        if (this.a.a() == javassist.orgs.java_websocket.enums.c.b) {
            ((javassist.orgs.java_websocket.framing.g)this.a).a(this.a());
            ((javassist.orgs.java_websocket.framing.g)this.a).a();
            try {
                j2.a().a((g)j2, javassist.orgs.java_websocket.util.d.a(this.a.a()));
            } catch (RuntimeException runtimeException) {
                this.a(j2, runtimeException);
            }
        } else if (this.a.a() == javassist.orgs.java_websocket.enums.c.c) {
            ((javassist.orgs.java_websocket.framing.g)this.a).a(this.a());
            ((javassist.orgs.java_websocket.framing.g)this.a).a();
            try {
                j2.a().a((g)j2, this.a.a());
            } catch (RuntimeException runtimeException) {
                this.a(j2, runtimeException);
            }
        }
        this.a = null;
        this.b();
    }

    private void a(javassist.orgs.java_websocket.framing.f f2) {
        if (this.a != null) {
            this.a.a("Protocol error: Previous continuous frame sequence not completed.");
            throw new javassist.orgs.java_websocket.exceptions.c(1002, "Previous continuous frame sequence not completed.");
        }
        this.a = f2;
        this.a(f2.a());
        this.c();
    }

    private void e(j j2, javassist.orgs.java_websocket.framing.f f2) {
        int n2 = 1005;
        String string = "";
        if (f2 instanceof javassist.orgs.java_websocket.framing.b) {
            javassist.orgs.java_websocket.framing.b b2 = (javassist.orgs.java_websocket.framing.b)f2;
            n2 = b2.a();
            string = b2.a();
        }
        if (j2.a() == javassist.orgs.java_websocket.enums.d.c) {
            j2.b(n2, string, true);
        } else if (this.a() == javassist.orgs.java_websocket.enums.a.c) {
            j2.a(n2, string, true);
        } else {
            j2.c(n2, string, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void b() {
        String string = this.c;
        synchronized (string) {
            this.c.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(ByteBuffer byteBuffer) {
        String string = this.c;
        synchronized (string) {
            this.c.add(byteBuffer);
        }
    }

    private void c() {
        long l2 = this.a();
        if (l2 > (long)this.a) {
            this.b();
            this.a.a("Payload limit reached. Allowed: {} Current: {}", (Object)this.a, (Object)l2);
            throw new javassist.orgs.java_websocket.exceptions.g(this.a);
        }
    }

    @Override
    public javassist.orgs.java_websocket.enums.a a() {
        return javassist.orgs.java_websocket.enums.a.c;
    }

    @Override
    public String toString() {
        String string = super.toString();
        if (this.a() != null) {
            string = String.valueOf(string) + " extension: " + this.a().toString();
        }
        if (this.a() != null) {
            string = String.valueOf(string) + " protocol: " + this.a().toString();
        }
        string = String.valueOf(string) + " max frame size: " + this.a;
        return string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        b b2 = (b)object;
        if (this.a != b2.a()) {
            return false;
        }
        if (this.a != null ? !this.a.equals(b2.a()) : b2.a() != null) {
            return false;
        }
        return this.a != null ? this.a.equals(b2.a()) : b2.a() == null;
    }

    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        n2 = 31 * n2 + (this.a != null ? this.a.hashCode() : 0);
        n2 = 31 * n2 + (this.a ^ this.a >>> 32);
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ByteBuffer a() {
        ByteBuffer byteBuffer;
        long l2 = 0L;
        String string = this.c;
        synchronized (string) {
            ByteBuffer byteBuffer2;
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                byteBuffer2 = (ByteBuffer)iterator.next();
                l2 += (long)byteBuffer2.limit();
            }
            this.c();
            byteBuffer = ByteBuffer.allocate((int)l2);
            iterator = this.c.iterator();
            while (iterator.hasNext()) {
                byteBuffer2 = (ByteBuffer)iterator.next();
                byteBuffer.put(byteBuffer2);
            }
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private long a() {
        long l2 = 0L;
        String string = this.c;
        synchronized (string) {
            Iterator iterator = this.c.iterator();
            while (iterator.hasNext()) {
                ByteBuffer byteBuffer = (ByteBuffer)iterator.next();
                l2 += (long)byteBuffer.limit();
            }
        }
        return l2;
    }
}

