package org.kew.preventsnowmelting;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("NullableProblems")
public final class Preventsnowcore extends JavaPlugin implements Listener {

    private boolean preventSnowMelting = true; // Default state

    @Override
    public void onEnable() {
        // Register the event listener
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("PreventSnowMelting plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PreventSnowMelting plugin disabled!");
    }

    @EventHandler
    public void onSnowMelt(BlockFadeEvent event) {
        // If the feature is disabled, do nothing
        if (!preventSnowMelting) return;

        // listen for any events that have something to do with snow
        if (event.getBlock().getType().toString().contains("SNOW")) {
            event.setCancelled(true); // prevent the event from uh.... executing? something.
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("preventsnow")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("true")) {
                    preventSnowMelting = true;
                    sender.sendMessage("§aSnow melting prevention enabled!");
                    return true;
                } else if (args[0].equalsIgnoreCase("false")) {
                    preventSnowMelting = false;
                    sender.sendMessage("§cSnow melting prevention disabled!");
                    return true;
                }
            }
            sender.sendMessage("§eUsage: /preventsnow <true|false>");
            return false;
        }
        return false;
    }
}