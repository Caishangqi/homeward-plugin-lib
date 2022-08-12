package com.caizi.compatibilities;

import com.caizi.compatibilities.enumerate.BaseCompatiblePlugin;
import com.caizi.utils.logs.ConsoleLogger;
import com.caizi.utils.logs.LoggerManipulationType;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

// TODO 写文档注释

/**
 * ???
 *
 * @since ?
 * @author ?
 */
public class CompatibilityManager {

    public final HashMap<Plugin, Class<? extends Listener>> ACTIVATED_COMPATIBILITY = new HashMap<>();
    private final Plugin plugin;
    private final ConsoleLogger logger;
    private final CompatibilityListener compatibilityListener;
    protected final HashMap<String, Class<? extends Listener>> UNLOADED_COMPATIBILITY = new HashMap<>();
    private final String COMPATIBILITY_PACKAGE_NAME = "compatibilities.provided";

    public CompatibilityManager(Plugin plugin, ConsoleLogger logger, Class<? extends Listener> clazz, BaseCompatiblePlugin... compatiblePlugins) {
        this.plugin = plugin;
        this.logger = logger;
        compatibilityListener = new CompatibilityListener(logger, plugin);
        addUnloadedCompatibilityList(compatiblePlugins);
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

    private void addUnloadedCompatibilityList(BaseCompatiblePlugin... compatiblePlugins) {
        for (BaseCompatiblePlugin compatiblePlugin : compatiblePlugins) {
            if (Bukkit.getPluginManager().isPluginEnabled(compatiblePlugin.getPluginName()) && compatiblePlugin.getNative()) {
                UNLOADED_COMPATIBILITY.put(compatiblePlugin.getPluginName(), compatiblePlugin.getCompatibilityPlugin());
            }
        }
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
