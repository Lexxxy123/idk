/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.java.JavaPlugin
 */
package de.tr7zw.nbtapi.plugin;

import de.tr7zw.nbtapi.plugin.ReloadListener;
import de.tr7zw.nbtapi.plugin.tests.GameprofileTest;
import de.tr7zw.nbtapi.plugin.tests.NBTFileTest;
import de.tr7zw.nbtapi.plugin.tests.Test;
import de.tr7zw.nbtapi.plugin.tests.blocks.BlockNBTTest;
import de.tr7zw.nbtapi.plugin.tests.chunks.ChunkNBTPersistentTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.EqualsTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.ForEachTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.GetterSetterTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.IteratorTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.ListTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.MergeTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.RemovingKeys;
import de.tr7zw.nbtapi.plugin.tests.compounds.StreamTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.SubCompoundsTest;
import de.tr7zw.nbtapi.plugin.tests.compounds.TypeTest;
import de.tr7zw.nbtapi.plugin.tests.data.WorldDataTest;
import de.tr7zw.nbtapi.plugin.tests.entities.EntityCustomNbtPersistentTest;
import de.tr7zw.nbtapi.plugin.tests.entities.EntityTest;
import de.tr7zw.nbtapi.plugin.tests.injector.EntityCustomNbtInjectorTest;
import de.tr7zw.nbtapi.plugin.tests.injector.MergeTileSubCompoundTest;
import de.tr7zw.nbtapi.plugin.tests.injector.SpawnEntityCustomNbtInjectorTest;
import de.tr7zw.nbtapi.plugin.tests.injector.TilesCustomNBTInjectorTest;
import de.tr7zw.nbtapi.plugin.tests.items.DirectApplyTest;
import de.tr7zw.nbtapi.plugin.tests.items.EmptyItemTest;
import de.tr7zw.nbtapi.plugin.tests.items.ItemConvertionTest;
import de.tr7zw.nbtapi.plugin.tests.items.ItemMergingTest;
import de.tr7zw.nbtapi.plugin.tests.tiles.TileTest;
import de.tr7zw.nbtapi.plugin.tests.tiles.TilesCustomNBTPersistentTest;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import de.tr7zw.nbtinjector.NBTInjector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class NBTAPI
extends JavaPlugin {
    private boolean compatible = true;
    private ArrayList<Test> apiTests = new ArrayList();
    private static NBTAPI instance;

    public static NBTAPI getInstance() {
        return instance;
    }

    public void onLoad() {
        this.getConfig().options().copyDefaults(true);
        this.getConfig().addDefault("nbtInjector.enabled", (Object)false);
        this.getConfig().addDefault("bStats.enabled", (Object)true);
        this.getConfig().addDefault("updateCheck.enabled", (Object)true);
        this.saveConfig();
        if (!this.getConfig().getBoolean("bStats.enabled")) {
            this.getLogger().info("bStats disabled");
            MinecraftVersion.disableBStats();
        }
        if (!this.getConfig().getBoolean("updateCheck.enabled")) {
            this.getLogger().info("Update check disabled");
            MinecraftVersion.disableUpdateCheck();
        }
        if (this.getConfig().getBoolean("nbtInjector.enabled")) {
            this.getLogger().info("Injecting custom NBT");
            try {
                NBTInjector.inject();
                this.getLogger().info("Injected!");
            } catch (Throwable ex) {
                this.getLogger().log(Level.SEVERE, "Error while Injecting custom Tile/Entity classes!", ex);
                this.compatible = false;
            }
        }
        this.apiTests.add(new GetterSetterTest());
        this.apiTests.add(new TypeTest());
        this.apiTests.add(new RemovingKeys());
        if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3)) {
            this.apiTests.add(new ListTest());
        }
        this.apiTests.add(new SubCompoundsTest());
        if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3)) {
            this.apiTests.add(new MergeTest());
        }
        this.apiTests.add(new ForEachTest());
        this.apiTests.add(new StreamTest());
        this.apiTests.add(new EqualsTest());
        if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3)) {
            this.apiTests.add(new IteratorTest());
        }
        if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3)) {
            this.apiTests.add(new ItemConvertionTest());
        }
        this.apiTests.add(new EmptyItemTest());
        if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3)) {
            this.apiTests.add(new ItemMergingTest());
            this.apiTests.add(new DirectApplyTest());
        }
        this.apiTests.add(new EntityTest());
        this.apiTests.add(new EntityCustomNbtPersistentTest());
        this.apiTests.add(new TileTest());
        this.apiTests.add(new TilesCustomNBTPersistentTest());
        this.apiTests.add(new ChunkNBTPersistentTest());
        this.apiTests.add(new BlockNBTTest());
        this.apiTests.add(new NBTFileTest());
        this.apiTests.add(new WorldDataTest());
        this.apiTests.add(new TilesCustomNBTInjectorTest());
        this.apiTests.add(new MergeTileSubCompoundTest());
        this.apiTests.add(new EntityCustomNbtInjectorTest());
        this.apiTests.add(new SpawnEntityCustomNbtInjectorTest());
        if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_8_R3)) {
            this.apiTests.add(new GameprofileTest());
        }
    }

    /*
     * WARNING - void declaration
     */
    public void onEnable() {
        void var5_10;
        instance = this;
        this.getLogger().info("Adding listeners...");
        Bukkit.getPluginManager().registerEvents((Listener)new ReloadListener(), (Plugin)this);
        this.getLogger().info("Gson:");
        MinecraftVersion.hasGsonSupport();
        this.getLogger().info("Checking bindings...");
        MinecraftVersion.getVersion();
        boolean classUnlinked = false;
        for (ClassWrapper classWrapper : ClassWrapper.values()) {
            if (!classWrapper.isEnabled() || classWrapper.getClazz() != null) continue;
            if (!classUnlinked) {
                this.getLogger().info("Classes:");
            }
            this.getLogger().warning(classWrapper.name() + " did not find it's class!");
            this.compatible = false;
            classUnlinked = true;
        }
        if (!classUnlinked) {
            this.getLogger().info("All Classes were able to link!");
        }
        boolean methodUnlinked = false;
        ReflectionMethod[] reflectionMethodArray = ReflectionMethod.values();
        int n2 = reflectionMethodArray.length;
        boolean bl2 = false;
        while (var5_10 < n2) {
            ReflectionMethod method = reflectionMethodArray[var5_10];
            if (method.isCompatible() && !method.isLoaded()) {
                if (!methodUnlinked) {
                    this.getLogger().info("Methods:");
                }
                this.getLogger().warning(method.name() + " did not find the method!");
                this.compatible = false;
                methodUnlinked = true;
            }
            ++var5_10;
        }
        if (!methodUnlinked) {
            this.getLogger().info("All Methods were able to link!");
        }
        this.getLogger().info("Running NBT reflection test...");
        HashMap<Test, Exception> results = new HashMap<Test, Exception>();
        for (Test test : this.apiTests) {
            try {
                test.test();
                results.put(test, null);
            } catch (Exception ex) {
                results.put(test, ex);
                this.getLogger().log(Level.WARNING, "Error during '" + test.getClass().getSimpleName() + "' test!", ex);
            } catch (NoSuchFieldError th) {
                this.getLogger().log(Level.SEVERE, "Servere error during '" + test.getClass().getSimpleName() + "' test!");
                this.getLogger().warning("WARNING! This version of Item-NBT-API seems to be broken with your Spigot version! Canceled the other tests!");
                throw th;
            }
        }
        for (Map.Entry entry : results.entrySet()) {
            if (entry.getValue() != null) {
                this.compatible = false;
            }
            this.getLogger().info(((Test)entry.getKey()).getClass().getSimpleName() + ": " + (entry.getValue() == null ? "Ok" : ((Exception)entry.getValue()).getMessage()));
        }
        String checkMessage = "Plugins that don't check properly may throw Exeptions, crash or have unexpected behaviors!";
        if (this.compatible) {
            this.getLogger().info("Success! This version of NBT-API is compatible with your server.");
        } else {
            this.getLogger().warning("WARNING! This version of NBT-API seems to be broken with your Spigot version! " + checkMessage);
            if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
                this.getLogger().warning("1.7.10 is only partally supported! Some thing will not work/are not yet avaliable in 1.7.10!");
            }
        }
    }

    public boolean isCompatible() {
        return this.compatible;
    }
}

