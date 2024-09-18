/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.command.CommandParameters;
import vn.giakhanhvn.skysim.command.CommandSource;
import vn.giakhanhvn.skysim.command.SCommand;
import vn.giakhanhvn.skysim.features.enchantment.EnchantmentType;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.util.Sputnik;

@CommandParameters(description="", aliases="purc", permission="sse.cc")
public class BuyBookCommand
extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (player.isOp()) {
            EnchantmentType type = EnchantmentType.getByNamespace(args[0]);
            if (type == null) {
                this.send(ChatColor.RED + "Something wrong, contact admins!");
                return;
            }
            int i2 = Integer.parseInt(args[1]);
            SItem eBook = SItem.of(SMaterial.ENCHANTED_BOOK);
            eBook.addEnchantment(type, i2);
            Sputnik.smartGiveItem(eBook.getStack(), player);
        } else {
            this.send(ChatColor.RED + "Unknown Command.");
        }
    }
}

