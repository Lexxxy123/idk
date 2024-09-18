/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 */
package vn.giakhanhvn.skysim.features.entity.den;

import java.util.Collections;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import vn.giakhanhvn.skysim.features.entity.EntityDrop;
import vn.giakhanhvn.skysim.features.entity.EntityDropType;
import vn.giakhanhvn.skysim.features.entity.den.BaseSpider;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.util.SUtil;

public class TarantulaBeast
extends BaseSpider {
    @Override
    public String getEntityName() {
        return ChatColor.DARK_RED + "Tarantula Beast";
    }

    @Override
    public double getEntityMaxHealth() {
        return 144000.0;
    }

    @Override
    public double getDamageDealt() {
        return 2500.0;
    }

    @Override
    public double getXPDropped() {
        return 300.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.TARANTULA_WEB).getStack(), 2), EntityDropType.GUARANTEED, 1.0));
    }
}

