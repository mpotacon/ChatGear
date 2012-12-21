package com.github.mpotacon.chatgear;

//import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.HashMap;

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
/*
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
	 	//String suffix = user.getOwnSuffix();
	//Alpha
		if(user.inGroup("Alpha")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&2Alpha&8&l】&7");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
	//Beta	
		}else if(user.inGroup("Beta")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&eBeta&8&l】&7");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
	//Gamma	
		}else if(user.inGroup("Gamma")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&3Gamma&8&l】&7");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			} 
	//Epsilon
		}else if(user.inGroup("Epsilon")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&4Epsilon&8&l】&7");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage())); 
			}
	//Free	
		}else if(user.inGroup("Free")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&1Free&8&l】&7");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage())); 
			}
	//AlphaGaurd
		}else if(user.inGroup("AlphaGuard")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&aAlpha&cGuard&8&l】&9");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage())); 
			}
	//BetaGaurd
		}else if(user.inGroup("BetaGuard")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&eBeta&cGuard&8&l】&9");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
	//GammaGuard
		}else if(user.inGroup("GammaGuard")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&3Gamma&cGuard&8&l】&9");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
	//DeltaGuard	
		}else if(user.inGroup("DeltaGuard")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&5Delta&cGuard&8&l】&9");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
	//EpsilonGuard
		}else if(user.inGroup("EpsilonGuard")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&4Epsilon&cGuard&8&l】&9");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
	//HeadGuard
		}else if(user.inGroup("HeadGuard")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&4&lHead&cGuard&8&l】&9");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
	//Warden
		}else if(user.inGroup("Warden")){
			String prefix = ChatColor.translateAlternateColorCodes('&',  "&8&l【&4&lWarden&8&l】&9");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.YELLOW + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
	//bpo
		}else if(user.inGroup("BPO")){
			String prefix = ChatColor.translateAlternateColorCodes('&', "&8&l【&4W&7arden&8&l】&6");
			if(user.inGroup("Zeta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4Z&8eta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Theta")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4T&2heta&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Sigma")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4S&9igma&8&l");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("Omega")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4O&6mega&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else if(user.inGroup("ChatMod")){
				String suffix = ChatColor.translateAlternateColorCodes('&', "&8&l[&4C&chat&4M&cod&8&l]");
				event.setFormat(prefix + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}else{
				event.setFormat(prefix  + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.YELLOW + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
			}
		}
}
*/
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
	 	if(user.inGroup("Warden")){
	 		event.setFormat(prefix  + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.YELLOW + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 	}else if(user.inGroup("bpo")){ 
	 		event.setFormat(prefix  + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.YELLOW + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 	}else if(suffix != null){
	 		event.setFormat(prefix  + event.getPlayer().getDisplayName() + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 	}else{
	 		event.setFormat(prefix  + event.getPlayer().getDisplayName() + suffix + ChatColor.GRAY + ": "+ ChatColor.WHITE + ChatColor.translateAlternateColorCodes('&', event.getMessage()));
	 	}
	 }
}
