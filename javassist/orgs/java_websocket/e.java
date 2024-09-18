/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javassist.orgs.java_websocket.interfaces.a;
import javassist.orgs.java_websocket.m;
import javassist.orgs.slf4j.c;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLSession;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e
implements ByteChannel,
a,
m {
    protected static ByteBuffer a = ByteBuffer.allocate(0);
    private final c a;
    protected ExecutorService a;
    protected List<Future<?>> a;
    protected ByteBuffer b;
    protected ByteBuffer c;
    protected ByteBuffer d;
    protected SocketChannel a;
    protected SelectionKey a;
    protected SSLEngine a;
    protected SSLEngineResult a;
    protected SSLEngineResult b;
    protected int a;
    private byte[] a = null;

    public e(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) {
        if (socketChannel == null || sSLEngine == null || executorService == null) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.a = socketChannel;
        this.a = sSLEngine;
        this.a = executorService;
        this.a = this.b = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, sSLEngine.getHandshakeStatus(), 0, 0);
        this.a = new ArrayList(3);
        if (selectionKey != null) {
            selectionKey.interestOps(selectionKey.interestOps() | 4);
            this.a = selectionKey;
        }
        this.a(sSLEngine.getSession());
        this.a.write(this.a(a));
        this.c();
    }

    private void a(Future<?> future) {
        try {
            while (true) {
                try {
                    future.get();
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    continue;
                }
                break;
            }
        } catch (ExecutionException executionException) {
            throw new RuntimeException(executionException);
        }
    }

    private synchronized void c() {
        if (this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            return;
        }
        if (!this.a.isEmpty()) {
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                Future future = (Future)iterator.next();
                if (future.isDone()) {
                    iterator.remove();
                    continue;
                }
                if (this.c()) {
                    this.a(future);
                }
                return;
            }
        }
        if (this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            if (!this.c() || this.a.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                this.d.compact();
                int n2 = this.a.read(this.d);
                if (n2 == -1) {
                    throw new IOException("connection closed unexpectedly by peer");
                }
                this.d.flip();
            }
            this.b.compact();
            this.a();
            if (this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                this.a(this.a.getSession());
                return;
            }
        }
        this.b();
        if (this.a.isEmpty() || this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            this.a.write(this.a(a));
            if (this.b.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                this.a(this.a.getSession());
                return;
            }
        }
        assert (this.a.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
        this.a = 1;
    }

    private synchronized ByteBuffer a(ByteBuffer byteBuffer) {
        this.c.compact();
        this.b = this.a.wrap(byteBuffer, this.c);
        this.c.flip();
        return this.c;
    }

    private synchronized ByteBuffer a() {
        int n2;
        if (this.a.getStatus() == SSLEngineResult.Status.CLOSED && this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            try {
                this.close();
            } catch (IOException iOException) {
                // empty catch block
            }
        }
        do {
            n2 = this.b.remaining();
            this.a = this.a.unwrap(this.d, this.b);
        } while (this.a.getStatus() == SSLEngineResult.Status.OK && (n2 != this.b.remaining() || this.a.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP));
        this.b.flip();
        return this.b;
    }

    protected void b() {
        Runnable runnable;
        while ((runnable = this.a.getDelegatedTask()) != null) {
            this.a.add(this.a.submit(runnable));
        }
    }

    protected void a(SSLSession sSLSession) {
        this.d();
        int n2 = sSLSession.getPacketBufferSize();
        int n3 = Math.max(sSLSession.getApplicationBufferSize(), n2);
        if (this.b == null) {
            this.b = ByteBuffer.allocate(n3);
            this.c = ByteBuffer.allocate(n2);
            this.d = ByteBuffer.allocate(n2);
        } else {
            if (this.b.capacity() != n3) {
                this.b = ByteBuffer.allocate(n3);
            }
            if (this.c.capacity() != n2) {
                this.c = ByteBuffer.allocate(n2);
            }
            if (this.d.capacity() != n2) {
                this.d = ByteBuffer.allocate(n2);
            }
        }
        if (this.b.remaining() != 0 && this.a.a()) {
            this.a.a(new String(this.b.array(), this.b.position(), this.b.remaining()));
        }
        this.b.rewind();
        this.b.flip();
        if (this.d.remaining() != 0 && this.a.a()) {
            this.a.a(new String(this.d.array(), this.d.position(), this.d.remaining()));
        }
        this.d.rewind();
        this.d.flip();
        this.c.rewind();
        this.c.flip();
        ++this.a;
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        if (!this.g()) {
            this.c();
            return 0;
        }
        int n2 = this.a.write(this.a(byteBuffer));
        if (this.b.getStatus() == SSLEngineResult.Status.CLOSED) {
            throw new EOFException("Connection is closed");
        }
        return n2;
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        int n2;
        this.e();
        do {
            int n3;
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            if (!this.g()) {
                if (this.c()) {
                    while (!this.g()) {
                        this.c();
                    }
                } else {
                    this.c();
                    if (!this.g()) {
                        return 0;
                    }
                }
            }
            if ((n3 = this.b(byteBuffer)) != 0) {
                return n3;
            }
            assert (this.b.position() == 0);
            this.b.clear();
            if (!this.d.hasRemaining()) {
                this.d.clear();
            } else {
                this.d.compact();
            }
            if ((this.c() || this.a.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) && this.a.read(this.d) == -1) {
                return -1;
            }
            this.d.flip();
            this.a();
            n2 = this.a(this.b, byteBuffer);
        } while (n2 == 0 && this.c());
        return n2;
    }

    private int b(ByteBuffer byteBuffer) {
        if (this.b.hasRemaining()) {
            return this.a(this.b, byteBuffer);
        }
        if (!this.b.hasRemaining()) {
            this.b.clear();
        }
        this.e();
        if (this.d.hasRemaining()) {
            this.a();
            int n2 = this.a(this.b, byteBuffer);
            if (this.a.getStatus() == SSLEngineResult.Status.CLOSED) {
                return -1;
            }
            if (n2 > 0) {
                return n2;
            }
        }
        return 0;
    }

    public boolean d() {
        return this.a.isConnected();
    }

    @Override
    public void close() {
        this.a.closeOutbound();
        this.a.getSession().invalidate();
        if (this.a.isOpen()) {
            this.a.write(this.a(a));
        }
        this.a.close();
    }

    private boolean g() {
        SSLEngineResult.HandshakeStatus handshakeStatus = this.a.getHandshakeStatus();
        return handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    public SelectableChannel a(boolean bl2) {
        return this.a.configureBlocking(bl2);
    }

    public boolean a(SocketAddress socketAddress) {
        return this.a.connect(socketAddress);
    }

    public boolean e() {
        return this.a.finishConnect();
    }

    public Socket a() {
        return this.a.socket();
    }

    public boolean f() {
        return this.a.isInboundDone();
    }

    @Override
    public boolean isOpen() {
        return this.a.isOpen();
    }

    @Override
    public boolean a() {
        return this.c.hasRemaining() || !this.g();
    }

    @Override
    public void a() {
        this.write(this.c);
    }

    @Override
    public boolean b() {
        return this.a != null || this.b.hasRemaining() || this.d.hasRemaining() && this.a.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW && this.a.getStatus() != SSLEngineResult.Status.CLOSED;
    }

    @Override
    public int a(ByteBuffer byteBuffer) {
        return this.b(byteBuffer);
    }

    private int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int n2;
        int n3 = byteBuffer.remaining();
        if (n3 > (n2 = byteBuffer2.remaining())) {
            int n4 = Math.min(n3, n2);
            int n5 = 0;
            while (n5 < n4) {
                byteBuffer2.put(byteBuffer.get());
                ++n5;
            }
            return n4;
        }
        byteBuffer2.put(byteBuffer);
        return n3;
    }

    @Override
    public boolean c() {
        return this.a.isBlocking();
    }

    @Override
    public SSLEngine a() {
        return this.a;
    }

    private void d() {
        if (this.d != null && this.d.remaining() > 0) {
            int n2 = this.d.remaining();
            this.a = new byte[n2];
            this.d.get(this.a);
        }
    }

    private void e() {
        if (this.a != null) {
            this.d.clear();
            this.d.put(this.a);
            this.d.flip();
            this.a = null;
        }
    }
}

