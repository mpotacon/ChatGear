package com.github.mpotacon.chatgear;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class chatPEx implements Listener {
	
	public final static HashMap<String, ArrayList<Block>> mutedPlayers = new HashMap<String, ArrayList<Block>>();
	public static chatgear plugin;

	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		if(mutedPlayers.containsKey(player.getName())){
			try{
			event.setCancelled(true);
			player.sendMessage("muted");
			} catch (Exception e){
				event.setMessage("");
			}
		}
		String OP = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("OP.color") + player.getDisplayName());
	 	String OPcolor = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("OP.chatcolor") + event.getMessage());
	 	String nonOP = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("player.color") + player.getDisplayName());
	 	String nonOPcolor = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("player.chatcolor") + event.getMessage());
	 	String symbol =  ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("break"));
				
		PermissionUser user = PermissionsEx.getUser(player);
	 	String prefix = ChatColor.translateAlternateColorCodes('&', user.getOwnPrefix());
	 	String suffix = ChatColor.translateAlternateColorCodes('&', user.getOwnSuffix());
	 	String admin =  Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("AdminGroup");
	 	String mod = Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("ModGroup");
	 	if(user.inGroup(admin)){
	 		if(prefix != null & suffix != null){
	 			if (OP == "PEx"){
	 				event.setFormat(player.getDisplayName() + symbol + " "+ OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}else{
	 				event.setFormat(OP + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}
	 		}else if(prefix != null){
	 			if (OP == "PEx"){	
	 				event.setFormat(player.getDisplayName() + suffix + " " + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}else{
	 				event.setFormat(OP + suffix + " " + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}
	 		}else if(suffix != null){
	 			if (OP == "PEx"){
	 				event.setFormat(prefix + player.getDisplayName() + symbol + " "+ OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}else{
	 				event.setFormat(prefix + OP + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}
	 		}else{
	 			if (OP == "PEx"){
	 				event.setFormat(prefix + player.getDisplayName() + suffix + symbol + " "+ OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}else{
	 				event.setFormat(prefix + OP + suffix + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}
	 		}
	 	}else if(user.inGroup(mod)){
	 		if(prefix != null & suffix != null){
	 			if (OP == "PEx"){
	 				event.setFormat(player.getDisplayName() + symbol + " "+ OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}else{
	 				event.setFormat(OP + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}
	 		}else if(prefix != null){
	 			if (OP == "PEx"){	
	 				event.setFormat(player.getDisplayName() + suffix + " " + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}else{
	 				event.setFormat(OP + suffix + " " + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}
	 		}else if(suffix != null){
	 			if (OP == "PEx"){
	 				event.setFormat(prefix + player.getDisplayName() + symbol + " "+ OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}else{
	 				event.setFormat(prefix + OP + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}
	 		}else{
	 			if (OP == "PEx"){
	 				event.setFormat(prefix + player.getDisplayName() + suffix + symbol + " "+ OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}else{
	 				event.setFormat(prefix + OP + suffix + symbol + " " + OPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 			}
	 		}
	 	}else if(prefix != null & suffix != null){
	 		if (nonOP == "PEx"){
 				event.setFormat(player.getDisplayName() + symbol + " "+ nonOPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
 			}else{
 				event.setFormat(nonOP + symbol + " " + nonOPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
 			}
	 	}else if(prefix != null){
	 		if (nonOP == "PEx"){	
 				event.setFormat(player.getDisplayName() + suffix + " " + symbol + " " + nonOPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
 			}else{
 				event.setFormat(nonOP + suffix + " " + symbol + " " + nonOPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
 			}
	 	}else if(suffix != null){
	 		if (nonOP == "PEx"){
 				event.setFormat(prefix + player.getDisplayName() + symbol + " "+ nonOPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
 			}else{
 				event.setFormat(prefix + nonOP + symbol + " " + nonOPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
 			}
	 	}else{
	 		if (nonOP == "PEx"){
 				event.setFormat(prefix + player.getDisplayName() + suffix + symbol + " "+ nonOPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
 			}else{
 				event.setFormat(prefix + nonOP + suffix + symbol + " " + nonOPcolor + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
 			}
	 	}
	 }
}
