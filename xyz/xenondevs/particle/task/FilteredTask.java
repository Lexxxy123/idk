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
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.xenondevs.particle.task.ParticleTask;

public final class FilteredTask
extends ParticleTask {
    private final Predicate<Player> filter;

    public FilteredTask(List<Object> packets, int tickDelay, Predicate<Player> filter) {
        super(packets, tickDelay);
        this.filter = Objects.requireNonNull(filter);
    }

    @Override
    public Collection<Player> getTargetPlayers() {
        return Bukkit.getOnlinePlayers().stream().filter(this.filter).collect(Collectors.toList());
    }
}

