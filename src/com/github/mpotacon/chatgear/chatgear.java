package com.github.mpotacon.chatgear;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

//import ru.tehkode.permissions.PermissionUser;
//import ru.tehkode.permissions.bukkit.PermissionsEx;

public final class chatgear extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static chatgear plugin;
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version:" + pdfFile.getVersion() + " Has Been Enabled");
		getServer().getPluginManager().registerEvents(new chatListener(), this);
	}
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("ping")){
			player.sendMessage(ChatColor.WHITE + "pong");
		}
		return false;
	}
	
//	@EventHandler
//	public void onPlayerJoin(PlayerJoinEvent event) {
//	 	PermissionUser user = PermissionsEx.getUser(player);
//	 	String prefix = user.getOwnPrefix();
//	 	String suffix = user.getOwnSuffix();
//	 	if(user.inGroup("Zeta"){
//	 			player.sendMessage("Welcome back donator , " + prefix + player.getDisplayName() + suffix + "!");
//	 	}
//	 }
}
