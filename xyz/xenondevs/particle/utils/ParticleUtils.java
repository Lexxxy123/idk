/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package xyz.xenondevs.particle.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.xenondevs.particle.ParticleBuilder;
import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public final class ParticleUtils {
    public static void sendBulk(Collection<Object> packets, Player player) {
        Object connection = ReflectionUtils.PLAYER_CONNECTION_CACHE.getConnection(player);
        for (Object packet : packets) {
            try {
                ParticleConstants.PLAYER_CONNECTION_SEND_PACKET_METHOD.invoke(connection, packet);
            } catch (Exception exception) {}
        }
    }

    public static void sendBulk(Collection<Object> packets, Collection<Player> players) {
        for (Player player : players) {
            ParticleUtils.sendBulk(packets, player);
        }
    }

    public static void sendBulk(Collection<Object> packets) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ParticleUtils.sendBulk(packets, player);
        }
    }

    public static void sendBulkBuilders(Collection<ParticleBuilder> builders, Player player) {
        ParticleUtils.sendBulk((Collection<Object>)builders.stream().map(ParticleBuilder::toPacket).collect(Collectors.toList()), player);
    }

    public static void sendBulkBuilders(Collection<ParticleBuilder> builders, Collection<Player> players) {
        List<Object> packets = builders.stream().map(ParticleBuilder::toPacket).collect(Collectors.toList());
        for (Player player : players) {
            ParticleUtils.sendBulk(packets, player);
        }
    }

    public static void sendBulkBuilders(Collection<ParticleBuilder> builders) {
        List<Object> packets = builders.stream().map(ParticleBuilder::toPacket).collect(Collectors.toList());
        for (Player player : Bukkit.getOnlinePlayers()) {
            ParticleUtils.sendBulk(packets, player);
        }
    }
}

