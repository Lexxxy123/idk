/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.event.Listener
 *  org.bukkit.plugin.Plugin
 */
package vn.giakhanhvn.skysim.nms.nmsutil.apihelper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import vn.giakhanhvn.skysim.nms.nmsutil.apihelper.API;
import vn.giakhanhvn.skysim.nms.nmsutil.apihelper.RegisteredAPI;
import vn.giakhanhvn.skysim.nms.nmsutil.apihelper.exception.APIRegistrationException;
import vn.giakhanhvn.skysim.nms.nmsutil.apihelper.exception.MissingHostException;

public class APIManager {
    private static final Map<API, RegisteredAPI> HOST_MAP = new HashMap<API, RegisteredAPI>();
    private static final Map<Class<? extends API>, Set<Plugin>> PENDING_API_CLASSES = new HashMap<Class<? extends API>, Set<Plugin>>();
    private static final Logger LOGGER = Logger.getLogger("APIManager");

    public static RegisteredAPI registerAPI(API api) throws APIRegistrationException {
        if (HOST_MAP.containsKey(api)) {
            throw new APIRegistrationException("API for '" + api.getClass().getName() + "' is already registered");
        }
        RegisteredAPI registeredAPI = new RegisteredAPI(api);
        HOST_MAP.put(api, registeredAPI);
        api.load();
        LOGGER.fine("'" + api.getClass().getName() + "' registered as new API");
        return registeredAPI;
    }

    public static RegisteredAPI registerAPI(API api, Plugin host) throws IllegalArgumentException, APIRegistrationException {
        APIManager.validatePlugin(host);
        APIManager.registerAPI(api);
        return APIManager.registerAPIHost(api, host);
    }

    public static API registerEvents(API api, Listener listener) throws APIRegistrationException {
        if (!HOST_MAP.containsKey(api)) {
            throw new APIRegistrationException("API for '" + api.getClass().getName() + "' is not registered");
        }
        RegisteredAPI registeredAPI = HOST_MAP.get(api);
        if (registeredAPI.eventsRegistered) {
            return api;
        }
        Bukkit.getPluginManager().registerEvents(listener, registeredAPI.getNextHost());
        registeredAPI.eventsRegistered = true;
        return api;
    }

    private static void initAPI(API api) throws APIRegistrationException {
        if (!HOST_MAP.containsKey(api)) {
            throw new APIRegistrationException("API for '" + api.getClass().getName() + "' is not registered");
        }
        RegisteredAPI registeredAPI = HOST_MAP.get(api);
        registeredAPI.init();
    }

    public static void initAPI(Class<? extends API> clazz) throws APIRegistrationException {
        API clazzAPI = null;
        for (API api : HOST_MAP.keySet()) {
            if (!api.getClass().equals(clazz)) continue;
            clazzAPI = api;
            break;
        }
        if (clazzAPI == null) {
            if (!PENDING_API_CLASSES.containsKey(clazz)) {
                throw new APIRegistrationException("API for class '" + clazz.getName() + "' is not registered");
            }
            LOGGER.info("API class '" + clazz.getName() + "' is not yet initialized. Creating new instance.");
            try {
                clazzAPI = clazz.newInstance();
                APIManager.registerAPI(clazzAPI);
                for (Plugin plugin : PENDING_API_CLASSES.get(clazz)) {
                    if (plugin == null) continue;
                    APIManager.registerAPIHost(clazzAPI, plugin);
                }
            } catch (ReflectiveOperationException e2) {
                LOGGER.warning("API class '" + clazz.getName() + "' is missing valid constructor");
            }
            PENDING_API_CLASSES.remove(clazz);
        }
        APIManager.initAPI(clazzAPI);
    }

    private static void disableAPI(API api) {
        if (!HOST_MAP.containsKey(api)) {
            return;
        }
        RegisteredAPI registeredAPI = HOST_MAP.get(api);
        registeredAPI.disable();
        HOST_MAP.remove(api);
    }

    public static void disableAPI(Class<? extends API> clazz) {
        API clazzAPI = null;
        for (API api : HOST_MAP.keySet()) {
            if (!api.getClass().equals(clazz)) continue;
            clazzAPI = api;
            break;
        }
        APIManager.disableAPI(clazzAPI);
    }

    public static void require(Class<? extends API> clazz, Plugin host) {
        try {
            if (host == null) {
                throw new APIRegistrationException();
            }
            APIManager.registerAPIHost(clazz, host);
        } catch (APIRegistrationException e2) {
            if (PENDING_API_CLASSES.containsKey(clazz)) {
                PENDING_API_CLASSES.get(clazz).add(host);
            }
            HashSet<Plugin> hosts = new HashSet<Plugin>();
            hosts.add(host);
            PENDING_API_CLASSES.put(clazz, hosts);
        }
    }

    private static RegisteredAPI registerAPIHost(API api, Plugin host) throws APIRegistrationException {
        APIManager.validatePlugin(host);
        if (!HOST_MAP.containsKey(api)) {
            throw new APIRegistrationException("API for '" + api.getClass().getName() + "' is not registered");
        }
        RegisteredAPI registeredAPI = HOST_MAP.get(api);
        registeredAPI.registerHost(host);
        LOGGER.fine("'" + host.getName() + "' registered as Host for '" + api + "'");
        return registeredAPI;
    }

    public static RegisteredAPI registerAPIHost(Class<? extends API> clazz, Plugin host) throws APIRegistrationException {
        APIManager.validatePlugin(host);
        API clazzAPI = null;
        for (API api : HOST_MAP.keySet()) {
            if (!api.getClass().equals(clazz)) continue;
            clazzAPI = api;
            break;
        }
        if (clazzAPI == null) {
            throw new APIRegistrationException("API for class '" + clazz.getName() + "' is not registered");
        }
        return APIManager.registerAPIHost(clazzAPI, host);
    }

    public static Plugin getAPIHost(API api) throws APIRegistrationException, MissingHostException {
        if (!HOST_MAP.containsKey(api)) {
            throw new APIRegistrationException("API for '" + api.getClass().getName() + "' is not registered");
        }
        return HOST_MAP.get(api).getNextHost();
    }

    private static void validatePlugin(Plugin plugin) {
        if (plugin instanceof API) {
            throw new IllegalArgumentException("Plugin must not implement API");
        }
    }
}

