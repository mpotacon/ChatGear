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
		PermissionUser user = PermissionsEx.getUser(player);
	 	String prefix = ChatColor.translateAlternateColorCodes('&', user.getOwnPrefix());
	 	String suffix = ChatColor.translateAlternateColorCodes('&', user.getOwnSuffix());
	 	String admin =  Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("AdminGroup");
	 	String mod = Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("ModGroup");
	 	if(user.inGroup(admin)){
	 		event.setFormat(prefix  + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.YELLOW + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 	}else if(user.inGroup(mod)){ 
	 		event.setFormat(prefix  + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.YELLOW + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 	}else if(suffix != null){
	 		event.setFormat(prefix  + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 	}else{
	 		event.setFormat(prefix  + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 	}
	 }
}
