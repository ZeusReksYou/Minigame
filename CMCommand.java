package net.ZeusReksYou_.CustomMinigame.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.ZeusReksYou_.CustomMinigame.MessageManager;
import net.ZeusReksYou_.CustomMinigame.Commands.Subcommands.CreateAreaCommand;
import net.ZeusReksYou_.CustomMinigame.Commands.Subcommands.ReloadConfigCommand;
import net.ZeusReksYou_.CustomMinigame.Commands.Subcommands.StartCommand;
import net.ZeusReksYou_.CustomMinigame.MessageManager.MessageType;

public class CMCommand extends MainCommand {

	MessageManager m = MessageManager.getInstance();

	public CMCommand() {
		super("cm", true);
		super.addSubCommand(new StartCommand()).addSubCommand(new CreateAreaCommand())
				.addSubCommand(new ReloadConfigCommand());

	}

	// @Override
	public void onCommand(CommandSender sender, String label, String[] args) {
		Player p = (Player) sender;
		m.msg(p, MessageType.Explanation, new String[] { "A help page of the plugin CustomMinigame:" });
		m.msg(p, MessageType.Explanation, new String[] { "/cm reload | reload the configuration" });
		m.msg(p, MessageType.Explanation, new String[] { "/cm create | create an area" });
		m.msg(p, MessageType.Explanation, new String[] { "/cm delete | delete an area" });
		return;
	}

}
