/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.event.inventory.InventoryCloseEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.gui.GUI;
import vn.giakhanhvn.skysim.gui.GUIClickableItem;
import vn.giakhanhvn.skysim.gui.GUIOpenEvent;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.Sputnik;

public class DungeonsItemConverting
extends GUI {
    private static final ItemStack DEFAULT_REFORGE_ITEM = SUtil.getStack(ChatColor.RED + "Upgrade Item", Material.ANVIL, (short)0, 1, Sputnik.trans("&7Upgrades items using"), Sputnik.trans("&bBits &7place a weapon or"), Sputnik.trans("&7armor piece above to upgrade it"), Sputnik.trans("&7to a &dDungeon item&7, improving"), Sputnik.trans("&7its stats while in Dungeons. You"), Sputnik.trans("&7can also upgrade an existing"), Sputnik.trans("&7Dungeon item's stats!"));
    private static final ItemStack ANVIL_BARRIER = SUtil.getStack(ChatColor.RED + "Upgrade Item", Material.BARRIER, (short)0, 1, Sputnik.trans("&7Upgrades items using"), Sputnik.trans("&bBits &7place a weapon or"), Sputnik.trans("&7armor piece above to upgrade it"), Sputnik.trans("&7to a &dDungeon item&7, improving"), Sputnik.trans("&7its stats while in Dungeons. You"), Sputnik.trans("&7can also upgrade an existing"), Sputnik.trans("&7Dungeon item's stats!"));
    private static final Map<Rarity, Integer> COST_MAP = new HashMap<Rarity, Integer>();
    private static final List<UUID> COOLDOWN = new ArrayList<UUID>();

    public void fillFrom(Inventory i2, int startFromSlot, int height, ItemStack stacc) {
        i2.setItem(startFromSlot, stacc);
        i2.setItem(startFromSlot + 9, stacc);
        i2.setItem(startFromSlot + 9 + 9, stacc);
        i2.setItem(startFromSlot + 9 + 9 + 9, stacc);
        i2.setItem(startFromSlot + 9 + 9 + 9 + 9, stacc);
        i2.setItem(startFromSlot + 9 + 9 + 9 + 9 + 9, stacc);
    }

    public DungeonsItemConverting() {
        super("Dungeons Crafting", 54);
        this.fill(BLACK_STAINED_GLASS_PANE);
        this.set(GUIClickableItem.getCloseItem(49));
        this.set(13, null);
        this.set(new GUIClickableItem(){

            @Override
            public int getSlot() {
                return 22;
            }

            @Override
            public ItemStack getItem() {
                return DEFAULT_REFORGE_ITEM;
            }

            @Override
            public boolean canPickup() {
                return false;
            }

            @Override
            public void run(InventoryClickEvent e2) {
                SItem sItem = SItem.find(e2.getClickedInventory().getItem(13));
                if (sItem == null) {
                    return;
                }
                Player player = (Player)e2.getWhoClicked();
                if (!sItem.isStarrable()) {
                    player.sendMessage(ChatColor.RED + "That item cannot be upgraded!");
                    player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                    return;
                }
                if (sItem.getStar() >= 5) {
                    player.sendMessage(ChatColor.RED + "That item cannot be upgraded any further!");
                    player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                    return;
                }
                if (e2.getClickedInventory().getItem(31) != null && e2.getClickedInventory().getItem(31).getType() != Material.BARRIER) {
                    long add = (Integer)COST_MAP.get((Object)sItem.getRarity()) * (sItem.getStar() + 1);
                    double cur = User.getUser(player.getUniqueId()).getBits();
                    if (sItem.isStarrable() && sItem.getStar() < 5) {
                        if ((double)add > cur) {
                            player.sendMessage(ChatColor.RED + "You cannot afford to upgrade this.");
                            player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                            return;
                        }
                        player.playSound(player.getLocation(), Sound.ANVIL_USE, 1.0f, 1.0f);
                        User.getUser(player.getUniqueId()).subBits(add);
                        e2.getClickedInventory().setItem(13, null);
                        SItem build = sItem;
                        if (build.isDungeonsItem()) {
                            build.setStarAmount(build.getStar() + 1);
                        } else {
                            build.setDungeonsItem(true);
                            build.setStarAmount(0);
                        }
                        build.setDataString("owner", e2.getWhoClicked().getUniqueId().toString());
                        ItemStack st = User.getUser(e2.getWhoClicked().getUniqueId()).updateItemBoost(build);
                        e2.getClickedInventory().setItem(31, st);
                    } else {
                        player.sendMessage(ChatColor.RED + "You cannot upgrade this item.");
                    }
                }
            }
        });
    }

    @Override
    public void update(final Inventory inventory) {
        new BukkitRunnable(){

            public void run() {
                SItem sItem = SItem.find(inventory.getItem(13));
                if (sItem == null) {
                    inventory.setItem(22, DEFAULT_REFORGE_ITEM);
                    if (SItem.find(inventory.getItem(31)) != null && SItem.find(inventory.getItem(31)).getDataBoolean("dummyItem")) {
                        inventory.setItem(22, DEFAULT_REFORGE_ITEM);
                        inventory.setItem(31, ANVIL_BARRIER);
                    }
                    return;
                }
                if (inventory.getItem(31) == null) {
                    inventory.setItem(22, DEFAULT_REFORGE_ITEM);
                    inventory.setItem(31, ANVIL_BARRIER);
                }
                ItemStack stack = SUtil.getStack(ChatColor.GREEN + "Upgrade Item", Material.ANVIL, (short)0, 1, ChatColor.GRAY + "Upgrades the above items to a", ChatColor.GRAY + sItem.getFullName() + Sputnik.createStarStringFromAmount(sItem.getStar() + 1) + ChatColor.GRAY + "!", ChatColor.GRAY + "This grant an additional " + ChatColor.GREEN + (sItem.getStar() + 1) * 10 + "%", ChatColor.GRAY + "stat boost while in Dungeons!", " ", ChatColor.GRAY + "Cost", ChatColor.AQUA + SUtil.commaify((Integer)COST_MAP.get((Object)sItem.getRarity()) * (sItem.getStar() + 1)) + " Bits", " ", ChatColor.YELLOW + "Click to upgrade!");
                if (!sItem.isDungeonsItem()) {
                    stack = SUtil.getStack(ChatColor.GREEN + "Upgrade Item", Material.ANVIL, (short)0, 1, ChatColor.GRAY + "Converts the above items into a", ChatColor.GRAY + "Dungeon item! This grants the", ChatColor.GRAY + "item a stat boost while in ", ChatColor.GRAY + "Dungeons!", " ", ChatColor.GRAY + "Cost", ChatColor.AQUA + SUtil.commaify((Integer)COST_MAP.get((Object)sItem.getRarity()) * (sItem.getStar() + 1)) + " Bits", " ", ChatColor.YELLOW + "Click to upgrade!");
                }
                ItemStack barrierStack = ANVIL_BARRIER;
                if (!sItem.isStarrable() || sItem.getStar() >= 5) {
                    stack = DEFAULT_REFORGE_ITEM;
                    if (!sItem.isStarrable()) {
                        barrierStack = SUtil.getStack(ChatColor.RED + "Error!", Material.BARRIER, (short)0, 1, ChatColor.GRAY + "This item cannot be upgraded");
                    } else if (sItem.getStar() >= 5) {
                        barrierStack = SUtil.getStack(ChatColor.RED + "Error!", Material.BARRIER, (short)0, 1, ChatColor.GRAY + "This item cannot be upgraded any", ChatColor.GRAY + "further!");
                    }
                } else {
                    SItem build = sItem.clone();
                    if (build.isDungeonsItem()) {
                        build.setStarAmount(build.getStar() + 1);
                    } else {
                        build.setDungeonsItem(true);
                        build.setStarAmount(0);
                    }
                    build.setDataBoolean("dummyItem", true);
                    ItemStack st = build.getStack();
                    if (inventory.getViewers().get(0) != null) {
                        st = User.getUser(((HumanEntity)inventory.getViewers().get(0)).getUniqueId()).updateItemBoost(build);
                        build.setDataString("owner", ((HumanEntity)inventory.getViewers().get(0)).getUniqueId().toString());
                    }
                    ItemMeta mt = build.getStack().getItemMeta();
                    List s2 = mt.getLore();
                    s2.add(" ");
                    s2.add(ChatColor.GRAY + "Cost");
                    s2.add(ChatColor.AQUA + SUtil.commaify((Integer)COST_MAP.get((Object)sItem.getRarity()) * (sItem.getStar() + 1)) + " Bits");
                    s2.add(" ");
                    s2.add(ChatColor.YELLOW + "Click on the item above to");
                    s2.add(ChatColor.YELLOW + "upgrade!");
                    mt.setLore(s2);
                    st.setItemMeta(mt);
                    barrierStack = st;
                }
                inventory.setItem(22, stack);
                inventory.setItem(31, barrierStack);
            }
        }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 1L);
    }

    @Override
    public void onOpen(final GUIOpenEvent e2) {
        new BukkitRunnable(){

            public void run() {
                Player player = e2.getPlayer();
                if (DungeonsItemConverting.this != GUI.GUI_MAP.get(player.getUniqueId())) {
                    this.cancel();
                    return;
                }
                Inventory inventory = e2.getInventory();
                DungeonsItemConverting.this.update(inventory);
                SItem sItem = SItem.find(inventory.getItem(13));
                if (sItem == null) {
                    DungeonsItemConverting.this.fillFrom(inventory, 0, 5, SUtil.createColoredStainedGlassPane((short)14, ChatColor.RESET + " "));
                    DungeonsItemConverting.this.fillFrom(inventory, 8, 5, SUtil.createColoredStainedGlassPane((short)14, ChatColor.RESET + " "));
                    return;
                }
                if (sItem.isStarrable() && sItem.getStar() < 5) {
                    DungeonsItemConverting.this.fillFrom(inventory, 0, 5, SUtil.createColoredStainedGlassPane((short)5, ChatColor.RESET + " "));
                    DungeonsItemConverting.this.fillFrom(inventory, 8, 5, SUtil.createColoredStainedGlassPane((short)5, ChatColor.RESET + " "));
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 5L);
        this.set(new GUIClickableItem(){

            @Override
            public void run(final InventoryClickEvent e2) {
                ItemStack current = e2.getCurrentItem();
                if (current == null) {
                    return;
                }
                if (e2.getCurrentItem().getType() == Material.BARRIER) {
                    e2.setCancelled(true);
                    return;
                }
                final Inventory inventory = e2.getClickedInventory();
                if (!SUtil.isAir(inventory.getItem(13))) {
                    e2.setCancelled(true);
                    e2.getWhoClicked().sendMessage(ChatColor.RED + "Click on the anvil above to upgrade!");
                    return;
                }
                new BukkitRunnable(){

                    public void run() {
                        inventory.setItem(e2.getSlot(), ANVIL_BARRIER);
                    }
                }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 1L);
            }

            @Override
            public int getSlot() {
                return 31;
            }

            @Override
            public boolean canPickup() {
                return true;
            }

            @Override
            public ItemStack getItem() {
                return ANVIL_BARRIER;
            }
        });
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e2) {
        if (!(e2.getPlayer() instanceof Player)) {
            return;
        }
        Player player = (Player)e2.getPlayer();
        GUI gui = GUI.GUI_MAP.get(player.getUniqueId());
        if (gui == null) {
            return;
        }
        gui.onClose(e2);
        GUI.GUI_MAP.remove(player.getUniqueId());
    }

    static {
        COST_MAP.put(Rarity.COMMON, 400);
        COST_MAP.put(Rarity.UNCOMMON, 750);
        COST_MAP.put(Rarity.RARE, 1050);
        COST_MAP.put(Rarity.EPIC, 1470);
        COST_MAP.put(Rarity.LEGENDARY, 1820);
        COST_MAP.put(Rarity.MYTHIC, 2150);
        COST_MAP.put(Rarity.SUPREME, 4100);
        COST_MAP.put(Rarity.SPECIAL, 4600);
        COST_MAP.put(Rarity.VERY_SPECIAL, 7000);
        COST_MAP.put(Rarity.EXCLUSIVE, 100000);
    }
}

