/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.extra.beam;

import com.google.common.base.Preconditions;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.extra.beam.LocationTargetBeam;

public class ClientBeam {
    private final UUID worldUID;
    private final double viewingRadiusSquared;
    private final long updateDelay;
    private boolean isActive;
    private final LocationTargetBeam beam;
    private Location startingPosition;
    private Location endingPosition;
    private Player player;
    private boolean isViewing;
    private BukkitRunnable runnable;

    public ClientBeam(Player player, Location startingPosition, Location endingPosition) {
        this(player, startingPosition, endingPosition, 100.0, 5L);
    }

    public ClientBeam(Player player, Location startingPosition, Location endingPosition, double viewingRadius, long updateDelay) {
        Preconditions.checkNotNull(player, "player cannot be null");
        Preconditions.checkArgument(player.isOnline(), "The player must be online");
        Preconditions.checkNotNull(startingPosition, "startingPosition cannot be null");
        Preconditions.checkNotNull(endingPosition, "endingPosition cannot be null");
        Preconditions.checkState(startingPosition.getWorld().equals(endingPosition.getWorld()), "startingPosition and endingPosition must be in the same world");
        Preconditions.checkArgument(viewingRadius > 0.0, "viewingRadius must be positive");
        Preconditions.checkArgument(updateDelay >= 1L, "viewingRadius must be a natural number");
        this.worldUID = startingPosition.getWorld().getUID();
        this.viewingRadiusSquared = viewingRadius * viewingRadius;
        this.updateDelay = updateDelay;
        this.isActive = false;
        this.beam = new LocationTargetBeam(startingPosition, endingPosition);
        this.startingPosition = startingPosition;
        this.endingPosition = endingPosition;
        this.player = player;
        this.isViewing = false;
    }

    public void start() {
        Preconditions.checkState(!this.isActive, "The beam must be disabled in order to start it");
        Preconditions.checkState(this.player != null && !this.player.isOnline(), "The player must be online");
        this.isActive = true;
        this.runnable = new ClientBeamUpdater();
        this.runnable.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, this.updateDelay);
    }

    public void stop() {
        Preconditions.checkState(this.isActive, "The beam must be enabled in order to stop it");
        this.isActive = false;
        this.isViewing = false;
        if (this.player != null && !this.player.isOnline()) {
            this.player = null;
        }
        this.runnable.cancel();
        this.runnable = null;
    }

    public void setStartingPosition(Location location) {
        Preconditions.checkArgument(location.getWorld().getUID().equals(this.worldUID), "location must be in the same world as this beam");
        Preconditions.checkState(this.player != null && !this.player.isOnline(), "The player must be online");
        this.startingPosition = location;
        this.beam.setStartingPosition(this.player, location);
    }

    public void setEndingPosition(Location location) {
        Preconditions.checkArgument(location.getWorld().getUID().equals(this.worldUID), "location must be in the same world as this beam");
        Preconditions.checkState(this.player != null && !this.player.isOnline(), "The player must be online");
        this.endingPosition = location;
        this.beam.setEndingPosition(this.player, location);
    }

    public void update() {
        if (this.player == null || !this.player.isOnline()) {
            this.stop();
        }
        if (this.isActive) {
            if (!this.player.getWorld().getUID().equals(this.worldUID)) {
                this.stop();
            }
            if (this.isCloseEnough(this.player.getLocation())) {
                if (!this.isViewing) {
                    this.beam.start(this.player);
                    this.isViewing = true;
                }
            } else if (this.isViewing) {
                this.beam.cleanup(this.player);
                this.isViewing = false;
            }
        }
    }

    public boolean isActive() {
        return this.isActive;
    }

    public boolean isViewing() {
        return this.isViewing;
    }

    private boolean isCloseEnough(Location location) {
        return this.startingPosition.distanceSquared(location) <= this.viewingRadiusSquared || this.endingPosition.distanceSquared(location) <= this.viewingRadiusSquared;
    }

    private class ClientBeamUpdater
    extends BukkitRunnable {
        private ClientBeamUpdater() {
        }

        public void run() {
            ClientBeam.this.update();
        }
    }
}

