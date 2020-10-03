package Mathematician.commands.subcommands;

import Mathematician.warps.WarpManager;
import org.bukkit.entity.Player;

public class GoToWarpCommand implements SubCommand{

    public boolean onSubCommand(Player player, String[] args){
        if (args.length > 1) {
            WarpManager.getInstance().teleportToWarp(player, args[1]);
            return true;
        }
        return false;
    }
}
