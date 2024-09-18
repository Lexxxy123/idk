/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.entity.Player
 */
package de.slikey.effectlib.particle;

import de.slikey.effectlib.particle.ReflectionHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public final class ParticlePacket {
    private static Method getHandle;
    private static Field playerConnection;
    private static Method sendPacket;
    private static Class<?> packet;
    private static Object obj;
    private static Field fParticle;
    private static Field fX;
    private static Field fY;
    private static Field fZ;
    private static Field fOffX;
    private static Field fOffY;
    private static Field fOffZ;
    private static Field fSpeed;
    private static Field fAmount;
    public static String particle;
    public static float x;
    public static float y;
    public static float z;
    public static float offX;
    public static float offY;
    public static float offZ;
    public static float speed;
    public static float range;
    public static int amount;

    private ParticlePacket() {
    }

    public static void reset() {
        particle = "";
        amount = 0;
        offZ = speed = (float)0;
        offY = speed;
        offX = speed;
        z = speed;
        y = speed;
        x = speed;
    }

    public static void setLocation(Location l2) {
        x = (float)l2.getX();
        y = (float)l2.getY();
        z = (float)l2.getZ();
    }

    public static void set(ParticleType particle, float x2, float y2, float z2, float offX, float offY, float offZ, float speed, int amount) {
        ParticlePacket.particle = particle.getId();
        x = x2;
        y = y2;
        z = z2;
        ParticlePacket.offX = offX;
        ParticlePacket.offY = offY;
        ParticlePacket.offZ = offZ;
        ParticlePacket.speed = speed;
        ParticlePacket.amount = amount;
        ParticlePacket.update();
    }

    public static void update() {
        try {
            fParticle.set(obj, particle);
            fX.set(obj, Float.valueOf(x));
            fY.set(obj, Float.valueOf(y));
            fZ.set(obj, Float.valueOf(z));
            fOffX.set(obj, Float.valueOf(offX));
            fOffY.set(obj, Float.valueOf(offY));
            fOffZ.set(obj, Float.valueOf(offZ));
            fSpeed.set(obj, Float.valueOf(speed));
            fAmount.set(obj, amount);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static List<Player> getPlayers(World world) {
        ArrayList<Player> players = new ArrayList<Player>();
        float squared = range * range;
        for (Player p2 : world.getPlayers()) {
            if (!ParticlePacket.inRange(p2.getLocation(), squared)) continue;
            players.add(p2);
        }
        return players;
    }

    private static boolean inRange(Location l2, float squared) {
        return Math.pow(l2.getX() - (double)x, 2.0) + Math.pow(l2.getY() - (double)y, 2.0) + Math.pow(l2.getZ() - (double)z, 2.0) <= (double)squared;
    }

    public static void display(ParticleType p2, Location l2) {
        ParticlePacket.reset();
        ParticlePacket.set(p2, (float)l2.getX(), (float)l2.getY(), (float)l2.getZ(), 0.0f, 0.0f, 0.0f, 0.0f, 1);
        ParticlePacket.display(l2.getWorld());
    }

    public static void display(World world) {
        for (Player p2 : ParticlePacket.getPlayers(world)) {
            ParticlePacket.sendPacket(p2);
        }
    }

    private static void sendPacket(Player p2) {
        try {
            sendPacket.invoke(playerConnection.get(getHandle.invoke(p2, new Object[0])), obj);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static {
        try {
            getHandle = ReflectionHandler.getMethod("CraftPlayer", ReflectionHandler.SubPackageType.ENTITY, "getHandle", new Class[0]);
            playerConnection = ReflectionHandler.getField("EntityPlayer", ReflectionHandler.PackageType.MINECRAFT_SERVER, "playerConnection");
            sendPacket = ReflectionHandler.getMethod(playerConnection.getType(), "sendPacket", ReflectionHandler.getClass("Packet", ReflectionHandler.PackageType.MINECRAFT_SERVER));
            range = 32.0f;
            packet = ReflectionHandler.PacketType.PLAY_OUT_WORLD_PARTICLES.getPacket();
            obj = ReflectionHandler.getConstructor(packet, String.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Integer.TYPE).newInstance("", 0, 0, 0, 0, 0, 0, 0, 0);
            fParticle = packet.getDeclaredField("a");
            fParticle.setAccessible(true);
            fX = packet.getDeclaredField("b");
            fX.setAccessible(true);
            fY = packet.getDeclaredField("c");
            fY.setAccessible(true);
            fZ = packet.getDeclaredField("d");
            fZ.setAccessible(true);
            fOffX = packet.getDeclaredField("e");
            fOffX.setAccessible(true);
            fOffY = packet.getDeclaredField("f");
            fOffY.setAccessible(true);
            fOffZ = packet.getDeclaredField("g");
            fOffZ.setAccessible(true);
            fSpeed = packet.getDeclaredField("h");
            fSpeed.setAccessible(true);
            fAmount = packet.getDeclaredField("i");
            fAmount.setAccessible(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static enum ParticleType {
        HUGE_EXPLOSION("hugeexplosion"),
        LARGE_EXPLODE("largeexplode"),
        FIREWORKS_SPARK("fireworksSpark"),
        BUBBLE("bubble"),
        SUSPEND("suspend"),
        DEPTH_SUSPEND("depthSuspend"),
        TOWN_AURA("townaura"),
        CRIT("crit"),
        MAGIC_CRIT("magicCrit"),
        SMOKE("smoke"),
        MOB_SPELL("mobSpell"),
        MOB_SPELL_AMBIENT("mobSpellAmbient"),
        SPELL("spell"),
        INSTANT_SPELL("instantSpell"),
        WITCH_MAGIC("witchMagic"),
        NOTE("note"),
        PORTAL("portal"),
        ENCHANTMENT_TABLE("enchantmenttable"),
        EXPLODE("explode"),
        FLAME("flame"),
        LAVA("lava"),
        FOOTSTEP("footstep"),
        SPLASH("splash"),
        WAKE("wake"),
        LARGE_SMOKE("largesmoke"),
        CLOUD("cloud"),
        RED_DUST("reddust"),
        SNOWBALL_POOF("snowballpoof"),
        DRIP_WATER("dripWater"),
        DRIP_LAVA("dripLava"),
        SNOW_SHOVEL("snowshovel"),
        SLIME("slime"),
        HEART("heart"),
        ANGRY_VILLAGER("angryVillager"),
        HAPPY_VILLAGER("happyVillager");

        private String id;

        private ParticleType(String id) {
            this.id = id;
        }

        public String getId() {
            return this.id;
        }
    }
}

