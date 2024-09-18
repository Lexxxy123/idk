/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.entity.Player
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.InventoryView
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.gui;

import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.gui.GUI;
import vn.giakhanhvn.skysim.gui.GUIClickableItem;
import vn.giakhanhvn.skysim.gui.GUIOpenEvent;
import vn.giakhanhvn.skysim.gui.GUIType;
import vn.giakhanhvn.skysim.user.PlayerUtils;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.Sputnik;

public class CookieGUI
extends GUI {
    public CookieGUI(String query, int page) {
        super("Booster Cookie", 36);
        this.fill(BLACK_STAINED_GLASS_PANE);
    }

    @Override
    public void onOpen(GUIOpenEvent e2) {
        final Player player = e2.getPlayer();
        User user = User.getUser(player.getUniqueId());
        String text_ = "&7Status";
        if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
            text_ = "&7Duration";
        }
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                GUIType.SKYBLOCK_MENU.getGUI().open((Player)e2.getWhoClicked());
            }

            @Override
            public int getSlot() {
                return 31;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(Sputnik.trans("&aGo Back"), Material.ARROW, (short)0, 1, ChatColor.GRAY + "To SkySim Menu");
            }
        });
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    GUIType.ANVIL.getGUI().open((Player)e2.getWhoClicked());
                } else {
                    ((Player)e2.getWhoClicked()).playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                    e2.getWhoClicked().sendMessage(Sputnik.trans("&cYou need the Cookie Buff active to use this feature!"));
                }
            }

            @Override
            public int getSlot() {
                return 30;
            }

            @Override
            public ItemStack getItem() {
                String text = "&cRequires Cookie Buff!";
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    text = "&eClick to check it out!";
                }
                return SUtil.getStack(Sputnik.trans("&6Anvil"), Material.ANVIL, (short)0, 1, ChatColor.DARK_GRAY + "/av", "", ChatColor.GRAY + "Access an Anvil from anywhere in", ChatColor.GRAY + "SkySim SkyBlock.", "", Sputnik.trans(text));
            }
        });
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    e2.getWhoClicked().sendMessage(ChatColor.RED + "Disabled bruh.");
                } else {
                    ((Player)e2.getWhoClicked()).playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                    e2.getWhoClicked().sendMessage(Sputnik.trans("&cYou need the Cookie Buff active to use this feature!"));
                }
            }

            @Override
            public int getSlot() {
                return 32;
            }

            @Override
            public ItemStack getItem() {
                String text = "&cRequires Cookie Buff!";
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    text = "&eClick to check it out!";
                }
                return SUtil.getStack(Sputnik.trans("&6Auction House"), Material.GOLD_BARDING, (short)0, 1, ChatColor.DARK_GRAY + "/auh", "", ChatColor.GRAY + "Access the Auction House menu", ChatColor.GRAY + "from anywhere in SkySim SkyBlock.", "", Sputnik.trans(text));
            }
        });
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    GUIType.TRASH.getGUI().open((Player)e2.getWhoClicked());
                } else {
                    ((Player)e2.getWhoClicked()).playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                    e2.getWhoClicked().sendMessage(Sputnik.trans("&cYou need the Cookie Buff active to use this feature!"));
                }
            }

            @Override
            public int getSlot() {
                return 33;
            }

            @Override
            public ItemStack getItem() {
                String text = "&cRequires Cookie Buff!";
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    text = "&eClick to open!";
                }
                return SUtil.getStack(Sputnik.trans("&6Trash Bin"), Material.CAULDRON_ITEM, (short)0, 1, ChatColor.DARK_GRAY + "/bin", "", ChatColor.GRAY + "Access your personal Trash Bin", ChatColor.GRAY + "from anywhere in SkySim SkyBlock.", "", Sputnik.trans(text));
            }
        });
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    GUIType.FARM_MERCHANT.getGUI().open((Player)e2.getWhoClicked());
                } else {
                    ((Player)e2.getWhoClicked()).playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                    e2.getWhoClicked().sendMessage(Sputnik.trans("&cYou need the Cookie Buff active to use this feature!"));
                }
            }

            @Override
            public int getSlot() {
                return 29;
            }

            @Override
            public ItemStack getItem() {
                String text = "&cRequires Cookie Buff!";
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    text = "&eClick to open!";
                }
                return SUtil.getStack(Sputnik.trans("&6Farm Merchant"), Material.APPLE, (short)0, 1, ChatColor.DARK_GRAY + "/fm", "", ChatColor.GRAY + "Access the Farm Merchant menu", ChatColor.GRAY + "from anywhere in SkySim SkyBlock.", "", Sputnik.trans(text));
            }
        });
        this.set(11, SUtil.enchant(SUtil.getStack(ChatColor.GOLD + "Booster Cookie", Material.COOKIE, (short)0, 1, ChatColor.GRAY + "Aquire booster cookies from", ChatColor.GRAY + "the community shop in the hub.", "", Sputnik.trans("&dCookie Buff:"), Sputnik.trans("&8\u25b6 &b+35% &7Bonus Combat XP"), Sputnik.trans("&8\u25b6 &b+30\u272f &7Bonus Magic Find"), Sputnik.trans("&8\u25b6 &c+100\u2741 &7Bonus Strength"), Sputnik.trans("&8\u25b6 &a+200\u2748 &7Bonus Defense"), Sputnik.trans("&8\u25b6 &9+25\u2620 &7Bonus Crit Damage"), Sputnik.trans("&8\u25b6 &c+35\u2afd &7Bonus Ferocity"), Sputnik.trans("&8\u25b6 &b+2000\u270e &7Bonus Intelligence"), Sputnik.trans("&8\u25b6 &7Keep &6coins &7and &deffects &7on death"), Sputnik.trans("&8\u25b6 &7Access to &6/auh &7and &6/fm"), Sputnik.trans("&8\u25b6 &7Access to &6/av &7and &6/bin &7(Trash Bin)"), Sputnik.trans("&8\u25b6 &7A shiny &e\u272a &6Badge &7on your &aname tag."), "", Sputnik.trans("&7" + text_ + ": " + PlayerUtils.getCookieDurationDisplayGUI(player)), "", Sputnik.trans("&8NOTE: All effects listed above given"), Sputnik.trans("&8by the cookie will NOT stack!"))));
        this.set(13, SUtil.getStack(ChatColor.AQUA + "Bits", Material.DIAMOND, (short)0, 1, ChatColor.GRAY + "You can earn Bits from killing", ChatColor.GRAY + "mobs with melee weapons. Only.", "", Sputnik.trans("&7Bits Purse: &b" + User.of(player).getBits()), "", Sputnik.trans("&8Bits can be used to purchase Booster"), Sputnik.trans("&8Cookie and various items in the Community"), Sputnik.trans("&8Shop.")));
        this.set(15, SUtil.enchant(SUtil.getStack(ChatColor.GOLD + "Fame Rank", Material.GOLD_HELMET, (short)0, 1, ChatColor.GRAY + "This feature is not available.", "", "" + ChatColor.RED + ChatColor.BOLD + "NOT COMING SOON!", "", Sputnik.trans("&8Not planned release."))));
        new BukkitRunnable(){

            public void run() {
                String text_ = "&7Status";
                if (PlayerUtils.getCookieDurationTicks(player) > 0L) {
                    text_ = "&7Duration";
                }
                if (CookieGUI.this != GUI.GUI_MAP.get(player.getUniqueId())) {
                    this.cancel();
                    return;
                }
                InventoryView stackInventory = player.getOpenInventory();
                ItemStack craftStack = stackInventory.getItem(11);
                ItemMeta meta = craftStack.getItemMeta();
                meta.setLore(Arrays.asList(ChatColor.GRAY + "Aquire booster cookies from", ChatColor.GRAY + "the community shop in the hub.", "", Sputnik.trans("&dCookie Buff:"), Sputnik.trans("&8\u25b6 &b+35% &7Bonus Combat XP"), Sputnik.trans("&8\u25b6 &b+30\u272f &7Bonus Magic Find"), Sputnik.trans("&8\u25b6 &c+100\u2741 &7Bonus Strength"), Sputnik.trans("&8\u25b6 &a+200\u2748 &7Bonus Defense"), Sputnik.trans("&8\u25b6 &9+25\u2620 &7Bonus Crit Damage"), Sputnik.trans("&8\u25b6 &c+35\u2afd &7Bonus Ferocity"), Sputnik.trans("&8\u25b6 &b+2000\u270e &7Bonus Intelligence"), Sputnik.trans("&8\u25b6 &7Keep &6coins &7and &deffects &7on death"), Sputnik.trans("&8\u25b6 &7Access to &6/auh &7and &6/fm"), Sputnik.trans("&8\u25b6 &7Access to &6/av &7and &6/bin &7(Trash Bin)"), Sputnik.trans("&8\u25b6 &7A shiny &e\u272a &6Badge &7on your &aname tag."), "", Sputnik.trans("&7" + text_ + ": " + PlayerUtils.getCookieDurationDisplayGUI(player)), "", Sputnik.trans("&8NOTE: All effects listed above given"), Sputnik.trans("&8by the cookie will NOT stack!")));
                craftStack.setItemMeta(meta);
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 20L);
    }

    public CookieGUI(String query) {
        this(query, 1);
    }

    public CookieGUI(int page) {
        this("", page);
    }

    public CookieGUI() {
        this(1);
    }
}

