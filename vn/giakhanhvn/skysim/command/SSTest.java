/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.command;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.command.CommandParameters;
import vn.giakhanhvn.skysim.command.CommandSource;
import vn.giakhanhvn.skysim.command.SCommand;
import vn.giakhanhvn.skysim.extra.protocol.PacketInvoker;
import vn.giakhanhvn.skysim.features.dungeons.BlessingType;
import vn.giakhanhvn.skysim.features.dungeons.Blessings;
import vn.giakhanhvn.skysim.features.dungeons.ItemSerial;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.Watcher;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.gui.ConfirmWitherRuins;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.user.UserStash;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.Sputnik;

@CommandParameters(description="Modify your absorption amount.", permission="spt.player")
public class SSTest
extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (player.isOp()) {
            if (args[0].contains("sp")) {
                player.sendMessage(ChatColor.YELLOW + "Intizing Map...");
                long s2 = System.currentTimeMillis();
                Watcher w2 = new Watcher(new Location(player.getWorld(), 96.0, 99.0, 96.0), new Location(player.getWorld(), 126.0, 66.0, 126.0), 69);
                w2.intitize();
                long s_ = System.currentTimeMillis() - s2;
                player.sendMessage(ChatColor.GREEN + "All actions completed (Loop, placing heads, spawn Watcher)! This took " + ChatColor.YELLOW + s_ + "ms");
            } else if (args[0].contains("pl")) {
                player.sendMessage(ChatColor.YELLOW + "Done!");
                for (Entity e2 : player.getWorld().getEntities()) {
                    if (!(e2 instanceof ArmorStand) || !e2.hasMetadata("WATCHER_ENTITY")) continue;
                    e2.getLocation().add(0.0, 1.7, 0.0).getBlock().setTypeIdAndData(35, (byte)4, true);
                }
            } else if (args[0].contains("test")) {
                ItemSerial is = ItemSerial.createBlank();
                if (player.getItemInHand() != null) {
                    SItem sitem = SItem.find(player.getItemInHand());
                    is.saveTo(sitem);
                    sitem.setStarAmount(5);
                }
            } else if (!args[0].contains("wipe")) {
                if (args[0].contains("vlw")) {
                    PacketInvoker.dropVoidSpawner(player, player.getLocation());
                } else if (args[0].contains("bung")) {
                    SkySimEngine.getPlugin().updateServerName(player);
                } else if (args[0].contains("putitemstash")) {
                    if (player.getItemInHand() != null) {
                        if (player.getItemInHand().getType() == Material.AIR) {
                            return;
                        }
                        UserStash.getStash(player.getUniqueId()).addItemInStash(player.getItemInHand());
                        player.setItemInHand(null);
                    }
                } else if (args[0].contains("bs")) {
                    Blessings.dropBlessingPickable(player.getLocation().clone().add(2.0, 0.0, 2.0), new Blessings(BlessingType.valueOf(args[1]), Integer.parseInt(args[2]), player.getWorld()));
                } else if (args[0].contains("blessshow")) {
                    for (Blessings b2 : Blessings.getFrom(player.getWorld())) {
                        player.sendMessage(ChatColor.YELLOW + b2.toText());
                        float[] n2 = b2.getBlessingStats(User.getUser(player.getUniqueId())).getDefaultArray();
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < n2.length; ++i2) {
                            sb.append(n2[i2] + " ");
                        }
                        player.sendMessage(ChatColor.RED + sb.toString());
                    }
                } else if (args[0].contains("rs")) {
                    Blessings.resetForWorld(player.getWorld());
                } else if (args[0].contains("chest")) {
                    Sputnik.makeChestBlessings(player.getLocation(), new Blessings(BlessingType.valueOf(args[1]), Integer.parseInt(args[2]), player.getWorld()), Boolean.parseBoolean(args[3]), Byte.parseByte(args[4]));
                } else if (args[0].contains("citem")) {
                    Sputnik.makeChestItemLoot(player.getLocation(), player.getItemInHand(), Boolean.parseBoolean(args[3]), Byte.parseByte(args[4]));
                } else if (args[0].contains("ruins")) {
                    new ConfirmWitherRuins().open(player);
                } else if (args[0].contains("musicbgm")) {
                    if (args[1].contains("play")) {
                        if (sender.getUser().isPlayingSong()) {
                            this.send("&d[\u266b] &cYou're currently playing a song already! Use /sstest musicbgm stop to stop it!");
                            return;
                        }
                        File s3 = new File(SkySimEngine.getPlugin().getDataFolder() + File.separator + "/songs/" + args[2] + ".nbs");
                        if (!s3.exists()) {
                            this.send("&d[\u266b] &cThe specified BGM file does not exist!");
                            return;
                        }
                        this.send("&d[\u266b] &aPlaying BGM File &e" + args[2] + ".nbs &afrom disk&a for this world!");
                        SUtil.broadcastWorld(Sputnik.trans("&c"), player.getWorld());
                        SUtil.broadcastWorld(Sputnik.trans("&d[\u266b] &eYou're listening to &6" + args[2].replaceAll("_", " ") + " &efrom the &dSkySim Radio&e, requested by &d" + player.getName() + "&e, enjoy!"), player.getWorld());
                        SUtil.broadcastWorld(Sputnik.trans("&c"), player.getWorld());
                        Sputnik.playSound(s3, 1000, 10, true, player, player.getLocation());
                    } else if (args[1].contains("stop")) {
                        this.send("&d[\u266b] &eStopped all music played by you!");
                        sender.getUser().setPlayingSong(false);
                    } else {
                        this.send("&d\u266b SkySim Radiowave Usage \u266b");
                        this.send("&eCommand (Play): &6/sstest musicbgm play <song name>");
                        this.send("&eCommand (Stop): &6/sstest musicbgm stop");
                        this.send("&eAbout: &cSSMusicEngine-v0.1.0-ALPHA");
                    }
                }
            }
        } else {
            this.send(ChatColor.RED + "no, bad.");
        }
    }
}

