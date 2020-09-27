package Mathematician.commands.subcommands;

import org.bukkit.entity.Player;

public interface SubCommand {

    boolean onSubCommand(Player player, String[] args);

}

