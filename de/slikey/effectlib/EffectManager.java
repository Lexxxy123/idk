/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Color
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.configuration.ConfigurationSection
 *  org.bukkit.entity.Entity
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitScheduler
 *  org.bukkit.scheduler.BukkitTask
 *  org.bukkit.util.NumberConversions
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.Disposable;
import de.slikey.effectlib.util.DynamicLocation;
import de.slikey.effectlib.util.ParticleEffect;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;

public final class EffectManager
implements Disposable {
    private static List<EffectManager> effectManagers;
    private static Map<String, Class<? extends Effect>> effectClasses;
    private final Plugin owningPlugin;
    private final Map<Effect, BukkitTask> effects;
    private boolean disposed;
    private boolean disposeOnTermination;
    private boolean debug = false;
    private int visibleRange = 32;

    public EffectManager(Plugin owningPlugin) {
        ParticleEffect.ParticlePacket.initialize();
        this.owningPlugin = owningPlugin;
        this.effects = new HashMap<Effect, BukkitTask>();
        this.disposed = false;
        this.disposeOnTermination = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start(Effect effect) {
        if (this.disposed) {
            throw new IllegalStateException("EffectManager is disposed and not able to accept any effects.");
        }
        if (this.disposeOnTermination) {
            throw new IllegalStateException("EffectManager is awaiting termination to dispose and not able to accept any effects.");
        }
        if (this.effects.containsKey(effect)) {
            effect.cancel(false);
        }
        BukkitScheduler s2 = Bukkit.getScheduler();
        BukkitTask task = null;
        switch (effect.type) {
            case INSTANT: {
                task = s2.runTask(this.owningPlugin, (Runnable)effect);
                break;
            }
            case DELAYED: {
                task = s2.runTaskLater(this.owningPlugin, (Runnable)effect, (long)effect.delay);
                break;
            }
            case REPEATING: {
                task = s2.runTaskTimer(this.owningPlugin, (Runnable)effect, (long)effect.delay, (long)effect.period);
            }
        }
        EffectManager effectManager = this;
        synchronized (effectManager) {
            this.effects.put(effect, task);
        }
    }

    public Effect start(String effectClass, ConfigurationSection parameters, Location origin, Entity originEntity) {
        return this.start(effectClass, parameters, origin, null, originEntity, null, null);
    }

    public Effect start(String effectClass, ConfigurationSection parameters, Entity originEntity) {
        return this.start(effectClass, parameters, originEntity == null ? null : originEntity.getLocation(), null, originEntity, null, null);
    }

    public Effect start(String effectClass, ConfigurationSection parameters, Location origin) {
        return this.start(effectClass, parameters, origin, null, null, null, null);
    }

    public Effect start(String effectClass, ConfigurationSection parameters, Location origin, Location target, Entity originEntity, Entity targetEntity, Map<String, String> parameterMap) {
        return this.start(effectClass, parameters, new DynamicLocation(origin, originEntity), new DynamicLocation(target, targetEntity), parameterMap);
    }

    public Effect start(String effectClass, ConfigurationSection parameters, DynamicLocation origin, DynamicLocation target, Map<String, String> parameterMap) {
        Class<Effect> effectLibClass;
        try {
            if (!effectClass.contains(".") && !(effectClass = "de.slikey.effectlib.effect." + effectClass).endsWith("Effect")) {
                effectClass = effectClass + "Effect";
            }
            if ((effectLibClass = effectClasses.get(effectClass)) == null) {
                effectLibClass = Class.forName(effectClass);
                effectClasses.put(effectClass, effectLibClass);
            }
        } catch (Throwable ex) {
            this.owningPlugin.getLogger().info("Error loading EffectLib class: " + effectClass + ": " + ex.getMessage());
            return null;
        }
        Effect effect = null;
        try {
            Constructor<Effect> constructor = effectLibClass.getConstructor(EffectManager.class);
            effect = constructor.newInstance(this);
        } catch (Exception ex) {
            this.owningPlugin.getLogger().warning("Error creating Effect class: " + effectClass);
        }
        if (effect == null) {
            return null;
        }
        Set keys = parameters.getKeys(false);
        for (String key : keys) {
            if (key.equals("class") || this.setField(effect, key, parameters, parameterMap) || !this.debug) continue;
            this.owningPlugin.getLogger().warning("Unable to assign EffectLib property " + key + " of class " + effectLibClass.getName());
        }
        effect.setDynamicOrigin(origin);
        effect.setDynamicTarget(target);
        effect.start();
        return effect;
    }

    public void cancel(boolean callback) {
        for (Map.Entry<Effect, BukkitTask> entry : this.effects.entrySet()) {
            entry.getKey().cancel(callback);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void done(Effect effect) {
        EffectManager effectManager = this;
        synchronized (effectManager) {
            BukkitTask existingTask = this.effects.get(effect);
            if (existingTask != null) {
                existingTask.cancel();
            }
            this.effects.remove(effect);
        }
        if (effect.callback != null) {
            Bukkit.getScheduler().runTask(this.owningPlugin, effect.callback);
        }
        if (this.disposeOnTermination && this.effects.isEmpty()) {
            this.dispose();
        }
    }

    @Override
    public void dispose() {
        if (this.disposed) {
            return;
        }
        this.disposed = true;
        this.cancel(false);
        if (effectManagers != null) {
            effectManagers.remove(this);
        }
    }

    public void disposeOnTermination() {
        this.disposeOnTermination = true;
        if (this.effects.isEmpty()) {
            this.dispose();
        }
    }

    public void enableDebug(boolean enable) {
        this.debug = enable;
    }

    public boolean isDebugEnabled() {
        return this.debug;
    }

    public void onError(Throwable ex) {
        if (this.debug) {
            this.owningPlugin.getLogger().log(Level.WARNING, "Particle Effect error", ex);
        }
    }

    public int getParticleRange() {
        return this.visibleRange;
    }

    public void setParticleRange(int range) {
        this.visibleRange = range;
    }

    public Plugin getOwningPlugin() {
        return this.owningPlugin;
    }

    protected boolean setField(Object effect, String key, ConfigurationSection section, Map<String, String> parameterMap) {
        try {
            Field field;
            String value = section.getString(key);
            if (parameterMap != null && !parameterMap.isEmpty() && value.startsWith("$")) {
                String parameterValue = parameterMap.get(value);
                String string = value = parameterValue == null ? value : parameterValue;
            }
            if ((field = effect.getClass().getField(key)).getType().equals(Integer.TYPE) || field.getType().equals(Integer.class)) {
                field.set(effect, NumberConversions.toInt((Object)value));
            } else if (field.getType().equals(Float.TYPE) || field.getType().equals(Float.class)) {
                field.set(effect, Float.valueOf(NumberConversions.toFloat((Object)value)));
            } else if (field.getType().equals(Double.TYPE) || field.getType().equals(Double.class)) {
                field.set(effect, NumberConversions.toDouble((Object)value));
            } else if (field.getType().equals(Boolean.TYPE) || field.getType().equals(Boolean.class)) {
                field.set(effect, value.equalsIgnoreCase("true"));
            } else if (field.getType().equals(Long.TYPE) || field.getType().equals(Long.class)) {
                field.set(effect, NumberConversions.toLong((Object)value));
            } else if (field.getType().equals(Short.TYPE) || field.getType().equals(Short.class)) {
                field.set(effect, NumberConversions.toShort((Object)value));
            } else if (field.getType().equals(Byte.TYPE) || field.getType().equals(Byte.class)) {
                field.set(effect, NumberConversions.toByte((Object)value));
            } else if (field.getType().isAssignableFrom(String.class)) {
                field.set(effect, value);
            } else if (field.getType().isAssignableFrom(ParticleEffect.class)) {
                ParticleEffect particleType = ParticleEffect.valueOf(value.toUpperCase());
                field.set(effect, (Object)particleType);
            } else if (field.getType().isAssignableFrom(EffectType.class)) {
                EffectType effectType = EffectType.valueOf(value.toUpperCase());
                field.set(effect, (Object)effectType);
            } else if (field.getType().equals(Sound.class)) {
                try {
                    Sound sound = Sound.valueOf((String)value.toUpperCase());
                    field.set(effect, sound);
                } catch (Exception ex) {
                    this.onError(ex);
                }
            } else if (field.getType().equals(Material.class)) {
                try {
                    Material material = Material.valueOf((String)value.toUpperCase());
                    field.set(effect, material);
                } catch (Exception ex) {
                    this.onError(ex);
                }
            } else if (field.getType().equals(Color.class)) {
                try {
                    Integer rgb = Integer.parseInt(value, 16);
                    Color color = Color.fromRGB((int)rgb);
                    field.set(effect, color);
                } catch (Exception ex) {
                    this.onError(ex);
                }
            } else if (field.getType().equals(Vector.class)) {
                double x2 = 0.0;
                double y2 = 0.0;
                double z2 = 0.0;
                try {
                    String[] pieces = value.split(",");
                    x2 = pieces.length > 0 ? Double.parseDouble(pieces[0]) : 0.0;
                    y2 = pieces.length > 1 ? Double.parseDouble(pieces[1]) : 0.0;
                    z2 = pieces.length > 2 ? Double.parseDouble(pieces[2]) : 0.0;
                } catch (Exception ex) {
                    this.onError(ex);
                }
                field.set(effect, new Vector(x2, y2, z2));
            } else {
                return false;
            }
            return true;
        } catch (Exception ex) {
            this.onError(ex);
            return false;
        }
    }

    public static void initialize() {
        effectManagers = new ArrayList<EffectManager>();
    }

    public static List<EffectManager> getManagers() {
        if (effectManagers == null) {
            EffectManager.initialize();
        }
        return effectManagers;
    }

    public static void disposeAll() {
        if (effectManagers != null) {
            Iterator<EffectManager> i2 = effectManagers.iterator();
            while (i2.hasNext()) {
                EffectManager em = i2.next();
                i2.remove();
                em.dispose();
            }
        }
    }

    static {
        effectClasses = new HashMap<String, Class<? extends Effect>>();
    }
}

