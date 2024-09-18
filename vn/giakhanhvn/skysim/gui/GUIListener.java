/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.block.Action
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.event.inventory.InventoryCloseEvent
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemStack
 */
package vn.giakhanhvn.skysim.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.gui.AnvilGUI;
import vn.giakhanhvn.skysim.gui.BlockBasedGUI;
import vn.giakhanhvn.skysim.gui.CraftingTableGUI;
import vn.giakhanhvn.skysim.gui.DungeonsItemConverting;
import vn.giakhanhvn.skysim.gui.DungeonsLootGUI;
import vn.giakhanhvn.skysim.gui.GUI;
import vn.giakhanhvn.skysim.gui.GUIClickableItem;
import vn.giakhanhvn.skysim.gui.GUIItem;
import vn.giakhanhvn.skysim.gui.GUIOpenEvent;
import vn.giakhanhvn.skysim.gui.GUIQueryItem;
import vn.giakhanhvn.skysim.gui.GUISignItem;
import vn.giakhanhvn.skysim.gui.GUIType;
import vn.giakhanhvn.skysim.gui.QuiverGUI;
import vn.giakhanhvn.skysim.gui.ReforgeAnvilGUI;
import vn.giakhanhvn.skysim.gui.TrashGUI;
import vn.giakhanhvn.skysim.listener.PListener;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SignInput;
import vn.giakhanhvn.skysim.util.Sputnik;

public class GUIListener
extends PListener {
    public static final Map<UUID, GUIQueryItem> QUERY_MAP = new HashMap<UUID, GUIQueryItem>();
    public static final Map<UUID, Boolean> QUERY_MAPPING = new HashMap<UUID, Boolean>();

    @EventHandler
    public void onCloseInv(InventoryCloseEvent e2) {
        Player p2 = (Player)e2.getPlayer();
        User u2 = User.getUser(p2.getUniqueId());
        if (u2 != null && u2.isSaveable()) {
            u2.setSaveable(false);
            u2.updateInventory();
            u2.syncSavingData();
            u2.setSaveable(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e2) {
        GUI gui = GUI.GUI_MAP.get(e2.getWhoClicked().getUniqueId());
        if (gui == null) {
            return;
        }
        if (e2.getClickedInventory() == e2.getView().getTopInventory()) {
            int slot = e2.getSlot();
            gui.onTopClick(e2);
            GUIItem item = gui.get(slot);
            if (item != null) {
                Player player;
                GUIClickableItem query;
                if (!item.canPickup()) {
                    e2.setCancelled(true);
                }
                if (item instanceof GUIClickableItem) {
                    GUIClickableItem clickable = (GUIClickableItem)item;
                    clickable.run(e2);
                }
                if (item instanceof GUIQueryItem) {
                    query = (GUIQueryItem)item;
                    player = (Player)e2.getWhoClicked();
                    QUERY_MAPPING.put(player.getUniqueId(), true);
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "Enter your query:");
                    QUERY_MAP.put(player.getUniqueId(), (GUIQueryItem)query);
                }
                if (item instanceof GUISignItem) {
                    query = (GUISignItem)item;
                    player = (Player)e2.getWhoClicked();
                    SignInput.SIGN_INPUT_QUERY.put(player.getUniqueId(), (GUISignItem)query);
                    new SignInput(player, new String[]{"", "^^^^^^^", "Enter amount", "of Bits"}, 15, ((GUISignItem)query).inti());
                }
            }
        } else {
            gui.onBottomClick(e2);
        }
        gui.update(e2.getView().getTopInventory());
    }

    @EventHandler
    public void onInventoryClickEven(InventoryClickEvent event) {
        ItemStack stack;
        GUI gui = GUI.GUI_MAP.get(event.getWhoClicked().getUniqueId());
        if (!(gui == null || gui.getClass().equals(CraftingTableGUI.class) || gui.getClass().equals(ReforgeAnvilGUI.class) || gui.getClass().equals(AnvilGUI.class) || gui.getClass().equals(QuiverGUI.class) || gui.getClass().equals(TrashGUI.class) || gui.getClass().equals(DungeonsItemConverting.class) || gui.getClass().equals(DungeonsLootGUI.class))) {
            event.setCancelled(true);
        }
        if (gui != null && gui.getClass().equals(QuiverGUI.class) && (stack = event.getCurrentItem()) != null && stack.getType() != Material.ARROW) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onGUIOpen(GUIOpenEvent e2) {
        GUI gui = e2.getOpened();
        e2.getOpened().onOpen(e2);
    }

    @EventHandler
    public void onBlockInteract(PlayerInteractEvent e2) {
        if (e2.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        Block block = e2.getClickedBlock();
        for (GUIType type : GUIType.values()) {
            GUI gui = type.getGUI();
            if (gui == null || !(gui instanceof BlockBasedGUI) || ((BlockBasedGUI)((Object)gui)).getBlock() != block.getType()) continue;
            e2.setCancelled(true);
            gui.open(e2.getPlayer());
            return;
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e2) {
        Player player = e2.getPlayer();
        if (!QUERY_MAP.containsKey(player.getUniqueId())) {
            return;
        }
        e2.setCancelled(true);
        GUIQueryItem item = QUERY_MAP.get(player.getUniqueId());
        player.sendMessage(ChatColor.GOLD + "Querying for: " + e2.getMessage());
        GUI next = item.onQueryFinish(e2.getMessage());
        if (next != null) {
            next.open(player);
        }
        QUERY_MAP.remove(player.getUniqueId());
        QUERY_MAPPING.remove(player.getUniqueId());
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e2) {
        Inventory inventory = e2.getInventory();
        if (!(e2.getPlayer() instanceof Player)) {
            return;
        }
        Player player = (Player)e2.getPlayer();
        GUI gui = GUI.GUI_MAP.get(player.getUniqueId());
        if (gui == null) {
            return;
        }
        if (gui.getClass().equals(CraftingTableGUI.class) || gui.getClass().equals(AnvilGUI.class) || gui.getClass().equals(ReforgeAnvilGUI.class) || gui.getClass().equals(DungeonsItemConverting.class)) {
            if (gui.getClass().equals(AnvilGUI.class)) {
                if (inventory.getItem(29) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(29)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(29));
                    }
                }
                if (inventory.getItem(33) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(33)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(33));
                    }
                }
                if (inventory.getItem(13).getType().toString() != "BARRIER" && inventory.getItem(29) == null && inventory.getItem(33) == null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(13)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(13));
                    }
                }
            }
            if (gui.getClass().equals(ReforgeAnvilGUI.class)) {
                if (player.getInventory().firstEmpty() != -1) {
                    if (inventory.getItem(13) != null) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(13)});
                    }
                } else if (inventory.getItem(13) != null) {
                    player.getWorld().dropItem(player.getLocation(), inventory.getItem(13));
                }
            }
            if (gui.getClass().equals(DungeonsItemConverting.class)) {
                if (inventory.getItem(13) != null) {
                    Sputnik.smartGiveItem(inventory.getItem(13), player);
                } else if (inventory.getItem(31) != null && inventory.getItem(13) == null && inventory.getItem(31).getType() != Material.BARRIER && SItem.find(inventory.getItem(31)) != null && !SItem.find(inventory.getItem(31)).getDataBoolean("dummyItem")) {
                    Sputnik.smartGiveItem(inventory.getItem(31), player);
                }
            }
            if (gui.getClass().equals(CraftingTableGUI.class)) {
                if (inventory.getItem(10) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(10)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(10));
                    }
                }
                if (inventory.getItem(11) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(11)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(11));
                    }
                }
                if (inventory.getItem(12) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(12)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(12));
                    }
                }
                if (inventory.getItem(19) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(19)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(19));
                    }
                }
                if (inventory.getItem(20) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(20)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(20));
                    }
                }
                if (inventory.getItem(21) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(21)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(21));
                    }
                }
                if (inventory.getItem(28) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(28)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(28));
                    }
                }
                if (inventory.getItem(29) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(29)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(29));
                    }
                }
                if (inventory.getItem(30) != null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(30)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(30));
                    }
                }
                if (inventory.getItem(24).getType().toString() != "BARRIER" && inventory.getItem(10) == null && inventory.getItem(11) == null && inventory.getItem(12) == null && inventory.getItem(19) == null && inventory.getItem(20) == null && inventory.getItem(21) == null && inventory.getItem(28) == null && inventory.getItem(29) == null && inventory.getItem(30) == null) {
                    if (player.getInventory().firstEmpty() != -1) {
                        player.getInventory().addItem(new ItemStack[]{inventory.getItem(24)});
                    } else {
                        player.getWorld().dropItem(player.getLocation(), inventory.getItem(24));
                    }
                }
            }
        }
        GUI.GUI_MAP.remove(player.getUniqueId());
        if (QUERY_MAPPING.containsKey(player.getUniqueId()) && QUERY_MAPPING.get(player.getUniqueId()).booleanValue()) {
            return;
        }
        if (User.getUser(player.getUniqueId()) != null && User.getUser(player.getUniqueId()).isWaitingForSign()) {
            return;
        }
        gui.onClose(e2);
    }
}

