/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.event.inventory.ClickType
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package vn.giakhanhvn.skysim.gui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.gui.GUI;
import vn.giakhanhvn.skysim.gui.GUIClickableItem;
import vn.giakhanhvn.skysim.gui.GUIOpenEvent;
import vn.giakhanhvn.skysim.gui.ShopTradingOptionsGUI;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.PaginationList;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.StackArrayList;

public class ShopGUI
extends GUI {
    private static final Map<UUID, StackArrayList<SItem>> BUYBACK_HISTORY = new HashMap<UUID, StackArrayList<SItem>>();
    private static final int[] INTERIOR = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43};
    private final SItem[] items;
    private int page;

    protected ShopGUI(String title, int page, SItem ... items) {
        super(title, 54);
        this.page = page;
        this.items = items;
    }

    protected ShopGUI(String name, SItem ... items) {
        this(name, 1, items);
    }

    @Override
    public void onOpen(GUIOpenEvent e2) {
        final Player player = e2.getPlayer();
        final User user = User.getUser(player.getUniqueId());
        this.border(BLACK_STAINED_GLASS_PANE);
        PaginationList<SItem> paged = new PaginationList<SItem>(28);
        paged.addAll(this.items);
        if (paged.size() == 0) {
            this.page = 0;
        }
        final int finalPage = this.page;
        if (this.page > 1) {
            this.set(new GUIClickableItem(){

                @Override
                public void run(InventoryClickEvent e2) {
                    new ShopGUI(ShopGUI.this.title, finalPage - 1, ShopGUI.this.items).open((Player)e2.getWhoClicked());
                }

                @Override
                public int getSlot() {
                    return 45;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.createNamedItemStack(Material.ARROW, ChatColor.GRAY + "<-");
                }
            });
        }
        if (this.page != paged.getPageCount()) {
            this.set(new GUIClickableItem(){

                @Override
                public void run(InventoryClickEvent e2) {
                    new ShopGUI(ShopGUI.this.title, finalPage + 1, ShopGUI.this.items).open((Player)e2.getWhoClicked());
                }

                @Override
                public int getSlot() {
                    return 53;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.createNamedItemStack(Material.ARROW, ChatColor.GRAY + "->");
                }
            });
        }
        final UUID uuid = player.getUniqueId();
        final StackArrayList<SItem> buyback = BUYBACK_HISTORY.get(uuid);
        this.set(new GUIClickableItem(){

            @Override
            public int getSlot() {
                return 49;
            }

            @Override
            public void run(InventoryClickEvent e2) {
                if (!BUYBACK_HISTORY.containsKey(uuid) || ((StackArrayList)BUYBACK_HISTORY.get(player.getUniqueId())).size() == 0) {
                    return;
                }
                long value = ((SItem)buyback.last()).getType().getStatistics().getValue() * (long)((SItem)buyback.last()).getStack().getAmount();
                if (value > user.getCoins()) {
                    player.sendMessage(ChatColor.RED + "You don't have enough coins!");
                    return;
                }
                HashMap m2 = player.getInventory().addItem(new ItemStack[]{((SItem)buyback.pop()).getStack()});
                if (m2.size() != 0) {
                    player.sendMessage(ChatColor.RED + "Free up inventory space to purchase this!");
                    return;
                }
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.0f, 2.0f);
                user.subCoins(value);
                if (buyback.isEmpty()) {
                    BUYBACK_HISTORY.remove(uuid);
                }
                new ShopGUI(ShopGUI.this.title, ShopGUI.this.page, ShopGUI.this.items).open(player);
            }

            @Override
            public ItemStack getItem() {
                if (!BUYBACK_HISTORY.containsKey(uuid) || ((StackArrayList)BUYBACK_HISTORY.get(player.getUniqueId())).size() == 0) {
                    return SUtil.getStack(ChatColor.GREEN + "Sell Item", Material.HOPPER, (short)0, 1, ChatColor.GRAY + "Click items in your inventory to", ChatColor.GRAY + "sell them to this Shop!");
                }
                SItem last = ((SItem)buyback.last()).clone();
                ItemMeta meta = last.getStack().getItemMeta();
                List lore = meta.getLore();
                lore.add(" ");
                lore.add(ChatColor.GRAY + "Cost");
                long price = last.getType().getStatistics().getValue() * (long)last.getStack().getAmount();
                lore.add(ChatColor.GOLD + SUtil.commaify(price) + " Coin" + (price != 1L ? "s" : ""));
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to buyback!");
                meta.setLore(lore);
                last.getStack().setItemMeta(meta);
                return last.getStack();
            }
        });
        final List p2 = paged.getPage(this.page);
        if (p2 == null) {
            return;
        }
        int i2 = 0;
        while (i2 < p2.size()) {
            final int slot = INTERIOR[i2];
            final SItem item = ((SItem)p2.get(i2)).clone();
            ItemMeta meta = item.getStack().getItemMeta();
            if (item.getStack().getAmount() != 1) {
                meta.setDisplayName(meta.getDisplayName() + ChatColor.DARK_GRAY + " x" + item.getStack().getAmount());
            }
            List lore = meta.getLore();
            lore.add(" ");
            lore.add(ChatColor.GRAY + "Cost");
            final long price = item.getType().getStatistics().getPrice() * (long)item.getStack().getAmount();
            lore.add(ChatColor.GOLD + SUtil.commaify(price) + " Coin" + (price != 1L ? "s" : ""));
            lore.add(" ");
            lore.add(ChatColor.YELLOW + "Click to trade!");
            final SpecificItemType type = item.getType().getStatistics().getSpecificType();
            if (type == null || type.isStackable()) {
                lore.add(ChatColor.YELLOW + "Right-Click for more trading options!");
            }
            meta.setLore(lore);
            item.getStack().setItemMeta(meta);
            final int finalI = i2++;
            this.set(new GUIClickableItem(){

                @Override
                public void run(InventoryClickEvent e2) {
                    if ((type == null || type.isStackable()) && e2.getClick() == ClickType.RIGHT) {
                        new ShopTradingOptionsGUI((SItem)p2.get(finalI), ShopGUI.this).open(player);
                        return;
                    }
                    if (price > user.getCoins()) {
                        player.sendMessage(ChatColor.RED + "You don't have enough coins!");
                        return;
                    }
                    HashMap m2 = player.getInventory().addItem(new ItemStack[]{((SItem)p2.get(finalI)).clone().getStack()});
                    if (m2.size() != 0) {
                        player.sendMessage(ChatColor.RED + "Free up inventory space to purchase this!");
                        return;
                    }
                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.0f, 2.0f);
                    user.subCoins(price);
                }

                @Override
                public int getSlot() {
                    return slot;
                }

                @Override
                public ItemStack getItem() {
                    return item.getStack();
                }
            });
        }
    }

    @Override
    public void onBottomClick(InventoryClickEvent e2) {
        ItemStack current = e2.getCurrentItem();
        if (current == null) {
            return;
        }
        if (current.getType() == Material.AIR) {
            return;
        }
        SItem item = SItem.find(current);
        if (item == null) {
            item = SItem.convert(current);
        }
        e2.setCancelled(true);
        Player player = (Player)e2.getWhoClicked();
        User user = User.getUser(player.getUniqueId());
        StackArrayList<SItem> buyback = BUYBACK_HISTORY.get(player.getUniqueId());
        if (buyback == null) {
            BUYBACK_HISTORY.put(player.getUniqueId(), new StackArrayList());
            buyback = BUYBACK_HISTORY.get(player.getUniqueId());
        }
        buyback.push(item.clone());
        long value = item.getType().getStatistics().getValue() * (long)item.getStack().getAmount();
        user.addCoins(value);
        player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.0f, 2.0f);
        player.sendMessage(ChatColor.GREEN + "You sold " + item.getFullName() + ChatColor.DARK_GRAY + " x" + item.getStack().getAmount() + ChatColor.GREEN + " for " + ChatColor.GOLD + SUtil.commaify(value) + " Coin" + (value != 1L ? "s" : "") + ChatColor.GREEN + "!");
        player.getInventory().setItem(e2.getSlot(), new ItemStack(Material.AIR));
        new ShopGUI(this.title, this.page, this.items).open(player);
    }
}

