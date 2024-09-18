/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.framing;

import java.nio.ByteBuffer;
import javassist.orgs.java_websocket.enums.c;
import javassist.orgs.java_websocket.exceptions.e;
import javassist.orgs.java_websocket.framing.d;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
extends d {
    public static final int a = 1000;
    public static final int b = 1001;
    public static final int c = 1002;
    public static final int d = 1003;
    public static final int e = 1005;
    public static final int f = 1006;
    public static final int g = 1007;
    public static final int h = 1008;
    public static final int i = 1009;
    public static final int j = 1010;
    public static final int k = 1011;
    public static final int l = 1012;
    public static final int m = 1013;
    public static final int n = 1014;
    public static final int o = 1015;
    public static final int p = -1;
    public static final int q = -2;
    public static final int r = -3;
    private int s;
    private String a;

    public b() {
        super(javassist.orgs.java_websocket.enums.c.f);
        this.a("");
        this.a(1000);
    }

    public void a(int n2) {
        this.s = n2;
        if (n2 == 1015) {
            this.s = 1005;
            this.a = "";
        }
        this.b();
    }

    public void a(String string) {
        if (string == null) {
            string = "";
        }
        this.a = string;
        this.b();
    }

    public int a() {
        return this.s;
    }

    public String a() {
        return this.a;
    }

    @Override
    public String toString() {
        return String.valueOf(super.toString()) + "code: " + this.s;
    }

    @Override
    public void a() {
        super.a();
        if (this.s == 1007 && this.a.isEmpty()) {
            throw new javassist.orgs.java_websocket.exceptions.c(1007, "Received text is no valid utf8 string!");
        }
        if (this.s == 1005 && this.a.length() > 0) {
            throw new javassist.orgs.java_websocket.exceptions.c(1002, "A close frame must have a closecode if it has a reason");
        }
        if (this.s > 1015 && this.s < 3000) {
            throw new javassist.orgs.java_websocket.exceptions.c(1002, "Trying to send an illegal close code!");
        }
        if (this.s == 1006 || this.s == 1015 || this.s == 1005 || this.s > 4999 || this.s < 1000 || this.s == 1004) {
            throw new e("closecode must not be sent over the wire: " + this.s);
        }
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        this.s = 1005;
        this.a = "";
        byteBuffer.mark();
        if (byteBuffer.remaining() == 0) {
            this.s = 1000;
        } else if (byteBuffer.remaining() == 1) {
            this.s = 1002;
        } else {
            if (byteBuffer.remaining() >= 2) {
                ByteBuffer byteBuffer2 = ByteBuffer.allocate(4);
                byteBuffer2.position(2);
                byteBuffer2.putShort(byteBuffer.getShort());
                byteBuffer2.position(0);
                this.s = byteBuffer2.getInt();
            }
            byteBuffer.reset();
            try {
                int n2 = byteBuffer.position();
                this.a(byteBuffer, n2);
            } catch (javassist.orgs.java_websocket.exceptions.c c2) {
                this.s = 1007;
                this.a = null;
            }
        }
    }

    private void a(ByteBuffer byteBuffer, int n2) {
        try {
            try {
                byteBuffer.position(byteBuffer.position() + 2);
                this.a = javassist.orgs.java_websocket.util.d.a(byteBuffer);
            } catch (IllegalArgumentException illegalArgumentException) {
                throw new javassist.orgs.java_websocket.exceptions.c(1007);
            }
        } finally {
            byteBuffer.position(n2);
        }
    }

    private void b() {
        byte[] byArray = javassist.orgs.java_websocket.util.d.a(this.a);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.putInt(this.s);
        byteBuffer.position(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2 + byArray.length);
        byteBuffer2.put(byteBuffer);
        byteBuffer2.put(byArray);
        byteBuffer2.rewind();
        super.a(byteBuffer2);
    }

    @Override
    public ByteBuffer a() {
        if (this.s == 1005) {
            return javassist.orgs.java_websocket.util.c.a();
        }
        return super.a();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        b b2 = (b)object;
        if (this.s != b2.s) {
            return false;
        }
        return this.a != null ? this.a.equals(b2.a) : b2.a == null;
    }

    @Override
    public int hashCode() {
        int n2 = super.hashCode();
        n2 = 31 * n2 + this.s;
        n2 = 31 * n2 + (this.a != null ? this.a.hashCode() : 0);
        return n2;
    }
}

