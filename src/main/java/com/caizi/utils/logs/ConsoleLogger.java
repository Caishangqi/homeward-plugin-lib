package com.caizi.utils.logs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

public class ConsoleLogger {

    protected String loggerPrefix;

    private final ConsoleCommandSender sender = Bukkit.getConsoleSender();


    public ConsoleLogger(String loggerPrefix) {
        this.loggerPrefix = loggerPrefix;
    }

    public ConsoleLogger() {}

    /*
     *
     */

    public void send(LoggerManipulationType manipulationType, String message) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',loggerPrefix + manipulationType.getIcon() + " " + message));
    }

    public void setLoggerPrefix(String loggerPrefix) {
        this.loggerPrefix = loggerPrefix;
    }
}
