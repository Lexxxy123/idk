/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package xyz.xenondevs.particle.task;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.bukkit.entity.Player;

public abstract class ParticleTask {
    private final List<Object> packets;
    private final int tickDelay;

    public ParticleTask(List<Object> packets, int tickDelay) {
        this.packets = Objects.requireNonNull(packets);
        this.tickDelay = tickDelay;
    }

    public List<Object> getPackets() {
        return this.packets;
    }

    public int getTickDelay() {
        return this.tickDelay;
    }

    public abstract Collection<Player> getTargetPlayers();
}

