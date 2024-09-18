/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.Recipe
 *  org.bukkit.inventory.ShapedRecipe
 *  org.bukkit.inventory.ShapelessRecipe
 */
package vn.giakhanhvn.skysim.features.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import vn.giakhanhvn.skysim.features.item.MaterialQuantifiable;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.features.item.ShapedRecipe;
import vn.giakhanhvn.skysim.features.item.ShapelessRecipe;
import vn.giakhanhvn.skysim.util.Groups;

public abstract class Recipe<T> {
    protected static final List<List<SMaterial>> EXCHANGEABLES = new ArrayList<List>(Arrays.asList(Arrays.asList(SMaterial.OAK_WOOD, SMaterial.SPRUCE_WOOD, SMaterial.BIRCH_WOOD, SMaterial.JUNGLE_WOOD, SMaterial.ACACIA_WOOD, SMaterial.DARK_OAK_WOOD), Arrays.asList(SMaterial.OAK_WOOD_PLANKS, SMaterial.SPRUCE_WOOD_PLANKS, SMaterial.BIRCH_WOOD_PLANKS, SMaterial.JUNGLE_WOOD_PLANKS, SMaterial.ACACIA_WOOD_PLANKS, SMaterial.DARK_OAK_WOOD_PLANKS)));
    protected SItem result;
    protected boolean useExchangeables;

    protected Recipe(SItem result, boolean useExchangeables) {
        this.result = result;
        this.useExchangeables = useExchangeables;
    }

    protected Recipe(SItem result) {
        this(result, false);
    }

    public abstract T setResult(SItem var1);

    public abstract List<MaterialQuantifiable> getIngredients();

    public static Recipe<?> parseRecipe(ItemStack[] stacks) {
        ShapedRecipe shaped = ShapedRecipe.parseShapedRecipe(stacks);
        if (shaped != null) {
            return shaped;
        }
        return ShapelessRecipe.parseShapelessRecipe(stacks);
    }

    protected static MaterialQuantifiable[][] airless(MaterialQuantifiable[][] grid) {
        ArrayList<Integer> excluded = new ArrayList<Integer>(0);
        for (int i2 = 0; i2 < grid.length; ++i2) {
            boolean ex = true;
            for (MaterialQuantifiable material : grid[i2]) {
                if (material.getMaterial() == SMaterial.AIR) continue;
                ex = false;
                break;
            }
            if (!ex) continue;
            excluded.add(i2);
        }
        int amountExcluded = excluded.size();
        MaterialQuantifiable[][] g2 = new MaterialQuantifiable[grid.length - amountExcluded][];
        int b2 = 0;
        for (int i3 = 0; i3 < grid.length; ++i3) {
            if (excluded.contains(i3)) {
                ++b2;
                continue;
            }
            MaterialQuantifiable[] line = grid[i3];
            int remaining = (int)Arrays.stream(line).filter(mat -> mat.getMaterial() != SMaterial.AIR).count();
            g2[i3 - b2] = new MaterialQuantifiable[remaining];
            int r2 = 0;
            for (int j2 = 0; j2 < line.length; ++j2) {
                if (line[j2].getMaterial() == SMaterial.AIR) continue;
                g2[i3 - b2][r2] = line[j2];
                ++r2;
            }
        }
        return g2;
    }

    public static List<SMaterial> getExchangeablesOf(SMaterial material) {
        for (List<SMaterial> materials : EXCHANGEABLES) {
            int f2 = Collections.binarySearch(materials, material);
            if (f2 < 0) continue;
            return materials;
        }
        return null;
    }

    public static void initializeRecipes() {
        Iterator it = Bukkit.recipeIterator();
        while (it.hasNext()) {
            org.bukkit.inventory.Recipe recipe = (org.bukkit.inventory.Recipe)it.next();
            if (recipe.getResult() == null) continue;
            Material result = recipe.getResult().getType();
            if (recipe instanceof org.bukkit.inventory.ShapedRecipe) {
                org.bukkit.inventory.ShapedRecipe shaped = (org.bukkit.inventory.ShapedRecipe)recipe;
                ShapedRecipe specShaped = new ShapedRecipe(SItem.convert(shaped.getResult()), Groups.EXCHANGEABLE_RECIPE_RESULTS.contains(result)).shape(shaped.getShape());
                for (Map.Entry entry : shaped.getIngredientMap().entrySet()) {
                    if (entry.getValue() == null) continue;
                    ItemStack stack = (ItemStack)entry.getValue();
                    specShaped.set(((Character)entry.getKey()).charValue(), SMaterial.getSpecEquivalent(stack.getType(), stack.getDurability()), stack.getAmount());
                }
            }
            if (!(recipe instanceof org.bukkit.inventory.ShapelessRecipe)) continue;
            org.bukkit.inventory.ShapelessRecipe shapeless = (org.bukkit.inventory.ShapelessRecipe)recipe;
            ShapelessRecipe specShapeless = new ShapelessRecipe(SItem.convert(shapeless.getResult()), Groups.EXCHANGEABLE_RECIPE_RESULTS.contains(result));
            for (ItemStack itemStack : shapeless.getIngredientList()) {
                specShapeless.add(SMaterial.getSpecEquivalent(itemStack.getType(), itemStack.getDurability()), itemStack.getAmount());
            }
        }
    }

    public SItem getResult() {
        return this.result;
    }

    public boolean isUseExchangeables() {
        return this.useExchangeables;
    }

    public void setUseExchangeables(boolean useExchangeables) {
        this.useExchangeables = useExchangeables;
    }
}

