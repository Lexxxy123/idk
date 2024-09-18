/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 *  org.bukkit.util.Vector
 */
package xyz.xenondevs.particle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.ParticlePacket;
import xyz.xenondevs.particle.PropertyType;
import xyz.xenondevs.particle.data.ParticleData;
import xyz.xenondevs.particle.data.VibrationData;
import xyz.xenondevs.particle.data.color.DustColorTransitionData;
import xyz.xenondevs.particle.data.color.DustData;
import xyz.xenondevs.particle.data.color.NoteColor;
import xyz.xenondevs.particle.data.color.ParticleColor;
import xyz.xenondevs.particle.data.color.RegularColor;
import xyz.xenondevs.particle.data.texture.BlockTexture;
import xyz.xenondevs.particle.data.texture.ItemTexture;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public enum ParticleEffect {
    ASH(version -> version < 16.0 ? "NONE" : "ash", new PropertyType[0]),
    BARRIER(version -> version < 8.0 || version > 17.0 ? "NONE" : (version < 13.0 ? "BARRIER" : "barrier"), new PropertyType[0]),
    BLOCK_CRACK(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "BLOCK_CRACK" : "block"), PropertyType.REQUIRES_BLOCK),
    BLOCK_DUST(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "BLOCK_DUST" : "falling_dust"), PropertyType.DIRECTIONAL, PropertyType.REQUIRES_BLOCK),
    BUBBLE_COLUMN_UP(version -> version < 13.0 ? "NONE" : "bubble_column_up", PropertyType.DIRECTIONAL),
    BLOCK_MARKER(version -> version < 18.0 ? "NONE" : "block_marker", PropertyType.REQUIRES_BLOCK),
    BUBBLE_POP(version -> version < 13.0 ? "NONE" : "bubble_pop", PropertyType.DIRECTIONAL),
    CAMPFIRE_COSY_SMOKE(version -> version < 14.0 ? "NONE" : "campfire_cosy_smoke", PropertyType.DIRECTIONAL),
    CAMPFIRE_SIGNAL_SMOKE(version -> version < 14.0 ? "NONE" : "campfire_signal_smoke", PropertyType.DIRECTIONAL),
    CLOUD(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "CLOUD" : "cloud"), PropertyType.DIRECTIONAL),
    COMPOSTER(version -> version < 14.0 ? "NONE" : "composter", new PropertyType[0]),
    CRIMSON_SPORE(version -> version < 16.0 ? "NONE" : "crimson_spore", new PropertyType[0]),
    CRIT(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "CRIT" : "crit"), PropertyType.DIRECTIONAL),
    CRIT_MAGIC(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "CRIT_MAGIC" : "enchanted_hit"), PropertyType.DIRECTIONAL),
    CURRENT_DOWN(version -> version < 13.0 ? "NONE" : "current_down", new PropertyType[0]),
    DAMAGE_INDICATOR(version -> version < 9.0 ? "NONE" : (version < 13.0 ? "DAMAGE_INDICATOR" : "damage_indicator"), PropertyType.DIRECTIONAL),
    DOLPHIN(version -> version < 13.0 ? "NONE" : "dolphin", new PropertyType[0]),
    DRAGON_BREATH(version -> version < 9.0 ? "NONE" : (version < 13.0 ? "DRAGON_BREATH" : "dragon_breath"), PropertyType.DIRECTIONAL),
    DRIP_LAVA(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "DRIP_LAVA" : "dripping_lava"), new PropertyType[0]),
    DRIP_WATER(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "DRIP_WATER" : "dripping_water"), new PropertyType[0]),
    DRIPPING_DRIPSTONE_LAVA(version -> version < 17.0 ? "NONE" : "dripping_dripstone_lava", new PropertyType[0]),
    DRIPPING_DRIPSTONE_WATER(version -> version < 17.0 ? "NONE" : "dripping_dripstone_water", new PropertyType[0]),
    DRIPPING_HONEY(version -> version < 15.0 ? "NONE" : "dripping_honey", new PropertyType[0]),
    DRIPPING_OBSIDIAN_TEAR(version -> version < 16.0 ? "NONE" : "dripping_obsidian_tear", new PropertyType[0]),
    DUST_COLOR_TRANSITION(version -> version < 17.0 ? "NONE" : "dust_color_transition", PropertyType.COLORABLE, PropertyType.DUST),
    ELECTRIC_SPARK(version -> version < 17.0 ? "NONE" : "electric_spark", PropertyType.DIRECTIONAL),
    ENCHANTMENT_TABLE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "ENCHANTMENT_TABLE" : "enchant"), PropertyType.DIRECTIONAL),
    END_ROD(version -> version < 9.0 ? "NONE" : (version < 13.0 ? "END_ROD" : "end_rod"), PropertyType.DIRECTIONAL),
    EXPLOSION_HUGE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "EXPLOSION_HUGE" : "explosion_emitter"), new PropertyType[0]),
    EXPLOSION_LARGE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "EXPLOSION_LARGE" : "explosion"), new PropertyType[0]),
    EXPLOSION_NORMAL(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "EXPLOSION_NORMAL" : "poof"), PropertyType.DIRECTIONAL),
    FALLING_DRIPSTONE_LAVA(version -> version < 17.0 ? "NONE" : "falling_dripstone_lava", new PropertyType[0]),
    FALLING_DRIPSTONE_WATER(version -> version < 17.0 ? "NONE" : "falling_dripstone_water", new PropertyType[0]),
    FALLING_DUST(version -> version < 10.0 ? "NONE" : (version < 13.0 ? "FALLING_DUST" : "falling_dust"), PropertyType.REQUIRES_BLOCK),
    FALLING_HONEY(version -> version < 15.0 ? "NONE" : "falling_honey", new PropertyType[0]),
    FALLING_NECTAR(version -> version < 15.0 ? "NONE" : "falling_nectar", new PropertyType[0]),
    FALLING_OBSIDIAN_TEAR(version -> version < 16.0 ? "NONE" : "falling_obsidian_tear", new PropertyType[0]),
    FALLING_SPORE_BLOSSOM(version -> version < 17.0 ? "NONE" : "falling_spore_blossom", new PropertyType[0]),
    FIREWORKS_SPARK(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "FIREWORKS_SPARK" : "firework"), PropertyType.DIRECTIONAL),
    FLAME(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "FLAME" : "flame"), PropertyType.DIRECTIONAL),
    FLASH(version -> version < 14.0 ? "NONE" : "flash", new PropertyType[0]),
    FOOTSTEP(version -> version > 8.0 && version < 13.0 ? "FOOTSTEP" : "NONE", new PropertyType[0]),
    GLOW(version -> version < 17.0 ? "NONE" : "glow", PropertyType.DIRECTIONAL),
    GLOW_SQUID_INK(version -> version < 17.0 ? "NONE" : "glow_squid_ink", PropertyType.DIRECTIONAL),
    HEART(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "HEART" : "heart"), new PropertyType[0]),
    ITEM_CRACK(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "ITEM_CRACK" : "item"), PropertyType.DIRECTIONAL, PropertyType.REQUIRES_ITEM),
    LANDING_HONEY(version -> version < 15.0 ? "NONE" : "landing_honey", new PropertyType[0]),
    LANDING_OBSIDIAN_TEAR(version -> version < 16.0 ? "NONE" : "landing_obsidian_tear", new PropertyType[0]),
    LAVA(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "LAVA" : "lava"), new PropertyType[0]),
    LIGHT(version -> version != 17.0 ? "NONE" : "light", new PropertyType[0]),
    MOB_APPEARANCE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "MOB_APPEARANCE" : "elder_guardian"), new PropertyType[0]),
    NAUTILUS(version -> version < 13.0 ? "NONE" : "nautilus", PropertyType.DIRECTIONAL),
    NOTE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "NOTE" : "note"), PropertyType.COLORABLE),
    PORTAL(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "PORTAL" : "portal"), PropertyType.DIRECTIONAL),
    REDSTONE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "REDSTONE" : "dust"), PropertyType.COLORABLE, PropertyType.DUST),
    REVERSE_PORTAL(version -> version < 16.0 ? "NONE" : "reverse_portal", PropertyType.DIRECTIONAL),
    SCRAPE(version -> version < 17.0 ? "NONE" : "scrape", PropertyType.DIRECTIONAL),
    SCULK_CHARGE(version -> version < 19.0 ? "NONE" : "sculk_charge", PropertyType.DIRECTIONAL),
    SCULK_CHARGE_POP(version -> version < 19.0 ? "NONE" : "sculk_charge_pop", PropertyType.DIRECTIONAL),
    SCULK_SOUL(version -> version < 19.0 ? "NONE" : "sculk_soul", PropertyType.DIRECTIONAL),
    SHRIEK(version -> version < 19.0 ? "NONE" : "shriek", new PropertyType[0]),
    SLIME(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SLIME" : "item_slime"), new PropertyType[0]),
    SMALL_FLAME(version -> version < 17.0 ? "NONE" : "small_flame", PropertyType.DIRECTIONAL),
    SMOKE_LARGE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SMOKE_LARGE" : "large_smoke"), PropertyType.DIRECTIONAL),
    SMOKE_NORMAL(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SMOKE_NORMAL" : "smoke"), PropertyType.DIRECTIONAL),
    SNEEZE(version -> version < 14.0 ? "NONE" : "sneeze", PropertyType.DIRECTIONAL),
    SNOWBALL(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SNOWBALL" : "item_snowball"), new PropertyType[0]),
    SNOWFLAKE(version -> version < 17.0 ? "NONE" : "snowflake", PropertyType.DIRECTIONAL),
    SNOW_SHOVEL(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SNOW_SHOVEL" : "poof"), PropertyType.DIRECTIONAL),
    SONIC_BOOM(version -> version < 19.0 ? "NONE" : "sonic_boom", new PropertyType[0]),
    SOUL(version -> version < 16.0 ? "NONE" : "soul", PropertyType.DIRECTIONAL),
    SOUL_FIRE_FLAME(version -> version < 16.0 ? "NONE" : "soul_fire_flame", PropertyType.DIRECTIONAL),
    SPELL(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SPELL" : "effect"), new PropertyType[0]),
    SPELL_INSTANT(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SPELL_INSTANT" : "instant_effect"), new PropertyType[0]),
    SPELL_MOB(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SPELL_MOB" : "entity_effect"), PropertyType.COLORABLE),
    SPELL_MOB_AMBIENT(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SPELL_MOB_AMBIENT" : "ambient_entity_effect"), PropertyType.COLORABLE),
    SPELL_WITCH(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SPELL_WITCH" : "witch"), new PropertyType[0]),
    SPIT(version -> version < 11.0 ? "NONE" : (version < 13.0 ? "SPIT" : "spit"), new PropertyType[0]),
    SPORE_BLOSSOM_AIR(version -> version < 17.0 ? "NONE" : "spore_blossom_air", new PropertyType[0]),
    SQUID_INK(version -> version < 13.0 ? "NONE" : "squid_ink", PropertyType.DIRECTIONAL),
    SUSPENDED(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "SUSPENDED" : "underwater"), PropertyType.REQUIRES_WATER),
    SUSPENDED_DEPTH(version -> version > 8.0 && version < 13.0 ? "SUSPENDED_DEPTH" : "NONE", PropertyType.DIRECTIONAL),
    SWEEP_ATTACK(version -> version < 9.0 ? "NONE" : (version < 13.0 ? "SWEEP_ATTACK" : "sweep_attack"), PropertyType.RESIZEABLE),
    TOTEM(version -> version < 11.0 ? "NONE" : (version < 13.0 ? "TOTEM" : "totem_of_undying"), PropertyType.DIRECTIONAL),
    TOWN_AURA(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "TOWN_AURA" : "mycelium"), PropertyType.DIRECTIONAL),
    VIBRATION(version -> version < 17.0 ? "NONE" : "vibration", PropertyType.DIRECTIONAL),
    VILLAGER_ANGRY(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "VILLAGER_ANGRY" : "angry_villager"), new PropertyType[0]),
    VILLAGER_HAPPY(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "VILLAGER_HAPPY" : "happy_villager"), PropertyType.DIRECTIONAL),
    WARPED_SPORE(version -> version < 16.0 ? "NONE" : "warped_spore", new PropertyType[0]),
    WATER_BUBBLE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "WATER_BUBBLE" : "bubble"), PropertyType.DIRECTIONAL, PropertyType.REQUIRES_WATER),
    WATER_DROP(version -> version > 8.0 && version < 13.0 ? "WATER_DROP" : "NONE", new PropertyType[0]),
    WATER_SPLASH(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "WATER_SPLASH" : "splash"), PropertyType.DIRECTIONAL),
    WATER_WAKE(version -> version < 8.0 ? "NONE" : (version < 13.0 ? "WATER_WAKE" : "fishing"), PropertyType.DIRECTIONAL),
    WAX_OFF(version -> version < 17.0 ? "NONE" : "wax_off", PropertyType.DIRECTIONAL),
    WAX_ON(version -> version < 17.0 ? "NONE" : "wax_on", PropertyType.DIRECTIONAL),
    WHITE_ASH(version -> version < 16.0 ? "NONE" : "white_ash", new PropertyType[0]);

    private final DoubleFunction<String> fieldNameMapper;
    private final List<PropertyType> properties;
    public static final List<ParticleEffect> VALUES;
    public static final Map<ParticleEffect, Object> NMS_EFFECTS;

    public static Set<ParticleEffect> getAvailableEffects() {
        return NMS_EFFECTS.keySet();
    }

    private ParticleEffect(DoubleFunction<String> fieldNameMapper, PropertyType ... properties) {
        this.fieldNameMapper = fieldNameMapper;
        this.properties = Collections.unmodifiableList(Arrays.asList(properties));
    }

    public String getFieldName() {
        return this.fieldNameMapper.apply(ReflectionUtils.MINECRAFT_VERSION);
    }

    public List<PropertyType> getProperties() {
        return this.properties;
    }

    public boolean hasProperty(PropertyType propertyType) {
        return propertyType != null && this.properties.contains((Object)propertyType);
    }

    public boolean isCorrectData(ParticleData data) {
        if (data == null) {
            return true;
        }
        if (data instanceof ParticleColor) {
            return this.isCorrectColor((ParticleColor)data);
        }
        if (data instanceof BlockTexture) {
            return this.hasProperty(PropertyType.REQUIRES_BLOCK);
        }
        if (data instanceof ItemTexture) {
            return this.hasProperty(PropertyType.REQUIRES_ITEM);
        }
        return data instanceof VibrationData && this == VIBRATION;
    }

    public boolean isCorrectColor(ParticleColor color) {
        if (color instanceof DustColorTransitionData) {
            return this == DUST_COLOR_TRANSITION;
        }
        if (color instanceof DustData) {
            return this.hasProperty(PropertyType.DUST);
        }
        return this.hasProperty(PropertyType.COLORABLE) && (this.equals((Object)NOTE) ? color instanceof NoteColor : color instanceof RegularColor);
    }

    public Object getNMSObject() {
        if (NMS_EFFECTS != null && NMS_EFFECTS.containsKey((Object)this)) {
            return NMS_EFFECTS.get((Object)this);
        }
        String fieldName = this.getFieldName();
        if ("NONE".equals(fieldName)) {
            return null;
        }
        if (ReflectionUtils.MINECRAFT_VERSION < 13.0) {
            return Arrays.stream(ParticleConstants.PARTICLE_ENUM.getEnumConstants()).filter(effect -> effect.toString().equals(fieldName)).findFirst().orElse(null);
        }
        try {
            return ParticleConstants.REGISTRY_GET_METHOD.invoke(ParticleConstants.PARTICLE_TYPE_REGISTRY, ReflectionUtils.getMinecraftKey(fieldName));
        } catch (Exception exception) {
            return null;
        }
    }

    public void display(Location location, ParticleColor color, Player ... players) {
        this.display(location, 0.0f, 0.0f, 0.0f, 1.0f, 0, (ParticleData)color, players);
    }

    public void display(Location location, Color color, Player ... players) {
        this.display(location, (ParticleColor)new RegularColor(color), players);
    }

    public void display(Location location, ParticleColor color, Predicate filter) {
        this.display(location, 0.0f, 0.0f, 0.0f, 1.0f, 0, (ParticleData)color, filter);
    }

    public void display(Location location, Color color, Predicate filter) {
        this.display(location, (ParticleColor)new RegularColor(color), filter);
    }

    public void display(Location location, ParticleColor color, Collection<? extends Player> players) {
        this.display(location, 0.0f, 0.0f, 0.0f, 1.0f, 0, (ParticleData)color, players);
    }

    public void display(Location location, Color color, Collection<? extends Player> players) {
        this.display(location, (ParticleColor)new RegularColor(color), players);
    }

    public void display(Location location, ParticleColor color) {
        this.display(location, 0.0f, 0.0f, 0.0f, 1.0f, 0, color);
    }

    public void display(Location location, Color color) {
        this.display(location, new RegularColor(color));
    }

    public void display(Location location, Player ... players) {
        this.display(location, 0.0f, 0.0f, 0.0f, 0.0f, 1, null, players);
    }

    public void display(Location location, Predicate filter) {
        this.display(location, 0.0f, 0.0f, 0.0f, 0.0f, 1, null, filter);
    }

    public void display(Location location, Collection<? extends Player> players) {
        this.display(location, 0.0f, 0.0f, 0.0f, 0.0f, 1, null, players);
    }

    public void display(Location location) {
        this.display(location, 0.0f, 0.0f, 0.0f, 0.0f, 1, null, Bukkit.getOnlinePlayers());
    }

    public void display(Location location, Vector vector, float speed, int amount, ParticleData data, Player ... players) {
        this.display(location, (float)vector.getX(), (float)vector.getY(), (float)vector.getZ(), speed, amount, data, players);
    }

    public void display(Location location, Vector vector, float speed, int amount, ParticleData data, Predicate filter) {
        this.display(location, (float)vector.getX(), (float)vector.getY(), (float)vector.getZ(), speed, amount, data, filter);
    }

    public void display(Location location, Vector vector, float speed, int amount, ParticleData data, Collection<? extends Player> players) {
        this.display(location, (float)vector.getX(), (float)vector.getY(), (float)vector.getZ(), speed, amount, data, players);
    }

    public void display(Location location, Vector vector, float speed, int amount, ParticleData data) {
        this.display(location, (float)vector.getX(), (float)vector.getY(), (float)vector.getZ(), speed, amount, data);
    }

    public void display(Location location, float offsetX, float offsetY, float offsetZ, float speed, int amount, ParticleData data, Player ... players) {
        ArrayList playerList = Arrays.stream(players).collect(Collectors.toCollection(ArrayList::new));
        this.display(location, offsetX, offsetY, offsetZ, speed, amount, data, playerList);
    }

    public void display(Location location, float offsetX, float offsetY, float offsetZ, float speed, int amount, ParticleData data, Predicate<Player> filter) {
        ArrayList players = Bukkit.getOnlinePlayers().stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
        this.display(location, offsetX, offsetY, offsetZ, speed, amount, data, players);
    }

    public void display(Location location, float offsetX, float offsetY, float offsetZ, float speed, int amount, ParticleData data) {
        this.display(location, offsetX, offsetY, offsetZ, speed, amount, data, Bukkit.getOnlinePlayers());
    }

    public void display(Location location, float offsetX, float offsetY, float offsetZ, float speed, int amount, ParticleData data, Collection<? extends Player> players) {
        if (!this.isCorrectData(data)) {
            return;
        }
        if (data != null) {
            data.setEffect(this);
        }
        ParticlePacket packet = new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, data);
        Object nmsPacket = packet.createPacket(location);
        players.stream().filter(p2 -> p2.getWorld().equals(location.getWorld())).forEach(p2 -> ReflectionUtils.sendPacket(p2, nmsPacket));
    }

    static {
        VALUES = Collections.unmodifiableList(Arrays.asList(ParticleEffect.values()));
        NMS_EFFECTS = Collections.unmodifiableMap(VALUES.stream().filter(effect -> !"NONE".equals(effect.getFieldName())).collect(Collectors.toMap(Function.identity(), ParticleEffect::getNMSObject)));
    }
}

