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
import xyz.xenondevs.particle.task.ParticleTask;

public final class TargetedTask
extends ParticleTask {
    private final Collection<Player> targets;

    public TargetedTask(List<Object> packets, int tickDelay, Collection<Player> targets) {
        super(packets, tickDelay);
        this.targets = Objects.requireNonNull(targets);
    }

    @Override
    public Collection<Player> getTargetPlayers() {
        return this.targets;
    }
}

