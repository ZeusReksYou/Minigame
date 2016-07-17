package net.ZeusReksYou_.CustomMinigame.Commands.Subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.ZeusReksYou_.CustomMinigame.AreaManager;
import net.ZeusReksYou_.CustomMinigame.MessageManager;
import net.ZeusReksYou_.CustomMinigame.Commands.SubCommand;
import net.ZeusReksYou_.CustomMinigame.MessageManager.MessageType;

public class CreateAreaCommand extends SubCommand {

	FileConfiguration am = AreaManager.getInstance().getAreas();
	MessageManager mm = MessageManager.getInstance();

	private int id = 0;

	public CreateAreaCommand() {
		super("create");
		super.addAlias("acreate");
	}

	@Override
	public void onCommand(CommandSender sender, String label, String[] args) {
		Player p = (Player) sender;
		id = am.getInt("Areas.id" + id) + 1;
		am.set("Areas.", id);
		mm.msg(p, MessageType.Good, new String[] { "You create area " + id });
		return;
	}

}
