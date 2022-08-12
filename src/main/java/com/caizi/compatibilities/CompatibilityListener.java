package com.caizi.compatibilities;

import com.caizi.utils.logs.ConsoleLogger;
import com.caizi.utils.logs.LoggerManipulationType;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public class CompatibilityListener implements Listener {

    private ConsoleLogger logger;
    private Plugin plugin;

    public CompatibilityListener(ConsoleLogger logger, Plugin plugin) {
        this.logger = logger;
        this.plugin = plugin;
        logger.send(LoggerManipulationType.INFO,"尝试加载兼容性");
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPluginEnable(PluginEnableEvent event) {
        logger.send(LoggerManipulationType.LOAD,"插件 " + event.getPlugin().getName() + " 已加载");
        //CompatibilitiesManager.enableCompatibility(event.getPlugin().getName());
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {
        //CompatibilitiesManager.disableCompatibility(event.getPlugin().getName());
    }

}
