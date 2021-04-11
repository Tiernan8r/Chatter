package me.Tiernanator.Chatter.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.Tiernanator.Chatter.ChatterMain;
import me.Tiernanator.Utilities.Colours.Colour;

public class ListColourCodes implements CommandExecutor {

	public ListColourCodes(ChatterMain main) {
	}

	// a long list that shows all available colour codes to the player when they
	// call the command
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		// get the two colours used by all plugins from the Colour enumerator
		ChatColor good = Colour.ALTERNATE_GOOD.getColour();
		ChatColor highlight = Colour.ALTERNATE_HIGHLIGHT.getColour();
		
		sender.sendMessage(good + "The colour codes are:");
		sender.sendMessage(highlight + " - " + "&0" + good + " : " + ChatColor.BLACK + "Black" + ChatColor.WHITE + " (Black)");
		sender.sendMessage(highlight + " - " + "&1" + good + " : " + ChatColor.DARK_BLUE + "Dark Blue");
		sender.sendMessage(highlight + " - " + "&2" + good + " : " + ChatColor.DARK_GREEN + "Dark Green");
		sender.sendMessage(highlight + " - " + "&3" + good + " : " + ChatColor.DARK_AQUA + "Dark Aqua");
		sender.sendMessage(highlight + " - " + "&4" + good + " : " + ChatColor.DARK_RED + "Dark Red");
		sender.sendMessage(highlight + " - " + "&5" + good + " : " + ChatColor.DARK_PURPLE + "Dark Purple");
		sender.sendMessage(highlight + " - " + "&6" + good + " : " + ChatColor.GOLD + "Gold");
		sender.sendMessage(highlight + " - " + "&7" + good + " : " + ChatColor.GRAY + "Grey");
		sender.sendMessage(highlight + " - " + "&8" + good + " : " + ChatColor.DARK_GRAY + "Dark Grey");
		sender.sendMessage(highlight + " - " + "&9" + good + " : " + ChatColor.BLUE + "Blue");
		sender.sendMessage(highlight + " - " + "&A" + good + " : " + ChatColor.GREEN + "Green");
		sender.sendMessage(highlight + " - " + "&B" + good + " : " + ChatColor.AQUA + "Aqua");
		sender.sendMessage(highlight + " - " + "&C" + good + " : " + ChatColor.RED + "Red");
		sender.sendMessage(highlight + " - " + "&D" + good + " : " + ChatColor.LIGHT_PURPLE + "Light Purple");
		sender.sendMessage(highlight + " - " + "&E" + good + " : " + ChatColor.YELLOW + "Yellow");
		sender.sendMessage(highlight + " - " + "&F" + good + " : " + ChatColor.WHITE + "White");
		sender.sendMessage(good + "The following can be paired with colours:");
		sender.sendMessage(highlight + " - " + "&K" + good + " : " + ChatColor.WHITE + ChatColor.MAGIC + "Magic" + ChatColor.WHITE + " (Magic)");
		sender.sendMessage(highlight + " - " + "&L" + good + " : " + ChatColor.WHITE + ChatColor.BOLD + "Bold");
		sender.sendMessage(highlight + " - " + "&M" + good + " : " + ChatColor.WHITE + ChatColor.STRIKETHROUGH + "Strike-Through");
		sender.sendMessage(highlight + " - " + "&N" + good + " : " + ChatColor.WHITE + ChatColor.UNDERLINE + "Underline");
		sender.sendMessage(highlight + " - " + "&O" + good + " : " + ChatColor.WHITE + ChatColor.ITALIC + "Italic");
		sender.sendMessage(highlight + " - " + "&R" + good + " : " + ChatColor.RESET + "Reset (Clears Other Values)");
		
				
		return false;
		
	}

}
