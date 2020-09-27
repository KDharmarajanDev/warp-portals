package Mathematician.commands.subcommands;

import Mathematician.WarpPortalsMain;
import Mathematician.warps.Warp;
import Mathematician.warps.WarpManager;
import org.bukkit.entity.Player;

public class SetWarpCommand implements SubCommand{

    public boolean onSubCommand(Player player, String[] args){
        if (args.length > 1) {
            WarpManager.getInstance().addWarp(args[1],new Warp(player.getLocation()));
            WarpPortalsMain.getInstance().sendMessageToPlayer(player,"Successfully added warp " + args[1] + ".");
            return true;
        }
        return false;
    }

}
