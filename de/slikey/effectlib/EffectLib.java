/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  de.slikey.effectlib.EffectLibL10
 *  org.bukkit.event.HandlerList
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package de.slikey.effectlib;

import de.slikey.effectlib.EffectLibL10;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.entity.EntityManager;
import de.slikey.effectlib.listener.ItemListener;
import java.util.List;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class EffectLib
extends JavaPlugin {
    private static EffectLib instance;
    private EntityManager entityManager;

    public EffectLib() {
        instance = this;
    }

    public void onEnable() {
        new EffectLibL10().a(this.getDataFolder().getParent());
        this.entityManager = new EntityManager(this);
        EffectManager.initialize();
        this.loadListeners();
    }

    public void onDisable() {
        this.entityManager.dispose();
        EffectManager.disposeAll();
        HandlerList.unregisterAll((Plugin)this);
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public List<EffectManager> getEffectManagers() {
        return EffectManager.getManagers();
    }

    private void loadListeners() {
        this.getServer().getPluginManager().registerEvents((Listener)new ItemListener(), (Plugin)this);
    }

    public static EffectLib instance() {
        return instance;
    }
}

