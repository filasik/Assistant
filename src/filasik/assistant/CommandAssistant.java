package filasik.assistant;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAssistant implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage("/assistant - all commands");
            player.sendMessage("/web - server website");
            player.sendMessage("/discord - Discord server");
            player.sendMessage("/teamspeak - Team Speak server");
            player.sendMessage("/facebook - Facebook");
        }
        return true;
    }
}
