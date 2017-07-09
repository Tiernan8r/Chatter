package me.Tiernanator.Chatter.Chat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Tiernanator.Chatter.ChatterMain;
import me.Tiernanator.Colours.MessageColourer;
import me.Tiernanator.Factions.Factions.Faction;
import me.Tiernanator.Factions.Factions.FactionAccessor;
import me.Tiernanator.Permissions.Group.Group;
import me.Tiernanator.Permissions.Group.GroupAccessor;

public class PlayerChat implements Listener {

	public PlayerChat(ChatterMain main) {
	}

	// Handles player chatting, giving them coloured messages from colour codes and displays their faction & group.
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {

		// get player's sent message
		String message = event.getMessage();

		//parse any colour codes present in the message, it defaults to a white message if there aren't any
		String formattedMessage = MessageColourer.parseMessage(message, ChatColor.WHITE);
		// replace the original message with the formatted one
		event.setMessage(formattedMessage);

		//get the player
		Player player = event.getPlayer();

		//get the player's group
		GroupAccessor groupAccessor = new GroupAccessor(player);
		Group playerGroup = groupAccessor.getPlayerGroup();
//		Group playerGroup = Group.getPlayerGroup(player);
		//get the group's suffix and prefix, also parses their colours
		String prefix = MessageColourer.parseMessage(playerGroup.getPrefix(), ChatColor.WHITE);
		String suffix = MessageColourer.parseMessage(playerGroup.getSuffix(), ChatColor.WHITE);
		
		//get the player faction
		FactionAccessor factionAccessor = new FactionAccessor(player);
		Faction playerFaction = factionAccessor.getPlayerFaction();
//		Faction playerFaction = Faction.getPlayerFaction(player);
		String factionPrefix = MessageColourer.parseMessage(playerFaction.getPrefix(), ChatColor.WHITE);
		String factionSuffix = MessageColourer.parseMessage(playerFaction.getSuffix(), ChatColor.WHITE);
		//get the player faction's unique colour
		ChatColor factionColour = playerFaction.chatColour();
		
		//set the format of the message with all the above factors
		event.setFormat(prefix + suffix + factionPrefix + playerFaction.getName() + factionSuffix
				+ ChatColor.RESET + " %s " + factionColour + ":"
				+ ChatColor.RESET + " %s");
		
//		EntityPlayer entityPlayer = ((CraftPlayer) player).getHandle();
//		PacketPlayOutMount packet = new PacketPlayOutMount(entityPlayer);
//		Packet.sendPacket(player, packet);
//		
//		PlayerTag playerTag = PlayerTag.getPlayerTag(player);
//		if(playerTag == null) {
//			return;
//		}
//		playerTag.setTagMessage(formattedMessage, 8);

	}
}
