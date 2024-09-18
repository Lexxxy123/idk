/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.World
 *  org.bukkit.entity.Player
 */
package xyz.xenondevs.particle.task;

import java.util.Collection;
import java.util.List;
import org.bukkit.World;
import org.bukkit.entity.Player;
import xyz.xenondevs.particle.task.ParticleTask;

public final class WorldTask
extends ParticleTask {
    private final World world;

    public WorldTask(List<Object> packets, int tickDelay, World world) {
        super(packets, tickDelay);
        this.world = world;
    }

    @Override
    public Collection<Player> getTargetPlayers() {
        return this.world.getPlayers();
    }
}

