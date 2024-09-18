/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package xyz.xenondevs.particle.task;

import java.util.Collection;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.xenondevs.particle.task.ParticleTask;

public final class GlobalTask
extends ParticleTask {
    public GlobalTask(List<Object> packets, int tickDelay) {
        super(packets, tickDelay);
    }

    @Override
    public Collection<Player> getTargetPlayers() {
        return Bukkit.getOnlinePlayers();
    }
}

