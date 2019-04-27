package me.askingg.giveall.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.askingg.giveall.command.GiveallCMD;
import me.askingg.giveall.utils.Files;

public class Main extends JavaPlugin {

	public void onEnable() {
		Files.base();
		getCommand("giveall").setExecutor(new GiveallCMD());
	}
}