/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package vn.giakhanhvn.skysim.command;

import org.bukkit.ChatColor;

public class CommandPermissionException
extends RuntimeException {
    public CommandPermissionException(String permission) {
        super(ChatColor.RED + "No permission. You need \"" + permission + "\"");
    }
}

