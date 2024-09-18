/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.item.armor.lapis;

import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.PlayerBoostStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.armor.ArmorSet;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorBoots;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorChestplate;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorHelmet;
import vn.giakhanhvn.skysim.features.item.armor.lapis.LapisArmorLeggings;

public class LapisArmorSet
implements ArmorSet {
    @Override
    public String getName() {
        return "Health";
    }

    @Override
    public String getDescription() {
        return "Increases the wearer's maximum Health by 60.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return LapisArmorHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return LapisArmorChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return LapisArmorLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return LapisArmorBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
        return new PlayerBoostStatistics(){

            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public Rarity getRarity() {
                return null;
            }

            @Override
            public GenericItemType getType() {
                return null;
            }

            @Override
            public double getBaseHealth() {
                return 60.0;
            }
        };
    }
}

