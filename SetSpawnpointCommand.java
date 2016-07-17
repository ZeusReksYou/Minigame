package net.ZeusReksYou_.CustomMinigame.Commands.Subcommands;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.ZeusReksYou_.CustomMinigame.AreaManager;
import net.ZeusReksYou_.CustomMinigame.MessageManager;
import net.ZeusReksYou_.CustomMinigame.Commands.SubCommand;
import net.ZeusReksYou_.CustomMinigame.MessageManager.MessageType;

public class SetSpawnpointCommand extends SubCommand {

	MessageManager mi = MessageManager.getInstance();
	FileConfiguration am = AreaManager.getInstance().getAreas();

	public SetSpawnpointCommand() {
		super("setspawnpoint");
		super.addAlias("spp");
	}

	@Override
	public void onCommand(CommandSender sender, String label, String[] args) {
		Player p = (Player) sender;
		Location loc = p.getLocation();

		am.set("Area.id.Spawnpoint.X", loc.getX());
		am.set("Area.id.Spawnpoint.Y", loc.getY());
		am.set("Area.id.Spawnpoint.Z", loc.getZ());
		am.set("Area.id.Spawnpoint.pitch", loc.getPitch());
		am.set("Area.id.Spawnpoint.yaw", loc.getYaw());

		mi.msg(p, MessageType.Good, new String[] { "You succesfully created a spawnpoint!" });
		return;
	}

}
