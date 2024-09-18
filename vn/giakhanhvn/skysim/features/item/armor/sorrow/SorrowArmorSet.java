/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.item.armor.sorrow;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.armor.TickingSet;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorBoots;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorChestplate;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorHelmet;
import vn.giakhanhvn.skysim.features.item.armor.sorrow.SorrowArmorLeggings;

public class SorrowArmorSet
implements TickingSet {
    @Override
    public String getName() {
        return "Mist Aura";
    }

    @Override
    public String getDescription() {
        return "Hides the wearer in a guise of mist.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return SorrowArmorHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return SorrowArmorChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return SorrowArmorLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return SorrowArmorBoots.class;
    }

    @Override
    public void tick(Player owner, SItem helmet, SItem chestplate, SItem leggings, SItem boots, List<AtomicInteger> counters) {
    }
}

