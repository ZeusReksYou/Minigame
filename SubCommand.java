package net.ZeusReksYou_.CustomMinigame.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

public abstract class SubCommand {

	private final String name;
	private final List<String> aliases = new ArrayList<>();

	public SubCommand(String name) {
		this.name = name.toLowerCase();
	}

	public final SubCommand addAlias(String alias) {
		aliases.add(alias.toLowerCase());
		return this;
	}

	public final String getName() {
		return name;
	}

	public final List<String> getAliases() {
		return aliases;
	}

	public final String substitue(String alias) {
		alias = alias.toLowerCase();
		if (alias.equals(name) || alias.contains(alias)) {
			return name;
		}

		return null;
	}

	public abstract void onCommand(CommandSender sender, String label, String[] args);

}
