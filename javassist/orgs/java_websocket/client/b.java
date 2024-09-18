/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javassist.orgs.java_websocket.client.a;
import javassist.orgs.java_websocket.client.c;
import javassist.orgs.java_websocket.client.d;
import javassist.orgs.java_websocket.g;
import javassist.orgs.java_websocket.handshake.f;
import javassist.orgs.java_websocket.handshake.h;
import javassist.orgs.java_websocket.j;
import javassist.orgs.java_websocket.k;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class b
extends javassist.orgs.java_websocket.a
implements Runnable,
g {
    protected URI a;
    private j a;
    private Socket a;
    private SocketFactory a;
    private OutputStream a;
    private Proxy a;
    private Thread a;
    private Thread b;
    private javassist.orgs.java_websocket.drafts.a a;
    private Map<String, String> a;
    private CountDownLatch a;
    private CountDownLatch b;
    private int a;
    private a a = null;

    public b(URI uRI) {
        this(uRI, new javassist.orgs.java_websocket.drafts.b());
    }

    public b(URI uRI, javassist.orgs.java_websocket.drafts.a a2) {
        this(uRI, a2, null, 0);
    }

    public b(URI uRI, Map<String, String> map) {
        this(uRI, new javassist.orgs.java_websocket.drafts.b(), map);
    }

    public b(URI uRI, javassist.orgs.java_websocket.drafts.a a2, Map<String, String> map) {
        this(uRI, a2, map, 0);
    }

    public b(URI uRI, javassist.orgs.java_websocket.drafts.a a2, Map<String, String> map, int n2) {
        this.b = new CountDownLatch(1);
        if (uRI == null) {
            throw new IllegalArgumentException();
        }
        if (a2 == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.a = uRI;
        this.a = a2;
        this.a = new c(this);
        if (map != null) {
            this.a = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            this.a.putAll(map);
        }
        this.a = n2;
        this.a((Object)false);
        this.b(false);
        this.a = new j((k)this, a2);
    }

    public URI a() {
        return this.a;
    }

    @Override
    public javassist.orgs.java_websocket.drafts.a a() {
        return this.a;
    }

    public Socket a() {
        return this.a;
    }

    public void a(String string, String string2) {
        if (this.a == null) {
            this.a = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        }
        this.a.put(string, string2);
    }

    public String a(String string) {
        if (this.a == null) {
            return null;
        }
        return (String)this.a.remove(string);
    }

    public void c() {
        this.a = null;
    }

    public void a(a a2) {
        this.a = a2;
    }

    public void d() {
        this.g();
        this.e();
    }

    public boolean g() {
        this.g();
        return this.h();
    }

    private void g() {
        Thread thread = Thread.currentThread();
        if (thread == this.a || thread == this.b) {
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
        }
        try {
            this.f();
            if (this.a != null) {
                this.a.interrupt();
                this.a = null;
            }
            if (this.b != null) {
                this.b.interrupt();
                this.b = null;
            }
            this.a.a();
            if (this.a != null) {
                this.a.close();
                this.a = null;
            }
        } catch (Exception exception) {
            this.a(exception);
            this.a.b(1006, exception.getMessage());
            return;
        }
        this.a = new CountDownLatch(1);
        this.b = new CountDownLatch(1);
        this.a = new j((k)this, this.a);
    }

    public void e() {
        if (this.b != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        this.b = new Thread(this);
        this.b.setName("WebSocketConnectReadThread-" + this.b.getId());
        this.b.start();
    }

    public boolean h() {
        this.e();
        this.a.await();
        return this.a.b();
    }

    public boolean a(long l2, TimeUnit timeUnit) {
        this.e();
        return this.a.await(l2, timeUnit) && this.a.b();
    }

    @Override
    public void a() {
        if (this.a != null) {
            this.a.a(1000);
        }
    }

    public void f() {
        this.a();
        this.b.await();
    }

    @Override
    public void a(String string) {
        this.a.a(string);
    }

    @Override
    public void a(byte[] byArray) {
        this.a.a(byArray);
    }

    @Override
    public <T> T a() {
        return this.a.a();
    }

    @Override
    public <T> void a(T t2) {
        this.a.a(t2);
    }

    @Override
    protected Collection<g> a() {
        return Collections.singletonList(this.a);
    }

    @Override
    public void b() {
        this.a.b();
    }

    @Override
    public void run() {
        InputStream inputStream;
        try {
            Object object;
            Object object2;
            boolean bl2 = false;
            if (this.a != null) {
                this.a = this.a.createSocket();
            } else if (this.a == null) {
                this.a = new Socket(this.a);
                bl2 = true;
            } else if (this.a.isClosed()) {
                throw new IOException();
            }
            this.a.setTcpNoDelay(this.a_());
            this.a.setReuseAddress(this.b_());
            if (!this.a.isConnected()) {
                object2 = new InetSocketAddress(this.a.a(this.a), this.b());
                this.a.connect((SocketAddress)object2, this.a);
            }
            if (bl2 && "wss".equals(this.a.getScheme())) {
                object2 = SSLContext.getInstance("TLSv1.2");
                ((SSLContext)object2).init(null, null, null);
                object = ((SSLContext)object2).getSocketFactory();
                this.a = ((SSLSocketFactory)object).createSocket(this.a, this.a.getHost(), this.b(), true);
            }
            if (this.a instanceof SSLSocket) {
                object2 = (SSLSocket)this.a;
                object = ((SSLSocket)object2).getSSLParameters();
                ((SSLParameters)object).setEndpointIdentificationAlgorithm("HTTPS");
                this.a((SSLParameters)object);
                ((SSLSocket)object2).setSSLParameters((SSLParameters)object);
            }
            inputStream = this.a.getInputStream();
            this.a = this.a.getOutputStream();
            this.h();
        } catch (Exception exception) {
            this.a((g)this.a, exception);
            this.a.b(-1, exception.getMessage());
            return;
        } catch (InternalError internalError) {
            if (internalError.getCause() instanceof InvocationTargetException && internalError.getCause().getCause() instanceof IOException) {
                IOException iOException = (IOException)internalError.getCause().getCause();
                this.a((g)this.a, iOException);
                this.a.b(-1, iOException.getMessage());
                return;
            }
            throw internalError;
        }
        this.a = new Thread(new d(this, this));
        this.a.start();
        byte[] byArray = new byte[16384];
        try {
            int n2;
            while (!this.c() && !this.e() && (n2 = inputStream.read(byArray)) != -1) {
                this.a.b(ByteBuffer.wrap(byArray, 0, n2));
            }
            this.a.d();
        } catch (IOException iOException) {
            this.a(iOException);
        } catch (RuntimeException runtimeException) {
            this.a(runtimeException);
            this.a.b(1006, runtimeException.getMessage());
        }
        this.b = null;
    }

    protected void a(SSLParameters sSLParameters) {
    }

    private int b() {
        int n2 = this.a.getPort();
        if (n2 == -1) {
            String string = this.a.getScheme();
            if ("wss".equals(string)) {
                return 443;
            }
            if ("ws".equals(string)) {
                return 80;
            }
            throw new IllegalArgumentException("unknown scheme: " + string);
        }
        return n2;
    }

    private void h() {
        String string = this.a.getRawPath();
        String string2 = this.a.getRawQuery();
        String string3 = string == null || string.length() == 0 ? "/" : string;
        if (string2 != null) {
            string3 = String.valueOf(string3) + '?' + string2;
        }
        int n2 = this.b();
        String string4 = String.valueOf(this.a.getHost()) + (n2 != 80 && n2 != 443 ? ":" + n2 : "");
        javassist.orgs.java_websocket.handshake.d d2 = new javassist.orgs.java_websocket.handshake.d();
        d2.a(string3);
        d2.a("Host", string4);
        if (this.a != null) {
            for (Map.Entry entry : this.a.entrySet()) {
                d2.a((String)entry.getKey(), (String)entry.getValue());
            }
        }
        this.a.a(d2);
    }

    @Override
    public javassist.orgs.java_websocket.enums.d a() {
        return this.a.a();
    }

    @Override
    public final void a(g g2, String string) {
        this.b(string);
    }

    @Override
    public final void a(g g2, ByteBuffer byteBuffer) {
        this.b(byteBuffer);
    }

    @Override
    public final void a(g g2, f f2) {
        this.b_();
        this.a((h)f2);
        this.a.countDown();
    }

    @Override
    public final void a(g g2, int n2, String string, boolean bl2) {
        this.a_();
        if (this.a != null) {
            this.a.interrupt();
        }
        this.b(n2, string, bl2);
        this.a.countDown();
        this.b.countDown();
    }

    @Override
    public final void a(g g2, Exception exception) {
        this.a(exception);
    }

    @Override
    public final void a(g g2) {
    }

    @Override
    public void a(g g2, int n2, String string) {
        this.c(n2, string);
    }

    @Override
    public void b(g g2, int n2, String string, boolean bl2) {
        this.a(n2, string, bl2);
    }

    public void c(int n2, String string) {
    }

    public void a(int n2, String string, boolean bl2) {
    }

    public g a() {
        return this.a;
    }

    @Override
    public InetSocketAddress a(g g2) {
        if (this.a != null) {
            return (InetSocketAddress)this.a.getLocalSocketAddress();
        }
        return null;
    }

    @Override
    public InetSocketAddress b(g g2) {
        if (this.a != null) {
            return (InetSocketAddress)this.a.getRemoteSocketAddress();
        }
        return null;
    }

    public abstract void a(h var1);

    public abstract void b(String var1);

    public abstract void b(int var1, String var2, boolean var3);

    public abstract void a(Exception var1);

    public void b(ByteBuffer byteBuffer) {
    }

    public void a(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        this.a = proxy;
    }

    @Deprecated
    public void a(Socket socket) {
        if (this.a != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.a = socket;
    }

    public void a(SocketFactory socketFactory) {
        this.a = socketFactory;
    }

    @Override
    public void a(javassist.orgs.java_websocket.enums.c c2, ByteBuffer byteBuffer, boolean bl2) {
        this.a.a(c2, byteBuffer, bl2);
    }

    @Override
    public boolean b() {
        return this.a.b();
    }

    @Override
    public boolean d() {
        return this.a.d();
    }

    @Override
    public boolean e() {
        return this.a.e();
    }

    @Override
    public boolean c() {
        return this.a.c();
    }

    @Override
    public boolean a() {
        return this.a.a();
    }

    @Override
    public void a(int n2) {
        this.a.a(n2);
    }

    @Override
    public void a(int n2, String string) {
        this.a.a(n2, string);
    }

    @Override
    public void b(int n2, String string) {
        this.a.b(n2, string);
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        this.a.a(byteBuffer);
    }

    @Override
    public void a(javassist.orgs.java_websocket.framing.f f2) {
        this.a.a(f2);
    }

    @Override
    public void a(Collection<javassist.orgs.java_websocket.framing.f> collection) {
        this.a.a(collection);
    }

    @Override
    public InetSocketAddress b() {
        return this.a.b();
    }

    @Override
    public InetSocketAddress a() {
        return this.a.a();
    }

    @Override
    public String a() {
        return this.a.getPath();
    }

    @Override
    public boolean f() {
        return this.a.f();
    }

    @Override
    public SSLSession a() {
        return this.a.a();
    }

    private void a(IOException iOException) {
        if (iOException instanceof SSLException) {
            this.a((Exception)iOException);
        }
        this.a.d();
    }

    static /* synthetic */ void a(b b2, Thread thread) {
        b2.a = thread;
    }

    static /* synthetic */ void a(b b2, IOException iOException) {
        b2.a(iOException);
    }

    static /* synthetic */ j a(b b2) {
        return b2.a;
    }

    static /* synthetic */ OutputStream a(b b2) {
        return b2.a;
    }

    static /* synthetic */ Socket a(b b2) {
        return b2.a;
    }
}

