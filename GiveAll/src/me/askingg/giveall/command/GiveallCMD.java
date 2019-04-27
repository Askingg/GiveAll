package me.askingg.giveall.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.askingg.giveall.utils.Files;
import me.askingg.giveall.utils.Message;

public class GiveallCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 0) {
			Message.sender(Files.config.getString("format.list.header"), sender);
			Message.sender(Files.config.getString("format.list.item").replace("%subcommand%", "Reload")
					.replace("%executecmd%", "Reload the config"), sender);
			Message.sender("&7", sender);
			if (Files.config.getConfigurationSection("commands") != null) {
				for (String key : Files.config.getConfigurationSection("commands").getKeys(false)) {
					Message.sender(Files.config.getString("format.list.item").replace("%subcommand%", key)
							.replace("%executecmd%", Files.config.getString("commands." + key + ".command")), sender);
				}
			}
			Message.sender(Files.config.getString("format.list.footer"), sender);
			return true;
		} else {
			if (args[0].equalsIgnoreCase("reload")) {
				try {
					Files.base();
					Message.sender("%prefix% Reloaded config file", sender);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				return true;
			}
			for (String str : Files.config.getConfigurationSection("commands").getKeys(false)) {
				if (args[0].equals(str)) {
					Message.broadcast(Files.config
							.getString("commands." + args[0] + ".broadcast").replace("%player%", sender.getName()));
					String cmd = Files.config.getString("commands." + str + ".command");
					for (Player p : Bukkit.getOnlinePlayers()) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("%player%", p.getName()));
					}
					return true;
				}
			}
			Message.sender(Files.config.getString("message.invalidsubcommand").replaceAll("%cmd%", args[0]), sender);
			return true;
		}
	}
}
