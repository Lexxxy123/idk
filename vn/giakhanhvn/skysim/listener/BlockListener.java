/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.block.Block
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.player.PlayerInteractEvent
 */
package vn.giakhanhvn.skysim.listener;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import vn.giakhanhvn.skysim.command.RegionCommand;
import vn.giakhanhvn.skysim.features.region.Region;
import vn.giakhanhvn.skysim.features.region.RegionGenerator;
import vn.giakhanhvn.skysim.listener.PListener;

public class BlockListener
extends PListener {
    @EventHandler
    public void onBlockInteract(PlayerInteractEvent e2) {
        Block block = e2.getClickedBlock();
        if (block == null) {
            return;
        }
        Player player = e2.getPlayer();
        if (!RegionCommand.REGION_GENERATION_MAP.containsKey(player)) {
            return;
        }
        e2.setCancelled(true);
        RegionGenerator generator = RegionCommand.REGION_GENERATION_MAP.get(player);
        switch (generator.getPhase()) {
            case 1: {
                generator.setFirstLocation(block.getLocation());
                generator.setPhase(2);
                player.sendMessage(ChatColor.GRAY + "Set your clicked block as the first location of the region!");
                player.sendMessage(ChatColor.DARK_AQUA + "Click the second corner of your region.");
                break;
            }
            case 2: {
                generator.setSecondLocation(block.getLocation());
                if (generator.getModificationType().equals("create")) {
                    Region.create(generator.getName(), generator.getFirstLocation(), generator.getSecondLocation(), generator.getType());
                } else {
                    Region region = Region.get(generator.getName());
                    region.setFirstLocation(generator.getFirstLocation());
                    region.setSecondLocation(generator.getSecondLocation());
                    region.setType(generator.getType());
                    region.save();
                }
                player.sendMessage(ChatColor.GRAY + "Region \"" + generator.getName() + "\" has been fully set up and " + generator.getModificationType() + "d!");
                RegionCommand.REGION_GENERATION_MAP.remove(player);
            }
        }
    }
}

