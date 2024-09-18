/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.command;

import vn.giakhanhvn.skysim.command.CommandParameters;
import vn.giakhanhvn.skysim.command.CommandSource;
import vn.giakhanhvn.skysim.command.SCommand;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.user.UserStash;

@CommandParameters(description="Adds an enchantment from Spec to the specified item.", aliases="pickupstash", permission="spt.item")
public class PickupStashCommand
extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (sender.getPlayer() == null) {
            this.send("&cPoor you, but console can't stash items away, do they even... exist?");
            return;
        }
        User u2 = User.getUser(sender.getPlayer().getUniqueId());
        if (u2 != null) {
            UserStash us = UserStash.getStash(u2.getUuid());
            us.pickUpStash();
        }
    }
}

