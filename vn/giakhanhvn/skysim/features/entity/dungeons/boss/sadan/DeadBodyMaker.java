/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.properties.Property
 *  net.md_5.bungee.api.ChatColor
 *  net.minecraft.server.v1_8_R3.BlockPosition
 *  net.minecraft.server.v1_8_R3.DataWatcher
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.EntityHuman
 *  net.minecraft.server.v1_8_R3.EntityPlayer
 *  net.minecraft.server.v1_8_R3.MinecraftServer
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutBed
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntity$PacketPlayOutRelEntityMove
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityMetadata
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport
 *  net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn
 *  net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo
 *  net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo$EnumPlayerInfoAction
 *  net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam
 *  net.minecraft.server.v1_8_R3.PlayerConnection
 *  net.minecraft.server.v1_8_R3.PlayerInteractManager
 *  net.minecraft.server.v1_8_R3.Scoreboard
 *  net.minecraft.server.v1_8_R3.ScoreboardTeam
 *  net.minecraft.server.v1_8_R3.ScoreboardTeamBase$EnumNameTagVisibility
 *  net.minecraft.server.v1_8_R3.World
 *  net.minecraft.server.v1_8_R3.WorldServer
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.craftbukkit.v1_8_R3.CraftServer
 *  org.bukkit.craftbukkit.v1_8_R3.CraftWorld
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboard
 *  org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboardManager
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.entity.dungeons.boss.sadan;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.DataWatcher;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutBed;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntity;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardTeam;
import net.minecraft.server.v1_8_R3.ScoreboardTeamBase;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboard;
import org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboardManager;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.entity.dungeons.boss.sadan.SadanFunction;
import vn.giakhanhvn.skysim.util.SUtil;

public final class DeadBodyMaker {
    private static final byte PLAYER_SLEEP_HEIGHT_FIX = 1;

    public static Object[] createPlayer(Location loc) {
        MinecraftServer minecraftServer = ((CraftServer)Bukkit.getServer()).getServer();
        String name = SadanFunction.generateRandom();
        WorldServer world = ((CraftWorld)loc.getWorld()).getHandle();
        GameProfile botGameProfile = new GameProfile(UUID.randomUUID(), name);
        GameProfile playerProfile = new GameProfile(UUID.randomUUID(), name);
        playerProfile.getProperties().put((Object)"textures", (Object)new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTYxMjAyOTExOTA2MiwKICAicHJvZmlsZUlkIiA6ICI5ZDQyNWFiOGFmZjg0MGU1OWM3NzUzZjc5Mjg5YjMyZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJUb21wa2luNDIiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmEwNmNiMGM0NzFjMWM5YmMxNjlhZjI3MGNkNDY2ZWE3MDE5NDY3NzYwNTZlNDcyZWNkYWViNDlmMGY0YTRkYyIKICAgIH0KICB9Cn0=", "mpSbfgDmWvoHASfqQ+poj2b4Y0QEZYh4QlqcCqHrZ4DNKY7mIenlbY2s7Ptmhb46dONt5OVfHb1pDLDlCPnYP9QYDXhl/wR99wxA4F7HHjs1g1omvZBfGRCvwHU/Bc3aWhjlaKZCVotf0snzrPTWIHFYnQoVLnhXoz19b3SQfdztIipZoZFKgMxwM2l4y+hBS9p7b/u2loz6/kVLBiLxzzYtAayF+ekma+bWlQcqhdsaf/BAJJSjh/UtipZLvAo4L2E2JlBsoKhj9PVSRVk4eAS1KE7p9Dupbrr/Ypj4bYVpUH5KhMJlQn7vCGoWILwd1NjFWk6KVlGUCag8/3pE1BNeD5d3QOfiVCkFH/rofRfS0/w0Nv8ROK0JQP/cFaAQ3kQ2ilvifF0kzPiA1M7si22lbXGyLqhQAVFsNSgKIU0Fe2qfD536Rr+kkBc/sVAzfVh4ajfsOXtMuMoZGIDJULpA1RD9qsybGvl7kkVQd2jPzlvZD8Ef8ZW8wr64Lu+/zZEj30zISIKZiwIsMKM2vOO7eqbfTs+tu0BNKKjiRg7uLF0qhyCpQrlJENzFud04ZiaTyI1Btt2LpOHQmKASWfg7/TEr8rPVPWiVqRBPCpHe5xJlAtQc2+PrtBO8u+qG3TTRKVci2a+Mpx1SwuPtMY2ZRj1NmYW3yBuu9pQnvlg="));
        Collection skinProperty = playerProfile.getProperties().get((Object)"textures");
        botGameProfile.getProperties().putAll((Object)"textures", (Iterable)skinProperty);
        PlayerInteractManager interactManager = new PlayerInteractManager((World)world);
        EntityPlayer botPlayer = new EntityPlayer(minecraftServer, world, botGameProfile, interactManager);
        Location playerLocation = loc;
        botPlayer.setLocation(playerLocation.getX(), playerLocation.getY(), playerLocation.getZ(), playerLocation.getYaw(), playerLocation.getPitch());
        return new Object[]{botPlayer, name};
    }

    public static EntityPlayer spawn(Location location) {
        Location bedLocation = new Location(location.getWorld(), 1.0, 1.0, 1.0);
        Location deathLocation = location;
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendBlockChange(bedLocation, Material.BED_BLOCK, (byte)0);
        }
        BlockPosition deathBlockPosition = new BlockPosition(bedLocation.getBlockX(), bedLocation.getBlockY(), bedLocation.getBlockZ());
        Object[] obj = DeadBodyMaker.createPlayer(bedLocation);
        String name = (String)obj[1];
        EntityPlayer botPlayer = (EntityPlayer)obj[0];
        botPlayer.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
        PacketPlayOutEntityTeleport astp = new PacketPlayOutEntityTeleport((Entity)botPlayer);
        PacketPlayOutPlayerInfo pack = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, new EntityPlayer[]{botPlayer});
        DataWatcher data = new DataWatcher((Entity)botPlayer);
        data.a(10, (Object)127);
        PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(botPlayer.getId(), data, true);
        CraftScoreboardManager scoreboardManager = ((CraftServer)Bukkit.getServer()).getScoreboardManager();
        assert (scoreboardManager != null);
        CraftScoreboard mainScoreboard = scoreboardManager.getMainScoreboard();
        Scoreboard scoreboard = mainScoreboard.getHandle();
        ScoreboardTeam scoreboardTeam = scoreboard.getTeam(name);
        if (scoreboardTeam == null) {
            scoreboardTeam = new ScoreboardTeam(scoreboard, name);
        }
        scoreboardTeam.setNameTagVisibility(ScoreboardTeamBase.EnumNameTagVisibility.NEVER);
        scoreboardTeam.setPrefix(ChatColor.DARK_GRAY + "[NPC] ");
        for (Player p2 : location.getWorld().getPlayers()) {
            PlayerConnection conn = ((CraftPlayer)p2).getHandle().playerConnection;
            conn.sendPacket((Packet)astp);
            conn.sendPacket((Packet)new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, new EntityPlayer[]{botPlayer}));
            conn.sendPacket((Packet)new PacketPlayOutNamedEntitySpawn((EntityHuman)botPlayer));
            conn.sendPacket((Packet)packet);
            DeadBodyMaker.sendPacketBundle(p2, new Packet[]{new PacketPlayOutScoreboardTeam(scoreboardTeam, 1), new PacketPlayOutScoreboardTeam(scoreboardTeam, 0), new PacketPlayOutScoreboardTeam(scoreboardTeam, Collections.singletonList(name), 3)});
            conn.sendPacket((Packet)new PacketPlayOutBed((EntityHuman)botPlayer, deathBlockPosition));
            SUtil.delay(() -> conn.sendPacket((Packet)pack), 10L);
            conn.sendPacket((Packet)new PacketPlayOutEntity.PacketPlayOutRelEntityMove(botPlayer.getId(), 0, 1, 0, true));
        }
        return botPlayer;
    }

    private static void sendPacketBundle(Player p2, Packet[] pk) {
        for (int i2 = 0; i2 < pk.length; ++i2) {
            ((CraftPlayer)p2).getHandle().playerConnection.sendPacket(pk[i2]);
        }
    }
}

