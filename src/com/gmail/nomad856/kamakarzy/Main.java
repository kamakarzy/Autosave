package com.gmail.nomad856.kamakarzy;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;

	public void onEnable() {
		getLogger().info(
				"By nomad856 aka kamakarzy with thanks to bukkit fourms team");
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + "Has Been Enabled");
		plugin = this;
		getConfig().options().copyDefaults(true);
		saveConfig();
		counter();
		return;
	}

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + "Has Been Disabled");
		saveConfig();
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equals("forcesave")) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saving_1"))));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saving_2"))));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			savePlayers();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saving_3"))));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saving_4"))));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			saveWorlds();
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saved"))));
		}
		return true;
	}

	private int saveWorlds() {
		int i = 0;
		List<World> worlds = this.getServer().getWorlds();
		for (World world : worlds) {
			world.save();
			i++;
		}
		return i;
	}
	
	private void savePlayers() {
		this.getServer().savePlayers();
	}
	
	public void counter(){
		int time =	getConfig().getInt("Time");
	    int ticks = time*1200;
	BukkitRunnable run = new BukkitRunnable() {
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saving_1"))));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			savePlayers();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saving_2"))));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saving_3"))));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			saveWorlds();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bukkit.broadcastMessage((ChatColor.translateAlternateColorCodes('&',getConfig().getString("Saved"))));
			return;

		}
	};
	run.runTaskTimer(this, 0L, Long.valueOf(ticks));
return;
}
}
