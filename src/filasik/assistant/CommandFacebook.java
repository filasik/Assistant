package filasik.assistant;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CommandFacebook implements CommandExecutor {
    private Plugin plugin = Assistant.getPlugin(Assistant.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GREEN + "");
            player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("text-facebook",ChatColor.RED+"Not defined ")+" " + plugin.getConfig().getString("server-facebook", ChatColor.RED + "Not defined"));
            System.out.println(player.getName() + " " + plugin.getConfig().getString("console-facebook-shown"));
        }
        return true;
    }
}
