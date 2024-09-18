/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.block.Action
 *  org.bukkit.event.player.PlayerInteractEvent
 */
package vn.giakhanhvn.skysim.features.item.exclusive;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityType;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SkullStatistics;

public abstract class FloatingCrystal
implements SkullStatistics,
MaterialFunction {
    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public void onInteraction(PlayerInteractEvent e2) {
        if (e2.getAction() == Action.LEFT_CLICK_AIR || e2.getAction() == Action.LEFT_CLICK_BLOCK) {
            return;
        }
        Player player = e2.getPlayer();
        SEntity sEntity = new SEntity(player.getLocation().clone().add(player.getLocation().getDirection().multiply(1.5)), this.getCrystalType(), new Object[0]);
    }

    protected abstract SEntityType getCrystalType();
}

