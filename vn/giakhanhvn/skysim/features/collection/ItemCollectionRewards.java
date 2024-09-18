/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.collection;

import java.util.ArrayList;
import java.util.Arrays;
import vn.giakhanhvn.skysim.features.collection.ItemCollectionReward;

public class ItemCollectionRewards
extends ArrayList<ItemCollectionReward> {
    private final int requirement;

    public ItemCollectionRewards(int requirement, ItemCollectionReward ... rewards) {
        super(Arrays.asList(rewards));
        this.requirement = requirement;
    }

    public int getRequirement() {
        return this.requirement;
    }
}

