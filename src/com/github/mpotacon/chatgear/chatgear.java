package com.github.mpotacon.chatgear;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class chatgear extends JavaPlugin {
	public static chatgear plugin;
	public final chatListener cl = new chatListener();
	public final chatPEx cPEx = new chatPEx();
	PluginManager pm = getServer().getPluginManager();
	
	@Override
	public void onEnable(){
		getCommand("tell").setExecutor(new tellCommand());
		getCommand("ping").setExecutor(new pingCommand());
		getCommand("mute").setExecutor(new muteCommand());
		if(pm.isPluginEnabled("PermissionsEx")){
			pm.registerEvents(this.cPEx, this);
		}else{
			pm.registerEvents(this.cl, this);
		}		
	}	
	
	@Override
	public void onDisable(){
		
	}
}
