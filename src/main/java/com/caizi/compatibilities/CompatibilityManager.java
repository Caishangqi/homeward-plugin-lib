package com.caizi.compatibilities;

import com.caizi.utils.logs.ConsoleLogger;
import com.caizi.utils.logs.LoggerManipulationType;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.HashMap;

public class CompatibilityManager {

    public final HashMap<Plugin, Class<? extends Listener>> ACTIVATED_COMPATIBILITY = new HashMap<>();
    private Plugin plugin;
    private ConsoleLogger logger;
    private CompatibilityListener compatibilityListener;
    protected final HashMap<String, Class<? extends Listener>> UNLOADED_COMPATIBILITY = new HashMap<>();
    private final String COMPATIBILITY_PACKAGE_NAME = "compatibilities.provided";


    public CompatibilityManager(Plugin plugin, ConsoleLogger logger, Class<? extends Listener> clazz) {
        this.plugin = plugin;
        this.logger = logger;
        compatibilityListener = new CompatibilityListener(logger, plugin);
        addUnloadedCompatibilityList();
        addActivatedCompatibilityList(clazz);
        registerCompatibility();
    }

    private void addActivatedCompatibilityList(Class<? extends Listener> clazz) {
        UNLOADED_COMPATIBILITY.forEach((K, V) -> {
            Plugin plugin = Bukkit.getPluginManager().getPlugin(K);
            ACTIVATED_COMPATIBILITY.put(plugin, V);
        });
        //Register Original Compatibility
        ACTIVATED_COMPATIBILITY.put(plugin, clazz);
    }

    protected void addUnloadedCompatibilityList() {

        Arrays.stream(CompatibilityList.values()).toList().forEach(K -> {
            if (Bukkit.getPluginManager().isPluginEnabled(K.getPluginName()) && K.getNative()) {
                UNLOADED_COMPATIBILITY.put(K.getPluginName(), K.getCompatibilityPlugin());
            }
        });
    }

    private void registerCompatibility() {
        ACTIVATED_COMPATIBILITY.forEach((K, V) -> {
            try {
                if (V.getDeclaredConstructor().getParameterCount() == 0) {
                    Listener listener = V.getDeclaredConstructor().newInstance();
                    Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);

                    logger.send(LoggerManipulationType.LOAD, "兼容插件" + K.getName() + "成功加载");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        });
    }


}
