/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.collection;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.collection.ItemCollectionReward;

public class ItemCollectionUpgradeReward
extends ItemCollectionReward {
    private final String name;
    private final ChatColor color;

    public ItemCollectionUpgradeReward(String name, ChatColor color) {
        super(ItemCollectionReward.Type.UPGRADE);
        this.name = name;
        this.color = color;
    }

    @Override
    public String toRewardString() {
        return this.color + this.name + " Upgrade";
    }

    @Override
    public void onAchieve(Player player) {
    }
}

