package net.ZeusReksYou_.CustomMinigame.Commands.Subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.ZeusReksYou_.CustomMinigame.MessageManager;
import net.ZeusReksYou_.CustomMinigame.SettingsManager;
import net.ZeusReksYou_.CustomMinigame.Commands.SubCommand;
import net.ZeusReksYou_.CustomMinigame.MessageManager.MessageType;

public class ReloadConfigCommand extends SubCommand {

	MessageManager mi = MessageManager.getInstance();

	ConsoleCommandSender c;

	public ReloadConfigCommand() {
		super("reload");
		super.addAlias("rl").addAlias("rlconfig");
	}

	@Override
	public void onCommand(CommandSender sender, String label, String[] args) {
		c = Bukkit.getConsoleSender();
		Player p = (Player) sender;
		SettingsManager.getInstance().reloadConfig();
		mi.msg(p, MessageType.Good, new String[] { "You succesfully reloaded the configuration!" });
		mi.msg(p, MessageType.Good, new String[] {
				"Make sure to know that this feature isn't tested completely and may not work properly" });
		mi.msg(c, MessageType.Good, new String[] { p.getName() + " reloaded the configuration" });
		return;
	}

}
