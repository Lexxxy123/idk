/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import javassist.orgs.java_websocket.interfaces.a;
import javassist.orgs.java_websocket.m;
import javassist.orgs.java_websocket.util.c;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class d
implements ByteChannel,
a,
m {
    private final javassist.orgs.slf4j.c a;
    private final SocketChannel a;
    private final SSLEngine a;
    private ByteBuffer a;
    private ByteBuffer b;
    private ByteBuffer c;
    private ByteBuffer d;
    private ExecutorService a = javassist.orgs.slf4j.d.a(d.class);
    private static /* synthetic */ int[] a;
    private static /* synthetic */ int[] b;

    public d(SocketChannel socketChannel, SSLEngine sSLEngine, ExecutorService executorService, SelectionKey selectionKey) {
        if (socketChannel == null || sSLEngine == null || this.a == executorService) {
            throw new IllegalArgumentException("parameter must not be null");
        }
        this.a = socketChannel;
        this.a = sSLEngine;
        this.a = executorService;
        this.b = ByteBuffer.allocate(this.a.getSession().getPacketBufferSize());
        this.d = ByteBuffer.allocate(this.a.getSession().getPacketBufferSize());
        this.a.beginHandshake();
        if (this.d()) {
            if (selectionKey != null) {
                selectionKey.interestOps(selectionKey.interestOps() | 4);
            }
        } else {
            try {
                this.a.close();
            } catch (IOException iOException) {
                this.a.e("Exception during the closing of the channel", iOException);
            }
        }
    }

    @Override
    public synchronized int read(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.c.hasRemaining()) {
            this.c.flip();
            return javassist.orgs.java_websocket.util.c.a(this.c, byteBuffer);
        }
        this.d.compact();
        int n2 = this.a.read(this.d);
        if (n2 > 0 || this.d.hasRemaining()) {
            this.d.flip();
            if (this.d.hasRemaining()) {
                SSLEngineResult sSLEngineResult;
                this.c.compact();
                try {
                    sSLEngineResult = this.a.unwrap(this.d, this.c);
                } catch (SSLException sSLException) {
                    this.a.e("SSLExcpetion during unwrap", sSLException);
                    throw sSLException;
                }
                switch (javassist.orgs.java_websocket.d.a()[sSLEngineResult.getStatus().ordinal()]) {
                    case 3: {
                        this.c.flip();
                        return javassist.orgs.java_websocket.util.c.a(this.c, byteBuffer);
                    }
                    case 1: {
                        this.c.flip();
                        return javassist.orgs.java_websocket.util.c.a(this.c, byteBuffer);
                    }
                    case 2: {
                        this.c = this.b(this.c);
                        return this.read(byteBuffer);
                    }
                    case 4: {
                        this.b();
                        byteBuffer.clear();
                        return -1;
                    }
                }
                throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)sSLEngineResult.getStatus()));
            }
        } else if (n2 < 0) {
            this.c();
        }
        javassist.orgs.java_websocket.util.c.a(this.c, byteBuffer);
        return n2;
    }

    @Override
    public synchronized int write(ByteBuffer byteBuffer) {
        int n2 = 0;
        block6: while (byteBuffer.hasRemaining()) {
            this.b.clear();
            SSLEngineResult sSLEngineResult = this.a.wrap(byteBuffer, this.b);
            switch (javassist.orgs.java_websocket.d.a()[sSLEngineResult.getStatus().ordinal()]) {
                case 3: {
                    this.b.flip();
                    while (this.b.hasRemaining()) {
                        n2 += this.a.write(this.b);
                    }
                    continue block6;
                }
                case 2: {
                    this.b = this.a(this.b);
                    break;
                }
                case 1: {
                    throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
                }
                case 4: {
                    this.b();
                    return 0;
                }
                default: {
                    throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)sSLEngineResult.getStatus()));
                }
            }
        }
        return n2;
    }

    private boolean d() {
        int n2 = this.a.getSession().getApplicationBufferSize();
        this.a = ByteBuffer.allocate(n2);
        this.c = ByteBuffer.allocate(n2);
        this.b.clear();
        this.d.clear();
        SSLEngineResult.HandshakeStatus handshakeStatus = this.a.getHandshakeStatus();
        boolean bl2 = false;
        block27: while (!bl2) {
            block4 : switch (javassist.orgs.java_websocket.d.b()[handshakeStatus.ordinal()]) {
                case 2: {
                    boolean bl3 = bl2 = !this.d.hasRemaining();
                    if (bl2) {
                        return true;
                    }
                    this.a.write(this.d);
                    break;
                }
                case 5: {
                    SSLEngineResult sSLEngineResult;
                    if (this.a.read(this.d) < 0) {
                        if (this.a.isInboundDone() && this.a.isOutboundDone()) {
                            return false;
                        }
                        try {
                            this.a.closeInbound();
                        } catch (SSLException sSLException) {
                            // empty catch block
                        }
                        this.a.closeOutbound();
                        handshakeStatus = this.a.getHandshakeStatus();
                        break;
                    }
                    this.d.flip();
                    try {
                        sSLEngineResult = this.a.unwrap(this.d, this.c);
                        this.d.compact();
                        handshakeStatus = sSLEngineResult.getHandshakeStatus();
                    } catch (SSLException sSLException) {
                        this.a.closeOutbound();
                        handshakeStatus = this.a.getHandshakeStatus();
                        break;
                    }
                    switch (javassist.orgs.java_websocket.d.a()[sSLEngineResult.getStatus().ordinal()]) {
                        case 3: {
                            break block4;
                        }
                        case 2: {
                            this.c = this.b(this.c);
                            break block4;
                        }
                        case 1: {
                            this.d = this.c(this.d);
                            break block4;
                        }
                        case 4: {
                            if (this.a.isOutboundDone()) {
                                return false;
                            }
                            this.a.closeOutbound();
                            handshakeStatus = this.a.getHandshakeStatus();
                            break block4;
                        }
                    }
                    throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)sSLEngineResult.getStatus()));
                }
                case 4: {
                    SSLEngineResult sSLEngineResult;
                    this.b.clear();
                    try {
                        sSLEngineResult = this.a.wrap(this.a, this.b);
                        handshakeStatus = sSLEngineResult.getHandshakeStatus();
                    } catch (SSLException sSLException) {
                        this.a.closeOutbound();
                        handshakeStatus = this.a.getHandshakeStatus();
                        break;
                    }
                    switch (javassist.orgs.java_websocket.d.a()[sSLEngineResult.getStatus().ordinal()]) {
                        case 3: {
                            this.b.flip();
                            while (this.b.hasRemaining()) {
                                this.a.write(this.b);
                            }
                            continue block27;
                        }
                        case 2: {
                            this.b = this.a(this.b);
                            break block4;
                        }
                        case 1: {
                            throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
                        }
                        case 4: {
                            try {
                                this.b.flip();
                                while (this.b.hasRemaining()) {
                                    this.a.write(this.b);
                                }
                                this.d.clear();
                            } catch (Exception exception) {
                                handshakeStatus = this.a.getHandshakeStatus();
                            }
                            continue block27;
                        }
                        default: {
                            throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)sSLEngineResult.getStatus()));
                        }
                    }
                }
                case 3: {
                    Runnable runnable;
                    while ((runnable = this.a.getDelegatedTask()) != null) {
                        this.a.execute(runnable);
                    }
                    handshakeStatus = this.a.getHandshakeStatus();
                    break;
                }
                case 1: {
                    break;
                }
                default: {
                    throw new IllegalStateException("Invalid SSL status: " + (Object)((Object)handshakeStatus));
                }
            }
        }
        return true;
    }

    private ByteBuffer a(ByteBuffer byteBuffer) {
        return this.a(byteBuffer, this.a.getSession().getPacketBufferSize());
    }

    private ByteBuffer b(ByteBuffer byteBuffer) {
        return this.a(byteBuffer, this.a.getSession().getApplicationBufferSize());
    }

    private ByteBuffer a(ByteBuffer byteBuffer, int n2) {
        byteBuffer = n2 > byteBuffer.capacity() ? ByteBuffer.allocate(n2) : ByteBuffer.allocate(byteBuffer.capacity() * 2);
        return byteBuffer;
    }

    private ByteBuffer c(ByteBuffer byteBuffer) {
        if (this.a.getSession().getPacketBufferSize() < byteBuffer.limit()) {
            return byteBuffer;
        }
        ByteBuffer byteBuffer2 = this.a(byteBuffer);
        byteBuffer.flip();
        byteBuffer2.put(byteBuffer);
        return byteBuffer2;
    }

    private void b() {
        this.a.closeOutbound();
        try {
            this.d();
        } catch (IOException iOException) {
            // empty catch block
        }
        this.a.close();
    }

    private void c() {
        try {
            this.a.closeInbound();
        } catch (Exception exception) {
            this.a.e("This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
        }
        this.b();
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public void a() {
    }

    @Override
    public boolean b() {
        return this.d.hasRemaining() || this.c.hasRemaining();
    }

    @Override
    public int a(ByteBuffer byteBuffer) {
        return this.read(byteBuffer);
    }

    @Override
    public boolean c() {
        return this.a.isBlocking();
    }

    @Override
    public boolean isOpen() {
        return this.a.isOpen();
    }

    @Override
    public void close() {
        this.b();
    }

    @Override
    public SSLEngine a() {
        return this.a;
    }

    static /* synthetic */ int[] a() {
        if (a != null) {
            return a;
        }
        int[] nArray = new int[SSLEngineResult.Status.values().length];
        try {
            nArray[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 2;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 1;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[SSLEngineResult.Status.CLOSED.ordinal()] = 4;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[SSLEngineResult.Status.OK.ordinal()] = 3;
        } catch (NoSuchFieldError noSuchFieldError) {}
        a = nArray;
        return nArray;
    }

    static /* synthetic */ int[] b() {
        if (b != null) {
            return b;
        }
        int[] nArray = new int[SSLEngineResult.HandshakeStatus.values().length];
        try {
            nArray[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 5;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 1;
        } catch (NoSuchFieldError noSuchFieldError) {}
        b = nArray;
        return nArray;
    }
}

