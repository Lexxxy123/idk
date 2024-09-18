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
import java.util.function.Supplier;
import org.bukkit.entity.Player;
import xyz.xenondevs.particle.task.ParticleTask;

public final class SuppliedTask
extends ParticleTask {
    private final Supplier<Collection<Player>> supplier;

    public SuppliedTask(List<Object> packets, int tickDelay, Supplier<Collection<Player>> supplier) {
        super(packets, tickDelay);
        this.supplier = Objects.requireNonNull(supplier);
    }

    @Override
    public Collection<Player> getTargetPlayers() {
        return this.supplier.get();
    }
}

