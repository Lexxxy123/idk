/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.server;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javassist.orgs.java_websocket.drafts.a;
import javassist.orgs.java_websocket.e;
import javassist.orgs.java_websocket.h;
import javassist.orgs.java_websocket.j;
import javassist.orgs.java_websocket.k;
import javassist.orgs.java_websocket.l;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
implements l {
    protected SSLContext a;
    protected ExecutorService a;

    public b(SSLContext sSLContext) {
        this(sSLContext, Executors.newSingleThreadScheduledExecutor());
    }

    public b(SSLContext sSLContext, ExecutorService executorService) {
        if (sSLContext == null || executorService == null) {
            throw new IllegalArgumentException();
        }
        this.a = sSLContext;
        this.a = executorService;
    }

    @Override
    public ByteChannel a(SocketChannel socketChannel, SelectionKey selectionKey) {
        SSLEngine sSLEngine = this.a.createSSLEngine();
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(sSLEngine.getEnabledCipherSuites()));
        arrayList.remove("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        sSLEngine.setEnabledCipherSuites(arrayList.toArray(new String[arrayList.size()]));
        sSLEngine.setUseClientMode(false);
        return new e(socketChannel, sSLEngine, this.a, selectionKey);
    }

    @Override
    public j a(h h2, a a2) {
        return new j((k)h2, a2);
    }

    @Override
    public j a(h h2, List<a> list) {
        return new j((k)h2, list);
    }

    @Override
    public void a() {
        this.a.shutdown();
    }
}

