/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.command;

import vn.giakhanhvn.skysim.command.CommandParameters;
import vn.giakhanhvn.skysim.command.CommandSource;
import vn.giakhanhvn.skysim.command.SCommand;

@CommandParameters(description="Modify your coin amount.", usage="/<command> <auction uuid/player name>", aliases="su")
public class AuctionHouseCommand
extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
    }
}

