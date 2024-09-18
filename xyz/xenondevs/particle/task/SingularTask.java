/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 */
package xyz.xenondevs.particle.task;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.xenondevs.particle.task.ParticleTask;

public final class SingularTask
extends ParticleTask {
    private final UUID target;

    public SingularTask(List<Object> packets, int tickDelay, UUID target) {
        super(packets, tickDelay);
        this.target = Objects.requireNonNull(target);
    }

    public SingularTask(List<Object> packets, int tickDelay, Player target) {
        super(packets, tickDelay);
        this.target = Objects.requireNonNull(target).getUniqueId();
    }

    public List<Player> getTargetPlayers() {
        Player player = Bukkit.getPlayer((UUID)this.target);
        return player == null ? Collections.EMPTY_LIST : Collections.singletonList(player);
    }
}

