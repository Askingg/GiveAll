package me.askingg.giveall.utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.askingg.giveall.main.Main;

public class Files {

	public static File configFile;
	public static FileConfiguration config;

	public static void base() {
		Main main = Main.getPlugin(Main.class);
		if (!main.getDataFolder().exists())
			main.getDataFolder().mkdirs();
		configFile = new File(main.getDataFolder(), "config.yml");
		config = YamlConfiguration.loadConfiguration(configFile);
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
				config.set("prefix", "&8&l[&9&lGiveAll&8&l]&7");
				config.set("format.list.header", "%prefix% Available giveall commands:");
				config.set("format.list.item", "&8 ● &b/GA %subcommand% &7%executecmd%");
				config.set("format.list.footer", "");
				config.set("message.nosubcommands", "%prefix% Sorry, but no subcommands are currently setup");
				config.set("message.invalidsubcommand", "%prefix% Sorry, but &c%cmd%&7 is an invalid subcommand");
				config.set("message.nopermission", "%prefix% Sorry, but you don't have permission to do this");
				config.set("commands.dirt.command", "give %player% dirt 1");
				config.set("commands.dirt.broadcast", "%prefix% &b%player%&7 just gave all online players &b1x Dirt");
				config.set("commands.stone.command", "give %player% stone 1");  
				config.set("commands.stone.broadcast", "%prefix% &b%player%&7 just gave all online players &b1x Stone");  
				config.set("commands.tokens.command", "token give %player% 100");
				config.set("commands.tokens.broadcast", "%prefix% &b%player%&7 just gave all online players &b100 eTokens");
				config.set("commands.flesh.command", "flesh give %player% 25");
				config.set("commands.flesh.broadcast", "%prefix% &b%player%&7 just gave all online players &b25 flesh");
				config.set("commands.key.command", "crate give %player% Xenon 1");
				config.set("commands.key.broadcast", "%prefix% &b%player%&7 just gave all online players &b1x Xenon key");
				config.save(configFile);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}