/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package vn.giakhanhvn.skysim.gui;

import java.util.ArrayList;
import java.util.Collections;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import vn.giakhanhvn.skysim.features.auction.AuctionEscrow;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.gui.AuctionConfirmGUI;
import vn.giakhanhvn.skysim.gui.AuctionDurationGUI;
import vn.giakhanhvn.skysim.gui.GUI;
import vn.giakhanhvn.skysim.gui.GUIClickableItem;
import vn.giakhanhvn.skysim.gui.GUIOpenEvent;
import vn.giakhanhvn.skysim.gui.GUIQueryItem;
import vn.giakhanhvn.skysim.gui.GUIType;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SUtil;

public class CreateAuctionGUI
extends GUI {
    private CreateAuctionGUI(String title) {
        super(title, 54);
        this.fill(BLACK_STAINED_GLASS_PANE);
    }

    public CreateAuctionGUI() {
        this("Create Auction");
    }

    @Override
    public void early(Player player) {
        User user = User.getUser(player.getUniqueId());
        if (user.isAuctionCreationBIN()) {
            this.title = "Create BIN Auction";
        }
    }

    @Override
    public void onOpen(GUIOpenEvent e2) {
        final Player player = e2.getPlayer();
        final User user = User.getUser(player.getUniqueId());
        final boolean bin = user.isAuctionCreationBIN();
        this.set(GUIClickableItem.createGUIOpenerItem(GUIType.AUCTION_HOUSE, player, ChatColor.GREEN + "Go Back", 49, Material.ARROW, ChatColor.GRAY + "To Auction House"));
        final AuctionEscrow escrow = user.getAuctionEscrow();
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                if (user.getAuctionEscrow().getItem() == null) {
                    return;
                }
                player.getInventory().addItem(new ItemStack[]{user.getAuctionEscrow().getItem().getStack()});
                user.getAuctionEscrow().setItem(null);
                new CreateAuctionGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 13;
            }

            @Override
            public ItemStack getItem() {
                if (user.getAuctionEscrow().getItem() != null) {
                    SItem display = user.getAuctionEscrow().getItem().clone();
                    ItemMeta meta = display.getStack().getItemMeta();
                    meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + ChatColor.UNDERLINE + "AUCTION FOR ITEM:");
                    ArrayList<String> lore = new ArrayList<String>(Collections.singletonList(" "));
                    lore.add(ChatColor.GRAY + "" + display.getStack().getAmount() + "x " + escrow.getItem().getFullName());
                    lore.add(display.getRarity().getDisplay());
                    lore.add(" ");
                    lore.add(ChatColor.YELLOW + "Click to pickup!");
                    meta.setLore(lore);
                    display.getStack().setItemMeta(meta);
                    return display.getStack();
                }
                return SUtil.getStack(ChatColor.YELLOW + "Click an item in your inventory!", Material.STONE_BUTTON, (short)0, 1, ChatColor.GRAY + "Selects it for auction");
            }
        });
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                if (escrow.getItem() == null) {
                    return;
                }
                if (user.getCoins() < escrow.getCreationFee(bin)) {
                    player.sendMessage(ChatColor.RED + "You don't have enough coins to afford this!");
                    return;
                }
                new AuctionConfirmGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 29;
            }

            @Override
            public ItemStack getItem() {
                ArrayList<String> lore = new ArrayList<String>();
                if (escrow.getItem() == null) {
                    lore.add(ChatColor.GRAY + "No item selected!");
                    lore.add(" ");
                    lore.add(ChatColor.GRAY + "Click an item in your");
                    lore.add(ChatColor.GRAY + "inventory to select it for");
                    lore.add(ChatColor.GRAY + "this auction.");
                } else {
                    lore.add(ChatColor.GRAY + "This item will be added to");
                    lore.add(ChatColor.GRAY + "the auction house for other");
                    lore.add(ChatColor.GRAY + "players to purchase.");
                    lore.add(" ");
                    lore.add(ChatColor.GRAY + "Item: " + escrow.getItem().getStack().getAmount() + "x " + escrow.getItem().getFullName());
                    lore.add(ChatColor.GRAY + "Auction duration: " + ChatColor.YELLOW + SUtil.getAuctionSetupFormattedTime(escrow.getDuration()));
                    lore.add(ChatColor.GRAY + "Starting bid: " + ChatColor.GOLD + SUtil.commaify(escrow.getStarter()) + " coins");
                    lore.add(" ");
                    lore.add(ChatColor.GRAY + "Creation fee: " + ChatColor.GOLD + SUtil.commaify(escrow.getCreationFee(user.isAuctionCreationBIN())) + " coins");
                    lore.add(" ");
                    lore.add(ChatColor.YELLOW + "Click to submit!");
                }
                return SUtil.getStack((escrow.getItem() != null ? ChatColor.GREEN : ChatColor.RED) + "Create Auction", Material.STAINED_CLAY, escrow.getItem() != null ? (short)13 : 14, 1, lore);
            }
        });
        this.set(new GUIQueryItem(){

            @Override
            public GUI onQueryFinish(String query) {
                long l2;
                try {
                    l2 = Long.parseLong(query);
                    if (l2 <= 0L) {
                        player.sendMessage(ChatColor.RED + "Could not read this number!");
                        return null;
                    }
                } catch (NumberFormatException ex) {
                    player.sendMessage(ChatColor.RED + "Could not read this number!");
                    return null;
                }
                user.getAuctionEscrow().setStarter(l2);
                return new CreateAuctionGUI();
            }

            @Override
            public void run(InventoryClickEvent e2) {
            }

            @Override
            public int getSlot() {
                return 31;
            }

            @Override
            public ItemStack getItem() {
                ArrayList<String> lore = new ArrayList<String>();
                if (bin) {
                    lore.add(ChatColor.GRAY + "The price at which you want");
                    lore.add(ChatColor.GRAY + "to sell this item.");
                } else {
                    lore.add(ChatColor.GRAY + "The minimum price a player");
                    lore.add(ChatColor.GRAY + "can offer to obtain your");
                    lore.add(ChatColor.GRAY + "item.");
                    lore.add(" ");
                    lore.add(ChatColor.GRAY + "Once a player bids for your");
                    lore.add(ChatColor.GRAY + "item, other players will");
                    lore.add(ChatColor.GRAY + "have until the auction ends");
                    lore.add(ChatColor.GRAY + "to make a higher bid.");
                }
                lore.add(" ");
                lore.add(ChatColor.GRAY + "Extra fee: " + ChatColor.GOLD + "+" + SUtil.commaify(escrow.getCreationFee(user.isAuctionCreationBIN())) + " coins " + ChatColor.YELLOW + "(" + (bin ? 1 : 5) + "%)");
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to edit!");
                return SUtil.getStack(ChatColor.WHITE + (bin ? "Item price: " : "Starting bid: ") + ChatColor.GOLD + SUtil.commaify(escrow.getStarter()) + " coins", bin ? Material.GOLD_INGOT : Material.POWERED_RAIL, (short)0, 1, lore);
            }
        });
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                new AuctionDurationGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 33;
            }

            @Override
            public ItemStack getItem() {
                ArrayList<String> lore = new ArrayList<String>();
                if (bin) {
                    lore.add(ChatColor.GRAY + "How long the item will be");
                    lore.add(ChatColor.GRAY + "up for sale.");
                } else {
                    lore.add(ChatColor.GRAY + "How long players will be");
                    lore.add(ChatColor.GRAY + "able to place bids for.");
                    lore.add(" ");
                    lore.add(ChatColor.GRAY + "Note: Bids automatically");
                    lore.add(ChatColor.GRAY + "increase the duration of");
                    lore.add(ChatColor.GRAY + "auctions.");
                }
                lore.add(" ");
                lore.add(ChatColor.YELLOW + "Click to edit!");
                return SUtil.getStack(ChatColor.WHITE + "Duration: " + ChatColor.YELLOW + SUtil.getAuctionSetupFormattedTime(escrow.getDuration()), Material.WATCH, (short)0, 1, lore);
            }
        });
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                user.setAuctionCreationBIN(!user.isAuctionCreationBIN());
                new CreateAuctionGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 48;
            }

            @Override
            public ItemStack getItem() {
                if (bin) {
                    return SUtil.getStack(ChatColor.GREEN + "Click to Auction", Material.POWERED_RAIL, (short)0, 1, ChatColor.GRAY + "With traditional auctions,", ChatColor.GRAY + "multiple buyers compete for the", ChatColor.GRAY + "item by bidding turn by turn.", " ", ChatColor.YELLOW + "Click to switch!");
                }
                return SUtil.getStack(ChatColor.GREEN + "Switch to BIN", Material.GOLD_INGOT, (short)0, 1, ChatColor.GRAY + "BIN Auctions are simple.", " ", ChatColor.GRAY + "Set a price, then one player may", ChatColor.GRAY + "buy the item at that price.", " ", ChatColor.DARK_GRAY + "(BIN means Buy It Now)", " ", ChatColor.YELLOW + "Click to switch!");
            }
        });
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
        if (current.getType() == Material.NETHER_STAR) {
            return;
        }
        SItem item = SItem.find(current);
        if (item == null) {
            item = SItem.convert(current);
        }
        e2.setCancelled(true);
        Player player = (Player)e2.getWhoClicked();
        User user = User.getUser(player.getUniqueId());
        if (user.getAuctionEscrow().getItem() != null) {
            return;
        }
        user.getAuctionEscrow().setItem(item);
        player.getInventory().setItem(e2.getSlot(), new ItemStack(Material.AIR));
        new CreateAuctionGUI().open(player);
    }
}

