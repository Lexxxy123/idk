/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.inventory.ItemStack
 */
package vn.giakhanhvn.skysim.gui;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import vn.giakhanhvn.skysim.gui.GUI;
import vn.giakhanhvn.skysim.gui.GUIClickableItem;
import vn.giakhanhvn.skysim.gui.GUIOpenEvent;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.Sputnik;

public class ConfirmWitherRuins
extends GUI {
    public ConfirmWitherRuins() {
        super("Travel to the Withering Ruins?", 27);
        this.fill(BLACK_STAINED_GLASS_PANE);
    }

    @Override
    public void onOpen(GUIOpenEvent e2) {
        final Player player = e2.getPlayer();
        User user = User.getUser(player.getUniqueId());
        this.set(new GUIClickableItem(){

            @Override
            public void run(InventoryClickEvent e2) {
                Player p2 = (Player)e2.getWhoClicked();
                if (User.of(p2).subBits(2000L)) {
                    p2.sendMessage(Sputnik.trans("&eYou have travelled to the &cWithering Ruins&e!"));
                    p2.teleport(new Location(Bukkit.getWorld((String)"arena"), 234744.5, 158.0, 236558.5, 135.0f, 0.0f));
                } else {
                    p2.sendMessage(Sputnik.trans("&cYou cannot afford for this ride!"));
                }
            }

            @Override
            public int getSlot() {
                return 13;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(Sputnik.trans("&aTravel to: &cWithering Ruins"), Material.MINECART, (short)0, 1, Sputnik.trans("&7Following &dArlly &7rails and travel into"), Sputnik.trans("&7a mysterious place under the &eGiants Island"), Sputnik.trans("&cBe Careful! &4Something, is there..."), Sputnik.trans("&7"), Sputnik.trans("&7Cost for a Minecart Ride"), Sputnik.trans("&b2,000 Bits"), Sputnik.trans("&7"), Sputnik.trans((double)User.of(player).getBits() >= 2000.0 ? "&eClick to travel" : "&cYou cannot afford this!"));
            }
        });
    }
}

