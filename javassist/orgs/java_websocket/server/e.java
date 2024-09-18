/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javassist.orgs.java_websocket.a;
import javassist.orgs.java_websocket.g;
import javassist.orgs.java_websocket.h;
import javassist.orgs.java_websocket.i;
import javassist.orgs.java_websocket.j;
import javassist.orgs.java_websocket.l;
import javassist.orgs.java_websocket.m;
import javassist.orgs.java_websocket.server.c;
import javassist.orgs.java_websocket.server.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class e
extends a
implements Runnable {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private final javassist.orgs.slf4j.c a;
    private final Collection<g> a;
    private final InetSocketAddress a;
    private ServerSocketChannel a;
    private Selector a;
    private List<javassist.orgs.java_websocket.drafts.a> b;
    private Thread a;
    private final AtomicBoolean a;
    protected List<f> a;
    private List<j> c;
    private BlockingQueue<ByteBuffer> a;
    private int b = 0;
    private final AtomicInteger a;
    private l a = new c();
    private int c = -1;

    public e() {
        this(new InetSocketAddress(80), a, null);
    }

    public e(InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress, a, null);
    }

    public e(InetSocketAddress inetSocketAddress, int n2) {
        this(inetSocketAddress, n2, null);
    }

    public e(InetSocketAddress inetSocketAddress, List<javassist.orgs.java_websocket.drafts.a> list) {
        this(inetSocketAddress, a, list);
    }

    public e(InetSocketAddress inetSocketAddress, int n2, List<javassist.orgs.java_websocket.drafts.a> list) {
        this(inetSocketAddress, n2, list, new HashSet<g>());
    }

    public e(InetSocketAddress inetSocketAddress, int n2, List<javassist.orgs.java_websocket.drafts.a> list, Collection<g> collection) {
        if (inetSocketAddress == null || n2 < 1 || collection == null) {
            throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
        }
        this.b = list == null ? Collections.emptyList() : list;
        this.a = inetSocketAddress;
        this.a = (int)collection;
        this.a(false);
        this.b(false);
        this.c = new LinkedList<j>();
        this.a = (int)new ArrayList(n2);
        this.a = (int)new LinkedBlockingQueue();
        int n3 = 0;
        while (n3 < n2) {
            f f2 = new f(this);
            this.a.add(f2);
            ++n3;
        }
    }

    public void c() {
        if (this.a != null) {
            throw new IllegalStateException(String.valueOf(this.getClass().getName()) + " can only be started once.");
        }
        new Thread(this).start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void b(int n2) {
        ArrayList arrayList;
        if (!this.a.compareAndSet(false, true)) {
            return;
        }
        Object object = this.a;
        synchronized (object) {
            arrayList = new ArrayList(this.a);
        }
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            object = (g)iterator.next();
            object.a(1001);
        }
        this.a.a();
        e e2 = this;
        object = e2;
        synchronized (e2) {
            if (this.a != null && this.a != null) {
                this.a.wakeup();
                this.a.join(n2);
            }
            // ** MonitorExit[var3_2 /* !! */ ] (shouldn't be in output)
            return;
        }
    }

    public void d() {
        this.b(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection<g> a() {
        int n2 = this.a;
        synchronized (n2) {
            return Collections.unmodifiableCollection(new ArrayList(this.a));
        }
    }

    public InetSocketAddress a() {
        return this.a;
    }

    public int b() {
        int n2 = this.a().getPort();
        if (n2 == 0 && this.a != null) {
            n2 = this.a.socket().getLocalPort();
        }
        return n2;
    }

    public List<javassist.orgs.java_websocket.drafts.a> a() {
        return Collections.unmodifiableList(this.b);
    }

    public void c(int n2) {
        this.c = n2;
    }

    public int c() {
        return this.c;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[CATCHBLOCK]], but top level block is 3[TRYBLOCK]
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

    private void f() {
        while (!this.c.isEmpty()) {
            j j2 = this.c.remove(0);
            m m2 = (m)j2.a();
            ByteBuffer byteBuffer = this.b();
            try {
                if (javassist.orgs.java_websocket.f.a(byteBuffer, j2, m2)) {
                    this.c.add(j2);
                }
                if (byteBuffer.hasRemaining()) {
                    j2.b.put(byteBuffer);
                    this.a(j2);
                    continue;
                }
                this.b(byteBuffer);
            } catch (IOException iOException) {
                this.b(byteBuffer);
                throw iOException;
            }
        }
    }

    private void a(SelectionKey selectionKey, Iterator<SelectionKey> iterator) {
        if (!this.a(selectionKey)) {
            selectionKey.cancel();
            return;
        }
        SocketChannel socketChannel = this.a.accept();
        if (socketChannel == null) {
            return;
        }
        socketChannel.configureBlocking(false);
        Socket socket = socketChannel.socket();
        socket.setTcpNoDelay(this.a_());
        socket.setKeepAlive(true);
        g g2 = this.a.a((h)this, (List)this.b);
        ((j)g2).a(socketChannel.register(this.a, 1, g2));
        try {
            ((j)g2).a(this.a.a(socketChannel, ((j)g2).a()));
            iterator.remove();
            this.b(g2);
        } catch (IOException iOException) {
            if (((j)g2).a() != null) {
                ((j)g2).a().cancel();
            }
            this.a(((j)g2).a(), null, iOException);
        }
    }

    private boolean a(SelectionKey selectionKey, Iterator<SelectionKey> iterator) {
        j j2 = (j)selectionKey.attachment();
        ByteBuffer byteBuffer = this.b();
        if (j2.a() == null) {
            selectionKey.cancel();
            this.a(selectionKey, j2, new IOException());
            return false;
        }
        try {
            if (javassist.orgs.java_websocket.f.a(byteBuffer, j2, j2.a())) {
                if (byteBuffer.hasRemaining()) {
                    j2.b.put(byteBuffer);
                    this.a(j2);
                    iterator.remove();
                    if (j2.a() instanceof m && ((m)j2.a()).b()) {
                        this.c.add(j2);
                    }
                } else {
                    this.b(byteBuffer);
                }
            } else {
                this.b(byteBuffer);
            }
        } catch (IOException iOException) {
            this.b(byteBuffer);
            throw new javassist.orgs.java_websocket.exceptions.j(j2, iOException);
        }
        return true;
    }

    private void a(SelectionKey selectionKey) {
        j j2 = (j)selectionKey.attachment();
        try {
            if (javassist.orgs.java_websocket.f.a(j2, j2.a()) && selectionKey.isValid()) {
                selectionKey.interestOps(1);
            }
        } catch (IOException iOException) {
            throw new javassist.orgs.java_websocket.exceptions.j(j2, iOException);
        }
    }

    private boolean c() {
        this.a.setName("WebSocketSelector-" + this.a.getId());
        try {
            this.a = ServerSocketChannel.open();
            this.a.configureBlocking(false);
            ServerSocket serverSocket = this.a.socket();
            serverSocket.setReceiveBufferSize(16384);
            serverSocket.setReuseAddress(this.b_());
            serverSocket.bind(this.a, this.c());
            this.a = Selector.open();
            this.a.register(this.a, this.a.validOps());
            this.b_();
            for (f f2 : this.a) {
                f2.start();
            }
            this.e();
        } catch (IOException iOException) {
            this.c(null, iOException);
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean d() {
        e e2 = this;
        synchronized (e2) {
            block5: {
                if (this.a != null) {
                    throw new IllegalStateException(String.valueOf(this.getClass().getName()) + " can only be started once.");
                }
                this.a = Thread.currentThread();
                if (!this.a.get()) break block5;
                return false;
            }
        }
        return true;
    }

    private void g() {
        this.a_();
        if (this.a != null) {
            for (f f2 : this.a) {
                f2.interrupt();
            }
        }
        if (this.a != null) {
            try {
                this.a.close();
            } catch (IOException iOException) {
                this.a.e("IOException during selector.close", iOException);
                this.b(null, iOException);
            }
        }
        if (this.a != null) {
            try {
                this.a.close();
            } catch (IOException iOException) {
                this.a.e("IOException during server.close", iOException);
                this.b(null, iOException);
            }
        }
    }

    protected void b(g g2) {
        if (this.a.get() >= 2 * this.a.size() + 1) {
            return;
        }
        this.a.incrementAndGet();
        this.a.put(this.a());
    }

    protected void c(g g2) {
    }

    public ByteBuffer a() {
        return ByteBuffer.allocate(16384);
    }

    protected void a(j j2) {
        if (j2.a() == null) {
            j2.a((f)this.a.get(this.b % this.a.size()));
            ++this.b;
        }
        j2.a().a(j2);
    }

    private ByteBuffer b() {
        return (ByteBuffer)this.a.take();
    }

    private void b(ByteBuffer byteBuffer) {
        if (this.a.size() > this.a.intValue()) {
            return;
        }
        this.a.put(byteBuffer);
    }

    private void a(SelectionKey selectionKey, g g2, IOException iOException) {
        SelectableChannel selectableChannel;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        if (g2 != null) {
            g2.b(1006, iOException.getMessage());
        } else if (selectionKey != null && (selectableChannel = selectionKey.channel()) != null && selectableChannel.isOpen()) {
            try {
                selectableChannel.close();
            } catch (IOException iOException2) {
                // empty catch block
            }
            this.a.a("Connection closed because of exception", iOException);
        }
    }

    private void c(g g2, Exception exception) {
        this.a.e("Shutdown due to fatal error", exception);
        this.b(g2, exception);
        if (this.a != null) {
            for (f f2 : this.a) {
                f2.interrupt();
            }
        }
        if (this.a != null) {
            this.a.interrupt();
        }
        try {
            this.d();
        } catch (IOException iOException) {
            this.a.e("Error during shutdown", iOException);
            this.b(null, iOException);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            this.a.e("Interrupt during stop", exception);
            this.b(null, interruptedException);
        }
    }

    @Override
    public final void a(g g2, String string) {
        this.b(g2, string);
    }

    @Override
    public final void a(g g2, ByteBuffer byteBuffer) {
        this.b(g2, byteBuffer);
    }

    @Override
    public final void a(g g2, javassist.orgs.java_websocket.handshake.f f2) {
        if (this.b(g2)) {
            this.b(g2, (javassist.orgs.java_websocket.handshake.a)f2);
        }
    }

    @Override
    public final void a(g g2, int n2, String string, boolean bl2) {
        this.a.wakeup();
        try {
            if (this.a(g2)) {
                this.d(g2, n2, string, bl2);
            }
        } finally {
            try {
                this.c(g2);
            } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean a(g g2) {
        boolean bl2 = false;
        int n2 = this.a;
        synchronized (n2) {
            if (this.a.contains(g2)) {
                bl2 = this.a.remove(g2);
            } else {
                this.a.a("Removing connection which is not in the connections collection! Possible no handshake recieved! {}", (Object)g2);
            }
        }
        if (this.a.get() && this.a.isEmpty()) {
            this.a.interrupt();
        }
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean b(g g2) {
        if (!this.a.get()) {
            int n2 = this.a;
            synchronized (n2) {
                return this.a.add(g2);
            }
        }
        g2.a(1001);
        return true;
    }

    @Override
    public final void a(g g2, Exception exception) {
        this.b(g2, exception);
    }

    @Override
    public final void a(g g2) {
        j j2 = (j)g2;
        try {
            j2.a().interestOps(5);
        } catch (CancelledKeyException cancelledKeyException) {
            j2.a.clear();
        }
        this.a.wakeup();
    }

    @Override
    public void a(g g2, int n2, String string) {
        this.b(g2, n2, string);
    }

    @Override
    public void b(g g2, int n2, String string, boolean bl2) {
        this.c(g2, n2, string, bl2);
    }

    public void b(g g2, int n2, String string) {
    }

    public void c(g g2, int n2, String string, boolean bl2) {
    }

    public final void a(l l2) {
        if (this.a != null) {
            this.a.a();
        }
        this.a = l2;
    }

    public final i a() {
        return this.a;
    }

    protected boolean a(SelectionKey selectionKey) {
        return true;
    }

    private Socket a(g g2) {
        j j2 = (j)g2;
        return ((SocketChannel)j2.a().channel()).socket();
    }

    @Override
    public InetSocketAddress a(g g2) {
        return (InetSocketAddress)this.a(g2).getLocalSocketAddress();
    }

    @Override
    public InetSocketAddress b(g g2) {
        return (InetSocketAddress)this.a(g2).getRemoteSocketAddress();
    }

    public abstract void b(g var1, javassist.orgs.java_websocket.handshake.a var2);

    public abstract void d(g var1, int var2, String var3, boolean var4);

    public abstract void b(g var1, String var2);

    public abstract void b(g var1, Exception var2);

    public abstract void e();

    public void b(g g2, ByteBuffer byteBuffer) {
    }

    public void a(String string) {
        this.a(string, (Collection<g>)this.a);
    }

    public void a(byte[] byArray) {
        this.a(byArray, (Collection<g>)this.a);
    }

    public void a(ByteBuffer byteBuffer) {
        this.a(byteBuffer, (Collection<g>)this.a);
    }

    public void a(byte[] byArray, Collection<g> collection) {
        if (byArray == null || collection == null) {
            throw new IllegalArgumentException();
        }
        this.a(ByteBuffer.wrap(byArray), collection);
    }

    public void a(ByteBuffer byteBuffer, Collection<g> collection) {
        if (byteBuffer == null || collection == null) {
            throw new IllegalArgumentException();
        }
        this.a((Object)byteBuffer, collection);
    }

    public void a(String string, Collection<g> collection) {
        if (string == null || collection == null) {
            throw new IllegalArgumentException();
        }
        this.a((Object)string, collection);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(Object object, Collection<g> collection) {
        ArrayList<g> arrayList;
        String string = null;
        if (object instanceof String) {
            string = (String)object;
        }
        ByteBuffer byteBuffer = null;
        if (object instanceof ByteBuffer) {
            byteBuffer = (ByteBuffer)object;
        }
        if (string == null && byteBuffer == null) {
            return;
        }
        HashMap<javassist.orgs.java_websocket.drafts.a, List<javassist.orgs.java_websocket.framing.f>> hashMap = new HashMap<javassist.orgs.java_websocket.drafts.a, List<javassist.orgs.java_websocket.framing.f>>();
        Collection<g> object22 = collection;
        synchronized (object22) {
            arrayList = new ArrayList<g>(collection);
        }
        for (g g2 : arrayList) {
            if (g2 == null) continue;
            javassist.orgs.java_websocket.drafts.a a2 = g2.a();
            this.a(a2, hashMap, string, byteBuffer);
            try {
                g2.a((Collection)hashMap.get(a2));
            } catch (javassist.orgs.java_websocket.exceptions.i i2) {
                // empty catch block
            }
        }
    }

    private void a(javassist.orgs.java_websocket.drafts.a a2, Map<javassist.orgs.java_websocket.drafts.a, List<javassist.orgs.java_websocket.framing.f>> map, String string, ByteBuffer byteBuffer) {
        if (!map.containsKey(a2)) {
            List<javassist.orgs.java_websocket.framing.f> list = null;
            if (string != null) {
                list = a2.a(string, false);
            }
            if (byteBuffer != null) {
                list = a2.a(byteBuffer, false);
            }
            if (list != null) {
                map.put(a2, list);
            }
        }
    }

    static /* synthetic */ javassist.orgs.slf4j.c a(e e2) {
        return e2.a;
    }

    static /* synthetic */ void a(e e2, g g2, Exception exception) {
        e2.c(g2, exception);
    }

    static /* synthetic */ void a(e e2, ByteBuffer byteBuffer) {
        e2.b(byteBuffer);
    }
}

