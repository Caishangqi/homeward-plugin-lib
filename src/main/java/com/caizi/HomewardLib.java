package com.caizi;

import com.caizi.command.MainCommand;
import com.caizi.utils.logs.ConsoleLogger;
import com.caizi.utils.logs.CustomLogger;
import com.caizi.utils.logs.LoggerManipulationType;
import me.mattstudios.mf.base.CommandManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomewardLib extends JavaPlugin {

    public final static String packageName = HomewardLib.class.getPackageName();
    public static final String LISTENER_PACKAGE_NAME = "listener";
    public static final String EVENTS_PACKAGE_NAME = "event";
    public static FileConfiguration config;
    public static CommandManager commandManager;
    public static ConsoleLogger consoleLogger;
    public static CustomLogger customLogger;
    private static String pluginPrefix = "&3HLib &f| ";

    public static HomewardLib plugin;

    @Override
    public void onEnable() {
        initializedComponents();
        registerCommands();
        loadConfigurations();
        // Plugin startup logic
    }

    private void registerCommands() {
        commandManager = new CommandManager(this);
        commandManager.register(new MainCommand());
    }

    private void initializedComponents() {
        plugin = this;
        consoleLogger = new ConsoleLogger();
        customLogger = new CustomLogger();
        customLogger.setLoggerPrefix(pluginPrefix);
        consoleLogger.setLoggerPrefix(pluginPrefix);
        consoleLogger.send(LoggerManipulationType.LOAD,"正在初始化 " +this.getName()+ " 的必要组件");
    }

    private void loadConfigurations() {
        //注册默认Config,没有的话创建一个
        saveDefaultConfig();
        config = getConfig();

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        consoleLogger.send(LoggerManipulationType.UNLOAD,"关闭 "+this.getName()+" 中...");
    }

    public static HomewardLib getInstance() {
        return plugin;
    }
}
