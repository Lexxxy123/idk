/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Effect
 *  org.bukkit.World
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.util;

import java.util.ArrayList;
import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.util.BoundingBox;

public class RayTracing {
    Vector origin;
    Vector direction;

    RayTracing(Vector origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public Vector getPostion(double blocksAway) {
        return this.origin.clone().add(this.direction.clone().multiply(blocksAway));
    }

    public boolean isOnLine(Vector position) {
        double t2 = (position.getX() - this.origin.getX()) / this.direction.getX();
        return (double)position.getBlockY() == this.origin.getY() + t2 * this.direction.getY() && (double)position.getBlockZ() == this.origin.getZ() + t2 * this.direction.getZ();
    }

    public ArrayList<Vector> traverse(double blocksAway, double accuracy) {
        ArrayList<Vector> positions = new ArrayList<Vector>();
        for (double d2 = 0.0; d2 <= blocksAway; d2 += accuracy) {
            positions.add(this.getPostion(d2));
        }
        return positions;
    }

    public Vector positionOfIntersection(Vector min, Vector max, double blocksAway, double accuracy) {
        ArrayList<Vector> positions = this.traverse(blocksAway, accuracy);
        for (Vector position : positions) {
            if (!RayTracing.intersects(position, min, max)) continue;
            return position;
        }
        return null;
    }

    public boolean intersects(Vector min, Vector max, double blocksAway, double accuracy) {
        ArrayList<Vector> positions = this.traverse(blocksAway, accuracy);
        for (Vector position : positions) {
            if (!RayTracing.intersects(position, min, max)) continue;
            return true;
        }
        return false;
    }

    public Vector positionOfIntersection(BoundingBox boundingBox, double blocksAway, double accuracy) {
        ArrayList<Vector> positions = this.traverse(blocksAway, accuracy);
        for (Vector position : positions) {
            if (!RayTracing.intersects(position, boundingBox.min, boundingBox.max)) continue;
            return position;
        }
        return null;
    }

    public boolean intersects(BoundingBox boundingBox, double blocksAway, double accuracy) {
        ArrayList<Vector> positions = this.traverse(blocksAway, accuracy);
        for (Vector position : positions) {
            if (!RayTracing.intersects(position, boundingBox.min, boundingBox.max)) continue;
            return true;
        }
        return false;
    }

    public static boolean intersects(Vector position, Vector min, Vector max) {
        if (position.getX() < min.getX() || position.getX() > max.getX()) {
            return false;
        }
        if (position.getY() < min.getY() || position.getY() > max.getY()) {
            return false;
        }
        return !(position.getZ() < min.getZ()) && !(position.getZ() > max.getZ());
    }

    public void highlight(World world, double blocksAway, double accuracy) {
        for (Vector position : this.traverse(blocksAway, accuracy)) {
            world.playEffect(position.toLocation(world), Effect.COLOURED_DUST, 0);
        }
    }
}

