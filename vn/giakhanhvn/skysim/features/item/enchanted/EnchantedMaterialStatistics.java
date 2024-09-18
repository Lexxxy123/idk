/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.enchanted;

import vn.giakhanhvn.skysim.features.item.MaterialQuantifiable;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.features.item.ShapelessRecipe;

public interface EnchantedMaterialStatistics
extends MaterialStatistics {
    public SMaterial getCraftingMaterial();

    public MaterialQuantifiable getResult();

    default public SMaterial getBlockCraftingMaterial() {
        return null;
    }

    default public MaterialQuantifiable getBlockResult() {
        return null;
    }

    default public int getCraftingRequiredAmount() {
        return 32;
    }

    @Override
    default public void load() {
        if (this.getBlockCraftingMaterial() != null && this.getBlockResult() != null) {
            EnchantedMaterialStatistics.createRecipe(new MaterialQuantifiable(this.getBlockCraftingMaterial(), this.getCraftingRequiredAmount()), this.getBlockResult());
        }
        EnchantedMaterialStatistics.createRecipe(new MaterialQuantifiable(this.getCraftingMaterial(), this.getCraftingRequiredAmount()), this.getResult());
    }

    public static void createRecipe(MaterialQuantifiable material, MaterialQuantifiable result) {
        new ShapelessRecipe(result.getMaterial(), result.getAmount()).add(material).add(material).add(material).add(material).add(material);
    }
}

