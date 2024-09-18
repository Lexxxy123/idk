/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javassist.orgs.java_websocket.drafts.b;
import javassist.orgs.java_websocket.enums.a;
import javassist.orgs.java_websocket.enums.c;
import javassist.orgs.java_websocket.enums.d;
import javassist.orgs.java_websocket.enums.e;
import javassist.orgs.java_websocket.exceptions.f;
import javassist.orgs.java_websocket.exceptions.g;
import javassist.orgs.java_websocket.exceptions.i;
import javassist.orgs.java_websocket.framing.h;
import javassist.orgs.java_websocket.k;
import javax.net.ssl.SSLSession;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class j
implements javassist.orgs.java_websocket.g {
    public static final int a = 80;
    public static final int b = 443;
    public static final int c = 16384;
    private final javassist.orgs.slf4j.c a;
    public final BlockingQueue<ByteBuffer> a;
    public final BlockingQueue<ByteBuffer> b;
    private final k a;
    private SelectionKey a;
    private ByteChannel a;
    private javassist.orgs.java_websocket.server.f a;
    private boolean b;
    private volatile d a;
    private List<javassist.orgs.java_websocket.drafts.a> a;
    private javassist.orgs.java_websocket.drafts.a a;
    private e a;
    private ByteBuffer a;
    private javassist.orgs.java_websocket.handshake.a a;
    private String a;
    private Integer a;
    private Boolean a;
    private String b;
    private long a;
    private final Object a = new Object();
    private Object b = null;

    public j(k k2, List<javassist.orgs.java_websocket.drafts.a> list) {
        this(k2, (javassist.orgs.java_websocket.drafts.a)null);
        this.a = e.b;
        if (list == null || list.isEmpty()) {
            this.a = (int)new ArrayList();
            this.a.add(new b());
        } else {
            this.a = (int)list;
        }
    }

    public j(k k2, javassist.orgs.java_websocket.drafts.a a2) {
        if (k2 == null || a2 == null && this.a == e.b) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.a = (int)new LinkedBlockingQueue();
        this.b = (int)new LinkedBlockingQueue();
        this.a = k2;
        this.a = e.a;
        if (a2 != null) {
            this.a = a2.a();
        }
    }

    public void b(ByteBuffer byteBuffer) {
        assert (byteBuffer.hasRemaining());
        this.a.a("process({}): ({})", (Object)byteBuffer.remaining(), (Object)(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining())));
        if (this.a != d.a) {
            if (this.a == d.b) {
                this.c(byteBuffer);
            }
        } else if (this.a(byteBuffer) && !this.c() && !this.e()) {
            assert (this.a.hasRemaining() != byteBuffer.hasRemaining() || !byteBuffer.hasRemaining());
            if (byteBuffer.hasRemaining()) {
                this.c(byteBuffer);
            } else if (this.a.hasRemaining()) {
                this.c(this.a);
            }
        }
    }

    /*
     * Exception decompiling
     */
    private boolean a(ByteBuffer var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 24[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:538)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         *     at async.DecompilerRunnable.cfrDecompilation(DecompilerRunnable.java:348)
         *     at async.DecompilerRunnable.call(DecompilerRunnable.java:309)
         *     at async.DecompilerRunnable.call(DecompilerRunnable.java:31)
         *     at java.util.concurrent.FutureTask.run(FutureTask.java:266)
         *     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
         *     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
         *     at java.lang.Thread.run(Thread.java:750)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void c(ByteBuffer byteBuffer) {
        try {
            List<javassist.orgs.java_websocket.framing.f> list = this.a.a(byteBuffer);
            for (javassist.orgs.java_websocket.framing.f f2 : list) {
                this.a.a("matched frame: {}", (Object)f2);
                this.a.a(this, f2);
            }
        } catch (g g2) {
            if (g2.b() == Integer.MAX_VALUE) {
                this.a.e("Closing due to invalid size of frame", g2);
                this.a.a((javassist.orgs.java_websocket.g)this, g2);
            }
            this.a(g2);
        } catch (javassist.orgs.java_websocket.exceptions.c c2) {
            this.a.e("Closing due to invalid data in frame", c2);
            this.a.a((javassist.orgs.java_websocket.g)this, c2);
            this.a(c2);
        }
    }

    private void b(javassist.orgs.java_websocket.exceptions.c c2) {
        this.d(this.a(404));
        this.c(c2.a(), c2.getMessage(), false);
    }

    private void a(RuntimeException runtimeException) {
        this.d(this.a(500));
        this.c(-1, runtimeException.getMessage(), false);
    }

    private ByteBuffer a(int n2) {
        String string;
        switch (n2) {
            case 404: {
                string = "404 WebSocket Upgrade Failure";
                break;
            }
            default: {
                string = "500 Internal Server Error";
            }
        }
        return ByteBuffer.wrap(javassist.orgs.java_websocket.util.d.b("HTTP/1.1 " + string + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (48 + string.length()) + "\r\n\r\n<html><head></head><body><h1>" + string + "</h1></body></html>"));
    }

    public synchronized void a(int n2, String string, boolean bl2) {
        if (this.a != d.c && this.a != d.d) {
            if (this.a == d.b) {
                if (n2 == 1006) {
                    assert (!bl2);
                    this.a = d.c;
                    this.c(n2, string, false);
                    return;
                }
                if (this.a.a() != javassist.orgs.java_websocket.enums.a.a) {
                    try {
                        if (!bl2) {
                            try {
                                this.a.a((javassist.orgs.java_websocket.g)this, n2, string);
                            } catch (RuntimeException runtimeException) {
                                this.a.a((javassist.orgs.java_websocket.g)this, runtimeException);
                            }
                        }
                        if (this.b()) {
                            javassist.orgs.java_websocket.framing.b b2 = new javassist.orgs.java_websocket.framing.b();
                            b2.a(string);
                            b2.a(n2);
                            b2.a();
                            this.a(b2);
                        }
                    } catch (javassist.orgs.java_websocket.exceptions.c c2) {
                        this.a.e("generated frame is invalid", c2);
                        this.a.a((javassist.orgs.java_websocket.g)this, c2);
                        this.c(1006, "generated frame is invalid", false);
                    }
                }
                this.c(n2, string, bl2);
            } else if (n2 == -3) {
                assert (bl2);
                this.c(-3, string, true);
            } else if (n2 == 1002) {
                this.c(n2, string, bl2);
            } else {
                this.c(-1, string, false);
            }
            this.a = d.c;
            this.a = null;
            return;
        }
    }

    @Override
    public void a(int n2, String string) {
        this.a(n2, string, false);
    }

    public synchronized void b(int n2, String string, boolean bl2) {
        if (this.a == d.d) {
            return;
        }
        if (this.a == d.b && n2 == 1006) {
            this.a = d.c;
        }
        if (this.a != null) {
            this.a.cancel();
        }
        if (this.a != null) {
            try {
                this.a.close();
            } catch (IOException iOException) {
                if (iOException.getMessage() != null && iOException.getMessage().equals("Broken pipe")) {
                    this.a.a("Caught IOException: Broken pipe during closeConnection()", iOException);
                }
                this.a.e("Exception during channel.close()", iOException);
                this.a.a((javassist.orgs.java_websocket.g)this, iOException);
            }
        }
        try {
            this.a.a(this, n2, string, bl2);
        } catch (RuntimeException runtimeException) {
            this.a.a((javassist.orgs.java_websocket.g)this, runtimeException);
        }
        if (this.a != null) {
            this.a.a();
        }
        this.a = null;
        this.a = d.d;
    }

    protected void a(int n2, boolean bl2) {
        this.b(n2, "", bl2);
    }

    public void c() {
        if (this.a == null) {
            throw new IllegalStateException("this method must be used in conjunction with flushAndClose");
        }
        this.b(this.a, this.a, this.a);
    }

    @Override
    public void b(int n2, String string) {
        this.b(n2, string, false);
    }

    public synchronized void c(int n2, String string, boolean bl2) {
        if (this.b) {
            return;
        }
        this.a = n2;
        this.a = string;
        this.a = bl2;
        this.b = true;
        this.a.a(this);
        try {
            this.a.b(this, n2, string, bl2);
        } catch (RuntimeException runtimeException) {
            this.a.e("Exception in onWebsocketClosing", runtimeException);
            this.a.a((javassist.orgs.java_websocket.g)this, runtimeException);
        }
        if (this.a != null) {
            this.a.a();
        }
        this.a = null;
    }

    public void d() {
        if (this.a == d.a) {
            this.a(-1, true);
        } else if (this.b) {
            this.b(this.a, this.a, this.a);
        } else if (this.a.a() == javassist.orgs.java_websocket.enums.a.a) {
            this.a(1000, true);
        } else if (this.a.a() == javassist.orgs.java_websocket.enums.a.b) {
            if (this.a == e.b) {
                this.a(1006, true);
            } else {
                this.a(1000, true);
            }
        } else {
            this.a(1006, true);
        }
    }

    @Override
    public void a(int n2) {
        this.a(n2, "", false);
    }

    public void a(javassist.orgs.java_websocket.exceptions.c c2) {
        this.a(c2.a(), c2.getMessage(), false);
    }

    @Override
    public void a(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        this.b(this.a.a(string, this.a == e.a));
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        this.b(this.a.a(byteBuffer, this.a == e.a));
    }

    @Override
    public void a(byte[] byArray) {
        this.a(ByteBuffer.wrap(byArray));
    }

    private void b(Collection<javassist.orgs.java_websocket.framing.f> collection) {
        if (!this.b()) {
            throw new i();
        }
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<ByteBuffer> arrayList = new ArrayList<ByteBuffer>();
        for (javassist.orgs.java_websocket.framing.f f2 : collection) {
            this.a.a("send frame: {}", (Object)f2);
            arrayList.add(this.a.a(f2));
        }
        this.a((Object)arrayList);
    }

    @Override
    public void a(c c2, ByteBuffer byteBuffer, boolean bl2) {
        this.b(this.a.a(c2, byteBuffer, bl2));
    }

    @Override
    public void a(Collection<javassist.orgs.java_websocket.framing.f> collection) {
        this.b(collection);
    }

    @Override
    public void a(javassist.orgs.java_websocket.framing.f f2) {
        this.b(Collections.singletonList(f2));
    }

    @Override
    public void b() {
        h h2 = this.a.a(this);
        if (h2 == null) {
            throw new NullPointerException("onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        }
        this.a(h2);
    }

    @Override
    public boolean a() {
        return !this.a.isEmpty();
    }

    public void a(javassist.orgs.java_websocket.handshake.b b2) {
        this.a = this.a.a(b2);
        this.b = b2.a();
        assert (this.b != null);
        try {
            this.a.a((javassist.orgs.java_websocket.g)this, this.a);
        } catch (javassist.orgs.java_websocket.exceptions.c c2) {
            throw new f("Handshake data rejected by client.");
        } catch (RuntimeException runtimeException) {
            this.a.e("Exception in startHandshake", runtimeException);
            this.a.a((javassist.orgs.java_websocket.g)this, runtimeException);
            throw new f("rejected because of " + runtimeException);
        }
        this.a((Object)this.a.a((javassist.orgs.java_websocket.handshake.f)this.a));
    }

    private void d(ByteBuffer byteBuffer) {
        this.a.a("write({}): {}", (Object)byteBuffer.remaining(), (Object)(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array())));
        this.a.add(byteBuffer);
        this.a.a(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(List<ByteBuffer> list) {
        Object object = this.a;
        synchronized (object) {
            for (ByteBuffer byteBuffer : list) {
                this.d(byteBuffer);
            }
        }
    }

    private void a(javassist.orgs.java_websocket.handshake.f f2) {
        this.a.a("open using draft: {}", (Object)this.a);
        this.a = d.b;
        try {
            this.a.a((javassist.orgs.java_websocket.g)this, f2);
        } catch (RuntimeException runtimeException) {
            this.a.a((javassist.orgs.java_websocket.g)this, runtimeException);
        }
    }

    @Override
    public boolean b() {
        return this.a == d.b;
    }

    @Override
    public boolean c() {
        return this.a == d.c;
    }

    @Override
    public boolean d() {
        return this.b;
    }

    @Override
    public boolean e() {
        return this.a == d.d;
    }

    @Override
    public d a() {
        return this.a;
    }

    public void a(SelectionKey selectionKey) {
        this.a = selectionKey;
    }

    public SelectionKey a() {
        return this.a;
    }

    public String toString() {
        return super.toString();
    }

    @Override
    public InetSocketAddress a() {
        return this.a.b(this);
    }

    @Override
    public InetSocketAddress b() {
        return this.a.a(this);
    }

    @Override
    public javassist.orgs.java_websocket.drafts.a a() {
        return this.a;
    }

    @Override
    public void a() {
        this.a(1000);
    }

    @Override
    public String a() {
        return this.b;
    }

    long a() {
        return this.a;
    }

    public void e() {
        this.a = System.nanoTime();
    }

    public k a() {
        return this.a;
    }

    @Override
    public <T> T a() {
        return (T)this.b;
    }

    @Override
    public boolean f() {
        return this.a instanceof javassist.orgs.java_websocket.interfaces.a;
    }

    @Override
    public SSLSession a() {
        if (!this.f()) {
            throw new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
        }
        return ((javassist.orgs.java_websocket.interfaces.a)((Object)this.a)).a().getSession();
    }

    @Override
    public <T> void a(T t2) {
        this.b = t2;
    }

    public ByteChannel a() {
        return this.a;
    }

    public void a(ByteChannel byteChannel) {
        this.a = byteChannel;
    }

    public javassist.orgs.java_websocket.server.f a() {
        return this.a;
    }

    public void a(javassist.orgs.java_websocket.server.f f2) {
        this.a = f2;
    }
}

