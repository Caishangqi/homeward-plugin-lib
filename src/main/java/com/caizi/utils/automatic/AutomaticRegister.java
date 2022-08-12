package com.caizi.utils.automatic;

import com.caizi.HomewardLib;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.reflections.Reflections;

import java.util.Set;

@UtilityClass
public class AutomaticRegister {

    public static void register() {
        String listenerPath = getPath(HomewardLib.packageName, HomewardLib.LISTENER_PACKAGE_NAME);
        Set<Class<? extends Listener>> classes = new Reflections(listenerPath).getSubTypesOf(Listener.class);
        classes.forEach(var -> {
            try {
                if (var.getDeclaredConstructor().getParameterCount() == 0) {
                    Listener listener = var.getDeclaredConstructor().newInstance();
                    Bukkit.getServer().getPluginManager().registerEvents(listener, HomewardLib.getInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
                Bukkit.getPluginManager().disablePlugin(HomewardLib.getInstance());
            }
        });
    }

    public static String getPath(String path, String append) {
        return path + '.' + append;
    }

}
