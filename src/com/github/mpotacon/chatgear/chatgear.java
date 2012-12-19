package com.github.mpotacon.chatgear;

//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//import ru.tehkode.permissions.PermissionUser;
//import ru.tehkode.permissions.bukkit.PermissionsEx;

public final class chatgear extends JavaPlugin {
	public static chatgear plugin;
	public final chatListener cl = new chatListener();
	
	@Override
	public void onEnable(){
		getCommand("tell").setExecutor(new tellCommand());
		getCommand("ping").setExecutor(new pingCommand());
		getCommand("mute").setExecutor(new muteCommand());
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.cl, this);
	}
	
	@Override
	public void onDisable(){
	}
	

}
