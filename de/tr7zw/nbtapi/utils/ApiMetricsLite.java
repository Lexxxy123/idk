/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  org.bukkit.Bukkit
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.RegisteredServiceProvider
 *  org.bukkit.plugin.ServicePriority
 */
package de.tr7zw.nbtapi.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;

public class ApiMetricsLite {
    private static final String PLUGINNAME = "ItemNBTAPI";
    public static final int B_STATS_VERSION = 1;
    public static final int NBT_BSTATS_VERSION = 1;
    private static final String URL = "https://bStats.org/submitData/bukkit";
    private boolean enabled;
    private static boolean logFailedRequests;
    private static boolean logSentData;
    private static boolean logResponseStatusText;
    private static String serverUUID;
    private Plugin plugin;

    public ApiMetricsLite() {
        Plugin[] pluginArray = Bukkit.getPluginManager().getPlugins();
        int n2 = pluginArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            Plugin plug;
            this.plugin = plug = pluginArray[i2];
            if (this.plugin != null) break;
        }
        if (this.plugin == null) {
            return;
        }
        File bStatsFolder = new File(this.plugin.getDataFolder().getParentFile(), "bStats");
        File configFile = new File(bStatsFolder, "config.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration((File)configFile);
        if (!config.isSet("serverUuid")) {
            config.addDefault("enabled", (Object)true);
            config.addDefault("serverUuid", (Object)UUID.randomUUID().toString());
            config.addDefault("logFailedRequests", (Object)false);
            config.addDefault("logSentData", (Object)false);
            config.addDefault("logResponseStatusText", (Object)false);
            config.options().header("bStats collects some data for plugin authors like how many servers are using their plugins.\nTo honor their work, you should not disable it.\nThis has nearly no effect on the server performance!\nCheck out https://bStats.org/ to learn more :)").copyDefaults(true);
            try {
                config.save(configFile);
            } catch (IOException plug) {
                // empty catch block
            }
        }
        serverUUID = config.getString("serverUuid");
        logFailedRequests = config.getBoolean("logFailedRequests", false);
        this.enabled = config.getBoolean("enabled", true);
        logSentData = config.getBoolean("logSentData", false);
        logResponseStatusText = config.getBoolean("logResponseStatusText", false);
        if (this.enabled) {
            boolean found = false;
            for (Class service : Bukkit.getServicesManager().getKnownServices()) {
                try {
                    service.getField("NBT_BSTATS_VERSION");
                    return;
                } catch (NoSuchFieldException noSuchFieldException) {
                    try {
                        service.getField("B_STATS_VERSION");
                        found = true;
                        break;
                    } catch (NoSuchFieldException noSuchFieldException2) {
                    }
                }
            }
            boolean fFound = found;
            if (Bukkit.isPrimaryThread()) {
                Bukkit.getServicesManager().register(ApiMetricsLite.class, (Object)this, this.plugin, ServicePriority.Normal);
                if (!fFound) {
                    MinecraftVersion.getLogger().info("[NBTAPI] Using the plugin '" + this.plugin.getName() + "' to create a bStats instance!");
                    this.startSubmitting();
                }
            } else {
                Bukkit.getScheduler().runTask(this.plugin, () -> {
                    Bukkit.getServicesManager().register(ApiMetricsLite.class, (Object)this, this.plugin, ServicePriority.Normal);
                    if (!fFound) {
                        MinecraftVersion.getLogger().info("[NBTAPI] Using the plugin '" + this.plugin.getName() + "' to create a bStats instance!");
                        this.startSubmitting();
                    }
                });
            }
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    private void startSubmitting() {
        final Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {
                if (!ApiMetricsLite.this.plugin.isEnabled()) {
                    timer.cancel();
                    return;
                }
                Bukkit.getScheduler().runTask(ApiMetricsLite.this.plugin, () -> ApiMetricsLite.this.submitData());
            }
        }, 300000L, 1800000L);
    }

    public JsonObject getPluginData() {
        JsonObject data = new JsonObject();
        data.addProperty("pluginName", PLUGINNAME);
        data.addProperty("pluginVersion", "2.8.0");
        data.add("customCharts", (JsonElement)new JsonArray());
        return data;
    }

    private JsonObject getServerData() {
        int playerAmount;
        try {
            Method onlinePlayersMethod = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers", new Class[0]);
            playerAmount = onlinePlayersMethod.getReturnType().equals(Collection.class) ? ((Collection)onlinePlayersMethod.invoke(Bukkit.getServer(), new Object[0])).size() : ((Player[])onlinePlayersMethod.invoke(Bukkit.getServer(), new Object[0])).length;
        } catch (Exception e2) {
            playerAmount = Bukkit.getOnlinePlayers().size();
        }
        int onlineMode = Bukkit.getOnlineMode() ? 1 : 0;
        String bukkitVersion = Bukkit.getVersion();
        String bukkitName = Bukkit.getName();
        String javaVersion = System.getProperty("java.version");
        String osName = System.getProperty("os.name");
        String osArch = System.getProperty("os.arch");
        String osVersion = System.getProperty("os.version");
        int coreCount = Runtime.getRuntime().availableProcessors();
        JsonObject data = new JsonObject();
        data.addProperty("serverUUID", serverUUID);
        data.addProperty("playerAmount", (Number)playerAmount);
        data.addProperty("onlineMode", (Number)onlineMode);
        data.addProperty("bukkitVersion", bukkitVersion);
        data.addProperty("bukkitName", bukkitName);
        data.addProperty("javaVersion", javaVersion);
        data.addProperty("osName", osName);
        data.addProperty("osArch", osArch);
        data.addProperty("osVersion", osVersion);
        data.addProperty("coreCount", (Number)coreCount);
        return data;
    }

    private void submitData() {
        final JsonObject data = this.getServerData();
        JsonArray pluginData = new JsonArray();
        for (Class service : Bukkit.getServicesManager().getKnownServices()) {
            try {
                service.getField("B_STATS_VERSION");
                for (RegisteredServiceProvider provider : Bukkit.getServicesManager().getRegistrations(service)) {
                    try {
                        Object plugin = provider.getService().getMethod("getPluginData", new Class[0]).invoke(provider.getProvider(), new Object[0]);
                        if (plugin instanceof JsonObject) {
                            pluginData.add((JsonElement)((JsonObject)plugin));
                            continue;
                        }
                        try {
                            Class<?> jsonObjectJsonSimple = Class.forName("org.json.simple.JSONObject");
                            if (!plugin.getClass().isAssignableFrom(jsonObjectJsonSimple)) continue;
                            Method jsonStringGetter = jsonObjectJsonSimple.getDeclaredMethod("toJSONString", new Class[0]);
                            jsonStringGetter.setAccessible(true);
                            String jsonString = (String)jsonStringGetter.invoke(plugin, new Object[0]);
                            JsonObject object = new JsonParser().parse(jsonString).getAsJsonObject();
                            pluginData.add((JsonElement)object);
                        } catch (ClassNotFoundException e2) {
                            if (!logFailedRequests) continue;
                            MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI][BSTATS] Encountered exception while posting request!", e2);
                        }
                    } catch (IllegalAccessException | NoSuchMethodException | NullPointerException | InvocationTargetException exception) {}
                }
            } catch (NoSuchFieldException noSuchFieldException) {
            }
        }
        data.add("plugins", (JsonElement)pluginData);
        new Thread(new Runnable(){

            @Override
            public void run() {
                block2: {
                    try {
                        ApiMetricsLite.sendData(ApiMetricsLite.this.plugin, data);
                    } catch (Exception e2) {
                        if (!logFailedRequests) break block2;
                        MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI][BSTATS] Could not submit plugin stats of " + ApiMetricsLite.this.plugin.getName(), e2);
                    }
                }
            }
        }).start();
    }

    private static void sendData(Plugin plugin, JsonObject data) throws Exception {
        String line;
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null!");
        }
        if (Bukkit.isPrimaryThread()) {
            throw new IllegalAccessException("This method must not be called from the main thread!");
        }
        if (logSentData) {
            System.out.println("[NBTAPI][BSTATS] Sending data to bStats: " + data.toString());
        }
        HttpsURLConnection connection = (HttpsURLConnection)new URL(URL).openConnection();
        byte[] compressedData = ApiMetricsLite.compress(data.toString());
        connection.setRequestMethod("POST");
        connection.addRequestProperty("Accept", "application/json");
        connection.addRequestProperty("Connection", "close");
        connection.addRequestProperty("Content-Encoding", "gzip");
        connection.addRequestProperty("Content-Length", String.valueOf(compressedData.length));
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("User-Agent", "MC-Server/1");
        connection.setDoOutput(true);
        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
        outputStream.write(compressedData);
        outputStream.flush();
        outputStream.close();
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
        }
        bufferedReader.close();
        if (logResponseStatusText) {
            MinecraftVersion.getLogger().info("[NBTAPI][BSTATS] Sent data to bStats and received response: " + builder.toString());
        }
    }

    private static byte[] compress(String str) throws IOException {
        if (str == null) {
            return new byte[0];
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(outputStream);
        gzip.write(str.getBytes(StandardCharsets.UTF_8));
        gzip.close();
        return outputStream.toByteArray();
    }
}

