package net.ZeusReksYou_.CustomMinigame.Commands;

import net.ZeusReksYou_.CustomMinigame.CustomMinigame;

public class CommandManager {

	public final CustomMinigame plugin;

	public CommandManager(CustomMinigame plugin) {
		this.plugin = plugin;
	}

	public void setupCommands(MainCommand maincmd) {
		plugin.getCommand(maincmd.getCommand()).setExecutor(maincmd);

	}

}
