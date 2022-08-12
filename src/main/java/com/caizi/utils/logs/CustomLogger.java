package com.caizi.utils.logs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CustomLogger extends ConsoleLogger{

    public CustomLogger(String loggerPrefix) {
        this.loggerPrefix = loggerPrefix;
    }

    public CustomLogger() {}

    public void send(LoggerManipulationType manipulationType, String message, Player player) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',loggerPrefix + manipulationType.getIcon() + " " + message));
    }

    public void send (String message, Player player) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',loggerPrefix + " " + message));

    }

}
