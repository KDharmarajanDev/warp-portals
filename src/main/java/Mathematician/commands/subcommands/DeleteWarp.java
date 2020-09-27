package Mathematician.commands.subcommands;

import Mathematician.WarpPortalsMain;
import Mathematician.warps.WarpManager;
import org.bukkit.entity.Player;

public class DeleteWarp implements SubCommand{

    public boolean onSubCommand(Player player, String[] args){
        if (args.length > 1) {
            if (WarpManager.getInstance().removeWarp(args[1])){
                WarpPortalsMain.getInstance().sendMessageToPlayer(player, "Successfully deleted " + args[1] + ".");
            } else {
                WarpPortalsMain.getInstance().sendMessageToPlayer(player, "Unable to delete " + args[1] + ".");
            }
            return true;
        }
        return false;
    }

}
