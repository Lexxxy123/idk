/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.framing;

import java.nio.ByteBuffer;
import javassist.orgs.java_websocket.framing.a;
import javassist.orgs.java_websocket.framing.b;
import javassist.orgs.java_websocket.framing.c;
import javassist.orgs.java_websocket.framing.f;
import javassist.orgs.java_websocket.framing.h;
import javassist.orgs.java_websocket.framing.i;
import javassist.orgs.java_websocket.framing.j;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class g
implements f {
    private boolean a;
    private javassist.orgs.java_websocket.enums.c a;
    private ByteBuffer a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private static /* synthetic */ int[] a;

    public abstract void a();

    public g(javassist.orgs.java_websocket.enums.c c2) {
        this.a = c2;
        this.a = javassist.orgs.java_websocket.util.c.a();
        this.a = true;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
    }

    @Override
    public boolean b() {
        return this.c;
    }

    @Override
    public boolean c() {
        return this.d;
    }

    @Override
    public boolean d() {
        return this.e;
    }

    @Override
    public boolean a() {
        return this.a;
    }

    @Override
    public javassist.orgs.java_websocket.enums.c a() {
        return this.a;
    }

    @Override
    public boolean e() {
        return this.b;
    }

    @Override
    public ByteBuffer a() {
        return this.a;
    }

    @Override
    public void a(f f2) {
        ByteBuffer byteBuffer = f2.a();
        if (this.a == null) {
            this.a = ByteBuffer.allocate(byteBuffer.remaining());
            byteBuffer.mark();
            this.a.put(byteBuffer);
            byteBuffer.reset();
        } else {
            byteBuffer.mark();
            this.a.position(this.a.limit());
            this.a.limit(this.a.capacity());
            if (byteBuffer.remaining() > this.a.remaining()) {
                ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer.remaining() + this.a.capacity());
                this.a.flip();
                byteBuffer2.put(this.a);
                byteBuffer2.put(byteBuffer);
                this.a = byteBuffer2;
            } else {
                this.a.put(byteBuffer);
            }
            this.a.rewind();
            byteBuffer.reset();
        }
        this.a = f2.a();
    }

    public String toString() {
        return "Framedata{ optcode:" + (Object)((Object)this.a()) + ", fin:" + this.a() + ", rsv1:" + this.b() + ", rsv2:" + this.c() + ", rsv3:" + this.d() + ", payloadlength:[pos:" + this.a.position() + ", len:" + this.a.remaining() + "], payload:" + (this.a.remaining() > 1000 ? "(too big to display)" : new String(this.a.array())) + '}';
    }

    public void a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    public void a(boolean bl2) {
        this.a = bl2;
    }

    public void b(boolean bl2) {
        this.c = bl2;
    }

    public void c(boolean bl2) {
        this.d = bl2;
    }

    public void d(boolean bl2) {
        this.e = bl2;
    }

    public void e(boolean bl2) {
        this.b = bl2;
    }

    public static g a(javassist.orgs.java_websocket.enums.c c2) {
        if (c2 == null) {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        switch (g.a()[c2.ordinal()]) {
            case 4: {
                return new h();
            }
            case 5: {
                return new i();
            }
            case 2: {
                return new j();
            }
            case 3: {
                return new a();
            }
            case 6: {
                return new b();
            }
            case 1: {
                return new c();
            }
        }
        throw new IllegalArgumentException("Supplied opcode is invalid");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        g g2 = (g)object;
        if (this.a != g2.a) {
            return false;
        }
        if (this.b != g2.b) {
            return false;
        }
        if (this.c != g2.c) {
            return false;
        }
        if (this.d != g2.d) {
            return false;
        }
        if (this.e != g2.e) {
            return false;
        }
        if (this.a != g2.a) {
            return false;
        }
        return this.a != null ? this.a.equals(g2.a) : g2.a == null;
    }

    public int hashCode() {
        int n2 = this.a ? 1 : 0;
        n2 = 31 * n2 + this.a.hashCode();
        n2 = 31 * n2 + (this.a != null ? this.a.hashCode() : 0);
        n2 = 31 * n2 + (this.b ? 1 : 0);
        n2 = 31 * n2 + (this.c ? 1 : 0);
        n2 = 31 * n2 + (this.d ? 1 : 0);
        n2 = 31 * n2 + (this.e ? 1 : 0);
        return n2;
    }

    static /* synthetic */ int[] a() {
        if (a != null) {
            return a;
        }
        int[] nArray = new int[javassist.orgs.java_websocket.enums.c.values().length];
        try {
            nArray[javassist.orgs.java_websocket.enums.c.c.ordinal()] = 3;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.java_websocket.enums.c.f.ordinal()] = 6;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.java_websocket.enums.c.a.ordinal()] = 1;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.java_websocket.enums.c.d.ordinal()] = 4;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.java_websocket.enums.c.e.ordinal()] = 5;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.java_websocket.enums.c.b.ordinal()] = 2;
        } catch (NoSuchFieldError noSuchFieldError) {}
        a = nArray;
        return nArray;
    }
}

