package net.ZeusReksYou_.CustomMinigame.Commands.Subcommands;

import org.bukkit.command.CommandSender;

import net.ZeusReksYou_.CustomMinigame.CustomMinigame;
import net.ZeusReksYou_.CustomMinigame.MessageManager;
import net.ZeusReksYou_.CustomMinigame.Commands.SubCommand;
import net.ZeusReksYou_.CustomMinigame.MessageManager.MessageType;

public class StartCommand extends SubCommand {

	private int number = 11;
	private boolean started = false;

	public StartCommand() {
		super("start");
		super.addAlias("startgame");
	}

	MessageManager mm = MessageManager.getInstance();

	@SuppressWarnings("deprecation")
	@Override
	public void onCommand(CommandSender sender, String label, String[] args) {
		setCount(11);
		CustomMinigame.getPlugin().getServer().getScheduler().scheduleAsyncRepeatingTask(CustomMinigame.getPlugin(),
				new Runnable() {

					public void run() {
						number--;
						if (number == 10 || number == 9 || number == 8 || number == 7 || number == 6 || number == 5
								|| number == 4 || number == 3 || number == 2 || number == 1) {

							// This will happen:
							//
							//
							mm.broadcast(MessageType.Good,
									new String[] { "The game will start in §c" + number + "§a seconds!" });
						}
						if (number == 0) {
							mm.broadcast(MessageType.Good, new String[] { "The game starts now!" });
							setStarted(true);
							setCount(-1);
							return;
						}
					}

				}, 0L, 20L);
		return;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public int isCounting() {
		return number;
	}

	public void setCount(int number) {
		this.number = number;
	}

}
