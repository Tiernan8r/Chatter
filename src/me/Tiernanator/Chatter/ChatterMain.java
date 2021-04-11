package me.Tiernanator.Chatter;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Tiernanator.Chatter.Chat.PlayerChat;
import me.Tiernanator.Chatter.Command.ListColourCodes;
import me.Tiernanator.Chatter.Event.PlayerServerJoinAndExitMessage;

public class ChatterMain extends JavaPlugin {
	
	//initialise the event and command handlers when the plugin is loaded.
	@Override
	public void onEnable() {
		registerEvents();
		registerCommands();
	}

	@Override
	public void onDisable() {
	}

	// initialise the player Chat event handler and the player join and exit server messenger.
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerChat(this), this);
		pm.registerEvents(new PlayerServerJoinAndExitMessage(this), this);
	}
	
	//initialise the command:
	public void registerCommands() {

		getCommand("colourCodes").setExecutor(new ListColourCodes(this));
		
	}
	
}
