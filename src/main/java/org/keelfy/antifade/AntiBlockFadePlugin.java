package org.keelfy.antifade;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.keelfy.antifade.command.CoreCommandExecutor;
import org.keelfy.antifade.config.ConfigManager;
import org.keelfy.antifade.listener.BlockFadeListener;

import java.util.Objects;

public final class AntiBlockFadePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        final ConfigManager configManager = new ConfigManager(this);
        configManager.initConfig();

        final Listener blockFadeListener = new BlockFadeListener(configManager);
        Bukkit.getPluginManager().registerEvents(blockFadeListener, this);

        final CommandExecutor coreCommand = new CoreCommandExecutor(configManager);
        Objects.requireNonNull(this.getCommand("antiblockfade")).setExecutor(coreCommand);

        getLogger().info("AntiBlockFade plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AntiBlockFade plugin disabled!");
    }

}