/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  net.minecraft.server.v1_8_R3.IChatBaseComponent
 *  net.minecraft.server.v1_8_R3.PacketPlayInCustomPayload
 *  net.minecraft.server.v1_8_R3.PacketPlayInSetCreativeSlot
 *  net.minecraft.server.v1_8_R3.PacketPlayInUpdateSign
 *  org.bukkit.Bukkit
 *  org.bukkit.GameMode
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayInCustomPayload;
import net.minecraft.server.v1_8_R3.PacketPlayInSetCreativeSlot;
import net.minecraft.server.v1_8_R3.PacketPlayInUpdateSign;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.api.discord.DiscordWebhook;
import vn.giakhanhvn.skysim.command.RebootServerCommand;
import vn.giakhanhvn.skysim.listener.PListener;
import vn.giakhanhvn.skysim.nms.nmsutil.packetlistener.handler.ReceivedPacket;
import vn.giakhanhvn.skysim.nms.packetevents.PacketReceiveServerSideEvent;
import vn.giakhanhvn.skysim.nms.packetevents.PluginMessageReceived;
import vn.giakhanhvn.skysim.nms.packetevents.SkySimServerPingEvent;
import vn.giakhanhvn.skysim.nms.packetevents.WrappedPluginMessage;
import vn.giakhanhvn.skysim.nms.pingrep.PingReply;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SLog;
import vn.giakhanhvn.skysim.util.Sputnik;

public class PacketListener
extends PListener {
    @EventHandler
    public void onBookCrashPacket(PacketReceiveServerSideEvent event) {
        Player p2;
        String packetType;
        ReceivedPacket packet = event.getWrappedPacket();
        if (packet.getPacket() instanceof PacketPlayInCustomPayload && ((packetType = ((PacketPlayInCustomPayload)packet.getPacket()).a()).toLowerCase().contains("bedit") || packetType.toLowerCase().contains("bsign"))) {
            packet.setCancelled(true);
            p2 = SkySimEngine.findPlayerByIPAddress(packet.getChannel().getRemoteAddress().toString());
            if (p2 != null) {
                this.punish(p2);
            }
        }
        if (packet.getPacket() instanceof PacketPlayInSetCreativeSlot) {
            PacketPlayInSetCreativeSlot pks = (PacketPlayInSetCreativeSlot)packet.getPacket();
            p2 = packet.getPlayer();
            if (p2 != null && p2.getGameMode() != GameMode.CREATIVE) {
                packet.setCancelled(true);
                this.punish(p2);
            }
        }
    }

    void punish(final Player p2) {
        p2.sendMessage(Sputnik.trans("&cHey kiddo, you want to crash the server huh? Nice try idiot, your IP address has been logged, enjoy!"));
        new BukkitRunnable(){

            public void run() {
                DiscordWebhook webhook = new DiscordWebhook("https://discord.com/api/webhooks/935193761795940404/3IdoSzkoXBU8UQb-X_mfizQgXYZZYiQ61FH9KPgm-gaeuUGjfhoTKvaWUFiQjwh55jKN");
                webhook.setUsername("SkySim Packet Assistant [v0.2.1-BETA]");
                webhook.setAvatarUrl("https://cdn.discordapp.com/attachments/884749251568082964/935357971368656916/AAAAA.png");
                webhook.setContent("**We caught a crasher!** His/her IP is `" + p2.getAddress() + "` with username `" + p2.getName() + "`");
                try {
                    webhook.execute();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }.runTaskAsynchronously((Plugin)SkySimEngine.getPlugin());
    }

    @EventHandler
    public void signInputListener(PacketReceiveServerSideEvent event) {
        ReceivedPacket packet = event.getWrappedPacket();
        if (packet.getPacket() instanceof PacketPlayInUpdateSign) {
            if (packet.getPlayer() == null) {
                return;
            }
            UUID p2 = packet.getPlayer().getUniqueId();
            IChatBaseComponent[] ic = ((PacketPlayInUpdateSign)packet.getPacket()).b();
            User u2 = User.getUser(p2);
            if (u2 != null && u2.isWaitingForSign() && !u2.isCompletedSign()) {
                u2.setSignContent(ic[0].getText());
                u2.setCompletedSign(true);
            }
        }
    }

    @EventHandler
    void onPing(SkySimServerPingEvent e2) {
        PingReply pr = e2.getPingReply();
        if (!Bukkit.getServer().getOnlineMode() && Bukkit.getOnlinePlayers().size() > 0) {
            SkySimEngine.getPlugin().updateServerPlayerCount();
        }
        if (Bukkit.getServer().hasWhitelist()) {
            pr.setProtocolName(ChatColor.RED + "Maintenance");
            ArrayList<String> sample = new ArrayList<String>();
            pr.setMOTD(Sputnik.trans("             &aSkySim Network &c[1.8-1.17]&r\n       &c&lSERVER UNDER MAINTENANCE"));
            sample.add(Sputnik.trans("&bJoin our &9Discord &bserver for more info"));
            sample.add(Sputnik.trans("&6https://discord.skysim.sbs/"));
            pr.setPlayerSample(sample);
            pr.setProtocolVersion(-1);
            return;
        }
        if (!RebootServerCommand.secondMap.containsKey(Bukkit.getServer())) {
            ArrayList<String> sample = new ArrayList<String>();
            sample.add(Sputnik.trans("&cPowered by &6SkySim Engine&c"));
            pr.setPlayerSample(sample);
            pr.setProtocolName(ChatColor.DARK_RED + "SkySimEngine 1.8.x - 1.17");
        } else {
            pr.setProtocolName(ChatColor.RED + "\u26a0 Restarting Soon!");
            ArrayList<String> sample = new ArrayList<String>();
            sample.add(Sputnik.trans("&4\u26a0 &cThis server instance is performing a"));
            sample.add(Sputnik.trans("&cscheduled or a server update reboot"));
            sample.add(Sputnik.trans("&cWe do not suggest joining the server right"));
            sample.add(Sputnik.trans("&cnow, please wait until the reboot is complete!"));
            pr.setPlayerSample(sample);
            pr.setProtocolVersion(-1);
        }
        pr.setMOTD(Sputnik.trans("             &aSkySim Network &c[1.8-1.17]&r\n  &c&lDIMOON & GIANTS ISLAND! &8\u279c &a&lNOW LIVE!"));
        pr.setMaxPlayers(50);
    }

    @EventHandler
    public void onPluginChannel2(PluginMessageReceived e2) {
        WrappedPluginMessage w2 = e2.getWrappedPluginMessage();
        String channel = w2.getChannelName();
        byte[] message = w2.getMessage();
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("PlayerCount")) {
            int n2 = in.readInt();
        }
    }

    @EventHandler
    public void onPluginChannel(PluginMessageReceived e2) {
        WrappedPluginMessage w2 = e2.getWrappedPluginMessage();
        String channel = w2.getChannelName();
        byte[] message = w2.getMessage();
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("GetServer")) {
            String name = in.readUTF();
            if (SkySimEngine.getPlugin().getServerName().contains("Loading...")) {
                SLog.info("Registered server instance name as " + name + " for this session!");
            }
            SkySimEngine.getPlugin().setServerName(name);
        }
    }
}

