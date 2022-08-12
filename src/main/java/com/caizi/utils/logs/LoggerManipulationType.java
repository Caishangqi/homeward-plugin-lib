package com.caizi.utils.logs;

public enum LoggerManipulationType {

    LOAD("&7(&2+&7)"),
    UNLOAD("&7(&c-&7)"),
    WARN("&7(&6!&7)"),
    ERROR("&7(&4x&7)"),
    INSPECTION("&7(&d🔍&7)"),
    INFO("&7(&d->&7)");

    private String icon;

    LoggerManipulationType(String icon) {
        this.icon = icon;
    }

    LoggerManipulationType() {

    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
