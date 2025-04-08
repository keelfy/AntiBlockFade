package org.keelfy.antifade.command;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.keelfy.antifade.config.ConfigManager;

@RequiredArgsConstructor
public class CoreCommandExecutor implements CommandExecutor {

    private final ConfigManager config;

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command,
                             @NonNull String label, String[] args) {

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("true")) {
                config.setEnabled(true);
                sender.sendMessage(config.getMessage("plugin-enabled"));
                return true;
            } else if (args[0].equalsIgnoreCase("false")) {
                config.setEnabled(false);
                sender.sendMessage(config.getMessage("plugin-disabled"));
                return true;
            }
        }
        sender.sendMessage(config.getMessage("usage"));
        return false;
    }

}
