package me.askingg.giveall.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Message {
	
	public static void console(String msg) {
		Bukkit.getConsoleSender().sendMessage(Format.color(msg.replace("%prefix%", Files.config.getString("prefix"))));
	}

	public static void broadcast(String msg) {
		Bukkit.broadcastMessage(Format.color(msg.replace("%prefix%", Files.config.getString("prefix"))));
	}

	public static void player(String msg, Player player) {
		player.sendMessage(Format.color(msg.replace("%prefix%", Files.config.getString("prefix"))));
	}

	public static void sender(String msg, CommandSender sender) {
		sender.sendMessage(Format.color(msg.replace("%prefix%", Files.config.getString("prefix"))));
	}
}
