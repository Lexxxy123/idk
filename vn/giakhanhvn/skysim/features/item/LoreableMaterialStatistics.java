/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item;

import java.util.List;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.SItem;

public interface LoreableMaterialStatistics
extends MaterialStatistics {
    public List<String> getCustomLore(SItem var1);
}

