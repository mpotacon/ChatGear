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

public class chatListener implements Listener {
	
	public final static HashMap<String, ArrayList<Block>> mutedPlayers = new HashMap<String, ArrayList<Block>>();
	public static chatgear plugin;
		
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		String OP = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("OP.color") + player.getDisplayName());
	 	String OPcolor = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("OP.chatcolor") + event.getMessage());
	 	String nonOP = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("player.color") + player.getDisplayName());
	 	String nonOPcolor = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("player.chatcolor") + event.getMessage());
	 	String symbol =  ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("break"));
		if(mutedPlayers.containsKey(player.getName())){
			try{
			event.setCancelled(true);
			player.sendMessage("muted");
			} catch (Exception e){
				event.setMessage("");
			}
		}else if(player.isOp()){
	 		event.setFormat(OP+ " " + symbol + " " + OPcolor);
	 	}else{ 
	 		event.setFormat(nonOP + " " + symbol + " " + nonOPcolor);
	 	}
	 }
}	
