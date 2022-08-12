package com.caizi.compatibilities.provided.minecraft;

import com.caizi.compatibilities.CompatibilityPlugin;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.bukkit.Material.CAULDRON;
import static org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;
import static org.bukkit.inventory.EquipmentSlot.HAND;

public class MinecraftCompatibility extends CompatibilityPlugin<Plugin> {

    @SuppressWarnings("unused") //invoke
    public static boolean isSimilar(ItemStack firstItems, ItemStack secondItems) {
        //Vanilla method
        return firstItems.isSimilar(secondItems);
    }


    @EventHandler
    public void onBlockClick(PlayerInteractEvent event) throws IOException {
    }





}



