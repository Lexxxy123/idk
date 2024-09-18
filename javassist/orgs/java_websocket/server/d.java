/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javassist.orgs.java_websocket.e;
import javassist.orgs.java_websocket.server.b;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

public class d
extends b {
    private final SSLParameters a;

    public d(SSLContext sSLContext, SSLParameters sSLParameters) {
        this(sSLContext, Executors.newSingleThreadScheduledExecutor(), sSLParameters);
    }

    public d(SSLContext sSLContext, ExecutorService executorService, SSLParameters sSLParameters) {
        super(sSLContext, executorService);
        if (sSLParameters == null) {
            throw new IllegalArgumentException();
        }
        this.a = sSLParameters;
    }

    @Override
    public ByteChannel a(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngine = ((SSLContext)((Object)this.a)).createSSLEngine();
        sSLEngine.setUseClientMode(false);
        sSLEngine.setSSLParameters(this.a);
        return new e(socketChannel, sSLEngine, (ExecutorService)((Object)this.a), selectionKey);
    }
}

