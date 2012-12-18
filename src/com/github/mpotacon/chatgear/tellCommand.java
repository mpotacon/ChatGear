package com.github.mpotacon.chatgear;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class tellCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender,Command smd,String commandLabel,String[] args){
		Player player = (Player) sender;
		
		if(commandLabel.equalsIgnoreCase("tell") || commandLabel.equalsIgnoreCase("message")){
			if(Bukkit.getPlayer(args[0]).hasPermission("chatgear.tell")){
				if(args.length == 0){
					player.sendMessage(ChatColor.RED + "/tell <to> <Message>");
					return true;
				}else if(args.length >= 1){
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					if(sender == targetPlayer){
						player.sendMessage(ChatColor.RED + "You CANNOT send your self a message");
					}else if(player.getServer().getPlayer(args[0])!= null ){
						StringBuilder message = new StringBuilder();
	                    	for(int i = 1; i < args.length; i++){
	                    		message.append(args[i]);
	                    		message.append(" ");
	                    	}
	                    	String from = "&8[&7From &4" + sender.getName() + " &8] : &7" + message.toString().trim();
	                    	String to = "&8[&7To &4" + targetPlayer.getName() + " &8] : &7" + message.toString().trim();
	                        	if(Bukkit.getPlayer(args[0]).hasPermission("chatgear.receive")){
	                        		Bukkit.getPlayer(args[0]).sendMessage(ChatColor.translateAlternateColorCodes('&', from));
	                        		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', to));
	                        	}
	                        	//targetPlayer.sendMessage(args[1]);
	                        	return true;
					}else{
						player.sendMessage(ChatColor.RED + "Player Not Online");
						return true;
					}
				}
			}else{
				player.sendMessage(ChatColor.RED + "You do not have permission to send a message");
				return true;
			}
		}
		return false;	
	}
}
