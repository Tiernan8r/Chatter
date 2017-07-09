package me.Tiernanator.Chatter.Event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.Tiernanator.Chatter.ChatterMain;
import me.Tiernanator.Colours.MessageColourer;
import me.Tiernanator.Factions.Factions.Faction;
import me.Tiernanator.Factions.Factions.FactionAccessor;
import me.Tiernanator.Permissions.Group.Group;
import me.Tiernanator.Permissions.Group.GroupAccessor;

public class PlayerServerJoinAndExitMessage implements Listener {

	public PlayerServerJoinAndExitMessage(ChatterMain main) {
	}

	//An event handler that shows the player's faction and group when they log in.
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {

		// get the player
		Player player = event.getPlayer();
		
		//get the player's group
		GroupAccessor groupAccessor = new GroupAccessor(player);
		Group playerGroup = groupAccessor.getPlayerGroup();
//		Group playerGroup = Group.getPlayerGroup(player);
		//get the players prefix from their group: it has a colour code so must be interpreted with the colour 
		//defaulting to white
		String prefix = MessageColourer.parseMessage(playerGroup.getPrefix(), ChatColor.WHITE);
		// same with suffix
		String suffix = MessageColourer.parseMessage(playerGroup.getSuffix(), ChatColor.WHITE);
		
		//get the faction
		FactionAccessor factionAccessor = new FactionAccessor(player);
		Faction playerFaction = factionAccessor.getPlayerFaction();
//		Faction playerFaction = Faction.getPlayerFaction(player);
		String factionPrefix = MessageColourer.parseMessage(playerFaction.getPrefix(), ChatColor.WHITE);
		String factionSuffix = MessageColourer.parseMessage(playerFaction.getSuffix(), ChatColor.WHITE);
		//get the faction's specific colour
//		ChatColor factionColour = playerFaction.chatColour();
		//combine all factors
		String joinMessage = prefix + suffix + factionPrefix + playerFaction.getName() + factionSuffix
				+ ChatColor.YELLOW + " " + player.getName() + " joined the game.";
		//set the message
		event.setJoinMessage(joinMessage);

	}
	
	//same but for when the player leaves the server
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {

		Player player = event.getPlayer();

		GroupAccessor groupAccessor = new GroupAccessor(player);
		Group playerGroup = groupAccessor.getPlayerGroup();
//		Group playerGroup = Group.getPlayerGroup(player);
		String prefix = MessageColourer.parseMessage(playerGroup.getPrefix(), ChatColor.WHITE);
		String suffix = MessageColourer.parseMessage(playerGroup.getSuffix(), ChatColor.WHITE);
		
		FactionAccessor factionAccessor = new FactionAccessor(player);
		Faction playerFaction = factionAccessor.getPlayerFaction();
//		Faction playerFaction = Faction.getPlayerFaction(player);

		String factionPrefix = MessageColourer.parseMessage(playerFaction.getPrefix(), ChatColor.WHITE);
		String factionSuffix = MessageColourer.parseMessage(playerFaction.getSuffix(), ChatColor.WHITE);
		
//		ChatColor factionColour = playerFaction.chatColour();
		
		String quitMessage = prefix + suffix + factionPrefix + playerFaction.getName() + factionSuffix
				+ ChatColor.YELLOW + " " + player.getName() + " left the game.";
		event.setQuitMessage(quitMessage);
		
	}
}
