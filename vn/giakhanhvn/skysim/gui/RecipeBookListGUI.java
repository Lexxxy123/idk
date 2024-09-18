/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.ItemStack
 */
package vn.giakhanhvn.skysim.gui;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.ShapedRecipe;
import vn.giakhanhvn.skysim.gui.GUI;
import vn.giakhanhvn.skysim.gui.GUIClickableItem;
import vn.giakhanhvn.skysim.gui.GUIOpenEvent;
import vn.giakhanhvn.skysim.gui.GUIType;
import vn.giakhanhvn.skysim.gui.RecipeBookGUI;
import vn.giakhanhvn.skysim.util.PaginationList;
import vn.giakhanhvn.skysim.util.SUtil;

public class RecipeBookListGUI
extends GUI {
    private static final int[] INTERIOR = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43};

    public RecipeBookListGUI(String query, int page) {
        super("Recipe Book", 54);
        this.border(BLACK_STAINED_GLASS_PANE);
        PaginationList pagedMaterials = new PaginationList(28);
        for (ShapedRecipe sr : ShapedRecipe.CACHED_RECIPES) {
            String lc = sr.getResult().getType().toString().toLowerCase();
            if (!lc.contains("hidden") && !lc.contains("enchanted_book")) continue;
            pagedMaterials.add(sr.getResult());
        }
        if (pagedMaterials.size() == 0) {
            page = 0;
        }
        this.title = "Recipe Book (" + page + "/" + pagedMaterials.getPageCount() + ")";
        final int finalPage = page;
        if (page > 1) {
            this.set(new GUIClickableItem(){

                @Override
                public void run(InventoryClickEvent e2) {
                    new RecipeBookListGUI(finalPage - 1).open((Player)e2.getWhoClicked());
                    ((Player)e2.getWhoClicked()).playSound(e2.getWhoClicked().getLocation(), Sound.NOTE_PIANO, 1.0f, 1.0f);
                }

                @Override
                public int getSlot() {
                    return 45;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.createNamedItemStack(Material.ARROW, ChatColor.GRAY + "Pervious Page");
                }
            });
        }
        if (page != pagedMaterials.getPageCount()) {
            this.set(new GUIClickableItem(){

                @Override
                public void run(InventoryClickEvent e2) {
                    new RecipeBookListGUI(finalPage + 1).open((Player)e2.getWhoClicked());
                    ((Player)e2.getWhoClicked()).playSound(e2.getWhoClicked().getLocation(), Sound.NOTE_PIANO, 1.0f, 1.0f);
                }

                @Override
                public int getSlot() {
                    return 53;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.createNamedItemStack(Material.ARROW, ChatColor.GRAY + "Next Page");
                }
            });
        }
        this.set(GUIClickableItem.getCloseItem(49));
        List p2 = pagedMaterials.getPage(page);
        if (p2 == null) {
            return;
        }
        for (int i2 = 0; i2 < p2.size(); ++i2) {
            final int slot = INTERIOR[i2];
            final SItem sItem = (SItem)p2.get(i2);
            this.set(new GUIClickableItem(){

                @Override
                public void run(InventoryClickEvent e2) {
                    Player player = (Player)e2.getWhoClicked();
                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.0f, 2.0f);
                    new RecipeBookGUI(sItem).open(player);
                }

                @Override
                public int getSlot() {
                    return slot;
                }

                @Override
                public ItemStack getItem() {
                    return sItem.getStack();
                }
            });
        }
    }

    @Override
    public void onOpen(GUIOpenEvent e2) {
        Player player = e2.getPlayer();
        this.set(GUIClickableItem.createGUIOpenerItem(GUIType.SKYBLOCK_MENU, player, ChatColor.GREEN + "Go Back", 48, Material.ARROW, ChatColor.GRAY + "To SkySim Menu"));
    }

    public RecipeBookListGUI(String query) {
        this(query, 1);
    }

    public RecipeBookListGUI(int page) {
        this("", page);
    }

    public RecipeBookListGUI() {
        this(1);
    }
}

