package net.ZeusReksYou_.CustomMinigame.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.ZeusReksYou_.CustomMinigame.MessageManager;
import net.ZeusReksYou_.CustomMinigame.MessageManager.MessageType;

public abstract class MainCommand implements CommandExecutor {

	private final String command;
	private final boolean player;
	private final List<SubCommand> subCommands = new ArrayList<>();

	MessageManager mm = MessageManager.getInstance();

	public MainCommand(String command, boolean player) {
		this.command = command;
		this.player = player;
	}

	public MainCommand addSubCommand(SubCommand subCommand) {
		subCommands.add(subCommand);
		return this;
	}

	@Override
	public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (player) {
			if (!(sender instanceof Player)) {
				mm.msg(sender, MessageType.Bad, new String[] { "Only players can use this command!" });
				return true;
			}

		}

		if (!sender.hasPermission("cm.help")) {
			mm.msg(sender, MessageType.Bad, new String[] { "You are not allowed to use this command!" });
			mm.msg(sender, MessageType.Bad, new String[] { "If this is an error, contact the server admins." });
			return true;
		}

		if (args.length > 0) {
			for (SubCommand subCommand : subCommands) {
				if (subCommand.substitue(args[0]) != null) {
					subCommand.onCommand(sender, label, args);
					return true;
				}
			}
		}
		onCommand(sender, label, args);
		return true;
	}

	public abstract void onCommand(CommandSender sender, String label, String[] args);

	public final String getCommand() {
		return command;
	}

}
