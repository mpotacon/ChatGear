package com.github.mpotacon.chatgear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

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
	private int i;
	private String[] group;
	private String[] groupcolor;
	private String[] groupchatcolor;
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		PermissionUser user = PermissionsEx.getUser(player);
		@SuppressWarnings("unused")
		boolean isInGroup = user.inGroup(group[i]);
		
		if(mutedPlayers.containsKey(player.getName())){
			try{
			event.setCancelled(true);
			player.sendMessage("muted");
			} catch (Exception e){
				event.setMessage("");
			}
		}
	 	String symbol =  ChatColor.translateAlternateColorCodes('&', Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("break"));
	 	String PEx = Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("PExColor");
			
	 	String name = player.getDisplayName();
		String prefix = ChatColor.translateAlternateColorCodes('&', user.getOwnPrefix());
	 	String suffix = ChatColor.translateAlternateColorCodes('&', user.getOwnSuffix());

	 	for(int i = 0; i < i; i++){
	 		group[i] = 	Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("PEx.Group" + i);
	 		groupcolor[i] = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("PEx.Group" + i + ".color"));
	 		groupchatcolor[i] = ChatColor.translateAlternateColorCodes('&', "&" + Bukkit.getPluginManager().getPlugin("chatgear").getConfig().getString("PEx.Group" + i + ".chatcolor"));
	 	}
	 	if(prefix != null ){
	 		if (PEx == "Yes" || PEx == "YES"){
	 			event.setFormat(name + suffix + " " + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 		}else{
	 			event.setFormat(groupcolor[i] + name + symbol + " " + groupchatcolor[i] + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 		}
	 	}else if(suffix != null){
	 		if (PEx == "Yes" || PEx == "YES"){
	 			Logger.getLogger("Minecraft").info("[chatgear] config.yml Error: PExColor= Yes but PermissionsEx has no suffix");
	 		}else{
	 			event.setFormat(prefix + groupcolor[i] + name + symbol + " " + groupchatcolor[i] + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 		}
	 	}else{
	 		if (PEx == "Yes" || PEx == "YES"){
	 			event.setFormat(prefix + name + suffix + symbol + " " + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 		}else{
	 			event.setFormat(prefix + groupcolor[i] + name + suffix + symbol + " " + groupchatcolor[i] + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 		}
	 	}
	 }
}
