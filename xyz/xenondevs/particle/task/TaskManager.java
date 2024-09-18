/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.World
 *  org.bukkit.entity.Player
 */
package xyz.xenondevs.particle.task;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import xyz.xenondevs.particle.task.FilteredTask;
import xyz.xenondevs.particle.task.GlobalTask;
import xyz.xenondevs.particle.task.ParticleTask;
import xyz.xenondevs.particle.task.SingularTask;
import xyz.xenondevs.particle.task.SuppliedTask;
import xyz.xenondevs.particle.task.TargetedTask;
import xyz.xenondevs.particle.task.WorldTask;
import xyz.xenondevs.particle.utils.ParticleUtils;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public final class TaskManager {
    private static final TaskManager INSTANCE = new TaskManager();

    private TaskManager() {
    }

    public int startTask(ParticleTask task) {
        int taskId = Bukkit.getScheduler().runTaskTimerAsynchronously(ReflectionUtils.getPlugin(), () -> ParticleUtils.sendBulk(task.getPackets(), task.getTargetPlayers()), 0L, (long)task.getTickDelay()).getTaskId();
        return taskId;
    }

    public void stopTask(int taskId) {
        Bukkit.getScheduler().cancelTask(taskId);
    }

    public static TaskManager getTaskManager() {
        return INSTANCE;
    }

    public static int startGlobalTask(List<Object> packets, int tickDelay) {
        return TaskManager.getTaskManager().startTask(new GlobalTask(packets, tickDelay));
    }

    public static int startWorldTask(List<Object> packets, int tickDelay, World world) {
        return TaskManager.getTaskManager().startTask(new WorldTask(packets, tickDelay, world));
    }

    public static int startTargetedTask(List<Object> packets, int tickDelay, Collection<Player> targets) {
        return TaskManager.getTaskManager().startTask(new TargetedTask(packets, tickDelay, targets));
    }

    public static int startSingularTask(List<Object> packets, int tickDelay, UUID target) {
        return TaskManager.getTaskManager().startTask(new SingularTask(packets, tickDelay, target));
    }

    public static int startSingularTask(List<Object> packets, int tickDelay, Player target) {
        return TaskManager.getTaskManager().startTask(new SingularTask(packets, tickDelay, target));
    }

    public static int startFilteredTask(List<Object> packets, int tickDelay, Predicate<Player> filter) {
        return TaskManager.getTaskManager().startTask(new FilteredTask(packets, tickDelay, filter));
    }

    public static int startSuppliedTask(List<Object> packets, int tickDelay, Supplier<Collection<Player>> supplier) {
        return TaskManager.getTaskManager().startTask(new SuppliedTask(packets, tickDelay, supplier));
    }
}

