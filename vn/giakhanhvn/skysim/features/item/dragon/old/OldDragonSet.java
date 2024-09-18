/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.item.dragon.old;

import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.PlayerBoostStatistics;
import vn.giakhanhvn.skysim.features.item.armor.ArmorSet;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.old.OldDragonLeggings;

public class OldDragonSet
implements ArmorSet {
    @Override
    public String getName() {
        return "Old Blood";
    }

    @Override
    public String getDescription() {
        return "Increases the strength of Growth, Protection, Feather Falling, Sugar Rush, and True Protection enchantments while worn.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return OldDragonHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return OldDragonChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return OldDragonLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return OldDragonBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        return null;
    }
}

