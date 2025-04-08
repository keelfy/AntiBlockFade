package org.keelfy.antifade.listener;

import lombok.RequiredArgsConstructor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import org.keelfy.antifade.config.ConfigManager;

@RequiredArgsConstructor
public class BlockFadeListener implements Listener {

    private final ConfigManager config;

    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {
        if (!config.isPluginEnabled()) {
            return;
        }

        final NamespacedKey namespacedKey = event.getBlock().getType().getKey();
        if (config.getBlockPreventedFromFading().contains(namespacedKey.toString())) {
            event.setCancelled(true);
        }
    }

}
