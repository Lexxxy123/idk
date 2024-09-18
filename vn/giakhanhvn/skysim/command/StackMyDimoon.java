/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.ItemStack
 */
package vn.giakhanhvn.skysim.command;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import vn.giakhanhvn.skysim.command.CommandParameters;
import vn.giakhanhvn.skysim.command.CommandSource;
import vn.giakhanhvn.skysim.command.SCommand;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.util.Sputnik;

@CommandParameters(description="", aliases="smd", permission="sse.cc")
public class StackMyDimoon
extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        int stg = 0;
        Player player = sender.getPlayer();
        ItemStack[] iss = player.getInventory().getContents();
        for (int i2 = 0; i2 < player.getInventory().getContents().length; ++i2) {
            ItemStack is = iss[i2];
            if (SItem.find(is) == null || SItem.find(is).getType() != SMaterial.HIDDEN_DIMOON_FRAG) continue;
            stg += is.getAmount();
            player.getInventory().setItem(i2, null);
        }
        if (stg > 0) {
            ItemStack is2 = SItem.of(SMaterial.HIDDEN_DIMOON_FRAG).getStack();
            is2.setAmount(stg);
            Sputnik.smartGiveItem(is2, player);
            player.sendMessage(Sputnik.trans("&aStacked all your fragments which have been broken before! Have fun!"));
        }
    }
}

