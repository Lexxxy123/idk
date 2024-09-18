/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.nms.nmsutil.packetlistener;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.nms.nmsutil.packetlistener.IPacketListener;
import vn.giakhanhvn.skysim.nms.nmsutil.packetlistener.channel.ChannelAbstract;
import vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.ClassResolver;
import vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.ConstructorResolver;

public class ChannelInjector {
    private static final ClassResolver CLASS_RESOLVER = new ClassResolver();
    private ChannelAbstract channel;

    public boolean inject(IPacketListener iPacketListener) {
        ArrayList<Exception> exceptions = new ArrayList<Exception>();
        try {
            Class.forName("io.netty.channel.Channel");
            this.channel = this.newChannelInstance(iPacketListener, "vn.giakhanhvn.skysim.nms.nmsutil.packetlistener.channel.INCChannel");
            System.out.println("[SkySim Protocol Injector] Using INChannel");
            return true;
        } catch (Exception e1) {
            exceptions.add(e1);
            for (Exception e2 : exceptions) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    protected ChannelAbstract newChannelInstance(IPacketListener iPacketListener, String clazzName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (ChannelAbstract)new ConstructorResolver(CLASS_RESOLVER.resolve(clazzName)).resolve(new Class[][]{{IPacketListener.class}}).newInstance(iPacketListener);
    }

    public void addChannel(Player p2) {
        this.channel.addChannel(p2);
    }

    public void removeChannel(Player p2) {
        this.channel.removeChannel(p2);
    }

    public void addServerChannel() {
        this.channel.addServerChannel();
    }
}

