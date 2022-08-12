package com.caizi.compatibilities.enumerate;

import org.bukkit.event.Listener;

// 其他项目的枚举继承这个
public interface BaseCompatiblePlugin {
    String getPluginName();

    boolean getNative();

    Class<? extends Listener> getCompatibilityPlugin();
}
