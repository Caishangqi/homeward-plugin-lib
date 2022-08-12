package com.caizi.command;

import com.caizi.HomewardLib;
import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command("hlib")
public class MainCommand extends CommandBase {

    @Default
    public void defaultCommand(final CommandSender commandSender) {
        HomewardLib.customLogger.send("Welcome to use Hlib", (Player) commandSender);
    }

}
