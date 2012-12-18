package com.github.mpotacon.chatgear;

//import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatListener implements Listener {
	public static chatgear plugin;
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event){
	    event.setMessage(ChatColor.RED + event.getPlayer().getName() + event.getMessage());
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
