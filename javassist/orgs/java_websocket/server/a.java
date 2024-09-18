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

public class a
extends b {
    private final String[] a;
    private final String[] b;

    public a(SSLContext sSLContext, String[] stringArray, String[] stringArray2) {
        this(sSLContext, Executors.newSingleThreadScheduledExecutor(), stringArray, stringArray2);
    }

    public a(SSLContext sSLContext, ExecutorService executorService, String[] stringArray, String[] stringArray2) {
        super(sSLContext, executorService);
        this.a = stringArray;
        this.b = stringArray2;
    }

    @Override
    public ByteChannel a(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngine = this.a.createSSLEngine();
        if (this.a != null) {
            sSLEngine.setEnabledProtocols(this.a);
        }
        if (this.b != null) {
            sSLEngine.setEnabledCipherSuites(this.b);
        }
        sSLEngine.setUseClientMode(false);
        return new e(socketChannel, sSLEngine, (ExecutorService)this.a, selectionKey);
    }
}

