package org.keelfy.antifade.config;

import lombok.RequiredArgsConstructor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ConfigManager {

    private final JavaPlugin plugin;

    public void initConfig() {
        plugin.saveDefaultConfig();
    }

    public String getMessage(String key) {
        return Optional.ofNullable(plugin.getConfig().getString("messages." + key))
                .map(str -> str.replace("&", "§"))
                .orElse("");
    }

    public List<String> getBlockPreventedFromFading() {
        return plugin.getConfig().getStringList("blocks-prevented-from-fading");
    }

    public boolean isPluginEnabled() {
        return plugin.getConfig().getBoolean("enabled");
    }

    public void setEnabled(boolean enabled) {
        plugin.getConfig().set("enabled", enabled);
        plugin.saveConfig();
    }

}
